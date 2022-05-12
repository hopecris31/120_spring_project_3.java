package proj3;
import java.util.ArrayList;
import java.util.Scanner;

public class main {

    private static ArrayList<Card> getHandCards(int handSize, Deck deck){
        ArrayList<Card> handCards = new ArrayList<>();
        for(int i = 0; i < handSize; i++){
            Card newCard = deck.deal();
            handCards.add(newCard);
        }
        return handCards;
    }

    public static void playGame() {
        final int HAND_SIZE = 5;
        int correctGuesses = 0;
        boolean game = true;

        Deck deck = new Deck();
        deck.shuffle();

        System.out.println("Enter 1 if hand 1 is better,  2 (or -1, idc im not the boss of you) if hand 2 is better, or 0 if it's a tie");

        while(game && deck.enoughInDeck(HAND_SIZE)){
            ArrayList<Card> cardList1 = getHandCards(HAND_SIZE, deck);
            ArrayList<Card> cardList2 = getHandCards(HAND_SIZE, deck);

            PokerHand hand1 = new PokerHand(cardList1);
            PokerHand hand2 = new PokerHand(cardList2);

            System.out.println(" ");
            System.out.println("HAND 1: "+ hand1);
            System.out.println("HAND 2: "+ hand2);
            System.out.println(" ");

            int correctAnswer = hand1.compareTo(hand2);
            //System.out.println(correctAnswer);
            Scanner userAnswer = new Scanner(System.in);
            int userAnswerInt =  userAnswer.nextInt(); // converts user answer from scanner to int, use this in compare

            userAnswer.nextLine();

            if(correctAnswer == -1){
                correctAnswer = 2;
            }
            if(userAnswerInt == -1){
                userAnswerInt = 2;
            }
            if(correctAnswer == userAnswerInt){
                correctGuesses += 1;
            }
            else{
                game = false;
            }

            System.out.println("correct answer: " + "HAND" + correctAnswer + " | your answer: " + "HAND" + userAnswerInt);
            System.out.println("correct guesses: " + correctGuesses);

            if(!game){
                System.out.println("GAME OVER");
            }
            if(!deck.enoughInDeck(HAND_SIZE)){
                System.out.println("All hands have been dealt!");
            }
        }
    }
    public static void main(String[] args) {
        playGame();
    }
}
