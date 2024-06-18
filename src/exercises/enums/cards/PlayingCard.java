package exercises.enums.cards;

public class PlayingCard implements Comparable<PlayingCard> {
    public enum Suit {
        DIAMONDS, HEARTS, SPADE, CLUBS;
    }

    public enum CardValue {
        SEVEN, EIGHT, NINE, JACK, QUEEN, KING, TEN, ACE;
    }

    private Suit suit;
    private CardValue value;

    public PlayingCard(Suit suit, CardValue value) {
        this.suit = suit;
        this.value = value;
    }

    public int compareTo(PlayingCard other) {
        if (this.value.compareTo(other.value) == 0) {
            return this.suit.compareTo(other.suit);
        } else {
            return this.value.compareTo(other.value);
        }
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }
}
