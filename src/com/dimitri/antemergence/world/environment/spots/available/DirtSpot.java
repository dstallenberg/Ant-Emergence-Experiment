package com.dimitri.antemergence.world.environment.spots.available;

import com.dimitri.antemergence.world.environment.Soil;

public class DirtSpot extends AvailableSpot {

    public DirtSpot(int x, int y) {
        super(x, y,true, Soil.EARTH);
    }
}
