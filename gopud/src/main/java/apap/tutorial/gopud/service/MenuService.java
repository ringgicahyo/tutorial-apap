package apap.tutorial.gopud.service;


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
    MenuModel deleteMenu(MenuModel menu);
    List<MenuModel> getListMenuOrderByHargaAsc(long idRestoran);
}