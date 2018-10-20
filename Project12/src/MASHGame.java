import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 * Lesson 12: Activity - ArrayLists
 *
 * @author CS121 Instructors
 * @version Fall 2018
 * @author Cameron Bentley
 */
public class MASHGame {

    public static void main(String[] args) {

        /* Define list of options */
        ArrayList<String> homeList = new ArrayList<String>();
        ArrayList<String> wifeList = new ArrayList<String>();
        ArrayList<String> husbandList = new ArrayList<String>();
        ArrayList<String> occupationList = new ArrayList<String>();
        ArrayList<String> transportationList = new ArrayList<String>();
        ArrayList<String> hometownList = new ArrayList<String>();

        /* Add items to home list */
        homeList.add("mansion");
        homeList.add("apartment");
        homeList.add("shack");
        homeList.add("house");
        homeList.add("flat");
        homeList.add("manor");
        homeList.add("estate");
        homeList.add("bungalow");

        /* TODO: 1. Add items to femaleSpouseList */
        wifeList.add("Kelly");
        wifeList.add("Jessica");
        wifeList.add("Nicole");
        wifeList.add("Rebecca");
        wifeList.add("Anabelle");
        wifeList.add("Cecilia");

        /* TODO: 2. Add items to maleSpouseList */
        husbandList.add("Reginald");
        husbandList.add("Spoonsworth");
        husbandList.add("Squidward");
        husbandList.add("Tiny Tim");
        husbandList.add("Peter");
        husbandList.add("George");

        /* TODO: 3. Add items to occupationList */
        occupationList.add("architect");
        occupationList.add("ambulance chaser");
        occupationList.add("lego designer");
        occupationList.add("pogo-stick inspector");
        occupationList.add("flamingo reviewer");

        /* TODO: 4. Add items to transportationList */
        transportationList.add("1998 Jeep Cherokee");
        transportationList.add("1967 Shelby Mustang");
        transportationList.add("Bentley Continental");
        transportationList.add("Tesla Model 3");
        transportationList.add("Millennium Falcon");

        /* TODO: 5. Add items to hometownList */
        hometownList.add("Bree");
        hometownList.add("Winterfell");
        hometownList.add("Minas Tirith");
        hometownList.add("Kaer Morhen");

        /* Print the database */
        System.out.println("--------------------- Future Possibilities Database ------------------------");
        System.out.print("Home List: ");
        for (String item : homeList) {
            System.out.print(item + " ");
        }
        System.out.println();

        /*
         * TODO: 6. Print the items in the femaleSpouseList using the ArrayList
         * toString() method
         */
        System.out.println("Wife List: " + wifeList.toString());

        /*
         * TODO: 7. Print the items in the maleSpouseList using a for loop (IE: use
         * indexes to print items )
         */
        System.out.print("Husband list: ");
        for (int i = 0; i < husbandList.size(); i++) {
            System.out.print(husbandList.get(i) + ',' + " ");
        }
        System.out.println();

        /*
         * TODO: 8. Print the items in the occupationList using the ArrayList iterator
         * and a while loop
         */
        System.out.print("Occupation list: ");
        Iterator<String> i = occupationList.iterator();
        while (i.hasNext()) {
            System.out.print(i.next() + ',' + " ");
        }
        System.out.println();

        /* TODO: 9. Print the items in the transportationList using a for each loop */
        System.out.print("Transportation List: ");
        for (String transport : transportationList) {
            System.out.print(transport + ',' + " ");
        }
        System.out.println();

        /*
         * TODO: 10. Print the items in the hometownList using the method of your choice
         */
        System.out.print("Hometown List: ");
        for (String hometown : hometownList) {
            System.out.print(hometown + ',' + " ");
        }
        System.out.println();

        System.out.println("----------------------------------------------------------------------------");
        System.out.println("\n");

        /* Ask the player for their name */
        Scanner kbd = new Scanner(System.in);
        System.out.print("Please enter your name: ");
        String name = kbd.nextLine();
        // kbd.close();
        System.out.println("\n\n");

        /* Randomly choose items from each List */
        Random rand = new Random();
        String firstHome = homeList.get(rand.nextInt(homeList.size()));

        /*
         * TODO: 11. Use rand object to select each of the following future components
         * from above lists.
         */
        String secondHome = homeList.get(rand.nextInt(homeList.size()));
        String occupation = occupationList.get(rand.nextInt(occupationList.size()));
        String transportation = transportationList.get(rand.nextInt(transportationList.size()));
        String hometown = hometownList.get(rand.nextInt(hometownList.size()));

        /*
         * TODO: 12. Use the coin to determine whether player's spouse is male or
         * female, then randomly select spouse from the corresponding list.
         */
        boolean coin = rand.nextBoolean();
        String spouse;

        if (coin == true) {
            spouse = wifeList.get(rand.nextInt(wifeList.size()));
        } else {
            spouse = husbandList.get(rand.nextInt(husbandList.size()));
        }

        /* Randomly choose number of years player will be married */
        int yearsOfMarriage = rand.nextInt(30);

        /* Print the player's future */
        System.out.println("Welcome " + name + ", this is your future...");
        System.out.println("You will marry " + spouse + " and live in a " + firstHome + ".");
        System.out.println("After " + yearsOfMarriage + (yearsOfMarriage == 1 ? " year" : " years")
                + " of marriage, you will finally get your dream job of being a " + occupation + ".");
        System.out.println("Your family will move to a " + secondHome + " in " + hometown + " where you will drive your "
                + transportation + " to work each day.");

    }

}
