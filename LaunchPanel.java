import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LaunchPanel  extends JFrame implements ActionListener {

    JFrame frame;
    JLabel titleLabel;
    JLabel versionLabel;
    JTextArea textArea;
    JTextArea outputArea;
    JComboBox letterBox;
    JComboBox shortsBox;
    JCheckBox reverseBox;
    JCheckBox numbersBox;
    JCheckBox removeBox;
    JCheckBox latexBox;
    JButton submitButton;

    LaunchPanel(){

        titleLabel = new JLabel();
        titleLabel.setText("TEXT TRANSFORMER");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.TOP);
        titleLabel.setForeground(new Color(20,43,248)); // set font color of text
        titleLabel.setFont(new Font("MV Boli",Font.PLAIN,50));
        titleLabel.setBounds(60,0,650,100);

        versionLabel = new JLabel();
        versionLabel.setText("ver. 1.0");
        versionLabel.setHorizontalAlignment(JLabel.RIGHT);
        versionLabel.setVerticalAlignment(JLabel.BOTTOM);
        versionLabel.setForeground(new Color(0,0,0)); // set font color of text
        versionLabel.setFont(new Font("Arial",Font.PLAIN,10));
        versionLabel.setBounds(60,0,600,70);

        textArea = new JTextArea();
        textArea.setPreferredSize(new Dimension(400,150));
        textArea.setBounds(5,100,400,150);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setFont(new Font("Consolas",Font.PLAIN,25));
        textArea.setForeground(Color.green);
        textArea.setBackground(Color.black);
        textArea.setCaretColor(Color.green);
        textArea.setText("(Insert your text here)");

        outputArea = new JTextArea();
        outputArea.setPreferredSize(new Dimension(400,150));
        outputArea.setBounds(5,300,400,150);
        outputArea.setLineWrap(true);
        outputArea.setWrapStyleWord(true);
        outputArea.setFont(new Font("Consolas",Font.PLAIN,25));
        outputArea.setForeground(Color.green);
        outputArea.setBackground(Color.black);
        outputArea.setCaretColor(Color.green);
        outputArea.setText("(Output)");
        outputArea.setEditable(false);

        String[] lettersOption = {"--Letters Options--","UPPER", "lower","Capitalize" };
        letterBox = new JComboBox(lettersOption);
        letterBox.setBounds(425,100,150,20);
        letterBox.setFocusable(false);
        letterBox.addActionListener(this);

        String [] shortsOption = {"--Shortcuts options--","expand","colapse"};
        shortsBox = new JComboBox(shortsOption);
        shortsBox.setBounds(585,100,150,20);
        shortsBox.setFocusable(false);
        shortsBox.addActionListener(this);

        reverseBox = new JCheckBox();
        reverseBox.setText("Reverse letters");
        reverseBox.setBackground(Color.cyan);
        reverseBox.setBounds(425,130,150,20);
        reverseBox.setFocusable(false);
        reverseBox.addActionListener(this);

        numbersBox = new JCheckBox();
        numbersBox.setText("Numbers to words");
        numbersBox.setBackground(Color.cyan);
        numbersBox.setBounds(585,130,150,20);
        numbersBox.setFocusable(false);
        numbersBox.addActionListener(this);

        removeBox = new JCheckBox();
        removeBox.setText("Remove repeats");
        removeBox.setBackground(Color.cyan);
        removeBox.setBounds(425,160,150,20);
        removeBox.setFocusable(false);
        removeBox.addActionListener(this);

        latexBox = new JCheckBox();
        latexBox.setText("Latex transformation");
        latexBox.setBackground(Color.cyan);
        latexBox.setBounds(585,160,150,20);
        latexBox.setFocusable(false);
        latexBox.addActionListener(this);

        submitButton = new JButton();
        submitButton.setText("Submit");
        submitButton.setBounds(425,190,310,40);
        submitButton.setFocusable(false);
        submitButton.setBorder(BorderFactory.createEtchedBorder());
        submitButton.addActionListener(this);

        frame = new JFrame("Text Transformer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,500);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.add(titleLabel);
        frame.add(textArea);
        frame.add(outputArea);
        frame.add(letterBox);
        frame.add(shortsBox);
        frame.add(reverseBox);
        frame.add(numbersBox);
        frame.add(removeBox);
        frame.add(latexBox);
        frame.add(submitButton);
        frame.add(versionLabel);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==submitButton){

            System.out.println(textArea.getText());

            if(letterBox.getSelectedIndex()!=0){
                //TODO
                System.out.println(letterBox.getSelectedItem());
            }
            if(shortsBox.getSelectedIndex()!=0){
                //TODO
                System.out.println(shortsBox.getSelectedItem());
            }
            if(reverseBox.isSelected()){
                //TODO
                System.out.println("Reverse option is selected");
            }
            if(removeBox.isSelected()){
                //TODO
                System.out.println("Remowe repeats option is selected");
            }
            if(numbersBox.isSelected()){
                //TODO
                System.out.println("Numbers to words option is selected");
            }
            if(latexBox.isSelected()){
                //TODO
                System.out.println("Latex transformation option is selected");
            }
            //TODO
            System.out.println("-------TEXT TRANSFORMED!-------");
            outputArea.setText(textArea.getText());

        }

    }
}
