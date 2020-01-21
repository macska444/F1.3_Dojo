package hu.idom.poker;

import java.util.List;
import hu.idom.poker.exception.*;

public class PokerGame {

    private static final int NUMBER_OF_CARDS_IN_HAND = 5;
    private static final int HIGHEST_RANK_OF_CARDS = 13;
    private static final int LOWEST_RANK_OF_CARDS = 1;

    public void evaluateHand(List<Card> hand) {
        validateHand(hand);
    }

    private void validateHand(List<Card> hand) {
        validateHandIsNull(hand);
        validateHandSize(hand);
        validateCards(hand);
    }

    private void validateCards(List<Card> hand) {
        for (int i=0;i<hand.size();i++) {
            validateCard(hand.get(i));
        }
    }

    private void validateCard(Card card) {
        if (card == null || card.rank == null || card.suit == null ) {
            throw new CardIsNullException();
        } else if (card.rank > HIGHEST_RANK_OF_CARDS || card.rank < LOWEST_RANK_OF_CARDS ) {
            throw new CardIsInvalidException();
        } else if (card.suit.equals("")) {
            throw new CardSuitIsInvalidException();
        }   
    }

    private void validateHandIsNull(List<Card> hand){
        if (hand == null){
            throw new HandIsNullException();
        }
    }

    private void validateHandSize(List<Card> hand){
        if(hand.isEmpty()) {
            throw new HandIsEmptyException();
        }else if(hand.size() < NUMBER_OF_CARDS_IN_HAND){
            throw new HandHasLessThan5CardsException();
        }else if(hand.size() > NUMBER_OF_CARDS_IN_HAND){
            throw new HandHasMoreThan5CardsException();
        }
    }
}