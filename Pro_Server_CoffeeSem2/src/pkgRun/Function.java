package pkgRun;


import java.io.IOException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;


public class Function {
    Connection conn = null;
    Statement stt = null;
    PreparedStatement pst = null;
    public Function() {}
    
    
    // ---- next Server
    public static final String XMLServer ="/pkgRun/ServerXML.fxml";
    
    
    
    // ---- database
    public static String usernameDB = "sa";
    public static String passwordDB = "123456";
    public static String portDriver = "1433";
    public static String yourNameDB = "Coffee";
    public static final String jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static final String urlDB = "jdbc:sqlserver://localhost:";
    public static final String sem = ";";
    
    
    public Connection connectDB(){
        try {
            Class.forName(jdbcDriver);
            Connection conn = DriverManager.getConnection(
                    urlDB           + portDriver + sem + 
                    "databaseName=" + yourNameDB + sem +
                    "user="         + usernameDB + sem +
                    "password="     + passwordDB + sem );
            return conn;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Function.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
  
     
    
    public void nextStage(String fxml, String title, boolean resizable) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxml));
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.setTitle(title);
            stage.setResizable(resizable);
            stage.initStyle(StageStyle.DECORATED);
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    public void ShowNotify(String header,String text,NotificationType type){
        // Alert.AlertType type
//        Alert notify = new Alert(type);
//        notify.setTitle("!- THÔNG BÁO -!");
//        notify.setHeaderText(header);
//        notify.setContentText(text);
//        notify.showAndWait();  
          
        TrayNotification tn = new TrayNotification();
        tn.setTitle(header);
        tn.setMessage(text);
        tn.setNotificationType(type);
        tn.setAnimationType(AnimationType.SLIDE);
        tn.showAndWait();
    }
   
}