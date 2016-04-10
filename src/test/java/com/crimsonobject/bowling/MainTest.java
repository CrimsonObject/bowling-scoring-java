package com.crimsonobject.bowling;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.crimsonobject.game.LinkedListBowling;
import com.crimsonobject.objects.Player;

public class MainTest {

	private static Player player1 = new Player("Tom");
	private static List<Player> playerList = new ArrayList<Player>();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		playerList.add(player1);
	}

	@Test
	public void testTwoThrowsNotSpareOrStrike() {
		LinkedListBowling game = new LinkedListBowling(playerList);
		game.throwBall(player1, (short) 8);
		game.throwBall(player1, (short) 0);
		
		assertEquals(8, game.getPlayerScore(player1));
	}
	@Test
	public void testSpareScoreOnFirstFrame() {
		LinkedListBowling game = new LinkedListBowling(playerList);
		game.throwBall(player1, (short) 1);
		game.throwBall(player1, (short) 9);
		game.throwBall(player1, (short) 5);
		
		assertEquals(15, game.getPlayerScore(player1));
	}
	@Test
	public void testOneStrikeThanNothingNextFrame() {
		LinkedListBowling game = new LinkedListBowling(playerList);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 0);
		game.throwBall(player1, (short) 0);
		
		assertEquals(10, game.getPlayerScore(player1));
	}
	@Test
	public void testOneStrikeThan9NextFrame() {
		LinkedListBowling game = new LinkedListBowling(playerList);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 4);
		game.throwBall(player1, (short) 5);
		
		assertEquals(28, game.getPlayerScore(player1));
	}

	@Test
	public void testThreeStrikesInARow() {
		LinkedListBowling game = new LinkedListBowling(playerList);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		
		assertEquals(30, game.getPlayerScore(player1));
	}
	
	@Test
	public void testTwoStrikesThanNothingNextFrame() {
		LinkedListBowling game = new LinkedListBowling(playerList);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 1);
		game.throwBall(player1, (short) 2);
		
		assertEquals(21, game.getPlayerScore(player1,1));
		assertEquals(34, game.getPlayerScore(player1,2));
		assertEquals(37, game.getPlayerScore(player1,3));
		
		assertEquals(21+13+3, game.getPlayerScore(player1));
	}
	@Test
	public void testTwoStrikesThanSpare() {
		LinkedListBowling game = new LinkedListBowling(playerList);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 1);
		game.throwBall(player1, (short) 9);
		
		assertEquals(21, game.getPlayerScore(player1,1));
		assertEquals(41, game.getPlayerScore(player1,2));
		assertEquals(-1, game.getPlayerScore(player1,3));
		assertEquals(21+20, game.getPlayerScore(player1));
	}
	
	@Test
	public void testEightFramesOfStrike() {
		LinkedListBowling game = new LinkedListBowling(playerList);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		assertEquals(240, game.getPlayerScore(player1));
	}
	@Test
	public void testNineFramesOfStrike() {
		LinkedListBowling game = new LinkedListBowling(playerList);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10); 
		assertEquals(270, game.getPlayerScore(player1));
	}
	
	@Test
	public void testOnlyOneMissedPin() {
		LinkedListBowling game = new LinkedListBowling(playerList);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 9);
		
		assertEquals(299, game.getPlayerScore(player1));
	}
	@Test
	public void testSpareLastThrow() {
		LinkedListBowling game = new LinkedListBowling(playerList);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 9);
		game.throwBall(player1, (short) 1);
		
		assertEquals(289, game.getPlayerScore(player1));
	}
	
	@Test
	public void testPerfectGame() {
		LinkedListBowling game = new LinkedListBowling(playerList);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		game.throwBall(player1, (short) 10);
		
		assertEquals(300, game.getPlayerScore(player1));
	}
}
