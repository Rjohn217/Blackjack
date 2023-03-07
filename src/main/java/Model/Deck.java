package Model;

import java.util.ArrayList;
import java.util.List;

public class Deck {

    List<Card> cards = new ArrayList<>();

    public Deck(List<Card> cards) {
        this.cards = cards;
    }

    public void createFullDeck() {
        for(Suit cardSuit: Suit.values()) {
            for(Value cardValue: Value.values()) {
                this.cards.add(new Card(cardValue, cardSuit));
            }
        }
    }

    public void shuffle()  {

    }

    public void removeCard() {

    }

    public void getCard() {

    }

    public void drawCard() {

    }

    public void moveAllToDeck() {

    }

    public int deckSize() {
        return 52;
    }

    public int cardsValue() {
        return 0;
    }

    public String toString() {
        return null;
    }

}
