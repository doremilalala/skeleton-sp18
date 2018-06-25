public class Planet{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    
    
    public Planet(double xP, double yP, double xV,
    double yV, double mas, String img){
        xxPos = xP;
        yyPos = yP;
        xxVel = xV;
        yyVel = yV;
        mass = mas;
        imgFileName = img;
    }
    
    
    public Planet(Planet p){
        xxPos = p.xxPos;
        yyPos = p.yyPos;
        xxVel = p.xxVel;
        yyVel = p.yyVel;
        mass = p.mass;
        imgFileName = p.imgFileName;
    }
    
    
    public double calcDistance(Planet p){
        double x = p.xxPos - xxPos;
        double y = p.yyPos - yyPos;
        double xy = Math.pow(x,2) + Math.pow(y,2);
        double xyz = Math.pow(xy, 1.0/2);
        return xyz;
    }


    public double calcForceExertedBy(Planet p){
        double dist = calcDistance(p);
        return (p.mass * mass * 6.67e-11)/Math.pow(dist,2);
    }


    public double calcForceExertedByX(Planet p){
        double net = calcForceExertedBy(p);
        double dist = calcDistance(p);
        double x = p.xxPos - xxPos;
        return net*x/dist;
    }
    
    
    public double calcForceExertedByY(Planet p){
        double net = calcForceExertedBy(p);
        double dist = calcDistance(p);
        double y = p.yyPos - yyPos;
        return net*y/dist;
    }


    public double calcNetForceExertedByX(Planet[] p){
        double net = 0;
        for(int i=0;i<p.length;i++){
            if(p[i] == this) continue;
            net += calcForceExertedByX(p[i]);
        }
        return net;
    }
    
    
    public double calcNetForceExertedByY(Planet[] p){
        double net = 0;
        for(int i=0;i<p.length;i++){
            if(p[i] == this) continue;
            net += calcForceExertedByY(p[i]);
        }
        return net;
    }


    public void update(double dt, double fx, double fy){
        double ax = fx/mass;
        double ay = fy/mass;
        xxVel += ax * dt;
        yyVel += ay * dt;
        xxPos += xxVel * dt;
        yyPos += yyVel * dt;
    }

}  