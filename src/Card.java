//package proj3; // do not erase. Gradescope expects this.
/**
 * represents a single card
 */

public class Card {

    int rank;
    String suit;


    /**
     * constructor, initializes the card
     */
    public Card(int rank, String suit){
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * returns the rank of the card
     */
    public int getRank(){
        return this.rank;
    }

    /**
     * returns the suit of the card
     */
    public String getSuit(){
        return this.suit;
    }

    /**
     * take numeric rank and turn it into
     * a printable string where 11-14 are
     * turned into Face card values
     */
    public String toString(){
        if (this.rank == 11){
            return "Jack";
        }
        else if (this.rank == 12) {
            return "Queen";
        }
        else if (this.rank == 13) {
            return "King";
        }
        else if (this.rank == 14) {
            return "Ace";
        }
        else {  //whole card -- just change type
            return "" + this.rank; //make int a string
        }
    }
}