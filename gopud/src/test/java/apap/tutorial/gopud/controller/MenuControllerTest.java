package apap.tutorial.gopud.controller;

import apap.tutorial.gopud.model.MenuModel;
import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.service.MenuService;
import apap.tutorial.gopud.service.RestoranService;

import org.apache.xerces.impl.xpath.regex.Match;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(MenuController.class)
public class MenuControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    @Qualifier("restoranServiceImpl")
    private RestoranService restoranService;

    @MockBean
    @Qualifier("menuServiceImpl")
    private MenuService menuService;

    @Test
    public void whenAddMenuRouteAccessItShouldReturnStatusCode200() throws Exception {
        mockMvc.perform(get("/menu/add/1/")).andExpect(MockMvcResultMatchers.status().isOk());
    }

    private MenuModel generateDummyMenuModel(int count) {
        MenuModel dummyMenuModel = new MenuModel();
        dummyMenuModel.setNama("dummy " + count);
        dummyMenuModel.setDeskripsi("deskripsi " + count);
        dummyMenuModel.setHarga(BigInteger.ONE);
        dummyMenuModel.setDurasiMasak(14000);
        return dummyMenuModel;
    }

    @Test
    public void whenMenuAddPostFormItShouldSuccessfullyReturnToRightView() throws Exception {
        String nama = "Dummy Menu";
        String deskripsi = "Dummy Deskripsi";
        mockMvc.perform(post("/menu/add/1")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("nama", nama)
                .param("deskripsi", deskripsi)
        )
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("add-menu"))
                .andExpect(model().attribute("nama", is(nama)));
    }

}