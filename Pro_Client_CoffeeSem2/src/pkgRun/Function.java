package pkgRun;

import java.io.IOException;
import java.sql.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

public class Function {

    Connection conn = null;
    Statement stt = null;
    PreparedStatement pst = null;

    public Function() {
    }

    // ---- ICON COFFEE
    public static final String txtTitleCF = "ĐĂNG NHẬP SYSTEM COFFEE";

    public static final String iconTitle = "/pkgImages/Coffee/iconTitle.png";
    public static final String iconError = "/pkgImages/Coffee/error.png";
    public static final String iconArrow = "/pkgImages/Coffee/arrow.png";
    public static final String iconInfo = "/pkgImages/Coffee/info.png";
    public static final String iconNotice = "/pkgImages/Coffee/notice.png";
    public static final String iconSuccess = "/pkgImages/Admin/Cafe_38px.png";
    public static final String iconWarning = "/pkgImages/Coffee/warning.png";

    // ---- next Stage Admin    
    public static final String XMLEditProduct_Admin = "/pkgView/EditProductsCoffee.fxml";
    public static final String XMLComponentListFood = "/pkgView/ListFoodXML.fxml";
    public static final String XMLAddTableInCoffee = "/pkgView/AddTableInCoffee.fxml";
    public static final String XMLDelteTableInCoffee = "/pkgView/DeleteTableInCoffee.fxml";

    // ---- next Stage Employee
    public static final String XMLViewMusic_Employee = "/pkgView/XMLViewMusic.fxml";

    // ---- next Stage
    public static final String XMLERRORServer = "/pkgView/Error503XML.fxml";
    public static final String XMLLoginCoffee = "/pkgView/LoginXML.fxml";
    public static final String XMLAdminCoffee = "/pkgView/AdminXML.fxml";
    public static final String XMLEmployeeCoffee = "/pkgView/EmployeeXML.fxml";

    // ---- database
    public static String usernameDB = "sa";
    public static String passwordDB = "123456";
    // public static String portDriver = "50124";
    public static String portDriver = "1433";
    public static String yourNameDB = "QuanLyQuanCafe";
    public static final String jdbcDriver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    public static final String urlDB = "jdbc:sqlserver://localhost:";
    public static final String sem = ";";

    public Connection connectDB() {
        try {
            Class.forName(jdbcDriver);
            Connection conn = DriverManager.getConnection(
                    urlDB + portDriver + sem
                    + "databaseName=" + yourNameDB + sem
                    + "user=" + usernameDB + sem
                    + "password=" + passwordDB + sem);
            return conn;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
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
            stage.show();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public void ShowNotify(String header, String text, NotificationType type) {
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
        tn.setAnimationType(AnimationType.POPUP);
        tn.showAndDismiss(Duration.seconds(6));
    }

}
