/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgModels;

/**
 *
 * @author ng1an
 */
public class AddBill {
    String soBan;
    String price;
    String name;
    String img;
    public AddBill(String soBan, String price, String name, String img) {
        this.soBan = soBan;
        this.price = price;
        this.name = name;
        this.img = img;
    }

    public String getSoBan() {
        return soBan;
    }

    public void setSoBan(String soBan) {
        this.soBan = soBan;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }
}