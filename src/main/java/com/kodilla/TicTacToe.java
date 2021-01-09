package com.kodilla;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static com.kodilla.Controller.whoFirst;
import static com.kodilla.MainScene.buildMainScene;
import static com.kodilla.StartMenu.*;


public class TicTacToe extends Application{

    public static GameStatus gameStatus = new GameStatus();
    public static Stage primaryStageClone;

    public static Scene startScene = new Scene(getStartGrid(), 700, 400, Color.WHITE);


    public static void main (String[] args){
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {


        gameStatus.setRoundNumber(1);
        gameStatus.setPlayerScore(0);
        gameStatus.setComputerScore(0);

        primaryStage.setTitle("Tic tac toe");
        primaryStage.setScene(startScene);
        primaryStage.show();

        startButton.setOnAction((e) ->{
            primaryStage.setScene(buildMainScene());
            whoFirst();
        });
        primaryStageClone = primaryStage;
    }



}