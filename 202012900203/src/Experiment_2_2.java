public class Experiment_2_2 {
    public static void main(String[] args) {
        System.out.println("陈杰202012900203");
        Square xiaoZ=new Square(15.0);
        double area= xiaoZ.getArea();
        System.out.println("这个正方形的面积为"+area);

    }
}
class Square{
    double length;

    public Square(double length) {
        this.length = length;
    }
    double getArea(){
        double area;
        area=Math.pow(length,2);
        return area;
    }
}