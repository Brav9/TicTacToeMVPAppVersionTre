package com.hfad.tictactoemvpappversiontree;

public interface IContract {
    interface IView {

        void updateView(String s, int i);
        void finishGame(Winner winner);
        void returnStart();

    }

    interface IPresenter {
       void move(int i);
       int playerOneScoreCount();
       int playerTwoScoreCount();
       void playAgain();
       void clearOneScoreCount();
       void clearTwoScoreCount();

    }
}