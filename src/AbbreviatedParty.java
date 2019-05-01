import javax.swing.*;
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
        window.setSize(750, 500);
        window.setLayout(new GridBagLayout());

        JPanel leftPanel = new JPanel();
        JPanel rightPanel = new JPanel();

        leftPanel.setLayout(new GridBagLayout());
        rightPanel.setLayout(new GridBagLayout());
        ArrayList<JPanel> charPanels = new ArrayList<>();

        GridBagConstraints geometry = new GridBagConstraints();

        String[] players = p.getPartyMemberNames();
        JList<String> playerList = new JList<>(players);

        MouseListener clickOnList = new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2){

                    int indexOfSelected = playerList.getSelectedIndex();
                    BasicPCDisplayPanel.build(rightPanel, p.getPartyMembers().get(indexOfSelected));
                }
            }
        };

        ActionListener rollInitiative = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InitiativeSort.build(p);
            }
        };
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));

        JButton popoutInitiative = new JButton("Roll for Initiative!");

        JButton backToPartiesButton = new JButton("Back to Party Select");


        playerList.setAlignmentX(Component.TOP_ALIGNMENT);
        popoutInitiative.setAlignmentX(Component.TOP_ALIGNMENT);

        playerList.addMouseListener(clickOnList);
        popoutInitiative.addActionListener(rollInitiative);

        geometry.anchor = GridBagConstraints.NORTH;
        leftPanel.add(playerList, geometry);

        geometry.anchor = GridBagConstraints.SOUTH;
        leftPanel.add(popoutInitiative, geometry);
        leftPanel.add(backToPartiesButton, geometry);

        geometry.insets = new Insets(3,3,3,3);
        for(int i = 0; i < p.getPartyMembers().size(); i++){
            geometry.gridx = i%3;
            geometry.gridy = (int) (i / 3);

            charPanels.add(new JPanel());
            BasicPCDisplayPanel.buildBasic(charPanels.get(i), p.getPartyMembers().get(i));
            rightPanel.add(charPanels.get(i), geometry);
        }

        //BasicPCDisplayPanel.build(rightPanel, p.getPartyMembers().get(0));

        window.add(leftPanel);
        window.add(rightPanel);

        window.setVisible(true);
        window.revalidate();
        window.repaint();

    }
}
