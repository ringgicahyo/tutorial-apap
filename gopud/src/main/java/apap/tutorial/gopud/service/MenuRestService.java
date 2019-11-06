package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.MenuModel;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public interface MenuRestService {
    MenuModel createMenu(MenuModel menu);
    List<MenuModel> retrieveListMenu();
    MenuModel getMenuById(Long id);
    MenuModel changeMenu(Long id, MenuModel menuUpdate);
    void deleteMenu(Long id);
}
