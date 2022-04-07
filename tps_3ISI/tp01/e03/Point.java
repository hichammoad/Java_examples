package tps_3ISI.tp01.e03;

public class Point {
	public double x;
	public double y;

	public Point(int abs, int ord) {
		x = abs;
		y = ord;
	}

	public void affiche() {
		System.out.println("coordonnées : " + x + " " + y);
	}

	public Point maxNorme(Point p2) {
		double distance1 = Math.sqrt((Math.pow(p2.x, 2)) + (Math.pow(p2.y, 2)));
		double distance2 = Math.sqrt((Math.pow(this.x, 2)) + (Math.pow(this.y, 2)));
		if (distance1 < distance2) {
			return this;
		} else {
			return p2;
		}
	}

	public double distance(Point p2) {
		double distance = Math.sqrt((Math.pow(p2.x - this.x, 2)) + (Math.pow(p2.y - this.y, 2)));
		return distance;
	}

}
