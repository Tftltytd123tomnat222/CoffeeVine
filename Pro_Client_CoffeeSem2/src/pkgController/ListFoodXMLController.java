package pkgController;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.*;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
public class ListFoodXMLController implements Initializable {

    @FXML 
    private ImageView imgNameFood;
    @FXML 
    private Label nameFood;
    @FXML 
    private Label priceFood;

    static String  nameList;
    static String  priceList;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Get_ListProduct(nameList,priceList);
    } 

    public void Get_ListProduct(String name,String price) {
        nameFood.setText(name);
        priceFood.setText(price);
    }

    
}
