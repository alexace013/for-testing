package calcFigure;

import calcFigure.window.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
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

        /*
        * create Tooltip - box
        * tooltip - used to display hints
        * */
        Tooltip tooltipBox = new Tooltip();
        tooltipBox.setText("volume calculation box");
        tooltipBox.setFont(Font.font("Arial", FontWeight.NORMAL, 10));

        // create Button - box
        Button buttonBox = new Button("Box");
        buttonBox.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 11));
        buttonBox.setPrefSize(80, 20);
        buttonBox.setTooltip(tooltipBox);

        // create Tooltip - cube
        Tooltip tooltipCube = new Tooltip();
        tooltipCube.setText("volume calculation cube");
        tooltipCube.setFont(Font.font("Arial", FontWeight.NORMAL, 10));

        // create Button - cube
        Button buttonCube = new Button("Cube");
        buttonCube.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 11));
        buttonCube.setPrefSize(80, 20);
        buttonCube.setTooltip(tooltipCube);

        // create Tooltip - circle
        Tooltip tooltipCircle = new Tooltip();
        tooltipCircle.setText("volume calculation circle");
        tooltipCircle.setFont(Font.font("Arial", FontWeight.NORMAL, 10));

        // create Button - circle
        Button buttonCircle = new Button("Circle");
        buttonCircle.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 11));
        buttonCircle.setPrefSize(80, 20);
        buttonCircle.setTooltip(tooltipCircle);

        // create Tooltip - cylinder
        Tooltip tooltipCylinder = new Tooltip();
        tooltipCylinder.setText("volume calculation cylinder");
        tooltipCylinder.setFont(Font.font("Arial", FontWeight.NORMAL, 10));

        // create Button - cylinder
        Button buttonCylinder = new Button("Cylinder");
        buttonCylinder.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 11));
        buttonCylinder.setPrefSize(80, 20);
        buttonCylinder.setTooltip(tooltipCylinder);

        // create Tooltip - pyramid
        Tooltip tooltipPyramid = new Tooltip();
        tooltipPyramid.setText("volume calculation pyramid");
        tooltipPyramid.setFont(Font.font("Arial", FontWeight.NORMAL, 10));

        // create Button - pyramid
        Button buttonPyramid = new Button("Pyramid");
        buttonPyramid.setFont(Font.font("Arial", FontWeight.SEMI_BOLD, 11));
        buttonPyramid.setPrefSize(80, 20);
        buttonPyramid.setTooltip(tooltipPyramid);

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

        // action that will be processed by pressing the button "CUBE"
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

        // action that will be processed by pressing the button "CIRCLE"
        buttonCircle.setOnAction(new EventHandler<ActionEvent>() {
                                     @Override
                                     public void handle(ActionEvent event) {
                                         // create window for circle
                                         WindowCircle windowCircle = new WindowCircle();
                                         Stage stageCircle = new Stage();
                                         try {
                                             windowCircle.start(stageCircle);
                                         } catch (Exception e) {
                                             e.printStackTrace();
                                         } finally {
                                             stage.close();
                                         }
                                     }
                                 }

        );

        // action that will be processed by pressing the button "CYLINDER"
        buttonCylinder.setOnAction(new EventHandler<ActionEvent>() {
                                       @Override
                                       public void handle(ActionEvent event) {
                                           // create window for cylinder
                                           WindowCylinder windowCylinder = new WindowCylinder();
                                           Stage stageCylinder = new Stage();
                                           try {
                                               windowCylinder.start(stageCylinder);
                                           } catch (Exception e) {
                                               e.printStackTrace();
                                           } finally {
                                               stage.close();
                                           }
                                       }
                                   }

        );

        // action that will be processed by pressing the button "PYRAMID"
        buttonPyramid.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // create window for pyramid
                WindowPyramid windowPyramid = new WindowPyramid();
                Stage stagePyramid = new Stage();
                try {
                    windowPyramid.start(stagePyramid);
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
