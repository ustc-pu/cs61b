public class Planet{
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	public Planet(double xP, double yP, double xV,
		double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet b) {
		xxPos = b.xxPos;
		yyPos = b.yyPos;
		xxVel = b.xxVel;
		yyVel = b.yyVel;
		mass = b.mass;
		imgFileName = b.imgFileName;
	}

	public double calcDistance(Planet p) {
		double dx = 0.0;
		double dy = 0.0;
		dx = this.xxPos - p.xxPos;
		dy = this.yyPos - p.yyPos;
		return Math.sqrt(dx*dx + dy*dy);
	}

	public double calcForceExertedBy(Planet p) {
		double G = 6.67e-11;
		double dist = this.calcDistance(p);
		return G*this.mass*p.mass/(dist*dist);
	}

	public double calcForceExertedByX(Planet p) {
		double f = this.calcForceExertedBy(p);
		double dist = this.calcDistance(p);
		double xFactor = (p.xxPos - this.xxPos) / dist;
		return f * xFactor;
	}

	public double calcForceExertedByY(Planet p) {
		double f = this.calcForceExertedBy(p);
		double dist = this.calcDistance(p);
		double yFactor = (p.yyPos - this. yyPos) / dist;
		return f * yFactor;
	}

	public void update(double dt, double fX, double fY) {
		double xAcc = fX / this.mass;
		//System.out.println(xAcc);
		double yAcc = fY / this.mass;
		xxVel = this.xxVel + xAcc * dt;
		//System.out.println(xxVel);
		yyVel = this.yyVel + yAcc * dt;
		xxPos = this.xxPos + xxVel * dt;
		yyPos = this.yyPos + yyVel * dt;
	}

	public void draw() {
		//StdDraw.clear();
		StdDraw.picture(this.xxPos, this.yyPos, "/images/"+this.imgFileName);
		StdDraw.show();
	}
}