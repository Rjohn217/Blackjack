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

    public void removeCard(int i) {
        this.cards.remove(i);
    }

    public Card getCard(int i) {
        return this.cards.get(i);
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public void drawCard(Deck deckFrom) {
        this.cards.add(deckFrom.getCard(0));
        deckFrom.removeCard(0);
    }

    public int cardsValue(){
        int aces = 0;
        int totalValue = 0;

        for(Card card: this.cards) {
            switch (card.getValue()){
                case TWO: totalValue += 2; break;
                case THREE: totalValue += 3; break;
                case FOUR: totalValue += 4; break;
                case FIVE: totalValue += 5; break;
                case SIX: totalValue += 6; break;
                case SEVEN: totalValue += 7; break;
                case EIGHT: totalValue += 8; break;
                case NINE: totalValue += 9; break;
                case TEN:
                case JACK:
                case QUEEN:
                case KING:
                    totalValue += 10; break;
                case ACE: totalValue += 1; break;
            }
        } for(int i = 0; i < aces; i++) {
            if(totalValue > 10) {
                totalValue += 1;
            } else{
                totalValue += 11;
            }
        } return totalValue;
    }

    public void moveAllToDeck(Deck moveTo) {
        int thisDeckSize = this.cards.size();
        for(int i = 0; i < thisDeckSize; i++) {
            moveTo.addCard(this.getCard(i));
        }
        for(int i = 0; i < thisDeckSize; i++){
            this.removeCard(0);
        }
    }

    public int deckSize() {
        return this.cards.size();
    }


    public String toString() {
        String cardListOutput = "";
        for(Card card: this.cards) {
            cardListOutput += "\n" + card.toString();
        }
        return cardListOutput;
    }

}
