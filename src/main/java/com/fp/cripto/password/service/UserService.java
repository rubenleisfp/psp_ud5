package com.fp.cripto.password.service;

import com.fp.cripto.password.repository.User;
import com.fp.cripto.password.repository.UserDao;


public class UserService {

    private UserDao userDao;
    private CifradoService cifradoService;


    public UserService(UserDao userDao, CifradoService cifradoService) {
        this.userDao = userDao;
        this.cifradoService = cifradoService;

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
        return  cifradoService.checkPassword(inputPassword, user.getPassword());
    }


}
