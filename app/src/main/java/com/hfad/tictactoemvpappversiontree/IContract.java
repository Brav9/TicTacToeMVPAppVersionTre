package com.hfad.tictactoemvpappversiontree;

public interface IContract {
    interface IView {

        void updateView(String s, int i);
        void finishGame();
        void returnStart();
        void updatePlayerScore();

    }

    interface IPresenter {
       void move(int i);
       int playerOneScoreCount();
       int playerTwoScoreCount();
       void clear();
       void playAgain();
    }
}