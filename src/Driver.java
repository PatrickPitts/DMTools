import java.util.Scanner;

public class Driver {
    private static Scanner key = new Scanner(System.in);

    public static void run(){
        boolean f = true;
        String r = "";
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
                case "bard" :
                    Bard b = new Bard();
                    b.printClassName();
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
