package com.alerouge.demo.io;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class IoDemo {
    private static final String FILE_NAME = "src/test/resources/fileToCreate.txt";

    public static void main(String[] args) throws IOException {
//        writeUsingBufferedWriter();
        writeUsingNio();
    }

    private static void writeUsingBufferedWriter() throws IOException {
        String content = "Hello";
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("demo.txt"));
        bufferedWriter.write(content);
        bufferedWriter.close();
    }

    private static void writeUsingNio() throws IOException {
//        String content = "Hello";
        Path path = Paths.get("demo2.txt");
//        byte[] strToBytes = content.getBytes();
//        Files.write(path, strToBytes);

        List<String> contentRead = Files.readAllLines(path);
        contentRead.forEach(System.out::println);

    }
}
