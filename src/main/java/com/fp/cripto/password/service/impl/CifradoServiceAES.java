package com.fp.cripto.password.service.impl;

import com.fp.cripto.password.service.CifradoService;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import static javax.crypto.Cipher.ENCRYPT_MODE;

/**
 * Cifrado simetrico con AES
 */
public class CifradoServiceAES implements CifradoService {


    private final String clave = "1983198319831983";

    @Override
    public boolean checkPassword(String inputPassword, String passwordCifrado) {
        Cipher cipher = null;
        try {
            SecretKey secretKey = new SecretKeySpec(clave.getBytes(), "AES");
            cipher = Cipher.getInstance("AES");
            cipher.init(ENCRYPT_MODE, secretKey);
            byte[] inputPasswordCifrado = cipher.doFinal(inputPassword.getBytes());
            String inputPasswordCifradoString = Base64.getEncoder().encodeToString(inputPasswordCifrado);
            return inputPasswordCifradoString.equals(passwordCifrado);

        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | BadPaddingException |
                 IllegalBlockSizeException e) {
            throw new RuntimeException(e);
        }

    }
}
