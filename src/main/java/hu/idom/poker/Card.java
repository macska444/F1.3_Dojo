package hu.idom.poker;

import java.util.Objects;

public class Card {
    
    public Suit suit;
    public Integer rank;

    public Card(Suit suit, Integer rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.suit);
        hash = 17 * hash + Objects.hashCode(this.rank);
        return hash;
    }

    @Override
    public boolean equals(Object objectCard) {
        return isCardObject(objectCard) && equalsTwoCard(this, (Card) objectCard);
    } 

    private static boolean isCardObject(Object objectCard) {
        return objectCard != null && Card.class == objectCard.getClass();
    }

    private boolean equalsTwoCard(Card thisCard, Card otherCard) {
        return thisCard.suit == otherCard.suit && thisCard.rank == otherCard.rank;
    } 
}