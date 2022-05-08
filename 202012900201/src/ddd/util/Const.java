package ddd.util;

import java.awt.*;

public class Const {
    public static final int FRAME_W=500;
    public static final int FRAME_H=500;
    public static final int SCREEN_W = Toolkit.getDefaultToolkit().getScreenSize().width;
    public static final int SCREEN_H = Toolkit.getDefaultToolkit().getScreenSize().height;

    public static final int FRAME_X =(SCREEN_W - FRAME_W)/2;
    public static final int FRAME_Y =(SCREEN_H - FRAME_H)/2;//获取屏幕中心点

}
