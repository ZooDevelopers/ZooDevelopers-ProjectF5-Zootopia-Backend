package org.factoriaf5.zootopia.services;

import java.util.HashSet;
import java.util.Set;



import org.factoriaf5.zootopia.models.Role;
import org.factoriaf5.zootopia.models.User;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    org.factoriaf5.zootopia.repository.UserRepository repository;
    UserService UserService;
    IEncryptFacade encoderFacade;

    public RegisterService(org.factoriaf5.zootopia.repository.UserRepository repository, UserService UserService, EncoderFacade encoderFacade) {
        this.repository = repository;
        this.UserService = UserService;
        this.encoderFacade = encoderFacade;
    }

    public String save(UserDto newUserDto) {

        String passwordDecoded = encoderFacade.decode("base64", newUserDto.getPassword());
        String passwordEncoded = encoderFacade.encode("bcrypt",  passwordDecoded);

        User user = new User(newUserDto.getUsername(), passwordEncoded);
        user.setRoles(assignDefaultRole());

        repository.save(user);

        return "Success";
    }

    public Set<Role> assignDefaultRole() {
        Role defaultRole = UserService.getById(1L);

        Set<Role> roles = new HashSet<>();
        roles.add(defaultRole);

        return roles;
    }

}