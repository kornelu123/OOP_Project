package pl.edu.pwr.bum.simulation.objects.location;

import pl.edu.pwr.bum.simulation.app.SimulationStats;
import pl.edu.pwr.bum.simulation.objects.type.FieldType;
import pl.edu.pwr.bum.simulation.user.interfaces.TableHandler;

public class EmptyField implements Field{

    private String name;

    private int x;
    private int y;

    private int id;

    public EmptyField(int x,int y,String name) {
        this.id = x + 15*y;
        this.x = x;
        this.y = y;
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getX() {
        return this.x;
    }

    @Override
    public int getY() {
        return this.y;
    }

    @Override
    public void handleFieldAction(SimulationStats simStat) {
        TableHandler.printStatsTableNoRandomEvent(simStat);
    }

    @Override
    public void getCurrentField() {

    }
}
