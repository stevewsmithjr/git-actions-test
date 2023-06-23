import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
public class Player {

    public List<Card> hand, pile;
    public String name;

    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<Card>();
        this.pile = new ArrayList<Card>();
    }

    public void drawCard(Deck deck) {
        this.hand.add(deck.draw());
    }

    public Card playTopCard() {
        Card playedCard = this.hand.get(0);
        this.hand.remove(playedCard);
        return playedCard;
    }

    public void discardCard(Card discardedCard, Deck deck) {
        deck.discard(Arrays.asList(discardedCard));
        this.hand.remove(discardedCard);
        System.out.print(discardedCard.toString()); System.out.println("was removed from " + this.name + "'s hand.\n");
    }

    public void showHand() {
        System.out.println(this.name + "'s hand: ");
        for (Card card : this.hand) {
            System.out.print(card.toString() + " ");
        }
        System.out.println(System.lineSeparator());
    }

}
