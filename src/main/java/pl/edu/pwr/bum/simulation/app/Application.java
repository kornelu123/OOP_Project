package pl.edu.pwr.bum.simulation.app;
import pl.edu.pwr.bum.simulation.objects.type.FieldType;
import pl.edu.pwr.bum.simulation.user.interfaces.TableHandler;

import java.io.IOException;
import java.util.Random;

import static pl.edu.pwr.bum.simulation.app.SimLogicHandler.HandleSimLogic;
import static pl.edu.pwr.bum.simulation.app.SimulationStats.handleArgs;
import static pl.edu.pwr.bum.simulation.objects.events.animation.Animation.cleanScreen;

public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {
        SimulationStats simStat = handleArgs(args);
        HandleSimLogic(simStat);
    }
}
