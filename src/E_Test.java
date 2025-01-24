public class E_Test {
    
    // Number of correct answers.
    private static int score;

    // Whether the test is finished.
    private static boolean done;

    // How the user answers the question (1).
            // 1 - Free Response
            // 2 - Multiple Choice
            // 3 - Mix of Both
    private static int option1;

    // How the user answers the question (2).
            // 1 - Name
            // 2 - Symbol
            // 3 - Mix of Both
    private static int option2;

    // What range of element numbers the answers fall in.
            // 1 - (1 to 30)
            // 2 - (31 to 60)
            // 3 - (61 to 90)
            // 4 - (91 to 118)
            // 5 - Any atomic number
    private static int option3;

    // How many questions the user wants to answer.
            // 1 - 5 Questions
            // 2 - 10 Questions
            // 3 - 15 Questions
            // 4 - 20 Questions
            // 5 - Custom (user input)
    private static int number;

   // The question number that the user is on during the test.
    private static int numberOn;

    // Either "name" or "symbol" depending on option2.
    private static String given;
    
    // The name or symbol of the element depending on option2.
    private static String givenVar;

    // The opposite of given (if given is name, lookingFor is symbol and vice versa).
    private static String lookingFor;

    // The opposite of givenVar (if givenVar is the element's name, lookingForVar is the element's symbol and vice versa).
    private static String lookingForVar;

    // The Element object which is the correct answer.
    private static Element answer;

    // Index of the next right answer.
    private static int index;

    // Index of the answer for multiple choice questions.
    private static int rightIndex;

    // Element objects that are fake answers if the user is answering via multiple choice.
    private static Element element1;
    private static Element element2;
    private static Element element3;

    // The array that contains the randomly sorted four answers (element1, element2, element3, answer) if the user is answering via multiple choice.
    private static Element[] sortedTestElements;

    // Element 2D array where in one row, it contains all the answers in the test, and another row has all the answers that the user got wrong on the test.
    private static Element[][] answers;

    // Boolean variable that holds whether or not the user got an answer wrong on the test.
    private static boolean isWrongAnswer;

    // What hint phase the user is in (how many hints they have received).
    private static int hintPhase;

    /**
     * This method checks if a given value is present in an array of Element objects.
     * 
     * @param Element[] array - array of Element objects to check the value in.
     * @param Element value - The value to be checked for in the array.
     * 
     * @return boolean indicating whether the value was found in the array or not (true if found, false if not).
     */
    public static boolean isPresent(Element[] array, Element value) {
        if(value == null) {return false;}
        for(int i = 0; i < array.length; i++) {
            if(array[i] != null && value.equals(array[i])) {
                return true;
            }
        }
        return false;
    }

    /**
     * First phase of testing where the user decides how to answer the question (multiple choice, free response, or a mix of both).
     * 
     * @param boolean tryAgain - whether the method was called again due to an invalid user input.
     */
    public static void userChooseOption1(boolean tryAgain) {
        number = 0;
        option1 = 0;
        option2 = 0;
        option3 = 0;
        index = 1;

        Main.printLine(false);
        System.out.println("How would you like to answer the questions on the test?");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("1 - Answer with free response");
        System.out.println("2 - Answer with multiple choice");
        System.out.println("3 - Answer with a mix of both");
        System.out.println("\n" + (tryAgain ? "You did not choose a valid option. Please try again.\n" : "") + "Type and enter the number of the option you want or type and enter -1 or 0 to go home:");

        Main.selected = Main.scan.nextLine();
        Main.intSelected = Main.isNumeric(Main.selected) ? Integer.parseInt(Main.selected) : -10;

        if(Main.intSelected >= 1 && Main.intSelected <= 3) {
            option1 = Main.intSelected;
            userChooseOption2(false);
        } else if(Main.selected.equals("-1")) {
            Main.userMain(false);
        } else if(Main.selected.equals("0")) {
            Main.userMain(false);
        } else {
            userChooseOption1(true);
        }
    }

    /**
     * Second phase of testing where the user decides how to answer the question (name, symbol, or a mix of both).
     * 
     * @param boolean tryAgain - whether the method was called again due to an invalid user input.
     */
    private static void userChooseOption2(boolean tryAgain) {
        Main.printLine(false);
        System.out.println("How would you like to answer the questions on the test?");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("1 - Answer with element name");
        System.out.println("2 - Answer with element symbol");
        System.out.println("3 - Answer with a mix of both");
        System.out.println("\n" + (tryAgain ? "You did not choose a valid option. Please try again.\n" : "") + "Type and enter the number of the option you want, type and enter -1 to go back, or type and enter 0 to go home:");

        Main.selected = Main.scan.nextLine();
        Main.intSelected = Main.isNumeric(Main.selected) ? Integer.parseInt(Main.selected) : -10;

        if(Main.intSelected >= 1 && Main.intSelected <= 3) {
            option2 = Main.intSelected;
            userChooseOption3(false);
        } else if(Main.selected.equals("-1")) {
            userChooseOption1(false);
        } else if(Main.selected.equals("0")) {
            Main.userMain(false);
        } else {
            userChooseOption2(true);
        }
    }

    /**
     * Third phase of testing where the user decides the range of the answers given (1 - 30, 31 - 60, 61 - 90, 91 - 118, any atomic number).
     * 
     * @param boolean tryAgain - whether the method was called again due to an invalid user input.
     */
    private static void userChooseOption3(boolean tryAgain) {
        Main.printLine(false);
        System.out.println("What atomic number range for elements do you want to be on the test?");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("1 - Elements from 1 to 30");
        System.out.println("2 - Elements from 31 to 60");
        System.out.println("3 - Elements from 61 to 90");
        System.out.println("4 - Elements from 91 to 118");
        System.out.println("5 - Elements with any atomic number");
        System.out.println("\n" + (tryAgain ? "You did not choose a valid option. Please try again.\n" : "") + "Type and enter the number of the option you want, type and enter -1 to go back, or type and enter 0 to go home:");

        Main.selected = Main.scan.nextLine();
        Main.intSelected = Main.isNumeric(Main.selected) ? Integer.parseInt(Main.selected) : -10;

        if(Main.intSelected >= 1 && Main.intSelected <= 5) {
            option3 = Main.intSelected;
            userChooseQuestions(false);
        } else if(Main.selected.equals("-1")) {
            userChooseOption2(false);
        }  else if(Main.selected.equals("0")) {
            Main.userMain(false);
        }else {
            userChooseOption3(true);
        }
    }

    /**
     * Fourth phase of testing where the user decides how many questions they want to choose (5, 10, 15, 20, custom).
     * 
     * @param boolean tryAgain - whether the method was called again due to an invalid user input.
     */
    private static void userChooseQuestions(boolean tryAgain) {
        Main.printLine(false);
        System.out.println("How many questions do you want on the test?");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("1 - 5 Questions");
        System.out.println("2 - 10 Questions");
        System.out.println("3 - 15 Questions");
        System.out.println("4 - 20 Questions");
        System.out.println("5 - Custom");
        System.out.println("\n" + (tryAgain ? "You did not choose a valid option. Please try again.\n" : "") + "Type and enter the number of the option you want, type and enter -1 to go back, or type and enter 0 to go home:");

        Main.selected = Main.scan.nextLine();
        Main.intSelected = Main.isNumeric(Main.selected) ? Integer.parseInt(Main.selected) : -10;

        if(Main.intSelected >= 1 && Main.intSelected <= 4) {
            number = Main.intSelected * 5;
            test();
        } else if(Main.intSelected == 5) {
            userChooseCustomQuestions(false);
        } else if(Main.selected.equals("-1")) {
            userChooseOption3(false);
        } else if(Main.selected.equals("0")) {
            Main.userMain(false);
        } else {
            userChooseQuestions(true);
        }
    }

    /**
     * Fourth phase of testing where the user decides how many questions they want to choose if number is equal to 5 meaning that they choose a custom number of questions.
     * 
     * @param boolean tryAgain - whether the method was called again due to an invalid user input.
     */
    private static void userChooseCustomQuestions(boolean tryAgain) {
        Main.printLine(false);
        System.out.println("\n" + (tryAgain ? "You did not choose a valid option. Please try again.\n" : "") + "Type and enter the number of questions you want to answer, type and enter -1 to go back, or type and enter 0 to go home:");
        System.out.println("--------------------------------------------------------------------------------------------");

        Main.selected = Main.scan.nextLine();
        Main.intSelected = Main.isNumeric(Main.selected) ? Integer.parseInt(Main.selected) : -10;

        if(option3 == 5 && Main.intSelected >= 1 && Main.intSelected <= 118) {
            number = Main.intSelected;
            test();
        } else if(option3 != 5 && Main.intSelected >= 1 && Main.intSelected <= 30) {
            number = Main.intSelected;
            test();
        } else if(Main.selected.equals("-1")) {
            userChooseQuestions(false);
        } else if(Main.selected.equals("0")) {
            Main.userMain(false);
        } else {
            userChooseCustomQuestions(true);
        }
    }
    
    /**
     * Shuffles an element array in random order.
     * 
     * @param Element[] array - the array that is to be shuffled.
     *
     * @return Element[] array that is shuffled.
     */
    private static Element[] shuffleArray(Element[] array) {
        Element[] shuffledArray = new Element[array.length];

        int i = 0;
        while(i < array.length) {
            int random = (int) (Math.random() * array.length);
            if(!isPresent(shuffledArray, array[random])) {
                shuffledArray[i] = array[random];
                i++;
            }
        }
        
        return shuffledArray;
    }

    /**
     * Test phase of testing where the test starts and where the other phases are controlled and called.
     * 
     * @param boolean testingAgain - whether or not the user is testing again.
     */
    private static void test() {
        answers = new Element[2][number];
        index = 0;
        score = 0;
        numberOn = 1;
        done = false;
        isWrongAnswer = false;

        Main.printLine(false);
        while(numberOn <= number && !done) {
            hintPhase = 0;

            do {
                answer = Element.randomElement(option3);
            } while(isPresent(answers[0], answer));

            answers[0][index] = answer;

            // If option1 is 3, then it randomly becomes either 1 or 2.
            int decide1 = (int) (Math.random() * 3) + 1;

            // If option2 is 3, then it randomly becomes either 1 or 2.
            int decide2 = (int) (Math.random() * 3) + 1;

            if(option2 == 1 || (option2 == 3 && decide2 == 1)) {
                lookingFor = "name";
                lookingForVar = answer.name;
                given = "symbol";
                givenVar = answer.symbol;
            } else {
                lookingFor = "symbol";
                lookingForVar = answer.symbol;
                given = "name";
                givenVar = answer.name;
            }

            if(option1 == 1 || (option1 == 3 && decide1 == 1)) {
                System.out.println("\nType and enter the " + lookingFor + " of the element " + '"' + givenVar + '"' + " (type and enter 0 to receive a hint) or type and enter -1 to end the test:");
                System.out.println("--------------------------------------------------------------------------------------------");
                userAnswersFR();
            } else {
                createMC(decide2);
            }
            
            if(done) return;

            answer = Element.randomElement(option3);
            index++;
            numberOn++;
        }
        userChooseDisplay(false);
    }

    /**
     * Option to receive a hint about an element if the user inputs 0.
     */
    private static void hint(int option, int decide) {
        hintPhase++;
        System.out.println();
        if(hintPhase == 1) {
            System.out.println("The element's phase is " + answer.phase);
        } else if(hintPhase == 2) {
            System.out.println("The element's type is " + answer.type);
        } else if(hintPhase == 3) {
            System.out.println("The element is in period " + answer.period);
        } else if(hintPhase == 4) {
            System.out.println("The element's group is " + answer.group);
        } else {
            System.out.println("You have no hints left.");
        }

        if(option == 1) {
            System.out.println("\nType and enter the " + lookingFor + " of the element " + '"' + givenVar + '"' + (hintPhase < 4 ? " (type and enter 0 to receive another hint)" : "") + " or enter -1 to end the test:");
            userAnswersFR();
        } else {
            System.out.println("--------------------------------------------------------------------------------------------");
            if(option2 == 1 || (option2 == 3 && decide == 1)) {
                System.out.println("1 - " + sortedTestElements[0].name);
                System.out.println("2 - " + sortedTestElements[1].name);
                System.out.println("3 - " + sortedTestElements[2].name);
                System.out.println("4 - " + sortedTestElements[3].name);
            } else {
                System.out.println("1 - " + sortedTestElements[0].symbol);
                System.out.println("2 - " + sortedTestElements[1].symbol);
                System.out.println("3 - " + sortedTestElements[2].symbol);
                System.out.println("4 - " + sortedTestElements[3].symbol);
            }
            System.out.println("\nType and enter the option of the element " + '"' + givenVar + '"' + (hintPhase < 4 ? " (type and enter 0 to receive another hint)" : "") + " or type and enter -1 to end the test:");
            userAnswersMC(decide);
        }
    }

    /**
     * Fifth phase of testing, if the user is answering a free response question, where the user enters an input and the input is compared to the correct answer.
     */
    private static void userAnswersFR() {
        Main.selected = Main.scan.nextLine();

        if(Main.selected.equals("-1")) {
            done = true;
            userChooseDisplay(false);
        } else if(Main.selected.equals("0")) {
            hint(1, 0);
        } else if(!Main.selected.matches("[a-zA-Z]+")) {
            System.out.println("\nYou did not choose a valid option. Please try again.\nType and enter the " + lookingFor + " of the element " + '"' + givenVar + '"' + " (type and enter 0 to receive a hint) or type and enter -1 to end the test:");
            userAnswersFR();
        } else {
            if(Main.selected.equalsIgnoreCase(lookingForVar)) {
                System.out.println("\nNice, you got it!");
                score++;
            } else {
                System.out.println("\nWrong, the correct answer was " + lookingForVar + ".");
                isWrongAnswer = true;
                answers[1][index] = answer;
            }
        }
    }

    /**
     * Creates and displays fake answers if the user is answering a multiple choice question.
     * 
     * @param int decide - randomly chosen integer that is only used if option2 equals 3 to randomly decide if the user answers with a name or symbol.
     */
    private static void createMC(int decide) {
        rightIndex = 1;
        do {
            element1 = Element.randomElement(option3);
            element2 = Element.randomElement(option3);
            element3 = Element.randomElement(option3);
        } while(element2.equals(element1) || element3.equals(element1) || element2.equals(element3) || answer.equals(element1) || answer.equals(element2) || answer.equals(element3));

        Element[] testElements = {element1, element2, element3, answer};
        sortedTestElements = shuffleArray(testElements);

        for(int i = 0; i < 4; i++) {
            if(sortedTestElements[i].equals(answer)) {
                rightIndex = i + 1;
            }
        }

        System.out.println("\n--------------------------------------------------------------------------------------------");
        if(option2 == 1 || (option2 == 3 && decide == 1)) {
            System.out.println("1 - " + sortedTestElements[0].name);
            System.out.println("2 - " + sortedTestElements[1].name);
            System.out.println("3 - " + sortedTestElements[2].name);
            System.out.println("4 - " + sortedTestElements[3].name);
        } else {
            System.out.println("1 - " + sortedTestElements[0].symbol);
            System.out.println("2 - " + sortedTestElements[1].symbol);
            System.out.println("3 - " + sortedTestElements[2].symbol);
            System.out.println("4 - " + sortedTestElements[3].symbol);
        }

        System.out.println("\nType and enter the option of the element " + '"' + givenVar + '"' + " (type and enter 0 to receive a hint) or type and enter -1 to end the test:");
        userAnswersMC(decide);
    }

    /**
     * Fifth phase of testing, if the user is answering a multiple choice question, where the user chooses one of the multiple choice options which is compared to the right answer.
     * 
     * @param int decide - randomly chosen integer that is only used if option2 equals 3 to randomly decide if the user answers with a name or symbol.
     */
    private static void userAnswersMC(int decide) {
        Main.selected = Main.scan.nextLine();
        Main.intSelected = Main.isNumeric(Main.selected) ? Integer.parseInt(Main.selected) : -10;

        if(Main.selected.equals("-1")) {
            done = true;
            userChooseDisplay(false);
        } else if(Main.selected.equals("0")) {
            hint(2, decide);
        } else if(Main.intSelected >= 1 && Main.intSelected <= 4) {
            if(Main.intSelected == rightIndex) {
                System.out.println("\nNice, you got it!");
                score++;
            } else {
                System.out.println("\nWrong, the correct answer was " + lookingForVar + " (" + rightIndex + ").");
                answers[1][index] = answer;
                isWrongAnswer = true;
            }
        } else {
            System.out.println("\n--------------------------------------------------------------------------------------------");
            if(option2 == 1 || (option2 == 3 && decide == 1)) {
                System.out.println("1 - " + sortedTestElements[0].name);
                System.out.println("2 - " + sortedTestElements[1].name);
                System.out.println("3 - " + sortedTestElements[2].name);
                System.out.println("4 - " + sortedTestElements[3].name);
            } else {
                System.out.println("1 - " + sortedTestElements[0].symbol);
                System.out.println("2 - " + sortedTestElements[1].symbol);
                System.out.println("3 - " + sortedTestElements[2].symbol);
                System.out.println("4 - " + sortedTestElements[3].symbol);
            }
            System.out.println("\nYou did not choose a valid option. Please try again.\nType and enter the option of the element " + '"' + givenVar + '"' + " or type and enter -1 to end the test:");
            userAnswersMC(decide);
        }
    }

    /**
     * Sixth phase of testing where the test is finished and the user sees their score and decides if they want to view their answers.
     * 
     * @param boolean tryAgain - whether the method was called again due to an invalid user input.
     */
    private static void userChooseDisplay(boolean tryAgain) {
        Main.printLine(false);

        System.out.println("Congratulations, you got " + score + " out of " + (numberOn - 1) + "! Would you like to view your answers?");
        System.out.println("--------------------------------------------------------------------------------------------");
        System.out.println("1 - Display all of your answers");
        if(isWrongAnswer) System.out.println("2 - Display all of your wrong answers");
        System.out.println("\n" + (tryAgain ? "You did not choose a valid option. Please try again.\n" : "") + "Type and enter the number of the option you want or type and enter -1 or 0 to go home:");

        Main.selected = Main.scan.nextLine();
        Main.intSelected = Main.isNumeric(Main.selected) ? Integer.parseInt(Main.selected) : -10;

        if(Main.intSelected == 1 || (isWrongAnswer && Main.intSelected == 2)) {
            displayElements(Main.intSelected, false);
        } else if(Main.selected.equals("-1")) {
            Main.userMain(false);
        } else if(Main.selected.equals("0")) {
            Main.userMain(false);
        } else {
            userChooseDisplay(true);
        }
    }

    /**
     * Seventh phase of testing where the answers are displayed.
     * 
     * @param boolean tryAgain - whether the method was called again due to an invalid user input.
     */
    private static void displayElements(int option, boolean tryAgain) {
        if(option == 1) {
            Main.printLine(false);
            System.out.println("These were all the elements asked for in the test:");
            System.out.println("--------------------------------------------------------------------------------------------");
            for(int i = 0; i < answers[0].length; i++) {
                if(answers[0][i] != null) {
                    System.out.println(answers[0][i]);
                }
            }
        } else {
            Main.printLine(false);
            System.out.println("These were all the elements you got wrong on the test:");
            System.out.println("--------------------------------------------------------------------------------------------");
            for(int i = 0; i < answers[1].length; i++) {
                if(answers[1][i] != null) {
                    System.out.println(answers[1][i]);
                }
            }
        }
        System.out.println("\n" + (tryAgain ? "You did not choose a valid option. Please try again.\n" : "") + "Type and enter the element number you want to view, type and enter -1 to go back, or type and enter 0 to go home:");

        Main.selected = Main.scan.nextLine();
        Main.intSelected = Main.isNumeric(Main.selected) ? Integer.parseInt(Main.selected) : -10;

        if(Main.intSelected >= 1 && Main.intSelected <= 118) {
            new Element(Main.intSelected).viewElement();
            userDone(option);
        } else if(Main.selected.equals("-1")) {
            userChooseDisplay(false);
        } else if(Main.selected.equals("0")) {
            Main.userMain(false);
        } else {
            displayElements(option, true);
        }
    }

    /**
     * Allows the user to go back to the main menu or allows them to view their answers on the test again.
     */
    private static void userDone(int option) {
        System.out.println("\nType and enter anything when you want to go home or type and enter -1 to go back:");
        Main.selected = Main.scan.nextLine();

        if(Main.selected.equals("-1")) {
            displayElements(option, false);
        } else {
            Main.userMain(false);
        }
    }

}