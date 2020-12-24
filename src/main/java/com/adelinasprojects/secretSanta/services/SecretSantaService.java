package com.adelinasprojects.secretSanta.services;

import com.adelinasprojects.secretSanta.entities.User;
import com.adelinasprojects.secretSanta.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SecretSantaService {
    private final UserRepository userRepository;

    public SecretSantaService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Map<User, User> assignSecretSanta(){
        Map<User, User> secretSantaList = new HashMap<>();
        List<User> userList = userRepository.findAll();
        List<User> randomUserList = userRepository.findAll();
        int count = 0;
        Random random = new Random();

        while (!randomUserList.isEmpty()){
            User randomUser = randomUserList.get(random.nextInt(randomUserList.size()));
            while(userList.get(count).equals(randomUser)){
                randomUser = randomUserList.get(random.nextInt(randomUserList.size()));
            }
            secretSantaList.put(userList.get(count), randomUser);
            randomUserList.remove(randomUser);
            count++;
        }

        return secretSantaList;
    }

    /** TO DO: Set persons in groups **/
}
