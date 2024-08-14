package org.factoriaf5.zootopia.facades.encryptations;

import java.util.Base64;

import org.factoriaf5.zootopia.implementations.IEncoder;
import org.springframework.stereotype.Component;

    @Component
    public class Base64Encoder implements IEncoder {
        @Override
        public String encode(String data) {
            return Base64.getEncoder().encodeToString(data.getBytes());
        }
    
        public String decode(String data) {
            byte[] decodedBytes = Base64.getDecoder().decode(data);
            return new String(decodedBytes);
        }
    }