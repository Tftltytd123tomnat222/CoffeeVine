package pkgController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import pkgModels.QuerySQL;
import pkgModels.TableInCoffee;
import pkgRun.Function;
import tray.notification.NotificationType;

public class DeleteTableInCoffeeController implements Initializable {

    @FXML
    private Function functions;
    Connection conn = null;
    PreparedStatement pst = null;
    Statement stmt = null;
    ResultSet rs = null;

    int idTable;
    @FXML
    private JFXButton btnDeleteTabel;

    @FXML
    private Label lblNameTable;
    @FXML
    private Label lblStatusTable;

    @FXML
    private JFXComboBox<String> cbxNameTable;

    ObservableList<String> ObsPosition = FXCollections.observableArrayList();

    @FXML
    void onActionAddTable(ActionEvent event) {
        if (event.getTarget() == btnDeleteTabel) {
            if ("TRỐNG".equals(lblStatusTable.getText())) {
                try {
                    conn = functions.connectDB();
                    stmt = conn.createStatement();
                    stmt.executeUpdate(QuerySQL.deleteTableCoffee + idTable);
                    functions.ShowNotify("XÓA BÀN", "BÀN ĐÃ ĐƯỢC XÓA KHỎI QUÁN COFFEE .", NotificationType.SUCCESS);
                    stmt.close();
                    conn.close();
                    Stage current = (Stage) btnDeleteTabel.getScene().getWindow();
                    current.hide();
                    functions.nextStage("/pkgView/DeleteTableInCoffee.fxml", "QUẢN LÍ QUÁN VINE COFFEE", true);
                } catch (SQLException ex) {
                    Logger.getLogger(DeleteTableInCoffeeController.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                functions.ShowNotify("XÓA BÀN", "BÀN ĐANG CÓ NGƯỜI NGỒI HOẶC ĐÃ XÓA.", NotificationType.ERROR);
            }
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // String = cbxNameTable.getSelectionModel().getSelectedItem();
        functions = new Function();
        SelectNameTable();

    }

    public void SelectNameTable() {
        try {
            conn = functions.connectDB();
            pst = conn.prepareStatement(QuerySQL.selectTableFood);
            rs = pst.executeQuery();
            while (rs.next()) {
                ObsPosition.add(rs.getString("Name"));
                TableInCoffee tc = new TableInCoffee(rs.getString("Name"), rs.getString("TableStatus"));
                cbxNameTable.setOnAction((event) -> {
                    try {
                        conn = functions.connectDB();
                        pst = conn.prepareStatement("SELECT * FROM TableFood WHERE Name=N'" + cbxNameTable.getSelectionModel().getSelectedItem() + "'");
                        rs = pst.executeQuery();
                        while (rs.next()) {
                            lblStatusTable.setText(rs.getString("TableStatus"));
                            lblNameTable.setText(rs.getString("Name"));
                            idTable = Integer.parseInt(rs.getString("ID"));
                        }
                        cbxNameTable.setItems(ObsPosition);
                        pst.close();
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(DeleteTableInCoffeeController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
            }
            cbxNameTable.setItems(ObsPosition);
            pst.close();
            conn.close();
        } catch (SQLException e) {

        }
    }
}
