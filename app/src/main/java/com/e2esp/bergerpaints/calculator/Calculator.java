package com.e2esp.bergerpaints.calculator;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputFilter;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.e2esp.bergerpaints.calculator.Model.Global_Class;
import com.e2esp.bergerpaints.calculator.R;

public class Calculator extends AppCompatActivity {


    /*
    * All Variables
    * */
    Button calculate;
    LinearLayout back, reset;
    TextView paint, area, n_d_w, recommended_coats, len_label;
    EditText lenth, width;
    String cots = "1", wind_door = "1", are = "";
    LinearLayout extra, widthe;
    Spinner sp_coats, sp_w_d, meter;
    ArrayAdapter<String> coats, meters;
    String[] apiner_arr = {"1", "2", "3", "4", "5"};
    RadioGroup radioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);
/*
* Get All Id Of Xml Layout
* */
        calculate = (Button) findViewById(R.id.button_calculate);
        back = (LinearLayout) findViewById(R.id.back);
        reset = (LinearLayout) findViewById(R.id.next_b);
        paint = (TextView) findViewById(R.id.paint_name);
        recommended_coats = (TextView) findViewById(R.id.recomend_cots);
        area = (TextView) findViewById(R.id.area_of);
        len_label = (TextView) findViewById(R.id.textView6);
        n_d_w = (TextView) findViewById(R.id.w_d_no);
        lenth = (EditText) findViewById(R.id.length);
        width = (EditText) findViewById(R.id.width);
        sp_w_d = (Spinner) findViewById(R.id.spinner_d_w);
        sp_coats = (Spinner) findViewById(R.id.spinner_coats);
        meter = (Spinner) findViewById(R.id.meter);
        extra = (LinearLayout) findViewById(R.id.windows);
        widthe = (LinearLayout) findViewById(R.id.widt);
        radioGroup = (RadioGroup) findViewById(R.id.frgement);

        init();
    }

    public void init() {

/**
 *
 * Array Adapter For spiner
 * */
        coats = new ArrayAdapter<String>(this, R.layout.spinner_item_text, apiner_arr);
        meters = new ArrayAdapter<String>(this, R.layout.spinner_item_text, Global_Class.measurement);
/*
*
* Set Addpter For Spiner
*
* */
        sp_coats.setAdapter(coats);
        sp_w_d.setAdapter(coats);
        meter.setAdapter(meters);




/*
*
* Set Area and Paint on Screen
* */
        are = Global_Class.getArea();
        area.setText(are);
        paint.setText(Global_Class.getPaint().getName());
        recommended_coats.setText("Recommended coats:" + Global_Class.getPaint().getRecommend_cots());
/*
* The Condition For Extra Part For Door and Window
* */
        if (are.equals("Doors")) {
            extra.setVisibility(View.VISIBLE);
            n_d_w.setText(" Doors");
        } else if (are.equals("Windows")) {
            extra.setVisibility(View.VISIBLE);
            n_d_w.setText("Windows");
        } else if (are.equals("Interior Walls")) {
            extra.setVisibility(View.VISIBLE);
            n_d_w.setText("Walls Sides");
        }



    /*Change input Key bord*/
        lenth.setInputType(Configuration.KEYBOARD_12KEY);
        width.setInputType(Configuration.KEYBOARD_12KEY);
/*
* All Click Events of Class
* */
        /*
        * Change Mood simple simple tp Total area and Total Area to simple
        * */
        Global_Class.total_area_working = "0";
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // checkedId is the RadioButton selected

                switch (checkedId) {
                    case R.id.dimensions:
                        len_label.setText("Length ");

                        if (are.equals("Doors")) {
                            extra.setVisibility(View.VISIBLE);
                            n_d_w.setText(" Doors");
                        } else if (are.equals("Windows")) {
                            extra.setVisibility(View.VISIBLE);
                            n_d_w.setText("Windows");
                        } else if (are.equals("Interior Walls")) {
                            extra.setVisibility(View.VISIBLE);
                            n_d_w.setText("Walls Sides");
                        }
                        widthe.setVisibility(View.VISIBLE);
                        width.setText("");
                        lenth.setFilters(new InputFilter[]{new InputFilter.LengthFilter(9)});
                        lenth.setInputType(InputType.TYPE_CLASS_NUMBER);
                        Global_Class.total_area_working = "0";
                        break;
                    case R.id.total_area:
                        len_label.setText("Total Area ");
                        extra.setVisibility(View.GONE);
                        widthe.setVisibility(View.GONE);
                        width.setText("1");
                        lenth.setFilters(new InputFilter[]{new InputFilter.LengthFilter(20)});
                        Global_Class.total_area_working = "1";
                        break;
                }

            }
        });

        /*
        * Select Coat in spiner
        * */
        sp_coats.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                        cots = apiner_arr[pos];
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
         /*
        * Select Windows OR doors Or wallas in spiner
        * */
        sp_w_d.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                        wind_door = apiner_arr[pos];
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
        /*
        * Select Meeter OR Feet  in spiner
        * */
        meter.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
                        Global_Class.setMeasurement_s("" + pos);
                    }

                    public void onNothingSelected(AdapterView<?> parent) {
                    }
                });
        /*
        * Calculation validation and set variables off Global Class in Calculate Button
        * */
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (lenth.getText().toString() != null && width.getText().toString() != null && !width.getText().toString().equals("") && !lenth.getText().toString().equals("")) {
                    if ((lenth.getText().toString().matches("[0-9]*$") || lenth.getText().toString().matches("^[0-9]*?(\\.[0-9]*?)?$")) && (width.getText().toString().matches("[0-9]*$") || width.getText().toString().matches("^[0-9]*?(\\.[0-9]*?)?$"))) {
                        Global_Class.setLength(lenth.getText().toString());
                        Global_Class.setWidth(width.getText().toString());
                        Global_Class.setCoats(cots);
                        Global_Class.setWindow_door(wind_door);
                        startActivity(new Intent(getBaseContext(), Result.class));
                        finish();
                    } else if (!lenth.getText().toString().matches("[0-9]*$") && !lenth.getText().toString().matches("^[0-9]*?(\\.[0-9]*?)?$")) {

                        lenth.setError("Pleas Enter Valid Value...");
                    } else if (!width.getText().toString().matches("[0-9]*$") && !width.getText().toString().matches("^[0-9]*?(\\.[0-9]*?)?$")) {

                        width.setError("Pleas Enter Valid Width...");
                    }

                } else if (lenth.getText().toString() == null || lenth.getText().toString().equals("")) {

                    lenth.setError("Pleas Enter Value...");

                } else if (width.getText().toString() == null || width.getText().toString().equals("")) {

                    width.setError("Pleas Enter Width...");

                } else {
                    width.setError("Please Enter Value ");
                    lenth.setError("Please Enter Width ");
                }

            }
        });
        /*
        * Back Button Click Event
        * */
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getBaseContext(), Paint_Select.class));
                finish();
                Paint_Select.extra_postion = -1;
            }
        });
        /*
        * Reset Button Click Event
        * */
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Global_Class.reset();
                startActivity(new Intent(getBaseContext(), MainActivity.class));
                finish();
            }
        });
    }
}
