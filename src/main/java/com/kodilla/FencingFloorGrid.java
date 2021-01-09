package com.kodilla;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;

import java.util.HashMap;
import java.util.Map;

import static com.kodilla.Controller.clickOnBox;

public class FencingFloorGrid {

    private FencingFloorGrid() {
    }

    public static HashMap<StackPane, Integer> stackPaneHashMap = new HashMap<StackPane, Integer>();

    private static Image sp1 = new Image("file:src/main/resources/sp1.png", 155, 155, true, false);
    private static Image sp2 = new Image("file:src/main/resources/sp2.png", 155, 155, true, false);
    private static Image sp3 = new Image("file:src/main/resources/sp3.png", 155, 155, true, false);
    private static Image sp4 = new Image("file:src/main/resources/sp4.png", 155, 155, true, false);
    private static Image sp5 = new Image("file:src/main/resources/sp5.png", 155, 155, true, false);
    private static Image sp6 = new Image("file:src/main/resources/sp6.png", 155, 155, true, false);
    private static Image sp7 = new Image("file:src/main/resources/sp7.png", 155, 155, true, false);
    private static Image sp8 = new Image("file:src/main/resources/sp8.png", 155, 155, true, false);
    private static Image sp9 = new Image("file:src/main/resources/sp9.png", 155, 155, true, false);

    static StackPane stackPane1 = new StackPane(new ImageView(sp1));
    static StackPane stackPane2 = new StackPane(new ImageView(sp2));
    static StackPane stackPane3 = new StackPane(new ImageView(sp3));
    static StackPane stackPane4 = new StackPane(new ImageView(sp4));
    static StackPane stackPane5 = new StackPane(new ImageView(sp5));
    static StackPane stackPane6 = new StackPane(new ImageView(sp6));
    static StackPane stackPane7 = new StackPane(new ImageView(sp7));
    static StackPane stackPane8 = new StackPane(new ImageView(sp8));
    static StackPane stackPane9 = new StackPane(new ImageView(sp9));



    static {

        stackPaneHashMap.put(stackPane1, Symbol.EMPTY.number);
        stackPaneHashMap.put(stackPane2, Symbol.EMPTY.number);
        stackPaneHashMap.put(stackPane3, Symbol.EMPTY.number);
        stackPaneHashMap.put(stackPane4, Symbol.EMPTY.number);
        stackPaneHashMap.put(stackPane5, Symbol.EMPTY.number);
        stackPaneHashMap.put(stackPane6, Symbol.EMPTY.number);
        stackPaneHashMap.put(stackPane7, Symbol.EMPTY.number);
        stackPaneHashMap.put(stackPane8, Symbol.EMPTY.number);
        stackPaneHashMap.put(stackPane9, Symbol.EMPTY.number);

        for (Map.Entry<StackPane, Integer> entry : stackPaneHashMap.entrySet()) {
            entry.getKey().addEventHandler(MouseEvent.MOUSE_CLICKED, clickOnBox);
        }
    }

    public static GridPane getFencingFloorGrid() {
        Image image = new Image("file:src/main/resources/background.png");

        BackgroundSize backgroundSize = new BackgroundSize(670, 670, false, false, false, false);
        BackgroundImage backgroundImage = new BackgroundImage(image, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        GridPane grid = new GridPane();
        grid.setBackground(background);
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(32, 100, 63, 70));
        grid.setHgap(20);
        grid.setVgap(18);

        grid.add(stackPane1, 1, 1);
        grid.add(stackPane2, 2, 1);
        grid.add(stackPane3, 3, 1);
        grid.add(stackPane4, 1, 2);
        grid.add(stackPane5, 2, 2);
        grid.add(stackPane6, 3, 2);
        grid.add(stackPane7, 1, 3);
        grid.add(stackPane8, 2, 3);
        grid.add(stackPane9, 3, 3);

        return grid;
    }

}