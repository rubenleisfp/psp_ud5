package com.fp.cripto.hash.service;

import com.fp.cripto.hash.repository.User;
import com.fp.cripto.hash.repository.UserDao;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HexFormat;

public class UserService {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public User getUserById(int userId) {
        return userDao.getUserById(userId);
    }

    /**
     * Verifica si la contraseña ingresada coincide con la almacenada en la base de datos
     * para el usuario con el ID especificado.
     *
     * @param userId el ID del usuario
     * @param inputPassword la contraseña ingresada por el usuario
     * @return true si la contraseña es correcta, false en caso contrario
     */
    public boolean esPasswordCorrecto (int userId, String inputPassword) {
        User user = this.getUserById(userId);

        if (user == null) {
            return false;
        }
        String passwordHash = this.hashPassword(inputPassword);
        //System.out.println(passwordHash);
        return passwordHash.equals(user.getPassword());
    }

    /**
     * Hashea la contraseña ingresada utilizando el algoritmo SHA-256 y devuelve el resultado como un texto hexadecimal.
     *
     * @param password la contraseña a hashear
     * @return el hash de la contraseña como un texto hexadecimal
     * @throws RuntimeException si no se puede instanciar el algoritmo SHA-256
     */
    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = md.digest(password.getBytes());
            return HexFormat.of().formatHex(hashBytes); // convierte a texto legible (hex)
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("Algoritmo SHA-256 no disponible", e);
        }
    }
}
