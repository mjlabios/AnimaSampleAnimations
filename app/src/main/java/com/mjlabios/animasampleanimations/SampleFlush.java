package com.mjlabios.animasampleanimations;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mjlabios.anima.Anima;

/**
 * Created by mark.labios on 2/12/2016.
 */
public class SampleFlush extends Activity {

    TextView txtMessage;
    Button btnStart;
    Anima buttonAnim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_layout);
        txtMessage = (TextView) findViewById(R.id.txtMessage);
        btnStart = (Button) findViewById(R.id.btnStart);

        txtMessage.setText("Flush This");

        btnStart.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        buttonAnim = new Anima(btnStart, Anima.Type.BUTTON_PRESS);
                        buttonAnim.moveIt();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        break;
                    case MotionEvent.ACTION_UP:
                        //stop animation of button press
                        buttonAnim.stopIt();
                        //text animation
                        new Anima(txtMessage).scale(0.8,0.8,1,0).translate(0.2,-0.8,1,0).rotate(0,-180,1,0).scale(0.1,0.1,1,0.5).translate(0.2,0.8,1,0.5).alpha(100,0,0.75,0.5).rotate(0,-180,1,0.5).moveIt();

                    default:
                        break;
                }
                return true;
            }
        });


    }

}
