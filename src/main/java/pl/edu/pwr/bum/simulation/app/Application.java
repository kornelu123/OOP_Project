package pl.edu.pwr.bum.simulation.app;
import pl.edu.pwr.bum.simulation.field.type.FieldType;
import pl.edu.pwr.bum.simulation.random.events.animation.Animation;
import pl.edu.pwr.bum.simulation.table.TableHandler;

import java.io.IOException;
import java.util.Random;

public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {
        Random rand = new Random();
        SimulationStats simStat = SimulationStats.initSimStats("zulas",50,300, 2L);
        Integer turns = 0;
        while(simStat.kloszard.getDrunkMeter() >= 0) {
            turns++;
            if(simStat.currentField.fieldType == FieldType.EMTPY_FIELD){
                TableHandler.printStatsTableNoRandomEvent(simStat);
            }else if(simStat.currentField.fieldType == FieldType.LIQUOR_STORE){
                TableHandler.printStatsTableLiquorStore(simStat);
                simStat.handleLiquorStore();
            }else if(simStat.currentField.fieldType == FieldType.ACTION_FIELD){
                TableHandler.printStatsTable(simStat);
                simStat.handleActionField();
            }
            System.out.println(simStat.kloszard.getBottlesCount());
            while(true){
                int random = rand.nextInt(4);
                Thread.sleep(3000);
                if(random == 0){
                    simStat.goUp();
                    break;
                }
                if(random == 1){
                    simStat.goLeft();
                    break;
                }
                if(random == 2){
                    simStat.goDown();
                    break;
                }
                if(random == 3){
                    simStat.goRight();
                    break;
                }
                System.out.println("Bad input , try again");
            }
            Animation.cleanScreen();
        }
        System.out.println(simStat.kloszard.name + " jest trzezwy , symulacja sie konczy\n");
        System.out.println("Dlugosc symulacji " + turns + " kolejek\n");
    }
}
