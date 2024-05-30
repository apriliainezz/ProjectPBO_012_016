package DAO;

import Koneksi.Connector;
import Model.Menu.ModelMenu;
import java.sql.*;
import java.util.ArrayList;

public class DAOMenu implements InterfaceDAOMenu {

    @Override
    public void insert(ModelMenu menu) {
       try {
            String query = "INSERT INTO menu (nama, harga) VALUES (?,?);";

            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, menu.getNama()); //? ke-1
            statement.setInt(2, menu.getHarga()); //? ke-2
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException e) {
            // Menampilkan pesan error ketika gagal input data.
            System.out.println("Input Failed: (" + e.getLocalizedMessage() + ")");
        } 
    }

    @Override
    public void update(ModelMenu menu) {
        try {
            String query = "UPDATE menu SET nama=?, harga=? WHERE id=?;";
            
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, menu.getNama());
            statement.setInt(2, menu.getHarga());
            statement.setInt(3, menu.getId());
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("Update gagal! (" + e.getMessage() + ")");
        }
    }

    @Override
    public void delete(int id) {
        try {
            String query = "DELETE FROM menu WHERE id=?;";
            
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setInt(1, id);
            
            statement.executeUpdate();
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("Delete gagal: " + e.getLocalizedMessage());
        }
    }

    @Override
    public java.util.List<ModelMenu> getAll() {
         java.util.List<ModelMenu> listMenu = null;

        try {
            listMenu = new ArrayList<>();
            
            Statement statement = Connector.Connect().createStatement();
            
            String query = "SELECT * FROM menu;";
            
            ResultSet resultSet = statement.executeQuery(query);
            

            while (resultSet.next()) {
                ModelMenu mn = new ModelMenu();
                
                mn.setId(resultSet.getInt("id"));
                mn.setNama(resultSet.getString("nama"));
                mn.setHarga(resultSet.getInt("harga"));
                
                listMenu.add(mn);
            }
            
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listMenu;
    }
}