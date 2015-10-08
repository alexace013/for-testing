package calcFigure.window;

import calcFigure.figure.Box;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by alexander on 08.10.15.
 */
public class WindowBox extends Application {

    private Box box = new Box();

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Box");

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setHgap(10.0d);
        gridPane.setVgap(10.0d);
        gridPane.setPadding(new Insets(10.0d, 10.0d, 10.0d, 10.0d));

        Text textHeight = new Text("enter box height: ");
        textHeight.setFont(Font.font("Arial", FontWeight.NORMAL, 11));

        Text textWidth = new Text("enter box width: ");
        textWidth.setFont(Font.font("Arial", FontWeight.NORMAL, 11));

        Text textDepth = new Text("enter box depth: ");
        textDepth.setFont(Font.font("Arial", FontWeight.NORMAL, 11));

        gridPane.add(textHeight, 0, 0);
        gridPane.add(textWidth, 0, 1);
        gridPane.add(textDepth, 0, 2);

        TextField textFieldHeight = new TextField();
        textFieldHeight.setMaxSize(120, 20);
        textFieldHeight.setFont(Font.font("Arial", FontWeight.NORMAL, 11));

        TextField textFieldWidth = new TextField();
        textFieldWidth.setMaxSize(120, 20);
        textFieldWidth.setFont(Font.font("Arial", FontWeight.NORMAL, 11));

        TextField textFieldDepth = new TextField();
        textFieldDepth.setMaxSize(120, 20);
        textDepth.setFont(Font.font("Arial", FontWeight.NORMAL, 11));

        gridPane.add(textFieldHeight, 1, 0);
        gridPane.add(textFieldWidth, 1, 1);
        gridPane.add(textFieldDepth, 1, 2);

        Scene scene = new Scene(gridPane, 300, 150);
        stage.setScene(scene);
        stage.show();

    }
}
