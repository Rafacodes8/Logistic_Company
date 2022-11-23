package com.example.demo2;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.entities.*;
import com.example.repositories.*;



@SpringBootApplication
public class Demo2Application {

	public static void main(String[] args) {
                Cargo cargo = new Cargo();
                Cargo cargodos = new Cargo();
                System.err.println(cargo.getId());
                System.err.println(cargodos.getId());
                System.out.println("hellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohello");
		SpringApplication.run(Demo2Application.class, args);
	}

}
