package com.vensoc.bergerpaints.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vensoc.bergerpaints.calculator.Model.Global_Class;

public class Paint_Select extends AppCompatActivity {

    GridView paint_grid;
    public static int extra_postion = -1;
    LinearLayout next, back;
    CustomGridViewAdapter customGridAdapter;
    TextView paint_name;
    String Area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint__select);
/*
*
*Get All id of the Xml layout
* */
        paint_grid = (GridView) findViewById(R.id.paint_gridview);
        next = (LinearLayout) findViewById(R.id.next_b);
        back = (LinearLayout) findViewById(R.id.back);
        paint_name = (TextView) findViewById(R.id.paint_name);

        init();
    }

    private void init() {

/*
*
*  Creat The Paint List
*
* */
        Global_Class.paint_list();

/*
*
* Set paint by area type
* */
        Area = Global_Class.getArea();
        if (Area.equals("Celing") || Area.equals("Interior Walls")) {
            customGridAdapter = new CustomGridViewAdapter(this, Global_Class.paint_Image_arry);
        } else if (Area.equals("Exterior Walls")) {
            customGridAdapter = new CustomGridViewAdapter(this, Global_Class.exterior);
        } else if (Area.equals("Doors") || Area.equals("Windows")) {
            customGridAdapter = new CustomGridViewAdapter(this, Global_Class.doors_and_windows);
        } else if (Area.equals("Wood finishes")) {
            customGridAdapter = new CustomGridViewAdapter(this, Global_Class.wood_finishes);
        }

        paint_grid.setAdapter(customGridAdapter);

/*
*
* Click Events of All Buttons
* */

        paint_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // TODO Auto-generated method stub

                Paint_Select.extra_postion = position;
                paint_grid.setAdapter(customGridAdapter);

                paint_grid.setSelection(position);
                if (Area.equals("Celing") || Area.equals("Interior Walls")) {
                    Global_Class.setPaint(Global_Class.paint_Image_arry[position]);
                } else if (Area.equals("Exterior Walls")) {
                    Global_Class.setPaint(Global_Class.exterior[position]);
                } else if (Area.equals("Doors") || Area.equals("Windows")) {
                    Global_Class.setPaint(Global_Class.doors_and_windows[position]);
                } else if (Area.equals("Wood finishes")) {
                    Global_Class.setPaint(Global_Class.wood_finishes[position]);
                }
                paint_name.setText(Global_Class.getPaint().getName());
                next.setVisibility(View.VISIBLE);
                Animation set = AnimationUtils.loadAnimation(Paint_Select.this, R.anim.slide_in);
                next.startAnimation(set);
            }
        });


        /**
         * next Button call Event
         */


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), Calculator.class));
                finish();
            }
        });

        /**
         * Back Button call Event
         */
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), MainActivity.class));
                finish();
            }
        });

    }
}
