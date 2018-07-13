package com.insertpunhere1.gl.engine;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class GLUtility {
    static String read(String file) throws IOException {
        byte[] read = Files.readAllBytes(Paths.get(file));

        return new String(read, Charset.forName("UTF-8"));
    }

    static List<String> readLines(String file) throws IOException {
        byte[] read_bytes = Files.readAllBytes(Paths.get(file));

        String read = new String(read_bytes, Charset.forName("UTF-8"));

        List<String> lines = new ArrayList<>();

        Collections.addAll(lines, read.split("\n"));

        return lines;
    }
}
