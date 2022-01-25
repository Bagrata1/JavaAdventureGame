package gameModel;

import java.util.*;



/**
 * Adventure class
 * 
 * This class initializes the map, rooms, items and a player.
 * Furthermore, the descriptions of rooms and items are initialized here as well.
 * function setupWorld() sets up the game world, while the function start() initializes the
 * main game loop.
 * Also, the connections between the rooms are created in this class.
 * 
 * @author Irakli Bagratishvili
 */


public class Adventure {
    static Room forest, boarden, meadow, river, mistletoetrees, villageroad, villageentrance, village;

    static Item yeast, harp, mistletoe, barrel, flask, bone;
    static ArrayList<Room> map = new ArrayList<>();
    static ArrayList<Item> itemsMap = new ArrayList<>();
    private Room currentLocation;
    static Hero idefix;
    Scanner choice = new Scanner(System.in);


    public static void setupWorld() {

        idefix = new Hero();

        //Room 1
        forest = new Room("The Forest");
        forest.setRoomDesc("In the dark forest he could see a pathway going to the east.");

        boarden = new Room("The Boar Den");
        boarden.setRoomDesc("Ideafix meets a hangry boar in the forest.\n"
                + " Accidentally, Idefix saw some yeast nearby that the hungry boar could not see.\n"
                + " This yeast could easily end the hunger/anger of the boar. \n"
                + " Apart from barking at the boar or getting the yeast for it,\n"
                + " Idefix can also try to go towards the southern path to avoid trouble...");
        boarden.setLocked(true);

        meadow = new Room("The Meadow");
        meadow.setRoomDesc("Good thing Idefix got away from that boar!\n"
                + "Far away he can hear Chants. He decides to approach the sound\n "
                + "and sees Assurancetourix, who has lost his harp.\n"
                + "Assurancetourix asks Idefix if he can look around for the harp.\n"
                + "Idefix really wants to help but also sees a path to the east that could lead to Obelix.\n"
                + "What should idefix do??");
        meadow.setLocked(true);

        river = new Room("The River");
        river.setRoomDesc("Idefix sees a river up north that seems a little bit too fast to cross by himself\n"
                + "He could try to cross it, but he could drown.\n"
                + "Or, Idefix can use the bone that he got to cross the river.\n"
                + "Of course, he can go back west where Assurancetourix was");
        river.setLocked(true);

        mistletoetrees = new Room("The Mistletoe Trees");
        mistletoetrees.setRoomDesc("Once on the other side, Idefix recognises the tree Panoramix\n"
                + " comes to often to get mistletoe for his famous potion. Idefix sits by the tree to take\n"
                + " a nap until he gets woken up by the marches of the Roman Army. In panic he climbs up the tree.\n"
                + " Idefix knows that Romans are interested in mistletoe, so if he would give it to them, they would\n"
                + " probably leave.Also, to the west he sees a path that might lead out of the forest.");
        mistletoetrees.setLocked(true);

        villageroad = new Room("The Village Road");
        villageroad.setRoomDesc("Finally, Idefix is almost out of the forest! On his way back, he crossed Panoramix,\n"
                + " who saw him with a huge wine barrel that romans gave to him in return for mistletoe.\n"
                + " This barrel could be useful for for Panoramix to get up on the mistletoe tree to get the ingredients\n"
                + " for his magic potion. In return for the wine barrel, Panoramix promised to give Idefix a flask of magic potion,\n"
                + " as well as telling him that the way to the village lies across the western path.");
        villageroad.setLocked(true);

        villageentrance = new Room("The Village Entrance");
        villageentrance.setRoomDesc("As Idefix continues his walk back to the village,\n"
                + " his passage is blocked by a huge menhir. What should Idefix do? He still has the flask with the magic potion.\n"
                + " Also, now he can see the village to the south!");
        villageentrance.setLocked(true);

        village = new Room("The Village");
        village.setRoomDesc("As he drinks the liquid, a surge of energy flows through his body.\n"
                + " It is a magic potion! He runs through the stone which shatters in pieces.\n"
                + " Idefix sees Obelix by the gates of the village. He makes a huge jump straight into Obelix's arms.\n"
                + " To celebrate the reunion of friends, they organize a feast with beer and boar with the whole village.\n"
                + " At the end, because Idefix managed to find his way back after a long absence,\n"
                + " Fabala gives him a big kiss.\n"
                +"\tTHE END");

        idefix.setCurrentLocation(forest);
        forest.setExit(Paths.EAST, boarden);

        // Room2
        boarden.setExit(Paths.WEST, forest);
        boarden.setExit(Paths.SOUTH, meadow);
        yeast = new Item("Yeast");
        yeast.setItemDesc("It is one of boar's favorite foods");

        boarden.setRoomItem(yeast);
        boarden.setTaskItem(yeast);

        // Room 3


        meadow.setExit(Paths.NORTH, boarden);
        meadow.setExit(Paths.EAST, river);
        harp = new Item("Harp");
        harp.setItemDesc("This is Assourancetourix's favorite harp!");
        bone = new Item("Bone");
        bone.setItemDesc("Yummy bone! it will last Idefix for at least weeks!");
        meadow.setRoomItem(harp);
        meadow.setTaskItem(harp);
        meadow.setRewardItem(bone);

        // Room 4
        river.setExit(Paths.WEST, meadow);
        river.setExit(Paths.NORTH, mistletoetrees);
        river.setTaskItem(bone);
        // Room 5

        mistletoetrees.setExit(Paths.WEST, villageroad);
        mistletoetrees.setExit(Paths.SOUTH, river);

        mistletoe = new Item("Mistletoe");
        mistletoe.setItemDesc("The powerful plant used for creating the famous magic potion");
        mistletoetrees.setRoomItem(mistletoe);
        mistletoetrees.setTaskItem(mistletoe);

        barrel = new Item("Wine Barrel");
        barrel.setItemDesc("A huge wooden barrel filled with high quality Roman wine");
        mistletoetrees.setRewardItem(barrel);


        // Room 6
        villageroad.setExit(Paths.EAST, mistletoetrees);
        villageroad.setExit(Paths.WEST, villageentrance);

        flask = new Item("Flask");
        flask.setItemDesc("A flask full of Panoramix's magic potion. To be used with care!");
        flask.setItemLocation(villageroad);
        villageroad.setRewardItem(flask);
        villageroad.setTaskItem(barrel);

        // Room 7
        villageentrance.setExit(Paths.SOUTH, village);
        villageentrance.setExit(Paths.EAST, villageroad);
        villageentrance.setTaskItem(flask);

        // Room 8
        village.setExit(Paths.WEST, villageentrance);

        // Creating a map

        map.add(forest);
        map.add(boarden);
        map.add(meadow);
        map.add(mistletoetrees);
        map.add(river);
        map.add(villageroad);
        map.add(villageentrance);
        map.add(village);

        // Adding the items to the map

        itemsMap.add(yeast);
        itemsMap.add(harp);
        itemsMap.add(mistletoe);
        itemsMap.add(barrel);
        itemsMap.add(flask);

        // Creating player inventory
    }

