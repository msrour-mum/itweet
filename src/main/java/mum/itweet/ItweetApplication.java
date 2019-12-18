package mum.itweet;

import mum.itweet.config.DataGenerate;
import mum.itweet.model.*;
import mum.itweet.model.lookups.Gender;
import mum.itweet.model.lookups.PostStatus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication()
public class ItweetApplication
{

	public static void main(String[] args) {
		//SpringApplication.run(ItweetApplication.class, args);

		//Zein : Use this if you want to fill data at Database
		DataGenerate.Generate();


	}



}