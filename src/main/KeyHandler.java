package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener{
    @Override
    public void keyTyped(KeyEvent e) {
        if(e.getKeyChar() == 'a'){

            Main.delay /= 10;
            if(Main.delay <= 1){
                Main.delay = 0;
            }
        }else if(e.getKeyChar() == 'd'){

            if(Main.delay <= 1){
                Main.delay = 1;
            }
            Main.delay *= 10;
            if(Main.delay >= 1000){
                Main.delay = 1000;
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
