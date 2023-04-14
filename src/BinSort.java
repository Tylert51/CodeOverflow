import javax.swing.*;
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

        instructions = "You will be presented with a set of trash items and it is your job to sort them in their respective bins\n";
        instructions += "\nBins: ";
        instructions += "\n    - green: compost\n    - blue: recyclables\n    - red: hazardous materials\n    - grey: trash";

        addItems();
    }

    public void start() {
        addItems();
    }

    public void addItems() {
        //items for greenBin (Compost)
        Item appleCore = new Item("apple core", green, new ImageIcon(getClass().getResource("appleCore.png")).getImage());
        Item eggShell = new Item("egg shell", green, new ImageIcon(getClass().getResource("eggShell.png")).getImage());
        Item bananaPeel = new Item("banana peel", green, new ImageIcon(getClass().getResource("bananaPeel.png")).getImage());
        Item coffeeGrounds = new Item("coffee grounds", green, new ImageIcon(getClass().getResource("coffeeGrounds.png")).getImage());
        Item staleBread = new Item("stale bread", green, new ImageIcon(getClass().getResource("staleBread.png")).getImage());
        Item teaBag = new Item("tea bag", green, new ImageIcon(getClass().getResource("teaBag.png")).getImage());
        Item nutshells = new Item("nutshells", green, new ImageIcon(getClass().getResource("nutShells.png")).getImage());
        Item napkin = new Item("napkin", green, new ImageIcon(getClass().getResource("napkins.png")).getImage());
        Item soiledNewspaper = new Item("soiled newspaper", green, new ImageIcon(getClass().getResource("soiledNewspaper.png")).getImage());
        Item cornCob = new Item("corn cob", green, new ImageIcon(getClass().getResource("cornCob.png")).getImage());

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
        Item cardboard = new Item("cardboard", blue, new ImageIcon(getClass().getResource("cardboard.png")).getImage());
        Item magazine = new Item("magazine", blue, new ImageIcon(getClass().getResource("magazine.png")).getImage());
        Item glassBottle = new Item("glass bottle", blue, new ImageIcon(getClass().getResource("glassBottle.png")).getImage());
        Item plasticBottle = new Item("plastic bottle", blue, new ImageIcon(getClass().getResource("plasticBottle.png")).getImage());
        Item jar = new Item("jar", blue, new ImageIcon(getClass().getResource("jar.png")).getImage());
        Item can = new Item("can", blue, new ImageIcon(getClass().getResource("can.png")).getImage());
        Item carton = new Item("carton", blue, new ImageIcon(getClass().getResource("carton.png")).getImage());
        Item cerealBox = new Item("cereal box", blue, new ImageIcon(getClass().getResource("cerealBox.png")).getImage());
        Item wrappingPaper = new Item("wrapping paper", blue, new ImageIcon(getClass().getResource("wrappingPaper.png")).getImage());
        Item paperBag = new Item("paper bag", blue, new ImageIcon(getClass().getResource("paperBag.png")).getImage());

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
        Item cleaningProduct = new Item("cleaning product", red, new ImageIcon(getClass().getResource("cleaningProduct.png")).getImage());
        Item medicine = new Item("medicine", red, new ImageIcon(getClass().getResource("medicine.png")).getImage());
        Item paint = new Item("paint", red, new ImageIcon(getClass().getResource("paint.png")).getImage());
        Item makeup = new Item("makeup", red, new ImageIcon(getClass().getResource("makeup.png")).getImage());
        Item lightBulb = new Item("compact fluorescent light bulb", red, new ImageIcon(getClass().getResource("lightBulb.png")).getImage());
        Item thermometer = new Item("thermometer", red, new ImageIcon(getClass().getResource("thermometer.png")).getImage());
        Item pesticide = new Item("pesticide", red, new ImageIcon(getClass().getResource("pesticide.png")).getImage());
        Item gasoline = new Item("gasoline", red, new ImageIcon(getClass().getResource("gasoline.png")).getImage());
        Item rechargeableBattery = new Item("rechargeable battery", red, new ImageIcon(getClass().getResource("rechargeableBattery.png")).getImage());
        Item nailPolish = new Item("nail polish", red, new ImageIcon(getClass().getResource("nailPolish.png")).getImage());

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
        Item soiledDiaper = new Item("soiled diaper", grey, new ImageIcon(getClass().getResource("diaper.png")).getImage());
        Item styrofoam = new Item("styrofoam", grey, new ImageIcon(getClass().getResource("styrofoam.png")).getImage());
        Item ceramicPlate = new Item("ceramic plate", grey, new ImageIcon(getClass().getResource("ceramicPlate.png")).getImage());
        Item paperPlate = new Item("soiled paper plate", grey, new ImageIcon(getClass().getResource("paperPlate.png")).getImage());
        Item faceMask = new Item("face mask", grey, new ImageIcon(getClass().getResource("faceMask.png")).getImage());
        Item usedGloves = new Item("used gloves", grey, new ImageIcon(getClass().getResource("usedGloves.png")).getImage());
        Item catLitter = new Item("cat litter", grey, new ImageIcon(getClass().getResource("catLitter.png")).getImage());
        Item chipBag = new Item("chip bag", grey, new ImageIcon(getClass().getResource("chipBag.png")).getImage());
        Item filter = new Item("filter", grey, new ImageIcon(getClass().getResource("filter.png")).getImage());
        Item bone = new Item("bone", grey, new ImageIcon(getClass().getResource("bone.png")).getImage());

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

    public void resetScore() {
        score = 0;
    }



}
