package pl.edu.pwr.bum.simulation.unit;

public class MainBum extends Bum{
    private float drunkMeter;
    public MainBum(String name, int strength) {
        super(name, strength);
        this.drunkMeter = 3/10;
    }

    public float getDrunkMeter(){
        return this.drunkMeter;
    }

    public Boolean isBumSober(){
        return this.drunkMeter == 0;
    }


}
