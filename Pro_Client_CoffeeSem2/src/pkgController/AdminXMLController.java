package pkgController;

import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import static com.sun.deploy.cache.Cache.reset;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import net.sf.jasperreports.engine.JRException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import pkgMayTinh.MayTinh;
import pkgModels.AddBill;
import pkgModels.Details;
import pkgModels.InBill;
import pkgModels.QuerySQL;
import pkgModels.TableandBill;
import pkgRun.Function;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

public class AdminXMLController implements Initializable {

    @FXML
    private Function functions;
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private Statement statement;

    @FXML
    private StackPane stackPane;
    @FXML
    private AnchorPane anpTrangchu;
    @FXML
    private AnchorPane anpMenu;
    @FXML
    private AnchorPane anpThongKe;
    @FXML
    private AnchorPane anpNhanVien;
    @FXML
    private AnchorPane anpHoaDon;
    @FXML
    private AnchorPane anpHoTro;

    @FXML
    private JFXMasonryPane masonryPane;

    @FXML
    private JFXButton btnTrangChuCoffee;
    @FXML
    private JFXButton btnMenuCoffee;
    @FXML
    private JFXButton btnThongKeCoffee;
    @FXML
    private JFXButton btnNhanVienCoffee;
    @FXML
    private JFXButton btnHoaDonCoffee;
    @FXML
    private JFXButton btnHoTroCoffee;
    @FXML
    private JFXButton btnLogoutAdminCoffee;

    // BÀN _ HÓA ĐƠN   ----------------------------------------------------------------------------------
    @FXML
    private AnchorPane anpPaneTable;
    @FXML
    private AnchorPane anpTableFoodCoffee;
    int sL = 0;
    @FXML
    private AnchorPane listProduct;
    @FXML
    public Label soBanBill;
    @FXML
    private Label txtTongTienBill;
    @FXML
    private JFXTextField txtThue;
    @FXML
    private ListView listFood;
    public JFXButton btnFood;

    @FXML
    private JFXButton btnMayTinhBill;
    @FXML
    private JFXButton btnInBill;
    @FXML
    private JFXButton btnXoaBill;
    @FXML
    private JFXButton btnTinhBill;

    @FXML
    private JFXButton btnAddTable;
    @FXML
    private JFXButton btnResetTable;
    @FXML
    private JFXButton btnDeleteTable;

    @FXML
    private JFXButton btnAddToBill;
    @FXML
    private JFXTextField txtSLAddToBill;
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

    private ObservableList<Details> obltableBill;

    String idTableProduct;
    String idFoodProduct;
    int countProduct = 0;
    int idMaxBill = 0;

