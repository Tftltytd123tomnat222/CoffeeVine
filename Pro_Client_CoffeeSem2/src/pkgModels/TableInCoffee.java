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
public class TableInCoffee {
    String Name;
    String Status;

    public TableInCoffee(String Name, String Status) {
        this.Name = Name;
        this.Status = Status;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

}
