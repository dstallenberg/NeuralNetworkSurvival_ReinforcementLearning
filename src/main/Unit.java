package main;

import main.KeyHandler;
import world.World;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.VolatileImage;
import java.io.IOException;

public class Unit
{
    private Frame frame;
    private Canvas canvas;

    private int canvasWidth = 0;
    private int canvasHeight = 0;

    public static final int GAME_WIDTH = 1080;
    public static final int GAME_HEIGHT = (GAME_WIDTH*9)/16;

    public Dimension screenSize;

    private int scale = 0;

    private GraphicsConfiguration gc;
    private VolatileImage vImage;
    
    private World world;

    public Unit(){
        getBestSize();

        frame = new Frame();
        canvas = new Canvas();

        canvas.setPreferredSize(new Dimension(canvasWidth, canvasHeight));
        canvas.addKeyListener(new KeyHandler());
        canvas.addMouseListener(new InputHandler());
        canvas.addMouseMotionListener(new InputHandler());

        frame.add(canvas);

        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);

        frame.addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                Test.quit(world.getNet());
            }
        });

        frame.setVisible(true);
        gc = canvas.getGraphicsConfiguration();
        vImage = gc.createCompatibleVolatileImage(GAME_WIDTH, GAME_HEIGHT);

        world = new World();
    }

    private void getBestSize(){
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        screenSize = toolkit.getScreenSize();
        canvasWidth = GAME_WIDTH;
        scale = canvasWidth/GAME_WIDTH;
        canvasHeight = scale*GAME_HEIGHT;
    }

    public void update(){
        world.update();
    }

    public void render(){
        if(vImage.validate(gc) == VolatileImage.IMAGE_INCOMPATIBLE){
            vImage = gc.createCompatibleVolatileImage(GAME_WIDTH, GAME_HEIGHT);
        }

        Graphics g = vImage.getGraphics();

        g.setColor(Color.BLACK);
        g.fillRect(0, 0, GAME_WIDTH, GAME_HEIGHT);

        g.setColor(Color.WHITE);


        world.render(g);


        g = canvas.getGraphics();
        g.drawImage(vImage, 0, 0, canvasWidth, canvasHeight, null);

        g.dispose();
    }

    public World getworld() {
        return world;
    }
}
