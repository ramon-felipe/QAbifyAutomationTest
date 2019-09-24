package Enums;

public enum DefaultWaitTimes {
	waitTime(5);
	
	private int defaultWaitTime;
	
	private DefaultWaitTimes(int seconds) {
		defaultWaitTime = seconds;
	}
	
	public int getDefaultWaitTime() {
		return defaultWaitTime;
	}
}
