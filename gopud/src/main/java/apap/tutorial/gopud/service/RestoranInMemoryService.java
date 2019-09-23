package apap.tutorial.gopud.service;

import org.springframework.stereotype.Service;
import apap.tutorial.gopud.model.RestoranModel;
import java.util.ArrayList;
import java.util.List;

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
	public RestoranModel getRestoranByIdRestoran(String idRestoran) {
        RestoranModel tempRestaurant = null;
        for (RestoranModel restaurant: listRestoran){
            if (idRestoran.equals(restaurant.getIdRestoran())){
                tempRestaurant = restaurant;
            }
        }
        return tempRestaurant;
	}
}