# Anima

Android view wrapper for animating views with customizable animations.

Anima is an open source android view wrapper for Native Android views such as TextView, ImageView, Button and so on.  With Anima you can now animate views with 1 line of code:

* **No More XML** - XML declaration will no longer be needed for instantiating animation objects.
* **No More Animation Object Declaration** - You no longer need to declare animation objects such as ScaleAnimation for scaling, AlphaAnimation for opacity and so forth, Just wrap your view and animate!
* **All Animation in one Class** - Anima supports all Animation classes in android, combine different animations in one line.
* **Predefined Animations** - Anima includes predefined animations such as Button press animations, pulsating animations, fading animations and so on, but the real power of Anima lies in combining and customizing your own animations.

## Install
* Just Download the Anima Module and place in your android project as module similar heirarchy as above. 
* Include this "compile project(':anima')" in your build.gradle (Module:app) file dependencies.
* Build and Run.
  
## Getting Started
* Include this snippet at the beginning of your code:

```java
   import com.mjlabios.anima.Anima;
```

## Examples
*All examples assume you have already imported Anima in your class and have working knowledge of android lifecycle*

Creating an Anima Object:
```java
Anima a = new Anima(txtMessage);
```

Moving the Anima Object:

```java
a.scale(0.8,0.8,1,0).moveIt(); 
// 1st parameter scales its object 0.8 in width
//, 2nd parameter scales its object 0.8 in height
//, 3rd parameter declares animation time - in this example animation will run for 1 sec(the longer the time the slower the animation), 
//4th parameter declares how long before the animation starts in this case 1 sec (used for chaining animations)
//.moveIt() - commences the animation, can take int parameter as number of times to repeat animation, or Animation.INFINITE, for looping indefinitely.
```

Predefined Pulse Animation with included button press (for the complete example download this github repo):

```java
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
                        new Anima(txtMessage).addAnimation(Anima.Type.PULSE).moveIt(Animation.INFINITE);

                    default:
                        break;
                }
                return true;
            }
        });


    }
```

Customized Flush Animation with included button press (for the complete example download this github repo):

```java
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
```

## Author's Notes
*The best way to learn is to take a look at the Anima Class Source code itself, I will add more examples in the future. For the mean time, here's a cat =)*


-![alt text](http://i.imgur.com/WWLYo.gif "Frustrated cat can't believe this is the 12th time he's clicked on an auto-linked README.md URL")
