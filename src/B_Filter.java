import java.util.ArrayList;

public class B_Filter {
    
    // The way that the user wants to filter the elements of the periodic table.
    private static int option;

    // The ArrayList that contains the filtered elements.
    private static ArrayList<String> filteredElements;
    
    /**
     * First phase of filtering where the user chooses how to filter the elements of the periodic table (1).
     * 
     * @param boolean tryAgain - whether the method was called again due to an invalid user input.
     */
    public static void userChooseFilter1(boolean tryAgain) {
        System.out.println("\nHow would you like to filter the elements of the periodic table?");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("1 - Filter by name");
        System.out.println("2 - Filter by symbol");
        System.out.println("3 - Filter by number");
        System.out.println("4 - Filter by phase");
        System.out.println("5 - Filter by type");
        System.out.println("6 - Filter by period");
        System.out.println("7 - Filter by group");
        System.out.println("8 - Filter by weight");
        System.out.println("9 - Filter by density");
        System.out.println("10 - Filter by melting point");
        System.out.println("11 - Filter by boiling point");
        System.out.println("\n" + (tryAgain ? "You did not choose a valid option. " : "") + "Type and enter the number of the option you want or type and enter -1 to go back:");

        Main.selected = Main.scan.nextLine();
        Main.intSelected = Main.isNumeric(Main.selected) ? Integer.parseInt(Main.selected) : -10;

        if(Main.intSelected >= 1 && Main.intSelected <= 11) {
            userChooseFilter2(Main.intSelected, false);
        } else if(Main.selected.equals("-1")) {
            Main.userMain(false);
        } else {
            userChooseFilter1(true);
        }
    }

