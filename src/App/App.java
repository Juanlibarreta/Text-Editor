package App;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;

public class App extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        stage = FXMLLoader.load(getClass().getResource("/Views/Main.fxml"));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
