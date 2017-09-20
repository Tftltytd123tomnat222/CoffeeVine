/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgRun;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import pkgConnectDB.ConnectDB;
import pkgInterface.LoginCF;


/**
 *
 * @author ng1an
 */
public class RunServerXMLController extends UnicastRemoteObject implements Initializable,LoginCF {
    public RunServerXMLController() throws RemoteException{
        super();
    }
    
    
    Connection conn  = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    
    @FXML
    private Function functions;
    @FXML
    private AnchorPane anpConnect;
    @FXML
    private AnchorPane anpLoading;

    @FXML
    void onServerAction(ActionEvent e) {
        try {
            ConnectDB.connectData();
            LoginCF myServerRMI = new RunServerXMLController();
            LocateRegistry.createRegistry(2222);
            Naming.bind("rmi://localhost:2222/ServerRMI", myServerRMI);
            //System.out.println("Server is Ready...");
            
            // -- Chạy luồng Thread
            anpConnect.setVisible(false);
            anpLoading.setVisible(true);
            new clsLoading().start();
            
        } catch (RemoteException ex) {
            System.out.println(ex.getMessage());
            anpConnect.setVisible(true);
            anpLoading.setVisible(false);
        } catch (AlreadyBoundException | MalformedURLException ex) {
            Logger.getLogger(RunServerXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    void onMouseClicked(MouseEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        functions = new Function();
        
    }

    @Override
    public boolean checkLogin(String lgUser, String lgPass, String lgPosition) throws RemoteException {
        try {
            String query = "SELECT * FROM lgCof WHERE lgUser=? AND lgPass =? AND lgPosition=?";
            conn = ConnectDB.connectData();
            ps = conn.prepareStatement(query);
            ps.setString(1, lgUser);
            ps.setString(2, lgPass);
            ps.setString(3, lgPosition);
            rs = ps.executeQuery();
            if(rs.next()) {    
                conn.close();
                ps.close();
                rs.close();
                return true;
            }
            else{
                conn.close();
                ps.close();
                rs.close();
                return true;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        // return true;
        return equals(ref);

    }
    
    
    
    
    
    
    
    
    
    // ---- LOADING
    class clsLoading extends Thread{
        @Override
        public void run() {
            try {
                Thread.sleep(2000);
                // Platform.runLater(new Runnable() 
                Platform.runLater(() -> {
                    
                });
            } catch (InterruptedException e) {
                System.out.println(e);
            }
            
        } 
    }
    
}
