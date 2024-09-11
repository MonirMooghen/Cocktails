package kea.iabr.cocktails.repository;

import kea.iabr.cocktails.model.Cocktail;
import kea.iabr.cocktails.model.Ingredient;
import org.springframework.core.io.buffer.TouchableDataBuffer;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class CocktailRepository {
    private ArrayList<Cocktail> cocktails = new ArrayList();


    public CocktailRepository(){
        populateCocktail();
    }

    public void populateCocktail(){
        Ingredient vodka = new Ingredient("vodka", false);
        Ingredient sukker = new Ingredient("sukker", false);
        Ingredient lime = new Ingredient("lime juice", false);
        Ingredient danskvand = new Ingredient("danskvand", false);
        Ingredient mynte = new Ingredient("mynte", false);
        Ingredient aperol = new Ingredient("aperol", false);
        Ingredient prosecco = new Ingredient("prosecco", false);
        Ingredient kaffelikør = new Ingredient("kaffelikør", false);
        Ingredient mælk = new Ingredient("mælk", true);
        Ingredient appelsin = new Ingredient("appelsin", false);

        cocktails.add(new Cocktail("Mojito", Arrays.asList(vodka, sukker, lime, danskvand, mynte)));
        cocktails.add(new Cocktail("Aperol Spritz", Arrays.asList(danskvand, aperol, prosecco, appelsin)));
        cocktails.add(new Cocktail("White Russian", Arrays.asList(vodka, kaffelikør, mælk)));
    }

    public ArrayList<Cocktail> getAllCocktails(){
        return cocktails;
    }

    public Cocktail findCocktailByName(String name) {
        for(Cocktail cocktail : cocktails) {
            if(cocktail.getName().equalsIgnoreCase(name)) {
                return cocktail;
            }
        } return null;
    }

    public List<Cocktail> searchCocktailByIngredient(String searchWord){
        List<Cocktail> searchList = new ArrayList<>();
        for(Cocktail cocktail : cocktails){
            for(Ingredient ingredient : cocktail.getIngredients()){
            if(ingredient.getIngredientName().equalsIgnoreCase(searchWord)){
                searchList.add(cocktail);
            }
            }
        }
        return searchList;
    }
}
