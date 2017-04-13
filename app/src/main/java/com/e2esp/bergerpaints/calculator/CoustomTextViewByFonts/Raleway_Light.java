package com.e2esp.bergerpaints.calculator.CoustomTextViewByFonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by PAPPU on 12/29/2016.
 */

public  class Raleway_Light extends TextView {


    public Raleway_Light(Context context,AttributeSet attrs){
        super(context,attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Raleway-Light.ttf"));

    }

}