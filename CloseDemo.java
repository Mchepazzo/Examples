package ru.stc;

public class CloseDemo {
    public static void main(String[] args) {

        try (TestClose t = new TestClose()) {

            System.out.println("внутри try-with-resources");
            throw new Exception("Суровый эксепшн");

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("конец");
    }
}
class TestClose implements AutoCloseable {

    @Override
    public void close() throws Exception {
        System.out.println("Идет закрытие...");
        throw new Exception("Эксепшн при закрытии");
    }
}