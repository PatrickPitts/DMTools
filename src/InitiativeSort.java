import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class InitiativeSort {
    private static GridBagConstraints geometry = new GridBagConstraints();
    private static int rowIndex;
    private static ArrayList<JTextField> rolls = new ArrayList<>();
    private static ArrayList<JCheckBox> addBonus = new ArrayList<>();



    public static void build(Party p){


        JFrame window = new JFrame("Roll for Initiative!");
        window.setLayout(new GridBagLayout());
        window.setSize(250, 350);

        JButton sortButton = new JButton("Initiative Order");


        ArrayList<Creature> players = new ArrayList<>(p.getPartyMembers());

        Creature monster = new Creature();
        monster.setName("Monster");
        players.add(monster);


        for (Creature player : players) {
            player.setRolledInitiative(0);
            rolls.add(new JTextField("1", 3));
            addBonus.add(new JCheckBox());
        }

        final JPanel[] sortedPanel = {new JPanel()};
        sortedPanel[0].add(sortPanel(players));



        ActionListener executeSort = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Creature> sorted = sort(players);
                sortedPanel[0].removeAll();
                sortedPanel[0].add(sortPanel(sorted));

                window.repaint();
                window.revalidate();
            }
        };

        sortButton.addActionListener(executeSort);


        geometry.gridx = 0;
        geometry.gridy = 0;
        window.add(sortedPanel[0], geometry);

        geometry.gridy = 1;
        window.add(sortButton, geometry);


        window.revalidate();
        window.repaint();
        window.setVisible(true);
    }

    public static JPanel sortPanel(ArrayList<Creature> c){

        JPanel sortPanel = new JPanel();
        sortPanel.setLayout(new GridBagLayout());

        geometry.gridy = 0;
        geometry.gridx = 3;
        sortPanel.add(GUIBuilder.labelGenSolid("Bonus?", GUIBuilder.MAIN_FONT), geometry);

        for(rowIndex = 0; rowIndex < c.size(); rowIndex++){
            geometry.gridx = 0;
            geometry.gridy++;
            sortPanel.add(GUIBuilder.labelGenSolid(c.get(rowIndex).getName(), GUIBuilder.MAIN_FONT), geometry);

            geometry.gridx++;
            if(c.get(rowIndex).getRolledInitiative() != 0) {
                sortPanel.add(GUIBuilder.labelGenSolid(String.valueOf(c.get(rowIndex).getRolledInitiative()), GUIBuilder.MAIN_FONT), geometry);
            }

            geometry.gridx++;
            sortPanel.add(rolls.get(rowIndex), geometry);

            geometry.gridx++;
            sortPanel.add(addBonus.get(rowIndex), geometry);
        }
        geometry.gridy++;
        geometry.gridx = 0;
        return sortPanel;
    }

    public static ArrayList<Creature> sort(ArrayList<Creature> players){
        ArrayList<Creature> newArr = new ArrayList<Creature>(players);
        for(int i = 0; i< newArr.size(); i++){
            int bonus = (addBonus.get(i).isSelected()) ? 1 : 0;
            int val = Integer.parseInt(rolls.get(i).getText()) + newArr.get(i).getDexMod() * bonus;
            newArr.get(i).setRolledInitiative(val);
        }

        //FIXME implement initiative initizalization
        //sorts newArr in ascending order
        int n = newArr.size();
        for(int i = 1; i < n; i++){
            Creature key = newArr.get(i);
            int j = i - 1;
            while(j >= 0 && newArr.get(j).getRolledInitiative() > key.getRolledInitiative()){
                newArr.set(j+1, newArr.get(j));
                j--;
            }
            newArr.set(j+1, key);
        }

        ArrayList<Creature> returnArr = new ArrayList<Creature>();
        int longest = 0;

        //reverses newArr into descending order, and also finds the longest name String
        for(int i = n-1; i > -1; i--){
            returnArr.add(newArr.get(i));
        }

        for(int i = 0; i < n-1; i++){
            if(returnArr.get(i+1).getDexterity() > returnArr.get(i).getDexterity()){
                Collections.swap(returnArr, i, i+1);
            }
        }

        return returnArr;

    }
}
