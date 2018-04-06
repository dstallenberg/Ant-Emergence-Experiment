package com.dimitri.antemergence.colony.brains;


import com.dimitri.antemergence.world.Location;

import java.util.Map;
import java.util.TreeMap;

public class ExploredMap {

    private Map<Location, Location> routes;

    public ExploredMap(){
        routes = new TreeMap<>();
    }

}
