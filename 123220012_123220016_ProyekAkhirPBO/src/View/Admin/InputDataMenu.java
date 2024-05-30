package View.Admin;

import Controller.ControllerMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class InputDataMenu extends JFrame {
    ControllerMenu controller;
    
    JLabel header = new JLabel("Input Menu");
    JLabel labelInputNama = new JLabel("Nama");
    JLabel labelInputHarga = new JLabel("Harga");
    JTextField inputNama = new JTextField();
    JTextField inputHarga = new JTextField();
    JButton tombolTambah = new JButton("Tambah Menu");
    JButton tombolKembali = new JButton("Kembali");

    public InputDataMenu() {
        setTitle("Input Menu");
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(480, 240);
        setLocationRelativeTo(null);
        setLayout(null);

        add(header);
        add(labelInputNama);
        add(labelInputHarga);
        add(inputNama);
        add(inputHarga);
        add(tombolTambah);
        add(tombolKembali);

        header.setBounds(20, 8, 440, 24);
        labelInputNama.setBounds(20, 32, 440, 24);
        inputNama.setBounds(18, 56, 440, 36);
        labelInputHarga.setBounds(20, 96, 440, 24);
        inputHarga.setBounds(18, 120, 440, 36);
        tombolKembali.setBounds(20, 160, 215, 40);
        tombolTambah.setBounds(240, 160, 215, 40);
        
        controller = new ControllerMenu(this);

        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewDataMenu();
                
            }
        });

        tombolTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.insertMenu();
            }
        });
    }

    public String getInputNama() {
        return inputNama.getText();
    }

    public String getInputHarga() {
        return inputHarga.getText();
    }
}
