package proj3;

import java.util.ArrayList;

public class PokerComparisonTests {
    public static void main(String[] args) {
        Testing testSuite = new Testing();

        testCompareTo();

        testSuite.finishTests();

    }

    public static void testCompareTo() {

        Card c2 = new Card(2, "Clubs");
        Card c3 = new Card(3, "Clubs");
        Card c4 = new Card(4, "Clubs");
        Card c5 = new Card(5, "Clubs");
        Card c6 = new Card(6, "Clubs");
        Card c7 = new Card(7, "Clubs");
        Card c8 = new Card(8, "Clubs");
        Card c9 = new Card(9, "Clubs");
        Card c10 = new Card(10, "Clubs");
        Card c11 = new Card(11, "Clubs");
        Card c12 = new Card(12, "Clubs");
        Card c13 = new Card(13, "Clubs");
        Card c14 = new Card(14, "Clubs");

        Card h2 = new Card(2, "Hearts");
        Card h3 = new Card(3, "Hearts");
        Card h4 = new Card(4, "Hearts");
        Card h5 = new Card(5, "Hearts");
        Card h6 = new Card(6, "Hearts");
        Card h7 = new Card(7, "Hearts");
        Card h8 = new Card(8, "Hearts");
        Card h9 = new Card(9, "Hearts");
        Card h10 = new Card(10, "Hearts");
        Card h11 = new Card(11, "Hearts");
        Card h12 = new Card(12, "Hearts");
        Card h13 = new Card(13, "Hearts");
        Card h14 = new Card(14, "Hearts");

        Card s2 = new Card(2, "Spades");
        Card s3 = new Card(3, "Spades");
        Card s4 = new Card(4, "Spades");
        Card s5 = new Card(5, "Spades");
        Card s6 = new Card(6, "Spades");
        Card s7 = new Card(7, "Spades");
        Card s8 = new Card(8, "Spades");
        Card s9 = new Card(9, "Spades");
        Card s10 = new Card(10, "Spades");
        Card s11 = new Card(11, "Spades");
        Card s12 = new Card(12, "Spades");
        Card s13 = new Card(13, "Spades");
        Card s14 = new Card(14, "Spades");

        ArrayList<Card> cardList = new ArrayList<Card>();


        PokerHand highCard1 = new PokerHand(cardList);
        highCard1.addCard(s2);
        highCard1.addCard(s3);
        highCard1.addCard(c5);
        highCard1.addCard(h7);
        highCard1.addCard(c9);


        PokerHand pair1 = new PokerHand(cardList);
        pair1.addCard(s12);
        pair1.addCard(s4);
        pair1.addCard(c5);
        pair1.addCard(h12);
        pair1.addCard(c7);

        PokerHand pair2 = new PokerHand(cardList);
        pair2.addCard(s11);
        pair2.addCard(s5);
        pair2.addCard(c11);
        pair2.addCard(h8);
        pair2.addCard(c9);



        PokerHand twoPair1 = new PokerHand(cardList);
        twoPair1.addCard(s2);
        twoPair1.addCard(s5);
        twoPair1.addCard(c5);
        twoPair1.addCard(h7);
        twoPair1.addCard(c9);


        Testing.assertEquals("testing high card and pair", -1, highCard1.compareTo(pair1));
        Testing.assertEquals("testing pair queen and jack", 1, pair1.compareTo(pair2));

    }
}
