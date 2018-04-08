package com.dimitri.antemergence.world;

import com.dimitri.antemergence.world.environment.weather.Conditions;

import java.util.ArrayList;
import java.util.List;

public class Location {

    private int x;
    private int y;
    private int z;

    private int DimensionSize;

    private Conditions conditions;
    private List<Location> neighbours;
    private boolean available;
    private boolean digAble;

    public Location(int x, int y, int z, boolean available, boolean digAble){
        this.x = x;
        this.y = y;
        this.z = z;
        // hardcoded
        this.DimensionSize = 4;
        this.available = available;
        this.digAble = digAble;
        this.neighbours = new ArrayList<>();
    }

    public void addNeighbour(Location location){
        neighbours.add(location);
    }

    public List<Location> getNeighbours(){
        return neighbours;
    }


    public boolean isAvailable() {
        return available;
    }

    public boolean isDigAble() {
        return digAble;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getZ() {
        return z;
    }

    public int getDimensionSize() {
        return DimensionSize;
    }
}
