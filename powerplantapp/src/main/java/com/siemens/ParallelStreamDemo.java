package com.siemens;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ParallelStreamDemo {
    public static void main(String[] args)  {
        Path dirPath= Paths.get("src\\main\\java\\com\\siemens\\models");
        try(Stream<Path>filesPath= Files.list(dirPath)){
            List<String> allLines=filesPath.filter(Files::isRegularFile)
                    .parallel()
                    .flatMap(filePath->{
                        try{
                            return Files.lines(filePath);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }) .collect(Collectors.toList());
            allLines.stream().forEach(System.out::println);


        }catch (IOException exception){

        }

    }
}
