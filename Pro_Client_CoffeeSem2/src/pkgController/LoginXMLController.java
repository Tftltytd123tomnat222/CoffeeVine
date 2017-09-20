package pkgController;

import com.jfoenix.controls.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pkgCodeMD5.lgMD5;
import pkgConnectDB.ConnectDB;
import pkgInterface.LoginCF;
import pkgModels.QuerySQL;
import pkgRun.Function;
import tray.notification.NotificationType;

/**
 *
 * @author Tom W
 */
public class LoginXMLController extends Thread implements Initializable {

    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    @FXML
    void initialize() {
    }

    @FXML
    private Function functions;

    
    @FXML
    private JFXTextField txtUser;
    @FXML
    private PasswordField txtPass;
    @FXML
    public JFXComboBox<String> mbPosition;
    @FXML
    private JFXButton btnLogin;


    @FXML
    void btnLoginCoffee(ActionEvent event) throws Exception {
        Stage current = (Stage) btnLogin.getScene().getWindow();
        try {
            LoginCF check = (LoginCF) Naming.lookup("rmi://localhost:2222/ServerRMI");
            if(check.checkLogin(txtUser.getText(), txtPass.getText(), mbPosition.getValue())){
                if (!isInput()) {
                    if (checkLoginCF() && mbPosition.getValue().equalsIgnoreCase("QUẢN LÍ")) {
                        // Quản lí
                        
                        current.hide();
                        functions.nextStage(Function.XMLAdminCoffee, "QUẢN LÍ", true);
                    } else if (checkLoginCF() && mbPosition.getValue().equalsIgnoreCase("NHÂN VIÊN")) {
                        // Nhân viên
                        
                        current.hide();
                        functions.nextStage(Function.XMLEmployeeCoffee, "ORDER ORDER", true);
                    } else {
                        functions.ShowNotify("LỖI ĐĂNG NHẬP", "VUI LÒNG KIỂM TRA LẠI THÔNG TIN ĐĂNG NHẬP", NotificationType.ERROR);
                    }
                } else {
                    functions.ShowNotify("LỖI ĐĂNG NHẬP", "HÃY CHẮC CHẮN RẰNG BẠN KHÔNG BỎ TRỐNG", NotificationType.WARNING);
                }
            }
        } catch (MalformedURLException | NotBoundException | RemoteException e) {
            functions.nextStage(Function.XMLERRORServer, "LỖI SERVER", true);
            current.hide();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        functions = new Function();

        ObservableList<String> ObsPosition = FXCollections.observableArrayList("QUẢN LÍ", "NHÂN VIÊN");
        mbPosition.setItems(ObsPosition);
        mbPosition.getSelectionModel().selectFirst(); //-- Lấy Item đầu tiên Select
        
        
//        txtUser.focusedProperty().addListener((ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) -> {
//            if (!newValue) {
//                functions.ShowNotify("LỖI", "KHÔNG ĐƯỢC ĐỄ TRỐNG", NotificationType.NOTICE);
//            }
//            
//        });

    }

    boolean isInput() {
        return txtUser.getText().isEmpty() || txtPass.getText().isEmpty();
    }
    boolean checkLoginCF() {
        try {
            conn = ConnectDB.connectData();
            pst = conn.prepareStatement("SELECT * FROM lgCof WHERE lgUser=? AND lgPass =? AND lgPosition=?");
            pst.setString(1, txtUser.getText());
            pst.setString(2, lgMD5.hashPass(txtPass.getText()));
            //202cb962ac5975b964b7152d234b70
            pst.setString(3, mbPosition.getValue());
            rs = pst.executeQuery();
            while (rs.next()) {
                return true;
            }

        } catch (NoSuchAlgorithmException | SQLException ex) {
            System.out.println(ex);
        }
        return false;
    }
}
