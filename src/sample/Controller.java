package sample;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import static sample.Arrays.*;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField countOfPlayers;

    @FXML
    private TextField pathToFiles;

    @FXML
    private Button buttonGenerate;

    static String finalPath;

    @FXML
    void initialize() {

        buttonGenerate.setOnAction(event -> {
            System.out.println("Hello!");
            int count = Integer.parseInt(countOfPlayers.getText());
            finalPath = pathToFiles.getText();
            try {
                fileCreator(count);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
    static ArrayList<String> listOfProfessions = new ArrayList<>();
    static ArrayList<String> listOfAges = new ArrayList<>();
    static ArrayList<String> listOfHealth = new ArrayList<>();
    static ArrayList<String> listOfBaggage = new ArrayList<>();
    static ArrayList<String> listOfPhobias = new ArrayList<>();
    static ArrayList<String> listOfInfo = new ArrayList<>();
    static ArrayList<String> listOfCharacter = new ArrayList<>();
    static ArrayList<String> listOfBody = new ArrayList<>();
    static ArrayList<String> listOfActiveCart1 = new ArrayList<>();
    static ArrayList<String> listOfActiveCart2 = new ArrayList<>();
    static ArrayList<String> listOfBunkerInfoCataclysm = new ArrayList<>();
    static ArrayList<String> listOfBunkerInfoDopInfo = new ArrayList<>();
    static ArrayList<String> listOfBunkerInfoEat = new ArrayList<>();
    static ArrayList<String> listOfBunkerInfoWater = new ArrayList<>();
    static ArrayList<String> listOfBunkerInfoSquare= new ArrayList<>();

    final static int a = 3;
    final static int b = 30;
    final static int d = 1;
    final static int c = 48;

    private static void fileCreator(int countOfPlayers) throws IOException {
        Collections.addAll(listOfProfessions, professions);
        Collections.addAll(listOfAges, ages);
        Collections.addAll(listOfHealth, healths);
        Collections.addAll(listOfBaggage, baggage);
        Collections.addAll(listOfPhobias, phobia);
        Collections.addAll(listOfInfo, info);
        Collections.addAll(listOfCharacter, character);
        Collections.addAll(listOfBody, body);
        Collections.addAll(listOfActiveCart1, activeCart1);
        Collections.addAll(listOfActiveCart2, activeCart2);
        Collections.addAll(listOfBunkerInfoCataclysm, bunkerCharacteristicCataclysm);
        Collections.addAll(listOfBunkerInfoDopInfo, bunkerCharacteristicDopInfo);
        Collections.addAll(listOfBunkerInfoEat, bunkerCharacteristicEat);
        Collections.addAll(listOfBunkerInfoWater, bunkerCharacteristicWater);
        Collections.addAll(listOfBunkerInfoSquare, bunkerCharacteristicSquare);
        Random random = new Random();
        int chanceForPeople = a + (int) (Math.random() * b);
        int timeForLeaving= d + (int) (Math.random() * c);
        String elForBunkerInfoCataclysm = listOfBunkerInfoCataclysm.get(random.nextInt(listOfBunkerInfoCataclysm.size()));
        String elForBunkerInfoEat = listOfBunkerInfoEat.get(random.nextInt(listOfBunkerInfoEat.size()));
        String elForBunkerInfoWater = listOfBunkerInfoWater.get(random.nextInt(listOfBunkerInfoWater.size()));
        String elForBunkerInfoDopInfo = listOfBunkerInfoDopInfo.get(random.nextInt(listOfBunkerInfoDopInfo.size()));
        String elForBunkerInfoSquare = listOfBunkerInfoSquare.get(random.nextInt(listOfBunkerInfoSquare.size()));
        String textForBunkerInfo = "Світ пережив "+elForBunkerInfoCataclysm+" Залишилось "+chanceForPeople+"% людей на землі.\n"+
                "В бункері ви будете жити "+timeForLeaving+" міс. Площа бункера "+elForBunkerInfoSquare+"\n"+
                "В бункері є "+elForBunkerInfoEat+" і "+elForBunkerInfoWater+ " також "+ elForBunkerInfoDopInfo;
        for (int i = 1; i < countOfPlayers+1; i++) {
            int chance = random.nextInt(100);
            String el1 = listOfProfessions.get(random.nextInt(listOfProfessions.size()));
            String el2 = listOfAges.get(random.nextInt(listOfAges.size()));
            String el3 = listOfHealth.get(random.nextInt(listOfHealth.size()));
            String el4 = listOfBaggage.get(random.nextInt(listOfBaggage.size()));
            String el5 = listOfPhobias.get(random.nextInt(listOfPhobias.size()));
            String el6 = listOfInfo.get(random.nextInt(listOfInfo.size()));
            String el7 = listOfCharacter.get(random.nextInt(listOfCharacter.size()));
            String el8 = listOfBody.get(random.nextInt(listOfBody.size()));
            String el9 = listOfActiveCart1.get(random.nextInt(listOfActiveCart1.size()));
            String el10 = listOfActiveCart2.get(random.nextInt(listOfActiveCart2.size()));
            String path = finalPath+"/player_"+i+".txt";
            String res = "Професія: "+el1+"\nВік і стать: "+el2+"\nСтан здоровя: "+el3+" "+chance+"%"+"\nБагаж: "+el4+"\nФобія: "+el5+"\nДоп.Інформація: "+el6+"\nРиса характеру: "+el7+"\nФізичний стан: "+el8+"\n----КАРТИ ДІЇ-----\n"+
                    "1- "+ el9+"\n2- "+el10;
            File f = new File(path);
            if (f.createNewFile())
                System.out.println("File created");
            else
                System.out.println("File already exists");
            appendUsingFileWriter(path,res,textForBunkerInfo);
        }
    }
    private static void appendUsingFileWriter(String filePath, String text1, String text2) {
        File file = new File(filePath);
        FileWriter fr = null;
        try {
            fr = new FileWriter(file, true);
            fr.write(text2+"\t ");
            fr.append('\n');
            fr.append('\n');
            fr.append("---ТВОЇ ХАРАКТЕРИСТИКИ---\n");
            fr.append('\n');
            fr.append(text1);
            fr.append('\n');
            fr.append('\n');
            fr.append("-----ПРАВИЛА------\n");
            fr.append('\n');
            fr.append(Rules);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert fr != null;
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
