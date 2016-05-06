package com.company;
import java.security.*;
import java.io.*;
/**
 * Created by Lolo on 15/04/2016.
 *
 * This class is a command to encrypt a file
 */
public class FileEncrypter {
    private File file;

    public FileEncrypter(File file) {
        this.file = file;
    }

    public FileEncrypter(String name){
        file = new File(name);
    }

    //return file encrypted
    public File getEncryptFile(){
        return null;
    }

    public byte[] getBytesOfFile(){

        try {
            FileInputStream ifile = new FileInputStream(file);
            byte[] bytes = new byte[(int)file.length()];
            ifile.read(bytes,0,(int)file.length());
            return bytes;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
