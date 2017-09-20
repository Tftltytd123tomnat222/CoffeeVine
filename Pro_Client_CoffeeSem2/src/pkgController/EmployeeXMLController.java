package pkgController;

import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pkgModels.AddBill;
import pkgModels.InBill;
import pkgModels.QuerySQL;
import pkgModels.TableandBill;
import pkgRun.Function;
import tray.notification.NotificationType;

public class EmployeeXMLController implements Initializable {

    private Statement statement;
    @FXML
    private JFXNodesList nodeListBill;
    @FXML
    private Function functions;
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    @FXML
    private JFXButton btnQuayLaiEmp;
    @FXML
    private JFXButton btnMenu;

    @FXML
    private JFXMasonryPane masonryPane;
    @FXML
    private ListView listFood;
    @FXML
    private Label lblSoBan;

    @FXML
    private AnchorPane anpTong;

    public JFXButton btnTable;
    public JFXButton btnFood;

    @FXML
    void onClickEmployee(ActionEvent event) {
        if (event.getTarget() == btnMenu) {
            if (nodeListBill.isVisible()) {
                nodeListBill.setVisible(false);
            } else {
                nodeListBill.setVisible(true);
            }
        } else if (event.getTarget() == btnQuayLaiEmp) {
            if (paneAddTable.isVisible()) {
                Alert notify = new Alert(Alert.AlertType.CONFIRMATION);
                notify.setTitle("THÔNG BÁO");
                notify.setHeaderText("ĐĂNG XUẤT KHỎI HỆ THỐNG");
                notify.setContentText("Bạn có muốn đăng xuất hay không?");
                Optional<ButtonType> ac = notify.showAndWait();
                if (ac.get() == ButtonType.OK) {
                    functions.nextStage(Function.XMLLoginCoffee, "ĐĂNG NHẬP SYSTEM COFFEE", true);
                    Stage current = (Stage) btnTable.getScene().getWindow();
                    current.hide();
                }
            } else if (paneAddFood.isVisible()) {
                lblSoBan.setText(null);
                hidePane();
                paneAddTable.setVisible(true);
            } else if (paneAddBill.isVisible()) {
                hidePane();
                paneAddFood.setVisible(true);
            }
        }
    }

    @FXML
    private JFXButton btnLamMoi;

    @FXML
    private JFXButton btnChuyenBan;

    @FXML
    private JFXButton btnGopBan;

    @FXML
    private JFXButton btnDangXuat;

    @FXML
    void onActionMenuOrder(ActionEvent event) {
        if (event.getTarget() == btnLamMoi) {
            //
            //
            //
            //  ? LOADER
            //
            //
            //
            Stage current = (Stage) btnLamMoi.getScene().getWindow();
            current.hide();
            functions.nextStage(Function.XMLEmployeeCoffee, "NHÂN VIÊN", true);
        } else if (event.getTarget() == btnChuyenBan) {
            //
            //
            //
            //  ? Chuyển bàn
            //
            //
            //

        } else if (event.getTarget() == btnGopBan) {
            //
            //
            //
            //  ? Gộp bàn
            //
            //
            //
        } else if (event.getTarget() == btnDangXuat) {
            Alert notify = new Alert(Alert.AlertType.CONFIRMATION);
            notify.setTitle("THÔNG BÁO");
            notify.setHeaderText("ĐĂNG XUẤT KHỎI HỆ THỐNG");
            notify.setContentText("Bạn có muốn đăng xuất hay không?");
            Optional<ButtonType> ac = notify.showAndWait();
            if (ac.get() == ButtonType.OK) {
                functions.nextStage(Function.XMLLoginCoffee, "ĐĂNG NHẬP SYSTEM COFFEE", true);
                Stage current = (Stage) btnTable.getScene().getWindow();
                current.hide();
            }
        }
    }
    @FXML
    private JFXButton btnAddToBill;
    @FXML
    private Label txtSLAddToBill;
    @FXML
    private AnchorPane imgAddToBill;
    @FXML
    public Label lblPriceAddToBill;
    @FXML
    private Label lblNameAddToBill;
    @FXML
    private ImageView btnCongAddToBill;
    @FXML
    private ImageView btnTruAddToBill;

