package com.hfad.tictactoemvpappversiontree;

import android.widget.Button;
import android.widget.Toast;

public class Presenter implements IContract.IPresenter {

    public boolean activePlayer = true;
    private int roundCount = 0;
    private int playerOneScoreCount;
    private int playerTwoScoreCount;


    // x => 0;
    // 0 => 1;
    // empty => 2;
    int[] gameStateSymbol = {2, 2, 2, 2, 2, 2, 2, 2, 2};


    int[][] winningPosition = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, //rows
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, //columns
            {0, 4, 8}, {2, 4, 6} // cross
    };

    IContract.IView myMVPView;

    public Presenter(IContract.IView myMVPView) {
        this.myMVPView = myMVPView;
    }


    @Override
    public void move(int i) {

        if (activePlayer) {
            gameStateSymbol[i] = 0;
            myMVPView.updateView("X", i);
        } else {
            gameStateSymbol[i] = 1;
            myMVPView.updateView("0", i);
        }
        roundCount++;
        activePlayer = !activePlayer;

        if (checkWinner()) {
            if (activePlayer) {
                playerOneScoreCount();
            } else {
                playerTwoScoreCount();
            }
            myMVPView.updatePlayerScore();
            playAgain();
        }
    }

    @Override
    public int playerOneScoreCount() {
        playerOneScoreCount++;
        return playerOneScoreCount;
    }

    @Override
    public int playerTwoScoreCount() {
        playerTwoScoreCount++;
        return playerOneScoreCount;
    }

    @Override
    public void clear() {
        activePlayer = true;
        roundCount = 0;
    }

    @Override
    public void playAgain() {
        clear();
        for (int i = 0; i < 9; i++) {
            gameStateSymbol[i] = 2;
            myMVPView.returnStart();
        }
    }

    public boolean checkWinner() {
        boolean winnerResult = false;

        for (int[] winningPosition : winningPosition) {
            if (gameStateSymbol[winningPosition[0]] == gameStateSymbol[winningPosition[1]] &&
                    gameStateSymbol[winningPosition[1]] == gameStateSymbol[winningPosition[2]] &&
                    gameStateSymbol[winningPosition[0]] != 2) {
                winnerResult = true;

            }
        }
        return winnerResult;
    }
}
