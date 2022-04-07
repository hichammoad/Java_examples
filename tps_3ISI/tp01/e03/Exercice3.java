package tps_3ISI.tp01.e03;

public class Exercice3 {
	public static void main(String[] args) {

		Point p1 = new Point(1, 1);
		Point p2 = new Point(1, 2);

		Point res = p1.maxNorme(p2);
		System.out.println(res.x + " " + res.y);

		// tableau des points:
		Point o = new Point(0, 0);
		Point p11 = new Point(1, 1);
		Point p12 = new Point(1, 2);
		Point p13 = new Point(1, 3);
		Point p21 = new Point(2, 1);
		Point p22 = new Point(2, 2);
		Point p23 = new Point(2, 3);

		// Point[] desPoints = new Point[10];
		Point[] desPoints = { o, p11, p12, p13, p21, p22, p23 };
		double shortestDistance = Integer.MAX_VALUE;
		for (int i = 0; i < desPoints.length; i++) {
			for (int j = i + 1; j < desPoints.length; j++) {
				double distance = desPoints[i].distance(desPoints[j]);
				shortestDistance = Math.min(distance, shortestDistance);
				// same as if(distance < shortestDistance) shortestDistance = distance;

			}
		}

		System.out.println("shortestDistance = " + shortestDistance);
	}
}
