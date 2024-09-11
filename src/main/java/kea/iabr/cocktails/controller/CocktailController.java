package kea.iabr.cocktails.controller;

import kea.iabr.cocktails.model.Cocktail;
import kea.iabr.cocktails.repository.CocktailRepository;
import kea.iabr.cocktails.service.CocktailService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("cocktails")
public class CocktailController {
    private final CocktailService cocktailService;


    public CocktailController(CocktailService cocktailService) {
        this.cocktailService = cocktailService;
    }

    @GetMapping("")
    public String listCocktails(Model model) {
        List<Cocktail> cocktails = cocktailService.getAllCocktails();
        model.addAttribute("cocktails", cocktails);
        return "cocktail-list";
    }

    @GetMapping("/cocktail")
    public String viewCocktails(@RequestParam("name") String name, Model model){
        Cocktail cocktail = cocktailService.findCocktailByName(name);
        model.addAttribute("cocktail", cocktail);
        return "cocktail-detail";
    }


//
//
//    @GetMapping("")
//    public ResponseEntity<List<Cocktail>> getAllCocktails() {
//        List<Cocktail> cocktails = cocktailService.getAllCocktails();
//        return new ResponseEntity<>(cocktails, HttpStatus.OK);
//    }
//
//    @GetMapping("/{name}")
//    public ResponseEntity<Cocktail> getCocktail(@PathVariable String name) {
//        Cocktail cocktail = cocktailService.findCocktailByName(name);
//        return new ResponseEntity<>(cocktail, HttpStatus.OK);
//    }
//
    @GetMapping("/search")
    public String searchByIngredient(@RequestParam("ingredient") String ingredient, Model model) {
        List<Cocktail> cocktails = cocktailService.searchCocktailByIngredient(ingredient);
        model.addAttribute("cocktails", cocktails);
//        model.addAttribute("ingredient", ingredient);
        return "cocktail-list";
    }



}
