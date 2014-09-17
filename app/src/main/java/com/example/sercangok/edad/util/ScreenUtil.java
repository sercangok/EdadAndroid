package com.example.sercangok.edad.util;

/**
 * Created by sercangok on 16/09/14.
 */
public class ScreenUtil {
    private float screenWidth;
    private float screenHeight;
    public float width;
    public float height;
    private static float widthforFullHd = 974.0f;
    private static float heightforHd = 306.0f;

    public ScreenUtil(int w, int h) {
        screenWidth = w;
        screenHeight = h;
        calculate();
    }

    public static ScreenUtil getInstance(int w, int h) {
        return new ScreenUtil(w, h);
    }

    public void calculate() {
        height = screenHeight / (1920.0f / widthforFullHd);
        width = screenWidth / (1080.0f / heightforHd);
    }
}
