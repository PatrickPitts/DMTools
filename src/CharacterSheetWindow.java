import javax.swing.*;
import java.awt.*;

public class CharacterSheetWindow {

    private static GridBagConstraints geometry = new GridBagConstraints();

    public static void buildShowPanel(PlayerCharacter p){

        JFrame window = new JFrame(p.getName());
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.setVisible(true);
        JPanel canvas = new JPanel();

        JPanel pageOne = new JPanel();
        JPanel pageTwo = new JPanel();
        JPanel pageThree = new JPanel();

        window.setLayout(new GridBagLayout());
        //tabbedPane.setLayout(new GridBagLayout());
        canvas.setLayout(new GridBagLayout());
        pageOne.setLayout(new GridBagLayout());
        pageTwo.setLayout(new GridBagLayout());
        pageThree.setLayout(new GridBagLayout());

        pageOne.add(new JLabel("page 1 label"));
        pageTwo.add(new JLabel("page 2 label"));
        pageThree.add(new JLabel("page 3 label"));

        tabbedPane.setBounds(50,50,300,300);

        tabbedPane.add("Page 1", pageOne);
        tabbedPane.add("Page 2", pageTwo);
        tabbedPane.add("Page 3", pageThree);


        canvas.add(tabbedPane);
        window.add(canvas);

        window.setSize(400,400);
        window.revalidate();
        window.repaint();
        window.setVisible(true);


    }


}
