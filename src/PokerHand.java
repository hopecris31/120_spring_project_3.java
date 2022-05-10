//package proj3; // do not erase. Gradescope expects this.
import java.util.ArrayList;


public class PokerHand {

    public ArrayList<Card> cardList;
    public ArrayList<Card> hand;


    public PokerHand(ArrayList<Card> cardList){
        this.hand = (ArrayList<Card>) cardList.clone();
    }

}