import javax.swing.*;
import java.util.ArrayList;

public class MSwing {
    private ArrayList<JTextField> textFieldArrayList;
    private ArrayList<JCheckBox> checkBoxArrayList;
    private ArrayList<JTextArea> textAreaArrayList;
    private ArrayList<JComboBox> comboBoxArrayList;
    private ArrayList<JList> listsArrayList;

    public ArrayList<JCheckBox> getCheckBoxArrayList() {
        return checkBoxArrayList;
    }

    public void setCheckBoxArrayList(ArrayList<JCheckBox> checkBoxArrayList) {
        this.checkBoxArrayList = checkBoxArrayList;
    }

    public ArrayList<JTextArea> getTextAreaArrayList() {
        return textAreaArrayList;
    }

    public void setTextAreaArrayList(ArrayList<JTextArea> textAreaArrayList) {
        this.textAreaArrayList = textAreaArrayList;
    }

    public ArrayList<JComboBox> getComboBoxArrayList() {
        return comboBoxArrayList;
    }

    public void setComboBoxArrayList(ArrayList<JComboBox> comboBoxArrayList) {
        this.comboBoxArrayList = comboBoxArrayList;
    }

    public ArrayList<JList> getListsArrayList() {
        return listsArrayList;
    }

    public void setListsArrayList(ArrayList<JList> listsArrayList) {
        this.listsArrayList = listsArrayList;
    }

    public ArrayList<JTextField> getTextFieldArrayList(){
        return textFieldArrayList;
    }
    public void setTextFieldArrayList(ArrayList<JTextField> textFieldArrayList) {
        this.textFieldArrayList = textFieldArrayList;
    }

    MSwing(){
        textFieldArrayList = new ArrayList<>();
        textAreaArrayList = new ArrayList<>();
        checkBoxArrayList = new ArrayList<>();
        comboBoxArrayList = new ArrayList<>();
        listsArrayList = new ArrayList<>();
    }

    public void addJTextField(JTextField j){
        textFieldArrayList.add(j);
    }

    public void addJCheckBox(JCheckBox j){
        checkBoxArrayList.add(j);
    }

    public void addJTextArea(JTextArea j){
        textAreaArrayList.add(j);
    }

    public void addJComboBox(JComboBox j){
        comboBoxArrayList.add(j);
    }

    public void addJList(JList j){
        listsArrayList.add(j);
    }


}
