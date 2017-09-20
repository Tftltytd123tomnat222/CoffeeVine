package pkgController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.Stage;
import pkgModels.QuerySQL;
import pkgRun.Function;
import tray.notification.NotificationType;

public class AddTableInCoffeeController implements Initializable {

    @FXML
    private Function functions;
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        functions = new Function();
    }
    @FXML
    private JFXButton btnAddTabel;

    @FXML
    private JFXButton btnResetTable;

    @FXML
    private JFXTextField txtNameTable;

    @FXML
    void onActionAddTable(ActionEvent event) {
        if (event.getTarget() == btnAddTabel) {
            if (txtNameTable.getText().isEmpty() || txtNameTable.getText() == null) {
                functions.ShowNotify("LỖI", "VUI LÒNG KHÔNG ĐỄ TRỐNG TÊN BÀN", NotificationType.ERROR);
            } else {
                try {
                    conn = functions.connectDB();
                    pst = conn.prepareStatement(QuerySQL.insertTable_ + txtNameTable.getText() + QuerySQL._StatusCoffee);
                    pst.executeUpdate();
                    functions.ShowNotify("THÊM BÀN", "BÀN ĐÃ ĐƯỢC THÊM VÀO QUÁN COFFEE", NotificationType.SUCCESS);
                    pst.close();
                    conn.close();
                    Stage current = (Stage) btnAddTabel.getScene().getWindow();
                    current.hide();
                    functions.nextStage("/pkgView/AddTableInCoffee.fxml", "QUẢN LÍ QUÁN VINE COFFEE", true);

                } catch (SQLException ex) {
                    functions.ShowNotify("LỖI", "KHÔNG THỂ THÊM BÀN VÀO QUÁN COFFEE", NotificationType.ERROR);
                }
            }
        } else if (event.getTarget() == btnResetTable) {
            txtNameTable.setText(null);
        }
    }
}
