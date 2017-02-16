package com.vensoc.bergerpaints.calculator;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vensoc.bergerpaints.calculator.Model.Global_Class;

public class MainActivity extends AppCompatActivity {

    Button button_celing, button_exterior_walls, button_interior_walls, button_doors, button_windows, button_wood_finishes;
    LinearLayout next;
    Typeface Font, Def;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        * Call Costume Code Function
        * */
        init(savedInstanceState);
    }

    /*
    * Costume Function
    * */
    private void init(Bundle bundle) {
    /*
    * Get Id OF The Xml Buttons
    * */
        next = (LinearLayout) findViewById(R.id.next_b);
        button_celing = (Button) findViewById(R.id.button_celing);
        button_exterior_walls = (Button) findViewById(R.id.button_exterior_walls);
        button_interior_walls = (Button) findViewById(R.id.button_interior_walls);
        button_doors = (Button) findViewById(R.id.button_doors);
        button_windows = (Button) findViewById(R.id.button_windows);
        button_wood_finishes = (Button) findViewById(R.id.wood_finishes);
    /*
    *Get and Set Font In Variable For Run Time Changes
    * */
        Font = Typeface.createFromAsset(getAssets(), "fonts/Raleway-SemiBold.ttf");
        Def = Typeface.createFromAsset(getAssets(), "fonts/Raleway-Light.ttf");
     /*
     * Set Click Events Of the All Button
     * */
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Paint_Select.extra_postion = -1;
                /*
                * Call Next Activity
                * */
                startActivity(new Intent(getBaseContext(), Paint_Select.class));
                finish();
            }
        });

        button_celing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /*
               * Call Function for Change Design
               * */
                setbackground(view, button_celing);
                /*
                * Save Area For Next Level Use
                * */
                Global_Class.setArea("Celing");
            }
        });
        button_exterior_walls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  /*
               * Call Function for Change Design
               * */
                setbackground(view, button_exterior_walls);
                  /*
                * Save Area For Next Level Use
                * */
                Global_Class.setArea("Exterior Walls");
            }
        });
        button_interior_walls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  /*
               * Call Function for Change Design
               * */
                setbackground(view, button_interior_walls);
                  /*
                * Save Area For Next Level Use
                * */
                Global_Class.setArea("Interior Walls");
            }
        });
        button_doors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  /*
               * Call Function for Change Design
               * */
                setbackground(view, button_doors);
                  /*
                * Save Area For Next Level Use
                * */
                Global_Class.setArea("Doors");
            }
        });
        button_windows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  /*
               * Call Function for Change Design
               * */
                setbackground(view, button_windows);
                  /*
                * Save Area For Next Level Use
                * */
                Global_Class.setArea("Windows");
            }
        });
        button_wood_finishes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                  /*
               * Call Function for Change Design
               * */
                setbackground(view, button_wood_finishes);
                  /*
                * Save Area For Next Level Use
                * */
                Global_Class.setArea("Wood finishes");
            }
        });
    }

    /*
    * Function Change The Run Time Color And Font Style
    * */
    private void setbackground(View view, TextView tv) {
/**
 * Default Setting Apply
 */
        set_button_def();
/*
* Change The Color and Font of Selected Button
* */
        view.setBackgroundResource(R.drawable.select_button_shape);
        tv.setTypeface(Font);


        next.setVisibility(View.VISIBLE);
        Animation set = AnimationUtils.loadAnimation(MainActivity.this, R.anim.slide_in);
        next.startAnimation(set);

    }

    /*
    * Set The Run Time Color And Font Style By Default
   * */
    private void set_button_def() {
/*
* Set Default  Back Ground Color of Button
* */
        button_celing.setBackgroundResource(R.drawable.button_shape);
        button_exterior_walls.setBackgroundResource(R.drawable.button_shape);
        button_interior_walls.setBackgroundResource(R.drawable.button_shape);
        button_doors.setBackgroundResource(R.drawable.button_shape);
        button_windows.setBackgroundResource(R.drawable.button_shape);
        button_wood_finishes.setBackgroundResource(R.drawable.button_shape);
        //  next.setVisibility(View.INVISIBLE);
/*
* Set Default  Fonts of Button
* */
        button_celing.setTypeface(Def);
        button_exterior_walls.setTypeface(Def);
        button_interior_walls.setTypeface(Def);
        button_doors.setTypeface(Def);
        button_windows.setTypeface(Def);
        button_wood_finishes.setTypeface(Def);


    }
}
