package com.gmail.alexace013.musicNote_Ver_3;

/**
 * @info The main class that starts the
 * application window is created in JavaFX
 * Created by Alexander Bakhin on 23.09.15
 * @author alexace013@gmail.com
 * @version 1.03
 */

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.time.Clock;
import java.time.LocalDateTime;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NotepadMain extends Application {

    // строчки которые часто используются в процессе
    private final static String strEmpty = new String("");
    private final static String strAuthorName = new String("enter author name");
    private final static String strAuthorGenre = new String("enter author genre");
    private final static String strTrackTitle = new String("enter track title");
    private static StringBuilder stringBuilder = new StringBuilder();

    private static boolean b1 = true;
    private static boolean b2 = true;
    private static boolean b3 = true;
    private static boolean b4 = true;
    private static boolean b5 = true;

    private static Notepad notepad = new Notepad();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public synchronized void start(Stage stage) {

        // устанавливаем текст в окне приложения
        stage.setTitle("Musical Notepad v.1.03");

        // создаем gridPane для размещения нужных компонентов
        GridPane mainGridPain = new GridPane();
        mainGridPain.setAlignment(Pos.TOP_LEFT);
        mainGridPain.setHgap(10.0d);
        mainGridPain.setVgap(10.0d);
        mainGridPain.setPadding(new Insets(25.0d, 25.0d, 25.0d, 25.0d));

        // текст "имя исполнителя"
        Text textAuthorName = new Text(strAuthorName.substring(6, strAuthorName.length()) + ": ");
        textAuthorName.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        mainGridPain.add(textAuthorName, 0, 0);

        // текст "жанр исполнителя"
        Text textAuthorGenre = new Text(strTrackTitle.substring(6, 11) + strAuthorGenre.substring(12, strAuthorGenre.length()) + ": ");
        textAuthorGenre.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        mainGridPain.add(textAuthorGenre, 0, 1);

        // текст "название композиции"
        Text textTrackTitle = new Text(strTrackTitle.substring(6, strTrackTitle.length()) + ": ");
        textTrackTitle.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        mainGridPain.add(textTrackTitle, 0, 2);

        // текст "для ввода удаления нужного компонента"
        Text textEnterNumber = new Text(strAuthorName.substring(0, 6) + "number:");
        textEnterNumber.setFont(Font.font("Arial", FontWeight.BOLD, 12));
        mainGridPain.add(textEnterNumber, 0, 3);

        // текст "подсказки"
        Text textTips = new Text("\t\ttips: ");
        textTips.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
        mainGridPain.add(textTips, 0, 6);

        // текстовое поле для ввода "имени исполнителя"
        TextField textFieldAuthorName = new TextField(strAuthorName);
        textFieldAuthorName.setMaxSize(330, 20);
        textFieldAuthorName.setDisable(false);
        textFieldAuthorName.setFont(Font.font("Arial", FontWeight.LIGHT, 12));
        mainGridPain.add(textFieldAuthorName, 1, 0);

        // текстовое поля для ввода "жанра исполнителя"
        TextField textFieldAuthorGenre = new TextField(strAuthorGenre);
        textFieldAuthorGenre.setMaxSize(330, 20);
        textFieldAuthorGenre.setDisable(true);
        textFieldAuthorGenre.setFont(Font.font("Arial", FontWeight.LIGHT, 12));
        mainGridPain.add(textFieldAuthorGenre, 1, 1);

        // тексовое поле для ввода "названия композиции"
        TextField textFieldTrackTitle = new TextField(strTrackTitle);
        textFieldTrackTitle.setMaxSize(330, 20);
        textFieldTrackTitle.setDisable(true);
        textFieldTrackTitle.setFont(Font.font("Arial", FontWeight.LIGHT, 12));
        mainGridPain.add(textFieldTrackTitle, 1, 2);

        // текстовое поле для ввода "удаление элемента"
        TextField textFieldNumberDelete = new TextField();
        textFieldNumberDelete.setDisable(true);
        textFieldNumberDelete.setMaxSize(40, 20);
        textFieldNumberDelete.getNodeOrientation();
        textFieldNumberDelete.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 12));
        mainGridPain.add(textFieldNumberDelete, 1, 3);

        // создание HBox для размещения кнопок вокне приложения
        HBox hBox = new HBox(10.0d);
        hBox.setAlignment(Pos.BOTTOM_LEFT);

        // создание кнопки "сохранить"
        Button buttonSave = new Button("save");
        buttonSave.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 12));
        buttonSave.setPrefSize(70, 20);
        hBox.getChildren().add(buttonSave);

        // создание кнопки "очистить подсказки"
        Button buttonClear = new Button("clear tips");
        buttonClear.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 12));
        buttonClear.setPrefSize(80, 20);
        hBox.getChildren().add(buttonClear);

        // создание кнопки "покзать весь список сохраненных компонентов"
        Button buttonShowAll = new Button("show tracklist");
        buttonShowAll.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 12));
        buttonShowAll.setPrefSize(120, 20);
        hBox.getChildren().add(buttonShowAll);

        // создание HBox для размещения дополнительных кнопок
        HBox hBox2 = new HBox();

        // создание кнопки "удалить компонет по индексу"
        Button buttonDelete = new Button("delete");
        buttonDelete.setFont(Font.font("Arial", FontWeight.EXTRA_BOLD, 12));
        buttonDelete.setPrefSize(70, 20);
        hBox.getChildren().add(buttonDelete);

        // создание текствойо области для "вывода подсказок пользователю"
        TextArea textArea = new TextArea("here you will see tips");
        textArea.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
        textArea.setEditable(false);
        textArea.setBackground(Background.EMPTY);
        mainGridPain.add(textArea, 1, 6);

        mainGridPain.add(hBox, 1, 5);

        // установка действия при нажатии на текстовое поле "имя автора"
        textFieldAuthorName.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (b1 == true) {
                    Thread thread = new Thread();
                    thread.start();
                    try {
                        thread.sleep(200);
                        textFieldAuthorName.setText(strEmpty);
                        textFieldAuthorGenre.setDisable(false);
                        b1 = false;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // установка действия принажатии на текствоое поле "жанр исполнителя"
        textFieldAuthorGenre.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (b2 == true) {
                    Thread thread = new Thread();
                    thread.start();
                    try {
                        thread.sleep(200);
                        textFieldAuthorGenre.setText(strEmpty);
                        textFieldTrackTitle.setDisable(false);
                        b2 = false;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // установка действия при нажатии на тексовое поле "название композиции исполнителя"
        textFieldTrackTitle.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (b3 == true) {
                    Thread thread = new Thread();
                    thread.start();
                    try {
                        thread.sleep(200);
                        textFieldTrackTitle.setText(strEmpty);
                        b3 = false;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // установка дейсвия при нажатии на тексовое поле "ввод номера для удаления компонента"
        textFieldNumberDelete.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (b4 == true) {
                    Thread thread = new Thread();
                    thread.start();
                    try {
                        thread.sleep(100);
                        textFieldNumberDelete.setText(strEmpty);
                        b4 = false;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        // установка действия на кнопку "сохранить"
        buttonSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (textFieldAuthorName.getText().equals(strEmpty) || textFieldAuthorGenre.getText().equals(strEmpty)
                        || textFieldTrackTitle.equals(strEmpty) || textFieldAuthorName.getText().equals(strAuthorName)
                        || textFieldAuthorGenre.getText().equals(strAuthorGenre)
                        || textFieldTrackTitle.getText().equals(strTrackTitle)) {
                    textArea.setText("track is not saved\nplease, fill in the fields");
                } else {
                    notepad.addTrack(textFieldAuthorName.getText(), textFieldAuthorGenre.getText(),
                            textFieldTrackTitle.getText());
                    textArea.setText("track saved");
                    textFieldAuthorName.setText(strEmpty);
                    textFieldAuthorGenre.setText(strEmpty);
                    textFieldTrackTitle.setText(strEmpty);
                }
            }
        });

        // установка действия на кнопку "показать весь списох сохраненных компонентов"
        buttonShowAll.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.setText(strEmpty);
                stringBuilder.append(notepad.getAllTracks());
                // делаем перебор всех компонентов
                Iterator<Track> iterator = notepad.getAllTracksList().iterator();
                // вводим переменную "счетчик" для количества компонентов в списке
                int count = 1;
                while (iterator.hasNext()) {
                    textArea.appendText(count + ". " + iterator.next().toString() + "\n");
                    count++;
                }
            }
        });

        // установка действия на кнопку "очисить подсказки"
        buttonClear.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textArea.setText(strEmpty);
            }
        });

        // установка действия при наведении на кнопку "удаление элемента"
        buttonDelete.setOnMouseMoved(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if (notepad.getAllTracksList().size() != 0) {
                    textFieldNumberDelete.setDisable(false);
                }
            }
        });

        // установка действия на кнопку "удалить элемент"
        buttonDelete.setOnAction(new EventHandler<ActionEvent>() {

            // метод для проверки введенного значения
            private boolean numberCheck(TextField textField) {

                Integer number = null;
                String strNumber = textField.getText();
                // задаём диапазон разрешённых символов для ввода
                Pattern pattern = Pattern.compile("[\\d]");
                Matcher matcher = pattern.matcher(strNumber);
                if (!matcher.matches()) {
                    textArea.setText("please, repeat enter index of you list");
                    return false;
                } else {
                    // отнимаем единицу, так, как нумерация в ArrayList элементов начинается с "0",
                    // а у пользователя идет отображение компонентов с "1"
                    number = (Integer.parseInt(textField.getText()) - 1);
//                    textFieldNumberDelete.setText(strEmpty);
                    return true;
                }
            }

            @Override
            public void handle(ActionEvent event) {

                Integer value = null;
                if (!(notepad.getAllTracksList().size() == 0)) {
                    if (numberCheck(textFieldNumberDelete)) {
                        value = Integer.parseInt(textFieldNumberDelete.getText());
                        if (value == 0) {
                            notepad.removeTrack(0);
                            textArea.setText("track delete");
                        } else {
                            notepad.removeTrack(value - 1);
                            textArea.setText("track delete");
                        }

                    }
                }

            }
        });

        // установка действия при "закрытии главного окна"
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                Stage stage2 = new Stage();
                // запуск класса, для создания окна запроса на выход
                QuestionExitWindow questionExit = new QuestionExitWindow();
                try {
                    questionExit.start(stage2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Scene scene = new Scene(mainGridPain, 470, 360);
        stage.setScene(scene);
        stage.show();

    }

    private class QuestionExitWindow extends Application {


        @Override
        public void start(Stage stage) throws Exception {

            stage.setTitle("Exit program?");

            GridPane gridPane = new GridPane();
            gridPane.setAlignment(Pos.TOP_CENTER);
            gridPane.setHgap(10.0d);
            gridPane.setVgap(10.0d);
            gridPane.setPadding(new Insets(25, 25, 25, 25));

            Text textQuestion = new Text("do you want to write your data to a file?");
            textQuestion.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
            gridPane.add(textQuestion, 0, 0);

            HBox box = new HBox(10.0d);
            box.setAlignment(Pos.CENTER);
            Button buttonYes = new Button("yes");
            buttonYes.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
            buttonYes.setPrefSize(40, 20);
            box.getChildren().add(buttonYes);
            Button buttonNo = new Button("no");
            buttonNo.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
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
                    WindowFileSave questionWindowAppFile = new WindowFileSave();
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

        // класс для 3-го окна, окно, где вводится имя файла и путь,
        // куда будет сохранен файл
        private class WindowFileSave extends Application {

            @Override
            public void start(Stage stage) throws Exception {

                stage.setTitle("Saving to file");

                GridPane gridPane = new GridPane();
                gridPane.setAlignment(Pos.TOP_CENTER);
                gridPane.setHgap(10.0d);
                gridPane.setVgap(10.0d);
                gridPane.setPadding(new Insets(25, 25, 25, 25));

                Text textFileName = new Text("enter your file name: ");
                textFileName.setFont(Font.font("Arial", FontWeight.NORMAL, 12));
                gridPane.add(textFileName, 0, 0);
                TextField textFieldFileName = new TextField();
                gridPane.add(textFieldFileName, 0, 1);
                Button buttonSave = new Button("save");
                buttonSave.setDisable(true);
                gridPane.add(buttonSave, 0, 2);

                HBox box = new HBox(10.0d);
                box.setAlignment(Pos.CENTER);
                box.getChildren().add(textFileName);
                box.getChildren().add(textFieldFileName);
                box.getChildren().add(buttonSave);
                gridPane.add(box, 0, 1);

                // действия по движению на "поле ввода", если поле пустое, то
                // кнопка сохранить не активная.
                textFieldFileName.setOnMouseMoved(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        if (textFieldFileName.getText().equals(strEmpty)) {
                            buttonSave.setDisable(true);
                        } else {
                            buttonSave.setDisable(false);
                        }
                    }
                });

                // кнопка для подтверждения "сохранения в файл"
                buttonSave.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        // получаем время и дату на момент сохранения в файл
                        LocalDateTime dateTime = LocalDateTime.now(Clock.systemDefaultZone());
                        // запуск класса для "сохранения данных в файл"
                        FileWriteProcess fileWriteProcess = new FileWriteProcess();
                        String fileName = textFieldFileName.getText();
                        Iterator<Track> iterator = notepad.getAllTracksList().iterator();
                        int count = 1;
                        StringBuilder stringBuilder1 = new StringBuilder();
                        while (iterator.hasNext()) {
                            stringBuilder1.append(count + ". " + iterator.next().toString() + "\n");
                            count++;
                        }
                        fileWriteProcess.writeFile(fileName, stringBuilder1.toString() +
                                "\ndate: " + "\t" + dateTime + "\n");
                        stage.close();
                    }
                });

//                stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
//                    @Override
//                    public void handle(WindowEvent event) {
//                        stage.close();
//                    }
//                });

                Scene scene = new Scene(gridPane, 450, 100);
                stage.setScene(scene);
                stage.show();

            }
        }

    }

}

