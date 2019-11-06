package apap.tutorial.gopud.restcontroller;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.service.MenuRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
public class MenuRestController {
    @Autowired
    private MenuRestService menuRestService;

    @PostMapping(value = "/menu")
    private MenuModel createMenu(@Valid @RequestBody MenuModel menu, BindingResult bindingResult){
        if (bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field");
        }
        else {
            return menuRestService.createMenu(menu);
        }
    }

    @GetMapping(value = "/menu/{id}")
    private MenuModel retrieveMenu(@PathVariable("id") Long id){
        try {
            return menuRestService.getMenuById(id);
        } catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ID Menu " + String.valueOf(id) + " Not Found");
        }
    }

    @DeleteMapping(value = "/menu/{id}")
    private ResponseEntity<String> deleteMenu(@PathVariable(value = "id") Long id) {
        try{
            menuRestService.deleteMenu(id);
            return ResponseEntity.ok("Menu with ID " + String.valueOf(id) + " Deleted!");
        } catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Menu with ID " + String.valueOf(id) + " Not Found!");
        }
    }

    @PutMapping(value = "/menu/{id}")
    private MenuModel updateMenu(
            @PathVariable(value = "id") Long id,
            @RequestBody MenuModel menu
    ) {
        try {
            return menuRestService.changeMenu(id, menu);
        } catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "ID Menu " + String.valueOf(id) + "Not Found");
        }
    }

    @GetMapping(value = "/menus")
    private List<MenuModel> retrieveListMenu(){
        return menuRestService.retrieveListMenu();
    }
}
