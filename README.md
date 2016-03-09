# AnimaSampleAnimations
Android view wrapper for animating views with customizable animations

*With anima there's no longer a need to declare xml files.

*No need to create Animation objects for a specific animation i.e ScaleAnimation.

*All animation in one class.

*Just wrap your view and animate!

ex1:
new Anima(TextView).scale(arguments).rotate(arguments).moveIt(); - will scale and rotate the view based on the arguments.


ex2:
Anima animation = new Anima(ImageView).addAnimation(Anima.Type.PULSE);
animation.moveIt(Animation.INFINITE);    - predefined animation added using .addAnimation(<predefined animation>), also infinitely looping , arguments is number of times to repeat

sorry guide is still a mess.


Real Guide, to follow... =)
