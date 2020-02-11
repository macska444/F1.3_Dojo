package hu.idom.poker;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import hu.idom.poker.exception.*;
import static org.junit.Assert.assertEquals;

public class PokerGameValidationTest {

    private PokerGame pokerGame;
    public List<Card> handWith4ValidCards;

    @Before
    public void setup() {
        pokerGame = new PokerGame();
        Card validCard2 = new Card(Suit.HEART, 4);
        Card validCard3 = new Card(Suit.HEART, 6);
        Card validCard4 = new Card(Suit.HEART, 8);
        Card validCard5 = new Card(Suit.HEART, 10);
        handWith4ValidCards = Arrays.asList(validCard2, validCard3, validCard4, validCard5);
    }

    @Test(expected = HandIsNullException.class)
    public void pokerHandIsNullTest() {
        pokerGame.evaluateHand(null);
    }

    @Test(expected = HandIsEmptyException.class)
    public void pokerHandIsEmptyTest() {
        pokerGame.evaluateHand(Arrays.asList());
    }

    @Test(expected = HandHasLessThan5CardsException.class)
    public void pokerHandHasLessThan5CardsTest() {
        pokerGame.evaluateHand(handWith4ValidCards);
    }

    @Test(expected = HandHasMoreThan5CardsException.class)
    public void pokerHandHasMoreThan5CardsTest() {
        List<Card> actualHand = new ArrayList<>();
        actualHand.addAll(handWith4ValidCards);

        Card firstExtraCard = new Card(Suit.HEART, 3);
        Card secondExtraCard = new Card(Suit.HEART, 5);
        actualHand.add(firstExtraCard);
        actualHand.add(secondExtraCard);

        pokerGame.evaluateHand(actualHand);
    }

    @Test(expected = CardIsNullException.class)
    public void pokerHandWithNullCardTest() {
        addExtraCardIntoTheHandAndEvaulateHand(null);
    }

    @Test(expected = CardIsNullException.class)
    public void cardRankIsNullTest() {
        addExtraCardIntoTheHandAndEvaulateHand(new Card(Suit.HEART, null));
    }

    @Test(expected = CardIsInvalidException.class)
    public void pokerHandHasHigherThen13RankOfCardTest() {
        addExtraCardIntoTheHandAndEvaulateHand(new Card(Suit.HEART, 14));
    }

    @Test(expected = CardIsInvalidException.class)
    public void pokerHandHasLessThen1RankOfCardTest() {
        addExtraCardIntoTheHandAndEvaulateHand(new Card(Suit.HEART, 0));
    }

    @Test(expected = CardIsNullException.class)
    public void cardSuitIsNullTest() {
        addExtraCardIntoTheHandAndEvaulateHand(new Card(null, 5));
    }

    @Test(expected = HandHasMoreSameCardsException.class)
    public void handHas2SameCard() {
        addExtraCardIntoTheHandAndEvaulateHand(new Card(Suit.HEART, 4));
    }



    public void addExtraCardIntoTheHandAndEvaulateHand(Card card) {
        List<Card> list = new ArrayList<>(handWith4ValidCards);
        list.add(card);
        pokerGame.evaluateHand(list);
    }
}