package com.hfad.tictactoemvpappversiontree;

public class Presenter implements IContract.IPresenter {
    IContract.IView myMVPView;

    public Presenter(IContract.IView myMVPView) {
        this.myMVPView = myMVPView;
    }
}
