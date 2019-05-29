package ru.stc;

import java.util.Calendar;
import java.util.Date;
import java.util.Formattable;
import java.util.Formatter;

public class FormatDemo {
    public static void main(String[] args) {
        // бинарный формат
        System.out.printf("%b%n", false);
        System.out.printf("%b%n", 8);
        System.out.printf("%b%n", 0);
        System.out.printf("%b%n", -1);
        System.out.printf("%b%n", (Object)null);
        System.out.printf("%b%n", "false");
        System.out.printf("%b%n", new Object());

        // хэш
        System.out.println("-----------------");
        System.out.printf("%h%n", (Object)null);
        System.out.printf("%h%n", 123456);
        System.out.printf("%h%n", 1234567890123L);
        System.out.printf("%h%n", true);
        System.out.printf("%h%n", "222");

        System.out.println("-----------------");
        System.out.printf("%s%n", (Object)null);
        System.out.printf("%s%n", "");
        System.out.printf("%s%n", "!!!");
        System.out.printf("%s%n", new StrObject1());
        System.out.printf("%s%n", new StrObject2());
        System.out.printf("%s%n", new StrObject3());

        System.out.println("-----------------");

        System.out.printf("%d%n", 324);
        int d = 0504;
        System.out.printf("%o%n", d);
        int d2 = 0xff00ff;
        System.out.printf("%x%n", d2);
        int d3 = 0b1011;
        System.out.printf("%x%n", d3);

        System.out.printf("%e%n", 12.50);
        System.out.printf("%f%n", 12.50);
        System.out.printf("%g%n", 12.50);
        System.out.printf("%a%n", 12.50);

        System.out.println("-----------------");
        System.out.printf("[%10.2f]%n", 1223.5);
        System.out.printf("[%-10.2f]%n", 1223.5);
        System.out.printf("[%+10.2f]%n", 1223.5);
        System.out.printf("[%010.2f]%n", 1223.5);
        System.out.printf("[%(10.2f]%n", -1223.5);
        System.out.printf("[%,10.2f]%n", -1223.5);
        System.out.printf("[%0(,12.2f]%n", -1223.5);
        String s = "Hello, World!";
        String hello = "Hello";
        System.out.printf("[%20s]%n", s);
        System.out.printf("[%-20s]%n", s);
        System.out.printf("[%10s]%n", s);
        System.out.printf("[%10s]%n", hello);
        System.out.printf("[%-10s]%n", hello);
        System.out.printf("[%10.10s]%n", s);

        // несколько переменных
        System.out.printf("[%-20s|%10.2f]%n", s, 25435.5);

        // Даты
        System.out.println("-----------------");
        Date date = new Date();
        System.out.printf("[%1$tH:%1$tM]%n", date);

        Calendar calendar = Calendar.getInstance();
        System.out.printf("%tR%n", calendar.getTime());

    }
}

class StrObject1 {
}
class StrObject2 {
    @Override
    public String toString() {
        return "StrObject{}";
    }
}
class StrObject3 implements Formattable {
    @Override
    public void formatTo(Formatter formatter, int flags, int width, int precision) {
        formatter.format("123123");
    }
}