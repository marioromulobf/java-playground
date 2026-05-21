package com.mariofernandes.javapoc.junit.injection;

import org.junit.jupiter.api.MediaType;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestReporter;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;

public class TestReporterTests {
    @Test
    void testReportSingleValue(TestReporter testReporter) {
        testReporter.publishEntry("a status message");
    }

    @Test
    void testReportKeyValuePair(TestReporter testReporter) {
        testReporter.publishEntry("a key", "a value");
    }

    @Test
    void testReportMultipleValuePairs(TestReporter testReporter) {
        var values = new HashMap<String, String>();

        values.put("user name", "mr666");
        values.put("award year", "2020");

        testReporter.publishEntry(values);
    }

    @Test
    void testReportFiles(TestReporter testReporter, @TempDir Path tempDir) throws IOException {
        testReporter.publishFile("test1.txt", MediaType.TEXT_PLAIN_UTF_8,
                file -> Files.write(file, Collections.singletonList("Test 1")));

        Path existingFile = Files.write(tempDir.resolve("test2.txt"), Collections.singletonList("Test 2"));
        testReporter.publishFile(existingFile, MediaType.TEXT_PLAIN_UTF_8);

        testReporter.publishDirectory("test3", dir -> {
            Files.write(dir.resolve("nested1.txt"), Collections.singletonList("Nested content 1"));
            Files.write(dir.resolve("nested2.txt"), Collections.singletonList("Nested content 2"));
        });

        var existingDir = Files.createDirectory(tempDir.resolve("test4"));
        Files.write(existingDir.resolve("nested1.txt"), Collections.singletonList("Nested content 1"));
        Files.write(existingDir.resolve("nested2.txt"), Collections.singletonList("Nested content 2"));
        testReporter.publishDirectory(existingDir);
    }
}
