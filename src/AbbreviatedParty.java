import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

public class AbbreviatedParty extends Frame {
    private static GridBagConstraints geometry = new GridBagConstraints();
    AbbreviatedParty(){}

    public static void build(Party p){

        String title = "Quick Stats for " + p.getPartyName();
        JFrame window = new JFrame(title);

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //window.setSize(750, 500);
        window.setLayout(new GridBagLayout());

        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();

        leftPanel.setLayout(new GridBagLayout());
        rightPanel.setLayout(new GridBagLayout());
        ArrayList<JPanel> charPanels = new ArrayList<>();

        GridBagConstraints geometry = new GridBagConstraints();

        String[] players = p.getPartyMemberNames();
        JList<String> playerList = new JList<>(players);
        playerList.setSelectedIndex(0);

        playerList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int indexOfSelected = playerList.getSelectedIndex();

                for(int i = 0; i < players.length; i++){
                    BasicPCDisplayPanel.buildBasic(charPanels.get(i), p.getPartyMembers().get(i));
                }
                BasicPCDisplayPanel.buildHighlight(charPanels.get(indexOfSelected), p.getPartyMembers().get(indexOfSelected));
            }
        });
        
        MouseListener clickOnList = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int indexOfSelected = playerList.getSelectedIndex();
                if (e.getClickCount() == 2){
                    CharacterSheetWindow c = new CharacterSheetWindow(p.getPartyMembers().get(indexOfSelected));
                }
            }
        };

        ActionListener rollInitiative = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InitiativeSort.build(p);
            }
        };

        ActionListener showChrSheet = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int indexOfSelected = playerList.getSelectedIndex();
                CharacterSheetWindow c = new CharacterSheetWindow(p.getPartyMembers().get(indexOfSelected));

            }
        };

        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        JButton popoutInitiative = new JButton("Roll for Initiative!");

        JButton showCharacterSheetButton = new JButton("Show Full Sheet");


        playerList.setAlignmentX(Component.TOP_ALIGNMENT);
        popoutInitiative.setAlignmentX(Component.TOP_ALIGNMENT);

        playerList.addMouseListener(clickOnList);
        popoutInitiative.addActionListener(rollInitiative);
        showCharacterSheetButton.addActionListener(showChrSheet);

        geometry.anchor = GridBagConstraints.NORTH;
        leftPanel.add(playerList, geometry);

        geometry.anchor = GridBagConstraints.SOUTH;
        leftPanel.add(popoutInitiative, geometry);
        leftPanel.add(showCharacterSheetButton, geometry);

        geometry.insets = new Insets(3,3,3,3);
        for(int i = 0; i < p.getPartyMembers().size(); i++){
            geometry.gridx = i%3;
            geometry.gridy = (int) (i / 3);

            charPanels.add(new JPanel());
            BasicPCDisplayPanel.buildBasic(charPanels.get(i), p.getPartyMembers().get(i));
            rightPanel.add(charPanels.get(i), geometry);
        }

        window.add(leftPanel);
        window.add(rightPanel);

        Dimension windowSize = new Dimension((int) window.getPreferredSize().getWidth()+25, (int) window.getPreferredSize().getHeight() + 75);
        window.setSize(windowSize);

        window.setVisible(true);
        window.revalidate();
        window.repaint();

    }
}
