import java.util.ArrayList;

public class D_Search {

    // How the user wants to search for an element.
    private static int option;

    // String array that is being searched from.
    private static String[] currentArray;

    // Element array that contains new elements based on the search query.
    private static ArrayList<Element> searchArray;
    
    /**
     * First phase of searching where the user decides how they want to search.
     * 
     * @param boolean tryAgain - whether the method was called again due to an invalid user input.
     */
    public static void userChooseSearch(boolean tryAgain) {
        option = 0;
        
        Main.printLine(false);
        System.out.println("How would you like to search for the elements of the periodic table?");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("1 - Name");
        System.out.println("2 - Symbol");
        System.out.println("\n" + (tryAgain ? "You did not choose a valid option. Please try again.\n" : "") + "Type and enter the option you want or type and enter -1 or 0 to go home:");

        Main.selected = Main.scan.nextLine();
        Main.intSelected = Main.isNumeric(Main.selected) ? Integer.parseInt(Main.selected) : -10;

        if(Main.intSelected >= 1 && Main.intSelected <= 2) {
            userSearch(Main.intSelected, false);
        } else if(Main.selected.equals("0")) {
            Main.userMain(false);
        } else if(Main.selected.equals("-1")) {
            Main.userMain(false);
        } else {
            userChooseSearch(true);
        }
    }
    
    /**
     * Second phase of searching where the user searches for an element.
     *
     * @param int type - how the user wants to search for an element.
            1 - Name
            2 - Symbol
     * @param boolean tryAgain - whether the method was called again due to an invalid user input.
     */
    private static void userSearch(int type, boolean tryAgain) {
        option = type;
        Main.printLine(false);
        System.out.println("\n" + (tryAgain ? "You did not choose a valid option. Please try again.\n" : "") + "Type and enter whatever you want to search for, type and enter -1 to go back, or type and enter 0 to go home:");
        System.out.println("--------------------------------------------------------------------------------------------");

        Main.selected = Main.scan.nextLine();

        if(Main.selected.equals("-1")) {
            userChooseSearch(false);
        } else if(Main.selected.equals("0")) {
            Main.userMain(false);
        } else if(!Main.selected.matches("[a-zA-Z]+")) {
            userSearch(option, true);
        } else {
            search(Main.selected);
        }
    }

/**
* Third phase of searching that gets the closest elements to the search query.
*
* @param String textInput - user input.
*/
private static void search(String textInput) {
    currentArray = Element.names;
    searchArray = new ArrayList<Element>();
    
    if(option == 2) currentArray = Element.symbols;

    // Check for an exact match
    for(int i = 0; i < 118; i++) {
        if(currentArray[i].equalsIgnoreCase(textInput)) {
            searchArray.add(Element.elements[i]);
            break;
        }
    }

    // Check for the first two letters
    if(textInput.length() >= 2) {
        for(int i = 0; i < 118; i++) {
            if(currentArray[i].toUpperCase().startsWith(textInput.toUpperCase().substring(0, 2)) && !searchArray.contains(Element.elements[i])) {
                searchArray.add(Element.elements[i]);
            }
        }
    }

    // Check for the first letter
    for(int i = 0; i < 118; i++) {
        if(currentArray[i].toUpperCase().startsWith(textInput.toUpperCase().substring(0, 1)) && !searchArray.contains(Element.elements[i])) {
            searchArray.add(Element.elements[i]);
        }
    }

    // Check for two letters
    if(searchArray.size() < 10) {
        if(textInput.length() > 2) {
            for(int i = 0; i < 118; i++) {
                for(int j = 0; j < (textInput.length() < currentArray[i].length() ? textInput.length() - 2 : currentArray[i].length() - 2); j++) {
                    if(searchArray.size() > 9) {
                        displayElements(false);
                        return;
                    }
                    if(currentArray[i].substring(j, j + 2).equalsIgnoreCase(textInput.substring(j, j + 2)) && !searchArray.contains(Element.elements[i])) {
                        searchArray.add(Element.elements[i]);
                    }
                }
            }
        }
    }

    displayElements(false);
}

    /**
     * Fourth phase of searching that displays the closest elements to the search query and allows users to view an element.
     *
     * @param boolean tryAgain - whether the method was called again due to an invalid user input.
     */
    private static void displayElements(boolean tryAgain) {
        Main.printLine(true);
        if(searchArray.size() > 0) {
            for(int i = 0; i < searchArray.size(); i++) {
                System.out.println(searchArray.get(i));
            }
            System.out.println("\n" + (tryAgain ? "You did not choose a valid option. Please try again.\n" : "") + "Type and enter the element number you want to view, type and enter -1 to go back, or type and enter 0 to go home:");
        } else {
            System.out.println((tryAgain ? "You did not choose a valid option. Please try again.\n" : "") + "No elements found. Type and enter -1 to go back or type and enter 0 to go home:");
        }

        Main.selected = Main.scan.nextLine();
        Main.intSelected = Main.isNumeric(Main.selected) ? Integer.parseInt(Main.selected) : -10;

        if(Main.intSelected >= 1 && Main.intSelected <= 118) {
            new Element(Main.intSelected).viewElement();
            userDone(option);
        } else if(Main.selected.equals("-1")) {
            userSearch(option, false);
        } else if(Main.selected.equals("0")) {
            Main.userMain(false);
        } else {
            displayElements(true);
        }
    }

    /**
     * Allows the user to go back to the main menu or allows them to view the searched list again.
     */
    private static void userDone(int option) {
        System.out.println("\nType and enter anything when you want to go home or type and enter -1 to go back:");
        Main.selected = Main.scan.nextLine();

        if(Main.selected.equals("-1")) {
            displayElements(false);
        } else {
            Main.userMain(false);
        }
    }

}