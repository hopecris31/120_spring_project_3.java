package proj3;
import java.util.ArrayList;

public class main {

    private ArrayList<Card> getHandCards(int handSize, Deck deck){
        ArrayList<Card> handCards = new ArrayList<>();
        for(int i = 0; i < handSize; i++){
            Card newCard = deck.deal();
            handCards.add(newCard);
        }
        return handCards;

    }

    public static void main(String[] args) {
        final int HAND_SIZE = 5;
        int correctGuesses = 0;
        boolean game = true;

        Deck deck = new Deck();
        deck.shuffle();

        System.out.println("Enter 1 if hand 1 is better,  2 (or -1, idc im not the boss of you) if hand 2 is better, or 0 if it's a tie");

        while(game && deck.enoughInDeck(HAND_SIZE)){
            //cardList1 = PokerHand()
        }


    }

}
