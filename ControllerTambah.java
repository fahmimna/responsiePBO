package manage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class ControllerTambah {
    ViewTambah viewTambah;
    Gudang gudang;
     ControllerTambah(ViewTambah viewTambah, Gudang gudang) {
        this.viewTambah = viewTambah;
        this.gudang = gudang;
        
        if(gudang.getBanyakKatalog()!= 0){
            String dataKatalog[][] = gudang.readKatalog();
            viewTambah.tabel.setModel((new JTable(dataKatalog, viewTambah.namaKolom)).getModel());
        }else{
            JOptionPane.showMessageDialog(null,"data Tak ada");
            
        }
        viewTambah.btnAdd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
               if (viewTambah.getNama().equals("")
                        || viewTambah.getMassa().equals("")
                        || viewTambah.getHarga().equals("")){
                    JOptionPane.showMessageDialog(null,"Field tak boleh kosong");
                }else {
                    String nama_barang = viewTambah.getNama();
                    String massa_barang = viewTambah.getMassa();
                    String harga_barang = viewTambah.getHarga();

                    gudang.insertBarang(nama_barang, massa_barang, harga_barang);
                    viewTambah.tfnama.setText("");
                    viewTambah.tfmassa.setText("");
                    viewTambah.tfharga.setText("");

                    String dataKatalog[][]= gudang.readKatalog();
                    viewTambah.tabel.setModel((new JTable(dataKatalog, viewTambah.namaKolom)).getModel());
                } //To change body of generated methods, choose Tools | Templates.
            }
        });
         viewTambah.tabel.addMouseListener (new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e){
                int baris = viewTambah.tabel.getSelectedRow();
                int kolom = viewTambah.tabel.getSelectedColumn();
                String dataterpilih = viewTambah.tabel.getValueAt(baris, 0).toString();
                System.out.println(dataterpilih);
                
                String nama_barang =viewTambah.tabel.getValueAt(baris, 0).toString();
                viewTambah.tfnama.setText(nama_barang);
                String massa_barang =viewTambah.tabel.getValueAt(baris, 1).toString();
                viewTambah.tfmassa.setText(massa_barang);
                String harga_barang =viewTambah.tabel.getValueAt(baris, 2).toString();
                viewTambah.tfharga.setText(harga_barang);
                
                
                viewTambah.btnEdit.addActionListener(new ActionListener(){
                     @Override
                     public void actionPerformed(ActionEvent e){ 

                            String nama_barang = viewTambah.getNama();
                            String massa_barang = viewTambah.getMassa();
                            String harga_barang = viewTambah.getHarga();
                            gudang.updateBarang(nama_barang, massa_barang, harga_barang);


                        String dataKatalog[][]= gudang.readKatalog();
                        viewTambah.tabel.setModel(new JTable(dataKatalog, viewTambah.namaKolom).getModel());

                    }
                });
                
                viewTambah.btnDelete.addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e){
                        int input =JOptionPane.showConfirmDialog(null, "Apa anda ingin menghapus Id Buah" + dataterpilih + " ?" , "Pilih Opsi...." , JOptionPane.YES_NO_CANCEL_OPTION);
                        if(input==0){
                            gudang.deleteBarang(dataterpilih);
                            String dataKatalog[][]= gudang.readKatalog();
                            viewTambah.tabel.setModel(new JTable(dataKatalog, viewTambah.namaKolom).getModel());
                        }else{
                            JOptionPane.showMessageDialog(null,"Tidak Jadi Dihapus");
                        }
                   }
                });
            }
        });
     }     
}
