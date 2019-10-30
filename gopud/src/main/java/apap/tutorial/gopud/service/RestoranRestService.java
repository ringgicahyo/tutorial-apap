package apap.tutorial.gopud.service;

import apap.tutorial.gopud.model.RestoranModel;
import apap.tutorial.gopud.rest.RestoranDetail;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public interface RestoranRestService {
    RestoranModel createRestoran(RestoranModel restoran);
    List<RestoranModel> retrieveListRestoran();
    RestoranModel getRestoranByIdRestoran(Long idRestoran);
    RestoranModel changeRestoran(Long idRestoran, RestoranModel restoranUpdate);
    void deleteRestoran(Long idRestoran);
    Mono<String> getStatus(Long idRestoran);
    Mono<RestoranDetail> postStatus();
}
