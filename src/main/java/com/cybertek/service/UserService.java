package com.cybertek.service;

import com.cybertek.model.User;
import com.cybertek.repository.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public User create(User user) throws Exception {
        Optional<User> foundedUser = userRepository.findByUserName(user.getUserName());

        if(foundedUser.isPresent()){

            throw new Exception("This user already exist ");
        }

       return  userRepository.save(user);

    }

    public void update(User user) throws Exception {
        Optional<User> foundedUser = userRepository.findByUserName(user.getUserName());

        if(foundedUser.isEmpty()){

            throw new Exception("There is no user to update");
        }

        user.setId(foundedUser.get().getId());

        userRepository.save(user);

    }

    public User readByUsername(String username){

        return userRepository.findByUserName(username).orElse(null);
    }

    public List<User> readAll(){

        return userRepository.findAll(Sort.by("user_id"));
    }
}
