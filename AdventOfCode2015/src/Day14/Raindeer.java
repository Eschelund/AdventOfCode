package Day14;

public class Raindeer {

	private String name;
	private int speed;
	private int duration;
	private int recharge;
	private int points;
	private int range;
	
	public Raindeer(String name, int speed, int duration, int recharge) {
		this.name = name;
		this.speed = speed;
		this.duration = duration;
		this.recharge = recharge;
		this.points = 0;
		this.range = 0;
	}

	public String name() {
		return this.name;
	}
	
	public int calculateRange(int traveltime) {
		int timeLeft = traveltime;
		int range = 0;
		while(timeLeft > 0) {
			if (timeLeft > duration) {
				range += speed * duration;
				timeLeft -= duration;
			} else {
				range += speed * timeLeft;
				timeLeft = 0;
			}
			if (timeLeft > recharge) {
				timeLeft -= recharge;
			} else {
				timeLeft = 0;
			}
		}
		this.range = range;
		return range;
	}
	
	public int getRange() {
		return this.range;
	}
	
	public void addPoint() {
		points++;
	}
	
	public int getPoints() {
		return this.points;
	}
}
