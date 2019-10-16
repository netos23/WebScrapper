package com.fbtw.io;

import com.fbtw.book_utils.TablePatern;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class TablePaternLoader {
    private Scanner in;
    private PrintWriter out;

    public TablePatern[] load(String path) throws FileNotFoundException {
        in = new Scanner(new File(path));

        int N = in.nextInt();
        in.nextLine();
        TablePatern[] paterns = new TablePatern[N];
        int count = 0;
        int[] inits = new int[4];
        String tmp = "";


        for (int i = 0; i < N * 5; i++) {
            if(count==0){
                tmp = in.nextLine();
                count++;
            }else if(count==4){
                inits[count-1]= in.nextInt();

                paterns[(i+1)/5-1] = new TablePatern(tmp, inits);
                if(in.hasNextLine())
                in.nextLine();
                inits = new int[4];
                count=0;
            }else {
                inits[count-1]= in.nextInt();
                count++;
            }

        }


        return paterns;

    }

    public void print(String path, TablePatern[] patern) {
        //todo поддержка сохранения шаблонов таблиц
    }
}
