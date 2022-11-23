package com.alerouge.demo.regex;

import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import java.io.File;
import java.io.IOException;
import java.io.StringWriter;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindMatches {

    //    private static final String fileName = "/home/arossi/Desktop/catturaSpark/segnalazioni/exchange/altriXml/test/test";
    private static final String fileName = "/home/arossi/Desktop/catturaSpark/segnalazioni/exchange/altriXml/xmlConStatusExchanged";

    private static final String directory = "/home/arossi/Desktop/catturaSpark/segnalazioni/exchange/altriXml/xml";
    private static final String directoryPretty = "/home/arossi/Desktop/catturaSpark/segnalazioni/exchange/altriXml/xmlFormatted";

    public static void main(String[] args) throws IOException {

//        String fileContent = readFileContent(fileName);
//        System.out.println("fileContent = " + fileContent);

        // find file names
//        findMatches(fileContent);

        // pretty all files
        prettyFiles();

    }

    private static void prettyFiles() throws IOException {
        List<String> files = listFilesUsingDirectoryStream(directory);
        for (String file : files) {
            String content = readFileContent(directory + File.separator +  file);
            String contentPretty = prettyContent(content);

            File fileFormatted = new File(directoryPretty + File.separator + file);
            // write file
            Files.writeString(Paths.get(fileFormatted.toURI()), contentPretty);
        }
    }

    private static String prettyContent(String content) {
        try {
            OutputFormat format = OutputFormat.createPrettyPrint();
            format.setIndentSize(4);
            format.setSuppressDeclaration(true);
            format.setEncoding("UTF-8");

            org.dom4j.Document document = DocumentHelper.parseText(content);
            StringWriter sw = new StringWriter();
            XMLWriter writer = new XMLWriter(sw, format);
            writer.write(document);
            return sw.toString();
        } catch (Exception e) {
            throw new RuntimeException("Error occurs when pretty-printing xml:\n" + content, e);
        }
    }


    public static List<String> listFilesUsingDirectoryStream(String dir) throws IOException {
        List<String> fileList = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get(dir))) {
            for (Path path : stream) {
                if (!Files.isDirectory(path)) {
                    fileList.add(path.getFileName()
                            .toString());
                }
            }
        }
        return fileList;
    }
    
    
    private static List<String> findMatches(String fileContent) {
        final String regex = "2022\\d+\\/.+\\.xml";
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(fileContent);
        List<String> listReturn = new ArrayList<>();
        while (matcher.find()) {
            listReturn.add(matcher.group(0));
            System.out.println(matcher.group(0));
//            for (int i = 1; i <= matcher.groupCount(); i++) {
//                System.out.println("Group " + i + ": " + matcher.group(i));
//            }
        }
        return listReturn;
    }

    private static String readFileContent(String fileName) throws IOException {
        Path path = Paths.get(fileName);
        String fileContent = null;
        try (Stream<String> s = Files.lines(path)) {
            fileContent = s.collect(Collectors.joining("\n"));
        }
        return fileContent;
    }
}
