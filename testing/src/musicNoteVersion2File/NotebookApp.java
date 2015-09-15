package musicNoteVersion2File;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import testMusicNotebookFile.*;
import testMusicNotebookFile.TrackRegister;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by alexander on 13.09.15.
 */
public class NotebookApp extends Application {

    private static StringBuilder stringBuilder = new StringBuilder();
    private static Notebook notebook = new Notebook();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("Musical Notes ver.1_02");

        /*
         * alignment (выравнивание) - меняет стандартное положение сетки
		 * gap (разрыв) - отвечают за пробелы между строками и столбцами
		 * padding (набивка) - отвечает за пространство вокруг сетки.
		 * insets (вставки) - порядок перечисления в insets: вверху, справа,
		 * снизу и слева.
        * */
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.TOP_LEFT);
        gridPane.setHgap(10.0d);
        gridPane.setVgap(10.0d);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        // setFont() - для задания шрифта, размера и стиля
        Text textName = new Text("author : ");
        textName.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        gridPane.add(textName, 0, 0);
        Text textSurname = new Text("genre : ");
        textSurname.setFont(Font.font("Tamona", FontWeight.NORMAL, 12));
        gridPane.add(textSurname, 0, 1);
        Text textPhone = new Text("track : ");
        textPhone.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        gridPane.add(textPhone, 0, 2);
        Text textInfo = new Text("info : ");
        textInfo.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        gridPane.add(textInfo, 0, 5);

        TextField textFieldName = new TextField("enter author");
        textFieldName.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        gridPane.add(textFieldName, 1, 0);
        TextField textFieldSurname = new TextField("enter genre");
        textFieldSurname.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        gridPane.add(textFieldSurname, 1, 1);
        TextField textFieldPhone = new TextField("enter track");
        textFieldPhone.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        gridPane.add(textFieldPhone, 1, 2);

        /*
        * HBox - выравнивание элементов горизонтально
        * setAligment - установка позиции
        * getChildren - получение списка "детей" этого "родителя"
        *
        * Button - кнопка
        * setPrefSize - установка размеров кнопки
        *
        * */
        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.BOTTOM_LEFT);
        Button buttonSave = new Button("save");
        buttonSave.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        buttonSave.setPrefSize(70, 20);
        hBox.getChildren().add(buttonSave);
        Button buttonClear = new Button("clear");
        buttonClear.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        buttonClear.setPrefSize(70, 20);
        hBox.getChildren().add(buttonClear);
        Button buttonShowAll = new Button("show all");
        buttonShowAll.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        buttonShowAll.setPrefSize(70, 20);
        hBox.getChildren().add(buttonShowAll);
        gridPane.add(hBox, 1, 4);

        /*
         * setEditable() - запрет ввода в textArea true - ввод разрешён, false -
		 * ввод запрещен
        * */
        TextArea textArea = new TextArea("here you will see tips");
        textArea.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
        textArea.setEditable(false);
        gridPane.add(textArea, 1, 5);

        // кнопка "сохранения"
        buttonSave.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    notebook.addTrack(textFieldName.getText(),
                            textFieldSurname.getText(),
                            textFieldPhone.getText());
                    textArea.setText(notebook.addTrackInfo());
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                }

            }
        });

        // кнопка "показать все данные, которые были сохранены"
        buttonShowAll.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                textArea.setText("");
                stringBuilder.append(notebook.allTracks().toString());
                Iterator<TrackRegister> iterator = notebook.allTracks()
                        .iterator();
                while (iterator.hasNext()) {
                    textArea.appendText(iterator.next().toString() + '\n');
                }
            }
        });

        // кнопка "очистка поля вывода"
        buttonClear.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                textArea.setText("");
            }
        });

        /*
        * действия при закрытии окна программы
        *
        * при нажатии на крестик закрытия окна,
        * переходим в окно для запроса сохранения данных в файл
        * */
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

            @Override
            public void handle(WindowEvent event) {
                Stage stage2 = new Stage();
                // создание окна запроса
                QuestionWindowApp question = new QuestionWindowApp();
                try {
                    question.start(stage2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Scene scene = new Scene(gridPane, 350, 360);
        stage.setScene(scene);

        stage.show();

    }

    /*
    * класс, отвечающий за запрос на выход с программы
    * В окне имеется две кнопки: Yes и No.
    * 1. После нажатия кнопки Yes - переходим к 3-у окну,
    * для ввода имени файла и сохранения данных в этот файл.
    * 2. После нажатия кнопки No - закрытие программы,
    * данные теряются.
    *
    * setHgap - установка ширины зазоров между горизонтальными столбцами
    * setVgap - установка ширины зазоров между вертикальными столбцами
    * */
    private class QuestionWindowApp extends Application {


        @Override
        public void start(Stage stage) throws Exception {

            stage.setTitle("Question");

            GridPane gridPane = new GridPane();
            gridPane.setAlignment(Pos.TOP_CENTER);
            gridPane.setHgap(10.0d);
            gridPane.setVgap(10.0d);
            gridPane.setPadding(new Insets(25, 25, 25, 25));

            Text textQuestion = new Text("Do you want to write your data to a file?");
            textQuestion.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
            gridPane.add(textQuestion, 0, 0);

            HBox box = new HBox(10.0d);
            box.setAlignment(Pos.CENTER);
            Button buttonYes = new Button("yes");
            buttonYes.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
            buttonYes.setPrefSize(40, 20);
            box.getChildren().add(buttonYes);
            Button buttonNo = new Button("no");
            buttonNo.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
            buttonNo.setPrefSize(40, 20);
            box.getChildren().add(buttonNo);

            gridPane.add(box, 0, 1);

            /*
            * кнопка для подтверждения сохранения в файл
            *
            * Здесь создаётся 3-е окно для ввода текста и его сохранения
            * */
            buttonYes.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    Stage stage3 = new Stage();
                    // создание окна для ввода текса и сохранения в файл
                    QuestionWindowAppFile questionWindowAppFile = new QuestionWindowAppFile();
                    try {
                        stage.close();
                        questionWindowAppFile.start(stage3);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });

            // выход из программы
            buttonNo.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent event) {
                    stage.close();
                }
            });

            Scene scene = new Scene(gridPane, 300, 100);
            stage.setScene(scene);

            stage.show();

        }

        private class QuestionWindowAppFile extends Application {


            @Override
            public void start(Stage stage) throws Exception {

                stage.setTitle("Saving");

                GridPane gridPane = new GridPane();
                gridPane.setAlignment(Pos.TOP_CENTER);
                gridPane.setHgap(10.0d);
                gridPane.setVgap(10.0d);
                gridPane.setPadding(new Insets(25, 25, 25, 25));

                Text textFileName = new Text("Enter your file name: ");
                textFileName.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
                gridPane.add(textFileName, 0, 0);
                TextField textFieldFileName = new TextField();
                gridPane.add(textFieldFileName, 0, 1);
                Button buttonSave = new Button("Save");
                gridPane.add(buttonSave, 0, 2);

                HBox box = new HBox(10.0d);
                box.setAlignment(Pos.CENTER);
                box.getChildren().add(textFileName);
                box.getChildren().add(textFieldFileName);
                box.getChildren().add(buttonSave);
                gridPane.add(box, 0, 1);

                buttonSave.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        LocalDateTime dateTime = LocalDateTime.now(Clock.systemDefaultZone());
                        FileProcess fileProcess = new FileProcess();
                        String fileName = textFieldFileName.getText();
                        fileProcess.writeFile(fileName, stringBuilder.toString() +
                                "\ndate: " + dateTime);
                    }
                });

                stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
                    @Override
                    public void handle(WindowEvent event) {
                        stage.close();
                    }
                });

                Scene scene = new Scene(gridPane, 450, 100);
                stage.setScene(scene);
                stage.show();

            }
        }

    }

}
