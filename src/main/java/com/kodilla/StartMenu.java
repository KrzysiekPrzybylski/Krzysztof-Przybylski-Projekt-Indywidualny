package com.kodilla;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class StartMenu {

    private StartMenu() {
    }

    static Text welcomeText = new Text("Welcome in Tic Tac Toe!");
    static Text chooseSymbolText = new Text("What symbol would you like to be?");
    static TextField textFieldName = new TextField();
    static ToggleGroup symbolsGroup = new ToggleGroup();
    static RadioButton crossRadio = new RadioButton("cross");
    static RadioButton circleRadio = new RadioButton("circle");
    static Text nameText = new Text("Type your name: ");
    static Button startButton = new Button("START");


    public static GridPane getStartGrid(){

        DropShadow ds = new DropShadow();
        ds.setOffsetY(2.0f);
        ds.setColor(Color.color(0.4f, 0.4f, 0.7f));
        welcomeText.setEffect(ds);
        welcomeText.setCache(true);
        welcomeText.setFill(Color.HONEYDEW);
        welcomeText.setFont(Font.font(null, FontWeight.EXTRA_BOLD, 48));

        chooseSymbolText.setFont(Font.font("Geneva", 18));

        crossRadio.setToggleGroup(symbolsGroup);
        circleRadio.setToggleGroup(symbolsGroup);
        symbolsGroup.selectToggle(crossRadio);

        nameText.setFont(Font.font("Geneva", 18));

        GridPane startGrid = new GridPane();
        startGrid.setAlignment(Pos.CENTER);
        startGrid.setPadding(new javafx.geometry.Insets(5, 5, 5, 5));
        startGrid.setVgap(20);
        startGrid.setHgap(5);

        startGrid.add(welcomeText, 1, 1);
        startGrid.add(chooseSymbolText, 1, 2);
        startGrid.add(crossRadio, 1, 3);
        startGrid.add(circleRadio, 1, 4);
        startGrid.add(nameText, 1, 5);
        startGrid.add(textFieldName, 1, 6);
        startGrid.add(startButton, 2, 7);

        return startGrid;
    }

}
