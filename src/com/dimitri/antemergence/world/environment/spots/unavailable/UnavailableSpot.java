package com.dimitri.antemergence.world.environment.spots.unavailable;

import com.dimitri.antemergence.world.environment.Soil;
import com.dimitri.antemergence.world.environment.spots.BasicSpot;

public class UnavailableSpot extends BasicSpot {
    public UnavailableSpot(int x, int y, Soil soil) {
        super(x, y,false, false, soil);
    }
}
