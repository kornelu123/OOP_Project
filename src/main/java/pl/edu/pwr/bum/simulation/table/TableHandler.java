package pl.edu.pwr.bum.simulation.table;

import com.acidmanic.consoletools.drawing.AsciiBorders;
import com.acidmanic.consoletools.table.Table;
import com.acidmanic.consoletools.table.builders.TableBuilder;

import pl.edu.pwr.bum.simulation.app.SimulationStats;

public class TableHandler {
    public static void printStatsTable(SimulationStats simStats){
        Table table = new TableBuilder()
            .tableBorder(AsciiBorders.BOLD)  /* set a BOLD border for table itself */
            .cell(simStats.getRandomEvent().description).maximumWidth(50)       /* add a cell with string content, (by default first row has been added) */
            .border()                        /* set default border for the cell */
            .row().cell(String.valueOf("DrunkMeter : "+ simStats.kloszard.getDrunkMeter()+" / 1000")).border(AsciiBorders.DOUBLELINE) /* add new row to main table, then add a text cell with DOUBLELINE borders.*/
            .cell("BottleCount : "+ simStats.kloszard.getBottlesCount()).border(AsciiBorders.BOLD)                  /* add another text cell to the row with BOLD border */
            .cell("Name : "+simStats.kloszard.name).border(AsciiBorders.SOLID)           /* add third text cell to the row with SOLID (default) border.*/
            .row().cell((TableBuilder builder) -> builder.table(new String[][] {{"X", String.valueOf(simStats.currentField.x-1),String.valueOf(simStats.currentField.x),String.valueOf(simStats.currentField.x+1)},{String.valueOf(simStats.currentField.y-1),"","UP" ,""},{String.valueOf(simStats.currentField.y),"LEFT",simStats.currentField.name,"RIGHT"},{String.valueOf(simStats.currentField.y+1),"","DOWN",""}}).borderAll().padAll(5, 1).tableBorder())
            .build();                       /* build main table*/

        System.out.println(table.render());
    }
    public static void printStatsTableNoRandomEvent(SimulationStats simStats){
        Table table = new TableBuilder()
                .tableBorder(AsciiBorders.BOLD)  /* set a BOLD border for table itself */
                .cell().maximumWidth(50)       /* add a cell with string content, (by default first row has been added) */
                .border()                        /* set default border for the cell */
                .row().cell(String.valueOf("DrunkMeter : "+ simStats.kloszard.getDrunkMeter()+" / 1000")).border(AsciiBorders.DOUBLELINE) /* add new row to main table, then add a text cell with DOUBLELINE borders.*/
                .cell("BottleCount : "+ simStats.kloszard.getBottlesCount()).border(AsciiBorders.BOLD)                  /* add another text cell to the row with BOLD border */
                .cell("Name : "+simStats.kloszard.name).border(AsciiBorders.SOLID)           /* add third text cell to the row with SOLID (default) border.*/
                .row().cell((TableBuilder builder) -> builder.table(new String[][] {{"X", String.valueOf(simStats.currentField.x-1),String.valueOf(simStats.currentField.x),String.valueOf(simStats.currentField.x+1)},{String.valueOf(simStats.currentField.y-1),"","UP" ,""},{String.valueOf(simStats.currentField.y),"LEFT",simStats.currentField.name,"RIGHT"},{String.valueOf(simStats.currentField.y+1),"","DOWN",""}}).borderAll().padAll(5, 1).tableBorder())
                .build();                       /* build main table*/

        System.out.println(table.render());
    }
    public static void printStatsTableLiquorStore(SimulationStats simStats){
        Table table = new TableBuilder()
                .tableBorder(AsciiBorders.BOLD)  /* set a BOLD border for table itself */
                .cell("Aaaaa , browarix , ulubione miejsce miejskiej smietanki Wrocławia, kupie tyle ile moge .").maximumWidth(50)       /* add a cell with string content, (by default first row has been added) */
                .border()                        /* set default border for the cell */
                .row().cell(String.valueOf("DrunkMeter : "+ simStats.kloszard.getDrunkMeter()+" / 1000")).border(AsciiBorders.DOUBLELINE) /* add new row to main table, then add a text cell with DOUBLELINE borders.*/
                .cell("BottleCount : "+ simStats.kloszard.getBottlesCount()).border(AsciiBorders.BOLD)                  /* add another text cell to the row with BOLD border */
                .cell("Name : "+simStats.kloszard.name).border(AsciiBorders.SOLID)           /* add third text cell to the row with SOLID (default) border.*/
                .row().cell((TableBuilder builder) -> builder.table(new String[][] {{"X", String.valueOf(simStats.currentField.x-1),String.valueOf(simStats.currentField.x),String.valueOf(simStats.currentField.x+1)},{String.valueOf(simStats.currentField.y-1),"","UP" ,""},{String.valueOf(simStats.currentField.y),"LEFT",simStats.currentField.name,"RIGHT"},{String.valueOf(simStats.currentField.y+1),"","DOWN",""}}).borderAll().padAll(5, 1).tableBorder())
                .build();                       /* build main table*/

        System.out.println(table.render());
    }
}
