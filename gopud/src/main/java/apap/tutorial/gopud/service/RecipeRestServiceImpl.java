package apap.tutorial.gopud.service;

import apap.tutorial.gopud.rest.Setting;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;

@Service
@Transactional
public class RecipeRestServiceImpl implements RecipeRestService {
    private final WebClient webClient;
    private final static String apiKey = "b22dd4177d5240aeb3cdb8e11e448059";

    public RecipeRestServiceImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl(Setting.recipeUrl).build();
    }

    @Override
    public Mono<String> postStatus(String choice) {
        MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
        data.add("cuisine", "german");
        data.add("excludeIngredients", choice);
        data.add("apiKey", apiKey);
        return this.webClient.get().uri(uriBuilder -> uriBuilder
                .path("/recipes/search")
                .queryParams(data)
                .build())
                .retrieve().bodyToMono(String.class);
    }
}
