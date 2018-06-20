package com.e2esp.bergerpaints.calculator.utils;

import com.e2esp.bergerpaints.calculator.R;
import com.e2esp.bergerpaints.calculator.models.Area;
import com.e2esp.bergerpaints.calculator.models.Paint;

/**
 *
 * Created by Zain on 12/15/2017.
 */

public class Statics {

    private static Area area;
    private static Paint paint;
    private static String length;
    private static String width;
    private static String coats;
    private static String window_door;
    private static String Result;
    private static String paint_price;
    private static String paint_price_s_f;
    private static String paint_price_s_m;
    private static String measurement_s = "0";
    public static String total_area_working = "0";

    /*
    * All type Of paint arrays
    * */
    public static Paint[] paint_Image_arry = new Paint[11];
    public static Paint[] exterior = new Paint[3];
    public static Paint[] doors_and_windows = new Paint[4];
    public static Paint[] wood_finishes = new Paint[4];
    /*
    * measurement types array
    * */
    public static String[] measurement = {"Feet Per Square", "Meter Per Square"};


    /*
    * Creat Private variables Getter Setter
    * */
    public static Area getArea() {
        return area;
    }


    public static void setArea(Area area) {
        Statics.area = area;
    }

    public static Paint getPaint() {
        return paint;
    }

    public static void setPaint(Paint paint) {
        Statics.paint = paint;
    }

    public static String getLength() {
        return length;
    }

    public static void setLength(String length) {
        Statics.length = length;
    }

    public static String getWidth() {
        return width;
    }

    public static void setWidth(String width) {
        Statics.width = width;
    }

    public static String getCoats() {
        return coats;
    }

    public static void setCoats(String coats) {
        Statics.coats = coats;
    }

    public static String getWindow_door() {
        return window_door;
    }

    public static void setWindow_door(String window_door) {
        Statics.window_door = window_door;
    }

    public static String getResult() {
        return Result;
    }

    public static String getPaint_price() {
        return paint_price;
    }

    public static String getPaint_price_s_f() {
        return paint_price_s_f;
    }

    public static String getPaint_price_s_m() {
        return paint_price_s_m;
    }

    public static String getMeasurement_s() {
        return measurement_s;
    }

    public static void setMeasurement_s(String measurement_s) {
        Statics.measurement_s = measurement_s;
    }
/*
* Set all Value Null
* */

    public static void reset() {
        area = Area.NA;
        paint = new Paint();
        length = "";
        width = "";
        coats = "";
        window_door = "";
        Result = "";
    }


  /*
  * call function of Calculation the values types
  * */

    public static void Calculat() {
        if (measurement_s.equals("0")) {
            switch (area) {
                case CEILING:
                    celing();
                    break;
                case EXTERIOR_WALLS:
                    Exterior_Walls();
                    break;
                case INTERIOR_WALLS:
                    Interior_Walls();
                    break;
                case DOORS:
                    Doors();
                    break;
                case WINDOWS:
                    Windows();
                    break;
                case WOOD_FINISHES:
                    celing();
                    break;
                default:
                    Result = "";
                    break;
            }
        } else {
            switch (area) {
                case CEILING:
                    celing(1);
                    break;
                case EXTERIOR_WALLS:
                    Exterior_Walls(1);
                    break;
                case INTERIOR_WALLS:
                    Interior_Walls(1);
                    break;
                case DOORS:
                    Doors(1);
                    break;
                case WINDOWS:
                    Windows(1);
                    break;
                case WOOD_FINISHES:
                    celing(1);
                    break;
                default:
                    Result = "";
                    break;
            }
        }

    }

