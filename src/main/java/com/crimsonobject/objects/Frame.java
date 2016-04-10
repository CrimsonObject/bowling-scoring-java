package com.crimsonobject.objects;

public class Frame {

	private int frameNo;
	private Frame prevFrame;
	private Frame nextFrame;
	private short[] ballScores = new short[3];
	private short currentBallNo = -1;
	private short frameScore = -1;

	public Frame(Frame previousFrame, int i) {
		this.prevFrame = previousFrame;
		this.frameNo = i;
	}

	public Frame getPrevFrame() {
		return prevFrame;
	}

	public short[] getBallScores() {
		return ballScores;
	}

	public void recordThrow(short numOfPins) {
		currentBallNo++;
		if (currentBallNo < 3) {
			ballScores[currentBallNo] = numOfPins;
		}
		calc();
	}

	private void calc() {
		if (getPrevFrame() != null) {
			getPrevFrame().calc();
		}
		if (getFrameScore() == -1) {
			short myScore = (short) (getBallScores()[0] + getBallScores()[1]);
			if (isStrike()) {
				if (getNextFrame() == null) {
					// last frame get 2 bonus throws
					if (getCurrentBallNo() == 2) {
						myScore = (short) (myScore + getBallScores()[2]);
						setFrameScore((short) (myScore + getPrevFramesScore()));
					}
				} else if (getNextFrame().getCurrentBallNo() > -1) {
					if (getNextFrame().isStrike()) {
						if (getNextFrame().getNextFrame() == null) {
							if (getNextFrame().getCurrentBallNo() == 1) {
								myScore = (short) (myScore + getNextFrame().getBallScores()[0]
										+ getNextFrame().getBallScores()[1]);
								setFrameScore((short) (myScore + getPrevFramesScore()));
							}
						} else if (getNextFrame().getNextFrame().currentBallNo > -1) {
							myScore = (short) (myScore + getNextFrame().getNextFrame().getBallScores()[0]);
							myScore = (short) (myScore + getNextFrame().getBallScores()[0]);
							setFrameScore((short) (myScore + getPrevFramesScore()));
						}
					} else if (getNextFrame().getCurrentBallNo() == 1) {
						myScore = (short) (myScore + getNextFrame().getBallScores()[0]
								+ getNextFrame().getBallScores()[1]);
						setFrameScore((short) (myScore + getPrevFramesScore()));
					}
				}
			} else if (isSpare()) {
				if (getNextFrame().getCurrentBallNo() > -1) {
					myScore = (short) (myScore + getNextFrame().getBallScores()[0]);
					setFrameScore((short) (myScore + getPrevFramesScore()));
				}
			} else if (getCurrentBallNo() == 1) {
				setFrameScore((short) (myScore + getPrevFramesScore()));
			}
		}
	}

	public short getCurrentBallNo() {
		return currentBallNo;
	}

	public short getFrameScore() {
		return frameScore;
	}

	public void setFrameScore(short frameScore) {
		this.frameScore = frameScore;
	}

	public boolean isStrike() {
		return ballScores[0] == 10;
	}

	public boolean isSpare() {
		return ballScores[0] + ballScores[1] == 10;
	}

	public Frame getNextFrame() {
		return nextFrame;
	}

	public void setNextFrame(Frame nextFrame) {
		this.nextFrame = nextFrame;
	}

	public int getFrameNo() {
		return frameNo;
	}

	public int getPrevFramesScore() {
		if (getPrevFrame() != null && getPrevFrame().getFrameScore() != -1)
			return getPrevFrame().getFrameScore();
		else
			return 0;
	}

}
