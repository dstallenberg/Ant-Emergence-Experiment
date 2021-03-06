package com.dimitri.antemergence.program;

import com.dimitri.antemergence.program.handlers.KeyHandler;
import com.dimitri.antemergence.world.World;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.VolatileImage;

public class Rendering {

    private Frame frame;
    private Canvas canvas;

    private int canvasWidth = 0;
    private int canvasHeight = 0;

    public static final int GAME_WIDTH = 1080;
    public static final int GAME_HEIGHT = (GAME_WIDTH*9)/16;

    public Dimension screenSize;

    private int scale = 0;

    private GraphicsConfiguration gc;
    private VolatileImage volatileImage;

    public Rendering(){
        getBestSize();

        frame = new Frame();
        canvas = new Canvas();

        canvas.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        //put listeners in canvas
        canvas.addKeyListener(new KeyHandler());

        frame.add(canvas);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                Main.quit();
            }
        });

        frame.setVisible(true);
        gc = canvas.getGraphicsConfiguration();
        volatileImage = gc.createCompatibleVolatileImage(GAME_WIDTH, GAME_HEIGHT);
    }

    private void getBestSize(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        screenSize = toolkit.getScreenSize();
        canvasWidth = GAME_WIDTH;
        scale = canvasWidth/GAME_WIDTH;
        canvasHeight = scale*GAME_HEIGHT;
    }

    public void render() {
        if(volatileImage.validate(gc) == VolatileImage.IMAGE_INCOMPATIBLE){
            volatileImage = gc.createCompatibleVolatileImage(GAME_WIDTH, GAME_HEIGHT);
        }

        Graphics g = volatileImage.getGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);

        g.setColor(Color.WHITE);


        Main.render(g);


        g = canvas.getGraphics();
        g.drawImage(volatileImage, 0, 0, canvasWidth, canvasHeight, null);

        g.dispose();
    }

}
