public class C_Random {

    /**
     * First phase of randomizing that displays a random element of the periodic table based on the user's choice of element number range.
     * 
     * @param boolean tryAgain - whether the method was called again due to an invalid user input.
     */
    public static void userChooseRange(boolean tryAgain) {
        System.out.println("\nWhat range for element numbers do you want to randomly choose and display?");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("1 - Random Element from 1 to 30");
        System.out.println("2 - Random Element from 31 to 60");
        System.out.println("3 - Random Element from 61 to 90");
        System.out.println("4 - Random Element from 91 to 118");
        System.out.println("5 - Random Element with any atomic number");
        System.out.println("\n" + (tryAgain ? "You did not choose a valid option. " : "") + "Type and enter the number of the option you want or type and enter -1 to go back:");

        Main.selected = Main.scan.nextLine();
        Main.intSelected = Main.isNumeric(Main.selected) ? Integer.parseInt(Main.selected) : -10;

        if(Main.intSelected >= 1 && Main.intSelected <= 5) {
            Element.randomElement(Main.intSelected).viewElement();
            userDone();
        }
        else if(Main.selected.equals("-1")) Main.userMain(false);
        else userChooseRange(true);
    }

    /**
     * Allows the user to go back to the main menu by typing and entering anything.
     */
    public static void userDone() {
        System.out.println("\nType and enter anything when you want to continue:");
        Main.selected = Main.scan.nextLine();
        Main.userMain(false);
    }

}