package com.hfad.tictactoemvpappversiontree;

public interface IContract {
    interface IView {

        void updateView(String s, int i);
        void finishGame();

    }

    interface IPresenter {
       void move(int i);
       void clear();
    }
}