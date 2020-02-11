package hu.idom.poker;

import java.util.List;
import java.util.Collections;

public class PokerGame {

    private static final int ACE = 1;
    private static final int TEN = 10;
    private static final int KING = 13;

    private List<Card> hand;

    public PokerHandScore evaluateHand(List<Card> hand) {
        PokerHandValidator phv = new PokerHandValidator();
        phv.validateHand(hand);
        this.hand = hand;
        return calculateHandScore();
    }

    private PokerHandScore calculateHandScore() {
        sortHand();
        if (isRoyalFlush()) {
            return PokerHandScore.ROYALFLUSH;
        }
        if (isStraightFlush()) {
            return PokerHandScore.STRAIGHTFLUSH;
        }
        if (isFlush()) {
            return PokerHandScore.FLUSH;
        }
        if (isStraight()) {
            return PokerHandScore.STRAIGHT;
        }
        return null;
    }

    private void sortHand() {
        Collections.sort(hand);
    }

    private boolean isRoyalFlush() {
        return isRoyal() && isStraightFlush();
    }

    private boolean isRoyal() {
        return hand.get(4).rank == KING && hand.get(0).rank == ACE;
    }

    private boolean isStraightFlush() {
        return isFlush() && isStraight();
    }

    private boolean isFlush() {
        Suit suitOfFirstCard = hand.get(0).suit;
        boolean allSameSuit = true;
        for (Card card : hand) {
            if (card.suit != suitOfFirstCard) {
                allSameSuit = false;
            }
        }
        return allSameSuit;
    }

    private boolean isStraight() {
        return hand.get(0).rank + 4 == hand.get(4).rank
                || isStraightWithAce();
    }

    private boolean isStraightWithAce() {
        return hand.get(0).rank == ACE
                && hand.get(1).rank == TEN
                && hand.get(1).rank + 3 == hand.get(4).rank;
    }
}
