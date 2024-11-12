package com.siemens.models;

import com.siemens.facades.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public record FileLogger(String message) implements Logger {
    @Override
    public boolean writeToFile() throws IOException {
        Path path= Paths.get("reports/messages.csv");
        Files.writeString(path,message, StandardOpenOption.APPEND);
        return true;
    }
}
