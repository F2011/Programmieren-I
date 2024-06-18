package exercises.enums.cards;

public class TestGame {
    public static void main(String[] args) {
        CardGame game = new CardGame();
        System.out.println(game.all());

        game.shuffle();
        System.out.println(game.all());

        PlayingCard hearts7 = new PlayingCard(PlayingCard.Suit.HEARTS, PlayingCard.CardValue.NINE);
        for (int i = 0; i < 10; i++) {
            PlayingCard card = game.get();
            System.out.println(card + (card.compareTo(hearts7) > 0 ? " > " : card.compareTo(hearts7) < 0 ? " < " : " = ") + hearts7);
        }

        System.out.println(game.all());
        System.out.println("\nSorted: \n");
        game.sort();
        System.out.println(game.all());

        // additional test
        PlayingCard card1 = new PlayingCard(PlayingCard.Suit.HEARTS, PlayingCard.CardValue.NINE);
        PlayingCard card2 = new PlayingCard(PlayingCard.Suit.HEARTS, PlayingCard.CardValue.NINE);
        System.out.println(card1 + (card1.compareTo(card2) > 0 ? " > " : card1.compareTo(card2) < 0 ? " < " : " = ") + card2);
    }
}
