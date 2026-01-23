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
        throw new UnsupportedOperationException("A implementar por el estudiante");
    }
}
