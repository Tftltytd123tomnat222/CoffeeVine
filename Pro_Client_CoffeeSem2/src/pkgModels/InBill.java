package pkgModels;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class InBill extends RecursiveTreeObject<InBill>{
    public StringProperty sttFood;
    public StringProperty nameFood;
    public StringProperty priceFood;
    public StringProperty numberFood;
    public StringProperty sumPriceFood;

    public InBill(String sttFood, String nameFood, String priceFood, String numberFood, String sumPriceFood) {
        this.sttFood = new SimpleStringProperty(sttFood);
        this.nameFood = new SimpleStringProperty(nameFood);
        this.priceFood = new SimpleStringProperty(priceFood);
        this.numberFood = new SimpleStringProperty(numberFood);
        this.sumPriceFood = new SimpleStringProperty(sumPriceFood);
    } 
}
