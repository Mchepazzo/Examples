package ru.stc;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipDemo {
    public static void main(String[] args) {
        String fileName = "test.zip";

        // запись
        try (FileOutputStream fos = new FileOutputStream(fileName);
             ZipOutputStream zos = new ZipOutputStream(fos);
             Writer writer = new OutputStreamWriter(zos);
             BufferedWriter bw = new BufferedWriter(writer)
        ) {

            ZipEntry entry = new ZipEntry("my.txt");
            zos.putNextEntry(entry);

            bw.write("Ля-ля-ля\r\nТра-та-та\r\n");

        } catch (IOException e) {
            e.printStackTrace();
        }

        // чтение
        try (FileInputStream fis = new FileInputStream(fileName);
             ZipInputStream zis = new ZipInputStream(fis);
             Reader reader = new InputStreamReader(zis);
             BufferedReader br = new BufferedReader(reader)
        ) {
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null ) {
                String name = entry.getName();
                long size = entry.getSize();
                System.out.printf("filename: %s, size: %d%n", name, size);

                // распаковка
                //Files.copy(zis, Paths.get(name));
                while (br.ready()) {
                    System.out.println(br.readLine());
                }
                size = entry.getSize();
                System.out.printf("size: %d%n", size);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
