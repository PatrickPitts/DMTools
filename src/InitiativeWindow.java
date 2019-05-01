import javax.swing.*;
import java.io.IOException;

public class InitiativeWindow {

    public static void build() throws IOException {
        Party party = null;
        try{
            party = FileLoader.getPartyFromFile();
        } catch (Exception e){
            System.out.println(e.fillInStackTrace());
        }
        assert party != null;
        String[] characters = party.getPartyMemberNames();

        JFrame window = new JFrame();

        JLabel j = new JLabel("butts");

        window.add(j);

        window.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        window.setLayout(null);
        window.setVisible(true);


    }
}
