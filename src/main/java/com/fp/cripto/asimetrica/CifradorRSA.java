/**
 * Clase que se encarga de cifrar y descifrar texto utilizando
 * el algoritmo de cifrado asimetrico RSA.
 *
 * @author fperaza
 */
package com.fp.cripto.asimetrica;

import javax.crypto.Cipher;
import java.security.*;
import java.util.Base64;


public class CifradorRSA {

    private final PublicKey clavePublica;
    private final PrivateKey clavePrivada;

    /**
     * Constructor que inicializa el par de claves RSA
     *
     * @throws Exception si ocurre un error al generar el par de claves
     */
    public CifradorRSA() throws Exception {
        KeyPairGenerator generador = KeyPairGenerator.getInstance("RSA");
        generador.initialize(2048);
        // Genera un par de claves RSA, utilizando el generador
        // KeyPairGenerator con el algoritmo RSA y un trama de clave de 2048 bits
        KeyPair parClaves = generador.generateKeyPair();
        this.clavePublica = parClaves.getPublic();
        this.clavePrivada = parClaves.getPrivate();
        System.out.println(clavePrivada);
        System.out.println(clavePublica);
    }

    /**
     * Metodo que cifra un texto utilizando la clave publica
     *
     * @param texto el texto a cifrar
     * @return el texto cifrado
     * @throws Exception si ocurre un error al cifrar
     */
    public String cifrarConPublica(String texto) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, clavePublica);
        byte[] cifrado = cipher.doFinal(texto.getBytes());
        return Base64.getEncoder().encodeToString(cifrado);
    }

    /**
     * Metodo que descifra un texto utilizando la clave privada
     *
     * @param textoCifrado el texto a descifrar
     * @return el texto descifrado
     * @throws Exception si ocurre un error al descifrar
     */
    public String descifrarConPrivada(String textoCifrado) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, clavePrivada);
        byte[] descifrado = cipher.doFinal(Base64.getDecoder().decode(textoCifrado));
        return new String(descifrado);
    }

    /**
     * Metodo principal de prueba
     *
     * @param args los argumentos pasados
     * @throws Exception si ocurre un error
     */
    public static void main(String[] args) throws Exception {
        CifradorRSA rsa = new CifradorRSA();
        String mensaje = "Token de acceso";

        String cifrado = rsa.cifrarConPublica(mensaje);
        String descifrado = rsa.descifrarConPrivada(cifrado);

        System.out.println("Texto original: " + mensaje);
        System.out.println("Texto cifrado: " + cifrado);
        System.out.println("Texto descifrado: " + descifrado);
    }
}