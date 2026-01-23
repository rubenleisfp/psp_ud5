package com.fp.cripto.password.service.impl;

import com.fp.cripto.password.service.CifradoService;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public class CifradoServiceHash implements CifradoService {
    @Override
    public boolean checkPassword(String inputPassword, String passwordCifrado) {
        throw new UnsupportedOperationException("A implementar por el estudiante");
    }


}
