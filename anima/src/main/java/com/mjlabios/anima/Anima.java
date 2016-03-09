
/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 mark.labios
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package com.mjlabios.anima;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;


/**
 * Created by mark.labios on 2/12/2016.
 */

public class Anima {

    private View v;

    private AlphaAnimation alphaAnimation;
    private RotateAnimation rotateAnimation;
    private ScaleAnimation scaleAnimation;
    private TranslateAnimation translateAnimation;

    private AnimationSet procedure;

    public enum Type {
        PULSE,ROTATE,SHAKE,BUTTON_PRESS,FLUSH,FADE_OUT,FADE_IN;
    }

    public Anima(View v){
        this.v = v;
        procedure = new AnimationSet(true);
    }

    public Anima(View v,Type type){
        this(v);
        addAnimation(type);
    }

    public Anima(View v,Type type,double Intensity){
        this(v);
        addAnimation(type, Intensity);
    }

    public Anima addAnimation(Type type){
       return addAnimation(type, 0);
    }

    public Anima addAnimation(Type type,double Intensity){
        double intsty = Math.abs(Intensity);
        switch(type){

            case PULSE:
                this.scale(1.00, 1.00, 0.15, 0).scale(0.99 - (intsty / 100), 0.99 - (intsty / 100), 0.15, 0).scale(1.01+(intsty/100), 1.01+(intsty/100),0.15,0.25).scale(1.00, 1.00, 0.15, 0.30);
                break;

            case ROTATE:
                if(Intensity > 0) {
                    this.rotate(0, 360, 1-(intsty/100), 0);
                }else{
                    this.rotate(0, -360, 1-(intsty/100), 0);
                }
                break;

            case SHAKE:
                this.translate(0.025+(intsty/100),0,0.25,0).translate(-0.05-(intsty/100),0,0.15,0.25).translate(-0.025-(intsty/100),0,0.15,0.35).translate(0.05+(intsty/100),0,0.25,0.4);
                break;

            case BUTTON_PRESS:
                this.scale(1.1, 1.1, 0, 0);
                break;

            case FADE_OUT:
                this.alpha(100,0,1-(intsty/100),0);
                break;

            case FADE_IN:
                this.alpha(0,100,1-(intsty/100),0);
                break;

            case FLUSH:
                this.scale(0.8,0.8,1,0).translate(0.2,-0.8,1,0).rotate(0,-180,1,0).scale(0.1,0.1,1,0.5).translate(0.2,0.8,1,0.5).alpha(100,0,0.75,0.5).rotate(0,-180,1,0.5);
                break;

            default:
                break;
        }
        return this;
    }

    public Anima scale(double Width, double Height,double AnimationTime, double BeforeAnimation){
        return scale( Width,  Height, AnimationTime,  BeforeAnimation, null);
    }

    public Anima scale(double Width, double Height,double AnimationTime, double BeforeAnimation, Animation.AnimationListener animationListener){
        scaleAnimation = new ScaleAnimation(1,(float)Width,1,(float)Height,ScaleAnimation.RELATIVE_TO_SELF,0.5f,ScaleAnimation.RELATIVE_TO_SELF,0.5f);
        scaleAnimation.setFillAfter(true);
        scaleAnimation.setDuration((long) (AnimationTime * 1000));
        scaleAnimation.setStartOffset((long) (BeforeAnimation * 1000));
        if(animationListener!=null){
            scaleAnimation.setAnimationListener(animationListener);
        }
        procedure.addAnimation(scaleAnimation);
        return this;
    }

    public Anima translate(double Horizontal, double Vertical,double AnimationTime, double BeforeAnimation){
        return translate(Horizontal, Vertical, AnimationTime, BeforeAnimation, null);
    }

    public Anima translate(double Horizontal,double Vertical,double AnimationTime,double BeforeAnimation,  Animation.AnimationListener animationListener){
        translateAnimation = new TranslateAnimation(TranslateAnimation.RELATIVE_TO_SELF,0,TranslateAnimation.RELATIVE_TO_SELF,(float)Horizontal,TranslateAnimation.RELATIVE_TO_SELF,0,TranslateAnimation.RELATIVE_TO_SELF,(float)Vertical);
        translateAnimation.setFillAfter(true);
        translateAnimation.setDuration((long) (AnimationTime * 1000));
        translateAnimation.setStartOffset((long) (BeforeAnimation * 1000));
        if(animationListener!=null){
            translateAnimation.setAnimationListener(animationListener);
        }
        procedure.addAnimation(translateAnimation);
        return this;
    }

    public Anima alpha(double OpacityStart , double OpacityEnd ,double AnimationTime,double BeforeAnimation){
       return alpha(OpacityStart , OpacityEnd ,AnimationTime,BeforeAnimation, null);
    }

    public Anima alpha(double OpacityStart , double OpacityEnd ,double AnimationTime,double BeforeAnimation, Animation.AnimationListener animationListener){
        alphaAnimation = new AlphaAnimation((float)OpacityStart/100f,(float)OpacityEnd/100f);
        alphaAnimation.setFillAfter(true);
        alphaAnimation.setDuration((long) (AnimationTime * 1000));
        alphaAnimation.setStartOffset((long) (BeforeAnimation * 1000));
        if(animationListener!=null){
            alphaAnimation.setAnimationListener(animationListener);
        }
        procedure.addAnimation(alphaAnimation);
        return this;
    }

    public Anima rotate(int RotationStart , int RotationEnd,double AnimationTime,double BeforeAnimation){
       return rotate( RotationStart ,  RotationEnd, AnimationTime, BeforeAnimation, null);
    }

    public Anima rotate(int RotationStart , int RotationEnd,double AnimationTime,double BeforeAnimation, Animation.AnimationListener animationListener){
        rotateAnimation = new RotateAnimation(RotationStart,RotationEnd, Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setFillAfter(true);
        rotateAnimation.setDuration((long) (AnimationTime * 1000));
        rotateAnimation.setStartOffset((long) (BeforeAnimation * 1000));
        if(animationListener!=null){
            rotateAnimation.setAnimationListener(animationListener);
        }
        procedure.addAnimation(rotateAnimation);
        return this;
    }


    public Anima visibility(String visibility){
        switch (visibility){

            case "gone":
                v.setVisibility(View.GONE);
                break;

            case "visible":
                v.setVisibility(View.VISIBLE);
                break;

            case "invisible":
                v.setVisibility(View.VISIBLE);
                break;
            default:
                break;
        }
        return this;
    }

    public void moveIt(){
        moveIt(0);
    }


    public void moveIt(final int Repeat){

        procedure.setFillAfter(true);

        /**This is a workaround for repeating AnimationSet Classes, as AnimationSet (Animation Set) does not work according to documentation. Several Animation attributes have no effect while some work only in code and not in XML.
           This bug is already reported in Issue 17662 here: https://code.google.com/p/android/issues/detail?id=17662.**/

        procedure.setAnimationListener(new Animation.AnimationListener() {
            private int RepeatCounter = 0;
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if(RepeatCounter!=Repeat) {
                    v.startAnimation(procedure);
                    RepeatCounter++;
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        /**Workaround seems to be working without any visual glitches or animation afterimage residues.**/

        v.startAnimation(procedure);
    }


    public void stopIt(){
        v.clearAnimation();
    }


}