    @FXML
    private JFXTreeTableView<InBill> treeTableBill;

    int sL = 0;
    int countProduct = 0;
    int idTableProduct = 0;
    int idMaxBill = 0;
    int idFoodProduct = 0;

    @FXML
    void onMouseAddBill(MouseEvent event) {
        if (event.getTarget() == btnCongAddToBill) {
            sL = sL + 1;
            txtSLAddToBill.setText("" + sL);
        } else if (event.getTarget() == btnTruAddToBill) {
            sL = sL - 1;
            txtSLAddToBill.setText("" + sL);

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        functions = new Function();
        nodeListBill.setVisible(false);
        Get_TableFood();
        Get_ListFood();

    }

    public void Get_TableFood() {
        try {
            conn = functions.connectDB();
            pst = conn.prepareStatement(QuerySQL.selectTableFood);
            rs = pst.executeQuery();
            while (rs.next()) {
                btnTable = new JFXButton(rs.getString(2));
                switch (rs.getString(3)) {
                    case "TRỐNG":
                        btnTable.setStyle("-fx-background-color: #7e9189");
                        break;
                    case "CÓ NGƯỜI":
                        btnTable.setStyle("-fx-background-color: #1fad7f");
                        break;
                    case "ĐẶT TRƯỚC":
                        btnTable.setStyle("-fx-background-color: #d04f69");
                        break;
                    default:
                        btnTable.setStyle("-fx-background-color: #7e9189");
                        break;
                }
                TableandBill gs = new TableandBill(rs.getString(1), rs.getString(2), rs.getString(3));
                btnTable.setOnMouseClicked((MouseEvent e) -> {
                    //
                    //
                    //
                    //
                    //
                    //
                    hidePane();
                    paneAddFood.setVisible(true);
                    lblSoBan.setText("BÀN " + gs.getNameTable());
                    idTableProduct = Integer.parseInt(gs.getIdTable());
                });
                masonryPane.getChildren().add(btnTable);
                masonryPane.setVisible(true);
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void Get_ListFood() {
        try {
            conn = functions.connectDB();
            pst = conn.prepareStatement(QuerySQL.selectListFood);
            rs = pst.executeQuery();
            while (rs.next()) {
                Image imageOk = new Image(getClass().getResourceAsStream(rs.getString("img")));
                ImageView imgFood = new ImageView(imageOk);
                btnFood = new JFXButton(rs.getString("name"), imgFood);
                // btnFood = new JFXButton(rs.getString("name"));
                btnFood.setAlignment(Pos.BASELINE_LEFT);
                btnFood.setPrefSize(345, 70);
                listFood.getItems().add(btnFood);
                btnFood.setStyle("-fx-font: 17 arial; -fx-base: #b6e7c9;");

                AddBill add = new AddBill(rs.getString("id"), rs.getString("price"), rs.getString("name"), rs.getString("img"));
                btnFood.setOnMouseClicked((MouseEvent e) -> {
                    //
                    //
                    //
                    //
                    //
                    //
                    imgAddToBill.getChildren().add(new ImageView(new Image(getClass().getResourceAsStream("/pkgImages/Coffee/null.jpg"))));
                    imgAddToBill.getChildren().add(new ImageView(new Image(getClass().getResourceAsStream(add.getImg()))));
                    lblNameAddToBill.setText(add.getName());
                    lblPriceAddToBill.setText("Giá : " + add.getPrice() + " Đồng");

                    txtSLAddToBill.setText("" + 1);
                    hidePane();
                    paneAddBill.setVisible(true);

                    idFoodProduct = Integer.parseInt(add.getSoBan());

                    // =========================================================
                    try {
                        JFXTreeTableColumn<InBill, String> sttFood = new JFXTreeTableColumn<>("STT");
                        sttFood.setPrefWidth(30);
                        sttFood.setCellValueFactory((TreeTableColumn.CellDataFeatures<InBill, String> param) -> param.getValue().getValue().sttFood);

                        JFXTreeTableColumn<InBill, String> nameFood = new JFXTreeTableColumn<>("Tên");
                        nameFood.setPrefWidth(105);
                        nameFood.setCellValueFactory((TreeTableColumn.CellDataFeatures<InBill, String> param) -> param.getValue().getValue().nameFood);

                        JFXTreeTableColumn<InBill, String> priceFood = new JFXTreeTableColumn<>("Giá");
                        priceFood.setPrefWidth(65);
                        priceFood.setCellValueFactory((TreeTableColumn.CellDataFeatures<InBill, String> param) -> param.getValue().getValue().priceFood);

                        JFXTreeTableColumn<InBill, String> numberFood = new JFXTreeTableColumn<>("SL");
                        numberFood.setPrefWidth(30);
                        numberFood.setCellValueFactory((TreeTableColumn.CellDataFeatures<InBill, String> param) -> param.getValue().getValue().numberFood);

                        JFXTreeTableColumn<InBill, String> sumPriceFood = new JFXTreeTableColumn<>("T.Tiền");
                        sumPriceFood.setPrefWidth(70);
                        sumPriceFood.setCellValueFactory((TreeTableColumn.CellDataFeatures<InBill, String> param) -> param.getValue().getValue().sumPriceFood);

                        ObservableList<InBill> bill = FXCollections.observableArrayList();

                        TreeItem<InBill> root = new RecursiveTreeItem<>(bill, RecursiveTreeObject::getChildren);

                        treeTableBill.getColumns().setAll(sttFood, nameFood, numberFood, priceFood, sumPriceFood);
                        treeTableBill.setRoot(root);
                        treeTableBill.setShowRoot(false);
                        conn = functions.connectDB();
                        pst = conn.prepareStatement("EXEC SP_ThongTinHoaDon " + idTableProduct);
                        rs = pst.executeQuery();
                        int stt = 0;
                        // == Tinsh tong tien bill
                        while (rs.next()) {
                            bill.add(new InBill(String.valueOf(stt + 1), rs.getString(1), rs.getString(3), rs.getString(2), rs.getString(4)));
                            stt++;
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(AdminXMLController.class.getName()).log(Level.SEVERE, null, ex);
                    }

                });
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private AnchorPane paneAddBill;
    @FXML
    private AnchorPane paneAddFood;
    @FXML
    private AnchorPane paneAddTable;

    public void hidePane() {
        paneAddBill.setVisible(false);
        paneAddFood.setVisible(false);
        paneAddTable.setVisible(false);

    }

    @FXML
    void onActionAddToBill(ActionEvent event) {
        if (event.getTarget() == btnAddToBill) {
            try {
                countProduct = Integer.parseInt(txtSLAddToBill.getText());
                countProduct = Integer.parseInt(txtSLAddToBill.getText());

//                System.out.println("INSERT VÀO BÀN CÓ ID VỪA CHỌN");
                conn = functions.connectDB();
                statement = conn.createStatement();
                statement.executeUpdate("EXEC SP_InsertBill " + idTableProduct);
                statement.close();
                conn.close();

//                System.out.println("LẤY GIÁ TRỊ BILL MAX VỪA TẠO");
                conn = functions.connectDB();
                pst = conn.prepareStatement("EXEC SP_BillMax");
                rs = pst.executeQuery();
                while (rs.next()) {
                    idMaxBill = Integer.parseInt(rs.getString(1));
                }
                rs.close();
                pst.close();
                conn.close();

//                System.out.println("UPDATE BÀN THÀNH CÓ NGƯỜI");
                conn = functions.connectDB();
                statement = conn.createStatement();
                statement.executeUpdate("EXEC SP_UPTableFood " + idTableProduct);
                statement.close();
                conn.close();
                functions.ShowNotify("THÊM ĐỒ UỐNG", "THÊM ĐỒ UỐNG THÀNH CÔNG ...", NotificationType.SUCCESS);

//                System.out.println("INSERT ĐỒ UỐNG VÀO");
                conn = functions.connectDB();
                //EXEC SP_InsertBillInfo 12,12,12
                pst = conn.prepareStatement("EXEC SP_InsertBillInfo " + idMaxBill + "," + idFoodProduct + "," + countProduct + "," + idTableProduct);
                rs = pst.executeQuery();
                rs.close();
                pst.close();
                conn.close();
            } catch (Exception ex) {
                System.out.print("");
            }
        }
    }
}
