package world;
import world.tiles.BasicTile;

import javax.imageio.ImageIO;
import java.io.File;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class World {

    private final String mapPath = "";


    private BasicTile[] basicTiles;

    public World(){

    }

    private void generateMap() throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new File(mapPath));
        
        int[] dataBufferInt = bufferedImage.getRGB(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null, 0, bufferedImage.getWidth());
        basicTiles = new BasicTile[dataBufferInt.length];

        for (int y = 0; y < bufferedImage.getHeight(); y++) {
            for (int x = 0; x < bufferedImage.getWidth(); x++) {
                
            }
        }
        
        for (int i = 0; i < dataBufferInt.length; i++) {
            if(dataBufferInt[i] == 0){
                basicTiles[i] = new BasicTile(); 
            }else{
                
            }
        }
        
    }

    public void update(){

    }

    public void render(Graphics g){

    }
}
