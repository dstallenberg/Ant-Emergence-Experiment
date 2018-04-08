package com.dimitri.antemergence.program;

import com.dimitri.antemergence.program.handlers.KeyHandler;
import com.dimitri.antemergence.world.World;

import java.awt.*;

public class Main {

    private static World world;
    private static Updater u;
    private static KeyHandler keyHandler;

    private static long lastRender = System.nanoTime();
    private static int renders = 0;
    private static int FPS = 0;

    private static long lastUpdate = System.nanoTime();
    private static int updates = 0;
    private static int UPS = 0;

    public static void main(String... args){
        world = new World();
        u = new Updater();
        keyHandler = new KeyHandler();
    }

    public static void update(){
        if(System.nanoTime() - lastUpdate >= 1000000000){
            lastUpdate = System.nanoTime();
            UPS = updates;
            updates = 0;
        }
        updates++;

        keyHandler.update();
        world.update();
    }

    public static void render(Graphics g){
        if(System.nanoTime() - lastRender >= 1000000000){
            lastRender = System.nanoTime();
            FPS = renders;
            renders = 0;
        }
        renders++;

        world.render(g);
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, 60, 21);
        g.setColor(Color.GREEN);
        g.drawString("FPS: " + FPS, 1, 10);
        g.drawString("UPS: " + UPS, 1, 20);
    }

    public static void quit(){
        u.quit();
        System.exit(0);
    }

    public static World getWorld() {
        return world;
    }
}
