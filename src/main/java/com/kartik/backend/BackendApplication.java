package com.kartik.backend;

import com.kartik.backend.beans.TestBean;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }

    @Bean                               // this method we can use anywhere in our application
    public TestBean testBean() {
     TestBean tb = new TestBean();
        tb.name = "Kartik Gour";
        return tb;
    }

    @Bean
    @Scope("singleton")
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
