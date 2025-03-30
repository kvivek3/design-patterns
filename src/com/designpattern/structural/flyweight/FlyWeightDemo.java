package com.designpattern.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

interface CharacterFlyweight {
    void display(int size, String color);
}

class Character implements CharacterFlyweight {
    private final char symbol;

    Character(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void display(int size, String color) {
        System.out.println(String.format("Character: %c , size: %d, color: %s", symbol, size, color));
    }
}

class CharacterFactory {
    private final Map<java.lang.Character, CharacterFlyweight> flyweights = new HashMap<>();

    public CharacterFlyweight getCharacter(char symbol) {
        CharacterFlyweight characterFlyweight = flyweights.get(symbol);
        if(characterFlyweight == null) {
            characterFlyweight = new Character(symbol);
            flyweights.put(symbol, characterFlyweight);

        }
        return characterFlyweight;
    }

}

public class FlyWeightDemo {
    public static void main(String[] args) {

        CharacterFactory factory = new CharacterFactory();
        String document = "Hello World";
        for(char c : document.toCharArray()) {
            CharacterFlyweight characterFlyweight = factory.getCharacter(c);
            characterFlyweight.display(12,"Black");
        }
    }
}
