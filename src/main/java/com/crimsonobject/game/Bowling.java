package com.crimsonobject.game;

import com.crimsonobject.objects.Player;

public interface Bowling {
	public void throwBall(Player player, short numOfPins);

	public int getPlayerScore(Player player);

	public int getPlayerScore(Player player, int i);
}
