package com.company;

public class Main {

    public static void main(String[] args) {
        PasswordManager pm = new PasswordManager();
        // lire l'option de la commande
        /*
        Some Example
        encryption  -e filename     password
        decryption  -d filename.enc password
        checking    -c
        */
        // lire le nom du fichier
        // lire le mot de passe
        String passwordInput =args[0];
        // check si ça match
        boolean res = pm.checkPassword(passwordInput);
        System.out.println("Result: "+res);


    }
}
