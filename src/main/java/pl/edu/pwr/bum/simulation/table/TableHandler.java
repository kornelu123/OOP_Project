package pl.edu.pwr.bum.simulation.table;

import com.acidmanic.consoletools.drawing.AsciiBorders;
import com.acidmanic.consoletools.table.Table;
import com.acidmanic.consoletools.table.builders.TableBuilder;

import pl.edu.pwr.bum.simulation.app.SimulationStats;
import pl.edu.pwr.bum.simulation.random.events.RandomEvent;

public class TableHandler {
    public static void printStatsTable(SimulationStats simStats){
        Table table = new TableBuilder()
            .tableBorder(AsciiBorders.BOLD)  /* set a BOLD border for table itself */
            .cell(simStats.getRandomEvent().description).maximumWidth(50)       /* add a cell with string content, (by default first row has been added) */
            .border()                        /* set default border for the cell */
            .cell((TableBuilder builder) -> builder     /* add new cell (beside last one), building a table as cell's content */
                    .row().cell("00").cell("01")        /* create first row, then two cells for it with values 00 and 01 */
                    .row().cell("10").cell("11")        /* create second row, then two cells for it with values 10 and 11 */
                    .borderAll().tableBorder())         /* set default border for all cells, then set default border for table*/
            .row().cell(String.valueOf("DrunkMeter : "+ simStats.kloszard.getDrunkMeter()+" / 1000")).border(AsciiBorders.DOUBLELINE) /* add new row to main table, then add a text cell with DOUBLELINE borders.*/
            .cell("BottleCount : "+ simStats.kloszard.getBottlesCount()).border(AsciiBorders.BOLD)                  /* add another text cell to the row with BOLD border */
            .cell("Name : "+simStats.kloszard.name).border(AsciiBorders.SOLID)           /* add third text cell to the row with SOLID (default) border.*/
            .row().cell((TableBuilder builder) -> builder.table(new String[][] {{"X", String.valueOf(simStats.x-1),String.valueOf(simStats.x),String.valueOf(simStats.x+1)},{String.valueOf(simStats.y-1),"","UP" ,""},{String.valueOf(simStats.y),"LEFT","YOU","RIGHT"},{String.valueOf(simStats.y+1),"","DOWN",""}}).borderAll().padAll(5, 1).tableBorder())
            .cell((TableBuilder builder)                                    /* add another cell to third row with a table as its content. */
                    -> builder.table(new String[][]{{"A", "B"}, {"C", "D"},{"E","F"}}) /* this inner table will have three rows, two cell each row corresponding to given 2d array*/
                    .padAll(3,2).tableBorder(AsciiBorders.BOLD))            /* all 6 cell of inner table will get 3 chars H-padding and 2 chars V-padding. the table itself gets a BOLD border. */
            .build();                       /* build main table*/

        System.out.println(table.render());
    }
}