    // Action Bill // Button In , Tính , Xóa , Máy tính 
    @FXML
    void onActionBill(ActionEvent event) {
        if (event.getTarget() == btnInBill) {

        } else if (event.getTarget() == btnTinhBill) {
            try {
                // TONG TIEN
                conn = functions.connectDB();
                statement = conn.createStatement();
                statement.executeUpdate("EXEC SP_Income " + Float.parseFloat(txtTongTienBill.getText()));
                statement.close();
                conn.close();

                // -- UPDATE Về bàn trống
                conn = functions.connectDB();
                statement = conn.createStatement();
                statement.executeUpdate("EXEC SP_DELTableFood " + idTableProduct);
                statement.close();
                conn.close();
                functions.ShowNotify("THANH TOÁN", ">><< ĐÃ THANH TOÁN HÓA ĐƠN BÀN >><<", NotificationType.SUCCESS);

                // -- Xóa Tất cả dử liệu of bàn 
                conn = functions.connectDB();
                statement = conn.createStatement();
                statement.executeUpdate("EXEC SP_delThongTinHoaDon " + idTableProduct);
                statement.close();
                conn.close();

            } catch (SQLException ex) {
                Logger.getLogger(AdminXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (event.getTarget() == btnMayTinhBill) {
            new MayTinh().setVisible(true);
        } else if (event.getTarget() == btnXoaBill) {
            // System.out.println(idTableProduct);
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
                float income = 0;
                while (rs.next()) {
                    bill.add(new InBill(String.valueOf(stt + 1), rs.getString(1), rs.getString(3), rs.getString(2), rs.getString(4)));
                    stt++;
                    income = income + Float.parseFloat(rs.getString(4));
                }
                txtTongTienBill.setText("" + income);
            } catch (SQLException ex) {
                Logger.getLogger(AdminXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else if (event.getTarget() == btnAddToBill) {
            try {
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

    @FXML
    void onActionTable(ActionEvent event
    ) {
        if (event.getTarget() == btnAddTable) {
            functions.nextStage(Function.XMLAddTableInCoffee, "THÊM BÀN - QUÁN COFFEE", true);
        } else if (event.getTarget() == btnResetTable) {
            Stage current = (Stage) btnResetTable.getScene().getWindow();
            current.hide();
            functions.nextStage(Function.XMLAdminCoffee, "QUẢN LÍ QUÁN VINE COFFEE", true);
        } else if (event.getTarget() == btnDeleteTable) {
            functions.nextStage(Function.XMLDelteTableInCoffee, "XÓA BÀN - QUÁN COFFEE", true);
        }
    }

    @FXML
    void onMouseAddBill(MouseEvent e
    ) {
        if (e.getTarget() == btnCongAddToBill) {
            sL = sL + 1;
            txtSLAddToBill.setText("" + sL);
        } else if (e.getTarget() == btnTruAddToBill) {
            sL = sL - 1;
            txtSLAddToBill.setText("" + sL);
        }
    }

    // THỐNG KÊ   ----------------------------------------------------------------------------------
    @FXML
    private AnchorPane anpTable_TK;
    @FXML
    private AnchorPane anpChart_TK;
    @FXML
    private JFXButton btnExcel_TK;
    @FXML
    private JFXButton btnIn_TK;
    @FXML
    private JFXButton btnViewTable_TK;
    @FXML
    private JFXButton btnViewChart_TK;
    @FXML
    private JFXButton btnMoney_TK;
    @FXML
    private JFXButton btnReset_TK;

    public JFXButton btnTable;

    @FXML
    private TableView<Details> TableExprot;

    @FXML
    private TableColumn<Details, String> colID;

    @FXML
    private TableColumn<Details, String> colDate;

    @FXML
    private TableColumn<Details, String> colName;

    @FXML
    private TableColumn<Details, String> colNumber;

    @FXML
    private TableColumn<Details, String> colNote;

    private ObservableList<Details> data;
    @FXML
    private AnchorPane anpTongTienThuNhap;

    @FXML
    private Label txtTongTienThuNhap;
    @FXML
    void onActionThongKe(ActionEvent e) throws JRException {
        
        // Xuất Excel
        if (e.getTarget() == btnExcel_TK) {
            FileChooser chooser = new FileChooser();
            // Set extension filter
            FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Excel Files(*.xls)", "*.xls");
            chooser.getExtensionFilters().add(filter);
            // Show save dialog
            File file = chooser.showSaveDialog(btnExcel_TK.getScene().getWindow());
            if (file != null) {
                saveXLSFile(file);
            }
            
        // In giấy A4    
        } else if (e.getTarget() == btnIn_TK) {
//            String report = "src\\pkgreports\\finalFarmers.jrxml";
//            conn = functions.connectDB();
//            JasperReport jr = JasperCompileManager.compileReport(report);
//            JasperPrint jp = JasperFillManager.fillReport(jr, null, conn);
//            JasperViewer.viewReport(jp, false);

        // Hiển thị Table
        } else if (e.getTarget() == btnViewTable_TK) {
            buildTableviewData();
            TableExprot.setVisible(true);
            hideThongKe();
            anpTable_TK.setVisible(true);
            
        //Hiển thị biểu đồ    
        } else if (e.getTarget() == btnViewChart_TK) {
            hideThongKe();
            anpChart_TK.setVisible(true);
            
        //Tổng tiền thu nhập    
        } else if (e.getTarget() == btnMoney_TK) {
            try {
                float tongtien = 0;
                String query = "SELECT * FROM incomeProduct";
                conn = functions.connectDB();
                pst = conn.prepareStatement(query);
                rs = pst.executeQuery();
                while (rs.next()) {
                    tongtien = Float.parseFloat(rs.getString(1));
                }
                txtTongTienThuNhap.setText(""+tongtien +" ĐỒNG");
                hideThongKe();
                anpTongTienThuNhap.setVisible(true);
                

            } catch (SQLException ex) {
                Logger.getLogger(AdminXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            // Refresh
        } else if (e.getTarget() == btnReset_TK) {
            TableExprot.getItems().clear();
            buildTableviewData();
        }
    }

   // Dữ liệu Table
    private void buildTableviewData() {
        try {
            conn = functions.connectDB();
            data = FXCollections.observableArrayList();
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT * FROM Statistical");
            while (rs.next()) {
                String ID = rs.getString(1).toUpperCase();
                String Date = rs.getDate(2).toString();
                String Name = rs.getString(3).toUpperCase();
                String Number = rs.getString(4).toUpperCase();
                String Note = rs.getString(5).toUpperCase();

                data.add(new Details(ID, Date, Name, Number, Note));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        colID.setCellValueFactory(new PropertyValueFactory<>("Mã phiếu"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("Ngày lập"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Tên hàng"));
        colNumber.setCellValueFactory(new PropertyValueFactory<>("Số lượng"));
        colNote.setCellValueFactory(new PropertyValueFactory<>("Ghi chú"));

        TableExprot.setItems(null);
        TableExprot.setItems(data);

    }

    private void saveXLSFile(File file) {
        try {
            conn = functions.connectDB();
            FileOutputStream fileOut;
            fileOut = new FileOutputStream(file);
            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet workSheet = workbook.createSheet("sheet 0");
            Row row1 = workSheet.createRow((short) 0);
            row1.createCell(0).setCellValue("Mã phiếu");
            row1.createCell(1).setCellValue("Ngày lập");
            row1.createCell(2).setCellValue("Tên hàng");
            row1.createCell(3).setCellValue("Số lượng");
            row1.createCell(4).setCellValue("Ghi chú");
            Row row2;

            rs = conn.createStatement().executeQuery("SELECT * FROM Statistical");
            while (rs.next()) {
                int a = rs.getRow();
                row2 = workSheet.createRow((short) a);
                row2.createCell(0).setCellValue(rs.getString(1));
                row2.createCell(1).setCellValue(rs.getString(2));
                row2.createCell(2).setCellValue(rs.getString(3));
                row2.createCell(3).setCellValue(rs.getString(4));
                row2.createCell(4).setCellValue(rs.getString(5));
            }
            workbook.write(fileOut);
            fileOut.flush();
            fileOut.close();
            rs.close();
            conn.close();
            TrayNotification tn = new TrayNotification("NEW EXCEL FILE", "Specified excel file successfully generated", NotificationType.SUCCESS);
            tn.showAndWait();
        } catch (SQLException | IOException e) {
            TrayNotification tn = new TrayNotification("NEW EXCEL FILE", "Could not generate specified file", NotificationType.ERROR);
            tn.showAndWait();
            System.err.println(e);

        }
    }

    // Hổ trợ   ----------------------------------------------------------------------------------
    @FXML
    private ImageView btnFacebookContact;
    @FXML
    private ImageView btnYoutubeContact;
    @FXML
    private ImageView btnTwitterContact;
    @FXML
    private ImageView btnSkypeContact;
    @FXML
    private WebView webMap;
    private WebEngine webEngine;

    @FXML
    void onMouseButtonContact(MouseEvent e) {
        if (e.getTarget() == btnFacebookContact) {

        } else if (e.getTarget() == btnYoutubeContact) {

        } else if (e.getTarget() == btnTwitterContact) {

        } else if (e.getTarget() == btnSkypeContact) {

        }
    }

    // Nhân viên
    @FXML
    private TableView<?> TableEmployee;

    @FXML
    private TableColumn<?, ?> colSex;

    @FXML
    private TableColumn<?, ?> colSDT;

    @FXML
    private TableColumn<?, ?> colStreet;

    @FXML
    private TableColumn<?, ?> colMoney;

    @FXML
    private TableColumn<?, ?> colPos;

    @FXML
    private JFXTextField txtID;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtSdt;

    @FXML
    private JFXTextField txtStreet;

    @FXML
    private JFXTextField txtSeach;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnEdit;

    @FXML
    private JFXButton btnDetele;

    @FXML
    private JFXButton btnChose;

    @FXML
    private RadioButton Male;

    @FXML
    private ImageView ImageView;

    @FXML
    private ToggleGroup Gender;

    @FXML
    private RadioButton Female;

    @FXML
    private JFXButton btnSeach;
    private final String pattern = "yyyy-MM-dd";

    @FXML
    void onActionNhanVien(ActionEvent event) {
        if (event.getTarget() == btnChose) {
            FileChooser fc = new FileChooser();
            fc.setInitialDirectory(new File("C:\\"));
            fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Image File( *.jpg, *.png)", "*.jpg", "*.png"));
            File seletedFile = fc.showOpenDialog(null);
            ImageView.getImage();
// --------------------------------------------------------------------------
        } else if (event.getTarget() == btnAdd) {

        } else if (event.getTarget() == btnEdit) {

        } else if (event.getTarget() == btnSeach) {
            try {
                boolean isFarmer = false;
                String query = "SELECT * FROM Employees WHERE EmployeesID=?";
                conn = functions.connectDB();
                pst = conn.prepareStatement(query);
                pst.setString(1, txtSeach.getText());
                rs = pst.executeQuery();
                while (rs.next()) {
                    txtID.setText(rs.getString(2));
                    txtName.setText(rs.getString(3));
                    txtSdt.setText(rs.getString(4));
                    txtStreet.setText(rs.getString(5));
//                txtMobile.setText(String.valueOf(rs.getInt(6)));
//                chJobCat.getSelectionModel().selectFirst();
                    isFarmer = true;
                }
                if (!isFarmer) {
                    reset();
                }

            } catch (SQLException ex) {
                Logger.getLogger(AdminXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (event.getTarget() == btnDetele) {

        }

    }

    public void Gender() throws SQLException {
        if (null != rs.getString("Gender")) {
            switch (rs.getString("Gender")) {
                case "Male":
                    Male.setSelected(true);
                    break;
                case "Female":
                    Female.setSelected(true);
                    break;
                default:
                    Male.setSelected(false);
                    Female.setSelected(false);
                    break;
            }
        } else {
            Male.setSelected(false);
            Female.setSelected(false);
        }
    }

    public void theQuery() {

    }

    private void buildTableEmployeeData() {
        try {
            conn = functions.connectDB();
            data = FXCollections.observableArrayList();
            statement = conn.createStatement();
            rs = statement.executeQuery("SELECT * FROM Statis");
            while (rs.next()) {
                String ID = rs.getString(1).toUpperCase();
                String Date = rs.getDate(2).toString();
                String Name = rs.getString(3).toUpperCase();
                String Number = rs.getString(4).toUpperCase();
                String Note = rs.getString(5).toUpperCase();

                data.add(new Details(ID, Date, Name, Number, Note));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        colID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("Ngày lập"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Tên hàng"));
        colNumber.setCellValueFactory(new PropertyValueFactory<>("Số lượng"));
        colNote.setCellValueFactory(new PropertyValueFactory<>("Ghi chú"));

//        TableExprot.setItems(null);
        TableExprot.setItems(data);

    }

    // ------------------------------------------------------------------------------------
    ////////////////////////////////////////////////////////////////////////////
//    
//    Mặc định anp
//    
    ////////////////////////////////////////////////////////////////////////////
    public void logoutAdmin() {
        Alert notify = new Alert(Alert.AlertType.CONFIRMATION);
        notify.setTitle("THÔNG BÁO");
        notify.setHeaderText("ĐĂNG XUẤT KHỎI HỆ THỐNG");
        notify.setContentText("Bạn có muốn đăng xuất hay không?");
        Optional<ButtonType> ac = notify.showAndWait();
        if (ac.get() == ButtonType.OK) {
            functions.nextStage(Function.XMLLoginCoffee, "ĐĂNG NHẬP SYSTEM COFFEE", true);
            Stage current = (Stage) btnLogoutAdminCoffee.getScene().getWindow();
            current.hide();
        }
    }

    @FXML
    void onActionButton(ActionEvent e) {
        if (e.getTarget() == btnTrangChuCoffee) {
            showPane();
            anpTrangchu.setVisible(true);
        } else if (e.getTarget() == btnMenuCoffee) {
            showPane();
            anpMenu.setVisible(true);
        } else if (e.getTarget() == btnThongKeCoffee) {
            showPane();
            anpThongKe.setVisible(true);
        } else if (e.getTarget() == btnHoaDonCoffee) {
            showPane();
            anpHoaDon.setVisible(true);
        } else if (e.getTarget() == btnHoTroCoffee) {
            showPane();
            anpHoTro.setVisible(true);
        } else if (e.getTarget() == btnLogoutAdminCoffee) {
            logoutAdmin();
        }
    }

    ////////////////////////////////////////////////////////////////////////////
//    
//    Phương thức khởi tạo Run
//    
    ////////////////////////////////////////////////////////////////////////////
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // khởi tạo lớp chức năng 
        functions = new Function();
        buildTableviewData();
        soBanBill.setText(null);
        // Map địa chỉ con quán Coffee
        showMapContact();

        //Date Formatter
        StringConverter converter = new StringConverter<LocalDate>() {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return formatter.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, formatter);

                } else {
                    return null;
                }
            }

        };

        // Load bàn .....
        Get_TableFood();

        // Load món ăn
        Get_ListFood();

    }

    public void showPane() {
        anpMenu.setVisible(false);
        anpThongKe.setVisible(false);
        anpHoaDon.setVisible(false);
        anpHoTro.setVisible(false);
        anpTrangchu.setVisible(false);
    }

    //
    //
    //
    // Map địa chỉ con quán Coffee
    public void showMapContact() {
        webEngine = webMap.getEngine();
        webEngine.load("https://www.google.co.in/maps/place/38+Y%C3%AAn+B%C3%A1i,+H%E1%BA%A3i+Ch%C3%A2u+1,+Q.+H%E1%BA%A3i+Ch%C3%A2u,+%C4%90%C3%A0+N%E1%BA%B5ng,+Vi%E1%BB%87t+Nam/@16.0694416,108.2217891,17.75z/data=!4m5!3m4!1s0x31421833d5d33d15:0xdbd9a00a7271b8c8!8m2!3d16.069404!4d108.222585");
    }

    // Thống kê Table vs Chart
    public void hideThongKe() {
        anpTongTienThuNhap.setVisible(false);
        anpTable_TK.setVisible(false);
        anpChart_TK.setVisible(false);
    }

    //
    //
    //
    // Load bàn .....
    public void Get_TableFood() {
        try {
            conn = functions.connectDB();
            pst = conn.prepareStatement(QuerySQL.selectTableFood);
            rs = pst.executeQuery();
            while (rs.next()) {
                btnTable = new JFXButton(rs.getString("Name"));
                switch (rs.getString("TableStatus")) {
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
                btnTable.setPrefSize(63, 57);
                TableandBill gs = new TableandBill(rs.getString("ID"), rs.getString("Name"), rs.getString("TableStatus"));
                btnTable.setOnMouseClicked((MouseEvent e) -> {
                    // -- Add số bàn
                    soBanBill.setText(gs.getNameTable());

                    // lấy id bàn
                    idTableProduct = gs.getIdTable();

                    // -- Lấy dử liệu trạng thái của bàn được chọn
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
                        pst = conn.prepareStatement(QuerySQL.addFoodToBill + gs.getIdTable());
                        rs = pst.executeQuery();
                        int stt = 0;
                        // == Tinsh tong tien bill
                        float income = 0;
                        while (rs.next()) {
                            bill.add(new InBill(String.valueOf(stt + 1), rs.getString(1), rs.getString(3), rs.getString(2), rs.getString(4)));
                            stt++;
                            income = income + Float.parseFloat(rs.getString(4));
                        }
                        txtTongTienBill.setText("" + income);

                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }

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
                btnFood.setPrefSize(320, 70);
                listFood.getItems().add(btnFood);
                btnFood.setStyle("-fx-font: 17 arial; -fx-base: #b6e7c9;");

                AddBill add = new AddBill(rs.getString("id"), rs.getString("price"), rs.getString("name"), rs.getString("img"));
                btnFood.setOnMouseClicked((MouseEvent e) -> {
                    if (soBanBill.getText() == null || soBanBill.getText().isEmpty()) {
                        functions.ShowNotify("LỖI CHỌN BÀN", "Bạn chưa chọn bàn, vui lòng kiểm tra lại !", NotificationType.ERROR);
                    } else {
                        try {
                            conn = functions.connectDB();
                            pst = conn.prepareStatement(QuerySQL.selectBillFood + add.getSoBan());
                            rs = pst.executeQuery();
                            while (rs.next()) {
                                imgAddToBill.getChildren().add(new ImageView(new Image(getClass().getResourceAsStream("/pkgImages/Coffee/null.jpg"))));
                                Image img = new Image(getClass().getResourceAsStream(rs.getString("img")));
                                ImageView imgAdd = new ImageView(img);
                                imgAddToBill.getChildren().add(imgAdd);

                                lblNameAddToBill.setText(rs.getString("name"));
                                lblPriceAddToBill.setText("Giá : " + rs.getString("price") + " Đồng");

                                txtSLAddToBill.setText("" + 1);

                                // Lấy id đồ uống
                                idFoodProduct = rs.getString("id");
                            }
                        } catch (SQLException ex) {
                            System.out.println(ex);
                        }
                    }
                });
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public void Get_BillFood() {
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
    }
}
