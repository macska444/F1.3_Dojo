package hu.idom.poker;

import java.util.List;
import hu.idom.poker.exception.*;

public class PokerGame {

    private final static int NUMBER_OF_CARDS_IN_HAND = 5;

    public void evaluateHand(List hand) {
        validateHand(hand);
    }

    private void validateHand(List hand) {
        validateHandIsNull(hand);
        validateHandSize(hand);
        validateCards(hand);
    }

    private void validateCards(List hand) {
        for (int i=0;i<hand.size();i++) {
            validateCard((String)hand.get(i));
        }
    }

    private void validateCard(String card) {
        if (card == null ) {
            throw new CardIsNullException();
        } else if (card.equals("")) {
            throw new CardIsEmptyException();
        }
    }

    private void validateHandIsNull(List hand){
        if (hand == null){
            throw new HandIsNullException();
        }
    }

    private void validateHandSize(List hand){
        if(hand.isEmpty()) {
            throw new HandIsEmptyException();
        }else if(hand.size() < NUMBER_OF_CARDS_IN_HAND){
            throw new HandHasLessThan5CardsException();
        }else if(hand.size() > NUMBER_OF_CARDS_IN_HAND){
            throw new HandHasMoreThan5CardsException();
        }
    }
}
