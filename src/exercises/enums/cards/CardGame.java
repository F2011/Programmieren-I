package exercises.enums.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class CardGame {
    private Stack<PlayingCard> cardDeck;

    public CardGame() {
        cardDeck = new Stack<>();
        for (PlayingCard.Suit value : PlayingCard.Suit.values()) {
            for (PlayingCard.CardValue cardValue : PlayingCard.CardValue.values()) {
                cardDeck.add(new PlayingCard(value, cardValue));
            }
        }
    }
    public void shuffle() {
        Collections.shuffle(cardDeck);
    }

    public void sort() {
        cardDeck.sort(null);
    }

    public PlayingCard get() {
        return cardDeck.pop();
    }

    public List<PlayingCard> all() {
        return cardDeck;
    }
}
