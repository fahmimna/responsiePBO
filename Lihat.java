/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package manage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class Lihat extends JFrame{
    JLabel judul = new JLabel("TAMBAH BARANG");

    JButton btnExit = new JButton("Exit");
    JButton btnBack = new JButton("Back");
    
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"ID Barang", "Nama Barang", "Massa (gr)", "Harga /pcs"};
    
    public Lihat(){
        tableModel = new DefaultTableModel(namaKolom, 0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        
        setTitle("Data Pesanan");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setLayout(null);
        setSize(900, 600);
        setLocation(200, 50);
        this.getContentPane().setBackground(Color.YELLOW);
      
        add(judul);
        judul.setBounds(350, 30, 300, 30);
        judul.setForeground(new java.awt.Color(43, 84, 128));
        judul.setFont(new Font("Bauhaus 93",Font.PLAIN,30));
        add(btnExit);
        btnExit.setBounds(675, 170, 100, 30);
        btnExit.setForeground(new java.awt.Color(255, 255, 255));
        btnExit.setFont(new Font("Aharoni",Font.BOLD,15));
        btnExit.setBackground(new java.awt.Color(43, 84, 128));
        add(btnBack);
        btnBack.setBounds(615, 210, 100, 30);
        btnBack.setForeground(new java.awt.Color(255, 255, 255));
        btnBack.setFont(new Font("Aharoni",Font.BOLD,15));
        btnBack.setBackground(new java.awt.Color(43, 84, 128));
        
        //TABEL
        add(scrollPane); 
        scrollPane.setBounds(20, 200, 480, 300);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        //scrollpane-nya vertikal
        
        btnExit.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                dispose();
            }
        });
        
        btnBack.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                ViewAwal view = new ViewAwal();
                dispose();
            }
        });
    }
}