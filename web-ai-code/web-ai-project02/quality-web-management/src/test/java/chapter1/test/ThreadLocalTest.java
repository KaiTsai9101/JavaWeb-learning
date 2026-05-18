package chapter1.test;

public class ThreadLocalTest {

    private static ThreadLocal<String> local = new ThreadLocal<>();
    public static void main(String[] args) {
        local.set("Main Message");

        new Thread(() -> {
            System.out.println(Thread.currentThread() + " : " + local.get());
        }).start();

        System.out.println(Thread.currentThread() + " : " + local.get());

        local.remove();

        System.out.println(Thread.currentThread() + " : " + local.get());

    }
}
