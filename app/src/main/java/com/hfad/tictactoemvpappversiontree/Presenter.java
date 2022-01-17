package com.hfad.tictactoemvpappversiontree;

public class Presenter implements IContract.IPresenter {

    public boolean activePlayer = true;
    int roundCount = 0;
    int playerOneScoreCount;
    int playerTwoScoreCount;

    Symbol[] gameSymbol = {Symbol.EMPTY, Symbol.EMPTY, Symbol.EMPTY, Symbol.EMPTY,
            Symbol.EMPTY, Symbol.EMPTY, Symbol.EMPTY, Symbol.EMPTY, Symbol.EMPTY};

    IContract.IView myMVPView;

    public Presenter(IContract.IView myMVPView) {
        this.myMVPView = myMVPView;
    }

    @Override
    public void move(int i) {

        roundCount++;

        if (activePlayer) {
            gameSymbol[i] = Symbol.CROSS;
            myMVPView.updateView("X", i);
        } else {
            gameSymbol[i] = Symbol.ZERO;
            myMVPView.updateView("0", i);
        }

        if (gameSymbol[0] == Symbol.ZERO && gameSymbol[1] == Symbol.ZERO && gameSymbol[2] == Symbol.ZERO ||
                gameSymbol[3] == Symbol.ZERO && gameSymbol[4] == Symbol.ZERO && gameSymbol[5] == Symbol.ZERO ||
                gameSymbol[6] == Symbol.ZERO && gameSymbol[7] == Symbol.ZERO && gameSymbol[8] == Symbol.ZERO ||

                gameSymbol[0] == Symbol.ZERO && gameSymbol[3] == Symbol.ZERO && gameSymbol[6] == Symbol.ZERO ||
                gameSymbol[1] == Symbol.ZERO && gameSymbol[4] == Symbol.ZERO && gameSymbol[7] == Symbol.ZERO ||
                gameSymbol[2] == Symbol.ZERO && gameSymbol[5] == Symbol.ZERO && gameSymbol[8] == Symbol.ZERO ||

                gameSymbol[0] == Symbol.ZERO && gameSymbol[4] == Symbol.ZERO && gameSymbol[8] == Symbol.ZERO ||
                gameSymbol[2] == Symbol.ZERO && gameSymbol[4] == Symbol.ZERO && gameSymbol[6] == Symbol.ZERO) {

            playerOneScoreCount();
            myMVPView.finishGame(Winner.WIN_ZERO);

        } else if (gameSymbol[0] == Symbol.CROSS && gameSymbol[1] == Symbol.CROSS && gameSymbol[2] == Symbol.CROSS ||
                gameSymbol[3] == Symbol.CROSS && gameSymbol[4] == Symbol.CROSS && gameSymbol[5] == Symbol.CROSS ||
                gameSymbol[6] == Symbol.CROSS && gameSymbol[7] == Symbol.CROSS && gameSymbol[8] == Symbol.CROSS ||

                gameSymbol[0] == Symbol.CROSS && gameSymbol[3] == Symbol.CROSS && gameSymbol[6] == Symbol.CROSS ||
                gameSymbol[1] == Symbol.CROSS && gameSymbol[4] == Symbol.CROSS && gameSymbol[7] == Symbol.CROSS ||
                gameSymbol[2] == Symbol.CROSS && gameSymbol[5] == Symbol.CROSS && gameSymbol[8] == Symbol.CROSS ||

                gameSymbol[0] == Symbol.CROSS && gameSymbol[4] == Symbol.CROSS && gameSymbol[8] == Symbol.CROSS ||
                gameSymbol[2] == Symbol.CROSS && gameSymbol[4] == Symbol.CROSS && gameSymbol[6] == Symbol.CROSS) {

            playerTwoScoreCount();
            myMVPView.finishGame(Winner.WIN_CROSS);

        } else if (roundCount == 9) {
            playAgain();
            myMVPView.returnStart();

        } else {
            activePlayer = !activePlayer;
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
        return playerTwoScoreCount;
    }

    @Override
    public void playAgain() {
        activePlayer = true;
        roundCount = 0;
        myMVPView.returnStart();
        for (int i = 0; i < 9; i++) {
            gameSymbol[i] = Symbol.EMPTY;
        }
    }

    @Override
    public void clearOneScoreCount() {
        playerOneScoreCount = 0;

    }

    @Override
    public void clearTwoScoreCount() {
        playerOneScoreCount = 0;
    }
}
