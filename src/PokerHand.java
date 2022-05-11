//package proj3; // do not erase. Gradescope expects this.
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class PokerHand {

    //public ArrayList<Card> handRanks;
    public ArrayList<Card> hand;
    //private ArrayList<Integer> listRanks;


    public PokerHand(ArrayList<Card> cardList) {
        this.hand = (ArrayList<Card>) cardList.clone();
    }

    public void addCard(Card card) {
        if (this.hand.size() < 5) {
            this.hand.add(card);
        }
    }

    private ArrayList<Integer> getHandRanks() {
        ArrayList<Integer> listRanks = new ArrayList<>();
        for (Card card : this.hand) {
            int rank = card.getRank();
            listRanks.add(rank);
        }
        return listRanks;
    }

    private boolean isFlush() {
        String firstSuit = this.hand.get(0).getSuit();
        for (Card card : this.hand) {
            if (firstSuit.equals(card.getSuit())) {
                return true;
            }
        }
        return false;
    }

    private boolean isPair() {
        ArrayList<Integer> handRanks = getHandRanks();
        for (int card1 = 0; card1 < handRanks.size(); card1++) {
            for (int card2 = 1; card2 < handRanks.size(); card2++) {
                if (handRanks.get(card1).equals(card2)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isTwoPair() {
        if (this.isPair()) {
            int numPairs = 0;
            ArrayList<Integer> handRanks = getHandRanks();
            for (int card1 = 0; card1 < handRanks.size(); card1++) {
                for (int card2 = 0; card2 < handRanks.size() - card1 - 1; card2++) {
                    if (handRanks.get(card1).equals(handRanks.get(card2))) {
                        numPairs += 1;
                    }
                }
            }
            return numPairs == 2;
        }
        return false;
    }

    private boolean isThreeKind(){
        ArrayList<Integer> handRanks = getHandRanks();
        handRanks.sort(Comparator.comparing(i -> Collections.frequency(handRanks, i)).reversed());
        int occurrences = Collections.frequency(handRanks, handRanks.get(0));
        return occurrences == 3;
    }

    private boolean isFourKind(){
        ArrayList<Integer> handRanks = getHandRanks();
        handRanks.sort(Comparator.comparing(i -> Collections.frequency(handRanks, i)).reversed());
        int occurrences = Collections.frequency(handRanks, handRanks.get(0));
        return occurrences == 4;
    }


}

