import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {
    public static void main (String [] args) throws FileNotFoundException {
        double totalBudgetU1 = 0, totalBudgetU2 = 0;
        Simulation simulation = new Simulation();

        ArrayList <Item> phase1 = simulation.loadItems(new File("Phase-1"));
        ArrayList <Item> phase2 = simulation.loadItems(new File("Phase-2"));

        // calculate total budget for U1

        ArrayList<U1> u1_rockets_phase1 = simulation.loadU1(phase1);
        ArrayList<U1> u1_rockets_phase2 = simulation.loadU1(phase2);
        totalBudgetU1 = simulation.runSimulation(u1_rockets_phase1);
        totalBudgetU1 += simulation.runSimulation(u1_rockets_phase2);
        System.out.println("U1 total budget is  " + totalBudgetU1);



        // calculate total budget for U2
        ArrayList<U2> u2_rockets_phase1 = simulation.loadU2(phase1);
        ArrayList<U2> u2_rockets_phase2 = simulation.loadU2(phase2);
        totalBudgetU2 = simulation.runSimulation(u2_rockets_phase1);
        totalBudgetU2 += simulation.runSimulation(u2_rockets_phase2);
        System.out.println("U2 total budget is  " + totalBudgetU2);


    }
}
