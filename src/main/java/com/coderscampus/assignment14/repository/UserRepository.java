package com.coderscampus.assignment14.repository;


import com.coderscampus.assignment14.domain.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {
    private Map<Long, User> users = new HashMap<>();

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public User getUser(Long id) {
        return users.get(id);
    }

    public boolean userExists(Long id) {
        return users.containsKey(id);
    }


}
