package chapter1.test;

import jakarta.servlet.annotation.WebFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class QualityWebManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(QualityWebManagementApplication.class, args);
    }

}