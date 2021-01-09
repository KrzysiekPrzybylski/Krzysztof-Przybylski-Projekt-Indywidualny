package com.kodilla;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static com.kodilla.FencingFloorGrid.*;
import static com.kodilla.MainScene.buildMainScene;
import static com.kodilla.StartMenu.*;
import static com.kodilla.TicTacToe.*;
import static javafx.application.Platform.exit;

import javafx.stage.Stage;

public class Controller implements EnterSymbol{

    public static void whoFirst(){
        Random random = new Random();
        int lot = random.nextInt(2);
        if(lot%2==0){
            EnterSymbol.drawComputerSymbol(symbolsGroup.getSelectedToggle());
        }
    }

    public static void roundWinner(int h) {

        Text message = new Text();

        if (h == Symbol.CROSS.number && symbolsGroup.getSelectedToggle().equals(crossRadio)) {
            message.setText("Congratulation! You won the round.");
            gameStatus.pointForPlayer();
        }
        else if (h == Symbol.CIRCLE.number && symbolsGroup.getSelectedToggle().equals(circleRadio)) {
            message.setText("Congratulation! You won the round.");
            gameStatus.pointForPlayer();
        }
        else{
            message.setText("Sorry, you lost the round.");
            gameStatus.pointForComputer();
        }

        gameStatus.increseRoundNumber();

        if(!checkFinalWin()) {

            message.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 20));
            Button buttonNextRound = new Button("Next round");

            GridPane g = new GridPane();
            g.setAlignment(Pos.CENTER);
            g.setPadding(new Insets(5, 5, 5, 5));
            g.add(message, 1, 1);
            g.add(buttonNextRound, 2, 2);
            g.setHgap(5);
            g.setVgap(5);
            Scene sc = new Scene(g, 800, 70, Color.WHITE);
            Stage stageWin = new Stage();
            stageWin.setScene(sc);
            stageWin.show();

