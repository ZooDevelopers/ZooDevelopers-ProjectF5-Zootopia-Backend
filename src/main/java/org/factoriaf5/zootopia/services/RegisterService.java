package org.factoriaf5.zootopia.services;

import java.util.HashSet;
import java.util.Set;

import org.factoriaf5.zootopia.dtos.UserDto;
import org.factoriaf5.zootopia.facades.EncoderFacade;
import org.factoriaf5.zootopia.implementations.IEncryptFacade;
import org.factoriaf5.zootopia.models.Role;
import org.factoriaf5.zootopia.models.User;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.factoriaf5.zootopia.repository.UserRepository;

@Service
public class RegisterService {

    UserService UserService;
    UserRepository repository;
    IEncryptFacade encoderFacade;

    @Autowired
    public RegisterService(UserRepository repository, UserService userService, EncoderFacade encoderFacade) {
        this.repository = repository;
        this.UserService = userService;
        this.encoderFacade = encoderFacade;
    }

    public String save(UserDto newUserDto) {
        try {

        String passwordDecoded = encoderFacade.decode("base64", newUserDto.getPassword());
        String passwordEncoded = encoderFacade.encode("bcrypt",  passwordDecoded);

        User user = new User(newUserDto.getUsername(), passwordEncoded, null);
        user.setRoles(assignDefaultRole());


        repository.save(user);

        return "Success";
    }  catch (Exception e) {
        LoggerFactory.getLogger(RegisterService.class).error("Error al guardar el usuario", e);
        return "Error: " + e.getMessage();
    }
    }

    public Set<Role> assignDefaultRole() {
        Role defaultRole = UserService.getById(1L);

        Set<Role> roles = new HashSet<>();
        roles.add(defaultRole);

        return roles;
    }

}