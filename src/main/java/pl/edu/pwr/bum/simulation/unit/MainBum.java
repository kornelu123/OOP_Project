package pl.edu.pwr.bum.simulation.unit;

import pl.edu.pwr.bum.simulation.Simulation;

public class MainBum extends Bum{
    private int drunkMeter;
    public MainBum(String name, int strength) {
        super(name, strength);
        this.drunkMeter = 300;
    }

    public float getDrunkMeter(){
        return this.drunkMeter/1000;
    }
    public enum operation{
        ADD,
        REMOVE
    }

    public Boolean isBumSober(){
        return this.drunkMeter <= 0;
    }

    public void handleDrunkMeterOperation(int howMuch, MainBum.operation operation){
        switch(operation){
            case ADD -> this.drunkMeter += howMuch;
            case REMOVE -> this.drunkMeter -= howMuch;
        }
    }
}