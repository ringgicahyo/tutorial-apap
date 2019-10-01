package apap.tutorial.gopud.service;

import java.util.List;
import java.util.Optional;
import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.repository.MenuDB;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDB menuDB;

    @Override
    public void addMenu(MenuModel menu) {
        menuDB.save(menu);
    }

    @Override
    public List<MenuModel> findAllMenuByIdRestoran(long idRestoran) {
        return menuDB.findByRestoranIdRestoran(idRestoran);
    }

    @Override
    public MenuModel changeMenu(MenuModel menuModel) {
        // mengambil object menu yang ingin diubah
        MenuModel targetMenu = menuDB.findById(menuModel.getId()).get();

        try {
            targetMenu.setNama(menuModel.getNama());
            targetMenu.setDeskripsi(menuModel.getDeskripsi());
            targetMenu.setHarga(menuModel.getHarga());
            targetMenu.setDurasiMasak(menuModel.getDurasiMasak());
            menuDB.save(targetMenu);
            return targetMenu;
        } catch (NullPointerException nullException) {
            return null;
        }
    }

    @Override
    public Optional<MenuModel> getMenuById(Long id) {
        return menuDB.findById(id);
    }

    @Override
    public List<MenuModel> listMenu(long idRestoran) {
        return menuDB.findByRestoranIdRestoran(idRestoran);
    }

    @Override
    public void deleteMenu(MenuModel menu) {
        MenuModel targetMenu = menuDB.findById(menu.getId()).get();
        menuDB.delete(targetMenu);
    }
}