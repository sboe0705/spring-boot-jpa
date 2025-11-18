package io.github.sboe0705.sample.jpa.dev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class JpaSampleApplicationWithTestdata {

    public static void main(String[] args) {
        new SpringApplicationBuilder(JpaSampleApplicationWithTestdata.class)
                .profiles("testdata")
                .run(args);
    }

}
