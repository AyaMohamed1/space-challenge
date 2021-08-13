import java.io.*;
import java.util.*;
public class Simulation {
//    public static void main(String [] args) throws FileNotFoundException {
//        File file = new File("Phase-1.txt");
//        ArrayList <Item> listOfItems = loadItems(file);
//        boolean taken[] = new boolean[listOfItems.size()];
////        for (int i = 0; i < listOfItems.size(); i++){
////            System.out.println(listOfItems.get(i).name + "   " + listOfItems.get(i).weight + "   " + taken[i]);
////        }
//
//        //System.out.println("*****************************************************");
//
//        ArrayList <U1> u1_rockets = loadU1(listOfItems);
//        System.out.println("size       "+u1_rockets.size());
//        for (int i = 0; i < u1_rockets.size(); i++){
//            System.out.println(u1_rockets.get(i).currentWeight);
//        }
//
//        System.out.println("*****************************************************");
//
//        ArrayList <U2> u2_rockets = loadU2(listOfItems);
//        System.out.println("size    " + u2_rockets.size());
//        for (int i = 0; i < u2_rockets.size(); i++){
//            System.out.println(u2_rockets.get(i).currentWeight);
//        }
//
//        System.out.println("*****************************************************");
//
//
//
////        int c = 0;
////        for (int i = 0; i < 10; i++){
////            int a = (int) (Math.random() * 2);
////            System.out.println("a is    "  +a);
////            while (a == 0){
////                a = (int) (Math.random() * 2);
////                c++;
////            }
////            System.out.println("c is       " +c);
////        }
//
//
//
//    }


    //loads all items from a text file and returns an ArrayList of Items:
    public ArrayList<Item> loadItems(File file) throws FileNotFoundException {
        ArrayList <Item> inputItems = new ArrayList<>();
        Scanner input = new Scanner(file);
        while (input.hasNext()){
            String lineOfInput = input.nextLine();
            String lineSeparated[] = lineOfInput.split("=");
            Item item = new Item(lineSeparated[0], Integer.parseInt(lineSeparated[1]) / 1000);
            inputItems.add(item);
        }
        Collections.sort(inputItems);
        return inputItems;
    }

    public  int binarySearch(ArrayList<Item> inputItems, int val, int size){
        int st = 0, ed = size - 1, res = -1, mid;
        while (st <= ed){
            mid = (st + ed) / 2;
            if(valid(inputItems, val, mid)){
                res = mid;
                st = mid + 1;
            }
            else
                ed = mid - 1;
        }
        return res;
    }

    public  boolean valid(ArrayList<Item> inputItems, int val, int mid){
        Item item = inputItems.get(mid);
        if(item.weight <= val)
            return true;
        return false;
    }

    public ArrayList<U1> loadU1(ArrayList<Item> inputItems){
        ArrayList<U1> u1_Rokets = new ArrayList<>();
        int maxWeight = 8, switching = 1, i = inputItems.size() - 1, j = 0, weightsTaken = 0, newRocket = 0, noMoreElements = 0;
        int rocketCurrentWeight = 0;
        while (weightsTaken < inputItems.size()){
            newRocket = 0;
            maxWeight = 8;
            noMoreElements = 0;
            //System.out.println("yyyyyyyyyyyyyyyyyyyyyyy");
            while (newRocket == 0){
                if(switching == 1){
                    if(inputItems.get(i).weight <= maxWeight){
                        //System.out.println("index    " + i + "    weight    " + inputItems.get(i).weight + "     " + maxWeight);
                        maxWeight -= inputItems.get(i).weight;
                        weightsTaken++;
                        i--;
                        noMoreElements = 0;

                    }
                    else
                        noMoreElements++;
                    switching = -1;
                }
                if(switching == -1){
                    if(inputItems.get(j).weight <= maxWeight){
                        //System.out.println("index    " + j + "    weight    " + inputItems.get(j).weight + "     " + maxWeight);
                        maxWeight -= inputItems.get(j).weight;
                        weightsTaken++;
                        j++;
                        noMoreElements = 0;

                    }
                    else
                        noMoreElements++;
                    switching = 1;
                }
                if(noMoreElements == 2 || maxWeight == 0 || j >= i){
                   //System.out.println(maxWeight);
                    rocketCurrentWeight = 8 - maxWeight;
                    //System.out.println("rocket current weight      "+rocketCurrentWeight);
                    u1_Rokets.add(new U1(rocketCurrentWeight));
                    newRocket = 1;
                }
            }

        }
        //System.out.println();
        return u1_Rokets;
    }

    public ArrayList<U2> loadU2(ArrayList<Item> inputItems){
        ArrayList<U2> u2_Rokets = new ArrayList<>();
        int maxWeight = 11, switching = 1, i = inputItems.size() - 1, j = 0, weightsTaken = 0, newRocket = 0, noMoreElements = 0;
        int rocketCurrentWeight = 0;
        while (weightsTaken < inputItems.size()){
            newRocket = 0;
            maxWeight = 11;
            noMoreElements = 0;
            //System.out.println("yyyyyyyyyyyyyyyyyyyyyyy");
            while (newRocket == 0){
                if(switching == 1){
                    if(inputItems.get(i).weight <= maxWeight){
                        //System.out.println("index    " + i + "    weight    " + inputItems.get(i).weight + "     " + maxWeight);
                        maxWeight -= inputItems.get(i).weight;
                        weightsTaken++;
                        i--;
                        noMoreElements = 0;

                    }
                    else
                        noMoreElements++;
                    switching = -1;
                }
                if(switching == -1){
                    if(inputItems.get(j).weight <= maxWeight){
                        //System.out.println("index    " + j + "    weight    " + inputItems.get(j).weight + "     " + maxWeight);
                        maxWeight -= inputItems.get(j).weight;
                        weightsTaken++;
                        j++;
                        noMoreElements = 0;

                    }
                    else
                        noMoreElements++;
                    switching = 1;
                }
                if(noMoreElements == 2 || maxWeight == 0 || j >= i){
                    //System.out.println(maxWeight);
                    rocketCurrentWeight = 11 - maxWeight;
                    //System.out.println("rocket current weight      "+rocketCurrentWeight);
                    u2_Rokets.add(new U2(rocketCurrentWeight));
                    newRocket = 1;
                }
            }

        }
        return u2_Rokets;
    }

    public double runSimulation(ArrayList<? extends Rocket> rockets){
        double totalBudget = 0;
        for (int i = 0; i < rockets.size(); i++){
            totalBudget += rockets.get(i).cost;
            while (!rockets.get(i).launch() || !rockets.get(i).land()){
                totalBudget += rockets.get(i).cost;
            }
        }
        return totalBudget;
    }




}
