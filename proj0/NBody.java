public class NBody {
	public static double readRadius(String path) {
		In in = new In(path);
		int num = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public static double[] readPlanets(String path) {
		In in = new In(path);
	}

	public static void main(String[] args) {
		Double ra = NBody.readRadius("/data/planets.txt");
		System.out.println(ra);
	}
}