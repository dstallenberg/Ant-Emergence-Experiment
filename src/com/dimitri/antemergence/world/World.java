package com.dimitri.antemergence.world;

import com.dimitri.antemergence.world.environment.Environment;
import com.dimitri.antemergence.world.nest.Nest;

import java.awt.*;

public class World {

    private Environment environment;
    private Nest nest;

    public World(){
        environment = new Environment();
    }

    public void update(){

    }

    public void render(Graphics g){
        environment.render(g);
    }

}
