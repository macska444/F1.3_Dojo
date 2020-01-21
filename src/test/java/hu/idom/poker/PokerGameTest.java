package hu.idom.poker;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import hu.idom.poker.exception.*;
import org.junit.Ignore;

public class PokerGameTest
{
    private PokerGame pokerGame;
    public Card validCard;
    
    @Before
    public void setup(){
        pokerGame = new PokerGame();
        validCard = new Card("Heart",4);
    }

    @Test(expected = HandIsNullException.class)
    public void pokerHandIsNullTest(){
        pokerGame.evaluateHand(null);
    }

    @Test(expected = HandIsEmptyException.class)
    public void pokerHandIsEmptyTest(){
        pokerGame.evaluateHand(Arrays.asList());
    }

    @Test(expected = HandHasLessThan5CardsException.class)
    public void pokerHandHasLessThan5CardsTest(){
        pokerGame.evaluateHand(Arrays.asList(validCard, validCard, validCard, validCard));
    }

    @Test(expected = HandHasMoreThan5CardsException.class)
    public void pokerHandHasMoreThan5CardsTest(){
       pokerGame.evaluateHand(Arrays.asList(validCard, validCard, validCard, validCard, validCard, validCard));
    }

    @Test(expected = CardIsNullException.class)
    public void pokerHandWithNullCardTest() {
        pokerGame.evaluateHand(Arrays.asList(null, validCard, validCard, validCard, validCard));
    }
    
    @Test(expected = CardIsNullException.class)
    public void cardRankIsNullTest() {
       pokerGame.evaluateHand(Arrays.asList(new Card("Heart",null), validCard, validCard, validCard, validCard));
    }
    
    @Test(expected = CardIsInvalidException.class)
    public void pokerHandHasHigherThen13RankOfCardTest() {
       pokerGame.evaluateHand(Arrays.asList(new Card("Heart",14), validCard, validCard, validCard, validCard));
    }

    @Test(expected = CardIsInvalidException.class)
    public void pokerHandHasLessThen1RankOfCardTest() {
       pokerGame.evaluateHand(Arrays.asList(new Card("Heart",0), validCard, validCard, validCard, validCard));
    }
        
    @Test(expected = CardIsNullException.class)
    public void cardSuitIsNullTest() {
       pokerGame.evaluateHand(Arrays.asList(new Card(null,5), validCard, validCard, validCard, validCard));
    }
    
    @Test(expected = CardSuitIsInvalidException.class)
    public void pokerHandHasCardWithInvalidSuitTest() {
       pokerGame.evaluateHand(Arrays.asList(new Card("",5), validCard, validCard, validCard, validCard));
    }
    
   
}