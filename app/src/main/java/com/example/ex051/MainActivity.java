package com.example.ex051;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView num1, num2, num3, num4, num5, num6;
    EditText input1, input2, input3;
    ImageView successIv1, successIv2, successIv3;
    Random rnd = new Random();
    int correctAnswers = 0, level3Limit = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = (TextView) findViewById(R.id.num1);
        num2 = (TextView) findViewById(R.id.num2);
        num3 = (TextView) findViewById(R.id.num3);
        num4 = (TextView) findViewById(R.id.num4);
        num5 = (TextView) findViewById(R.id.num5);
        num6 = (TextView) findViewById(R.id.num6);

        input1 = (EditText)  findViewById(R.id.input1);
        input2 = (EditText)  findViewById(R.id.input2);
        input3 = (EditText)  findViewById(R.id.input3);

        successIv1 = (ImageView)  findViewById(R.id.successIv1);
        successIv2 = (ImageView)  findViewById(R.id.successIv2);
        successIv3 = (ImageView)  findViewById(R.id.successIv3);

        num1.setText(rnd.nextInt(90) + 10 + "");
        num2.setText(rnd.nextInt(90) + 10 + "");
    }

    public void checkLevel1(View view) {
        if (num4.getText().toString().equals("")) {
            String sum = input1.getText().toString();
            if (sum.isEmpty()) {
                Toast.makeText(this, "Invalid input - try again", Toast.LENGTH_SHORT).show();
            } else {
                if (Integer.parseInt(sum) == Integer.parseInt(num1.getText().toString()) + Integer.parseInt(num2.getText().toString())) {
                    successIv1.setImageResource(R.drawable.iv_true);
                    correctAnswers++;
                } else {
                    successIv1.setImageResource(R.drawable.iv_false);
                }
                num3.setText(Integer.parseInt(num1.getText().toString()) + Integer.parseInt(num2.getText().toString()) + "");
                if (num4.getText().toString().equals("")) {
                    num4.setText(rnd.nextInt(90) + 10 + "");
                }
            }
        }
        else {
            Toast.makeText(this, "You cant answer again!", Toast.LENGTH_SHORT).show();
        }
    }

    public void checkLevel2(View view) {
        if (num6.getText().toString().equals("")) {
            if (num3.getText().toString().equals("") && num4.getText().toString().equals("")) {
                Toast.makeText(this, "Invalid level - try again", Toast.LENGTH_SHORT).show();
            } else {
                String sum = input2.getText().toString();
                if (sum.isEmpty()) {
                    Toast.makeText(this, "Invalid input - try again", Toast.LENGTH_SHORT).show();
                } else {
                    if (Integer.parseInt(sum) == Integer.parseInt(num3.getText().toString()) + Integer.parseInt(num4.getText().toString())) {
                        successIv2.setImageResource(R.drawable.iv_true);
                        correctAnswers++;
                    }
                    else {
                        successIv2.setImageResource(R.drawable.iv_false);
                    }
                    num5.setText(Integer.parseInt(num3.getText().toString()) + Integer.parseInt(num4.getText().toString()) + "");
                    if (num6.getText().toString().equals("")) {
                        num6.setText(rnd.nextInt(90) + 10 + "");
                    }
                }
            }
        }
        else {
            Toast.makeText(this, "You cant answer again!", Toast.LENGTH_SHORT).show();
        }
    }

    public void checkLevel3(View view) {
        if (level3Limit == 1) {
            if (num5.getText().toString().equals("") && num6.getText().toString().equals("")) {
                Toast.makeText(this, "Invalid level - try again", Toast.LENGTH_SHORT).show();
            } else {
                String sum = input3.getText().toString();
                if (sum.isEmpty()) {
                    Toast.makeText(this, "Invalid input - try again", Toast.LENGTH_SHORT).show();
                } else {
                    if (Integer.parseInt(sum) == Integer.parseInt(num5.getText().toString()) + Integer.parseInt(num6.getText().toString())) {
                        successIv3.setImageResource(R.drawable.iv_true);
                        correctAnswers++;
                    } else {
                        successIv3.setImageResource(R.drawable.iv_false);
                    }
                    Toast.makeText(this, 33.33 * correctAnswers + "%, " + correctAnswers + "/3", Toast.LENGTH_SHORT).show();
                    Toast.makeText(this, "You can start a new game!", Toast.LENGTH_SHORT).show();
                }
                if (!sum.isEmpty()) {
                    level3Limit = 0;
                }
            }
        }
        else {
            Toast.makeText(this, "You cant answer again!", Toast.LENGTH_SHORT).show();
        }
    }

    public void clearGame(View view) {
        correctAnswers = 0;
        num1.setText(rnd.nextInt(90) + 10 + "");
        num2.setText(rnd.nextInt(90) + 10 + "");
        num3.setText("");
        num4.setText("");
        num5.setText("");
        num6.setText("");

        input1.setText("");
        input2.setText("");
        input3.setText("");

        level3Limit = 1;

        successIv1.setImageResource(R.drawable.iv_unknown);
        successIv2.setImageResource(R.drawable.iv_unknown);
        successIv3.setImageResource(R.drawable.iv_unknown);
    }
}