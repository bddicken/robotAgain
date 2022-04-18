package com.benjdd.robot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random randomGenerator;
    SpringAnimation anim1X;
    SpringAnimation anim1Y;
    int xCoord = 0;
    int yCoord = 0;

    Random randomGenerator2;
    SpringAnimation anim1X2;
    SpringAnimation anim1Y2;
    int xCoord2 = 0;
    int yCoord2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iv = findViewById(R.id.orange_robot);
        randomGenerator = new Random();
        anim1X = new SpringAnimation(iv, DynamicAnimation.X);
        anim1Y = new SpringAnimation(iv, DynamicAnimation.Y);
        SpringForce forceY = new SpringForce();
        forceY.setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY).setStiffness(SpringForce.STIFFNESS_LOW);
        SpringForce forceX = new SpringForce();
        forceX.setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY).setStiffness(SpringForce.STIFFNESS_LOW);
        anim1Y.setSpring(forceY);
        anim1X.setSpring(forceX);

        ImageView iv2 = findViewById(R.id.robot);
        randomGenerator2 = new Random();
        anim1X2 = new SpringAnimation(iv2, DynamicAnimation.X);
        anim1Y2 = new SpringAnimation(iv2, DynamicAnimation.Y);
        SpringForce forceY2 = new SpringForce();
        forceY2.setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY).setStiffness(SpringForce.STIFFNESS_LOW);
        SpringForce forceX2 = new SpringForce();
        forceX2.setDampingRatio(SpringForce.DAMPING_RATIO_HIGH_BOUNCY).setStiffness(SpringForce.STIFFNESS_LOW);
        anim1Y2.setSpring(forceY2);
        anim1X2.setSpring(forceX2);
    }

    public void startAnimation(View v) {
        anim1X.setStartValue(xCoord);
        anim1Y.setStartValue(yCoord);
        xCoord = randomGenerator.nextInt(750);
        yCoord = randomGenerator.nextInt(1240);
        anim1X.animateToFinalPosition(xCoord);
        anim1Y.animateToFinalPosition(yCoord);

        anim1X2.setStartValue(xCoord2);
        anim1Y2.setStartValue(yCoord2);
        xCoord2 = randomGenerator2.nextInt(750);
        yCoord2 = randomGenerator2.nextInt(1240);
        anim1X2.animateToFinalPosition(xCoord2);
        anim1Y2.animateToFinalPosition(yCoord2);
    }

}
