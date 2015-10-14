package calcFigure.window;

import calcFigure.CalcFigureMainFX;
import calcFigure.figure.Cube;
import calcFigure.inputNumber.InputConstrains;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by alexander on 14.10.15.
 */
public class WindowCube extends Application {

    private Cube cube = new Cube();

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Cube");

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setHgap(10.0d);
        gridPane.setVgap(10.0d);
        gridPane.setPadding(new Insets(10.0d, 10.0d, 10.0d, 10.0d));

        Text text = new Text("enter cube side: ");
        text.setFont(Font.font("Arial", FontWeight.NORMAL, 11));
        gridPane.add(text, 0, 0);

        TextField textField = new TextField();
        textField.setMaxSize(140, 20);
        textField.setFont(Font.font("Arial", FontWeight.NORMAL, 11));
        InputConstrains.numbersOnly(textField);

        gridPane.add(textField, 1, 0);

        TextArea textArea = new TextArea();
        textArea.setFont(Font.font("Arial", FontWeight.BOLD, 11));
        textArea.setEditable(false);
        textArea.setBackground(Background.EMPTY);
        textArea.setMaxSize(180, 20);

        gridPane.add(textArea, 1, 4);

        HBox hBox = new HBox(7.5d);
        hBox.setAlignment(Pos.CENTER);

        // create Button - back
        Button buttonBack = new Button("<<Back");
        buttonBack.setFont(Font.font("Arial", FontWeight.BOLD, 11));
        buttonBack.setPrefSize(80, 20);

        // create Button - calculation
        Button buttonCalc = new Button("Calculate");
        buttonCalc.setFont(Font.font("Arial", FontWeight.NORMAL, 11));
        buttonCalc.setPrefSize(80, 20);

        // add buttons in hBox
        hBox.getChildren().add(buttonBack);
        hBox.getChildren().add(buttonCalc);

        // add hBox in gridPane
        gridPane.add(hBox, 1, 3);

        buttonCalc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                cube.setHeight(Double.parseDouble(textField.getText()));
                textArea.setText("cube volume = " + String.valueOf(cube.getVolume()));
            }
        });

        buttonBack.setOnAction(new EventHandler<ActionEvent>() {
                                   @Override
                                   public void handle(ActionEvent event) {
                                       CalcFigureMainFX calcFigureMainFX = new CalcFigureMainFX();
                                       Stage stageWindowMain = new Stage();
                                       try {
                                           stage.close();
                                           calcFigureMainFX.start(stageWindowMain);
                                       } catch (Exception e) {
                                           e.printStackTrace();
                                       }
                                   }
                               }

        );


        Scene scene = new Scene(gridPane, 300, 110);
        stage.setScene(scene);
        stage.show();

    }
}
