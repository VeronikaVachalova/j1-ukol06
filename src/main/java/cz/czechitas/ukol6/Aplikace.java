package cz.czechitas.ukol6;
import com.formdev.flatlaf.FlatLightLaf;
import net.miginfocom.swing.MigLayout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Aplikace extends JFrame {
    private JLabel husyLabel;
    private JLabel kraliciLabel;
    private JTextField husyField;
    private JTextField kraliciField;
    private JButton vypocitatButton;
    private JLabel pocetHlavLabel;
    private JLabel pocetNohouLabel;
    private JTextField pocetHlavField;
    private JTextField pocetNohouField;


    public static void main(String[] args) {
        FlatLightLaf.setup();
        new Aplikace().start();
    }

    public Aplikace() throws HeadlessException {
        super("Farmářka 1.0");
        this.init();
    }

    public void start() {
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void init() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setIconImage(new ImageIcon(Aplikace.class.getResource("czechitas-icon.png")).getImage());
        setLayout(new MigLayout("wrap 2", "[right]rel[50:120:150,grow,fill]"));
        setMinimumSize(new Dimension(250, 200));

        //TODO implementovat formulář podle zadání
        husyField = new JTextField();
        husyLabel = new JLabel("Husy");
        husyLabel.setDisplayedMnemonic('H');
        husyLabel.setLabelFor(husyField);
        add(husyLabel);
        add(husyField);
        husyField.setHorizontalAlignment(JTextField.TRAILING);

        kraliciField = new JTextField();
        kraliciLabel = new JLabel("Kralici");
        kraliciLabel.setDisplayedMnemonic('K');
        kraliciLabel.setLabelFor(kraliciField);
        add(kraliciLabel);
        add(kraliciField);
        kraliciField.setHorizontalAlignment(JTextField.TRAILING);

        vypocitatButton = new JButton("Vypocitat");
        vypocitatButton.setMnemonic('V');
        add(vypocitatButton,"center, span");
        vypocitatButton.addActionListener(this::vypocitatPocty);

        pocetHlavField = new JTextField();
        pocetHlavLabel = new JLabel("Pocet hlav");
        pocetHlavLabel.setLabelFor(pocetHlavField);
        add(pocetHlavLabel);
        add(pocetHlavField, "span");
        pocetHlavField.setHorizontalAlignment(JTextField.TRAILING);
        pocetHlavField.setEnabled(true);
        pocetHlavField.setEditable(false);

        pocetNohouField = new JTextField();
        pocetNohouLabel = new JLabel("Pocet nohou");
        pocetNohouLabel.setLabelFor(pocetNohouField);
        add(pocetNohouLabel);
        add(pocetNohouField, "span");
        pocetNohouField.setHorizontalAlignment(JTextField.TRAILING);
        pocetNohouField.setEnabled(true);
        pocetNohouField.setEditable(false);

        pack();
    }

    private void vypocitatPocty (ActionEvent actionEvent) {

        String husyText1 = husyField.getText();
        String kraliciText1 = kraliciField.getText();

        int husyCislo1 = Integer.parseInt(husyText1);
        int kraliciCislo1 = Integer.parseInt(kraliciText1);

        int pocetHlavCislo2 = ((1 * husyCislo1) + (1 * kraliciCislo1));
        int pocetNohouCislo2 = ((2 * husyCislo1) + (4 * kraliciCislo1));

        String pocetHlav = Integer.toString(pocetHlavCislo2);
        String pocetNohou = Integer.toString(pocetNohouCislo2);

        pocetHlavField.setText(Integer.toString(pocetHlavCislo2));
        pocetNohouField.setText(Integer.toString(pocetNohouCislo2));
    }
}

