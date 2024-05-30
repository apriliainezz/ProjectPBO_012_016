/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Koneksi.Connector;
import Model.Menu.ModelOrder;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author ahlul
 */
public class DAOOrder implements InterfaceDAOOrder {

    @Override
    public void insert(ModelOrder order) {
        try {
            String query = "INSERT INTO `order` (nama, menu, ttlharga, size, hot_ice, sweetness, topping, dairy, note) VALUES (?,?,?,?,?,?,?,?,?);";

            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, order.getNama());
            statement.setString(2, order.getMenu());
            statement.setString(3, order.getTtlharga());
            statement.setString(4, order.getSize());
            statement.setString(5, order.getHot_ice());
            statement.setString(6, order.getSweetness());
            statement.setString(7, order.getTopping());
            statement.setString(8, order.getDairy());
            statement.setString(9, order.getNote());
            
            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            // Menampilkan pesan error ketika gagal input data.
            System.out.println("Input Failed: (" + e.getLocalizedMessage() + ")");
        }
    }

//    @Override
//    public List<ModelOrder> getAll() {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
}
