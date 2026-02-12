package com.fp.cripto.password;

import com.fp.cripto.password.repository.UserJdbcDao;
import com.fp.cripto.password.service.UserService;
import com.fp.cripto.password.service.impl.CifradoServiceAES;
import com.fp.cripto.password.service.impl.CifradoServiceHash;


import java.util.Scanner;

public class AppPassword {

    UserService userService = null;

    public static void main(String[] args) {
        AppPassword app = new AppPassword();
        app.cfg();
        app.run();
    }

    private void cfg() {
        userService = new UserService(new UserJdbcDao(), new CifradoServiceHash());
        //userService = new UserService(new UserJdbcDao(), new CifradoServiceAES());
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del usuario: ");
        int userId = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese una contraseña: ");
        String password = scanner.nextLine();

        boolean esPasswordCorrecto = userService.esPasswordCorrecto(userId, password);
        System.out.println("El password es correcto: " + esPasswordCorrecto);
    }
}
