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
        PokerHandResult actualHandResult
                = pokerGame.evaluateHand(
                Arrays.asList(
                        new Card(Suit.HEART, 2),
                        new Card(Suit.HEART, 4),
                        new Card(Suit.HEART, 6),
                        new Card(Suit.HEART, 8),
                        new Card(Suit.HEART, 10)
                )
        );
        assertEquals(PokerHandScore.FLUSH, actualHandResult.pokerHandScore);
    }

    @Test
    public void straightFlushTest() {
        PokerHandResult actualHandResult
                = pokerGame.evaluateHand(
                Arrays.asList(
                        new Card(Suit.HEART, 12),
                        new Card(Suit.HEART, 10),
                        new Card(Suit.HEART, 11),
                        new Card(Suit.HEART, 9),
                        new Card(Suit.HEART, 13)
                )
        );
        assertEquals(PokerHandScore.STRAIGHT_FLUSH, actualHandResult.pokerHandScore);
    }

    @Test
    public void straightFlushWithAceTest() {
        PokerHandResult actualHandResult
                = pokerGame.evaluateHand(
                Arrays.asList(
                        new Card(Suit.HEART, 5),
                        new Card(Suit.HEART, 4),
                        new Card(Suit.HEART, 3),
                        new Card(Suit.HEART, 1),
                        new Card(Suit.HEART, 2)
                )
        );
        assertEquals(PokerHandScore.STRAIGHT_FLUSH, actualHandResult.pokerHandScore);
    }

    @Test
    public void straightWithAceTest() {
        PokerHandResult actualHandResult
                = pokerGame.evaluateHand(
                Arrays.asList(
                        new Card(Suit.DIAMOND, 12),
                        new Card(Suit.HEART, 10),
                        new Card(Suit.HEART, 11),
                        new Card(Suit.HEART, 1),
                        new Card(Suit.HEART, 13)
                )
        );
        assertEquals(PokerHandScore.STRAIGHT, actualHandResult.pokerHandScore);
    }

    @Test
    public void straightWithLowAceTest() {
        PokerHandResult actualHandResult
                = pokerGame.evaluateHand(
                Arrays.asList(
                        new Card(Suit.DIAMOND, 4),
                        new Card(Suit.HEART, 3),
                        new Card(Suit.HEART, 2),
                        new Card(Suit.HEART, 1),
                        new Card(Suit.HEART, 5)
                )
        );
        assertEquals(PokerHandScore.STRAIGHT, actualHandResult.pokerHandScore);
    }

    @Test
    public void royalFlushTest() {
        PokerHandResult actualHandResult
                = pokerGame.evaluateHand(
                Arrays.asList(
                        new Card(Suit.HEART, 12),
                        new Card(Suit.HEART, 10),
                        new Card(Suit.HEART, 11),
                        new Card(Suit.HEART, 1),
                        new Card(Suit.HEART, 13)
                )
        );
        assertEquals(PokerHandScore.ROYAL_FLUSH, actualHandResult.pokerHandScore);
    }

    @Test
    public void onePairTest() {
        PokerHandResult actualHandResult
                = pokerGame.evaluateHand(
                Arrays.asList(
                        new Card(Suit.HEART, 10),
                        new Card(Suit.DIAMOND, 10),
                        new Card(Suit.HEART, 8),
                        new Card(Suit.HEART, 1),
                        new Card(Suit.HEART, 4)
                )
        );
        assertEquals(PokerHandScore.ONE_PAIR, actualHandResult.pokerHandScore);
    }

    @Test
    public void onePairTest2() {
        PokerHandResult actualHandResult
                = pokerGame.evaluateHand(
                Arrays.asList(
                        new Card(Suit.HEART, 9),
                        new Card(Suit.DIAMOND, 9),
                        new Card(Suit.HEART, 11),
                        new Card(Suit.HEART, 12),
                        new Card(Suit.HEART, 13)
                )
        );
        assertEquals(PokerHandScore.ONE_PAIR, actualHandResult.pokerHandScore);
    }

    @Test
    public void threeOfAKindTest() {
        PokerHandResult actualHandResult
                = pokerGame.evaluateHand(
                Arrays.asList(
                        new Card(Suit.HEART, 9),
                        new Card(Suit.DIAMOND, 10),
                        new Card(Suit.DIAMOND, 9),
                        new Card(Suit.HEART, 11),
                        new Card(Suit.SPADE, 9)
                )
        );
        assertEquals(PokerHandScore.THREE_OF_A_KIND, actualHandResult.pokerHandScore);
    }

    @Test
    public void threeOfAKindTest2() {
        PokerHandResult actualHandResult
                = pokerGame.evaluateHand(
                Arrays.asList(
                        new Card(Suit.HEART, 9),
                        new Card(Suit.DIAMOND, 12),
                        new Card(Suit.DIAMOND, 9),
                        new Card(Suit.HEART, 8),
                        new Card(Suit.SPADE, 9)
                )
        );
        assertEquals(PokerHandScore.THREE_OF_A_KIND, actualHandResult.pokerHandScore);
    }

    @Test
    public void fourOfAKindTest() {
        PokerHandResult actualHandResult
                = pokerGame.evaluateHand(
                Arrays.asList(
                        new Card(Suit.HEART, 1),
                        new Card(Suit.DIAMOND, 1),
                        new Card(Suit.DIAMOND, 9),
                        new Card(Suit.CLUB, 1),
                        new Card(Suit.SPADE, 1)
                )
        );
        assertEquals(PokerHandScore.FOUR_OF_A_KIND, actualHandResult.pokerHandScore);
    }

    @Test
    public void fullHouseTest() {
        PokerHandResult actualHandResult
                = pokerGame.evaluateHand(
                Arrays.asList(
                        new Card(Suit.HEART, 1),
                        new Card(Suit.SPADE, 1),
                        new Card(Suit.DIAMOND, 1),
                        new Card(Suit.CLUB, 2),
                        new Card(Suit.SPADE, 2)
                )
        );
        assertEquals(PokerHandScore.FULL_HOUSE, actualHandResult.pokerHandScore);
    }

    @Test
    public void twoPairTest() {
        PokerHandResult actualHandResult
                = pokerGame.evaluateHand(
                Arrays.asList(
                        new Card(Suit.HEART, 1),
                        new Card(Suit.SPADE, 1),
                        new Card(Suit.DIAMOND, 8),
                        new Card(Suit.CLUB, 2),
                        new Card(Suit.SPADE, 2)
                )
        );
        assertEquals(PokerHandScore.TWO_PAIR, actualHandResult.pokerHandScore);
    }

    @Test
    public void highCardTest() {
        PokerHandResult actualHandResult
                = pokerGame.evaluateHand(
                Arrays.asList(
                        new Card(Suit.HEART, 1),
                        new Card(Suit.SPADE, 3),
                        new Card(Suit.DIAMOND, 8),
                        new Card(Suit.CLUB, 4),
                        new Card(Suit.SPADE, 2)
                )
        );
        assertEquals(PokerHandScore.HIGH_CARD, actualHandResult.pokerHandScore);
    }
}
