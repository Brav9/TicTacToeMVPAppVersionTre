package com.hfad.tictactoemvpappversiontree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements IContract.IView {

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

        Button resetGame = findViewById(R.id.resetGame);

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

        resetGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                myMVPPresenter.clearOneScoreCount();
                myMVPPresenter.clearTwoScoreCount();
                finishGame(Winner.DRAFT);

            }
        });
    }

    @Override
    public void updateView(String s, int i) {
        if (i == 0) {
            btnZero.setText(s);
            btnZero.setEnabled(false);
        } else if (i == 1) {
            btnOne.setText(s);
            btnOne.setEnabled(false);
        } else if (i == 2) {
            btnTwo.setText(s);
            btnTwo.setEnabled(false);
        } else if (i == 3) {
            btnTree.setText(s);
            btnTree.setEnabled(false);
        } else if (i == 4) {
            btnFour.setText(s);
            btnFour.setEnabled(false);
        } else if (i == 5) {
            btnFive.setText(s);
            btnFive.setEnabled(false);
        } else if (i == 6) {
            btnSix.setText(s);
            btnSix.setEnabled(false);
        } else if (i == 7) {
            btnSeven.setText(s);
            btnSeven.setEnabled(false);
        } else if (i == 8) {
            btnEight.setText(s);
            btnEight.setEnabled(false);

        }
    }

    @Override
    public void finishGame(Winner winner) {
        myMVPPresenter.playAgain();
        if (winner == Winner.WIN_CROSS) {
            playerOneScore.setText(Integer.toString(myMVPPresenter.playerOneScoreCount()));
            Toast.makeText(this, "Player One Won!", Toast.LENGTH_SHORT).show();
        } else if (winner == Winner.WIN_ZERO) {
            playerTwoScore.setText(Integer.toString(myMVPPresenter.playerTwoScoreCount()));
            Toast.makeText(this, "Player Two Won!", Toast.LENGTH_SHORT).show();
        } else if (winner == Winner.DRAFT) {
            playerOneScore.setText("0");
            playerTwoScore.setText("0");
        } else {
            Toast.makeText(this, "No Winner!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void returnStart() {
        btnZero.setText("");
        btnZero.setEnabled(true);
        btnOne.setText("");
        btnOne.setEnabled(true);
        btnTwo.setText("");
        btnTwo.setEnabled(true);
        btnTree.setText("");
        btnTree.setEnabled(true);
        btnFour.setText("");
        btnFour.setEnabled(true);
        btnFive.setText("");
        btnFive.setEnabled(true);
        btnSix.setText("");
        btnSix.setEnabled(true);
        btnSeven.setText("");
        btnSeven.setEnabled(true);
        btnEight.setText("");
        btnEight.setEnabled(true);
    }
}