package calcFigure.window;

import calcFigure.CalcFigureMainFX;
import calcFigure.figure.Box;
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
 * Created by alexander on 08.10.15.
 */
public class WindowBox extends Application {

    private Box box = new Box();

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Box");

        // create GridPane
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.TOP_CENTER);
        gridPane.setHgap(10.0d);
        gridPane.setVgap(10.0d);
        gridPane.setPadding(new Insets(10.0d, 10.0d, 10.0d, 10.0d));

        // create Text - text height
        Text textHeight = new Text("enter box height: ");
        textHeight.setFont(Font.font("Arial", FontWeight.NORMAL, 11));

        // create Text - text width
        Text textWidth = new Text("enter box width: ");
        textWidth.setFont(Font.font("Arial", FontWeight.NORMAL, 11));

        // create Text - text depth
        Text textDepth = new Text("enter box depth: ");
        textDepth.setFont(Font.font("Arial", FontWeight.NORMAL, 11));

        // add text elements in gridPane
        gridPane.add(textHeight, 0, 0);
        gridPane.add(textWidth, 0, 1);
        gridPane.add(textDepth, 0, 2);

        // create Tooltip for textFieldHeight
        Tooltip tooltipHeight = new Tooltip();
        tooltipHeight.setText("height (example: " + (int)(Math.random() * 100) + ")");
        tooltipHeight.setFont(Font.font("Arial", FontWeight.NORMAL, 10));

        // create TextField - height
        TextField textFieldHeight = new TextField();
        textFieldHeight.setMaxSize(140, 20);
        textFieldHeight.setFont(Font.font("Arial", FontWeight.NORMAL, 11));
        textFieldHeight.setTooltip(tooltipHeight);
        InputConstrains.numbersOnly(textFieldHeight);

        // create Tooltip for textFieldWidth
        Tooltip tooltipWidth = new Tooltip();
        tooltipWidth.setText("width (example: " + (int) (Math.random() * 100) + ")");
        tooltipWidth.setFont(Font.font("Arial", FontWeight.NORMAL, 10));

        // create TextField - width
        TextField textFieldWidth = new TextField();
        textFieldWidth.setMaxSize(140, 20);
        textFieldWidth.setFont(Font.font("Arial", FontWeight.NORMAL, 11));
        textFieldWidth.setTooltip(tooltipWidth);
        InputConstrains.numbersOnly(textFieldWidth);

        // create Tooltip for textFieldDepth
        Tooltip tooltipDepth = new Tooltip();
        tooltipDepth.setText("depth (example: " + (int) (Math.random() * 100) + ")");
        tooltipDepth.setFont(Font.font("Arial", FontWeight.NORMAL, 10));
        
        // create TextField - depth
        TextField textFieldDepth = new TextField();
        textFieldDepth.setMaxSize(140, 20);
        textDepth.setFont(Font.font("Arial", FontWeight.NORMAL, 11));
        textFieldDepth.setTooltip(tooltipDepth);
        InputConstrains.numbersOnly(textFieldDepth);

        //add textField elements in gridPane
        gridPane.add(textFieldHeight, 1, 0);
        gridPane.add(textFieldWidth, 1, 1);
        gridPane.add(textFieldDepth, 1, 2);

        // create Tooltip for textArea
        Tooltip tooltipTextArea = new Tooltip();
        tooltipTextArea.setText("in this fill your can see tips and result.");
        tooltipTextArea.setFont(Font.font("Arial", FontWeight.NORMAL, 10));

        // create TextArea
        TextArea textArea = new TextArea();
        textArea.setFont(Font.font("Arial", FontWeight.BOLD, 11));
        /*
        * sedEditable
        * true = > editing possible
        * false = > editing is not possible
        * */
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

        // actions that will be processed by pressing the button "CALCULATE"
        buttonCalc.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                if (textFieldHeight.getText().isEmpty() || textFieldWidth.getText().isEmpty() ||
                        textFieldDepth.getText().isEmpty()) {
                    textArea.setText("please, fill in height, width & depth.");
                } else {
                    box.setHeight(Double.parseDouble(textFieldHeight.getText()));
                    box.setWidth(Double.parseDouble(textFieldWidth.getText()));
                    box.setDepth(Double.parseDouble(textFieldDepth.getText()));
                    // formatting value to display two decimal places
                    String formatted = String.format("%.2f", box.getVolume());
                    textArea.setText("box volume = " + formatted);
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
        Scene scene = new Scene(gridPane, 350, 190);
        stage.setScene(scene);
        stage.show();

    }

}
