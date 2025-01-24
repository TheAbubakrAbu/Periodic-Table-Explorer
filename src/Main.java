import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    // The Scanner object that takes user inputs.
    public static Scanner scan = new Scanner(System.in);
    
    // String that stores the user's selection.
    public static String selected;

    // Integer version of the user's selection.
    public static int intSelected;

    // Boolean that holds whether or not the program is being run for the first time.
    public static boolean first = true;

    /**
     * Asks the user to select one of the five options in the main menu, then calls the corresponding class and its first phase.
     * 
     * @param boolean tryAgain - whether the method was called again due to an invalid user input
     */
    public static void userMain(boolean tryAgain) {
        printLine(false);
        if(first) {
            System.out.println("This is a program that allows you to interact with and learn from the periodic table.\n");
            first = false;
        }
        System.out.println("How would you like to interact with the elements of the periodic table?");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("1 - View all elements");
        System.out.println("2 - Filter and view elements");
        System.out.println("3 - View a random element");
        System.out.println("4 - Search for an element");
        System.out.println("5 - Test your element knowledge");

        System.out.println("\n" + (tryAgain ? "You did not choose a valid option. Please try again.\n" : "") + "Type and enter the number of the option you want:");

        selected = scan.nextLine();

        if(selected.equals("1")) A_View.displayElements(false);
        else if(selected.equals("2")) B_Filter.userChooseFilter1(false);
        else if(selected.equals("3")) C_Random.userChooseRange(false);
        else if(selected.equals("4")) D_Search.userChooseSearch(false);
        else if(selected.equals("5")) E_Test.userChooseOption1(false);
        else userMain(true);
    }

    /**
     * Checks if a given string can be converted to a number.
     * 
     * Credit to MV, Thanoshan. “Java String to Int – How to Convert a String to an Integer.” FreeCodeCamp.org, FreeCodeCamp.org, 23 Nov. 2020, https://www.freecodecamp.org/news/java-string-to-int-how-to-convert-a-string-to-an-integer/. 
     &
     * @param String value - the string to be checked.
     * 
     * @return boolean indicating whether the string can be converted to a number or not (true if can be converted, false if can't be converted).
     */
    public static boolean isNumeric(String str){
        return str != null && str.matches("[0-9]+");
    }

    /**
     * Prints many empty lines and then prints a border.
     */
    public static void printLine(boolean border) {
        for(int i = 0; i < 50; i++) {
            System.out.println();
        }
        if(border) System.out.println("--------------------------------------------------------------------------------------------");
    }

    /**
    * Main method where the program is first run
    */
    public static void main(String[] args) {
        Element.initializeElements();
        userMain(false);
    }

}