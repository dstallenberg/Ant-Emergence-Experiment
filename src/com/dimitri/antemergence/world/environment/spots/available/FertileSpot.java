package com.dimitri.antemergence.world.environment.spots.available;

import com.dimitri.antemergence.world.environment.entities.beneficial.Aphids;
import com.dimitri.antemergence.world.environment.Vegetation;

public class FertileSpot extends AvailableSpot {

    private Vegetation vegetation;
    private Aphids aphids;

    public FertileSpot(int x, int y) {
        super(x, y, false);
    }
}
