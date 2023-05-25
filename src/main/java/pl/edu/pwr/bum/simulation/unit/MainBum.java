package pl.edu.pwr.bum.simulation.unit;

import pl.edu.pwr.bum.simulation.Simulation;
import pl.edu.pwr.bum.simulation.random.events.animation.Animation;
import pl.edu.pwr.bum.simulation.random.events.animation.DrinkBeerAnimation;

public class MainBum extends Bum{
    private Long drunkMeter;
    private Long bottlesCount;
    public MainBum(String name, int strength,Long drunkMeter, Long amountOfBottles) {
        super(name, (long) strength);
        this.drunkMeter = drunkMeter;
        this.bottlesCount = amountOfBottles;
    }

    public Long getDrunkMeter(){
        return this.drunkMeter;
    }
    public enum operation{
        ADD,
        REMOVE
    }

    public void handleDrunkMeterOperation(int howMuch, MainBum.operation operation) throws InterruptedException {
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
        Animation.cleanScreen();
        DrinkBeerAnimation beerAnimation = new DrinkBeerAnimation();
        beerAnimation.printAnimation();
    }

    public void handleBottlesCountOperation(Long howMuch, MainBum.operation operation){
        switch(operation){
            case ADD -> {
                if(this.bottlesCount + howMuch <= this.strength){
                    this.bottlesCount = (Long) this.strength;
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

    public void buyMaxAmountOfPiwo() throws InterruptedException {
        handleDrunkMeterOperation((int) (this.bottlesCount*100),operation.ADD);
        this.bottlesCount = 0L;
    }

    public Long getBottlesCount(){
        return this.bottlesCount;
    }
}