    /*
    * Creat Paint all lists
    * */
    public static void paint_list() {

        for (int i = 0; i < paint_Image_arry.length; i++) {

            paint_Image_arry[i] = new Paint();
            if (i < exterior.length) {

                exterior[i] = new Paint();
            }

            if (i < doors_and_windows.length) {
                doors_and_windows[i] = new Paint();

            }
            if (i < wood_finishes.length) {
                wood_finishes[i] = new Paint();

            }
        }

        /*
        * Paint Array
        * */

        paint_Image_arry[0].setName("ELEGANCE  MATT EMULSION");
        paint_Image_arry[0].setImage_id(R.drawable.image1);
        paint_Image_arry[0].setSquare_feet(161);
        paint_Image_arry[0].setMetre_square(15);
        paint_Image_arry[0].setP_p_liter(2767);
        paint_Image_arry[0].setLiter(4);
        paint_Image_arry[0].setRecommend_cots("2-3");

        paint_Image_arry[1].setName("VIP PLASTIC EMULSION");
        paint_Image_arry[1].setImage_id(R.drawable.image3);
        paint_Image_arry[1].setSquare_feet(151);
        paint_Image_arry[1].setMetre_square(14);
        paint_Image_arry[1].setP_p_liter(2178);
        paint_Image_arry[1].setLiter(4);
        paint_Image_arry[1].setRecommend_cots("2-3");

        paint_Image_arry[2].setName("EAZY CLEAN EMULSION");
        paint_Image_arry[2].setImage_id(R.drawable.image7);
        paint_Image_arry[2].setSquare_feet(151);
        paint_Image_arry[2].setMetre_square(14);
        paint_Image_arry[2].setP_p_liter(1693);
        paint_Image_arry[2].setLiter(3.64);
        paint_Image_arry[2].setRecommend_cots("2-3");

        paint_Image_arry[3].setName("SPD SMOOTH EMULSION");
        paint_Image_arry[3].setImage_id(R.drawable.image8);
        paint_Image_arry[3].setSquare_feet(140);
        paint_Image_arry[3].setMetre_square(13);
        paint_Image_arry[3].setP_p_liter(1107);
        paint_Image_arry[3].setLiter(3.64);
        paint_Image_arry[3].setRecommend_cots("2-3");

        paint_Image_arry[4].setName("ECONOMY EMULSION");
        paint_Image_arry[4].setImage_id(R.drawable.image9);
        paint_Image_arry[4].setSquare_feet(140);
        paint_Image_arry[4].setMetre_square(13);
        paint_Image_arry[4].setP_p_liter(994);
        paint_Image_arry[4].setLiter(3.64);
        paint_Image_arry[4].setRecommend_cots("2-3");

        paint_Image_arry[5].setName("SILK EMULSION");
        paint_Image_arry[5].setImage_id(R.drawable.image10);
        paint_Image_arry[5].setSquare_feet(200);
        paint_Image_arry[5].setMetre_square(18.5);
        paint_Image_arry[5].setP_p_liter(3246);
        paint_Image_arry[5].setLiter(4);
        paint_Image_arry[5].setRecommend_cots("2-3");

        paint_Image_arry[6].setName("MARBLEIZED FINISH");
        paint_Image_arry[6].setImage_id(R.drawable.image11);
        paint_Image_arry[6].setSquare_feet(32);
        paint_Image_arry[6].setMetre_square(3);
        paint_Image_arry[6].setP_p_liter(1520);
        paint_Image_arry[6].setLiter(1);
        paint_Image_arry[6].setRecommend_cots("3-4");

        paint_Image_arry[7].setName("GLAZED FINISH");
        paint_Image_arry[7].setImage_id(R.drawable.image12);
        paint_Image_arry[7].setSquare_feet(350);
        paint_Image_arry[7].setMetre_square(32.5);
        paint_Image_arry[7].setP_p_liter(1020);
        paint_Image_arry[7].setLiter(0.5);
        paint_Image_arry[7].setRecommend_cots("1");

        paint_Image_arry[8].setName("INTERIOR TEXTURE");
        paint_Image_arry[8].setImage_id(R.drawable.image13);
        paint_Image_arry[8].setSquare_feet(16);
        paint_Image_arry[8].setMetre_square(1.5);
        paint_Image_arry[8].setP_p_liter(2400);
        paint_Image_arry[8].setLiter(24);
        paint_Image_arry[8].setRecommend_cots("1");

        paint_Image_arry[9].setName("NU Emulsion");
        paint_Image_arry[9].setImage_id(R.drawable.image17);
        paint_Image_arry[9].setSquare_feet(151);
        paint_Image_arry[9].setMetre_square(14);
        paint_Image_arry[9].setP_p_liter(746);
        paint_Image_arry[9].setLiter(3.64);
        paint_Image_arry[9].setRecommend_cots("2-3");

        paint_Image_arry[10].setName("ALLROUNDER MATT FINISH ENAMEL");
        paint_Image_arry[10].setImage_id(R.drawable.image5);
        paint_Image_arry[10].setSquare_feet(151);
        paint_Image_arry[10].setMetre_square(14);
        paint_Image_arry[10].setP_p_liter(2606);
        paint_Image_arry[10].setLiter(3.64);
        paint_Image_arry[10].setRecommend_cots("2");


        /*
         * Door And Windows Paint
         **/

        doors_and_windows[0].setName("ELEGANCE LONG LIFE ENAMEL");
        doors_and_windows[0].setImage_id(R.drawable.image2);
        doors_and_windows[0].setSquare_feet(151);
        doors_and_windows[0].setMetre_square(14);
        doors_and_windows[0].setP_p_liter(2345);
        doors_and_windows[0].setLiter(3.64);
        doors_and_windows[0].setRecommend_cots("2");

        doors_and_windows[1].setName("VIP SUPER GLOSS ENAMEL");
        doors_and_windows[1].setImage_id(R.drawable.image4);
        doors_and_windows[1].setSquare_feet(151);
        doors_and_windows[1].setMetre_square(14);
        doors_and_windows[1].setP_p_liter(2633);
        doors_and_windows[1].setLiter(3.64);
        doors_and_windows[1].setRecommend_cots("2-3");

        doors_and_windows[2].setName("ALLROUNDER MATT FINISH ENAMEL");
        doors_and_windows[2].setImage_id(R.drawable.image5);
        doors_and_windows[2].setSquare_feet(151);
        doors_and_windows[2].setMetre_square(14);
        doors_and_windows[2].setP_p_liter(3011);
        doors_and_windows[2].setLiter(3.64);
        doors_and_windows[2].setRecommend_cots("2");

        doors_and_windows[3].setName("NU Enamel");
        doors_and_windows[3].setImage_id(R.drawable.image16);
        doors_and_windows[3].setSquare_feet(151);
        doors_and_windows[3].setMetre_square(14);
        doors_and_windows[3].setP_p_liter(1388);
        doors_and_windows[3].setLiter(3.64);
        doors_and_windows[3].setRecommend_cots("2-3");


        /*
         * Exterior Paint
         **/

        exterior[0].setName("WEATHER COAT");
        exterior[0].setImage_id(R.drawable.image6);
        exterior[0].setSquare_feet(151);
        exterior[0].setMetre_square(14);
        exterior[0].setP_p_liter(2833);
        exterior[0].setLiter(4);
        exterior[0].setRecommend_cots("2-3");

        exterior[2].setName("EXTERIOR TEXTURE");
        exterior[2].setImage_id(R.drawable.image14);
        exterior[2].setSquare_feet(13);
        exterior[2].setMetre_square(1.25);
        exterior[2].setP_p_liter(3570);
        exterior[2].setLiter(20);
        exterior[2].setRecommend_cots("1");

        exterior[1].setName("SAND FINISH");
        exterior[1].setImage_id(R.drawable.image15);
        exterior[1].setSquare_feet(16);
        exterior[1].setMetre_square(1.5);
        exterior[1].setP_p_liter(4000);
        exterior[1].setLiter(20);
        exterior[1].setRecommend_cots("1");


        /*
         * Wood Finishes Paint
         **/

        wood_finishes[0].setName("Timbercoat Polyurethane Color Varnish");
        wood_finishes[0].setImage_id(R.drawable.image18);
        wood_finishes[0].setSquare_feet(118);
        wood_finishes[0].setMetre_square(11);
        wood_finishes[0].setP_p_liter(789);
        wood_finishes[0].setLiter(0.91);
        wood_finishes[0].setRecommend_cots("2-3");

        wood_finishes[1].setName("Timbercoat Acid Catalyzed Clear Matt Lacquer");
        wood_finishes[1].setImage_id(R.drawable.image18);
        wood_finishes[1].setSquare_feet(118);
        wood_finishes[1].setMetre_square(11);
        wood_finishes[1].setP_p_liter(2285);
        wood_finishes[1].setLiter(3.64);
        wood_finishes[1].setRecommend_cots("2-3");

        wood_finishes[2].setName("Timbercoat Clear Wood Lacquer");
        wood_finishes[2].setImage_id(R.drawable.image18);
        wood_finishes[2].setSquare_feet(118);
        wood_finishes[2].setMetre_square(11);
        wood_finishes[2].setP_p_liter(2315);
        wood_finishes[2].setLiter(3.64);
        wood_finishes[2].setRecommend_cots("2-3");

        wood_finishes[3].setName("Timbercoat Polyurethane Clear Wood Lacquer");
        wood_finishes[3].setImage_id(R.drawable.image18);
        wood_finishes[3].setSquare_feet(118);
        wood_finishes[3].setMetre_square(11);
        wood_finishes[3].setP_p_liter(2363);
        wood_finishes[3].setLiter(3.64);
        wood_finishes[3].setRecommend_cots("2-3");

    }

