package com.fbtw.io;

import java.io.*;
import java.util.Scanner;

public class PreSetLoader {
    // private Scanner reader;
    private ObjectInputStream objectInputStream;
    private FileInputStream in;

    private ObjectOutputStream objectOutputStream;
    private FileOutputStream out;

    public PreSet readPreSet(String path) throws IOException, ClassNotFoundException {
        in = new FileInputStream(path);
        objectInputStream = new ObjectInputStream(in);

        PreSet preSet = (PreSet)objectInputStream.readObject();

        objectInputStream.close();
        in.close();

        return preSet;

    }

    public void printPreSet(String path, PreSet preSet) throws IOException {
        out = new FileOutputStream(path);
        objectOutputStream = new ObjectOutputStream(out);

        objectOutputStream.writeObject(preSet);

        objectOutputStream.close();
        out.close();
    }

}
