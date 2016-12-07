package presentation.loginWindow;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class RunLogin extends Application {

	private Stage primaryStage;
    private BorderPane rootLayout;

   
    public static void main(String[] args) {
        launch(args);
    }
    
    
    
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("登录");
        this.primaryStage.getIcons().add(new Image("file:src/lib/logo.png"));

        initRootLayout();

        showLoginAnchor();
    }

    /**
     * Initializes the root layout.
     */
    public void initRootLayout() {
        try {
            // Load root layout from fxml file.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(RunLogin.class.getResource("LoginBorder.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Show the scene containing the root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Shows the LoginAnchor inside the root layout.
     */
    public void showLoginAnchor() {
        try {
            // Load person overview.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(RunLogin.class.getResource("LoginAnchor.fxml"));
            AnchorPane LoginAnchor = (AnchorPane) loader.load();

            // Set person overview into the center of root layout.
            rootLayout.setCenter(LoginAnchor);
            
            
            //set controller
            LoginAnchorController controller=loader.getController();
            controller.setRunLogin(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the main stage.
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    
}

