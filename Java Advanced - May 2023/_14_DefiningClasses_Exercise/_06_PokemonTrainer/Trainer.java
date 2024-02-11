package _14_DefiningClasses_Exercise._06_PokemonTrainer;

import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges = 0;
    private List<Pokemon> pokemonList;

    public Trainer(String name, List<Pokemon> pokemonList) {
        this.name = name;
        this.pokemonList = pokemonList;
    }

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public void elementExecute(String element) {
        if (exist(element)) {
            numberOfBadges += 1;
        } else {
            for (int i = 0; i < pokemonList.size() ; i++) {
                pokemonList.get(i).setHealth(pokemonList.get(i).getHealth() - 10);
                if (pokemonList.get(i).getHealth() - 10 <= 0) {
                    pokemonList.remove(pokemonList.get(i));
                    i--;
                }



            }
        }

    }


    private boolean exist(String element) {
        for (Pokemon pokemon : pokemonList) {
            if (pokemon.getElement().equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        //{TrainerName} {Badges} {NumberOfPokemon}".
        return String.format("%s %d %d", this.name, this.numberOfBadges, this.pokemonList.size());
    }
}
