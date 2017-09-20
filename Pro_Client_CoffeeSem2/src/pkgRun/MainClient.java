package pkgRun;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author Tom W
 */
public class MainClient extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(this.getClass().getResource(Function.XMLLoginCoffee));

        Scene scene = new Scene(root);
        scene.getStylesheets().add(this.getClass().getResource("Style.css").toExternalForm());
        
        stage.setTitle(Function.txtTitleCF);
        stage.getIcons().add(new Image(Function.iconSuccess));    
//        stage.initStyle(StageStyle.TRANSPARENT);
        stage.setScene(scene);
      //  stage.setFullScreen(true);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