    /*
     * function calculation Paint Square feet
        * */
    public static void Exterior_Walls() {
        double c = round(((round(Double.valueOf(width), 2) * round(Double.valueOf(length), 2)) / paint.getSquare_feet()), 2) * Integer.parseInt(coats);
        Result = "" + round(c, 2);

    }

    public static void Interior_Walls() {

        double c = round(((round(Double.valueOf(width), 2) * round(Double.valueOf(length), 2) * Integer.parseInt(window_door)) / paint.getSquare_feet()), 2) * Integer.parseInt(coats);
        Result = "" + round(c, 2);
    }

    public static void Doors() {

        double c = round((round(Double.valueOf(width), 2) * (Double.valueOf(length) * Integer.parseInt(window_door) * 2) / paint.getSquare_feet()), 2);// *  Integer.parseInt(coats);
        c = c * Double.valueOf(coats);
        Result = "" + c;
    }

    public static void Windows() {
        double c = round(((round(Double.valueOf(width), 2) * round(Double.valueOf(length), 2) * Integer.parseInt(window_door)) / paint.getSquare_feet()), 2) * Integer.parseInt(coats);
        Result = "" + (float) round(c, 2);

    }

    public static void celing() {

        double c = round(((round(Double.valueOf(width), 2) * round(Double.valueOf(length), 2)) / paint.getSquare_feet()), 2) * Integer.parseInt(coats);
        Result = "" + (float) round(c, 2);
    }

