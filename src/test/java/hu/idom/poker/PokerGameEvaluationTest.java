package hu.idom.poker;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PokerGameEvaluationTest {

    private PokerGame pokerGame;

    @Before
    public void setup() {
        pokerGame = new PokerGame();
    }

    @Test
    public void flushTest() {
        PokerHandScore actualHandResult
                = pokerGame.evaluateHand(
                Arrays.asList(
                        new Card(Suit.HEART, 2),
                        new Card(Suit.HEART, 4),
                        new Card(Suit.HEART, 6),
                        new Card(Suit.HEART, 8),
                        new Card(Suit.HEART, 10)
                )
        );
        assertEquals(PokerHandScore.FLUSH, actualHandResult);
    }

    @Test
    public void straightFlushTest() {
        PokerHandScore actualHandResult
                = pokerGame.evaluateHand(
                Arrays.asList(
                        new Card(Suit.HEART, 12),
                        new Card(Suit.HEART, 10),
                        new Card(Suit.HEART, 11),
                        new Card(Suit.HEART, 9),
                        new Card(Suit.HEART, 13)
                )
        );
        assertEquals(PokerHandScore.STRAIGHT_FLUSH, actualHandResult);
    }

    @Test
    public void straightFlushWithAceTest() {
        PokerHandScore actualHandResult
                = pokerGame.evaluateHand(
                Arrays.asList(
                        new Card(Suit.HEART, 5),
                        new Card(Suit.HEART, 4),
                        new Card(Suit.HEART, 3),
                        new Card(Suit.HEART, 1),
                        new Card(Suit.HEART, 2)
                )
        );
        assertEquals(PokerHandScore.STRAIGHT_FLUSH, actualHandResult);
    }

    @Test
    public void straightWithAceTest() {
        PokerHandScore actualHandResult
                = pokerGame.evaluateHand(
                Arrays.asList(
                        new Card(Suit.DIAMOND, 12),
                        new Card(Suit.HEART, 10),
                        new Card(Suit.HEART, 11),
                        new Card(Suit.HEART, 1),
                        new Card(Suit.HEART, 13)
                )
        );
        assertEquals(PokerHandScore.STRAIGHT, actualHandResult);
    }

    @Test
    public void straightWithLowAceTest() {
        PokerHandScore actualHandResult
                = pokerGame.evaluateHand(
                Arrays.asList(
                        new Card(Suit.DIAMOND, 4),
                        new Card(Suit.HEART, 3),
                        new Card(Suit.HEART, 2),
                        new Card(Suit.HEART, 1),
                        new Card(Suit.HEART, 5)
                )
        );
        assertEquals(PokerHandScore.STRAIGHT, actualHandResult);
    }

    @Test
    public void royalFlushTest() {
        PokerHandScore actualHandResult
                = pokerGame.evaluateHand(
                Arrays.asList(
                        new Card(Suit.HEART, 12),
                        new Card(Suit.HEART, 10),
                        new Card(Suit.HEART, 11),
                        new Card(Suit.HEART, 1),
                        new Card(Suit.HEART, 13)
                )
        );
        assertEquals(PokerHandScore.ROYAL_FLUSH, actualHandResult);
    }

    @Test
    public void onePairTest() {
        PokerHandScore actualHandResult
                = pokerGame.evaluateHand(
                Arrays.asList(
                        new Card(Suit.HEART, 10),
                        new Card(Suit.DIAMOND, 10),
                        new Card(Suit.HEART, 8),
                        new Card(Suit.HEART, 1),
                        new Card(Suit.HEART, 4)
                )
        );
        assertEquals(PokerHandScore.ONE_PAIR, actualHandResult);
    }

    @Test
    public void onePairTest2() {
        PokerHandScore actualHandResult
                = pokerGame.evaluateHand(
                Arrays.asList(
                        new Card(Suit.HEART, 9),
                        new Card(Suit.DIAMOND, 9),
                        new Card(Suit.HEART, 11),
                        new Card(Suit.HEART, 12),
                        new Card(Suit.HEART, 13)
                )
        );
        assertEquals(PokerHandScore.ONE_PAIR, actualHandResult);
    }

    @Test
    public void threeOfAKindTest() {
        PokerHandScore actualHandResult
                = pokerGame.evaluateHand(
                Arrays.asList(
                        new Card(Suit.HEART, 9),
                        new Card(Suit.DIAMOND, 10),
                        new Card(Suit.DIAMOND, 9),
                        new Card(Suit.HEART, 11),
                        new Card(Suit.SPADE, 9)
                )
        );
        assertEquals(PokerHandScore.THREE_OF_A_KIND, actualHandResult);
    }

    @Test
    public void threeOfAKindTest2() {
        PokerHandScore actualHandResult
                = pokerGame.evaluateHand(
                Arrays.asList(
                        new Card(Suit.HEART, 9),
                        new Card(Suit.DIAMOND, 12),
                        new Card(Suit.DIAMOND, 9),
                        new Card(Suit.HEART, 8),
                        new Card(Suit.SPADE, 9)
                )
        );
        assertEquals(PokerHandScore.THREE_OF_A_KIND, actualHandResult);
    }

    @Test
    public void fourOfAKindTest() {
        PokerHandScore actualHandResult
                = pokerGame.evaluateHand(
                Arrays.asList(
                        new Card(Suit.HEART, 1),
                        new Card(Suit.DIAMOND, 1),
                        new Card(Suit.DIAMOND, 9),
                        new Card(Suit.CLUB, 1),
                        new Card(Suit.SPADE, 1)
                )
        );
        assertEquals(PokerHandScore.FOUR_OF_A_KIND, actualHandResult);
    }

    @Test
    public void fullHouseTest() {
        PokerHandScore actualHandResult
                = pokerGame.evaluateHand(
                Arrays.asList(
                        new Card(Suit.HEART, 1),
                        new Card(Suit.SPADE, 1),
                        new Card(Suit.DIAMOND, 1),
                        new Card(Suit.CLUB, 2),
                        new Card(Suit.SPADE, 2)
                )
        );
        assertEquals(PokerHandScore.FULL_HOUSE, actualHandResult);
    }

    @Test
    public void twoPairTest() {
        PokerHandScore actualHandResult
                = pokerGame.evaluateHand(
                Arrays.asList(
                        new Card(Suit.HEART, 1),
                        new Card(Suit.SPADE, 1),
                        new Card(Suit.DIAMOND, 8),
                        new Card(Suit.CLUB, 2),
                        new Card(Suit.SPADE, 2)
                )
        );
        assertEquals(PokerHandScore.TWO_PAIR, actualHandResult);
    }

    @Test
    public void highCardTest() {
        PokerHandScore actualHandResult
                = pokerGame.evaluateHand(
                Arrays.asList(
                        new Card(Suit.HEART, 1),
                        new Card(Suit.SPADE, 3),
                        new Card(Suit.DIAMOND, 8),
                        new Card(Suit.CLUB, 4),
                        new Card(Suit.SPADE, 2)
                )
        );
        assertEquals(PokerHandScore.HIGH_CARD, actualHandResult);
    }
}
