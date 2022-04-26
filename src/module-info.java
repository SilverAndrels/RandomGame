module RandomGame {
	requires javafx.controls;
	
	opens Game to javafx.graphics, javafx.fxml;
}
