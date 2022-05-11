package proj3; // do not erase. Gradescope expects this.
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;


public class PokerHand {

    public final int HAND_SIZE = 5;
    public ArrayList<Card> hand;

    public PokerHand(ArrayList<Card> cardList) {
        this.hand = (ArrayList<Card>) cardList.clone();
    }

    public void addCard(Card card) {
        if (this.hand.size() < 5) {
            this.hand.add(card);
        }
    }

    public Card getCard(int index){
        if(index > HAND_SIZE-1 || index < 0){
            return null;
        }
        return this.hand.get(index);
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
                if (handRanks.get(card1).equals(handRanks.get(card2))) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isTwoPair() { //check
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

    private String getHandType(){
        if(this.isFlush()){
            return "Flush";}
        if(this.isTwoPair()){
            return "Two Pair";}
        if(this.isFourKind()){
            return "Two Pair";}
        if(this.isThreeKind()){
            return "Pair";}
        if(this.isPair()){
            return "Pair";}
        else{
            return "High Card";}
    }

    private ArrayList<Integer> getPairs(){
        ArrayList<Integer> listPairs = new ArrayList<>();
        if(this.isPair()){
            for (int card1 = 0; card1 < this.hand.size(); card1++) {
                for (int card2 = 1; card2 < this.hand.size(); card2++) {
                    if(this.hand.get(card1).getRank() == this.hand.get(card2).getRank() && !listPairs.contains(this.hand.get(card1).getRank())){
                            listPairs.add(this.hand.get(card1).getRank());
                    }
                }
            }
        }
        return listPairs;
    }

    private int compareHighCard(PokerHand other){
        ArrayList<Integer> selfRanks = this.getHandRanks();
        ArrayList<Integer> otherRanks = other.getHandRanks();
        selfRanks.sort(Collections.reverseOrder());
        otherRanks.sort(Collections.reverseOrder());

        for(int card = 0; card < selfRanks.size(); card++){
            if(selfRanks.get(card) > otherRanks.get(card)){
                return 1;
            }
            else if(selfRanks.get(card) < otherRanks.get(card)){
                return -1;
            }
        }
        return 0;
    }

    private int compareHandSameType(PokerHand other){
        ArrayList<Integer> selfPair = this.getPairs();
        ArrayList<Integer> otherPair = other.getPairs();
        selfPair.sort(Collections.reverseOrder());
        otherPair.sort(Collections.reverseOrder());

        if (this.isPair() && other.isPair()){
            for(int pair = 0; pair < selfPair.size(); pair++){
                if(selfPair.get(pair) > otherPair.get(pair)){
                    return 1;
                }
                else if(selfPair.get(pair) < otherPair.get(pair)){
                    return -1;
                }
            }
        }
        return this.compareHighCard(other);
    }

    private int handTypeWorth(){
        if(this.isFlush()){
            return 4;
        }
        if(this.isFourKind()){
            return 3;
        }
        else if(this.isTwoPair()){
            return 3;
        }
        else if(this.isThreeKind()){
            return 2;
        }
        else if(this.isPair()){
            return 2;
        }
        else{
            return 1;
        }
    }

    public int compareTo(PokerHand other){
        if(this.handTypeWorth() > other.handTypeWorth()){
            return 1;
        }
        else if(this.handTypeWorth() < other.handTypeWorth()){
            return -1;
        }
        if(this.getHandType().equals(other.getHandType())){
            return this.compareHandSameType(other);
        }
        return this.compareHighCard(other);
    }

    public String toString(){
        return String.valueOf(this.hand);
    }

}

