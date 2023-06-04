package pl.edu.pwr.bum.simulation.objects;

import pl.edu.pwr.bum.simulation.objects.events.animation.DrinkBeerAnimation;

public class MainBum {
    public final String name;
    final Long strength;
    private Long drunkMeter;
    private Long bottlesCount;
    private boolean skipAnimation;
    private Long drankBeers;

    public void skipAnimation(){
        this.skipAnimation = true;
    }
    public MainBum(String name, long strength,Long drunkMeter, Long amountOfBottles , Integer amountOfTurnBottlesCountDecrease) {
        this.drunkMeter = drunkMeter;
        this.bottlesCount = amountOfBottles;
        this.name = name;
        this.strength = strength;
        this.drankBeers = 0L ;
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
                if(this.drunkMeter + howMuch > 1000){
                    break;
                }
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

    public Long getAmountOfBeersDrank(){
        return this.drankBeers;
    }

    public void handleBottlesCountOperation(Long howMuch, MainBum.operation operation){
        switch(operation){
            case ADD -> {
                if (this.bottlesCount + howMuch >= this.strength) {
                    this.bottlesCount = (Long) this.strength;
                    break;
                }
                this.bottlesCount += howMuch;
                break;
            }
            default -> {
                System.out.println("NO_OPERATION");
                break;
            }

        }
    }

    public void buyMaxAmountOfPiwo() throws InterruptedException {
        if(this.bottlesCount == 0){
            return;
        }
        this.drankBeers += this.bottlesCount;
        this.handleDrunkMeterOperation((int) (this.bottlesCount*50),operation.ADD);
        DrinkBeerAnimation beerAnimation = new DrinkBeerAnimation();
        this.bottlesCount = 0L;
        if(skipAnimation){
            return;
        }
        beerAnimation.printAnimation();
    }

    public Long getBottlesCount(){
        return this.bottlesCount;
    }
}