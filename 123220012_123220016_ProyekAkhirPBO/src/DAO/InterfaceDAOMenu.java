package DAO;
import Model.Menu.ModelMenu;
import java.awt.List;

public interface InterfaceDAOMenu {
    public void insert(ModelMenu menu);
    
    public void update(ModelMenu menu);
    
    public void delete(int id);
    
    public java.util.List<ModelMenu> getAll();
}