import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class RankTest {

    Rank rank1 = new Rank(Character.valueOf('K'), 13),
            rank2 = new Rank(Character.valueOf('A'), 14),
            rank3 = new Rank(Character.valueOf('K'), 13);

    @Test
    public void isHigherThanShouldReturnTrueIfHigher() {
        assertThat(rank2.isHigherThan(rank1), is(true));
    }

    @Test
    public void isHigherThanShouldReturnFalseIfLower() {
        assertThat(rank2.isHigherThan(rank1), is(true));
    }

    @Test
    public void isLowerThanShouldReturnTrueIfLower() {
        assertThat(rank1.isLowerThan(rank2), is(true));
    }

    @Test
    public void isLowerThanShouldReturnFalseIfHigher() {
        assertThat(rank1.isLowerThan(rank2), is(true));
    }

    @Test
    public void isEqualToShouldReturnTrueIfEqual() {
        assertThat(rank1.isEqualTo(rank3), is(true));
    }

    @Test
    public void isEqualToShouldReturnFalseIfNotEqual() {
        assertThat(rank2.isEqualTo(rank1), is(false));
        assertThat(rank2.isEqualTo(rank3), is(false));
    }
}