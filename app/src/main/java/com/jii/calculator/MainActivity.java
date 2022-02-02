package com.jii.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

//Toast.makeText(MainActivity.this,e.toString(), Toast.LENGTH_SHORT).show();
public class MainActivity extends AppCompatActivity {
    TextView equationText, resultText, titleText;
    HorizontalScrollView scrollview;

    public static double result_double;
    public static long result_long;

    boolean dotClicked, percentClicked, operatorQueue;
    char prev_num, current_num, current_key, current_operator;

    String first_val, second_val, result_val;
    String string_val, active_val, temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TODO your application logic here:

        equationText = findViewById(R.id.equations_display);
        resultText = findViewById(R.id.result_display);
        scrollview = findViewById(R.id.Hscollview);
        titleText = findViewById(R.id.title);

        clear_fields();
    }
    private void operatorClicked(char key) {
        if (current_key != key) {
            current_key = key;

            if (resultText.getText().equals("") || Double.parseDouble(active_val) == 0) {
                if (operatorQueue) {
                    equationText.setText(equationText.getText().toString().replace(current_operator, current_key));
                    current_operator  = current_key;
                } else {
                    first_val = "0";
                }
            } else {
                prepare2ndVal(current_key);
            }
        }
    }

    private void prepare2ndVal(char key) {
        first_val = active_val;
        current_operator = key;
        dotClicked = false;
        operatorQueue = true;

        double D = Double.parseDouble(first_val);
        first_val = reformatResult(D);

        second_val = "";
        string_val = "";
        active_val = "";
        temp = "";


        resultText.setText(active_val);
        equationText.setText(first_val + " " + key + " ");
        equationText.setVisibility(View.VISIBLE);
    }

    private boolean checkDecimal(String val) {
        double doubleVal = Double.parseDouble(val);
        if ((long) doubleVal == doubleVal)
            return false;
        else
            return true;
    }

    private String reformatResult(double val) {
        if (val == (long) val)
            temp = Long.toString((long) val);
        else
            temp = Double.toString(val);

        return temp;
    }

    private void updateResultDisplay(String val) {
        if (val.startsWith("0") && !string_val.contains("."))
            val = val.replaceFirst("0", "");

        active_val = val;
        resultText.setText(active_val);
        scrollview.fullScroll(ScrollView.FOCUS_RIGHT);
    }

    private void clear_fields() {
        String empty = "";
        result_double = 0;
        result_long = 0;

        dotClicked = false;
        percentClicked = false;
        prev_num = '0';
        current_num = '0';
        current_key = 'c';

        first_val = "0";
        second_val = "0";
        result_val = "0";

        string_val = "";
        active_val = "";
        temp = "";

        resultText.setText(empty);
        equationText.setText(empty);
        equationText.setVisibility(View.INVISIBLE);
        scrollview.fullScroll(ScrollView.FOCUS_RIGHT);
    }

    public void clicked_9(View view) {
        current_num = '9';
        string_val += Character.toString(current_num);
        updateResultDisplay(string_val);
    }

    public void clicked_8(View view) {
        current_num = '8';
        string_val += Character.toString(current_num);
        updateResultDisplay(string_val);
    }

    public void clicked_7(View view) {
        current_num = '7';
        string_val += Character.toString(current_num);
        updateResultDisplay(string_val);
    }

    public void clicked_6(View view) {
        current_num = '6';
        string_val += Character.toString(current_num);
        updateResultDisplay(string_val);
    }

    public void clicked_5(View view) {
        current_num = '5';
        string_val += Character.toString(current_num);
        updateResultDisplay(string_val);
    }

    public void clicked_4(View view) {
        current_num = '4';
        string_val += Character.toString(current_num);
        updateResultDisplay(string_val);
    }

    public void clicked_3(View view) {
        current_num = '3';
        string_val += Character.toString(current_num);
        updateResultDisplay(string_val);
    }

    public void clicked_2(View view) {
        current_num = '2';
        string_val += Character.toString(current_num);
        updateResultDisplay(string_val);
    }

    public void clicked_1(View view) {
        current_num = '1';
        string_val += Character.toString(current_num);
        updateResultDisplay(string_val);
    }

    public void clicked_0(View view) {
        current_num = '0';
        if (!resultText.getText().equals("") && !resultText.getText().equals("0")) {
            string_val += Character.toString(current_num);
            updateResultDisplay(string_val);
        }
    }

    public void clicked_sign(View view) {
        current_key = 's';
        if (!resultText.getText().equals("")) {
            result_double = Double.parseDouble(string_val);
            if (result_double != 0.0) {
                result_double *= -1;
                string_val = reformatResult(result_double);
                updateResultDisplay(string_val);
            }
        }
    }

    public void clicked_dot(View view) {
        current_key = '.';
        if (!dotClicked) {
            if (string_val.equals(""))
                string_val = "0";

            string_val += current_key;
            dotClicked = true;
            updateResultDisplay(string_val);
        }
    }

    public void clicked_devide(View view) {
        operatorClicked('÷');
    }

    public void clicked_multiply(View view) {
        operatorClicked('×');
    }

    public void clicked_subtract(View view) {
        operatorClicked('-');
    }

    public void clicked_add(View view) {
        operatorClicked('+');
    }


    public void clicked_equal(View view) {
//        updateResultDisplay(current_key);
        if (current_key != '=' && operatorQueue) {
            if (!resultText.getText().equals("") && Double.parseDouble(active_val) != 0) {
                second_val = active_val;
                operatorQueue = false;
                current_key = '=';

                double fNum = Double.parseDouble(first_val);
                double sNum = Double.parseDouble(second_val);

                switch (current_operator) {
                    case '+':
                        result_double = fNum + sNum;
                        break;
                    case '-':
                        result_double = fNum - sNum;
                        break;
                    case '×':
                        result_double = fNum * sNum;
                        break;
                    case  '÷':
                        result_double = fNum / sNum;
                        break;
                    default:
                        Toast.makeText(MainActivity.this, "Error: Invalid Operator", Toast.LENGTH_SHORT).show();
                }

                result_val = reformatResult(result_double);
                titleText.setText(result_val);
                clear_fields();
            }

        }
    }

    public void clicked_backspace(View view) {
        current_key = 'b';
//        updateResultDisplay(current_key);
    }

    public void clicked_percent(View view) {
        if (!resultText.getText().equals("")) {
            result_double = Double.parseDouble(active_val);
            result_double /= 100;

            string_val = reformatResult(result_double);
            updateResultDisplay(string_val);
        }
    }

    public void clicked_clear(View view) {
        current_key = 'c';
        clear_fields();
    }

}