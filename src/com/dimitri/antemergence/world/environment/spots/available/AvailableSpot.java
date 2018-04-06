package com.dimitri.antemergence.world.environment.spots.available;

import com.dimitri.antemergence.world.environment.spots.BasicSpot;

public class AvailableSpot extends BasicSpot {

    public AvailableSpot(int x, int y, boolean digAble) {
        super(x, y,true, digAble);
    }
}
