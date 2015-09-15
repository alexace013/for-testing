package calculationFacilities;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * Created by alexander on 14.09.15.
 */
public class CalcFacilitiesMainApp extends Application {

    private static final double BUTTON_HEIGHT = 85.0d;
    private static final double BUTTON_LENGTH = 15.0d;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {

        //  установка имени заголовка
        stage.setTitle("Вычисление фигур");

        //
        GridPane mainGridPane = new GridPane();

        /*
        *   mainText - текст, который должен отображаться на главном окне
        * */
        Text mainText = new Text("Сделайте свой выбор.\nКакую фигуру вы хотите рассчитать?");
        mainText.setFont(Font.font("SansSerif", FontWeight.EXTRA_BOLD, 12));

        //  создание кнопок выбора

        /*
        *   buttonBox - создание кнопки для "коробки"
        * */
        Button buttonBox = new Button("Коробка");
        buttonBox.setFont(Font.font("SansSerif", FontPosture.ITALIC, 12));
        buttonBox.setPrefSize(BUTTON_HEIGHT, BUTTON_LENGTH);
        buttonBox.setOnAction(new EventHandler<ActionEvent>() { // установка логики на buttonBox
            @Override
            public void handle(ActionEvent event) {

            }
        });

        /*
        *   buttonCircle - создание кнопки для "сферы"
        * */
        Button buttonCircle = new Button("Сфера");
        buttonCircle.setFont(Font.font("SansSerif", FontPosture.ITALIC, 12));
        buttonCircle.setPrefSize(BUTTON_HEIGHT, BUTTON_LENGTH);

        /*
        *   buttonCylinder - создание кнопки для "цилиндра"
        * */
        Button buttonCylinder= new Button("Цилиндр");
        buttonCylinder.setFont(Font.font("SansSerif", FontPosture.ITALIC, 12));
        buttonCylinder.setPrefSize(BUTTON_HEIGHT, BUTTON_LENGTH);

        /*
        *   buttonPyramid - создание кнопки для "пирамиды"
        * */
        Button buttonPyramid = new Button("Пирамида");
        buttonPyramid.setFont(Font.font("SansSerif", FontPosture.ITALIC, 12));
        buttonPyramid.setPrefSize(BUTTON_HEIGHT, BUTTON_LENGTH);



        HBox hBox = new HBox(10.0d);
        hBox.getChildren().add(buttonBox);
        hBox.getChildren().add(buttonCircle);
        hBox.getChildren().add(buttonCylinder);
        hBox.getChildren().add(buttonPyramid);
        hBox.setAlignment(Pos.CENTER);




        mainGridPane.add(mainText, 3, 0);
        mainGridPane.add(hBox, 3, 4);
        mainGridPane.setPadding(new Insets(10, 0, 0, 35));

        Scene scene = new Scene(mainGridPane, 430.0d, 80.0d);
        stage.setScene(scene);
        stage.show();

    }
}
