package com.hfad.tictactoemvpappversiontree;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements IContract.IView {
    IContract.IPresenter myMVPPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myMVPPresenter = new Presenter(this);
    }
}