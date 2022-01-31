package com.jii.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView equationText, resultText;
    HorizontalScrollView scrollview;

    public static long result_long;
    public static int result_int;
    public static boolean operatorsClicked;

    long first_val, second_val;
    boolean dotClicked, percentClicked;
    char prev_num, current_num;

    String string_val;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TODO your application logic here:

        equationText = findViewById(R.id.equations_display);
        resultText = findViewById(R.id.result_display);
        scrollview = findViewById(R.id.Hscollview);

        dotClicked = false;
        percentClicked = false;
        operatorsClicked = false;

        string_val = "";

    }
    private void updateResultDisplay(char val) {
        string_val += Character.toString(val);

        resultText.setText(string_val);
        scrollview.fullScroll(ScrollView.FOCUS_RIGHT);
    }
    private void clear_fields() {

    }

    public void clicked_9(View view) {
        current_num = '9';
        updateResultDisplay(current_num);
    }

    public void clicked_8(View view) {
        current_num = '8';
        updateResultDisplay(current_num);
    }

    public void clicked_7(View view) {
        current_num = '7';
        updateResultDisplay(current_num);
    }

    public void clicked_6(View view) {
        current_num = '6';
        updateResultDisplay(current_num);
    }

    public void clicked_5(View view) {
        current_num = '5';
        updateResultDisplay(current_num);
    }

    public void clicked_4(View view) {
        current_num = '4';
        updateResultDisplay(current_num);
    }

    public void clicked_3(View view) {
        current_num = '3';
        updateResultDisplay(current_num);
    }

    public void clicked_2(View view) {
        current_num = '2';
        updateResultDisplay(current_num);
    }

    public void clicked_1(View view) {
        current_num = '1';
        updateResultDisplay(current_num);
    }

    public void clicked_0(View view) {
        current_num = '0';
        updateResultDisplay(current_num);
    }

    public void clicked_sign(View view) {

    }

    public void clicked_dot(View view) {

    }

    public void clicked_devide(View view) {

    }

    public void clicked_multiply(View view) {

    }

    public void clicked_subtract(View view) {

    }

    public void clicked_add(View view) {

    }

    public void clicked_equal(View view) {

    }

    public void clicked_backspace(View view) {

    }

    public void clicked_percent(View view) {

    }

    public void clicked_clear(View view) {

    }

}