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
public class TableandBill {
    private String idTable;
    private String nameTable;
    private String sttTable;

    public TableandBill(String idTable, String nameTable, String sttTable) {
        this.idTable = idTable;
        this.nameTable = nameTable;
        this.sttTable = sttTable;
    }

    /**
     * @return the idTable
     */
    public String getIdTable() {
        return idTable;
    }

    /**
     * @param idTable the idTable to set
     */
    public void setIdTable(String idTable) {
        this.idTable = idTable;
    }

    /**
     * @return the nameTable
     */
    public String getNameTable() {
        return nameTable;
    }

    /**
     * @param nameTable the nameTable to set
     */
    public void setNameTable(String nameTable) {
        this.nameTable = nameTable;
    }

    /**
     * @return the sttTable
     */
    public String getSttTable() {
        return sttTable;
    }

    /**
     * @param sttTable the sttTable to set
     */
    public void setSttTable(String sttTable) {
        this.sttTable = sttTable;
    }
    
}
