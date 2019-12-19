package mum.itweet;

import mum.itweet.config.DataGenerate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication()
public class ItweetApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ItweetApplication.class, args);
		// Zein : Use this if you want to fill data at Database
		 //DataGenerate.Generate();

	}

}