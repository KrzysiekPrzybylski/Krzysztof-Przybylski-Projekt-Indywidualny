package com.kodilla;

public class GameStatus {

    public GameStatus() {
    }


    public GameStatus(int roundNumber, int playerScore, int computerScore) {
        this.roundNumber = roundNumber;
        this.playerScore = playerScore;
        this.computerScore = computerScore;
    }

    private int roundNumber;
    private int playerScore;
    private int computerScore;


    public int getRoundNumber() {
        return roundNumber;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public int getComputerScore() {
        return computerScore;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public void setComputerScore(int computerScore) {
        this.computerScore = computerScore;
    }

    public boolean isThereFinalWin(){
        return getPlayerScore()==5 || getComputerScore()==5;
    }

    public void increseRoundNumber(){
        roundNumber = roundNumber+1;
    }

    public void pointForPlayer(){
        playerScore = playerScore+1;
    }

    public void pointForComputer(){
        computerScore = computerScore+1;
    }

    public void clearGameStatus(){
        roundNumber=1;
        playerScore=0;
        computerScore=0;
    }



}
