public class mao {
    public static void main(String[] args) {
        cat XiaoLi=new cat(5);
        mouse xx=new mouse();
        xx.speed=3;
        XiaoLi.CatchMouse(xx);

    }
}
class cat{
    int speed;

    public cat(int speed) {
        this.speed = speed;
    }
    void CatchMouse(mouse m){
        if(speed>m.speed)
            System.out.println("抓到了");
        else
            System.out.println("抓不到");

    }
}
class mouse{
    int speed;



}
