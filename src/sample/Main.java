package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.TextField;


import java.awt.*;

public class Main extends Application {

    Stage window;
    TableView<Persona> table;
    TextField nameInput, deathInput, ageInput;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("ColombianRiot");

        //Name Column
        TableColumn<Persona, String> nameColumn= new TableColumn<>("nombre");
        nameColumn.setMinWidth(200);
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));


        //Death Column
        TableColumn<Persona, String> deathColumn= new TableColumn<>("causa de muerte");
        deathColumn.setMinWidth(300);
        deathColumn.setCellValueFactory(new PropertyValueFactory<>("death"));

        //Age Column
        TableColumn<Persona, Double> ageColumn= new TableColumn<>("edad");
        ageColumn.setMinWidth(50);
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        // Name input
        nameInput = new TextField();
        nameInput.setPromptText("nombre");
        nameInput.setMinWidth(100);

        // Death input
        deathInput= new TextField();
        deathInput.setPromptText("muerte");
        deathInput.setMinWidth(200);

        // Age input
        ageInput = new TextField();
        ageInput.setPromptText("edad");
        ageInput.setMinWidth(50);

        //button
        Button addButton = new Button ("Agregar");
        addButton.setOnAction(e -> addButtonClicked());
        Button deleteButton = new Button ("Eliminar");
        deleteButton.setOnAction(e->deleteButtonClicked());



        //addButton.setOnAction(e -> deleteButtonClicked());



        HBox hBox = new HBox ();
        hBox.setPadding(new Insets(10,10,10,10));
        hBox.setSpacing(10);
        hBox.getChildren().addAll(nameInput, deathInput, ageInput, addButton, deleteButton);


        table = new TableView<>();
        table.setItems(getPersona());
        table.getColumns().addAll(nameColumn, deathColumn, ageColumn);

        VBox vBox = new VBox();
        vBox.getChildren().addAll(table, hBox);

        Scene scene = new Scene (vBox);
        window.setScene(scene);
        window.show();

    }

    // Add button clicked
    public void addButtonClicked(){
        Persona persona = new Persona();
        persona.setName(nameInput.getText());
        persona.setDeath(deathInput.getText());
        persona.setAge(Double.parseDouble(ageInput.getText()));
        table.getItems().add(persona);
        nameInput.clear();
        deathInput.clear();
        ageInput.clear();

    }

    public void deleteButtonClicked(){
      ObservableList<Persona> personaSelected, allPersonas;
        allPersonas = table.getItems();
        personaSelected = table.getSelectionModel().getSelectedItems();

        personaSelected.forEach(allPersonas::remove);
   }




    //Get ALL People
    public ObservableList<Persona> getPersona() {
        ObservableList<Persona> personas = FXCollections.observableArrayList();
        personas.add(new Persona("Julian", "gas lacrimogeno",20));
        personas.add(new Persona("Miguel", "perdida de ojo",27));
        personas.add(new Persona("Juan", "disparo",23));
        personas.add(new Persona("Sebastian", "caida",28));
        personas.add(new Persona("Pablo", "gas lacrimogeno",26));
        personas.add(new Persona("Julian", "gas lacrimogeno",29));
        personas.add(new Persona("Maria", "Abuso Policial",33));
        personas.add(new Persona("Juliana", "choque de automovil",50));
        personas.add(new Persona("Jose", "gas lacrimogeno",19));
        return personas;
    }

    private void setUpMenu(){

    }



}


