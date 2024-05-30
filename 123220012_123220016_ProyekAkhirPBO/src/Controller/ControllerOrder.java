package Controller;

import DAO.DAOMenu;
import DAO.DAOOrder;
import DAO.InterfaceDAOMenu;
import DAO.InterfaceDAOOrder;
import Model.Menu.ModelMenu;
import Model.Menu.ModelOrder;
import Model.Menu.ModelTableMenu;
import View.User.ViewHalamanOrder;
import View.User.ViewHalamanResult;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * author ACER
 */
public class ControllerOrder {

    ViewHalamanOrder viewhalamanorder;
    String nameMenu;
    int Hdefault;

    InterfaceDAOMenu daoMenu;
    InterfaceDAOOrder daoOrder;

    public ControllerOrder(ViewHalamanOrder viewhalamanorder) {
        this.viewhalamanorder = viewhalamanorder;
        this.daoMenu = new DAOMenu();
        this.daoOrder = new DAOOrder();
    }

    public void showAllMenu() {
        java.util.List<ModelMenu> daftarMenu = daoMenu.getAll();
        ModelTableMenu table = new ModelTableMenu(daftarMenu);
        viewhalamanorder.getTabelDataMenu().setModel(table);
    }

    public void pesan(String hotice, String size, String sweetness, String dairy, String topping, int jumlahTopping) {
        try {
            ModelOrder orderBaru = new ModelOrder();

            String nama = viewhalamanorder.getNamaCust().getText();
            if (nameMenu == null || nameMenu.isEmpty() || Hdefault <= 0) {
                JOptionPane.showMessageDialog(null, "Nama menu belum dipilih.");
                return; // Stop further execution
            }
        
            String hargaString = String.valueOf(Hdefault);

            orderBaru.setMenu(nameMenu);
            orderBaru.setTtlharga(hargaString); // Anda harus mengganti ini dengan harga yang sesuai
            orderBaru.setSize(size);
            orderBaru.setHot_ice(hotice);
            orderBaru.setSweetness(sweetness);
            orderBaru.setTopping(topping);
            orderBaru.setDairy(dairy);

            JTextArea noteTextArea = viewhalamanorder.getNotes();
            String noteText = noteTextArea.getText(); // Mendapatkan teks dari JTextArea
            orderBaru.setNote(noteText);
        
            if ("".equals(nama)) {
                throw new Exception("Nama tidak boleh kosong!");
            }

            daoOrder.insert(orderBaru);

            // Menutup view sebelumnya (ViewHalamanOrder) dan membuka ViewHalamanResult
            viewhalamanorder.dispose();
            new ViewHalamanResult(orderBaru).setVisible(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void getName(int selectedRow) {
        nameMenu = (String) viewhalamanorder.getTabelDataMenu().getValueAt(selectedRow, 1);
        Hdefault = (Integer) viewhalamanorder.getTabelDataMenu().getValueAt(selectedRow, 2);
    }    
}
