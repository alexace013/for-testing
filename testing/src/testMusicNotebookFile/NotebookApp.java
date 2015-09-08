package testMusicNotebookFile;

import java.util.Iterator;

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

public class NotebookApp extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		stage.setTitle("Music Notebook v.1.01");

		// alignment (выравнивание) - меняет стандартное положение сетки
		// gap (разрыв) - отвечают за пробелы между строками и столбцами
		// padding (набивка) - отвечает за пространство вокруг сетки.
		// insets (вставки) - порядок перечисления в insets: вверху, справа,
		// снизу и слева.
		GridPane gridPane = new GridPane();
		gridPane.setAlignment(Pos.TOP_LEFT); //
		gridPane.setHgap(10.0d);
		gridPane.setVgap(10.0d);
		gridPane.setPadding(new Insets(25, 25, 25, 25));

		// setFont() для задания шрифта, размера и стиля переменной textName
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

		HBox hBox = new HBox(10);
		hBox.setAlignment(Pos.BOTTOM_LEFT);
		Button buttonSave = new Button("save");
		buttonSave.setFont(Font.font("", FontWeight.NORMAL, 12));
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

		// setEditable() - запрет ввода в textArea true - ввод разрешён, false -
		// ввод запрещен
		TextArea textArea = new TextArea("here you will see tips");
		textArea.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
		textArea.setEditable(false);
		gridPane.add(textArea, 1, 5);

		Notebook notebook = new Notebook();

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

		buttonShowAll.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				textArea.setText("");
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append(notebook.allTracks().toString());
				Iterator<TrackRegister> iterator = notebook.allTracks()
						.iterator();
				while (iterator.hasNext()) {
					textArea.appendText(iterator.next().toString() + '\n');
				}
			}
		});

		buttonClear.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				textArea.setText("");
			}
		});
		
		stage.setOnCloseRequest(new EventHandler<WindowEvent>() {

			@Override
			public void handle(WindowEvent event) {
				Stage stage2 = new Stage();
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
}
