package com.hfad.tictactoemvpappversiontree;

import android.widget.Button;

public class Presenter implements IContract.IPresenter {

    public boolean activePlayer = true;

    Symbol[] gameStateSymbol = {Symbol.EMPTY, Symbol.EMPTY, Symbol.EMPTY, Symbol.EMPTY,
            Symbol.EMPTY, Symbol.EMPTY, Symbol.EMPTY, Symbol.EMPTY, Symbol.EMPTY};

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
           gameStateSymbol[i] = Symbol.CROSS;
           myMVPView.updateView( "X", i);
           activePlayer = false;
        } else {
            gameStateSymbol[i] = Symbol.ZERO;
            myMVPView.updateView( "0", i);
            activePlayer = true;
        }

    }
}
