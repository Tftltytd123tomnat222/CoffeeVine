package pkgModels;
public class QuerySQL {
    // Login 
    public static final String loginCoffee      ="SELECT * FROM lgCof WHERE lgUser=? AND lgPass =? AND lgPosition=?";
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    // Trang chủ
    
    
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    // Thống kê 
    
    
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    // Bàn và Hóa đơn 
    public static final String selectTableFood  ="EXEC SP_SXTableFood";
    
    public static final String selectListFood   ="SELECT img,id,name,price FROM Food";
    
    public static final String selectBillFood   ="SELECT img,id,name,price FROM Food WHERE id=";
    
    public static final String addFoodToBill    ="EXEC SP_ThongTinHoaDon ";

    public static final String insertTable_ = "EXEC SP_InsertTableFood N'";
    public static final String _StatusCoffee = "',N'TRỐNG'";
    
    
    public static final String deleteTableCoffee = "EXEC SP_DeleteTableFood ";
    

    
    ////////////////////////////////////////////////////////////////////////////
    // Nhân viên
    
    
    
    
    
    
    
    ////////////////////////////////////////////////////////////////////////////
    // Thực đơn 

    

    
    ////////////////////////////////////////////////////////////////////////////
    // Hổ trợ 
    

}
