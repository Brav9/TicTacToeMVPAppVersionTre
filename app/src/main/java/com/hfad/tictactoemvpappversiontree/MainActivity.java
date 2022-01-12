package com.hfad.tictactoemvpappversiontree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, IContract.IView {
    IContract.IPresenter myMVPPresenter;

    TextView playerOneScore;
    TextView playerTwoScore;
    TextView playerStatus;
    Button btnZero;
    Button btnOne;
    Button btnTwo;
    Button btnTree;
    Button btnFour;
    Button btnFive;
    Button btnSix;
    Button btnSeven;
    Button btnEight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        playerOneScore = findViewById(R.id.playerOneScore);
        playerTwoScore = findViewById(R.id.playerTwoScore);
        playerStatus = findViewById(R.id.playerStatus);

        btnZero = findViewById(R.id.btn_0);
        btnOne = findViewById(R.id.btn_1);
        btnTwo = findViewById(R.id.btn_2);
        btnTree = findViewById(R.id.btn_3);
        btnFour = findViewById(R.id.btn_4);
        btnFive = findViewById(R.id.btn_5);
        btnSix = findViewById(R.id.btn_6);
        btnSeven = findViewById(R.id.btn_7);
        btnEight = findViewById(R.id.btn_8);

        myMVPPresenter = new Presenter(this);

        btnZero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myMVPPresenter.move(0);

                ((Button) view).setText("X");
            }
        });

        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myMVPPresenter.move(1);

            }
        });

        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myMVPPresenter.move(2);
            }
        });

        btnTree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myMVPPresenter.move(3);
            }
        });

        btnFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myMVPPresenter.move(4);
            }
        });

        btnFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myMVPPresenter.move(5);
            }
        });

        btnSix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myMVPPresenter.move(6);
            }
        });

        btnSeven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myMVPPresenter.move(7);
            }
        });

        btnEight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myMVPPresenter.move(8);
            }
        });
    }

    @Override
    public void updateView(String s, int i) {


            if (i == 0) {
                btnZero.setText(s);
            } else if (i == 1) {
                btnOne.setText(s);
            } else if (i == 2) {
                btnTwo.setText(s);
            } else if (i == 3) {
                btnTree.setText(s);
            } else if (i == 4) {
                btnFour.setText(s);
            } else if (i == 5) {
                btnFive.setText(s);
            } else if (i == 6) {
                btnSix.setText(s);
            } else if (i == 7) {
                btnSeven.setText(s);
            } else if (i == 8) {
                btnEight.setText(s);

            }
    }

    @Override
    public void onClick(View view) {

    }
}