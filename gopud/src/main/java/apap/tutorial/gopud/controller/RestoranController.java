package apap.tutorial.gopud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.service.RestoranService;

@Controller
public class RestoranController {
    @Autowired
    private RestoranService restoranService;
    // URL mapping add
    @RequestMapping("/restoran/add")
    public String add(
        // Request Parameter untuk dipass
        @RequestParam(value = "idRestoran", required = true) String idRestoran,
        @RequestParam(value = "nama", required = true) String nama,
        @RequestParam(value = "alamat", required = true) String alamat,
        @RequestParam(value = "nomorTelepon", required = true) Integer nomorTelepon,
        Model model
    ) {

       // Membuat objek RestoranModel
       RestoranModel restoran = new RestoranModel(idRestoran, nama, alamat, nomorTelepon);

       // Memanggil service addRestoran
       restoranService.addRestoran(restoran);

       // Add variabel nama retoran ke "namaResto" untuk dirender
       model.addAttribute("namaResto", nama);

       // Return view template
       return "add-restoran";
    }

    // URL mapping add
    @RequestMapping("/restoran/view/id-restoran/{idRestoran}")
    public String view(
   
        // Path variable untuk dipass
        @PathVariable(value = "idRestoran") String idRestoran, Model model
    ) {
        
        // Mengambil objek RestoranModel yang dituju
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);

        // Add model restoran ke "resto" untuk dirender
        model.addAttribute("resto", restoran);

        // Return view template
        return "view-restoran";
    }
    
    // URL mapping viewAll
    @RequestMapping("/restoran/viewall")
    public String viewall(Model model) {
        // Mengambil semua objek RestoranModel yang ada
        List<RestoranModel> listRestoran = restoranService.getRestoranList();

        // Add model restoran ke "resto" untuk dirender
        model.addAttribute("restoList", listRestoran);

        // Return view template
        return "viewall-restoran";
    }

    // URL mapping update nomorTelepon
    @RequestMapping("/restoran/update/id-restoran/{idRestoran}/nomor-telepon/{nomorTelepon}")
    public String updateNomorTelepon(
        // Path Variable untuk dipass
        @PathVariable(value = "idRestoran") String idRestoran, 
        @PathVariable(value = "nomorTelepon") Integer nomorTelepon,
        Model model
    ) {
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);
        restoran.setNomorTelepon(nomorTelepon);
        model.addAttribute("namaResto", restoran.getNama());
        return "update-nomor-telepon";
    }
    
    // URL mapping delete Restoran
    @RequestMapping("/restoran/delete/id/{idRestoran}")
    public String deleteByIdRestoran(
        // Path Variable untuk dipass
        @PathVariable(value = "idRestoran") String idRestoran,
        Model model
    ) {
        RestoranModel restoran = restoranService.getRestoranByIdRestoran(idRestoran);
        if (restoran == null) {
            return "error-id-not-found";
        }
        List<RestoranModel> listRestoran = restoranService.getRestoranList();
        listRestoran.remove(restoran);
        model.addAttribute("namaResto", restoran.getNama());
        return "delete-restoran";
    }

}
