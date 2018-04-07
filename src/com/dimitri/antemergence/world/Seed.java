package com.dimitri.antemergence.world;

import com.dimitri.antemergence.world.environment.spots.BasicSpot;
import com.dimitri.antemergence.world.environment.spots.available.DirtSpot;
import com.dimitri.antemergence.world.environment.spots.available.FertileSpot;
import com.dimitri.antemergence.world.environment.spots.unavailable.WaterSpot;

import java.util.Random;

public class Seed {
    //  first 3 numbers are water
    //
    private String seed = "1245678";
    private Random random;
    private BasicSpot[][] spotMap;

    public Seed(int width, int height, String seed){
        this.seed = seed;
        init(width, height);
    }

    public Seed(int width, int height){
        init(width, height);
    }

    public void init(int width, int height){
        random = new Random();
        spotMap = new BasicSpot[width][height];

        for (int y = 0; y < spotMap.length; y++) {
            for (int x = 0; x < spotMap[y].length; x++) {
                spotMap[y][x] = new DirtSpot(x, y);
            }
        }

        setWater();
        setFertile();
        setNeighbours();
    }

    public void setWater() {
        int temp = random.nextInt(5) + 1;
        for (int i = 0; i < temp; i++) {
            int x = random.nextInt(spotMap[0].length);
            int y = random.nextInt(spotMap.length);

            spotMap[y][x] = new WaterSpot(x, y);

            // make some of the surrounding spots water too

        }


    }

    public void setFertile() {
        for (int y = 0; y < spotMap.length; y++) {
            for (int x = 0; x < spotMap[y].length; x++) {
                if(spotMap[x][y] instanceof DirtSpot){
//                    if(closetowater) make fertile
                }
            }
        }
    }


    public void setNeighbours() {
        // set neighbours probably not the fastest way
        // one way to do it faster is by adding itself to the neighbour's list of neighbours and then skipping it for the
        // this can be archieved by using a schaakbord instead of the whole field
        for (int y = 0; y < spotMap.length; y++) {
            for (int x = 0; x < spotMap[y].length; x++) {
                // check if the current spot is available
                if(spotMap[y][x].isAvailable()){
                    // check for unreachable edges
                    if(x != 0){
                        if(spotMap[y][x - 1].isAvailable()){
                            spotMap[y][x].addNeighbour(spotMap[y][x - 1]);
                        }
                    }
                    if(y != 0){
                        if(spotMap[y - 1][x].isAvailable()){
                            spotMap[y][x].addNeighbour(spotMap[y - 1][x]);
                        }
                    }
                    if(x != spotMap[y].length - 1){
                        if(spotMap[y][x + 1].isAvailable()){
                            spotMap[y][x].addNeighbour(spotMap[y][x + 1]);
                        }
                    }
                    if(y != spotMap.length - 1){
                        if(spotMap[y + 1][x].isAvailable()){
                            spotMap[y][x].addNeighbour(spotMap[y + 1][x]);
                        }
                    }
                }
            }
        }
    }

    public BasicSpot[][] getSpotMap() {
        return spotMap;
    }
}
