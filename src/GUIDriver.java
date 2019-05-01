import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GUIDriver {

    public static void main() throws IOException {

        JFrame window = new JFrame();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(750, 500);
        window.setLayout(new GridBagLayout());


        ChooseParty.build();
    }

}
