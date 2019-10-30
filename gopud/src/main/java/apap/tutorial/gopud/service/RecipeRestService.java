package apap.tutorial.gopud.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public interface RecipeRestService {
    Mono<String> postStatus(String choice);
}
