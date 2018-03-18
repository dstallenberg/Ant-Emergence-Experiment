package com.dimitri.antemergence.world;

import com.dimitri.antemergence.world.environment.weather.Conditions;

public class Location {

    private int x;
    private int y;
    private int z;
    private Conditions conditions;

    public Location(int x, int y, int z){
        this.x = x;
        this.y = y;
        this.z = z;
    }



}
