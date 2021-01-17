package com.kodilla;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.io.File;

import static com.kodilla.StartMenu.*;
import static com.kodilla.TicTacToe.*;

public class SummaryGrid {

    private static Text round;
    private static Text score;
    private static Text player;
    private static Text computer;
    private static Button saveButton = new Button("Save");
    private static Button loadButton = new Button("Load");
    private static File file = new File("save.txt");

    public static GridPane getSummaryGrid() {

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER_LEFT);
        grid.setPadding(new Insets(20, 10, 10, 10));
        grid.setHgap(5);
        grid.setVgap(10);

        round = new Text("Round " + gameStatus.getRoundNumber());
        round.setFont(Font.font("Geneva", 22));
        score = new Text("Score");
        player = new Text();
        computer = new Text("Computer: " + gameStatus.getComputerScore());
        playerInfo();

        grid.add(round, 1, 1);
        grid.add(score, 1, 2);
        grid.add(player, 1, 3);
        grid.add(computer, 1, 4);

        saveButton.setOnMouseClicked(event -> {
            SaveFileService.save(gameStatus.getRoundNumber(), gameStatus.getPlayerScore(), gameStatus.getComputerScore());
        });
        loadButton.setOnMouseClicked(event -> {
            GameStatus gameStatusSaved = SaveFileService.load(file);
            gameStatus.setRoundNumber(gameStatusSaved.getRoundNumber());
            gameStatus.setComputerScore(gameStatusSaved.getComputerScore());
            gameStatus.setPlayerScore(gameStatusSaved.getPlayerScore());
            playerInfo();
            computer.setText("Computer: " + gameStatus.getComputerScore());
            round.setText("Round " + gameStatus.getRoundNumber());
        });

        grid.add(saveButton, 2, 1);
        grid.add(loadButton, 3, 1);

        return grid;
    }

    public static void playerInfo() {
        if (textFieldName.getText().equals("")) {
            player.setText("You: " + gameStatus.getPlayerScore());
        } else {
            player.setText(textFieldName.getText() + ": " + gameStatus.getPlayerScore());
        }
    }


}