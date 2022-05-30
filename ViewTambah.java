package manage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

public class ViewTambah extends JFrame{
    JLabel judul = new JLabel("TAMBAH BARANG");
    JLabel lnama = new JLabel("Nama Barang");
    JTextField tfnama = new JTextField();
    JLabel lmassa = new JLabel("Massa (gr)");
    JTextField tfmassa = new JTextField();
    JLabel lharga = new JLabel("Harga /pcs");
    JTextField tfharga = new JTextField();
    
    JButton btnAdd = new JButton("Add");
    JButton btnDelete = new JButton("Delete");
    JButton btnEdit = new JButton("Edit");
    JButton btnExit = new JButton("Exit");
    JButton btnBack = new JButton("Back");
    
    JTable tabel;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    Object namaKolom[] = {"ID Barang", "Nama Barang", "Massa (gr)", "Harga /pcs"};
    
    public ViewTambah(){
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
        add(lnama);
        lnama.setBounds(30, 100, 120, 20);
        add(tfnama);
        tfnama.setBounds(180, 100, 150, 20);
        add(lmassa);
        lmassa.setBounds(30, 130, 120, 20);
        add(tfmassa);
        tfmassa.setBounds(180, 130, 150, 20);
        add(lharga);
        lharga.setBounds(30, 160, 120, 20);
        add(tfharga);
        tfharga.setBounds(180, 160, 150, 20);
        add(btnAdd);
        btnAdd.setBounds(550, 130, 100, 30);
        btnAdd.setForeground(new java.awt.Color(255, 255, 255));
        btnAdd.setFont(new Font("Aharoni",Font.BOLD,15));
        btnAdd.setBackground(new java.awt.Color(43, 84, 128));
        add(btnDelete);
        btnDelete.setBounds(675, 130, 100, 30);
        btnDelete.setForeground(new java.awt.Color(255, 255, 255));
        btnDelete.setFont(new Font("Aharoni",Font.BOLD,15));
        btnDelete.setBackground(new java.awt.Color(43, 84, 128));
        add(btnEdit);
        btnEdit.setBounds(550, 170, 100, 30);
        btnEdit.setForeground(new java.awt.Color(255, 255, 255));
        btnEdit.setFont(new Font("Aharoni",Font.BOLD,15));
        btnEdit.setBackground(new java.awt.Color(43, 84, 128));
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
    
    public String getNama()
    {
        return tfnama.getText();
    }
    public String getMassa()
    {
        return tfmassa.getText();
    }
   public String getHarga()
   {
       return tfharga.getText();
   }
}
