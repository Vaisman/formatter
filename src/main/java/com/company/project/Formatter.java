package com.company.project;

import java.io.InputStream;
import java.io.OutputStream;

import com.company.project.helpers.FileHelper;

public class Formatter {

    public static void main(String[] args) throws Exception {
        System.out.println("Start formatting...");

        try {
            InputStream inputStream = FileHelper.getInput(args);
            OutputStream outputStream = FileHelper.getOutput(args);

            FormatterEngine formatterEngine = new FormatterEngine();
            formatterEngine.formatFile(inputStream, outputStream);

        } catch (Exception e) {
            System.err.println("Formatting failed." + e.getMessage());
        }

        System.out.println("Formatting finished successfully.");
    }
}
