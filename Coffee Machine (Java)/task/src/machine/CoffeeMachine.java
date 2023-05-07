package machine;
import java.util.*;

public class CoffeeMachine {



    final static int WATERPERCOFFEE = 200;
    final static int MILKPERCOFFEE = 50;
    final static int BEANSPERCOFFEE = 15;

    final static int WATERPERESPRESSO = 250;
    final static int BEANSPERESPRESSO = 16;
    final static int COSTOFESPRESSO = 4;

    final static int WATERPERLATTE = 350;
    final static int MILKPERLATTE = 75;
    final static int BEANSPERLATTE = 20;
    final static int COSTOFLATTE =   7;

    final static int WATERPERCAPPUCINO = 200;
    final static int MILKPERCAPPUCINO = 100;
     final static int BEANSPERCAPPUCINO = 12;
    final static int COSTOFCAPPUCINO = 6;

    static int  currentNumberOfCups = 9;
    static int currentMoney = 550;
    static int currentWater = 400;
    static int currentMilk = 540;
    static int currentBeans = 120;


    public static void printStatus ()
    {



        System.out.println("The coffee machine has: ");
        System.out.println(currentWater + " ml of water");
        System.out.println(currentMilk + " ml of milk");
        System.out.println(currentBeans + " g of coffee beans");
        System.out.println(currentNumberOfCups + " disposable cups");
        System.out.println("$"+currentMoney + " of money");

        determineMode();}


//    public static void printStatus (int userWaterAdd, int userMilkAdd, int userBeansAdd, int userCupsAdd, int userCost)
//    {
//         int  currentNumberOfCups = 9 + userCupsAdd;
//         int currentMoney = 550 + userCost;
//        int currentWater = 400+userWaterAdd;
//        int currentMilk = 540+userMilkAdd;
//         int currentBeans = 120 + userBeansAdd;
//
//
//        System.out.println("The coffee machine has: ");
//        System.out.println(currentWater + " ml of water");
//        System.out.println(currentMilk + " ml of milk");
//        System.out.println(currentBeans + " g of coffee beans");
//        System.out.println(currentNumberOfCups + " disposable cups");
//        System.out.println("$"+currentMoney + " of money");}
//
//    public static void printStatus (boolean tookMoney)
//    {
//        int currentNumberOfCups = 9;
//        int currentMoney;
//        if (tookMoney==true)
//        {currentMoney=0;}
//        else
//        {currentMoney=550;}
//        int currentWater = 400;
//        int currentMilk = 540;
//        int currentBeans = 120;
//
//
//        System.out.println("The coffee machine has: ");
//        System.out.println(currentWater + " ml of water");
//        System.out.println(currentMilk + " ml of milk");
//        System.out.println(currentBeans + " g of coffee beans");
//        System.out.println(currentNumberOfCups + " disposable cups");
//        System.out.println("$"+currentMoney + " of money");}





        public static void determineMode()
        {

            System.out.println("Write action (buy, fill, take, remaining, exit):");
            Scanner scan = new Scanner(System.in);
            String userChoice = scan.next();

            if (userChoice.equals("buy"))
            {

                buy();
            } else if (userChoice.equals("fill"))
            {
                fill();
            }
            else if (userChoice.equals("take"))
            {
                take();

            }
            else if (userChoice.equals("remaining"))
            {

                printStatus();


            }
            else if (userChoice.equals("exit"))
            {
                System.exit(0);
            }
        }

public static void buy() { //start of buy
    Scanner scan = new Scanner(System.in);
    System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappucino, back - to main menu:");
    //TO FINISH

    String userOption = scan.next();
    if (userOption.equals("1") ) {//start of espresso
        if (checkResources(250, 0, 16, 1) == true) {
            System.out.println("I have enough resources, making you a coffee!");
            currentWater-=WATERPERESPRESSO;
            currentBeans-=BEANSPERESPRESSO;
            currentNumberOfCups--;
            currentMoney+=COSTOFESPRESSO;

        } else {
            if (WATERPERESPRESSO > currentWater) {
                System.out.println("Sorry, not enough water!");
            } else if (BEANSPERESPRESSO > currentBeans) {
                System.out.println("Sorry, not enough beans!");
            } else if (currentNumberOfCups == 0) {
                System.out.println("Sorry, not enough cups!");
            }
        }//end of espresso

//now latte
        } else if (userOption.equals("2")) {

        if (checkResources(WATERPERLATTE, MILKPERLATTE, BEANSPERLATTE, 1)==true)
        {
            System.out.println("I have enough resources, making you a coffee!");
        currentWater-=WATERPERLATTE;
        currentMilk-=MILKPERLATTE;
        currentBeans-=BEANSPERLATTE;
        currentNumberOfCups--;
        currentMoney+=COSTOFLATTE;


        }
        else {

            if (WATERPERLATTE > currentWater) {
                System.out.println("Sorry, not enough water!");
            } else if (MILKPERLATTE > currentMilk) {
                System.out.println("Sorry, not enough milk!");

            } else if (BEANSPERLATTE > currentBeans) {
                System.out.println("Sorry, not enough beans!");

            } else if (currentNumberOfCups == 0) {
                System.out.println("Sorry, not enough cups!");
            }



        }

        }//end of option latte


    //now cappucino
    else if (userOption.equals("3")) {

        if (checkResources(WATERPERCAPPUCINO, MILKPERCAPPUCINO, BEANSPERCAPPUCINO, 1)==true) {
            System.out.println("I have enough resources, making you a coffee!" );
            currentWater-=WATERPERCAPPUCINO;
            currentMilk-=MILKPERCAPPUCINO;
            currentBeans-=BEANSPERCAPPUCINO;
            currentNumberOfCups--;
            currentMoney+=COSTOFCAPPUCINO;


        }
        else if (WATERPERCAPPUCINO<currentWater)
        {
            System.out.println("Sorry, not enough water!");

            }

        else if (MILKPERCAPPUCINO<currentMilk)
        {
            System.out.println("Sorry, not enough milk!");

        }
        else if (BEANSPERCAPPUCINO<currentBeans)
        {
            System.out.println("Sorry, not enough beans!");

        }
        else if (currentNumberOfCups==0)
        {
            System.out.println("Sorry, not enough cups!");
        }



        }//end of cappucino

    else if (userOption.equals("back"))
    {
        determineMode();
    }

determineMode();
    }//end of buy method

public static void fill()
{
Scanner scan = new Scanner(System.in);
    System.out.println("Write how many ml of water you want to add:");
    currentWater+= scan.nextInt();
    System.out.println("Write how many ml of milk you want to add:");
    currentMilk+= scan.nextInt();
    System.out.println("Write how many grams of coffee beans you want to add:");
    currentBeans+= scan.nextInt();
    System.out.println("Write how many disposable cups you want to add:");
    currentNumberOfCups+= scan.nextInt();


   determineMode();

}


public static void take()
{


    System.out.println("I gave you $"+ currentMoney );
    currentMoney=0;

determineMode();
}


public static boolean checkResources(int waterNeeded, int milkNeeded, int beansNeeded, int cupsNeeded)
{
    boolean enoughWater = waterNeeded<currentWater;
    boolean enoughMilk = milkNeeded<currentMilk;
    boolean enoughBeans = beansNeeded<currentBeans;
    boolean enoughCups = cupsNeeded<currentNumberOfCups;


    if (waterNeeded<currentWater &&
            milkNeeded<currentMilk &&
            beansNeeded<currentBeans &&
    cupsNeeded<currentNumberOfCups)
    {
        return true;
    }
    else
        return false;

}






