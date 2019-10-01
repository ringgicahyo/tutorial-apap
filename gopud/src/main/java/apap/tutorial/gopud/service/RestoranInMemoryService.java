package apap.tutorial.gopud.service;

import org.springframework.stereotype.Service;
import apap.tutorial.gopud.model.RestoranModel;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestoranInMemoryService implements RestoranService {
    private List<RestoranModel> listRestoran;

    // Constructor
    public RestoranInMemoryService() {
        listRestoran = new ArrayList<>();
    }

	@Override
	public void addRestoran(RestoranModel restoran) {
		listRestoran.add(restoran);
	}

	@Override
	public List<RestoranModel> getRestoranList() {
		return listRestoran;
	}

	@Override
	public Optional<RestoranModel> getRestoranByIdRestoran(Long idRestoran) {
        return null;
    }
    
    @Override
    public RestoranModel changeRestoran(RestoranModel restoranModel){
        return null;
    }
}