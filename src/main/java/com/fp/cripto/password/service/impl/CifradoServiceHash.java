package com.fp.cripto.password.service.impl;

import com.fp.cripto.password.service.CifradoService;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public class CifradoServiceHash implements CifradoService {
    @Override
    public boolean checkPassword(String inputPassword, String passwordCifrado) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(inputPassword.getBytes());
            String passwordHash = HexFormat.of().formatHex(hashBytes); // convierte a texto legible (hex)
            return passwordHash.equals(passwordCifrado);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Algoritmo SHA-256 no disponible", e);
        }
    }


}
