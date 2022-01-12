package com.hfad.tictactoemvpappversiontree;

public interface IContract {
    interface IView {

        void updateView(String s, int i);
    }

    interface IPresenter {
       void move(int i);
    }
}