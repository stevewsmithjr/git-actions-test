import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {

    public List<Card> cards, discardPile;

    public Deck(List<Card> cards) {
        this.cards = cards;
        this.discardPile = new ArrayList<Card>();

    }

    public Card draw() {
        if(!cards.isEmpty()) {
            Card topCard = cards.get(0);
            cards.remove(0);
            return topCard;
        } else
            return null;
    }

    public List<Card> draw(Integer count) {
        List<Card> topCards = new ArrayList<>();
        Card topCard = null;
        while(count.intValue() > 0) {
            count = Integer.valueOf(count.intValue()-1);
            if(null != (topCard = draw()))
                topCards.add(topCard);
            else
                break;
        }
        return topCards;
    }


    // player provides a list of cards to discard, top card of discard pile is last discarded card
    public void discard(List<Card> discards) {
        List<Card> discardList = new ArrayList<>(discards); // avoid changing parameter data
        Collections.reverse(discardList);
        discardPile.addAll(discardList);
    }


    // a player provides a list of cards from their hand they want to discard to exchange (games like poker)
    public List<Card> exchangeCards(List<Card> discards) {
        discard(discards);
        ArrayList<Card> newCards = new ArrayList<>();
        discards.forEach( card -> {
            newCards.add(this.draw());
        });
        return newCards;
    }

    public int cardCount() {
        return this.cards.size();
    }

    public int discardedCount() {
        return this.discardPile.size();
    }

    public void printDeck() {
        int i = 0;
        System.out.println("Cards left in the deck: ");
        for (Card card : this.cards) {
            System.out.print(card.toString() + " ");
            i++;
            if (i%7 == 0){
                System.out.println();
                i = 0;
            }
        }
        System.out.println(System.lineSeparator());
    }

    public void printDiscardPile() {
        int i = 0;
        System.out.println("Cards in the discard pile: ");
        for (Card card : this.discardPile) {
            System.out.print(card.toString() + " ");
            i++;
            if(i%7 ==0){
                System.out.println();
                i = 0;
            }
        }
        System.out.println(System.lineSeparator());
    }

    public List<Card> shuffle() {
        List<Card> shuffledCards = new ArrayList<>();
        List<Integer> order = new ArrayList<>();
        cards.forEach( card -> {
            int temp;
            do {
                temp = Math.abs(ThreadLocalRandom.current().nextInt() % this.cardCount());
            } while(order.contains(temp));
            order.add(temp);
        });

        order.forEach( index -> {
            shuffledCards.add(cards.get(index));
        });
        this.cards = shuffledCards;
        return this.cards;
    }

    public List<Card> getCards() { return this.cards; }

    public List<Card> getDiscardPile() { return this.discardPile; }
}
