package com.e2esp.bergerpaints.calculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.e2esp.bergerpaints.calculator.Model.Global_Class;
import com.e2esp.bergerpaints.calculator.R;

import java.math.BigDecimal;

public class Result extends AppCompatActivity {

    /*
    * Creat all Variables
    * */

    LinearLayout reset, back;
    TextView result, paint, area, lenght, width, cots, no_d_w, n_d_w, price, price_sqf, price_sqm, len;
    LinearLayout extra, widthe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

/*
* Call all function of calculation
* */
        Global_Class.Calculat();
        Global_Class.price_of_paint();
        Global_Class.price_of_s_f();
        Global_Class.price_of_s_m();

   /*
   * Get All Id of Xml Layout
   * */

        result = (TextView) findViewById(R.id.result);
        paint = (TextView) findViewById(R.id.paint_name);
        area = (TextView) findViewById(R.id.area_of);
        lenght = (TextView) findViewById(R.id.lenght);
        width = (TextView) findViewById(R.id.width);
        cots = (TextView) findViewById(R.id.Cots);
        len = (TextView) findViewById(R.id.textView5);
        no_d_w = (TextView) findViewById(R.id.w_d);
        n_d_w = (TextView) findViewById(R.id.n_d_w);
        price = (TextView) findViewById(R.id.price);
        price_sqf = (TextView) findViewById(R.id.price_s_q);
        price_sqm = (TextView) findViewById(R.id.price_s_m);
        extra = (LinearLayout) findViewById(R.id.extra);
        reset = (LinearLayout) findViewById(R.id.next_b);
        back = (LinearLayout) findViewById(R.id.back);
        widthe = (LinearLayout) findViewById(R.id.widthe);


        /*
        * Get & Set All Values of result
        * */
        String are = Global_Class.getArea();
        area.setText(are);
        paint.setText(Global_Class.getPaint().getName());
        lenght.setText(Global_Class.getLength());
        width.setText(Global_Class.getWidth());
        cots.setText(Global_Class.getCoats());
        no_d_w.setText(Global_Class.getWindow_door());
        BigDecimal bd = new BigDecimal(Global_Class.getPaint_price());
        price.setText("Rs: " + bd.toPlainString());

        /*
        * Show value by type of measurement
        * */

        if (Global_Class.getMeasurement_s().equals("0")) {

            if (Global_Class.getPaint().getName().equals("INTERIOR TEXTURE") || Global_Class.getPaint().getName().equals("SAND FINISH") || Global_Class.getPaint().getName().equals("EXTERIOR TEXTURE")) {
                price_sqf.setText(Html.fromHtml("Rs: " + Global_Class.getPaint_price_s_f() + "ft<sup>2</sup>/kg/Coat"));
            } else {
                price_sqf.setText(Html.fromHtml("Rs: " + Global_Class.getPaint_price_s_f() + "ft<sup>2</sup>/Ltr/Coat "));
            }


        } else {

            if (Global_Class.getPaint().getName().equals("INTERIOR TEXTURE") || Global_Class.getPaint().getName().equals("SAND FINISH") || Global_Class.getPaint().getName().equals("EXTERIOR TEXTURE")) {
                price_sqf.setText(Html.fromHtml("Rs: " + Global_Class.getPaint_price_s_m() + "m<sup>2</sup>/kg/Coat"));
            } else {
                price_sqf.setText(Html.fromHtml("Rs: " + Global_Class.getPaint_price_s_m() + "m<sup>2</sup>/Ltr/Coat"));
            }


        }

        /*
        *set VISIBILITY of Relevant Data
        * */
        if (Global_Class.total_area_working.equals("0")) {
            if (are.equals("Doors")) {
                extra.setVisibility(View.VISIBLE);
                n_d_w.setText("No. of Doors");
            } else if (are.equals("Windows")) {
                extra.setVisibility(View.VISIBLE);
                n_d_w.setText("No. of Windows");
            } else if (are.equals("Interior Walls")) {
                extra.setVisibility(View.VISIBLE);
                n_d_w.setText("Walls Sides");
            }
        } else {
            extra.setVisibility(View.GONE);
            widthe.setVisibility(View.GONE);
            len.setText("Total Area");
        }

        /*
        *set Value by types
        * */

        bd = new BigDecimal(Global_Class.getResult());
        if (Global_Class.getPaint().getName().equals("INTERIOR TEXTURE") || Global_Class.getPaint().getName().equals("SAND FINISH") || Global_Class.getPaint().getName().equals("EXTERIOR TEXTURE")) {
            result.setText(bd.toPlainString() + "Kg");
        } else {
            result.setText(bd.toPlainString() + "Liter(s)");
        }


     /*
     * reset button click event
     * */
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Global_Class.reset();
                startActivity(new Intent(getBaseContext(), MainActivity.class));
                finish();
            }
        });

     /*
     * Back button click event
     * */

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), Calculator.class));
                finish();
            }
        });
    }

}
