import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner key = new Scanner(System.in);
        PC.Party p = PC.getTheParty();

        boolean flag = true;
        Driver d = new Driver();
        d.run();

//        while(flag){
//
//            System.out.println("Which encounter we running?");
//            String r = key.next();
//
//            if(r.equals("1")){
//                encounter1(p);
//            }
//
//            else if(r.equals("q")) {
//                flag = false;
//            }
//
//            else if(r.equals("test")) {
//                test();
//            }
//
//            else if(r.equals("init")){
//                init(p);
//            }
//
//            else{
//                System.out.println("IDK what this is");
//            }
//        }
    }
    public static void test(){
        PC.Party p = PC.getTheParty();

        String[] s = "a".split(" ");
        for(int i = 0; i < s.length; i++){
            System.out.print(i+ "  ");
            System.out.println(s[i]);
        }
    }

    public static void init(PC.Party p){
        Scanner key = new Scanner(System.in);
        boolean flag = true;

        //PC.Party p = PC.getTheParty();
        String[] l = p.getCharacterNames();

        while(flag){
            System.out.println("player _ initiative");
            String r = key.next();
            String[] parsed = r.split(" ");
                if(Arrays.asList(p.getCharacterNames()).contains(parsed[0])){
                    p.getPcList().get(Arrays.asList(p.getCharacterNames()).indexOf(parsed[0])).setRolledInitiative(Integer.parseInt(parsed[1]));
                }else if(parsed[0].equals("q")){
                    flag = false;
                }

        }
    }

    public static void encounter1(PC.Party p){

        Random rand = new Random();
        //PC.Party p = PC.getTheParty();

        PC.MonsterParty m = new PC.MonsterParty();


        PC.Creature d = new PC.Creature();
        PC.Creature z = new PC.Creature();

        d.setName("Dragon");
        z.setName("Zombie");

        m.addCreature(d);
        m.addCreature(z);

        d.setInitiative(rand.nextInt(20) + 1);
        z.setInitiative(rand.nextInt(20) + 1);

        p.printEssentialStats(m.getMonsters());
    }

}
