package pl.edu.pwr.bum.simulation.app;
import pl.edu.pwr.bum.simulation.filedType.FieldType;
import pl.edu.pwr.bum.simulation.table.TableHandler;
import jcurses.system.*;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException, InterruptedException {
        SimulationStats simStat = SimulationStats.initSimStats("zulas",50,300, 2L);
        while(simStat.kloszard.getDrunkMeter() >= 0) {
            if(simStat.currentField.fieldType == FieldType.EMTPY_FIELD){
                TableHandler.printStatsTableNoRandomEvent(simStat);
            }else if(simStat.currentField.fieldType == FieldType.LIQUOR_STORE){
                TableHandler.printStatsTableLiquorStore(simStat);
                simStat.handleLiquorStore();
            }else if(simStat.currentField.fieldType == FieldType.ACTION_FIELD){
                TableHandler.printStatsTable(simStat);
                simStat.handleActionField();
            }
            while(true){
                InputChar c = Toolkit.readCharacter();
                char ch = c.getCharacter();
                System.out.println(ch);
                if(ch == 'w'){
                    simStat.goUp();
                    break;
                }
                if(ch == 'a'){
                    simStat.goLeft();
                    break;
                }
                if(ch == 's'){
                    simStat.goDown();
                    break;
                }
                if(ch == 'd'){
                    simStat.goRight();
                    break;
                }
            }
        }
    }
}
