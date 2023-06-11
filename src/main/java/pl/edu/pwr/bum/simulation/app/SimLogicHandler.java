package pl.edu.pwr.bum.simulation.app;

import java.util.Random;

import static pl.edu.pwr.bum.simulation.objects.events.animation.Animation.cleanScreen;

public class SimLogicHandler {
    static public void HandleSimLogic(SimulationStats simStat) throws InterruptedException {

        while(simStat.kloszard.getDrunkMeter() > 0) {
            simStat.incrementTurnCount();
            Random rand = new Random();
            simStat.getCurrentField().handleFieldAction(simStat);
            int random = rand.nextInt(4);
            Thread.sleep(simStat.getMilisToSleep());
            if(random == 0){
                simStat.goUp();
            }
            if(random == 1){
                simStat.goLeft();
            }
            if(random == 2){
                simStat.goDown();
            }
            if(random == 3){
                simStat.goRight();
            }
            cleanScreen();
        }
        handleSimSummary(simStat);
    }

    static public void handleSimSummary(SimulationStats simStat){
        System.out.println(simStat.kloszard.name + " jest trzezwy , symulacja sie konczy\n");
        System.out.println("Dlugosc symulacji w kolejkach :" + simStat.getTurnCount() + "\n");
        System.out.println("Ilosc wypitych piw : "+ simStat.kloszard.getAmountOfBeersDrank() + "\n");

    }
}
