package com.dimitri.antemergence.world.environment;

import com.dimitri.antemergence.world.Seed;
import com.dimitri.antemergence.world.environment.spots.BasicSpot;
import com.dimitri.antemergence.world.environment.spots.available.DirtSpot;
import com.dimitri.antemergence.world.environment.spots.available.FertileSpot;
import com.dimitri.antemergence.world.environment.spots.unavailable.WaterSpot;
import com.dimitri.antemergence.world.environment.weather.Climate;

import java.awt.*;
import java.util.Random;

// Dimitri looks cute <3
public class Environment {

    private Seed seed;
    private Climate climate;

    private BasicSpot[][] spotMap;

    public Environment(){
        this.seed = new Seed(200, 300);
        this.climate = new Climate();
        spotMap = seed.getSpotMap();


    }

//    public Environment(/*SaveState*/){
//
//    }

    public void update(){

    }

    public void render(Graphics g){
        for (int y = 0; y < spotMap.length; y++) {
            for (int x = 0; x < spotMap[y].length; x++) {
                spotMap[y][x].render(g);
            }
        }
    }


}
