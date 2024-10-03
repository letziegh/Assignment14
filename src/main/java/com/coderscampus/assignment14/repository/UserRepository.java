package com.coderscampus.assignment14.repository;


import com.coderscampus.assignment14.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List users = new ArrayList<>();

    public void addUser(User user) {
        users.add(user);
    }
}
