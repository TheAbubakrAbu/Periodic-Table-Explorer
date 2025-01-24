import java.util.Arrays;

public class Element {

    // Variables assigned to an Element object via a constructor
    public String number;
    public String name;
    public String symbol;
    public String phase;
    public String type;
    public String period;
    public String group;
    public String weight;
    public String density;
    public String meltingPoint;
    public String boilingPoint;

    // Array that contains all elements' numbers, names, and symbols in this format: Number - Name (Symbol) like "1 - Hydrogen (H)"
    public static Element[] elements = new Element[118];

    // Arrays with information about all 118 elements of the periodic table.
    // Imported from code.org's data tab which included all of these lists about elements in JavaScript (which I converted to arrays in Java). Code.org allows anyone to use this information.
    public static final String[] numbers = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", "101", "102", "103", "104", "105", "106", "107", "108", "109", "110", "111", "112", "113", "114", "115", "116", "117", "118"};

    public static final String[] names = {"Hydrogen", "Helium", "Lithium", "Beryllium", "Boron", "Carbon", "Nitrogen", "Oxygen", "Fluorine", "Neon", "Sodium", "Magnesium", "Aluminum", "Silicon", "Phosphorus", "Sulfur", "Chlorine", "Argon", "Potassium", "Calcium", "Scandium", "Titanium", "Vanadium", "Chromium", "Manganese", "Iron", "Cobalt", "Nickel", "Copper", "Zinc", "Gallium", "Germanium", "Arsenic", "Selenium", "Bromine", "Krypton", "Rubidium", "Strontium", "Yttrium", "Zirconium", "Niobium", "Molybdenum", "Technetium", "Ruthenium", "Rhodium", "Palladium", "Silver", "Cadmium", "Indium", "Tin", "Antimony", "Tellurium", "Iodine", "Xenon", "Cesium", "Barium", "Lanthanum", "Cerium", "Praseodymium", "Neodymium", "Promethium", "Samarium", "Europium", "Gadolinium", "Terbium", "Dysprosium", "Holmium", "Erbium", "Thulium", "Ytterbium", "Lutetium", "Hafnium", "Tantalum", "Tungsten", "Rhenium", "Osmium", "Iridium", "Platinum", "Gold", "Mercury", "Thallium", "Lead", "Bismuth", "Polonium", "Astatine", "Radon", "Francium", "Radium", "Actinium", "Thorium", "Protactinium", "Uranium", "Neptunium", "Plutonium", "Americium", "Curium", "Berkelium", "Californium", "Einsteinium", "Fermium", "Mendelevium", "Nobelium", "Lawrencium", "Rutherfordium", "Dubnium", "Seaborgium", "Bogrium", "Hassium", "Meitnerium", "Darmstadtium", "Roentgenium", "Copernicium", "Nihonium", "Flerovium", "Moscovium", "Livermorium", "Tennessine", "Oganesson"};

    public static final String[] symbols = {"H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne", "Na", "Mg", "Al", "Si", "P", "S", "Cl", "Ar", "K", "Ca", "Sc", "Ti", "V", "Cr", "Mn", "Fe", "Co", "Ni", "Cu", "Zn", "Ga", "Ge", "As", "Se", "Br", "Kr", "Rb", "Sr", "Y", "Zr", "Nb", "Mo", "Tc", "Ru", "Rh", "Pd", "Ag", "Cd", "In", "Sn", "Sb", "Te", "I", "Xe", "Cs", "Ba", "La", "Ce", "Pr", "Nd", "Pm", "Sm", "Eu", "Gd", "Tb", "Dy", "Ho", "Er", "Tm", "Yb", "Lu", "Hf", "Ta", "W", "Re", "Os", "Ir", "Pt", "Au", "Hg", "Tl", "Pb", "Bi", "Po", "At", "Rn", "Fr", "Ra", "Ac", "Th", "Pa", "U", "Np", "Pu", "Am", "Cm", "Bk", "Cf", "Es", "Fm", "Md", "No", "Lr", "Rf", "Db", "Sg", "Bh", "Hs", "Mt", "Ds", "Rg", "Cn", "Nh", "Fl", "Mc", "Lv", "Ts", "Og"};

