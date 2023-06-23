

public class Main {
    public static void main(String[] args) {

        System.out.println("Card games by Steve and Travis");
        Player steve = new Player("Steve");
        Player travis = new Player("Travis");
        CardGame war = new War(steve, travis);
    }
}
