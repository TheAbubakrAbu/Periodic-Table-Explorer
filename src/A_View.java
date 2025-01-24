public class A_View {
    
    /**
     * Displays the elements of the periodic table and allows the user to view an element.
     * 
     * @param boolean tryAgain - whether the method was called again due to an invalid user input.
     */
    public static void displayElements(boolean tryAgain) {
        Main.printLine(true);
        for(int i = 0; i < 118; i++) System.out.println(Element.elements[i]);
        System.out.println("\n" + (tryAgain ? "You did not choose a valid option. Please try again.\n" : "") + "Type and enter the element number you want to view, or type and enter -1 or 0 to go home:");

        Main.selected = Main.scan.nextLine();
        Main.intSelected = Main.isNumeric(Main.selected) ? Integer.parseInt(Main.selected) : -10;

        if(Main.intSelected >= 1 && Main.intSelected <= 118) {new Element(Main.intSelected).viewElement(); userDone();}
        else if(Main.selected.equals("-1")) Main.userMain(false);
        else if(Main.selected.equals("0")) Main.userMain(false);
        else displayElements(true);
    }

    /**
     * Allows the user to go back to the main menu or allows them to view all elements again.
     */
    private static void userDone() {
        System.out.println("\nType and enter anything when you want to go home or type and enter -1 to go back:");
        Main.selected = Main.scan.nextLine();

        if(Main.selected.equals("-1")) {
            displayElements(false);
        } else {
            Main.userMain(false);
        }
    }

}