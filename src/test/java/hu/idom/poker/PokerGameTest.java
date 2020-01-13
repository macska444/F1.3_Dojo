package hu.idom.poker;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import hu.idom.poker.exception.*;

public class PokerGameTest
{
    private PokerGame pokerGame;

    @Before
    public void setup(){
        pokerGame = new PokerGame();
    }

    @Test(expected = HandIsNullException.class)
    public void pokerHandIsNullTest(){
        pokerGame.evaluateHand(null);
    }

    @Test(expected = HandIsEmptyException.class)
    public void pokerHandIsEmptyTest(){
        pokerGame.evaluateHand(new ArrayList<>());
    }

    @Test(expected = HandHasLessThan5CardsException.class)
    public void pokerHandHasLessThan5CardsTest(){
        pokerGame.evaluateHand(Arrays.asList("", "", "", ""));
    }

    @Test(expected = HandHasMoreThan5CardsException.class)
    public void pokerHandHasMoreThan5CardsTest(){
        pokerGame.evaluateHand(Arrays.asList("", "", "", "", "", ""));
    }

    @Test(expected = CardIsNullException.class)
    public void pokerHandWithNullCardTest() {
        pokerGame.evaluateHand(Arrays.asList(null, "", "", "", ""));
    }

    @Test(expected = CardIsEmptyException.class)
    public void pokerHandHasAnyEmptyCardTest() {
        pokerGame.evaluateHand(Arrays.asList("", "", "", "", ""));
    }
}