    public static void main(String[] args) {

determineMode();



//










//        System.out.println("Starting to make a coffee");
//        System.out.println("Grinding coffee beans");
//        System.out.println("Boiling water");
//        System.out.println("Mixing boiled water with crushed coffee beans");
//        System.out.println("Pouring coffee into the cup");
//        System.out.println("Pouring some milk into the cup");
//        System.out.println("Coffee is ready!");

//        System.out.println("Write how many cups of coffee you will need:");
//        int cupsofCoffeeNeeded = scan.nextInt();
//        int water = cupsofCoffeeNeeded * WATERPERCOFFEE;
//        int milk = cupsofCoffeeNeeded * MILKPERCOFFEE;
//        int beans = cupsofCoffeeNeeded * BEANSPERCOFFEE;
//        System.out.println("For " + cupsofCoffeeNeeded + " cups of coffee you will need:\n" +
//                ""+ water + " ml of water\n"+ milk + " ml of milk\n"+ beans+ " g of coffee" +
//                "beans");

//        System.out.println("Write how many ml of water the coffee machine has:");
//        int waterInMachine = scan.nextInt();
//        System.out.println("Write how many ml of milk the coffee machine has:");
//        int milkInMachine = scan.nextInt();
//        System.out.println("Write how many grams of coffee beans the coffee machine has:");
//        int beansInMachine = scan.nextInt();
//        System.out.println("Write how many cups of coffee you will need:");
//        int cupsNeeded = scan.nextInt();
//
//        int waterNeeded = cupsNeeded * WATERPERCOFFEE;
//        int milkNeeded = cupsNeeded * MILKPERCOFFEE;
//        int beansNeeded = cupsNeeded * BEANSPERCOFFEE;
//
//       //i'll need to pick the lowest # from the ingredients able to make a cup.
//
//        int maxCupsOfCoffeeFromWater = waterInMachine / WATERPERCOFFEE;
//        int maxCupsOfCoffeeFromMilk = milkInMachine / MILKPERCOFFEE;
//        int maxCupsOfCoffeeFromBeans = beansInMachine /BEANSPERCOFFEE;
//        int [] maxCupsOfCoffee = {maxCupsOfCoffeeFromBeans, maxCupsOfCoffeeFromMilk, maxCupsOfCoffeeFromWater};
//
//        int actualMaximumCupsOfCoffee = maxCupsOfCoffee[0];
//        for (int i=0; i<maxCupsOfCoffee.length; i++)
//        {
//            if (maxCupsOfCoffee[i]<actualMaximumCupsOfCoffee)
//            {
//
//                actualMaximumCupsOfCoffee = maxCupsOfCoffee[i];
//
//            }
//
//        }
//        //now I have my actual max. Now I compare that to how many they want.
//
//        if (cupsNeeded==actualMaximumCupsOfCoffee)
//        {
//            System.out.println("Yes, I can make that amount of coffee");
//        }
//        else if (cupsNeeded>actualMaximumCupsOfCoffee)
//        {
//
//            System.out.println("No, I can only make " + actualMaximumCupsOfCoffee + " cup(s) of coffee");
//
//        }
//        else if (cupsNeeded<actualMaximumCupsOfCoffee)
//        {
//
//            System.out.println("Yes, I can make that amount of coffee (and even " +
//                    (actualMaximumCupsOfCoffee - cupsNeeded) + " more than that)");
//        }

    }






}
