package com.company.project.helpers;

import static com.sun.org.apache.bcel.internal.util.SecuritySupport.getResourceAsStream;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileHelper {
    private static final String INPUT_FILE_NAME = "input.txt";
    private static final String OUTPUT_FILE_NAME = "output.txt";

    private FileHelper() {
    }

    public static InputStream getInput(String[] args) {
        if (args.length == 0) {
            return getResourceAsStream(INPUT_FILE_NAME);
        } else {
            // TODO
        }
        return null;
    }

    public static OutputStream getOutput(String[] args) throws IOException {
        if (args.length == 0) {
            File file = new File(OUTPUT_FILE_NAME);
            file.createNewFile();
            return new FileOutputStream(OUTPUT_FILE_NAME);
        } else {
            // TODO
        }
        return null;
    }
}
