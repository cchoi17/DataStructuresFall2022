import java.util.List;

public record Quaternion(double a,double b,double c,double d){
    public static final Quaternion ZERO = new Quaternion(0,0,0,0);
    public static final Quaternion I = new Quaternion (0,1,0,0);
    public static final Quaternion J = new Quaternion(0,0,1,0);
    public static final Quaternion K = new Quaternion (0,0,0,1);

    public Quaternion{
        if(Double.isNaN(a) || Double.isNaN(b) || Double.isNaN(c) || Double.isNaN(d)){
            throw new IllegalArgumentException("Fields cannot be NaN");
        }
    }

    Quaternion plus(Quaternion q){
        return new Quaternion(this.a+ q.a , this.b+ q.b, this.c+ q.c , this.d+ q.d);
    }
    Quaternion minus(Quaternion q){
        return new Quaternion(a- q.a , b- q.b , c- q.c , d- q.d);
    }
    Quaternion times(Quaternion q){
        return new Quaternion(
            (a*q.a - b*q.b - c*q.c - d*q.d),
            (a*q.b + b*q.a + c*q.d - d*q.c),
            (a*q.c - b*q.d +c*q.a + d*q.b),
            (a*q.d + b*q.c - c*q.b + d*q.a)
        );
    }
    double norm(){ 
        return Math.sqrt(a*a + b*b + c*c + d*d);
    }
    Quaternion normalized(){
        return new Quaternion (a/(this.norm()), b/norm(), c/norm(), d/norm());
    }
    Quaternion conjugate(){ //negated signs
        return new Quaternion (-a, -b, -c, -d);
    }
    Quaternion inverse()){
        return new Quaternion (
            (a/(q.a*q.a)), (b/(q.b*q.b)), (c/(q.c*q.c)), (d/(q.d*q.d))
        );
    }
    List<Double> coefficients(){
        return List.of(a,b,c,d);
    }


}
