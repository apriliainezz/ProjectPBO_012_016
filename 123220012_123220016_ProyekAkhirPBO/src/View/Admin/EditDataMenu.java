/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View.Admin;

import Controller.ControllerMenu;
import Model.Menu.ModelMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author ACER
 */
public class EditDataMenu extends JFrame {
    // Membuat sebuah instance bernama controller dari class "ControllerMahasiswa".
    ControllerMenu controller;
    
    JLabel header = new JLabel("Edit Menu");
    JLabel labelInputNama = new JLabel("Nama");
    JLabel labelInputHarga = new JLabel("Harga");
    JTextField inputNama = new JTextField();
    JTextField inputHarga = new JTextField();
    JButton tombolEdit = new JButton("Edit Menu");
    JButton tombolKembali = new JButton("Kembali");

    public EditDataMenu(ModelMenu menu) {
        setTitle("Edit Menu");
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
        add(tombolEdit);
        add(tombolKembali);

        header.setBounds(20, 8, 440, 24);
        labelInputNama.setBounds(20, 32, 440, 24);
        inputNama.setBounds(18, 56, 440, 36);
        labelInputHarga.setBounds(20, 96, 440, 24);
        inputHarga.setBounds(18, 120, 440, 36);
        tombolKembali.setBounds(20, 160, 215, 40);
        tombolEdit.setBounds(240, 160, 215, 40);
        
        inputNama.setText(menu.getNama());
        inputHarga.setText(String.valueOf(menu.getHarga())); 
        
        controller = new ControllerMenu(this);

        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ViewDataMenu();
            }
        });

        tombolEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.editMenu(menu.getId());
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