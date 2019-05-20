import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class ChooseParty{

    public static void build() throws IOException {

        JFrame window = new JFrame("Select Your Party");
        JPanel pane = new JPanel();
        JList partyJList;
        JButton choosePartyButton = new JButton("Choose Party");
        JButton newCharacterButton = new JButton("Add A Character");

        window.setLayout(new GridBagLayout());
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(500, 150);
        pane.setLayout(new GridBagLayout());

        GridBagConstraints geometry = new GridBagConstraints();
        geometry.insets = new Insets(5,5,5,5);

        Map<String, Party> partyMap = FileLoader.getPartyMapFromFile();
        ArrayList<String> partyNameArray = new ArrayList<>();


        for(String key : partyMap.keySet()){
            if(!key.equals("None")){
                partyNameArray.add(key);
            }
        }
        partyJList = new JList(partyNameArray.toArray());
        partyJList.setFont(GUIBuilder.MAIN_FONT);
        partyJList.setSelectedIndex(0);

        //ActionListeners used in the pane
        ActionListener loadParty = e -> {
            AbbreviatedParty.build(partyMap.get(partyJList.getSelectedValue()));
        };

        ActionListener newCharacter = e -> {AddCharacterWindow.build();
        };

        choosePartyButton.addActionListener(loadParty);
        newCharacterButton.addActionListener(newCharacter);
        geometry.gridx = 0; geometry.gridy = 0;
        pane.add(partyJList, geometry);

        geometry.gridx = 1;
        pane.add(choosePartyButton, geometry);

        geometry.gridx = 2;
        pane.add(newCharacterButton, geometry);

        geometry.gridx = 0;
        window.add(pane);

        //Builds the menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu featsMenu = new JMenu("Feats");
        JMenuItem seeFeats = new JMenuItem("Show Feats");
        seeFeats.addActionListener((event) -> new ViewAllFeatsWindow());

        featsMenu.add(seeFeats);
        menuBar.add(featsMenu);
        window.setJMenuBar(menuBar);


        pane.repaint();
        window.repaint();

        pane.revalidate();
        window.revalidate();

        window.setVisible(true);


    }
}
