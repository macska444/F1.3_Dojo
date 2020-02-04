package hu.idom.poker;

import java.util.List;
import java.util.Collections;

public class PokerGame {

    private List<Card> hand;

    public PokerHandScore evaluateHand(List<Card> hand) {
        PokerHandValidator phv = new PokerHandValidator();
        phv.validateHand(hand);
        this.hand = hand;
        return calculateHandScore();
    }

    private PokerHandScore calculateHandScore() {
        sortHand();
        if (isFlush() && isStraight()) {
            return PokerHandScore.STRAIGHTFLUSH;
        }
        if (isFlush()) {
            return PokerHandScore.FLUSH;
        }
        return null;
    }

    private void sortHand() {
        Collections.sort(hand);
    }

    private boolean isStraight() {
        return hand.get(0).rank + 4 == hand.get(4).rank;
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
}
