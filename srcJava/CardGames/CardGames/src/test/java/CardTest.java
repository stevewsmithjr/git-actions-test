import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class CardTest {

    Card card1 = new Card(new Rank('K', 13), 'H'),
            card2 = new Card(new Rank('A', 14), 'S'),
            card3 = new Card(new Rank('Q', 12), 'H'),
            card4 = new Card(new Rank('J', 11), 'H'),
            card5 = new Card(new Rank('Q', 12), 'S'),
            card6 = new Card(new Rank('Q', 12), 'S');

    @Test
    public void suitMatchesShouldReturnTrueIfMatches() {
        assertThat(card1.suitMatches(card3), is(true));
    }

    @Test
    public void suitMatchesMultipleShouldReturnTrueIfMatchesAll() {
        assertThat(card1.suitMatches(Arrays.asList(card3, card4)), is(true));
    }

    @Test
    public void rankMatchesShouldReturnTrueIfMatches() {
        assertThat(card3.rankMatches(card5), is(true));
        assertThat(card3.rankMatches(card6), is(true));
    }

    @Test
    public void rankMatchesMultipleShouldReturnTrueIfMatchesAll() {
        assertThat(card3.rankMatches(Arrays.asList(card5, card6)), is(true));
    }

    @Test
    public void isHigherThanShouldReturnTrueIfHigher() {
        assertThat(card1.isHigherThan(card4), is(true));
    }

    @Test
    public void isHigherThanMultipleShouldReturnTrueIfHigherThanAll() {
        assertThat(card1.isHigherThan(Arrays.asList(card3, card4, card5, card6)), is(true));
    }

    @Test
    public void isLowerThanShouldReturnTrueIfLower() {
        assertThat(card3.isLowerThan(card2), is(true));
    }

    @Test
    public void isLowerThanMultipleShouldReturnTrueIfLowerThanALl() {
        assertThat(card4.isLowerThan(Arrays.asList(card1, card2, card3, card5, card6)), is(true));
    }

    @Test
    public void isOneRankHigherThanShouldReturnTrueIfOneHigher() {
        assertThat(card1.isOneRankHigherThan(card3), is(true));
        assertThat(card1.isOneRankHigherThan(card5), is(true));
        assertThat(card1.isOneRankHigherThan(card6), is(true));
    }
}