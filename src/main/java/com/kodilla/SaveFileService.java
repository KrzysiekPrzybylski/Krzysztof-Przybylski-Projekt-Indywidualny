package com.kodilla;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class SaveFileService implements Serializable {

    private static final File file = new File("save.txt");
    private static final Map<String, Integer> map = new HashMap<>();


    public static void save(int roundNumber, int playerPoints, int computerPoints) {
        map.put("round number",roundNumber);
        map.put("player points",playerPoints);
        map.put("computer points",computerPoints);
        GameStatus gameStatus = new GameStatus(roundNumber, playerPoints, computerPoints);

        try {
            ObjectOutputStream oos = new ObjectOutputStream (new FileOutputStream(file));
            oos.writeObject(gameStatus);
            oos.close();
        } catch (Exception e) {
            // obsługa błędów
        }
    }

    public static GameStatus load(File file) {
        GameStatus gameStatus = null;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            gameStatus = (GameStatus)ois.readObject();
            System.out.println(gameStatus);
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return gameStatus;
    }
}
