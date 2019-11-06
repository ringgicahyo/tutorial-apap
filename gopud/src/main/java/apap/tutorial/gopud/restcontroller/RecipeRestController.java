package apap.tutorial.gopud.restcontroller;

import apap.tutorial.gopud.service.RecipeRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(value = "/recipe")
public class RecipeRestController {
    @Autowired
    private RecipeRestService recipeRestService;

    @GetMapping(value = "/excludeIngredient={namaBahan}")
    private Mono<String> postStatus(@PathVariable String namaBahan) {
        return recipeRestService.postStatus(namaBahan);
    }
}
