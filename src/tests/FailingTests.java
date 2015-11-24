package tests;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import game.Board;
import game.Fraction;
<<<<<<< HEAD
=======
import game.ProblemType;
>>>>>>> 4bb86f3ae9c6513109e96ee5e98d23cbbc77f51e
import game.Player;
import game.Problem;

public class FailingTests {
	
	private static Board board;

	@Before
	public void initialize(){
		board = new Board();
		board.initialize();
	}
	
	@Test(expected=Exception.class)
	public void testDivByZeroException() {
		new Fraction(5, 0);
	}
	
	@Test(expected=Exception.class)
	public void testDivByZeroException_2() {
		Fraction badFrac = new Fraction(5, 2);
		badFrac.setDenominator(0);
	}
	
	// Test makes sure the human Player moves correctly
	@Test
	public void playerMovesOneForward() {
		Player humanPlayer = new Player();
		humanPlayer.move();
		assertEquals(1, humanPlayer.getLocation());	//Player started at 0 and moved once, so should be at location 1
		humanPlayer.move();
		assertEquals(2, humanPlayer.getLocation());	// PLayer moved again, so now should be at location 2
	}
	
	// Tests make sure the computer players move as expected
	@Test
	public void CPUMovesCorrectly(){
		Problem fraction1 = new Problem(ProblemType.Core1);
		board.setCurrentProblem(fraction1);
		board.setAnswerRight(false);
		board.movePlayer();
		assertEquals(1, board.getPlayers().get(1).getLocation());	//Make sure the correct CPU moved
		assertEquals(0, board.getPlayers().get(0).getLocation());	//Make sure no other player moved
		assertEquals(0, board.getPlayers().get(2).getLocation());
		assertEquals(0, board.getPlayers().get(3).getLocation());
		
		Problem fraction2 = new Problem(ProblemType.Core2);
		board.setCurrentProblem(fraction2);
		board.movePlayer();
		assertEquals(1, board.getPlayers().get(1).getLocation());	//Make sure the correct CPU moved
		assertEquals(0, board.getPlayers().get(0).getLocation());	//Make sure no other player moved
		assertEquals(1, board.getPlayers().get(2).getLocation());
		assertEquals(0, board.getPlayers().get(3).getLocation());
		
		Problem fraction3 = new Problem(ProblemType.Core3b);
		board.setCurrentProblem(fraction3);
		board.movePlayer();
		assertEquals(1, board.getPlayers().get(1).getLocation());	//Make sure the correct CPU moved
		assertEquals(0, board.getPlayers().get(0).getLocation());	//Make sure no other player moved
		assertEquals(1, board.getPlayers().get(2).getLocation());
		assertEquals(1, board.getPlayers().get(3).getLocation());
		
		Problem fraction4 = new Problem(ProblemType.Core3c);
		board.setCurrentProblem(fraction4);
		board.setAnswerRight(true);
		board.movePlayer();
		assertEquals(1, board.getPlayers().get(1).getLocation());	//Make sure the correct Player moved
		assertEquals(1, board.getPlayers().get(0).getLocation());	//Make sure no other CPU moved
		assertEquals(1, board.getPlayers().get(2).getLocation());
		assertEquals(1, board.getPlayers().get(3).getLocation());
		
		board.setAnswerRight(false);
		board.movePlayer();
		assertEquals(1, board.getPlayers().get(1).getLocation());	//Make sure the correct Player moved
		assertEquals(1, board.getPlayers().get(0).getLocation());	//Make sure no other CPU moved
		assertEquals(2, board.getPlayers().get(2).getLocation());
		assertEquals(1, board.getPlayers().get(3).getLocation());
		
		Problem problem5 = new Problem(ProblemType.Core4);
		board.setCurrentProblem(problem5);
		board.movePlayer();
		assertEquals(1, board.getPlayers().get(1).getLocation());	//Make sure the correct CPU moved
		assertEquals(1, board.getPlayers().get(0).getLocation());	//Make sure no other player moved
		assertEquals(2, board.getPlayers().get(2).getLocation());
		assertEquals(2, board.getPlayers().get(3).getLocation());
		
		Problem problem6 = new Problem(ProblemType.Core5);
		board.setCurrentProblem(problem6);
		board.movePlayer();
		assertEquals(2, board.getPlayers().get(1).getLocation());	//Make sure the correct CPU moved
		assertEquals(1, board.getPlayers().get(0).getLocation());	//Make sure no other player moved
		assertEquals(2, board.getPlayers().get(2).getLocation());
		assertEquals(2, board.getPlayers().get(3).getLocation());
	}
	
	@Test
	public void gameEndsRight(){
		//Make sure the game ends when ANY player is at the end
		board.getPlayers().get(0).setLocation(board.MAX_SIZE);
		assertTrue(board.checkOver());
		board.getPlayers().get(0).setLocation(0);
		board.getPlayers().get(1).setLocation(board.MAX_SIZE);
		assertTrue(board.checkOver());
		board.getPlayers().get(1).setLocation(0);
		board.getPlayers().get(2).setLocation(board.MAX_SIZE);
		assertTrue(board.checkOver());
		board.getPlayers().get(2).setLocation(0);
		board.getPlayers().get(3).setLocation(board.MAX_SIZE);
		assertTrue(board.checkOver());
		// Make sure the game doesn't end if no one is at the end
		board.getPlayers().get(3).setLocation(0);
		assertFalse(board.checkOver());
		
	}
	
	@Test
	public void TestCore1(){
		
	}
	
	@Test
	public void TestCore2(){
		Fraction core2Fraction1 = new Fraction(1,2);
		Fraction core2Fraction2 = new Fraction(2,4);
		assertTrue(core2Fraction1.getNumerator() / core2Fraction1.getDenominator() 
				== core2Fraction2.getNumerator() / core2Fraction2.getDenominator());
		Fraction core2Fraction3 = new Fraction(1,5);
		Fraction core2Fraction4 = new Fraction(3,4);
		assertTrue(core2Fraction3.getNumerator() / core2Fraction3.getDenominator() 
				< core2Fraction4.getNumerator() / core2Fraction4.getDenominator());
		Fraction core2Fraction5 = new Fraction(2,3);
		Fraction core2Fraction6 = new Fraction(1,4);
		assertTrue(core2Fraction5.getNumerator() / core2Fraction5.getDenominator() 
				> core2Fraction6.getNumerator() / core2Fraction6.getDenominator());
		
	}
	
	@Test
	public void TestCore3b(){
		
	}
	
	@Test
	public void TestCore3c(){
		
	}
	
	@Test
	public void TestCore4(){
		
	}
	
	@Test
	public void TestCore5(){
		
	}

}
