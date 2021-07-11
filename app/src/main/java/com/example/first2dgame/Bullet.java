package com.example.first2dgame;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.widget.Button;

import static com.example.first2dgame.GameView.screenRatioX;
import static com.example.first2dgame.GameView.screenRatioY;

public class Bullet {

    public int x, y, width, height;
    Bitmap bullet;

    Bullet(Resources res){

        bullet = BitmapFactory.decodeResource(res, R.drawable.bullet);

        width = bullet.getWidth();
        height = bullet.getHeight();

        width /= 4;
        height /= 4;

        width = (int) (width * screenRatioX);
        height = (int) (height * screenRatioY);

        bullet = Bitmap.createScaledBitmap(bullet, width, height, false);
    }

    public Rect getCollisionShape() {
        return  new Rect(x, y, x + width, y + height);
    }
}
