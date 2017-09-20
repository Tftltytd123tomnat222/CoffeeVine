/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkgModels;


import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
/**
 *
 * @author TrongNguyen
 */
public class Details {
    private final StringProperty colID;
    private final StringProperty colDate;
    private final StringProperty colName;
    private final StringProperty colNumber;
    private final StringProperty colNote;

    public Details( String colID, String colDate,  String colName, String colNumber, String colNote) {
        this.colID = new SimpleStringProperty(colID);
        this.colDate = new SimpleStringProperty(colDate);
        this.colName = new SimpleStringProperty(colName);
        this.colNumber = new SimpleStringProperty(colNumber);
        this.colNote = new SimpleStringProperty(colNote);
    }


    
    public String getcolID(){
        return colID.get();
    }
    
    public void setcolID(String id){
        colID.set(id);
    }
    
    public StringProperty colIDProperty(){
        return colID;
    }
    
    public String  getcolDate(){
        return colDate.get();
    }
    
    public void setcolDate(String dt){
        colDate.set(dt);
    }
    
    public StringProperty colDateProperty(){
        return colDate;
    }
    
    public String getcolName(){
        return colName.get();
    }
    
    public void setcolName(String nm){
        colName.set(nm);
    }
    
    public StringProperty colNameProperty(){
        return colName;
    }
    
    public String getcolNumber(){
        return colNumber.get();
    }
    
    public void setcolNumber(String num){
        colNumber.set(num);
    }
    
    public StringProperty colNumber(){
        return colNumber;
    }
    
    public String getcolNote(){
        return colNote.get();
    }
    
    public void setcolNote(String nt){
        colNote.set(nt);
    }
    
    public StringProperty colNoteProperty(){
        return colNote;
    }
 
}
