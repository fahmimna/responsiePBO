package manage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Random;
import javax.swing.JOptionPane;

public class Gudang {
    String PtotalHarga;
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost/barang";
    static final String USER = "root";
    static final String PASS = "";
    
    Connection koneksi;
    Statement statement;
    
    public Gudang(){
      
        try //koneksi database
        {
            Class.forName(JDBC_DRIVER);
            koneksi = (Connection) DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("Connected");
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Connection Failed");
        }
    }
    public void insertBarang(String nama, String massa, String harga)//insert
    {
          try
        {
            String sql = "INSERT INTO `barang` (`nama`, `massa`, `harga`)"
                    + "VALUES ('"+nama+"', '"+massa+"', '"+harga+"')";  
            statement.executeUpdate(sql);
        }
        catch(Exception sql)
        {
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage());            
        }
    }
    public void updateBarang(String nama, String massa, String harga) //update
    {
         try {
      
            String sql = "UPDATE `barang` SET `nama` = '"+nama+"', `massa` = '"+massa+"', `harga` = '"+harga+"' WHERE `nama` = '"+nama+"'";  
            statement.executeUpdate(sql);
        } catch(SQLException sql){
            System.out.println(sql.getMessage());
            JOptionPane.showMessageDialog(null, sql.getMessage()); 
        }
    }
    public void deleteBarang(String id)//delete 
    {
         try{
            String query = "DELETE FROM `barang` WHERE `id` = '"+id+"'";
            statement = koneksi.createStatement();
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");       
        }catch(SQLException sql){
            System.out.println(sql.getMessage());
        }
    }
      public int getBanyakKatalog()
    {
         int jmlData = 0;
        try
        {
            statement = koneksi.createStatement();
            String query = "Select * from `barang`";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                jmlData++;
            }
            return jmlData;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    public String[][] readKatalog()
    {
       try
        {
            int jmlData = 0;
            String data[][] = new String[getBanyakKatalog()][3];
            String query = "SELECT * FROM `barang`;";
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next())
            {
                data[jmlData][0] = resultSet.getString("nama");
                data[jmlData][1] = resultSet.getString("massa");
                data[jmlData][2] = resultSet.getString("harga");
                jmlData++;
            }
            return data;
        }
        catch(SQLException e)
        {
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return null;
        }  
    }
}
