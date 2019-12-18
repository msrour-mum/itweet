package mum.itweet;

import mum.itweet.config.DataGenerate;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
public class ItweetApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItweetApplication.class, args);

//<<<<<<< HEAD
		//Zein : Use this if you want to fill data at Database
		DataGenerate.Generate();

//=======
		// Zein : Use this if you want to fill data at Database
		// DataGenerate.Generate();
//>>>>>>> master

	}

}