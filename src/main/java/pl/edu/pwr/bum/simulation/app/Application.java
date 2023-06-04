package pl.edu.pwr.bum.simulation.app;
import pl.edu.pwr.bum.simulation.objects.type.FieldType;
import pl.edu.pwr.bum.simulation.user.interfaces.TableHandler;

import java.io.IOException;
import java.util.Random;

public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {
        String name = args[0];
        Integer strength =  Integer.parseInt(args[1]);
        Integer drunkMeter = Integer.parseInt(args[2]);
        Long amountOfBottles = Long.valueOf(args[3]);
        Integer milisToSleep = Integer.valueOf(args[4]);
        Integer bottlesDecrease = Integer.valueOf(args[5]);
        Random rand = new Random();
        SimulationStats simStat = SimulationStats.initSimStats(name,strength,drunkMeter, amountOfBottles ,bottlesDecrease);
        if(milisToSleep < 1000){
            simStat.kloszard.skipAnimation();
        }
        Integer turns = 0;
        while(simStat.kloszard.getDrunkMeter() > 0) {
            turns++;
            if(simStat.currentField.fieldType == FieldType.EMTPY_FIELD && (milisToSleep != 0)){
                TableHandler.printStatsTableNoRandomEvent(simStat);
            }else if(simStat.currentField.fieldType == FieldType.LIQUOR_STORE){
                if(milisToSleep != 0) {
                    TableHandler.printStatsTableLiquorStore(simStat);
                }
                simStat.handleLiquorStore();
            }else if(simStat.currentField.fieldType == FieldType.ACTION_FIELD){
                if(milisToSleep != 0){
                    TableHandler.printStatsTable(simStat);
                }
                simStat.handleActionField();
            }
                int random = rand.nextInt(4);
                Thread.sleep(milisToSleep);
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
            Animation.cleanScreen();
        }
        System.out.println(simStat.kloszard.name + " jest trzezwy , symulacja sie konczy\n");
        System.out.println("Dlugosc symulacji w kolejkach :" + turns + "\n");
        System.out.println("Ilosc wypitych piw : "+ simStat.kloszard.getAmountOfBeersDrank() + "\n");
    }

    public void parseArgs(String[] args){

    }
}
