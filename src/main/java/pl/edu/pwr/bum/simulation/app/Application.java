package pl.edu.pwr.bum.simulation.app;

import java.io.IOException;

import static pl.edu.pwr.bum.simulation.app.SimLogicHandler.HandleSimLogic;
import static pl.edu.pwr.bum.simulation.app.SimulationStats.handleArgs;

public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {
        SimulationStats simStat = handleArgs(args);
        HandleSimLogic(simStat);

    }
}
