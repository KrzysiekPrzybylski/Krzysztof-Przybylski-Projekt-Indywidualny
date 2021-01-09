package com.kodilla;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import static com.kodilla.FencingFloorGrid.getFencingFloorGrid;
import static com.kodilla.SummaryGrid.getSummaryGrid;

public class MainScene {

    public static Scene buildMainScene(){

        GridPane mainGrid = new GridPane();
        mainGrid.setAlignment(Pos.CENTER);
        mainGrid.add(getFencingFloorGrid(), 1, 2);
        mainGrid.add(getSummaryGrid(), 1, 1);
        Scene mainScene = new Scene(mainGrid, 700, 800, Color.WHITE);
        return mainScene;
    }
}