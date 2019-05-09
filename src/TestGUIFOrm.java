import javax.swing.*;

public class TestGUIFOrm {
    private JLabel chrNameSub;
    private JTextField classField;
    private JTextField raceField;
    private JTextField chrNameTextBox;
    private JTextField backgroundField;
    private JTextField alignField;
    private JTextField playerNameField;
    private JTextField expField;
    private JTextField strField;
    private JLabel strengthLabel;
    private JLabel strModLabel;
    private JTextField a0TextField;
    private JTextField textField1;
    private JCheckBox ___StrengthCheckBox;
    private JCheckBox checkBox1;

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    public void buildShowSheet(PlayerCharacter p){

        strModLabel.setText(""+p.getStrMod());
    }
}
