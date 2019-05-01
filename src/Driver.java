import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Driver {
    private static Scanner key = new Scanner(System.in);
    static Party p;

    private static void buildParty() throws IOException{

    }

    public static Party getParty(){
        return p;
    }

    public static void run() throws IOException {
        boolean f = true;
        String r;

        FileLoader y = new FileLoader();
        p = new Party(y.getData());
        buildParty();

        while(f){

            System.out.println("What are we doing next?");
            r = key.next();

            switch (r.toLowerCase()){
                case "quit" :
                    System.out.println("Quitting...");
                    f = false;
                    break;
                case "init" :
                    System.out.println("setting up initiative \n");
                    break;
                case "test" :

                    //FIXME implement setting data from save file
                    PlayerCharacter bob = new PlayerCharacter(new Barbarian(), "Bob", "Boub");

                    //bob.getCharacterClass().showClassFeatures();
                    //bob.getCharacterClass().setSubclass();
                    System.out.println(bob.getDexterity());
                    break;
                case "load" :




                    GUIDriver.main();
//                    ArrayList<PlayerCharacter> pcs = p.getPartyMembers();
//
//                    for(PlayerCharacter c : pcs){
//                        System.out.println(c.exportDataString());
//                    }
//
//
//                    ArrayList<String> features = pcs.get(0).getCharacterClass().getAllClassFeatures();
//                    for(String s : features){
//                        System.out.println(s);
//                    }
                    break;
                default :
                    System.out.println("Invalid command. \n");
                    break;
            }
        }
    }

    public static void main(String[] args){

        }
    }
