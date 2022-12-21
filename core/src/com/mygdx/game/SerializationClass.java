package com.mygdx.game;

import java.io.*;

public class SerializationClass {

//    public static void main(String[] args) throws IOException, ClassNotFoundException {
//
//        BattleArena game1 = new BattleArena();
//
//
//        writeObjectToFile(tank1, file);
//
//        Battle p = readObjectFromFile(file);
//
//        System.out.println(p);
//
//    }

    public static void writeObjectToFile(Tank obj) throws IOException {
//        File file = new File("battle.bin");
        ObjectOutputStream oos  = null;
        try {
            FileOutputStream fos = new FileOutputStream("battle.txt");
            oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.flush();
        }
        catch (IOException e) {
            e.printStackTrace();    }
        finally {
            oos.close();
        }

    }
    public static BattleArena readObjectFromFile(File file) throws IOException, ClassNotFoundException {
        BattleArena result = null;
        try (FileInputStream fis = new FileInputStream(file);
             ObjectInputStream ois = new ObjectInputStream(fis)) {
            result = (BattleArena) ois.readObject();
        }
        return result;
    }

}