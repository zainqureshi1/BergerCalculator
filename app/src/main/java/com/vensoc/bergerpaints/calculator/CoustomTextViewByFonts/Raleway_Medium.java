package com.vensoc.bergerpaints.calculator.CoustomTextViewByFonts;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by PAPPU on 12/29/2016.
 */
public class Raleway_Medium  extends TextView {


    public Raleway_Medium(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/Raleway-Medium.ttf"));

    }
}