    public void start() {
        boolean gameFinished = false;
        setupWorld();
        System.out.println("Welcome to the text-based adventure game.\n"
        		+"Idefix, who happens to be Obelix's dog after walking\n"
			+"around in the forest,lost sight of Obelix.\n"
        		+"The valid commands are look,go south/north/east/west, take x, drop x and use x.\n"
        		+"type look to get the description of surroundings!"
        		+"Good Look and have fun!");
        while (!gameFinished) {
            String input = choice.nextLine();
            input = input.toLowerCase();
            String[] commandWords = input.split(" ");
            switch (commandWords[0]) {
                case "go":
                    if (commandWords.length == 2) {
                        if (!idefix.getcurrentLocation().isLocked()) {
                            Paths destination = null;
                            switch (commandWords[1]) {
                                case "east":
                                    destination = Paths.EAST;
                                    break;
                                case "west":
                                    destination = Paths.WEST;
                                    break;
                                case "south":
                                    destination = Paths.SOUTH;
                                    break;
                                case "north":
                                    destination = Paths.NORTH;
                                    break;
                            }
                            if (destination != null) {
                                Room newRoom = idefix.getcurrentLocation().getExit(destination);
                                if (newRoom != null) {
                                    idefix.setCurrentLocation(newRoom);
                                    System.out.println("Idefix is now at a " + idefix.getcurrentLocation().getRoomName());
                                } else {
                                    System.out.println("Can't go there!");
                                }
                            }
                        } else
                            System.out.println("You can't go to the next area yet.");
                    } else {
                        System.out.println("Idefix does not understand this command! Try something else");
                    }
                    break;
                case "take":
                    if(commandWords.length > 1) {
                        Item roomItem = idefix.getcurrentLocation().getRoomItem();
                        String itemToTake = input.substring(input.indexOf(" ") + 1);
                        if (roomItem != null) {
                            if (roomItem.getitemName().toLowerCase().equals(itemToTake)) {
                                idefix.take(roomItem);
                                idefix.getcurrentLocation().setRoomItem(null);
                                System.out.println("Now Idefix is carrying " + roomItem.getitemName());
                                break;
                            }
                        }
                        System.out.println(itemToTake + " is not found, try another item!");
                    }else{
                        System.out.println("Idefix does not understand this command! Try something else!");
                    }
                    break;
                case "use":
                    if(commandWords.length > 1) {
                        ArrayList<Item> heroInven = idefix.getInventory();
                        String itemToUse = input.substring(input.indexOf(" ") + 1);
                        boolean temp = false;
                        for (int i = 0; i < heroInven.size(); i++) {
                            if (itemToUse.equals(heroInven.get(i).getitemName().toLowerCase())) {
                                if (idefix.getcurrentLocation().getTaskItem().getitemName().toLowerCase().equals(itemToUse)) {
                                    System.out.println("Idefix used " + heroInven.get(i).getitemName());
                                    temp = true;
                                    idefix.getcurrentLocation().setLocked(false);
                                    idefix.drop(heroInven.get(i));
                                    if (idefix.getcurrentLocation().getRewardItem() != null) {
                                        idefix.take(idefix.getcurrentLocation().getRewardItem());
                                        System.out.println("Idefix received " +
                                                idefix.getcurrentLocation().getRewardItem().getitemName() + " as a reward for being a good boy!");
                                    }
                                } else {
                                    System.out.println("Can't use " + itemToUse + " here.");
                                    temp = true;
                                }
                            }
                        }
                        if (!temp)
                            System.out.println(itemToUse + " is not found, try another item!");
                    }else{
                        System.out.println("Idefix does not understand this command! Try something else!");
                    }
                    break;
                case "look":
                    System.out.println(idefix.getcurrentLocation().getRoomDesc());
                    break;
                default:
                    System.out.println("Idefix does not understand this command! Try something else!");
            }
        }
    }
}

	