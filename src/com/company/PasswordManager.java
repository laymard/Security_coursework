package com.company;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.security.*;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Lolo on 15/04/2016.
 */
public class PasswordManager {
    // doit contenir les password hashé

    private byte[]storedPassword=encrypt("test");
    private HashMap<String,byte[]> readPasswords;
    private HashMap<String,byte[]> writePasswords;

    public byte[] getStoredPassword() {
        return storedPassword;
    }

    public PasswordManager() {
    }




    public boolean checkPassword(String input){
        byte[] hashedInput = encrypt(input);
        return Arrays.equals(hashedInput,getStoredPassword());
    }

    public static byte[] encrypt(String x) {
        java.security.MessageDigest d = null;
        try {
            d = MessageDigest.getInstance("SHA-1");
            d.reset();
            d.update(x.getBytes());
            return d.digest();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;

    }
}
