package ru.mardaganiev;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileCopy {
    public static void main(String[] args) throws IOException {

        //копирование файл-файл
        Path src = Paths.get(".", "hello.txt");
        Path dst = Paths.get(".", "new.txt");
        Files.copy(src, dst);
    }
}
