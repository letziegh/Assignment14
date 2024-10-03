package com.coderscampus.assignment14.service;


import com.coderscampus.assignment14.domain.User;
import com.coderscampus.assignment14.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepo;

//    public String save(User user){
//        userRepo.save(user);
//
//        return null;
  //  }

}
