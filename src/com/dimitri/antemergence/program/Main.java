package com.dimitri.antemergence.program;

public class Main {

    private static Updater u;

    public static void main(String... args){
        u = new Updater();
    }

    public static void quit(){
        u.quit();
        System.exit(0);
    }

}
