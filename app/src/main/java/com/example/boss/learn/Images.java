package com.example.boss.learn;

import android.widget.Toast;

public class Images {
    private int image1,image2;
    public Images() {
    }

    public Images(int title1,int title2) {
        System.out.println(title1);
        System.out.println(title2);
        this.image1 = title1;this.image2 = title2;
    }

    public int getImage1() {
        return image1;
    }
    public int getImage2() {
        return image2;
    }

    public void setImage1(int name) {
        this.image1 = name;
    }
    public void setImage2(int name) {
        this.image2 = name;
    }

}
