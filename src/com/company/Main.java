package com.company;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.math.BigInteger;
import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;

public class Main {

    public static void main(String[] args) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeySpecException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, IOException {
        //HACK
        // BULLSHIT TO DELETE


        byte[] input = new byte[] { (byte) 0xbe, (byte) 0xef };
        KeyGenerator keyGenerator = KeyGenerator.getInstance("Blowfish");
        keyGenerator.init(128);
        Key blowfishKey = keyGenerator.generateKey();

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(1024);
        KeyPair keyPair = keyPairGenerator.genKeyPair();

        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128);
        SecretKey key = kgen.generateKey();
        byte[] aesKey = key.getEncoded();
        SecretKeySpec aeskeySpec = new SecretKeySpec(aesKey, "AES");

        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        Cipher aesCipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, keyPair.getPublic());
        aesCipher.init(Cipher.ENCRYPT_MODE,aeskeySpec);



        //END OD BULLSHIT
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

        // read the file svs
        FileEncrypter fe = new FileEncrypter("SVS");

        byte[] byteToEncrypt = fe.getBytesOfFile();
        byte[] encryptedbyte = aesCipher.doFinal(byteToEncrypt);

        FileOutputStream out = new FileOutputStream("SVS.enc2");
        out.write(encryptedbyte);
        out.close();


        // encrypt the file SVS

    }
}
