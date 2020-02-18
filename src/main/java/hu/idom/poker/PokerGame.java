package hu.idom.poker;

import java.util.List;
import java.util.Collections;

public class PokerGame {

    private static final int ACE = 1;
    private static final int TEN = 10;
    private static final int KING = 13;

    private List<Card> hand;
    private int[] sameCards;

    public PokerHandScore evaluateHand(List<Card> hand) {
        PokerHandValidator phv = new PokerHandValidator();
        phv.validateHand(hand);
        this.hand = hand;
        return calculateHandScore();
    }

    private PokerHandScore calculateHandScore() {
        prepareHand();
        if (isRoyalFlush()) {
            return PokerHandScore.ROYALFLUSH;
        }
        if (isStraightFlush()) {
            return PokerHandScore.STRAIGHTFLUSH;
        }
        if (isFourOfAKind()) {
            return PokerHandScore.FOUROFAKIND;
        }
        if (isFullHouse()) {
            return PokerHandScore.FULLHOUSE;
        }
        if (isFlush()) {
            return PokerHandScore.FLUSH;
        }
        if (isStraight()) {
            return PokerHandScore.STRAIGHT;
        }
        if (isThreeOfAKind()) {
            return PokerHandScore.THREEOFAKIND;
        }
        if (isTwoPair()) {
            return PokerHandScore.TWOPAIR;
        }
        if (isOnePair()) {
            return PokerHandScore.ONEPAIR;
        }
        return null;
    }

    private void prepareHand() {
        sortHand();
        countOfCardsRank();
    }

    private void sortHand() {
        Collections.sort(hand);
    }

    private void countOfCardsRank() {
        sameCards = new int[15];
        for (int i = 0; i < hand.size(); i++) {
            sameCards[hand.get(i).rank]++;
        }
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

    private boolean isFourOfAKind() {
        return hasNumberOfSameCards(4);
    }

    private boolean isFullHouse() {
        return hasNumberOfSameCards(3) && hasNumberOfSameCards(2);
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
        return !isOnePair() && !isThreeOfAKind() && !isFourOfAKind() && isRankDifferenceOk();
    }

    private boolean isRankDifferenceOk() {
        return isRankDifferenceOkWithoutAce() || isRankDifferenceOkWithAce();
    }

    private boolean isRankDifferenceOkWithoutAce() {
        return hand.get(0).rank + 4 == hand.get(4).rank;
    }

    private boolean isRankDifferenceOkWithAce() {
        return hand.get(0).rank == ACE
                && hand.get(1).rank == TEN
                && hand.get(1).rank + 3 == hand.get(4).rank;
    }

    private boolean isThreeOfAKind() {
        return hasNumberOfSameCards(3);
    }

    private boolean isTwoPair() {
        int pairCount = 0;
        for (int i = 0; i < sameCards.length; i++) {
            if (sameCards[i] == 2) {
                pairCount++;
            }
        }
        return pairCount == 2;
    }

    private boolean isOnePair() {
        return hasNumberOfSameCards(2);
    }

    private boolean hasNumberOfSameCards(int numberOfSameCard) {
        boolean hasSameCards = false;
        for (int i = 0; i < sameCards.length; i++) {
            if (sameCards[i] == numberOfSameCard) {
                hasSameCards = true;
            }
        }
        return hasSameCards;
    }
}
