package ooo;
public class Solution {
    static class Deck {
        final Card[] cards = new Card[52];

        Deck() {
            int i = 0;
            for (Card.Suit suit : Card.Suit.values())
                for (Card.Val val : Card.Val.values())
                    cards[i++] = new Card(suit, val);
        }
    }

    static class Card {
        final Suit suit;
        final Val val;

        Card(Suit suit, Val val) {
            this.suit = suit;
            this.val = val;
        }

        enum Suit {spades, hearts, clubs, diamonds}

        enum Val {two, three, four, five, six, seven, eight, nine, ten, jack, queen, king, ace}
    }

}
