import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class DeckTest {

    List<Card> cards;
    Deck deck;

    @Before
    public void initializeCardCount() {
        cards = new ArrayList<Card>(
                Arrays.asList(
                        new Card(new Rank(Character.valueOf('2'), 2),Character.valueOf('S')),
                        new Card(new Rank(Character.valueOf('5'), 5), Character.valueOf('H')),
                        new Card(new Rank(Character.valueOf('9'), 9), Character.valueOf('C')),
                        new Card(new Rank(Character.valueOf('3'), 3), Character.valueOf('D')),
                        new Card(new Rank(Character.valueOf('A'), 14), Character.valueOf('C')),
                        new Card(new Rank(Character.valueOf('K'), 13), Character.valueOf('H')),
                        new Card(new Rank(Character.valueOf('Q'), 12), Character.valueOf('S'))
                ));
        deck = new Deck(cards);
    }

    @Test
    public void drawShouldReturnFirstCard() {
        assertThat(cards.get(0), is(equalTo(deck.draw())));
    }

    @Test
    public void drawMultipleShouldReturnCorrectCount() {
        List<Card> topCards = deck.draw(5);
        assertThat(topCards.size(), is(equalTo(5)));
        deck.cards.addAll(topCards);
    }

    @Test
    public void drawMultipleShouldBeLimitedToCardsLeft() {
        int size = deck.getCards().size();
        List<Card> topCards = deck.draw(deck.getCards().size() + 1);
        assertThat(topCards.size(), is(equalTo(size)));
        deck.cards.addAll(topCards);
    }

    @Test
    public void shuffleShouldReturnNewlyOrderedList() {
        List<Card> beforeShuffle = deck.getCards();
        List<Card> afterShuffle = deck.shuffle();
        assertThat(beforeShuffle, is(not(equalTo(afterShuffle))));
        assertThat(beforeShuffle, not(containsInRelativeOrder(afterShuffle)));
        System.out.println("Before:");
        beforeShuffle.forEach(card -> System.out.print(String.format("| %s |", card.toString())));
        System.out.println("\nAfter:");
        deck.getCards().forEach(card -> System.out.print(String.format("| %s |", card.toString())));
    }

    @Test
    public void discardShouldAddToDiscardPileInReverseOrder() {
        List<Card> discards = deck.draw(5);
        deck.discard(discards);
        assertThat(deck.getDiscardPile(), is(not(equalTo(discards))));
        assertThat(deck.getDiscardPile(), not(containsInRelativeOrder(discards)));
        System.out.println("Before:");
        discards.forEach(card -> System.out.print(String.format("| %s |", card.toString())));
        System.out.println("\nAfter:");
        deck.getDiscardPile().forEach(card -> System.out.print(String.format("| %s |", card.toString())));
    }

    @Test
    public void exchangeCardsShouldReturnNewCards() {
        List<Card> discards = Arrays.asList(
                new Card(new Rank(Character.valueOf('K'), 13), Character.valueOf('S')),
                new Card(new Rank(Character.valueOf('7'), 7), Character.valueOf('H'))
        );
        List<Card> newCards = deck.exchangeCards(discards);

        assertThat(newCards.size(), is(equalTo(discards.size())));
        assertThat(newCards, not(contains(discards.toArray())));
    }

}