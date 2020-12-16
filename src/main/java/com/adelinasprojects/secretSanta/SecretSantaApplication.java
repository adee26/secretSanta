package com.adelinasprojects.secretSanta;

import com.adelinasprojects.secretSanta.entities.Person;
import com.adelinasprojects.secretSanta.services.SecretSantaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Map;

@SpringBootApplication
public class SecretSantaApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SecretSantaApplication.class, args);
		SecretSantaService secretSantaService = (SecretSantaService) applicationContext.getBean("secretSantaService");
		Map<Person, Person> personPersonMap = secretSantaService.assignSecretSanta();
		for(Map.Entry<Person, Person> entry : personPersonMap.entrySet()){
			System.out.println(entry.getKey().getName() + " " + entry.getValue().getName() + "\n");
		}
	}

}
