package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {

    private ArrayList<Card> cards;

    public Deck() {
        this.cards = new ArrayList<Card>();
    }

    public void createFullDeck() {
        for(Suit cardSuit: Suit.values()) {
            for(Value cardValue: Value.values()) {
                this.cards.add(new Card(cardValue, cardSuit));
            }
        }
    }

    public void shuffle()  {
        ArrayList<Card> tempDeck = new ArrayList<Card>();
        Random random = new Random();
        int randomCardIndex = 0;
        int originalSize = this.cards.size();
        for(int i = 0; i < originalSize; i++) {
            randomCardIndex = random.nextInt((this.cards.size() - 1 - 0) + 1) + 0;
            tempDeck.add(this.cards.get(randomCardIndex));
            this.cards.remove(randomCardIndex);
        }
        this.cards = tempDeck;
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
        String cardListOutput = "";
        int i = 0;
        for(Card card: this.cards) {
            cardListOutput += "\n" + i + " " + card.toString();
            i++;
        }
        return cardListOutput;
    }

}
