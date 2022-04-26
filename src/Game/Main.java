package Game;

import java.util.Random;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {
	Integer v1 = 0;
	Integer contador = 0;

	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Game Random");
			Label labelTitulo = new Label("I think in a number between 0 and 100, try findout!!!");
			labelTitulo.getStyleClass().add("titulos");

			TextField tx1 = new TextField();
			tx1.getStyleClass().add("texto");

			Button bnt1 = new Button("Try");
			bnt1.getStyleClass().add("botoes");
			Button bnt2 = new Button("Exit");
			bnt2.getStyleClass().add("botoes");

			bnt2.setOnAction(e -> {
				primaryStage.close();
			});
			contador = geraRandom();
			bnt1.setOnAction(e -> {
				try {
					v1 = Integer.parseInt(tx1.getText());
					if (v1 == contador) {
						Alert alerta = new Alert(AlertType.WARNING);
						alerta.setTitle("Congratulations!!!");
						alerta.setHeaderText("You are right!!!!!!");
						alerta.show();
						contador = geraRandom();
						tx1.clear();
					} else if (v1 > 100) {
						Alert alerta = new Alert(AlertType.WARNING);
						alerta.setTitle("Try again please!");
						alerta.setHeaderText("Only numbers between 0 and 100 !!!");
						alerta.show();
						tx1.clear();
					} else {
						Alert alerta = new Alert(AlertType.WARNING);
						alerta.setTitle("Try again please!");
						alerta.setHeaderText("Wrong number !!!");
						alerta.show();
						tx1.clear();
					}
				} catch (NumberFormatException e2) {
					Alert alerta = new Alert(AlertType.WARNING);
					alerta.setTitle("Only Numbers");
					alerta.setHeaderText("Only Numbers");
					alerta.showAndWait();
					tx1.clear();
				}
			});

			VBox boxConteudo = new VBox();
			boxConteudo.setAlignment(Pos.CENTER);
			boxConteudo.getChildren().add(labelTitulo);
			VBox.setMargin(labelTitulo, new Insets(20));
			boxConteudo.getChildren().add(tx1);
			VBox.setMargin(bnt1, new Insets(15));
			boxConteudo.getChildren().add(bnt1);
			boxConteudo.getChildren().add(bnt2);

			Scene cenaPrincipal = new Scene(boxConteudo, 600, 300);
			cenaPrincipal.getStylesheets().add("https://fonts.googleapis.com/css2?family=Oswald");

			String caminhoDoCss = getClass().getResource("application.css").toExternalForm();
			cenaPrincipal.getStylesheets().add(caminhoDoCss);

			primaryStage.setScene(cenaPrincipal);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Integer geraRandom() {
		Random gerador = new Random();
		int valor = gerador.nextInt(100);
		return valor;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
