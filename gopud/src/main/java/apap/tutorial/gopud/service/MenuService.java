package apap.tutorial.gopud.service;

<<<<<<< HEAD
=======
import java.math.BigInteger;
>>>>>>> feat/tutorial-3-gopud-v2
import java.util.List;
import java.util.Optional;

import apap.tutorial.gopud.model.MenuModel;
import org.springframework.stereotype.Service;

@Service
public interface MenuService {
    void addMenu(MenuModel menu);
    List<MenuModel> findAllMenuByIdRestoran(long idRestoran);
    Optional<MenuModel> getMenuById(Long id);
    MenuModel changeMenu(MenuModel menuModel);
    List<MenuModel> listMenu(long idRestoran);
    void deleteMenu(MenuModel menu);
}