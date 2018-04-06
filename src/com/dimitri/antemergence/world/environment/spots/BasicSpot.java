package com.dimitri.antemergence.world.environment.spots;

import com.dimitri.antemergence.world.Location;
import com.dimitri.antemergence.world.environment.Soil;

public class BasicSpot extends Location {

    private Soil soil;

    public BasicSpot(int x, int y, boolean available, boolean digAble) {
        super(x, y, 0, available, digAble);
    }
}
