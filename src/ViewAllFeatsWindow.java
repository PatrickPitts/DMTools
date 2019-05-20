import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ViewAllFeatsWindow extends JFrame {

    private GridBagConstraints geometry = new GridBagConstraints();

    ViewAllFeatsWindow(){
        setLayout(new GridBagLayout());

        JTextArea featInfoDisplay = new JTextArea();
        //featInfoDisplay.setPreferredSize(new Dimension(200,80));

        ArrayList<String[]> featsArrayList = FeatReader.getFeatStrings();
        //ArrayList<String> featNames = new ArrayList<>();
        String[] listOfFeatNames = new String[featsArrayList.size()];

        for(int i = 1; i < featsArrayList.size(); i++){
            listOfFeatNames[i] = featsArrayList.get(i)[0];
        }

        JList featJList = new JList<>(listOfFeatNames);
        featJList.setVisibleRowCount(5);

        featJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                featInfoDisplay.setText("");
                StringBuilder displayText = new StringBuilder();
                String[] fArray = featsArrayList.get(featJList.getSelectedIndex());

                displayText.append(fArray[0]);
                featInfoDisplay.setText(displayText.toString());

            }
        });

        JScrollPane featScroller = new JScrollPane(featJList);
        featScroller.setPreferredSize(new Dimension(200, 80));

        add(featScroller);
        geometry.gridx = 1;

        add(featInfoDisplay, geometry);
        setVisible(true);

        setSize(400,400);
        revalidate();
        repaint();


    }


}
