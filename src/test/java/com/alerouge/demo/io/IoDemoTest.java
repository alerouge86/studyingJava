package com.alerouge.demo.io;

//import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertTrue;

class IoDemoTest {

    private final String FILE_NAME = "src/test/resources/fileToCreate.txt";

//    @Test
//    void writeFileUsingBuffered() throws IOException {
//        String content = "Hello";
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FILE_NAME));
//        bufferedWriter.write(content);
//        bufferedWriter.close();
//    }
}