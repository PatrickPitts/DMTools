import java.io.IOException;
import java.util.Scanner;

public class Main {


    private static Party p;

    static {
        try {
            setP(FileLoader.getPartyFromFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Main() throws IOException {

    }

    public static void main(String[] args) throws IOException {
        Scanner key = new Scanner(System.in);

        //Driver.run();
        GUIDriver.main();
    }

    public static Party getP() {
        return p;
    }

    public static void setP(Party p) {
        Main.p = p;
    }
}
