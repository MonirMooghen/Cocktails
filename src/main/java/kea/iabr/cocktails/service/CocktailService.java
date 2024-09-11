package kea.iabr.cocktails.service;

import kea.iabr.cocktails.model.Cocktail;
import kea.iabr.cocktails.repository.CocktailRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CocktailService {
    private final CocktailRepository cocktailRepository;

    public CocktailService(CocktailRepository cocktailRepository) {
        this.cocktailRepository = cocktailRepository;
    }

    public ArrayList<Cocktail> getAllCocktails() {
        return cocktailRepository.getAllCocktails();
    }

    public Cocktail findCocktailByName(String name){
        return cocktailRepository.findCocktailByName(name);
    }

    public List<Cocktail> searchCocktailByIngredient(String searchWord){
        return cocktailRepository.searchCocktailByIngredient(searchWord);
    }


}
