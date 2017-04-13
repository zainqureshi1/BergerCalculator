package com.e2esp.bergerpaints.calculator.CoustomButtonByFont;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by PAPPU on 12/29/2016.
 */
public class Raleway_Bold extends Button {


    public Raleway_Bold(Context context,AttributeSet attrs){
        super(context,attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Raleway-Bold.ttf"));

    }

}