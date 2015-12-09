package Day3;

public class Coordinat extends Object {
	private int x = 0;
	private int y = 0;
	
	public Coordinat() {
		
	}
	
	public Coordinat(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public Coordinat move(char c) {
		if (c == '^') {
			x++;
		}
		if (c == 'v') {
			x--;
		}
		if (c == '<') {
			y--;
		}
		if (c == '>') {
			y++;
		}
		
		return new Coordinat(x, y);
	}
	
	public String getPosition() {
		return x + "," + y;
	}
	
	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		Coordinat coordinat = (Coordinat) obj;
		return this.x == coordinat.x && this.y == coordinat.y;
	}
}
