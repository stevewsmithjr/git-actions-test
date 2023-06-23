import java.util.List;

public abstract class CardGame {
    public boolean aceHigh;
    public char[] cardList;
    public char[] suits = {'S','H','D','C'};
    protected List<Rank> rankList;
    public Deck gameDeck;
    public int FULLDECK;
    protected List<Player> playerList;

    public boolean isAceHigh() {
        return aceHigh;
    }

    public abstract void setup();
    public abstract void deal();
    public abstract void play();
}
