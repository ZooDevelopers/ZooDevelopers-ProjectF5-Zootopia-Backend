package org.factoriaf5.zootopia.services;



import java.util.List;

import org.factoriaf5.zootopia.models.Role;
import org.factoriaf5.zootopia.models.User;


import org.factoriaf5.zootopia.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

   private UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> getAll() {
        List<User> users = repository.findAll();
        return users;
    }

    public Role getById(long l) {
        throw new UnsupportedOperationException("Unimplemented method 'getById'");
    }

}