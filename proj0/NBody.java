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

		Planet[] p = NBody.readPlanets(filename);
		
		for(double t=0; t <= T; t = t+dt) {
			Double[] xForces = new Double[5];
			Double[] yForces = new Double[5];

			for(int i=0; i<5; i++) {
				xForces[i] = p[i].calcNetForceExertedByX(p);
				yForces[i] = p[i].calcNetForceExertedByY(p);
			}
			for(int i=0; i<5; i++) {
				p[i].update(dt, xForces[i], yForces[i]);
			}

			/**
			Draw the background of the universe
			Please set the scale to the radius of the universe
			Use the method readRadius() abve
			*/
			Double radius = NBody.readRadius(filename);
			StdDraw.setScale(0-radius, radius);
			StdDraw.clear();
			StdDraw.picture(0, 0, "/images/starfield.jpg");
			StdDraw.show();

			for(int i=0; i<5; i++) {
				//System.out.println(p[i].imgFileName);
				p[i].draw();
			}

			StdDraw.enableDoubleBuffering();
			StdDraw.pause(10);
		}		
	}
}