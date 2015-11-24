package tests;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import game.Board;
import game.Fraction;
import game.FractionType;
import game.Player;

public class FailingTests {
	
	private static Board board;

	@Before
	public void initialize(){
		board = new Board();
		board.initialize();
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
		Fraction fraction1 = new Fraction(FractionType.Core1);
		board.setCurrentProblem(fraction1);
		board.setAnswerRight(false);
		board.movePlayer();
		assertEquals(1, board.getPlayers().get(1).getLocation());	//Make sure the correct CPU moved
		assertEquals(0, board.getPlayers().get(0).getLocation());	//Make sure no other player moved
		assertEquals(0, board.getPlayers().get(2).getLocation());
		assertEquals(0, board.getPlayers().get(3).getLocation());
		
		Fraction fraction2 = new Fraction(FractionType.Core2);
		board.setCurrentProblem(fraction2);
		board.movePlayer();
		assertEquals(1, board.getPlayers().get(1).getLocation());	//Make sure the correct CPU moved
		assertEquals(0, board.getPlayers().get(0).getLocation());	//Make sure no other player moved
		assertEquals(1, board.getPlayers().get(2).getLocation());
		assertEquals(0, board.getPlayers().get(3).getLocation());
		
		Fraction fraction3 = new Fraction(FractionType.Core3b);
		board.setCurrentProblem(fraction3);
		board.movePlayer();
		assertEquals(1, board.getPlayers().get(1).getLocation());	//Make sure the correct CPU moved
		assertEquals(0, board.getPlayers().get(0).getLocation());	//Make sure no other player moved
		assertEquals(1, board.getPlayers().get(2).getLocation());
		assertEquals(1, board.getPlayers().get(3).getLocation());
		
		Fraction fraction4 = new Fraction(FractionType.Core3c);
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
		
		Fraction fraction5 = new Fraction(FractionType.Core4);
		board.setCurrentProblem(fraction5);
		board.movePlayer();
		assertEquals(1, board.getPlayers().get(1).getLocation());	//Make sure the correct CPU moved
		assertEquals(1, board.getPlayers().get(0).getLocation());	//Make sure no other player moved
		assertEquals(2, board.getPlayers().get(2).getLocation());
		assertEquals(2, board.getPlayers().get(3).getLocation());
		
		Fraction fraction6 = new Fraction(FractionType.Core5);
		board.setCurrentProblem(fraction6);
		board.movePlayer();
		assertEquals(2, board.getPlayers().get(1).getLocation());	//Make sure the correct CPU moved
		assertEquals(1, board.getPlayers().get(0).getLocation());	//Make sure no other player moved
		assertEquals(2, board.getPlayers().get(2).getLocation());
		assertEquals(2, board.getPlayers().get(3).getLocation());
	}
	
	@Test
	public void gameEndsRight(){
		
	}
	
	@Test
	public void TestCore1(){
		
	}
	
	@Test
	public void TestCore2(){
		
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
