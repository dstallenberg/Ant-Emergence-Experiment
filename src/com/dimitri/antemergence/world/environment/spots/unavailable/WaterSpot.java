package com.dimitri.antemergence.world.environment.spots.unavailable;

import com.dimitri.antemergence.world.environment.Soil;

public class WaterSpot extends UnavailableSpot{
    public WaterSpot(int x, int y) {
        super(x, y, Soil.WATER);
    }
}
