/**
 * A header comment!
 */

package com.benjdd.robot;

import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;
import androidx.dynamicanimation.animation.SpringForce;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

/**
 * A comment for the class
 */
public class MainActivity extends AppCompatActivity {

    Random randomGenerator;
    SpringAnimation anim1X;
    SpringAnimation anim1Y;
    int xCoord = 0;
    int yCoord = 0;

    /**
     * This is oncreate yo
     * @param savedInstanceState
     */
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
    }

    /**
     * Something
     * @param v
     */
    public void startAnimation(View v) {
        anim1X.setStartValue(xCoord);
        anim1Y.setStartValue(yCoord);
        xCoord = randomGenerator.nextInt(750);
        yCoord = randomGenerator.nextInt(1240);
        anim1X.animateToFinalPosition(xCoord);
        anim1Y.animateToFinalPosition(yCoord);
    }

}