            buttonNextRound.setOnAction((e) -> {
                clearMainScene();
                primaryStageClone.setScene(buildMainScene());
                stageWin.close();
            });
        }
    }


    public static boolean checkRoundWin(){
        boolean check = false;
        //PION
        if (stackPaneHashMap.get(stackPane1)==stackPaneHashMap.get(stackPane4) &&
                stackPaneHashMap.get(stackPane4)==(stackPaneHashMap.get(stackPane7)) && stackPaneHashMap.get(stackPane1)!=0){
            roundWinner(stackPaneHashMap.get(stackPane1));
            check=true;
        }
        else if((stackPaneHashMap.get(stackPane2)==(stackPaneHashMap.get(stackPane5)) &&
                stackPaneHashMap.get(stackPane5)==(stackPaneHashMap.get(stackPane8))) && stackPaneHashMap.get(stackPane8)!=0){
            roundWinner(stackPaneHashMap.get(stackPane8));
            check=true;
        }
        else if((stackPaneHashMap.get(stackPane3)==(stackPaneHashMap.get(stackPane6)) &&
                stackPaneHashMap.get(stackPane9)==(stackPaneHashMap.get(stackPane6))) && stackPaneHashMap.get(stackPane6)!=0){
            roundWinner(stackPaneHashMap.get(stackPane6));
            check=true;
        }
        //POZIOM
        else if((stackPaneHashMap.get(stackPane1)==(stackPaneHashMap.get(stackPane2)) &&
                stackPaneHashMap.get(stackPane2)==(stackPaneHashMap.get(stackPane3))) && stackPaneHashMap.get(stackPane3)!=0){
            roundWinner(stackPaneHashMap.get(stackPane3));
            check=true;
        }
        else if((stackPaneHashMap.get(stackPane4)==(stackPaneHashMap.get(stackPane5)) &&
                stackPaneHashMap.get(stackPane5)==(stackPaneHashMap.get(stackPane6)))&& stackPaneHashMap.get(stackPane6)!=0){
            roundWinner(stackPaneHashMap.get(stackPane6));
            check=true;
        }
        else if((stackPaneHashMap.get(stackPane7)==(stackPaneHashMap.get(stackPane8)) &&
                stackPaneHashMap.get(stackPane8)==(stackPaneHashMap.get(stackPane9))) && stackPaneHashMap.get(stackPane9)!=0){
            roundWinner(stackPaneHashMap.get(stackPane9));
            check=true;
        }
        //SKOS
        else if((stackPaneHashMap.get(stackPane1)==(stackPaneHashMap.get(stackPane9)) &&
                stackPaneHashMap.get(stackPane9)==(stackPaneHashMap.get(stackPane5)))&& stackPaneHashMap.get(stackPane5)!=0){
            roundWinner(stackPaneHashMap.get(stackPane5));
            check=true;
        }
        else if((stackPaneHashMap.get(stackPane3)==(stackPaneHashMap.get(stackPane5)) &&
                stackPaneHashMap.get(stackPane5)==(stackPaneHashMap.get(stackPane7)))&& stackPaneHashMap.get(stackPane7)!=0){
            roundWinner(stackPaneHashMap.get(stackPane7));
            check=true;
        }
        return check;
    }


    public static StackPane convertion(Object o) {
        if(o instanceof StackPane) {
            final StackPane stackPane = (StackPane) o;
            return stackPane;
        }
        throw new IllegalArgumentException();
    }

    public static void clearMainScene(){

        stackPaneHashMap.put(stackPane1, Symbol.EMPTY.number);
        stackPaneHashMap.put(stackPane2, Symbol.EMPTY.number);
        stackPaneHashMap.put(stackPane3, Symbol.EMPTY.number);
        stackPaneHashMap.put(stackPane4, Symbol.EMPTY.number);
        stackPaneHashMap.put(stackPane5, Symbol.EMPTY.number);
        stackPaneHashMap.put(stackPane6, Symbol.EMPTY.number);
        stackPaneHashMap.put(stackPane7, Symbol.EMPTY.number);
        stackPaneHashMap.put(stackPane8, Symbol.EMPTY.number);
        stackPaneHashMap.put(stackPane9, Symbol.EMPTY.number);

        for(Map.Entry<StackPane, Integer> entry: stackPaneHashMap.entrySet()){
            entry.getKey().getChildren().remove(1,entry.getKey().getChildren().size());
        }
    }

    public static boolean checkFinalWin(){


        if(gameStatus.isThereFinalWin()) {

            Text message1 = new Text();
            Text message2 = new Text();
            message1.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 40));
            message2.setFont(Font.font("verdana", FontWeight.EXTRA_BOLD, FontPosture.REGULAR, 40));
            Button buttonPlayNewGame = new Button("Start new game");
            Button buttonQuit = new Button("Quit");

            GridPane g = new GridPane();
            g.setAlignment(Pos.CENTER);
            g.setPadding(new Insets(5, 5, 5, 5));
            g.add(message1, 2, 1);
            g.add(message2, 2, 2);
            g.add(buttonPlayNewGame, 2, 3);
            g.add(buttonQuit, 3, 3);
            g.setHgap(2);
            g.setVgap(20);

            buttonQuit.setOnAction((e) -> {
                exit();
            });

            if (gameStatus.getPlayerScore() == 5) {
                message1.setText("Congratulation!");
                message2.setText("You won the game.");
            }
            else{
                message1.setText("Sorry!");
                message2.setText("You lost the game.");
            }

            Scene sc = new Scene(g, 750, 400, Color.BLACK);
            Stage stageWin = new Stage();
            stageWin.setScene(sc);
            stageWin.show();

            buttonPlayNewGame.setOnAction((e) -> {
                clearMainScene();
                gameStatus.clearGameStatus();
                primaryStageClone.setScene(buildMainScene());
                stageWin.close();

            });

            return true;
        }

        return false;
    }


    public static EventHandler<MouseEvent> clickOnBox = new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent e) {

            if (stackPaneHashMap.get(convertion(e.getSource())) == Symbol.EMPTY.number) {

                if(symbolsGroup.getSelectedToggle().equals(crossRadio)){
                    EnterSymbol.putCross(convertion(e.getSource()));
                }
                else{
                    EnterSymbol.putCircle(convertion(e.getSource()));
                }
            }

            boolean check= checkRoundWin();

            if(!(check)) {
                EnterSymbol.drawComputerSymbol(symbolsGroup.getSelectedToggle());
                checkRoundWin();
            }
        }
    };

}
