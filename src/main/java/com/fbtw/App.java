package com.fbtw;



import com.fbtw.core.DataParser;
import com.fbtw.io.PreSet;
import com.fbtw.io.PreSetLoader;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;


/**
 * Hello world!
 *
 */
public class App extends Application {
    public static final int TIMEOUT = 70;

   /* public static void main(String[] args) throws InterruptedException, IOException, ClassNotFoundException {


        PreSetLoader loader = new PreSetLoader();
       // PreSet set =  loader.readPreSet(args[0]+".preset");
        PreSet set =  loader.readPreSet("пятница"+".preset");
        DataParser parser = new DataParser(set);

        parser.parse();
        System.exit(0);

    }*/
   @Override
   public void start(Stage primaryStage) throws Exception{
       GridPane mainLayout = new GridPane();
       mainLayout.getColumnConstraints().add(0,new ColumnConstraints(300));
       mainLayout.getColumnConstraints().add(1,new ColumnConstraints(300));
       mainLayout.getColumnConstraints().add(2,new ColumnConstraints(300));
       mainLayout.setAlignment(Pos.TOP_CENTER);



       Label label = new Label("Создание отчета");
       label.setFont(Font.font("Arial", FontWeight.BOLD,70));
       label.setAlignment(Pos.CENTER);
       label.setMaxWidth(Double.MAX_VALUE);
       label.setMaxHeight(20);

       CheckBox checkBox = new CheckBox("режим эксперта");


       ObservableList<String> presets = FXCollections.observableArrayList(getPreSetNames());
       ListView<String> fastStartBooks = new ListView<>(presets);
       fastStartBooks.getSelectionModel().select(0);



       Label chouse = new Label("Выбирите отчет");
       chouse.setFont(Font.font("Arial", FontWeight.BOLD,20));


       VBox fragment = new VBox(20,chouse,fastStartBooks);
       fragment.setAlignment(Pos.CENTER);

       Button createBtn = new Button("СОЗДАТЬ");
       createBtn.setMaxSize(200,50);
       GridPane.setHalignment(createBtn, HPos.CENTER);

       createBtn.setOnAction((event -> {
           PreSetLoader loader = new PreSetLoader();
           // PreSet set =  loader.readPreSet(args[0]+".preset");
           PreSet set = null;
           try {
               set = loader.readPreSet(presets.get(fastStartBooks.getSelectionModel().getSelectedIndex()));
           } catch (IOException | ClassNotFoundException e) {
               e.printStackTrace();
           }
           DataParser parser = new DataParser(set);

           try {
               parser.parse();
           } catch (IOException | InterruptedException e) {
               e.printStackTrace();
           }
           System.exit(0);
       }));


       mainLayout.add(label,0,0,3,1);
       GridPane.setHgrow(label, Priority.ALWAYS);
       mainLayout.add(checkBox,2,5);

       mainLayout.add(fragment,0,2,3,3);
       mainLayout.add(createBtn,1,5);



       /* GridPane altLayout = new GridPane();

        Label name = new Label("НАЗВАНИЕ:");
        name.setMaxSize(,Double.MAX_VALUE);

        GridPane.setVgrow();
        TextField field = new TextField();


        checkBox.setOnAction(event -> {
            if(checkBox.isSelected()){
                fragment.setVisible(false);
            }else{
                fragment.setVisible(true);
            }
        });*/

       Scene scene = new Scene(mainLayout,900,600);
       primaryStage.setResizable(false);
       primaryStage.setScene(scene);
       primaryStage.show();
   }


    public static void main(String[] args) {
        System.setProperty("Dfile.encoding","UTF-8");
        launch(args);
    }
    public static String[] getPreSetNames(){
        File folder = new File(".");

        return folder.list((folder1, name) -> name.endsWith(".preset"));
    }




}
