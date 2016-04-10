package com.crimsonobject.objects;

public class FrameList {

	private Frame head = new Frame(null,1);
	private Frame tail;
	private Frame currentFrame;

	public FrameList() {
		Frame prevFrame = head;
		for (short i = 1; i < 10; i++) {
			Frame nextFrame = new Frame(prevFrame,i+1);
			prevFrame.setNextFrame(nextFrame);
			prevFrame = nextFrame;
		}
		tail = prevFrame;
		setCurrentFrame(head);
	}

	public final Frame getFirstFrame() {
		return head;
	}
	public final Frame getLastFrame() {
		return tail;
	}

	public final Frame getCurrentFrame() {
		return currentFrame;
	}
	
	public final void setCurrentFrame(Frame currFrame){
		this.currentFrame = currFrame;
	}
	
	public final int getFrameScore(int frameNo){
		Frame frame = head;
		for(int i=1;i<frameNo;i++){
			frame = frame.getNextFrame();
		}
		return frame.getFrameScore();
	}
}
