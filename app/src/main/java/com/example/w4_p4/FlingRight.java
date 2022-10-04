package com.example.w4_p4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

public class FlingRight extends AppCompatActivity {
    GestureDetector gd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fling_right);
        gd = new GestureDetector(this, new Gestures());
    }
    private class Gestures extends GestureDetector.SimpleOnGestureListener {


        @Override
        public boolean onFling(MotionEvent event1, MotionEvent event2, float v, float v1) {

            try {


                if (Math.abs(event1.getY()-event2.getY()) > 90){
                    if (event1.getY() - event2.getY() > 40) {
                        Toast.makeText(getApplicationContext(), "Fling up", Toast.LENGTH_SHORT).show();
                    } else if (event2.getY() - event1.getY() > 40) {
                        Toast.makeText(getApplicationContext(), "Fling down", Toast.LENGTH_SHORT).show();

                    }
                }
                if (Math.abs(event1.getX() - event2.getX())>90) {
                    if (event1.getX() - event2.getX() > 40) {
                        Toast.makeText(getApplicationContext(), "Fling left", Toast.LENGTH_SHORT).show();
                        Intent i = new Intent(FlingRight.this, MainActivity.class);
                        startActivity(i);
                    } else if (event2.getX() - event1.getX() > 40) {
                        Toast.makeText(getApplicationContext(), "Fling right", Toast.LENGTH_SHORT).show();

                    }
                }



            } catch (NumberFormatException e) {



            } catch (NullPointerException e) {

            }
            return super.onFling(event1, event2, v, v1);
        }


        @Override
        public boolean onScroll(MotionEvent event1, MotionEvent event2, float v, float v1) {
            try {




                if (Math.abs(event1.getY()-event2.getY()) <= 90){
                    if (event1.getY() - event2.getY() <= 40) {

                    } else if (event2.getY() - event1.getY() <= 40) {


                    }


                }



            } catch (NumberFormatException e) {



            } catch (NullPointerException e) {

            }


            return super.onScroll(event1, event2, v, v1);
        }


    }
    public boolean onTouchEvent(MotionEvent event) {
        gd.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}