    public static final String[] phases = {"Gas", "Gas", "Solid", "Solid", "Solid", "Solid", "Gas", "Gas", "Gas", "Gas", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Gas", "Gas", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Liquid", "Gas", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Gas", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Liquid", "Solid", "Solid", "Solid", "Solid", "Solid", "Gas", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Solid", "Expected to be Solid", "Expected to be Solid", "Expected to be Solid", "Expected to be Solid", "Expected to be Solid", "Expected to be Solid", "Expected to be Solid", "Expected to be Solid", "Expected to be Solid"};

    public static final String[] types = {"Non-Metal", "Non-Metal", "Metal", "Metal", "Semi-Metal", "Non-Metal", "Non-Metal", "Non-Metal", "Non-Metal", "Non-Metal", "Metal", "Metal", "Metal", "Semi-Metal", "Non-Metal", "Non-Metal", "Non-Metal", "Non-Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Semi-Metal", "Semi-Metal", "Non-Metal", "Non-Metal", "Non-Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Semi-Metal", "Semi-Metal", "Non-Metal", "Non-Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Semi-Metal", "Non-Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Metal", "Unknown", "Non-Metal"};

    public static final String[] periods = {"1", "1", "2", "2", "2", "2", "2", "2", "2", "2", "3", "3", "3", "3", "3", "3", "3", "3", "4", "4", "4", "4", "4", "4", "4", "4", "4", "4", "4", "4", "4", "4", "4", "4", "4", "4", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "5", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "6", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7", "7"};

    public static final String[] groups = {"No definitive group", "Noble Gas", "Alkali Metal", "Alkaline Earth Metal", "Metalloid", "Non-Metal", "Non-Metal", "Non-Metal", "Halogen", "Noble Gas", "Alkali Metal", "Alkaline Earth Metal", "Poor Metal", "Metalloid", "Non-Metal", "Non-Metal", "Halogen", "Noble Gas", "Alkali Metal", "Alkaline Earth Metal", "Transition Metal", "Transition Metal", "Transition Metal", "Transition Metal", "Transition Metal", "Transition Metal", "Transition Metal", "Transition Metal", "Transition Metal", "Transition Metal", "Poor Metal", "Poor Metal", "Metalloid", "Non-Metal", "Halogen", "Noble Gas", "Alkali Metal", "Alkaline Earth Metal", "Transition Metal", "Transition Metal", "Transition Metal", "Transition Metal", "Transition Metal", "Transition Metal", "Transition Metal", "Transition Metal", "Transition Metal", "Transition Metal", "Poor Metal", "Poor Metal", "Poor Metal", "Metalloid", "Halogen", "Noble Gas", "Alkali Metal", "Alkaline Earth Metal", "Rare Earth Metal", "Rare Earth Metal", "Rare Earth Metal", "Rare Earth Metal", "Rare Earth Metal", "Rare Earth Metal", "Rare Earth Metal", "Rare Earth Metal", "Rare Earth Metal", "Rare Earth Metal", "Rare Earth Metal", "Rare Earth Metal", "Rare Earth Metal", "Rare Earth Metal", "Rare Earth Metal", "Transition Metal", "Transition Metal", "Transition Metal", "Transition Metal", "Transition Metal", "Transition Metal", "Transition Metal", "Transition Metal", "Transition Metal", "Poor Metal", "Poor Metal", "Poor Metal", "Poor Metal", "Halogen", "Noble Gas", "Alkali Metal", "Alkaline Earth Metal", "Actinide Metal", "Actinide Metal", "Actinide Metal", "Actinide Metal", "Actinide Metal", "Actinide Metal", "Actinide Metal", "Actinide Metal", "Actinide Metal", "Actinide Metal", "Actinide Metal", "Actinide Metal", "Actinide Metal", "Actinide Metal", "Actinide Metal", "Superheavy Element", "Superheavy Element", "Superheavy Element", "Superheavy Element", "Superheavy Element", "Superheavy Element", "Superheavy Element", "Superheavy Element", "Superheavy Element", "Superheavy Element", "Superheavy Element", "Superheavy Element", "Superheavy Element", "Superheavy Element", "Superheavy Element"};

    public static final String[] weights = {"1.00794", "4.002602", "6.941", "9.1021831", "10.811", "12.0107", "14.00674", "15.9994", "18.9984032", "20.1797", "22.9897693", "24.305", "26.9815385", "28.0855", "30.973762", "32.066", "35.4527", "39.948", "39.0983", "40.078", "44.955908", "47.867", "50.9415", "51.9961", "54.938044", "55.845", "58.933194", "58.6934", "63.546", "65.38", "69.723", "72.63", "74.921595", "78.971", "79.904", "83.798", "85.4678", "87.62", "88.90584", "91.224", "92.90637", "95.95", "98", "101.07", "102.9055", "106.42", "107.8682", "112.414", "114.818", "118.71", "121.76", "127.6", "126.90447", "131.293", "132.905452", "137.327", "138.90547", "140.116", "140.90766", "144.242", "145", "150.36", "151.964", "157.25", "158.92535", "162.5", "164.93033", "167.259", "168.93422", "173.045", "174.9668", "178.49", "180.94788", "183.84", "186.207", "190.23", "192.217", "195.084", "196.966569", "200.592", "204.3833", "207.2", "208.9804", "209", "210", "222", "223", "226", "227", "232.0377", "231.03588", "238.02891", "237", "244", "243", "247", "247", "251", "252", "257", "258", "259", "262", "263", "268", "271", "270", "270", "278", "281", "281", "285", "286", "289", "289", "293", "294", "294"};
    
    public static final String[] densities = {"0.00008988", "0.0001785", "0.534", "1.85", "2.37", "2.267", "0.0012506", "0.001429", "0.001696", "0.0008999", "0.97", "1.74", "2.7", "2.3296", "1.82", "2.067", "0.003214", "0.0017837", "0.89", "1.54", "2.99", "4.5", "6", "7.15", "7.3", "7.874", "8.86", "8.912", "8.933", "7.134", "5.91", "5.323", "5.776", "4.809", "3.11", "0.003733", "1.53", "2.64", "4.47", "6.52", "8.57", "10.2", "11", "12.1", "12.4", "12", "10.501", "8.69", "7.31", "7.287", "6.685", "6.232", "4.93", "0.005887", "1.93", "3.62", "6.15", "6.77", "6.77", "7.01", "7.26", "7.52", "5.24", "7.9", "8.23", "8.55", "8.8", "9.07", "9.32", "7.9", "9.84", "13.3", "16.4", "19.3", "20.8", "22.57", "22.42", "21.46", "19.282", "13.5336", "11.8", "11.342", "9.807", "9.31", "7", "0.00973", "Unknown", "5", "10.07", "11.72", "15.37", "18.95", "20.25", "19.84", "13.79", "13.51", "14", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown"};

    public static final String[] meltingPoints = {"-434.81", "-458", "356.9", "2349", "3767", "6422", "-346", "-361.82", "-363.32", "-415.46", "208.04", "1202", "1220.581", "2577", "111.47", "239.38", "-150.7", "-308.83", "146.08", "1548", "2806", "3034", "3470", "3465", "2275", "2800", "2723", "2651", "1984.32", "787.15", "85.57", "1720.85", "1503", "428.9", "19", "-251.25", "102.76", "1431", "2772", "3371", "4491", "4753", "3915", "4233", "3567", "2830.8", "1763.2", "609.93", "313.88", "449.47", "1167.13", "841.12", "236.7", "-169.22", "83.19", "1341", "1684", "1468", "1708", "1870", "1908", "1965", "1512", "2395", "2473", "2574", "2685", "2784", "2813", "1506", "3025", "4051", "5463", "6192", "5767", "5491", "4435", "3215.1", "1947.52", "-37.89", "579", "621.43", "520.52", "489", "576", "-96", "81", "1292", "1924", "3182", "2862", "2075", "1191", "1184", "2149", "2453", "1922", "1652", "1580", "2781", "1521", "1520", "2961", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown"};

    public static final String[] boilingPoints = {"-423.17", "-452.07", "2448", "4480", "7232", "6917", "-320.44", "-297.31", "-306.62", "-410.94", "1621", "1994", "4566", "5909", "536.9", "832.28", "-29.27", "-302.53", "1398", "2703", "5137", "5949", "6165", "4840", "3742", "5182", "5301", "5275", "4644", "1655", "3999", "5131", "1137", "1265", "137.8", "-243.8", "1270", "2520", "6053", "7968", "8571", "8382", "7709", "7502", "6683", "5365", "3924", "1413", "3762", "4715", "2889", "1810", "364", "-162.62", "1240", "3447", "6267", "6195", "6368", "5565", "5432", "3261", "2784", "5923", "5846", "4653", "4892", "5194", "3542", "2185", "6156", "8317", "9856", "10031", "10105", "9054", "8002", "6917", "5173", "674.11", "2683", "3180", "2847", "1764", "Unknown", "-79.1", "Unknown", "2084", "5788", "8650", "Unknown", "7468", "7065", "5842", "3652", "5600", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown", "Unknown"};

    /**
     * Constructor for creating a new Element object based on the lists.
     * 
     * @param int option - the element number of the Element object.
     */
    public Element(int option) {
        option--;
        number = numbers[option];
        name = names[option];
        symbol = symbols[option];
        phase = phases[option];
        type = types[option];
        period = periods[option];
        group = groups[option];
        weight = weights[option];
        density = densities[option];
        meltingPoint = meltingPoints[option];
        boilingPoint = boilingPoints[option];
    }

    /**
     * Initializes the elements array (the main array that contains element names, numbers, and symbols).
     */
    public static void initializeElements() {
        for(int i = 0; i < 118; i++) {
            elements[i] = new Element(i + 1);
        }
    }

    /**
     * Displays all information about an element using the instance variables assigned to each Element object.
     */
    public void viewElement() {
        Main.printLine(true);
        System.out.println(elements[Integer.parseInt(number) - 1] + ":");
        System.out.println("Element Name: " + name);
        System.out.println("Atomic Number: " + number);
        System.out.println("Element Symbol: " + symbol);
        System.out.println("Phase type: " + phase);
        System.out.println("Element type: " + type);
        System.out.println("Element Period: " + period);
        System.out.println("Element Group: " + group);
        System.out.println("Weight: " + weight + " amu");
        System.out.println("Density: " + (density.equals("Unknown") ? "Unknown" : density + " g/L"));
        System.out.println("Melting Point: " + (meltingPoint.equals("Unknown") ? "Unknown" : meltingPoint + "°F"));
        System.out.println("Boiling Point: " + (boilingPoint.equals("Unknown") ? "Unknown" : boilingPoint + "°F"));
    }

    /**
     * Displays all information about an element using the instance variables assigned to each Element object.
     *
     * @param Element other - the element that is being compared.
     *
     * @return boolean whether or not the other element is the same as this element.
     */
    public boolean equals(Element other) {
        return this.number == other.number;
    }

    /**
     * Returns a string representation of the element.
     *
     * @return String representation of the element.
     */
    public String toString() {
        return this.number + " - " + this.name + " (" + this.symbol + ")";
    }

    /**
     * Creates an Element object that has a random index/atomic (element) depending on the user's input.
     * 
     * @param int option - Range of element numbers that can be randomly chosen.
            1 - Random Element from 1 to 30.
            2 - Random Element from 31 to 60.
            3 - Random Element from 61 to 90.
            4 - Random Element from 91 to 118.
            5 - Random Element with any atomic number.
     * 
     * @return Element object that has a random index/atomic (element) number depending on the parameter option.
     */
    public static Element randomElement(int option) {
        int randomIndex = 1;
        if(option == 1) {
            randomIndex = (int) (Math.random() * 30) + 1;
        } else if(option == 2) {
            randomIndex = (int) (Math.random() * 30) + 31;
        } else if(option == 3) {
            randomIndex = (int) (Math.random() * 30) + 61;
        } else if(option == 4) {
            randomIndex = (int) (Math.random() * 28) + 91;
        } else if(option == 5) {
            randomIndex = (int) (Math.random() * 118) + 1;
        }
        
        return new Element(randomIndex);
    }

}