    /*
  * function calculation  Paint metre square
     * */
    public static void Exterior_Walls(int a) {
        double c = round((((round(Double.valueOf(width), 2) * round(Double.valueOf(length), 2))) / paint.getMetre_square()), 2) * Integer.parseInt(coats);
        Result = "" + (float) round(c, 2);

    }

    public static void Interior_Walls(int a) {

        double c = round((((round(Double.valueOf(width), 2) * round(Double.valueOf(length), 2) * 3)) / paint.getMetre_square()), 2) * Integer.parseInt(coats);
        Result = "" + (float) round(c, 2);
    }

    public static void Doors(int a) {

        double c = round((((round(Double.valueOf(width), 2) * round(Double.valueOf(length), 2) * Integer.parseInt(window_door) * 2)) / paint.getMetre_square()), 2) * Integer.parseInt(coats);
        Result = "" + (float) round(c, 2);
        ;
    }

    public static void Windows(int a) {
        double c = round((((round(Double.valueOf(width), 2) * round(Double.valueOf(length), 2) * Integer.parseInt(window_door))) / paint.getMetre_square()), 2) * Integer.parseInt(coats);
        Result = "" + (float) round(c, 2);
        ;

    }

    public static void celing(int a) {

        double c = round((((round(Double.valueOf(width), 2) * round(Double.valueOf(length), 2))) / paint.getMetre_square()), 2) * Integer.parseInt(coats);
        Result = "" + (float) round(c, 2);
    }

    /**
     * value Round off
     */

    public static double round(double value, int places) {

        return Double.valueOf(String.format("%." + places + "f", value));

    }

    /*
    * Calculate the price of paint
    * */
    public static void price_of_paint() {

        double d = (Double.valueOf(paint.getP_p_liter()) / Double.valueOf(paint.getLiter()));
        d = round(d, 0);
        d = d * round(Double.valueOf(Result), 0);
        paint_price = "" + d;


    }

    /*
* Calculate the price of Square Feet
* */
    public static void price_of_s_f() {

        Double d = (Double.valueOf(paint.getP_p_liter()) / Double.valueOf(paint.getLiter())) / Double.valueOf(paint.getSquare_feet());
        paint_price_s_f = "" + round(d, 2);

    }

    /*
* Calculate the price of Square Metre
* */
    public static void price_of_s_m() {

        Double d = (Double.valueOf(paint.getP_p_liter()) / Double.valueOf(paint.getLiter())) / Double.valueOf(paint.getMetre_square());
        paint_price_s_m = "" + round(d, 2);

    }


}
