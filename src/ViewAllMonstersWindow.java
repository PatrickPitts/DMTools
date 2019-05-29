import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicSliderUI;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ViewAllMonstersWindow extends JFrame{

    private GridBagConstraints geometry = new GridBagConstraints();
    private JTextPane monsterDisplay;
    private String[] monsterNames;
    private DefaultListModel<String> monsterList;
    private JList<String> monsterNamesJList;
    private JScrollPane monsterDisplayScroller;
    private JTextField monsterSearchField;


    ViewAllMonstersWindow(){

        geometry.ipadx = 5; geometry.ipady = 5;geometry.insets=new Insets(3,3,3,3);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int monsterDisplayWidth = (int) (screenSize.getWidth() *0.4);
        int monsterDisplayHeight = (int) (screenSize.getHeight() * 0.8);

        setLayout(new GridBagLayout());
        setTitle("Monster Manual");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        monsterDisplay = new JTextPane();

        monsterDisplay.setContentType("text/html");

        monsterNames = MonsterReader.getMonsterDict().keySet().toArray(new String[0]);
        Arrays.sort(monsterNames);

        monsterList = new DefaultListModel<>();

        monsterNamesJList = new JList<>(monsterList);
        for(String str : monsterNames){
            monsterList.addElement(str);
        }

        monsterNamesJList.setSelectedIndex(0);
        monsterNamesJList.setVisibleRowCount(10);

        JScrollPane monsterScroller = new JScrollPane(monsterNamesJList);
        monsterDisplayScroller = new JScrollPane(monsterDisplay);

        monsterSearchField = new JTextField(20);

        monsterDisplay.setPreferredSize(new Dimension(monsterDisplayWidth, monsterDisplayHeight));
        monsterDisplay.setText(MonsterReader.getMonsterDict().get(monsterNames[0]).toString());
        monsterDisplay.setCaretPosition(0);

        monsterDisplayScroller.setPreferredSize(new Dimension(monsterDisplayWidth, monsterDisplayHeight));

        monsterNamesJList.addListSelectionListener(this::buildMonsterDisplay);

        JButton popoutMonster = new JButton("<html>Popout<br>Monster</html>");
        popoutMonster.addActionListener(this::popoutCreature);
        // monsterSearchField.getDocument().addDocumentListener(this::implementSearch);


        monsterSearchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                filter();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                filter();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                filter();

            }

            public void filter(){
                monsterNamesJList.clearSelection();
                monsterList.clear();
                String s = monsterSearchField.getText();
                for(String str : monsterNames){
                    if(str.contains(s)){
                        monsterList.addElement(str);
                    }
                }
                monsterNamesJList.setSelectedIndex(0);
            }
        });
        monsterSearchField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                return;
            }

            @Override
            public void keyPressed(KeyEvent e) {
                shiftFocus(e);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                return;
            }
            public void shiftFocus(KeyEvent e){
                if(e.getKeyChar()==KeyEvent.VK_D || e.getKeyChar()==KeyEvent.VK_ENTER){
                    monsterNamesJList.requestFocus();
                }
            }

        });
        geometry.gridx = 0; geometry.gridy = 0;
        add(monsterSearchField, geometry);
        geometry.gridy = 1; geometry.fill = GridBagConstraints.HORIZONTAL;
        add(monsterScroller, geometry);
        geometry.gridx = 1; geometry.gridy = 0; geometry.gridheight = 3; geometry.fill = GridBagConstraints.CENTER;
        add(monsterDisplayScroller, geometry);
        geometry.gridx = 0; geometry.gridy = 2; geometry.gridheight = 1;
        add(popoutMonster, geometry);
        pack();
        setVisible(true);
        monsterNamesJList.requestFocus();
        setSize(getPreferredSize().width + 50, monsterDisplayHeight+100);
        revalidate();
        repaint();
    }

    public void implementSearch(DocumentEvent e){

            ArrayList<String> updatedMonsterArrayList = new ArrayList<>();
            String searchString = monsterSearchField.getText();
            for (String str : monsterNames) {
                if (str.contains(searchString)) {
                    updatedMonsterArrayList.add(str);
                }
            }
            Collections.sort(updatedMonsterArrayList);
            monsterList.clear();
            for (String str : updatedMonsterArrayList) {
                monsterList.addElement(str);
            }
            revalidate();


    }

    public void buildMonsterDisplay(ListSelectionEvent e){
        if(monsterNamesJList.isFocusOwner()) {
            String selectedMonsterName = monsterNamesJList.getSelectedValue();
            monsterDisplay.setText(MonsterReader.getMonsterDict().get(selectedMonsterName).toString());
            monsterDisplay.setCaretPosition(0);

            monsterDisplayScroller.getViewport().setViewPosition(new Point(0, 0));

            revalidate();
        }
    }

    public void popoutCreature(ActionEvent e) {
        String selectedMonsterName = monsterNames[monsterNamesJList.getSelectedIndex()];
        PopoutMonsterWindow p = new PopoutMonsterWindow(MonsterReader.getMonsterDict().get(selectedMonsterName));
    }

    public void setFocusToMonsterList(KeyEvent e){
        int pressed = e.getKeyChar();
        if(pressed==KeyEvent.VK_DOWN || pressed==KeyEvent.VK_ENTER){
            monsterNamesJList.requestFocus();
        }
    }
}
