package calcFigure;

import calcFigure.window.WindowBox;
import calcFigure.window.WindowCube;
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
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author created by Alexander Bakhin.
 * @version 1.01
 */
public class CalcFigureMainFX extends Application {

    @Override
    public void start(final Stage stage) throws Exception {

        stage.setTitle("Calculation of figures");

        // create GridPane
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setHgap(10.0d);
        gridPane.setVgap(10.0d);
        gridPane.setPadding(new Insets(15.0d, 15.0d, 15.0d, 15.0d));

        // create Text
        Text text = new Text();
        text.setText("\tPlease, select the desired shape.");
        text.setFont(Font.font("ComicSans", FontWeight.NORMAL, 12));
        gridPane.add(text, 0, 1);

        // create first HBox for accommodation buttons (box, cube, circle)
        HBox hBox = new HBox(7.5d);
        hBox.setAlignment(Pos.CENTER);

        // create second HBox for accommodation buttons (cylinder, pyramid)
        HBox hBox2 = new HBox(7.5d);
        hBox2.setAlignment(Pos.CENTER);

        // create Button - box
        Button buttonBox = new Button("Box");
        buttonBox.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 11));
        buttonBox.setPrefSize(80, 20);

        // create Button - cube
        Button buttonCube = new Button("Cube");
        buttonCube.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 11));
        buttonCube.setPrefSize(80, 20);

        // create Button - circle
        Button buttonCircle = new Button("Circle");
        buttonCircle.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 11));
        buttonCircle.setPrefSize(80, 20);

        // create Button - cylinder
        Button buttonCylinder = new Button("Cylinder");
        buttonCylinder.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 11));
        buttonCylinder.setPrefSize(80, 20);

        // create Button - pyramid
        Button buttonPyramid = new Button("Pyramid");
        buttonPyramid.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 10));
        buttonPyramid.setPrefSize(80, 20);

        // add buttons (box, cube & circle) in hBox
        hBox.getChildren().add(buttonBox);
        hBox.getChildren().add(buttonCube);
        hBox.getChildren().add(buttonCircle);
        // add buttons (cylinder & pyramid) in hBox2
        hBox2.getChildren().add(buttonCylinder);
        hBox2.getChildren().add(buttonPyramid);

        // add hBox & hBox2 in gridPane
        gridPane.add(hBox, 0, 2);
        gridPane.add(hBox2, 0, 3);

        // action that will be processed by pressing the button "BOX"
        buttonBox.setOnAction(new EventHandler<ActionEvent>() {
                                  @Override
                                  public void handle(ActionEvent event) {
                                      // create window for box
                                      WindowBox windowBox = new WindowBox();
                                      Stage stageBox = new Stage();
                                      try {
                                          windowBox.start(stageBox);
                                      } catch (Exception e) {
                                          e.printStackTrace();
                                      } finally {
                                          stage.close();
                                      }
                                  }
                              }

        );

        buttonCube.setOnAction(new EventHandler<ActionEvent>() {
                                   @Override
                                   public void handle(ActionEvent event) {
                                       // create window for cube
                                       WindowCube windowCube = new WindowCube();
                                       Stage stageCube = new Stage();
                                       try {
                                           windowCube.start(stageCube);
                                       } catch (Exception e) {
                                           e.printStackTrace();
                                       } finally {
                                           stage.close();
                                       }
                                   }
                               }

        );

        // create Scene and setting
        Scene scene = new Scene(gridPane, 300, 125);
        stage.setScene(scene);
        stage.show();


    }
}
