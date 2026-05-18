package chapter1.test;

import org.junit.jupiter.api.Test;

import java.util.UUID;

public class UUIDTest {
    @Test
    public void test1() {
        for (int i = 0; i < 1000; i++) {
            System.out.println(UUID.randomUUID().toString());
        }
    }
}
