package com.adelinasprojects.secretSanta.services;

import com.adelinasprojects.secretSanta.entities.Person;
import com.adelinasprojects.secretSanta.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SecretSantaService {
    private final PersonRepository personRepository;

    public SecretSantaService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Map<Person, Person> assignSecretSanta(){
        Map<Person, Person> secretSantaList = new HashMap<>();
        List<Person> personList = personRepository.findAll();
        List<Person> randomPersonList = personRepository.findAll();
        int count = 0;
        Random random = new Random();

        while (!randomPersonList.isEmpty()){
            Person randomPerson = randomPersonList.get(random.nextInt(randomPersonList.size()));
            while(personList.get(count).equals(randomPerson)){
                randomPerson = randomPersonList.get(random.nextInt(randomPersonList.size()));
            }
            secretSantaList.put(personList.get(count), randomPerson);
            randomPersonList.remove(randomPerson);
            count++;
        }

        return secretSantaList;
    }
}
