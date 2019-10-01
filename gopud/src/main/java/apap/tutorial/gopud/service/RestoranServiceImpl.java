package apap.tutorial.gopud.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.repository.RestoranDB;   

@Service
@Transactional
public class RestoranServiceImpl implements RestoranService {
    @Autowired
    private RestoranDB restoranDB;

    @Override
    public void addRestoran(RestoranModel restoran) {
        restoranDB.save(restoran);
    }

    @Override
    public List<RestoranModel> getRestoranList() {
        return restoranDB.findAllByOrderByNamaAsc();
    }

    @Override
    public Optional<RestoranModel> getRestoranByIdRestoran(Long idRestoran) {
        return restoranDB.findByIdRestoran(idRestoran);
    }

    @Override
    public RestoranModel changeRestoran(RestoranModel restoranModel) {
        // mengambil object restoran yang ingin diubah
        RestoranModel targetRestoran = restoranDB.findById(restoranModel.getIdRestoran()).get();
        
        try{
            targetRestoran.setNama(restoranModel.getNama());
            targetRestoran.setAlamat(restoranModel.getAlamat());
            targetRestoran.setNomorTelepon(restoranModel.getNomorTelepon());
            restoranDB.save(targetRestoran);
            return targetRestoran;
        } catch (NullPointerException nullException) {
            return null;
        }
    }
    

}