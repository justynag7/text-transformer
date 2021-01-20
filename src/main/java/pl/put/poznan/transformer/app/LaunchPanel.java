package pl.put.poznan.transformer.app;



import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import pl.put.poznan.transformer.exceptions.BadTextTransformationException;
import pl.put.poznan.transformer.logic.TextTransformer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLOutput;
import java.util.ArrayList;

public class LaunchPanel  extends JFrame implements ActionListener {

    JFrame frame;
    JLabel titleLabel;
    JLabel versionLabel;
    JTextArea textArea;
    JTextArea outputArea;
    JTextArea optionsArea;
    JComboBox letterBox;
    JComboBox shortsBox;
    JCheckBox reverseBox;
    JCheckBox numbersBox;
    JCheckBox removeBox;
    JCheckBox latexBox;
    JButton submitButton;
    JButton addButton;
    JButton clearButton;
    JComboBox comboBox;

    LaunchPanel(){

        titleLabel = new JLabel();
        titleLabel.setText("TEXT TRANSFORMER");
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setVerticalAlignment(JLabel.TOP);
        titleLabel.setForeground(new Color(20,43,248)); // set font color of text
        titleLabel.setFont(new Font("MV Boli",Font.PLAIN,50));
        titleLabel.setBounds(60,0,650,100);

        versionLabel = new JLabel();
        versionLabel.setText("ver. 0.1");
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

        optionsArea = new JTextArea();
        optionsArea.setPreferredSize(new Dimension(400,150));
        optionsArea.setBounds(425,150,340,150);
        optionsArea.setEditable(false);
        optionsArea.setLineWrap(true);
        optionsArea.setWrapStyleWord(true);

        String[] lettersOption = {"--Letters Options--","UPPER", "lower","Capitalize" };
        letterBox = new JComboBox(lettersOption);
        letterBox.setBounds(425,100,150,20);
        letterBox.setFocusable(false);
        letterBox.addActionListener(this);
        letterBox.setVisible(false);

        String [] shortsOption = {"--Shortcuts options--","toFullForm","toShortForm"};
        shortsBox = new JComboBox(shortsOption);
        shortsBox.setBounds(585,100,150,20);
        shortsBox.setFocusable(false);
        shortsBox.addActionListener(this);
        shortsBox.setVisible(false);

        reverseBox = new JCheckBox();
        reverseBox.setText("Reverse letters");
        reverseBox.setBackground(Color.cyan);
        reverseBox.setBounds(425,130,150,20);
        reverseBox.setFocusable(false);
        reverseBox.addActionListener(this);
        reverseBox.setVisible(false);

        numbersBox = new JCheckBox();
        numbersBox.setText("Numbers to words");
        numbersBox.setBackground(Color.cyan);
        numbersBox.setBounds(585,130,150,20);
        numbersBox.setFocusable(false);
        numbersBox.addActionListener(this);
        numbersBox.setVisible(false);

        removeBox = new JCheckBox();
        removeBox.setText("Remove repeats");
        removeBox.setBackground(Color.cyan);
        removeBox.setBounds(425,160,150,20);
        removeBox.setFocusable(false);
        removeBox.addActionListener(this);
        removeBox.setVisible(false);

        latexBox = new JCheckBox();
        latexBox.setText("Latex transformation");
        latexBox.setBackground(Color.cyan);
        latexBox.setBounds(585,160,150,20);
        latexBox.setFocusable(false);
        latexBox.addActionListener(this);
        latexBox.setVisible(false);

        submitButton = new JButton();
        submitButton.setText("Submit");
        submitButton.setBounds(425,310,340,40);
        submitButton.setFocusable(false);
        submitButton.setBorder(BorderFactory.createEtchedBorder());
        submitButton.addActionListener(this);

        clearButton = new JButton();
        clearButton.setText("Clear");
        clearButton.setBounds(665,100,100,40);
        clearButton.setFocusable(false);
        clearButton.setBorder(BorderFactory.createEtchedBorder());
        clearButton.addActionListener(this);

        addButton = new JButton();
        addButton.setText("Add");
        addButton.setBounds(555,100,100,40);
        addButton.addActionListener(this);

        String [] options = {"--Options--","upper", "lower",
                             "capitalize","toShortForm","toFullForm","inverse",
                             "duplicates", "numbersToText", "latexFormat"};
        
        comboBox = new JComboBox(options);
        comboBox.setBounds(425,100,120,40);
        comboBox.setFocusable(false);
        comboBox.addActionListener(this);


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
        frame.add(comboBox);
        frame.add(optionsArea);
        frame.add(addButton);
        frame.add(clearButton);
        frame.setVisible(true);

    }
    String opt = "";

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==addButton){
            opt= opt + comboBox.getSelectedItem().toString() ;
            optionsArea.setText(opt);
            opt = opt + ",";

        }
        if(e.getSource()==clearButton){
            opt="";
            optionsArea.setText(opt);
        }
        if(e.getSource()==submitButton){


            String text = textArea.getText();

            String[] transform = optionsArea.getText().split(",");
            try {
                TextTransformer transformer = new TextTransformer(transform);
                text = transformer.transform(text);
            }
            catch(BadTextTransformationException ex){
                System.out.println("Error! Transformation error!");
            }


            /*
            String [] transforms = new String[30];

            for(int i=0;i<30;i++)
            {
                transforms[i] = "nochange";
            }
            int n = 0;
            if(letterBox.getSelectedIndex()!=0){
                transforms[n++] = letterBox.getSelectedItem().toString().toLowerCase();
                //System.out.println(letterBox.getSelectedItem());
            }
            if(shortsBox.getSelectedIndex()!=0){
                transforms[n++] = shortsBox.getSelectedItem().toString();
                //System.out.println(shortsBox.getSelectedItem());
            }
            if(reverseBox.isSelected()){
                transforms[n++] = "inverse";
                //System.out.println("Reverse option is selected");
            }
            if(removeBox.isSelected()){
                transforms[n++] = "duplicates";
                //System.out.println("Remove repeats option is selected");
            }
            if(numbersBox.isSelected()){
                transforms[n++] = "numbersToText";
                //System.out.println("Numbers to words option is selected");
            }
            if(latexBox.isSelected()) {
                transforms[n++] = "latexFormat";
                //System.out.println("Latex transformation option is selected");
            }
            try {
                TextTransformer transformer = new TextTransformer(transforms);
                text = transformer.transform(text);
            }
            catch(BadTextTransformationException ex){
                System.out.println("Error! Transformation error!");
            }
            /*
            for(int i=0;i<10;i++)
            {
                System.out.println(transforms[i]);
            }*/
            System.out.println("-------TEXT TRANSFORMED!-------");

            outputArea.setText(text);

        }

    }
}
