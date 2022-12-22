package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.entities.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan("com.example.controler")
@SpringBootApplication
public class Demo3Application{
    
    private static Logger LOG = LoggerFactory.getLogger(Demo3Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Demo3Application.class, args);
	}
        
        //@Override
//        public void run(String... args) throws Exception {
//            System.err.println("hola mis amigos");
//            LOG.info("hola mis amigos");
//            LOG.warn("Cuidado mis amigos");
//        }
}


