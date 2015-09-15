//package testMusicNotebookFile;
//
//import javafx.application.Application;
//import javafx.event.ActionEvent;
//import javafx.event.EventHandler;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.GridPane;
//import javafx.scene.layout.HBox;
//import javafx.scene.text.Font;
//import javafx.scene.text.FontWeight;
//import javafx.scene.text.Text;
//import javafx.stage.Stage;
//
//import java.util.Scanner;
//
//public class QuestionWindowApp extends Application {
//
//	public static void main(String[] args) {
//		launch(args);
//	}
//
//	@Override
//	public void start(Stage stage) throws Exception {
//
//		stage.setTitle("question");
//
//		GridPane gridPane = new GridPane();
//		gridPane.setAlignment(Pos.TOP_CENTER);
//		gridPane.setHgap(10.0d);
//		gridPane.setVgap(10.0d);
//		gridPane.setPadding(new Insets(25, 25, 25, 25));
//
//		Text textQuestion = new Text("Do you want to write your data to a file?");
//		textQuestion.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
//		gridPane.add(textQuestion, 0, 0);
//
//		HBox box = new HBox(10.0d);
//		box.setAlignment(Pos.CENTER);
//		Button buttonYes = new Button("yes");
//		buttonYes.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
//		buttonYes.setPrefSize(40, 20);
//		box.getChildren().add(buttonYes);
//		Button buttonNo = new Button("no");
//		buttonNo.setFont(Font.font("Tahoma", FontWeight.NORMAL, 12));
//		buttonNo.setPrefSize(40, 20);
//		box.getChildren().add(buttonNo);
//
//		gridPane.add(box, 0, 1);
//
//		buttonYes.setOnAction(new EventHandler<ActionEvent>() {
//
//			@Override
//			public void handle(ActionEvent event) {
//				System.out.print("enter file name: ");
//				Scanner scanner = new Scanner(System.in);
//				String fileName = scanner.nextLine();
//				FileProcess fileProcess = new FileProcess();
//				fileProcess.writeFile(fileName, "");
//				stage.close();
//			}
//		});
//
//		buttonNo.setOnAction(new EventHandler<ActionEvent>() {
//
//			@Override
//			public void handle(ActionEvent event) {
//				stage.close();
//			}
//		});
//
//
//
//		Scene scene = new Scene(gridPane, 300, 100);
//		stage.setScene(scene);
//
//		stage.show();
//
//	}
//
//
//
//}
