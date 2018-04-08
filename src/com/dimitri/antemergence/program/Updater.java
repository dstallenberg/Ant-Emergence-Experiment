package com.dimitri.antemergence.program;

import com.dimitri.antemergence.world.World;

public class Updater {

    private boolean running;

    private Thread update;
    private final int UPS = 120;
    private Thread render;
    private final int FPS = 60;

    private Rendering rendering;


    public Updater(){
        rendering = new Rendering();
        init();
        update.start();
        render.start();
    }

    public void init(){
        running = true;
        update = new Thread(() -> {
            long last = System.nanoTime();
            double rate = 1000000000/UPS;
            while(running){
                if(System.nanoTime() - last >= rate){
                    double delta = ((System.nanoTime() - last)- rate)/rate;
                    last = System.nanoTime();
                    Main.update();
                }else if(System.nanoTime() - last < rate/2){
                    try {
                        Thread.sleep(0, 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        render = new Thread(() -> {
            long last = System.nanoTime();
            double rate = 1000000000/FPS;
            while(running){
                if(System.nanoTime() - last >= rate){
                    last = System.nanoTime();
                    rendering.render();
                }else if(System.nanoTime() - last < rate/2){
                    try {
                        Thread.sleep(0, 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void quit(){
        running = false;
        //SAVE STATE//

    }


}
