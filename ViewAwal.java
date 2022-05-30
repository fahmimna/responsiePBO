package manage;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class ViewAwal extends JFrame 
{
    JButton btnTambah = new JButton("TAMBAH");
    JButton btnLihat = new JButton("LIHAT");
    JLabel judul = new JLabel(" M A I N   M E N U");
    
    public ViewAwal()
    {
     setTitle("Menu Awal");
     setDefaultCloseOperation(EXIT_ON_CLOSE);
     setVisible(true);
     setLayout(null);
     setSize(400,300);
     setLocation(500,100);
     this.getContentPane().setBackground(Color.YELLOW);
     
   add(judul);
        judul.setBounds(75, 10, 300, 50);
        judul.setForeground(new java.awt.Color(43, 84, 128));
        judul.setFont(new Font("Algerian",Font.BOLD,28));
        add(btnTambah);
        btnTambah.setBounds(95, 75, 200, 50);
        btnTambah.setForeground(new java.awt.Color(255, 255, 255));
        btnTambah.setFont(new Font("Aharoni",Font.BOLD,18));
        btnTambah.setBackground(new java.awt.Color(43, 84, 128));
        add(btnLihat);
        btnLihat.setBounds(95, 150, 200, 50);
        btnLihat.setForeground(new java.awt.Color(255, 255, 255));
        btnLihat.setFont(new Font("Aharoni",Font.BOLD,18));
        btnLihat.setBackground(new java.awt.Color(43, 84, 128));
     
    btnLihat.addActionListener(new ActionListener()
     {
         @Override
         public void actionPerformed(ActionEvent e)
         {  
              Lihat lihat = new Lihat();
             dispose();
         }
     });
     
   btnTambah.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
               Tambah tambah = new Tambah();
                dispose();
            }
        });
       
   }
    
}