    /**
     * Second phase of filtering where the user decides how to filter the elements of the periodic table (2).
     * 
     * @param boolean int type - the way that the user wants to filter the elements of the periodic table, value is given to option.
            1 - Filter by name.
            2 - Filter by symbol.
            3 - Filter by number.
            4 - Filter by phase.
            5 - Filter by type.
            6 - Filter by period.
            7 - Filter by group.
            8 - Filter by weight.
            9 - Filter by density.
            10 - Filter by melting point.
            11 - Filter by boiling point.
     * @param boolean tryAgain - whether the method was called again due to an invalid user input.
     */
    private static void userChooseFilter2(int type, boolean tryAgain) {
        option = type;

        String[] options1 = {"letters (names)", "letters (symbols)", "element numbers", "element phases", "element types", "periods", "groups", "weights", "densities", "melting points", "boiling points"};
        String[][] options2 = {
            {"A, B, C", "D, E, F", "G, H, I", "J, K, L", "M, N, O", "P, Q, R", "S, T, U", "V, W, X", "Y, Z"}, // 1
            {"A, B, C", "D, E, F", "G, H, I", "J, K, L", "M, N, O", "P, Q, R", "S, T, U", "V, W, X", "Y, Z"}, // 2
            {"1 to 20", "21 to 40", "41 to 60", "61 to 80", "81 to 100", "101 to 118"}, // 3
            {"Solid", "Gas", "Liquid", "Expected to be Solid"}, // 4
            {"Non-Metal", "Semi-Metal", "Metal", "Unknown"}, // 5
            {"Period 1", "Period 2", "Period 3", "Period 4", "Period 5", "Period 6", "Period 7"}, // 6
            {"No Definitive Group", "Noble Gas", "Alkali Metal", "Alkaline Earth Metal", "Metalloid", "Non-Metal", "Halogen", "Poor Metal", "Transition Metal", "Rare Earth Metal", "Actinide Metal", "Superheavy Element"}, // 7
            {"1 to 50", "51 to 100", "101 to 150", "151 to 200", "201 to 250", "251 to 300"}, // 8
            {"0 to 5", "5 to 10", "10 to 15", "15 to 25", "Unknown"}, // 9
            {"-500 to 500", "500 to 1750", "1750 to 3000", "3000 to 7000", "Unknown"}, // 10
            {"-500 to 500", "500 to 1750", "1750 to 3000", "3000 to 7000", "7000 to 11000", "Unknown"} // 11
        };

        String[][] letters = {
            {"A", "D", "G", "J", "M", "P", "S", "V", "Y"},
            {"B", "E", "H", "K", "N", "Q", "T", "W", "Z"},
            {"C", "F", "I", "L", "O", "R", "U", "X", ""}
        };
        String[][] numbers = {
            {"1", "21", "41", "61", "81", "101"},
            {"20", "40", "60", "80", "100", "118"}
        };
        String[] phases = {"Solid", "Gas", "Liquid", "Expected to be Solid"};
        String[] types = {"Non-Metal", "Semi-Metal", "Metal", "Unknown"};
        String[] periods = {"1", "2", "3", "4", "5", "6", "7"};
        String[] groups = {"No definitive group", "Noble Gas", "Alkali Metal", "Alkaline Earth Metal", "Metalloid", "Non-Metal", "Halogen", "Poor Metal", "Transition Metal", "Rare Earth Metal", "Actinide Metal", "Superheavy Element"};
        String[][] weights = {
            {"1", "50", "100", "150", "200", "250"},
            {"50", "100", "150", "200", "250", "300"}
        };
        String[][] densities = {
            {"0", "5", "10", "15"},
            {"5", "10", "15", "25"}
        };
        String[][] meltingPoints = {
            {"-500", "500", "1750", "3000"},
            {"500", "1750", "3000", "7000"}
        };
        String[][] boilingPoints = {
            {"-500", "500", "1750", "3000", "7000"},
            {"500", "1750", "3000", "7000", "11000"}
        };

        System.out.println("\nHow would you like to filter by " + options1[option - 1] + " and display those elements?" + (option == 9 || option == 10 || option == 11 ? ("first number is inclusive, and the second number is exclusive") : ""));
        System.out.println("--------------------------------------------------------------------------------------------");
        for(int i = 0; i < options2[option - 1].length; i++) {
            System.out.println((i + 1) + " - " + options2[option - 1][i]);
        }
        System.out.println("\n" + (tryAgain ? "You did not choose a valid option. " : "") + "Type and enter the number of the option you want or type and enter -1 to go back:");
        
        Main.selected = Main.scan.nextLine();
        Main.intSelected = Main.isNumeric(Main.selected) ? Integer.parseInt(Main.selected) : -10;

        if(Main.intSelected >= 1 && Main.intSelected <= options2[option - 1].length) {
            filteredElements = new ArrayList<String>();
            if(option == 1) {
                filterLetter(Element.names, letters[0][Main.intSelected - 1], letters[1][Main.intSelected - 1], letters[2][Main.intSelected - 1]);
            } else if(option == 2) {
                filterLetter(Element.symbols, letters[0][Main.intSelected - 1], letters[1][Main.intSelected - 1], letters[2][Main.intSelected - 1]);
            } else if(option == 3) {
                filterNumber(true, Element.numbers, numbers[0][Main.intSelected - 1], numbers[1][Main.intSelected - 1]);
            } else if(option == 4) {
                filterEqual(Element.phases, phases[Main.intSelected - 1]);
            } else if(option == 5) {
                filterEqual(Element.types, types[Main.intSelected - 1]);
            } else if(option == 6) {
                filterEqual(Element.periods, periods[Main.intSelected - 1]);
            } else if(option == 7) {
                filterEqual(Element.groups, groups[Main.intSelected - 1]);
            } else if(option == 8) {
                filterNumber(true, Element.weights, weights[0][Main.intSelected - 1], weights[1][Main.intSelected - 1]);
            } else if(option == 9) {
                if(Main.intSelected >= 1 && Main.intSelected <= 4) {
                    filterNumber(false, Element.densities, densities[0][Main.intSelected - 1], densities[1][Main.intSelected - 1]);
                } else {
                    filterEqual(Element.densities, "Unknown");
                }
            } else if(option == 10) {
                if(Main.intSelected >= 1 && Main.intSelected <= 4) {
                    filterNumber(false, Element.meltingPoints, meltingPoints[0][Main.intSelected - 1], meltingPoints[1][Main.intSelected - 1]);
                } else if(Main.intSelected == 5) {
                    filterEqual(Element.meltingPoints, "Unknown");
                }
            } else if(option == 11) {
                if(Main.intSelected >= 1 && Main.intSelected <= 5) {
                    filterNumber(false, Element.boilingPoints, boilingPoints[0][Main.intSelected - 1], boilingPoints[1][Main.intSelected - 1]);
                } else if(Main.intSelected == 6) {
                    filterEqual(Element.boilingPoints, "Unknown");
                }
            }
        } else if(Main.selected.equals("-1")) {
            userChooseFilter1(false);
        } else {
            userChooseFilter2(option, true);
        }
    }
    
