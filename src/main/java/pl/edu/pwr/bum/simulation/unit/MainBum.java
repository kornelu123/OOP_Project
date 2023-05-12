package pl.edu.pwr.bum.simulation.unit;

import pl.edu.pwr.bum.simulation.Simulation;

public class MainBum extends Bum{
    private int drunkMeter;
    private int bottlesCount;
    public MainBum(String name, int strength,int drunkMeter, int amountOfBottles) {
        super(name, strength);
        this.drunkMeter = drunkMeter;
        this.bottlesCount = amountOfBottles;
    }

    public int getDrunkMeter(){
        return this.drunkMeter;
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
            case ADD -> {
                this.drunkMeter += howMuch;
                break;
            }
            case REMOVE -> {
                this.drunkMeter -= howMuch;
                break;
            }
            default -> {
                System.out.println("NO_OPERATION");
                break;
            }
        }
    }

    public void handleBottlesCountOperation(int howMuch, MainBum.operation operation){
        switch(operation){
            case ADD -> {
                if(this.bottlesCount + howMuch <= this.strength){
                    this.bottlesCount = this.strength;
                    break;
                }
                this.bottlesCount += howMuch;
                break;
            }
            case REMOVE -> {
                this.bottlesCount -= howMuch;
                break;
            }
            default -> {
                System.out.println("NO_OPERATION");
                break;
            }

        }
    }

    public int getBottlesCount(){
        return this.bottlesCount;
    }
}