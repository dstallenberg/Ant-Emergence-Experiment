package com.dimitri.antemergence.world.environment.spots;

import com.dimitri.antemergence.world.Location;
import com.dimitri.antemergence.world.environment.Soil;

import java.awt.*;

public abstract class BasicSpot extends Location {

    private Soil soil;

    public BasicSpot(int x, int y, boolean available, boolean digAble, Soil soil) {
        super(x, y, 0, available, digAble);
        this.soil = soil;
    }

    public void render(Graphics g){
        if(soil.equals(Soil.EARTH)){
            g.setColor(new Color(131, 82, 0));
            g.fillRect(getX()*getDimensionSize(), getY()*getDimensionSize(), getDimensionSize(), getDimensionSize());
        }else if(soil.equals(Soil.WATER)){
            g.setColor(new Color(60, 99, 152));
            g.fillRect(getX()*getDimensionSize(), getY()*getDimensionSize(), getDimensionSize(), getDimensionSize());
        }else if(soil.equals(Soil.GRASS)){
            g.setColor(new Color(28, 169, 62));
            g.fillRect(getX()*getDimensionSize(), getY()*getDimensionSize(), getDimensionSize(), getDimensionSize());
        }

        g.setColor(Color.WHITE);
        g.drawRect(getX()*getDimensionSize(), getY()*getDimensionSize(), getDimensionSize(), getDimensionSize());
    }
}
