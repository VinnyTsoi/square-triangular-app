package com.vinnytsoi.squareortriangularnumberapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickButton(View view){

        EditText numberEditText = findViewById(R.id.numberEditText);

        String answer;

        String numberString = numberEditText.getText().toString();

        if (numberString.isEmpty()){

            answer = "Please enter a number";

        } else {
            double number = Double.parseDouble(numberString);

            answer = numberString;

            Square square = new Square();

            Triangular triangular = new Triangular();

            if (square.isSquare(number))
                answer += " is square and ";
            else
                answer += " is not square and ";

            if (triangular.isTriangular(number))
                answer += "is triangular";
            else
                answer += "is not triangular";
        }

        Log.i("info",answer);

        Toast.makeText(this, answer, Toast.LENGTH_LONG).show();

    }

    public class Square {

        public boolean isSquare(double number){

            if(Math.sqrt(number) % 1 == 0 )
                return true;
            else
                return false;
        }

    }

    public class Triangular{

        //An integer x is triangular if and only if 8x + 1 is a square
        public boolean isTriangular(double number){

            double newDouble = (8 * number) + 1;

            Square newSquare = new Square();

            if (newSquare.isSquare(newDouble))
                return true;
            else
                return false;
        }

    }

}
