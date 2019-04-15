public class NBody {
	public static double readRadius(String path) {
		In in = new In(path);
		int num = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	/**
	We use Planet[] as the return value.
	Each element of the array is a Planet object. 
	Each object has six variables which are exactly in the file.
	We can use the constructor of Planet.
	*/

	public static Planet[] readPlanets(String path) {
		In in = new In(path);
		int num = in.readInt();
		double radius = in.readDouble();
		Planet[] planets = new Planet[5];
		for(int i=0; i<5; i++) {
			Double xxPos = in.readDouble();
			Double yyPos = in.readDouble();
			Double xxVel = in.readDouble();
			Double yyVel = in.readDouble();
			Double mass = in.readDouble();
			String imgFileName = in.readString();
			planets[i] = new Planet(xxPos, yyPos, xxVel, 
				yyVel, mass, imgFileName);
		}
		return planets;		
	}

	public static void main(String[] args) {
		Double T = Double.parseDouble(args[0]);
		Double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		//System.out.println(T);
		//System.out.println(filename);

		//Please set the scale to the radius of the universe
		Double radius = NBody.readRadius(filename);
		StdDraw.setScale(0-radius, radius);
		StdDraw.clear();
		StdDraw.picture(0, 0, "/images/starfield.jpg");
		StdDraw.show();

		Planet[] p = NBody.readPlanets(filename);
		for(int i=0; i<5; i++) {
			System.out.println(p[i].imgFileName);
			p[i].draw();
		}		
	}
}