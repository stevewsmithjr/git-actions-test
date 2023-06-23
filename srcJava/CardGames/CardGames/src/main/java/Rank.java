public class Rank {
    public Character rank;
    public Integer value;

    public Rank(Character rank, Integer value) {
        this.rank = rank;
        this.value = value;
    }

    public Character getRank() { return this.rank; }

    public Integer getValue() { return value; }

    public boolean isHigherThan(Rank rank) { return this.value > rank.getValue(); }

    public boolean isLowerThan(Rank rank) { return this.value < rank.getValue(); }

    public boolean isEqualTo(Rank rank) { return this.value == rank.getValue(); }

    @Override
    public String toString() { return String.valueOf(rank); }
}
