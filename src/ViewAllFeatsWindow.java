import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;


public class ViewAllFeatsWindow extends JFrame {

    private GridBagConstraints geometry = new GridBagConstraints();

    ViewAllFeatsWindow(){
        setLayout(new GridBagLayout());
        setTitle("Feats");
        JTextArea featInfoDisplay = new JTextArea();
        featInfoDisplay.setSize(new Dimension(200,80));
        featInfoDisplay.setFont(GUIBuilder.MAIN_FONT);
        featInfoDisplay.setLineWrap(true);
        featInfoDisplay.setWrapStyleWord(true);
        featInfoDisplay.setRows(45);
        featInfoDisplay.setColumns(50);

        String[] temp = new String[AbilityReader.getFeatNames().size()];
        String[] listOfFeatNames = AbilityReader.getFeatNames().toArray(temp);

        JList featJList = new JList<>(listOfFeatNames);
        featJList.setVisibleRowCount(5);

        featJList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                featInfoDisplay.setText("");
                StringBuilder displayText = new StringBuilder();
                String selectedFeat = listOfFeatNames[featJList.getSelectedIndex()];

                featInfoDisplay.setText(GUIBuilder.getFeatDisplayString(selectedFeat));
                featInfoDisplay.setSize(new Dimension(200,80));
                revalidate();


            }
        });

        JScrollPane featScroller = new JScrollPane(featJList);
        featScroller.setPreferredSize(new Dimension(200, 80));

        add(featScroller);
        geometry.gridx = 1;

        add(featInfoDisplay, geometry);
        setVisible(true);

        setSize(getPreferredSize().width+25,getPreferredSize().height+25 );
        revalidate();
        repaint();


    }


}
