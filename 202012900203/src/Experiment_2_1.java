public class Experiment_2_1 {
    public static void main(String[] args) {
        System.out.println("陈杰202012900203");
        Point3D p1=new Point3D(1.0,1.0,1.0);
        Point3D p2=new Point3D(2.0,2.0,2.0);
        double distance = p1.getDistance(p2);
        System.out.println("点p1到p2的距离为"+distance);
    }
}
class Point3D{
    double x;
    double y;
    double z;

    public Point3D(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    double getDistance(Point3D p){
        double a,b;
        a=Math.pow((x-p.x),2)+Math.pow((y-p.y),2)+Math.pow((z-p.z),2);
        b=Math.sqrt(a);
        return b;

    }
}