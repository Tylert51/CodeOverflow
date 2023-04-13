import java.util.ArrayList;

public class BinSort {

    private ArrayList<Item> allItems;
    private ArrayList<Item> greenBin;
    private ArrayList<Item> blueBin;
    private ArrayList<Item> redBin;
    private ArrayList<Item> greyBin;
    private String green;
    private String blue;
    private String red;
    private String grey;
    private int score;
    private String instructions;



    public BinSort() {
        allItems = new ArrayList<Item>();
        greenBin = new ArrayList<Item>();
        blueBin = new ArrayList<Item>();
        redBin = new ArrayList<Item>();
        greyBin = new ArrayList<Item>();
        green  = "green";
        blue = "blue";
        red = "red";
        grey = "grey";

        score = 0;

        instructions = "You will be displayed with a set of trash items and it is your job to sort them in their respective bins\n";
        instructions += "\nBins: ";
        instructions += "\n    - green: compost\n    - blue: recyclables\n    - red: hazardous materials\n    - grey: trash";

        addItems();
    }

    public void start() {
        addItems();
    }

    public void addItems() {
        //items for greenBin (Compost)
        Item appleCore = new Item("apple core", green);
        Item eggShell = new Item("egg shell", green);
        Item bananaPeel = new Item("banana peel", green);
        Item coffeeGrounds = new Item("coffee grounds", green);
        Item staleBread = new Item("stale bread", green);
        Item teaBag = new Item("tea bag", green);
        Item nutshells = new Item("nutshells", green);
        Item napkin = new Item("napkin", green);
        Item soiledNewspaper = new Item("soiled newspaper", green);
        Item cornCob = new Item("corn cob", green);

        greenBin.add(appleCore);
        greenBin.add(eggShell);
        greenBin.add(bananaPeel);
        greenBin.add(coffeeGrounds);
        greenBin.add(staleBread);
        greenBin.add(teaBag);
        greenBin.add(nutshells);
        greenBin.add(napkin);
        greenBin.add(soiledNewspaper);
        greenBin.add(cornCob);

        //items for blueBin
        Item cardboard = new Item("cardboard", blue);
        Item magazine = new Item("magazine", blue);
        Item glassBottle = new Item("glass bottle", blue);
        Item plasticBottle = new Item("plastic bottle", blue);
        Item jar = new Item("jar", blue);
        Item can = new Item("can", blue);
        Item carton = new Item("carton", blue);
        Item cerealBox = new Item("cereal box", blue);
        Item wrappingPaper = new Item("wrapping paper", blue);
        Item paperBag = new Item("paper bag", blue);

        blueBin.add(cardboard);
        blueBin.add(magazine);
        blueBin.add(glassBottle);
        blueBin.add(plasticBottle);
        blueBin.add(jar);
        blueBin.add(can);
        blueBin.add(carton);
        blueBin.add(cerealBox);
        blueBin.add(wrappingPaper);
        blueBin.add(paperBag);

        //items for redBin
        Item cleaningProduct = new Item("cleaning product", red);
        Item medicine = new Item("medicine", red);
        Item paint = new Item("paint", red);
        Item makeup = new Item("makeup", red);
        Item lightBulb = new Item("compact fluorescent light bulb", red);
        Item thermometer = new Item("thermometer", red);
        Item pesticide = new Item("pesticide", red);
        Item gasoline = new Item("gasoline", red);
        Item rechargeableBattery = new Item("rechargeable battery", red);
        Item nailPolish = new Item("nail polish", red);

        redBin.add(cleaningProduct);
        redBin.add(medicine);
        redBin.add(paint);
        redBin.add(makeup);
        redBin.add(lightBulb);
        redBin.add(thermometer);
        redBin.add(pesticide);
        redBin.add(gasoline);
        redBin.add(rechargeableBattery);
        redBin.add(nailPolish);

        //items for greyBin
        Item soiledDiaper = new Item("soiled diaper", grey);
        Item styrofoam = new Item("styrofoam", grey);
        Item ceramicPlate = new Item("ceramic plate", grey);
        Item paperPlate = new Item("soiled paper plate", grey);
        Item faceMask = new Item("face mask", grey);
        Item usedGloves = new Item("used gloves", grey);
        Item catLitter = new Item("cat litter", grey);
        Item chipBag = new Item("chip bag", grey);
        Item filter = new Item("filter", grey);
        Item bone = new Item("bone", grey);

        greyBin.add(soiledDiaper);
        greyBin.add(styrofoam);
        greyBin.add(ceramicPlate);
        greyBin.add(paperPlate);
        greyBin.add(faceMask);
        greyBin.add(usedGloves);
        greyBin.add(catLitter);
        greyBin.add(chipBag);
        greyBin.add(filter);
        greyBin.add(bone);

        for (int i = 0; i < (greenBin.size() + blueBin.size() + redBin.size() + greyBin.size()); i++) {
            if (i < 10) {
                allItems.add(greenBin.get(i));
            }
            else if (i < 20) {
                allItems.add(blueBin.get(i - 10));
            }
            else if (i < 30) {
                allItems.add(redBin.get(i - 20));
            }
            else {
                allItems.add(greyBin.get(i - 30));
            }
        }

    }

    public ArrayList<Item> getListOfRandItems() {
        ArrayList<Item> randList = new ArrayList<Item>();
        int allItemLen = (greenBin.size() + blueBin.size() + redBin.size() + greyBin.size());

        for(int i = 0; i < 10; i++) {
            int rand = (int) (Math.random() * allItemLen);

            while(randList.contains(allItems.get(rand))) {
                rand = (int) (Math.random() * allItemLen);
            }

            randList.add(allItems.get(rand));
        }


        return randList;
    }

    public boolean checkInput(Item i, String inputtedColor) {
        inputtedColor = inputtedColor.toLowerCase();
        String realColor = i.getBinColor();

        if(realColor.equals(inputtedColor)) {
            score++;
            return true;
        }

        return false;
    }

    public int getScore() {
        return score;
    }

    public String getInstructions() {
        return instructions;
    }

}
