package com.aetherwars;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import com.aetherwars.card.Character.Character;
import com.aetherwars.card.Character.Type;
import com.aetherwars.util.CSVReader;


import com.aetherwars.view.Frame;
//public class AetherWars extends Application {
public class AetherWars{
  private static final String CHARACTER_CSV_FILE_PATH = "card/data/character.csv";
/*
  @Override
  public void start(Stage stage) {
    Text text = new Text();
    text.setText("Loading...");
    text.setX(50);
    text.setY(50);

    Group root = new Group();
    root.getChildren().add(text);

    Scene scene = new Scene(root, 1280, 720);

    stage.setTitle("Minecraft: Aether Wars");
    stage.setScene(scene);
    stage.show();

    try {
      this.loadCards();
      text.setText("Minecraft: Aether Wars!");
    } catch (Exception e) {
      text.setText("Failed to load cards: " + e);
    }
  }
*/
public static void loadCards() throws IOException, URISyntaxException {
  File characterCSVFile = new File(AetherWars.class.getResource(CHARACTER_CSV_FILE_PATH).toURI());
  CSVReader characterReader = new CSVReader(characterCSVFile, "\t");
  characterReader.setSkipHeader(true);
  List<String[]> characterRows = characterReader.read();
  for (String[] row : characterRows) {
    Character c = new Character(Integer.parseInt(row[0]),row[1],Integer.parseInt(row[7]),
            row[3], row[4], Type.valueOf(row[2]),Integer.parseInt(row[5]),Integer.parseInt(row[8]),
            Float.parseFloat(row[6]),Integer.parseInt(row[9]));
    System.out.println(c);
  }
}
  public static void main(String[] args) {
    //launch();
    Frame main_frame = new Frame();
    try {
      AetherWars.loadCards();
    } catch (Exception e) {
      System.out.println("Failed to load cards: " + e);
    }
    main_frame.run();
  }
}
