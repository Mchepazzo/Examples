package ru.stc;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("text.txt");
             Scanner scanner = new Scanner(fr)
        ){
            scanner.useLocale(Locale.GERMAN);
            while (scanner.hasNext()) {
                if (scanner.hasNextBoolean()) {
                    boolean b = scanner.nextBoolean();
                    System.out.printf("%10s: %b%n", "bool", b);
                } else
                if (scanner.hasNextInt()) {
                    int b = scanner.nextInt();
                    System.out.printf("%10s: %d%n", "int", b);
                } else
                if (scanner.hasNextFloat()) {
                    float b = scanner.nextFloat();
                    System.out.printf("%10s: %f%n", "float", b);
                } else {
                    String b = scanner.next();
                    System.out.printf("%10s: %s%n", "string", b);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
