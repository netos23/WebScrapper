package com.fbtw;


import com.fbtw.book_utils.TableBuilder;
import com.fbtw.book_utils.TablePatern;
import com.fbtw.core.DataParser;
import com.fbtw.io.PreSet;
import com.fbtw.io.PreSetLoader;
import com.fbtw.io.TablePaternLoader;

import java.io.IOException;
import java.util.ArrayList;


/**
 * Hello world!
 *
 */
public class App {
    public static final int TIMEOUT = 70;

    public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {


        PreSetLoader loader = new PreSetLoader();
       // PreSet set =  loader.readPreSet(args[0]+".preset");
        PreSet set =  loader.readPreSet("пятница"+".preset");
        DataParser parser = new DataParser(set);

        parser.parse();
        System.exit(0);
    }


}
