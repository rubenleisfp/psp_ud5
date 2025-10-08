package com.fp.cripto.hash;

import com.fp.cripto.hash.repository.UserJdbcDao;
import com.fp.cripto.hash.service.UserService;


import java.util.Scanner;

public class AppHash {

    UserService userService = null;

    public static void main(String[] args) {
        AppHash app = new AppHash();
        app.cfg();
        app.run();
    }

    private void cfg() {
        userService = new UserService(new UserJdbcDao());
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
