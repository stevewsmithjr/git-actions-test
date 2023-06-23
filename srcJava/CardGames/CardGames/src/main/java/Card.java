import java.util.List;

public class Card {
    private final Character suit;
    private final Rank rank;

    public Card(Rank rank, Character suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Character getSuit() { return this.suit; }

    public Rank getRank() { return this.rank; }

    public int getValue() { return this.rank.getValue(); }

    public boolean suitMatches(Card card) { return this.suit.compareTo(card.getSuit()) == 0; }
    public boolean suitMatches(List<Card> cards) { return cards.parallelStream().anyMatch(card -> !card.suitMatches(this)); }

    public boolean rankMatches(Card card) { return this.rank.isEqualTo(card.getRank()); }
    public boolean rankMatches(List<Card> cards) { return cards.parallelStream().allMatch(card -> card.rankMatches(this)); }

    public boolean isHigherThan(Card card) { return this.rank.isHigherThan(card.getRank()); }
    public boolean isHigherThan(List<Card> cards) { return cards.parallelStream().allMatch(card -> this.isHigherThan(card)); }

    public boolean isLowerThan(Card card) { return this.rank.isLowerThan(card.getRank()); }
    public boolean isLowerThan(List<Card> cards) { return cards.parallelStream().allMatch(card -> this.isLowerThan(card)); }

    public boolean isOneRankHigherThan(Card card) { return this.rank.getValue() == card.getRank().getValue() + 1; }

    @Override
    public String toString() {
        return String.format("%s%s", this.getRank(), this.getSuit());
    }
}
