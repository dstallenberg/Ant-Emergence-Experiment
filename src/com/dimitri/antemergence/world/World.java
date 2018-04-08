package com.dimitri.antemergence.world;

import com.dimitri.antemergence.program.handlers.KeyHandler;
import com.dimitri.antemergence.world.environment.Environment;
import com.dimitri.antemergence.world.nest.Nest;

import java.awt.*;
import java.awt.event.KeyEvent;

public class World {

    private double transX;
    private double transY;

    private Environment environment;
    private Nest nest;

    public World(){
        transX = 0;
        transY = 0;
        environment = new Environment();
    }

    public void update(){
        if(KeyHandler.isKeyPressed(KeyEvent.VK_W)){
            transY++;
        }
        if(KeyHandler.isKeyPressed(KeyEvent.VK_A)){
            transX--;
        }
        if(KeyHandler.isKeyPressed(KeyEvent.VK_S)){
            transY--;
        }
        if(KeyHandler.isKeyPressed(KeyEvent.VK_D)){
            transX++;
        }
    }

    public void render(Graphics g){
        int x = (int)transX;
        int y = (int)transY;
        g.translate(-x, y);
        environment.render(g);
        g.translate(x, -y);
    }

}
