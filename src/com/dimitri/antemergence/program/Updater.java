package com.dimitri.antemergence.program;

import com.dimitri.antemergence.world.World;

public class Updater {

    private boolean running;

    private Thread update;
    private final int UPS = 120;
    private Thread render;
    private final int FPS = 60;

    private Rendering rendering;

    private World world;

    public Updater(){
        rendering = new Rendering();
        world = new World();
        init();
        update.start();
        render.start();
    }

    public void init(){
        running = true;
        update = new Thread(() -> {
            long last = System.nanoTime();
            while(running){
                if(System.nanoTime() - last >= 1000000000/UPS){
                    update();
                }else{
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        render = new Thread(() -> {
            long last = System.nanoTime();
            while(running){
                if(System.nanoTime() - last >= 1000000000/FPS){
                    render();
                }else{
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void update(){
        world.update();
    }

    public void render(){
        rendering.render(world);
    }

    public void quit(){
        running = false;
    }


}
