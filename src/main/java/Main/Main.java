package Main;

import Model.Deck;

public class Main {
    public static void main(String[] args) {
        System.out.println("");
        System.out.println("****Welcome to the Blackjack Table!****");

        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        playingDeck.shuffle();

        System.out.println(playingDeck);

    }
}