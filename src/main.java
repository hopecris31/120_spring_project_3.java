public class main {

    public static void main(String[] args) {
      Deck newDeck = new Deck();

      newDeck.shuffle();
      System.out.println(newDeck);
      newDeck.deal();
      System.out.println(newDeck.deal());

    }

}
