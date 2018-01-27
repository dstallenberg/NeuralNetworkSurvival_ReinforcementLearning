package main;

import java.io.FileNotFoundException;

public class Main {

    private static Unit unit;

    private static MultiThread update;
    private static MultiThread render;

    public static int delay = 100;

    public static void main(String... args){
        unit = new Unit();
        update = new MultiThread(unit, "Update");
        render = new MultiThread(unit, "Render");
        update.start();
        render.start();
    }

    public static void quit(Net net) {
        update.Running = false;
        render.Running = false;
        net.setFilePath("weights.txt");
        try {
            net.getIo().Write(net);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

    public static Unit getUnit() {
        return unit;
    }

}
