package com.crimsonobject.game;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.crimsonobject.objects.Frame;
import com.crimsonobject.objects.FrameList;
import com.crimsonobject.objects.Player;

public class LinkedListBowling {

	private Map<Player, FrameList> playerMap = new HashMap<Player, FrameList>();

	public LinkedListBowling(List<Player> players) {
		// create frame list for each player
		for (Player player : players) {
			playerMap.put(player, new FrameList());
		}
	}

	public void throwBall(Player player, short numOfPins) {
		FrameList frameList = playerMap.get(player);
		Frame currentFrame = frameList.getCurrentFrame();
		currentFrame.recordThrow(numOfPins);
		
		advanceFrame(frameList);
	}

	private void advanceFrame( FrameList frameList) {
		Frame currentFrame = frameList.getCurrentFrame();
		if (currentFrame.getNextFrame()==null)
			return;
		if (currentFrame.isSpare() || currentFrame.isStrike() || currentFrame.getCurrentBallNo() == 1) {
			frameList.setCurrentFrame(currentFrame.getNextFrame());
		}
	}

	public int getPlayerScore(Player player1, int i) {
		return playerMap.get(player1).getFrameScore(i);
	}

	public int getPlayerScore(Player player1) {
		int total = 0;
		total = tally(playerMap.get(player1).getFirstFrame(), total);
		return total;
	}

	private int tally(Frame frame, int tally) {
		
		if (frame.getFrameScore() == -1) {
			
			return frame.getPrevFrame().getFrameScore();
		}
		else if ( frame.getNextFrame()==null){
			return frame.getFrameScore();
		}
		else {
			return tally(frame.getNextFrame(), tally);
		}
	}
	/*
	 * private int tally(Frame frame, int tally){ if ( frame.getFrameScore()
	 * ==-1 ){ return tally; } else if ( frame.getNextFrame()==null ){ return
	 * tally + frame.getFrameScore(); } else return tally(frame.getNextFrame(),
	 * frame.getFrameScore()+tally); }
	 */

}
