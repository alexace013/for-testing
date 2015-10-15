package calcFigure.window;

import calcFigure.CalcFigureMainFX;
import calcFigure.figure.Cylinder;
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
public class WindowCylinder extends Application {

    private Cylinder cylinder = new Cylinder();

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Cylinder");

        // create GridPane
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setHgap(10.0d);
        gridPane.setVgap(10.0d);
        gridPane.setPadding(new Insets(10.0d, 10.0d, 10.0d, 10.0d));

        // create Text - diameter
        Text textDiameter = new Text("enter cylinder diameter: ");
        textDiameter.setFont(Font.font("Arial", FontWeight.NORMAL, 11));
        gridPane.add(textDiameter, 0, 0);

        // create Text - height
        Text textHeight = new Text("enter cylinder height: ");
        textHeight.setFont(Font.font("Arial", FontWeight.NORMAL, 11));
        gridPane.add(textHeight, 0, 1);

        // create Tooltip for textFieldDiameter
        Tooltip tooltipDiameter = new Tooltip();
        tooltipDiameter.setText("diameter (example: " + (int) (Math.random() * 100) + ")");
        tooltipDiameter.setFont(Font.font("Arial", FontWeight.NORMAL, 10));

        // create TextField - diameter
        TextField textFieldDiameter = new TextField();
        textFieldDiameter.setMaxSize(140, 20);
        textFieldDiameter.setFont(Font.font("Arial", FontWeight.NORMAL, 11));
        textFieldDiameter.setTooltip(tooltipDiameter);
        InputConstrains.numbersOnly(textFieldDiameter);
        gridPane.add(textFieldDiameter, 1, 0);

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
        gridPane.add(textFieldHeight, 1, 1);

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

        // create HBox for buttons
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
        gridPane.add(hBox, 1, 3);

        // set action where buttonCalc clicked
        buttonCalc.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (textFieldDiameter.getText().isEmpty() && textFieldHeight.getText().isEmpty()) {
                    textArea.setText("please, fill in diameter & height.");
                } else {
                    cylinder.setHeight(Double.parseDouble(textFieldHeight.getText()));
                    cylinder.setWidth(Double.parseDouble(textFieldDiameter.getText()));
                    // formatting value to display two decimal places
                    String formatted = String.format("%.2f", cylinder.getVolume());
                    textArea.setText("cylinder volume = " + formatted);
                }
            }
        });

        // set action where buttonBack clicked
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

        // create Scene
        Scene scene = new Scene(gridPane, 350, 160);
        stage.setScene(scene);
        stage.show();

    }
}
