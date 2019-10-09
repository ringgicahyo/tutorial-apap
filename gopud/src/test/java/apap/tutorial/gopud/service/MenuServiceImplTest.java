package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.repository.MenuDB;
import apap.tutorial.gopud.model.MenuModel;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
import java.util.ArrayList;
import java.math.BigInteger;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class MenuServiceImplTest {
    @InjectMocks
    MenuService menuService = new MenuServiceImpl();

    @Mock
    MenuDB menuDB;

    @Test
    public void whenAddValidMenuItShouldCallMenuRepositorySave() {
        MenuModel newMenu = new MenuModel();
        newMenu.setNama("Ayam Sambal Rempah");
        newMenu.setDeskripsi("Dengan rempah Aceh yang mantap");
        newMenu.setHarga(BigInteger.ONE);
        newMenu.setDurasiMasak(1);
        menuService.addMenu(newMenu);
        verify(menuDB, times(1)).save(newMenu);
    }

    @Test
    public void whenFindAllMenuByIdRestoranCalledItShouldReturnMenuList() {
        RestoranModel restoran = new RestoranModel();
        restoran.setIdRestoran((long) 1);

        List<MenuModel> allMenuInRestoran = new ArrayList<>();
        for (int loopTimes = 3; loopTimes > 0; loopTimes--) {
            MenuModel menuModel = new MenuModel();
            menuModel.setRestoran(restoran);
            allMenuInRestoran.add(menuModel);
        }
        when (menuService.findAllMenuByIdRestoran(1L)).thenReturn(allMenuInRestoran);

        List<MenuModel> dataFromServiceCall = menuService.findAllMenuByIdRestoran(1L);
        assertEquals(3, dataFromServiceCall.size());

        verify(menuDB, times(1)).findByRestoranIdRestoran(1L);
    }
    @Test
    public void whenListMenuCalledItShouldReturnMenuList() {
        RestoranModel restoran = new RestoranModel();
        restoran.setIdRestoran((long) 1);

        List<MenuModel> allMenuInRestoran = new ArrayList<>();
        for (int loopTimes = 3; loopTimes > 0; loopTimes--) {
            MenuModel menuModel = new MenuModel();
            menuModel.setRestoran(restoran);
            allMenuInRestoran.add(menuModel);
        }
        when (menuService.listMenu(1L)).thenReturn(allMenuInRestoran);

        List<MenuModel> dataFromServiceCall = menuService.listMenu(1L);
        assertEquals(3, dataFromServiceCall.size());

        verify(menuDB, times(1)).findByRestoranIdRestoran(1L);
    }

    @Test(expected=NullPointerException.class)
    public void whenChangeMenuCalledItShouldChangeMenuData() {
        MenuModel updatedData = new MenuModel();
        updatedData.setNama("ayam mantap");
        updatedData.setDeskripsi("dummy");
        updatedData.setHarga(BigInteger.ONE);
        updatedData.setDurasiMasak(5);
        updatedData.setId(1L);

        when(menuDB.findById(1L)).thenReturn(Optional.of(updatedData));

        when(menuService.changeMenu(updatedData)).thenReturn(updatedData);

        when(menuService.changeMenu(updatedData)).thenThrow(new NullPointerException());

        MenuModel dataFromServiceCall = menuService.changeMenu(updatedData);

        assertEquals("ayam mantap", dataFromServiceCall.getNama());
        assertEquals("dummy", dataFromServiceCall.getDeskripsi());
        assertEquals(BigInteger.ONE, dataFromServiceCall.getHarga());
        assertEquals(Integer.valueOf(5), dataFromServiceCall.getDurasiMasak());
    }

    @Test
    public void whenGetMenuByIdMenuCalledItShouldReturnMenu() {
        MenuModel returnedData = new MenuModel();
        returnedData.setId((long)1);
        returnedData.setNama("ayam");
        returnedData.setDeskripsi("kecap");
        returnedData.setHarga(BigInteger.valueOf(5000));
        returnedData.setDurasiMasak(10);
        returnedData.setId((long)1);

        when(menuService.getMenuById(1L)).thenReturn(Optional.of(returnedData));

        Optional<MenuModel> dataFromServiceCall = menuService.getMenuById(1L);

        verify(menuDB, times(1)).findById(1L);
        assertTrue(dataFromServiceCall.isPresent());

        MenuModel dataFromOptional = dataFromServiceCall.get();

        assertEquals("ayam", dataFromOptional.getNama());
        assertEquals("kecap", dataFromOptional.getDeskripsi());
        assertEquals(BigInteger.valueOf(5000), dataFromOptional.getHarga());
        assertEquals(Integer.valueOf(10), dataFromOptional.getDurasiMasak());
    }

    @Test
    public void whenDeleteMenuCalledItShouldDeleteMenuData(){
        MenuModel menuModel = new MenuModel();
        menuModel.setNama("ayam");
        menuModel.setDeskripsi("rica-rica");
        menuModel.setId(1L);
        menuModel.setDurasiMasak(2);

        when(menuDB.findById(1L)).thenReturn(Optional.of(menuModel));
        menuService.addMenu(menuModel);
        menuService.deleteMenu(menuModel);
        verify(menuDB, times(1)).delete(menuModel);
    }

    @Test
    public void whenGetListMenuOrderByHargaAscCalledItShouldReturnMenuList() {
        RestoranModel restoran = new RestoranModel();
        restoran.setIdRestoran((long)1);

        List<MenuModel> allMenuInRestoran = new ArrayList<>();

        MenuModel menuModel1 = new MenuModel();
        menuModel1.setRestoran(restoran);
        menuModel1.setHarga(BigInteger.valueOf(2000));
        MenuModel menuModel2 = new MenuModel();
        menuModel2.setRestoran(restoran);
        menuModel2.setHarga(BigInteger.valueOf(1000));
        allMenuInRestoran.add(menuModel1);
        allMenuInRestoran.add(menuModel2);

        when (menuService.getListMenuOrderByHargaAsc(1L)).thenReturn(allMenuInRestoran);

        List<MenuModel> dataFromServiceCall = menuService.getListMenuOrderByHargaAsc(1L);
        assertEquals(2, dataFromServiceCall.size());

        verify(menuDB, times(1)).findByRestoranIdRestoranOrderByHargaAsc(1L);
    }

}
