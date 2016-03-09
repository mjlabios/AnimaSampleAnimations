package com.mjlabios.animasampleanimations;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by mark.labios on 3/9/2016.
 */
public class MainActivity extends Activity {
    Button flushAnimation,pulseAnimation,rotateAnimation,shakeAnimation,fadeInAnimation,fadeOutAnimation;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        flushAnimation = (Button) findViewById(R.id.Flush);
        pulseAnimation = (Button) findViewById(R.id.Pulse);
        rotateAnimation = (Button) findViewById(R.id.Rotate);
        shakeAnimation = (Button) findViewById(R.id.Shake);
        fadeInAnimation = (Button)findViewById(R.id.FadeIn);
        fadeOutAnimation = (Button) findViewById(R.id.FadeOut);

        flushAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),SampleFlush.class));
            }
        });

        pulseAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),SamplePulse.class));
            }
        });

        rotateAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),SampleRotate.class));
            }
        });

        shakeAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),SampleShake.class));
            }
        });

        fadeInAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),SampleFadeIn.class));
            }
        });

        fadeOutAnimation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getBaseContext(),SampleFadeOut.class));
            }
        });








    }
}
