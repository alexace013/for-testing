package calcFigure.window;

import calcFigure.CalcFigureMainFX;
import calcFigure.figure.Pyramid;
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
import javafx.scene.control.Tooltip;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by alexander on 15.10.15.
 */
public class WindowPyramid extends Application {

    private Pyramid pyramid = new Pyramid();

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Pyramid");

        // create GridPane
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setHgap(10.0d);
        gridPane.setVgap(10.0d);
        gridPane.setPadding(new Insets(10.0d, 10.0d, 10.0d, 10.0d));

        // create Text - text height
        Text textHeight = new Text("enter pyramid height: ");
        textHeight.setFont(Font.font("Arial", FontWeight.NORMAL, 11));

        // create Text - text square
        Text textSquare = new Text("enter pyramid square: ");
        textSquare.setFont(Font.font("Arial", FontWeight.NORMAL, 11));

        // add text elements in gridPane
        gridPane.add(textHeight, 0, 0);
        gridPane.add(textSquare, 0, 1);

        // create Tooltip for textFieldHeight
        Tooltip tooltipHeight = new Tooltip();
        tooltipHeight.setText("height (example: " + (int) (Math.random() * 100) + ")");
        tooltipHeight.setFont(Font.font("Arial", FontWeight.NORMAL, 10));

        // create TextField - height
        TextField textFieldHeight = new TextField();
        textFieldHeight.setMaxSize(140, 20);
        textFieldHeight.setFont(Font.font("Arial", FontWeight.NORMAL, 11));
        textFieldHeight.setTooltip(tooltipHeight);
        InputConstrains.numbersOnly(textFieldHeight);

        // create Tooltip for textFieldSquare
        Tooltip tooltipWidth = new Tooltip();
        tooltipWidth.setText("square (example: " + (int) (Math.random() * 100) + ")");
        tooltipWidth.setFont(Font.font("Arial", FontWeight.NORMAL, 10));

        // create TextField - square
        TextField textFieldSquare = new TextField();
        textFieldSquare.setMaxSize(140, 20);
        textFieldSquare.setFont(Font.font("Arial", FontWeight.NORMAL, 11));
        textFieldSquare.setTooltip(tooltipWidth);
        InputConstrains.numbersOnly(textFieldSquare);

        //add textField elements in gridPane
        gridPane.add(textFieldHeight, 1, 0);
        gridPane.add(textFieldSquare, 1, 1);

        // create Tooltip for textArea
        Tooltip tooltipTextArea = new Tooltip();
        tooltipTextArea.setText("in this fill your can see tips and result.");
        tooltipTextArea.setFont(Font.font("Arial", FontWeight.NORMAL, 10));

        // create TextArea
        TextArea textArea = new TextArea();
        textArea.setFont(Font.font("Arial", FontWeight.BOLD, 11));
        textArea.setEditable(false);
        textArea.setBackground(Background.EMPTY);
        textArea.setMaxSize(220, 20);
        textArea.setTooltip(tooltipTextArea);
        gridPane.add(textArea, 1, 4);

        // create HBox for accommodation buttons
        HBox hBox = new HBox(7.5d);
        hBox.setAlignment(Pos.CENTER);

        // create Tooltip for back button
        Tooltip tooltipBack = new Tooltip();
        tooltipBack.setText("back to main menu");
        tooltipBack.setFont(Font.font("Arial", FontWeight.NORMAL, 10));

        // create Button - back
        Button buttonBack = new Button("<<Back");
        buttonBack.setFont(Font.font("Arial", FontWeight.BOLD, 11));
        buttonBack.setPrefSize(80, 20);
        buttonBack.setTooltip(tooltipBack);

        // create Tooltip for calculate button
        Tooltip tooltipCalc = new Tooltip();
        tooltipCalc.setText("calculate the volume");
        tooltipCalc.setFont(Font.font("Arial", FontWeight.NORMAL, 10));

        // create Button - calculation
        Button buttonCalc = new Button("Calculate");
        buttonCalc.setFont(Font.font("Arial", FontWeight.NORMAL, 11));
        buttonCalc.setPrefSize(80, 20);
        buttonCalc.setTooltip(tooltipCalc);

        // add buttons in hBox
        hBox.getChildren().add(buttonBack);
        hBox.getChildren().add(buttonCalc);

        // add hBox in gridPane
        gridPane.add(hBox, 1, 3);

        buttonCalc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (textFieldHeight.getText().isEmpty() && textFieldSquare.getText().isEmpty()) {
                    textArea.setText("please, fill in height & square.");
                } else {
                    pyramid.setHeight(Double.parseDouble(textFieldHeight.getText()));
                    pyramid.setWidth(Double.parseDouble(textFieldSquare.getText()));
                    // formatting value to display two decimal places
                    String formatted = String.format("%.2f", pyramid.getVolume());
                    textArea.setText("pyramid volume = " + formatted);
                }
            }
        });

        buttonBack.setOnAction(new EventHandler<ActionEvent>() {
                                   @Override
                                   public void handle(ActionEvent event) {
                                       // create main window
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


        // create Scene and setting
        Scene scene = new Scene(gridPane, 350, 160);
        stage.setScene(scene);
        stage.show();

    }
}
