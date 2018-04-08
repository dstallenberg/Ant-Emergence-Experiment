package com.dimitri.antemergence.world.environment.spots.available;

import com.dimitri.antemergence.world.environment.Soil;

public class SandSpot extends AvailableSpot{
    public SandSpot(int x, int y) {
        super(x, y, false, Soil.SAND);
    }
}
