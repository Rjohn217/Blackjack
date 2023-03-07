package Main;

import Model.Deck;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n**** Welcome to the Blackjack Table! ****\n****\t  The game pays 2:1\t\t\t****\n");

        Deck playingDeck = new Deck();
        playingDeck.createFullDeck();
        playingDeck.shuffle();
        Deck playerDeck = new Deck();
        Deck dealerDeck = new Deck();
        double playerMoney = 100.00;
        Scanner scanner = new Scanner(System.in);

        while (playerMoney > 0) {
            System.out.println("You have $" + playerMoney + ", how much would you like to bet?");
            double playerBet = scanner.nextDouble();

            if(playerBet > playerMoney) {
                System.out.println("You can't bet more money than you have, you can go now.");
                break;
            }

            boolean endRound = false;

            playerDeck.drawCard(playingDeck);
            playerDeck.drawCard(playingDeck);
            dealerDeck.drawCard(playingDeck);
            dealerDeck.drawCard(playingDeck);

            while(true) {
                System.out.println("Your hand: " + playerDeck.toString());
                System.out.println("Dealer hand: " + dealerDeck.getCard(0).toString() + " and [Hidden Card]");
                System.out.println("Would you like to Hit(1) or Stand(2)");
                int response = scanner.nextInt();

                if(response == 1) {
                    playerDeck.drawCard(playingDeck);
                    System.out.println("You draw a: " + playingDeck.getCard(playerDeck.deckSize() - 1).toString() + "\n");
                    if(playerDeck.cardsValue() > 21) {
                        System.out.println("You Busted! Deck Value: " + playerDeck.cardsValue());
                        playerMoney = playerMoney - playerBet;
                        endRound = true;
                        break;
                    }
                } else if(response == 2) {
                    break;
                }
            }

            System.out.println("Dealer cards: " + dealerDeck.toString());
            if(dealerDeck.cardsValue() > playerDeck.cardsValue() && endRound) {
                System.out.println("The dealer wins, thanks for your generous donation");
                playerMoney -= playerBet;
                endRound = true;
            }

            while(dealerDeck.cardsValue() < 17 && endRound) {
                dealerDeck.drawCard(playingDeck);
                System.out.println("Dealer draws: " + dealerDeck.getCard(dealerDeck.deckSize() - 1).toString());
            }

            System.out.println("The value of the dealer's hand is: " + dealerDeck.cardsValue());

            if(dealerDeck.cardsValue() > 21 && endRound){
                System.out.println("Dealer has busted, you win this time..");
                playerMoney += (playerBet * 1.5);
                endRound = true;
            }

            if(playerDeck.cardsValue() == dealerDeck.cardsValue() && endRound){
                System.out.println("Push");
                endRound = true;
            }

            if(playerDeck.cardsValue() > dealerDeck.cardsValue() && endRound) {
                System.out.println("You win this hand, but don't push your luck.");
                playerMoney += (playerBet * 1.5);
                endRound = true;
            }
            else if(endRound){
                System.out.println("You lose the hand.");
                playerMoney -= playerBet;
                endRound = true;
            }

            playerDeck.moveAllToDeck(playingDeck);
            dealerDeck.moveAllToDeck(playingDeck);
            System.out.println("End of hand.");

        }
        System.out.println("You're out of money, thanks for your donations!");


        System.out.println(playingDeck);

    }
}