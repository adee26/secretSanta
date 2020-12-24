package com.adelinasprojects.secretSanta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecretSantaApplication {

	public static void main(String[] args) { SpringApplication.run(SecretSantaApplication.class, args);
		//ApplicationContext applicationContext =;
//		SecretSantaService secretSantaService = (SecretSantaService) applicationContext.getBean("secretSantaService");
//		Map<Person, Person> personPersonMap = secretSantaService.assignSecretSanta();
//		for(Map.Entry<Person, Person> entry : personPersonMap.entrySet()){
//			System.out.println(entry.getKey().getName() + " " + entry.getValue().getName() + "\n");
//		}
	}

}
