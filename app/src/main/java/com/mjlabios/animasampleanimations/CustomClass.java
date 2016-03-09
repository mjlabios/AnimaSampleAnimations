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
public class CustomClass extends Activity {

    TextView txtMessage;
    Button btnStart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_layout);
        txtMessage = (TextView) findViewById(R.id.txtMessage);
        btnStart = (Button) findViewById(R.id.btnStart);

        if(savedInstanceState!=null){
   //         Toast.makeText(this,savedInstanceState.getString("text") +" new state",Toast.LENGTH_SHORT).show();
      //      txtMessage.setText(savedInstanceState.getString("text"));
        }

//        new Anima(btnStart,Anima.PULSATING_MODE,10).moveIt(Animation.INFINITE);
        // button click event
        btnStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                //   txtMessage.setText("im changing this");
                //  new Anima(btnStart,getBaseContext()).scale(1.1,1.1,0.2,0).scale(0.9,0.9,0.2,0.2).moveIt();
               //     new Anima(btnStart).scale(1.1,1.1,0,0).moveIt(Animation.INFINITE);
                //txtMessage.setText("moved");
                //  Toast.makeText(getBaseContext(),txtMessage.getText().toString(),Toast.LENGTH_SHORT).show();

            }
        });

        btnStart.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {

                return false;
            }
        });


        btnStart.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        new Anima(btnStart, Anima.Type.BUTTON_PRESS).moveIt();

                        break;
                    case MotionEvent.ACTION_MOVE:
                        break;
                    case MotionEvent.ACTION_UP:
                        new Anima(btnStart).stopIt();
                        new Anima(txtMessage).scale(0.8,0.8,1,0).translate(0.2,-0.8,1,0).rotate(0,-180,1,0).scale(0.1,0.1,1,0.5).translate(0.2,0.8,1,0.5).alpha(100,0,0.75,0.5).rotate(0,-180,1,0.5).moveIt();
                      //  new Anima(mickey).scale(0.8,0.8,1,0).translate(0.2,-0.8,1,0).rotate(0,-180,1,0).scale(0.1,0.1,1,0.5).translate(0.2,0.8,1,0.5).alpha(100,0,0.75,0.5).rotate(0,-180,1,0.5).moveIt();

                        //   txtMessage.setText("change this text");
                       // new Anima(txtMessage, Anima.Type.PULSATING,10).addAnimation(Anima.Type.ROTATING, 10).alpha(100,0,1,0).moveIt();
                        break;
                    default:
                        break;
                }
                return true;
            }
        });


    }



    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    //    outState.putString("text", txtMessage.getText().toString());
   //     Log.d("Anima", outState.get("text").toString());
    }
}
