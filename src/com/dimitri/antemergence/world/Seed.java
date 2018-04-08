package com.dimitri.antemergence.world;

import com.dimitri.antemergence.world.environment.spots.BasicSpot;
import com.dimitri.antemergence.world.environment.spots.available.DirtSpot;
import com.dimitri.antemergence.world.environment.spots.available.FertileSpot;
import com.dimitri.antemergence.world.environment.spots.available.SandSpot;
import com.dimitri.antemergence.world.environment.spots.unavailable.WaterSpot;

import java.util.Random;

public class Seed {
    //  first 3 numbers are water
    //
    private String seed = "1245678";
    private Random random;
    private BasicSpot[][] spotMap;
    private int width, height;

    public Seed(int width, int height, String seed){
        this.seed = seed;
        this.width = width;
        this.height = height;
        init();
    }

    public Seed(int width, int height){
        this.width = width;
        this.height = height;
        init();
    }

    public void init(){
        random = new Random();
        spotMap = new BasicSpot[height][width];

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
        int temp = random.nextInt(width/4) + 1;
        for (int i = 0; i < temp; i++) {
            int x = random.nextInt(spotMap[0].length);
            int y = random.nextInt(spotMap.length);

            spotMap[y][x] = new WaterSpot(x, y);
            // make some of the surrounding spots water too
            int maxRangeX = (int) (width/10 * (random.nextDouble()/2+0.5));
            int maxRangeY = (int) (width/10 * (random.nextDouble()/2+0.5));
            int startB = y - maxRangeY >= 0 ? y - maxRangeY : 0;
            int endB = y + maxRangeY < spotMap.length ? y + maxRangeY : spotMap.length;
            int startA = x - maxRangeX >= 0 ? x - maxRangeX : 0;
            int endA = x + maxRangeX < spotMap[0].length ? x + maxRangeX : spotMap[0].length;

            double maxDistance = Math.sqrt(maxRangeX*maxRangeX + maxRangeY*maxRangeY);

            for (int b = startB; b < endB; b++) {
                for (int a = startA; a < endA; a++) {
                    double distance = Math.sqrt((x-a)*(x-a) + (y-b)*(y-b));
                    double r = 1-(distance/maxDistance);
                    if((random.nextDouble()/2+0.5) * r * r >= 0.2){//
                        spotMap[b][a] = new WaterSpot(a, b);
                    }
                }
            }
        }
    }

    public void setFertile() {
        for (int y = 0; y < spotMap.length; y++) {
            for (int x = 0; x < spotMap[y].length; x++) {
                if(spotMap[y][x] instanceof DirtSpot){
                    // close to water means more chance to be fertile
                    // overall chance is 0.1

                    int maxRange = width/5;
                    int startB = y - maxRange >= 0 ? y - maxRange : 0;
                    int endB = y + maxRange < spotMap.length ? y + maxRange : spotMap.length;
                    int startA = x - maxRange >= 0 ? x - maxRange : 0;
                    int endA = x + maxRange < spotMap[0].length ? x + maxRange : spotMap[0].length;
                    double maxDistance = Math.sqrt(maxRange*maxRange + maxRange*maxRange);

                    double smallestDistance = Double.MAX_VALUE;
                    //find smallestDistance to water
                    for (int b = startB; b < endB; b++) {
                        for (int a = startA; a < endA; a++) {
                            if(spotMap[b][a] instanceof WaterSpot){
                                double distance = Math.sqrt((x-a)*(x-a) + (y-b)*(y-b));
                                if(distance < smallestDistance){
                                    smallestDistance = distance;
                                }
                            }
                        }
                    }

                    double r = smallestDistance/maxDistance;
                    if(random.nextDouble() <= 0.1 || r*random.nextDouble() <= 0.1){
                        spotMap[y][x] = new FertileSpot(x, y);
                    }
                    double z = r*random.nextDouble();
                    if(((z >= 0.6) && random.nextDouble() <= 0.2 ) && !(spotMap[y][x] instanceof FertileSpot)){
                        spotMap[y][x] = new SandSpot(x, y);
                    }
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
