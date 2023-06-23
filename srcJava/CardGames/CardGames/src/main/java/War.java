import java.util.ArrayList;
import java.util.Arrays;
import java.util.Arrays;
import java.util.List;

public class War extends CardGame{
    public Player player1;
    public Player player2;


    public War(Player p1, Player p2){
        cardList = new char[]{'2', '3', '4', '5', '6', '7', '8', '9', 'X', 'J', 'Q', 'K', 'A'};
        FULLDECK = 52;
        aceHigh = true;
        this.player1 = p1;
        this.player2 = p2;
        playerList = new ArrayList<Player>(Arrays.asList(p1, p2));
        setup();
        deal();
        play();
    }

    public void setup() {
        rankList = Arrays.asList(
                new Rank('2', 2),
                new Rank('3', 3),
                new Rank('4', 4),
                new Rank('5', 5),
                new Rank('6', 6),
                new Rank('7', 7),
                new Rank('8', 8),
                new Rank('9', 9),
                new Rank('X', 10),
                new Rank('J', 11),
                new Rank('Q', 12),
                new Rank('K', 13),
                new Rank('A', 14));
        List<Card> deckList = new ArrayList<Card>();
        for (Rank rank : rankList){
            for (char suit : suits){
                deckList.add(new Card(rank, suit));
            }
        }
        gameDeck = new Deck(deckList);
        gameDeck.shuffle();
    }

    public void deal() {
        int cardsToDeal = FULLDECK/playerList.size();
        for (Player player : playerList){
            for (int i = 0; i < cardsToDeal; i++) {
                player.drawCard(gameDeck);
            }
        }
    }

    public void play() {
        boolean gameOver = false;
        int duelCount = 0;

        while(!gameOver){
            duel2(player1, player2);
            duelCount++;
            if (player1.hand.size() == 0) {
                System.out.println(player2.name + " won the War!");
                gameOver = true;
            }
            if (player2.hand.size() == 0) {
                System.out.println(player1.name + " won the War!");
                gameOver = true;
            }
        }
        System.out.println("There were a total of " + duelCount + " duels.");
    }


    /*
        duel2 is explicitly for duels between two players. We will have to re-write a duel function
        thank incorporates comparisons for a list of players > 2
     */
    public Player duel2(Player p1, Player p2) {
        List<Card> bounty = new ArrayList<Card>();
        Card a = p1.hand.get(0);
        Card b = p2.hand.get(0);
        Player winner = null;
        boolean tie = false;
        p1.hand.remove(a);
        p2.hand.remove(b);
        bounty.add(a); bounty.add(b);
        p1.showHand();
        p2.showHand();
        //System.out.print(p1.name + " threw: "); System.out.println(a.toString());
        //System.out.print(p2.name + " threw: "); System.out.println(b.toString());

        if (a.isHigherThan(b)) {
            winner = p1;
        }
        else if (b.isHigherThan(a)) {
            winner = p2;
        }
        else if (a.rankMatches(b)) {
            int wager = 3;
            tie = true;
            if (p1.hand.size() == 0 || p2.hand.size() == 0) {
                return p1.hand.size() == 0 ? p2 : p1;
            }
            if (p1.hand.size() < 4 || p2.hand.size() < 4) {
                wager = p1.hand.size() < 4 ? p1.hand.size()-1 : p2.hand.size()-1;
            }

            for (int i = 0; i < wager; i++) {
                bounty.add(p1.hand.get(i)); bounty.add(p2.hand.get(i));
            }

            p1.hand.removeAll(bounty);
            p2.hand.removeAll(bounty);
            System.out.println("A tie!");
            System.out.println(System.lineSeparator());
            winner = duel2(p1, p2);
        }
        else {
            System.out.println("Card value error.");
            System.exit(0);
        }
        winner.hand.addAll(bounty);

        if (!tie) {
            System.out.println(winner.name + " won the duel.");
        }
        System.out.println(System.lineSeparator());
        return winner;

    }


}
