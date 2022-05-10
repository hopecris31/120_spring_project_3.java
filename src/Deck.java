//package proj3; // do not erase. Gradescope expects this.

import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.ThreadLocalRandom;


public class Deck {
//ask about "field can be converted to local variable, when i declared private cards up here, moved to createDeck
    public ArrayList<Card> deck;
    public int nextToDeal;
    public final int[] RANKS = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}; // syntax for defining an array
    public final String[] SUITS = {"Spades", "Hearts", "Diamonds", "Clubs"};


    /**
     * deck constructor
     */
    public Deck(){ // a default constructor takes no parameters, correct?
        this.nextToDeal = 0; //is this in constructor
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
        return this.nextToDeal >= handSize && this.nextToDeal <= this.deck.size() - 1;
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