    /**
     * Third phase of interaction two that filters the elements of the periodic table if it involves checking the first letter of the elements' names or symbols.
     * 
     * @param String[] array - the array of elements where the first letter is being checked (names or symbols).
     * @param String letter1 - checks to see if the first letter of an element's attribute is equal to this.
     * @param String letter2 - checks to see if the first letter of an element's attribute is equal to this.
     * @param String letter3 - checks to see if the first letter of an element's attribute is equal to this.
     */
    private static void filterLetter(String[] array, String letter1, String letter2, String letter3) {
        for(int i = 0; i < 118; i++) {
            if(array[i].substring(0, 1).equals(letter1) || array[i].substring(0, 1).equals(letter2) || array[i].substring(0, 1).equals(letter3)) {
                filteredElements.add(Element.numbers[i] + " - " + Element.names[i] + " (" + Element.symbols[i] + ")");
            }
        }
        displayElements(false);
    }

    /**
     * Third phase of filtering that filters the elements of the periodic table if it involves checking if a number is in between a range.
     * 
     * @param String[] array - the array of elements where the numbers are being checked to see if they are in range (numbers, periods, weights, densities, melting points, or boiling points).
     * @param boolean equalTo - if true, number2 is inclusive, if false, number2 is exclusive.
     * @param String number1 - the first number in the range that is checked (inclusive).
     * @param String number2 - the last number in the range that is checked (inclusive if equalTo is true, exclusive if equalTo is false).
     */
    private static void filterNumber(boolean equalTo, String[] array, String number1, String number2) {
        for(int i = 0; i < 118; i++) {
            if(equalTo) {
                if(!array[i].equals("Unknown") && Double.parseDouble(array[i]) >= Double.parseDouble(number1) && Double.parseDouble(array[i]) <= Double.parseDouble(number2)) {
                    filteredElements.add(Element.numbers[i] + " - " + Element.names[i] + " (" + Element.symbols[i] + ")");
                }
            } else {
                if(!array[i].equals("Unknown") && Double.parseDouble(array[i]) >= Double.parseDouble(number1) && Double.parseDouble(array[i]) < Double.parseDouble(number2)) {
                    filteredElements.add(Element.numbers[i] + " - " + Element.names[i] + " (" + Element.symbols[i] + ")");
                }
            }
        }
        displayElements(false);
    }

    /**
     * Third phase of filtering that filters the elements of the periodic table if it involves checking if an attribute is the same.
     * 
     * @param String[] array - the array of elements that is being checked for equality (phases, types, groups, and other lists if the attributes are unknown).
     * @param String equal - the attribute that is being checked for equality.
     */
    private static void filterEqual(String[] array, String equal) {
        for(int i = 0; i < 118; i++) {
            if(array[i].equals(equal)) {
                filteredElements.add(Element.numbers[i] + " - " + Element.names[i] + " (" + Element.symbols[i] + ")");
            }
        }
        if(equal.equals("Unknown")) {option = 9;}
        displayElements(false);
    }

    /**
     * Fourth phase of filtering that displays the filtered elements and allows the user to view an element.
     * 
     * @param boolean tryAgain - whether the method was called again due to an invalid user input.
     */
    private static void displayElements(boolean tryAgain) {
        System.out.println("\n--------------------------------------------------------------------------------------------");
        for(int i = 0; i < filteredElements.size(); i++) {
            System.out.println(filteredElements.get(i));
        }
        System.out.println("\n" + (tryAgain ? "You did not choose a valid option. " : "") + "Type and enter the number of the option you want or type and enter -1 to go back:");

        Main.selected = Main.scan.nextLine();
        Main.intSelected = Main.isNumeric(Main.selected) ? Integer.parseInt(Main.selected) : -10;

        if(Main.selected.equals("-1")) userChooseFilter2(option, false);
        else if(Main.intSelected >= 1 && Main.intSelected <= 118) {
            new Element(Main.intSelected).viewElement();
            doneInteract();
        }
        else displayElements(true);
    }

    /**
     * Allows the user to go back to the main menu or allows them to view the filtered list again.
     */
    private static void doneInteract() {
        System.out.println("\nType and enter anything when you want to go home or type and enter -1 to go back:");
        Main.selected = Main.scan.nextLine();

        if(Main.selected.equals("-1")) displayElements(false);
        else Main.userMain(false);
    }
    
}