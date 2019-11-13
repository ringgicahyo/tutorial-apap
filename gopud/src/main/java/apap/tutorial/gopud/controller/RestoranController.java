package apap.tutorial.gopud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.service.MenuService;
import apap.tutorial.gopud.service.RestoranService;

@Controller
public class RestoranController {
    @Qualifier("restoranServiceImpl")
    @Autowired
    private RestoranService restoranService;

    @Autowired
    private MenuService menuService;

    // URL mapping yang digunakan untuk mengakses halaman add restoran
    @RequestMapping(value = "/restoran/add", method = RequestMethod.GET)
    public String addRestoranFormPage(Model model) {
        RestoranModel newRestoran = new RestoranModel();
        model.addAttribute("pagetitle", "Form Add Restoran");
        model.addAttribute("restoran", newRestoran);
        return "form-add-restoran";
    }

    // URL mapping yang digunakan untuk submit form yang telah anda masukkan pada halaman add restoran
    @RequestMapping(value = "/restoran/add", method = RequestMethod.POST)
    public String addRestoranSubmit(@ModelAttribute RestoranModel restoran, Model model) {
        restoranService.addRestoran(restoran);
        model.addAttribute("pagetitle", "Add Restoran");
        model.addAttribute("namaResto", restoran.getNama());
        return "add-restoran";
    }

    // URL mapping view
    @RequestMapping(path = "/restoran/view", method = RequestMethod.GET)
    public String view(
        // Request Parameter untuk dipass
        @RequestParam(value = "idRestoran") Long idRestoran, Model model
        ) {
        
        // Mengambil objek RestoranModel yang dituju
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
        
        // Add model restoran ke "resto" untuk dirender
        model.addAttribute("resto", restoran);

        List<MenuModel> menuList = menuService.getListMenuOrderByHargaAsc(restoran.getIdRestoran());
        restoran.setListMenu(menuList);
        
        model.addAttribute("menuList", menuList);
        model.addAttribute("pagetitle", "View Restoran");

        // Return view template
        return "view-restoran";
    }

    // API yang digunakan untuk menuju halaman form change restoran
    @RequestMapping(value = "restoran/change/{idRestoran}", method = RequestMethod.GET)
    public String changeRestoranFormPage(@PathVariable Long idRestoran, Model model) {
        // Mengambil existing data restoran
        RestoranModel existingRestoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
        model.addAttribute("restoran", existingRestoran);
        model.addAttribute("pagetitle", "Form Change Restoran");
        return "form-change-restoran";
    }

    // API yang digunakan untuk submit form change restoran
    @RequestMapping(value = "restoran/change/{idRestoran}", method = RequestMethod.POST)
    public String changeRestoranFormSubmit(@PathVariable Long idRestoran, @ModelAttribute RestoranModel restoran, Model model) {
        RestoranModel newRestoranData = restoranService.changeRestoran(restoran);
        model.addAttribute("restoran", newRestoranData);
        model.addAttribute("pagetitle", "Change Restoran");
        return "change-restoran";
    }

    // URL mapping viewAll
    @RequestMapping("/restoran/view-all")
    public String viewall(Model model) {
        // Mengambil semua objek RestoranModel yang ada
        List<RestoranModel> listRestoran = restoranService.getRestoranList();

        // Add model restoran ke "resto" untuk dirender
        model.addAttribute("restoList", listRestoran);
        model.addAttribute("pagetitle", "View All");

        // Return view template
        return "viewall-restoran";
    }

    // URL mapping delete Restoran
    @RequestMapping("/restoran/delete/{idRestoran}")
    public String deleteRestoran(
        // Path Variable untuk dipass
        @PathVariable(value = "idRestoran") Long idRestoran,
        Model model
    ) {
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran).get();
        if (restoran == null) {
            return "error-id-not-found";
        }
        if (menuService.listMenu(idRestoran).size() == 0) {
            restoranService.deleteRestoran(restoran);
        }
        model.addAttribute("namaResto", restoran.getNama());
        model.addAttribute("pagetitle", "Delete Restoran");
        return "delete-restoran";
    }
}
