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
public class SampleRotate extends Activity {

    TextView txtMessage;
    Button btnStart;
    Anima buttonAnim;
    boolean alternate = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_layout);
        txtMessage = (TextView) findViewById(R.id.txtMessage);
        btnStart = (Button) findViewById(R.id.btnStart);


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
                        if(alternate) {
                            new Anima(txtMessage).addAnimation(Anima.Type.ROTATE, 1).moveIt();
                            alternate = false;
                            txtMessage.setText("Now Counter-clockwise!");
                        }else{
                            new Anima(txtMessage).addAnimation(Anima.Type.ROTATE, -1).moveIt();
                            txtMessage.setText("Now Clockwise!");
                            alternate = true;
                        }
                    default:
                        break;
                }
                return true;
            }
        });




    }

}
