package com.e2esp.bergerpaints.calculator.CoustomButtonByFont;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by PAPPU on 12/29/2016.
 */

public  class Raleway_Light extends Button {


    public Raleway_Light(Context context,AttributeSet attrs){
        super(context,attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Raleway-Light.ttf"));

    }

}