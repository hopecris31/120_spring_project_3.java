package proj3; // do not erase. Gradescope expects this.

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;


public class Deck {
//ask about "field can be converted to local variable, when i declared private cards up here, moved to createDeck
    private ArrayList<Card> deck;
    private int nextToDeal;


    /**
     * deck constructor
     */
    public Deck(){ // a default constructor takes no parameters, correct?
        this.nextToDeal = 0; //is this in constructor
        String[] SUITS = {"Spades", "Hearts", "Diamonds", "Clubs"};
        // syntax for defining an array
        int[] RANKS = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};
        this.deck = createDeck(RANKS, SUITS);
    }

    private ArrayList<Card> createDeck(int[] ranks, String[] suits){
        ArrayList<Card> cards = new ArrayList<>();
        for (int rank : ranks) {
            for (String suit : suits) {
                Card card = new Card(rank, suit);
                cards.add(card);}
        }
        return cards;
    }

    public void shuffle(){
        int deckSize = this.deck.size();
        for (int i = 0; i < deckSize ; i++){
            int swapIndex = ThreadLocalRandom.current().nextInt(0, deckSize);
            Collections.swap(this.deck, i, swapIndex);
        }
    }

    public boolean enoughInDeck(int handSize) { //if nextToDeal is at end, return false
        if(this.size() >= handSize){
            return true;
        }
        else{
            return false;
        }
    }

    public Card deal() {
        if (this.nextToDeal == this.deck.size()){ //😍😍😍
            return null;}
        else{
            Card dealtCard = deck.get(nextToDeal);
            this.nextToDeal++;
            return dealtCard;
        }
    }

    public int size(){
        return this.deck.size() - this.nextToDeal;
    }

    public void gather(){
        this.nextToDeal = 0;
    }

    public String toString(){
        return String.valueOf(this.deck);
    }
}
