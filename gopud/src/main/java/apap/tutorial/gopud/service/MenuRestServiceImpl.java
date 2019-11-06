package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.repository.MenuDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
public class MenuRestServiceImpl implements MenuRestService {
    @Autowired
    private MenuDB menuDB;

    @Autowired
    RestoranRestService restoranRestService;

    @Override
    public MenuModel createMenu(MenuModel menu) {
        return menuDB.save(menu);
    }

    @Override
    public List<MenuModel> retrieveListMenu() {
        return menuDB.findAll();
    }

    @Override
    public MenuModel getMenuById(Long id) {
        Optional<MenuModel> menu = menuDB.findById(id);
        if (menu.isPresent()) return menu.get();
        else throw new NoSuchElementException();
    }

    @Override
    public MenuModel changeMenu(Long id, MenuModel menuUpdate) {
        MenuModel menu = getMenuById(id);
        menu.setNama(menuUpdate.getNama());
        menu.setDeskripsi(menuUpdate.getDeskripsi());
        menu.setHarga(menuUpdate.getHarga());
        menu.setDurasiMasak(menuUpdate.getDurasiMasak());
        return menuDB.save(menu);
    }

    @Override
    public void deleteMenu(Long id) {
        MenuModel menu = getMenuById(id);
        menuDB.delete(menu);
    }
}
