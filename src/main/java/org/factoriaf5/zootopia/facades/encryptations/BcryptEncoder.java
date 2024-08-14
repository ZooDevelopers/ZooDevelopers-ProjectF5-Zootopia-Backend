package org.factoriaf5.zootopia.facades.encryptations;

import org.factoriaf5.zootopia.implementations.IEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class BcryptEncoder implements IEncoder {
    private final BCryptPasswordEncoder encoder;

    @Autowired
    public BcryptEncoder(BCryptPasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public String encode(String data) {
        return encoder.encode(data);
    }
}



