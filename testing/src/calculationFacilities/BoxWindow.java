package calculationFacilities;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.awt.*;

/**
 * Created by alexander on 15.09.15.
 */

/*
*   Окно для ввода данных для объекта "Коробка"
* */

public class BoxWindow extends Application{
    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Коробка");

        GridPane gridPaneBox = new GridPane();

        TextField textFieldHeight = new TextField();
        textFieldHeight.setText("введите высоту коробки");


        TextField textFieldWidth = new TextField();
        textFieldWidth.setText("введите ширину коробки");

        TextField textFieldDepth = new TextField();
        textFieldDepth.setText("введите глубину коробки");


        Box box = new Box();



        Scene scene = new Scene(gridPaneBox);

    }
}
