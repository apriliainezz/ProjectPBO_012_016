package Controller;

import DAO.DAOMenu;
import DAO.InterfaceDAOMenu;
import Model.Menu.ModelMenu;
import Model.Menu.ModelTableMenu;
import View.Admin.EditDataMenu;
import View.Admin.InputDataMenu;
import View.Admin.ViewDataMenu;
import java.util.List;
import javax.swing.JOptionPane;

public class ControllerMenu {

    ViewDataMenu halamanTable;
    InputDataMenu halamanInput;
    EditDataMenu halamanEdit;

    InterfaceDAOMenu daoMenu;
    java.util.List<ModelMenu> daftarMenu;

    public ControllerMenu(ViewDataMenu halamanTable) {
        this.halamanTable = halamanTable;
        this.daoMenu = new DAOMenu();
    }

    public ControllerMenu(InputDataMenu halamanInput) {
        this.halamanInput = halamanInput;
        this.daoMenu = new DAOMenu();
    }

    public ControllerMenu(EditDataMenu halamanEdit) {
        this.halamanEdit = halamanEdit;
        this.daoMenu = new DAOMenu();
    }


    public void showAllMenu() {
        daftarMenu = daoMenu.getAll();

        ModelTableMenu table = new ModelTableMenu(daftarMenu);

        halamanTable.getTableMenu().setModel(table);
    }

    public void insertMenu() {
        try {
            ModelMenu menuBaru = new ModelMenu();

            String nama = halamanInput.getInputNama();
            String hargaString = halamanInput.getInputHarga();

            if ("".equals(nama) || "".equals(hargaString)) {
                throw new Exception("Nama Menu atau Harga tidak boleh kosong!");
            }

            int harga = Integer.parseInt(hargaString);

            menuBaru.setNama(nama);
            menuBaru.setHarga(harga);

            daoMenu.insert(menuBaru);

            JOptionPane.showMessageDialog(null, "Menu baru berhasil ditambahkan.");

            halamanInput.dispose();
            new ViewDataMenu();
        } catch (Exception e) {
            // Menampilkan pop-up ketika terjadi error
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void editMenu(int id) {
        try {
            ModelMenu menuYangMauDiedit = new ModelMenu();

            String nama = halamanEdit.getInputNama();
            String hargaString = halamanEdit.getInputHarga();

            if ("".equals(nama) || "".equals(hargaString)) {
                throw new Exception("Nama Menu atau Harga tidak boleh kosong!");
            }

            int harga = Integer.parseInt(hargaString);

            menuYangMauDiedit.setId(id);
            menuYangMauDiedit.setNama(nama);
            menuYangMauDiedit.setHarga(harga);

            daoMenu.update(menuYangMauDiedit);

            JOptionPane.showMessageDialog(null, "Data menu berhasil diubah.");

            halamanEdit.dispose();
            new ViewDataMenu();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void deleteMenu(Integer baris) {
        Integer id = (int) halamanTable.getTableMenu().getValueAt(baris, 0);
        String nama = halamanTable.getTableMenu().getValueAt(baris, 1).toString();

        int input = JOptionPane.showConfirmDialog(
                null,
                "Hapus " + nama + "?",
                "Hapus Menu",
                JOptionPane.YES_NO_OPTION
        );

        if (input == 0) {
            daoMenu.delete(id);

            JOptionPane.showMessageDialog(null, "Berhasil menghapus menu.");

            showAllMenu();
        }
    }
}
