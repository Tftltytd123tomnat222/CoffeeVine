CREATE DATABASE QuanLyQuanCafe
GO

USE QuanLyQuanCafe

GO
/*
				TableFood
*/
--------------TableFood------------
CREATE TABLE TableFood
(
	ID INT IDENTITY,
	Name NVARCHAR(100) NOT NULL DEFAULT N'Bàn chưa có tên',
	Status NVARCHAR(100) NOT NULL DEFAULT N'Trống',	-- Trống || Có người || Đã đặt
	CONSTRAINT pk_IDTableFood PRIMARY KEY (ID)
)
GO	



CREATE PROC SP_DeleteTableFood
	@ID INT
AS
BEGIN
	DELETE FROM TableFood WHERE ID = @ID
END
EXEC SP_DeleteTableFood 12
--------------SP_InsertTableFood---------------------------
CREATE PROC SP_InsertTableFood
	@Name NVARCHAR(100),
	@Status NVARCHAR(100)
AS
BEGIN
	INSERT INTO TableFood 
	VALUES(@Name,@Status)
END

GO
--THUC HIEN CAU LENH THEM BAN
EXEC SP_InsertTableFood 'BAN' ,'Trống'
--------------SP_ShowTableFood---------
CREATE PROC SP_ShowTableFood
AS
BEGIN
	SELECT * FROM TableFood
END
--THUC HIEN CAU LENH SHOW BAN
EXEC SP_ShowTableFood

/*
					Positions
*/
---------them chuc vu Positions------------------------------------

CREATE TABLE Positions
(
	PositionID INT,
	PositionTitle NVARCHAR(100)
	CONSTRAINT pk_PositionID PRIMARY KEY (PositionID)
)
/*
					Account
*/

---------------------Account----------------------------------------------
CREATE TABLE Account
(
	UserName NVARCHAR(100),	
	DisplayName NVARCHAR(100) NOT NULL DEFAULT N'Cafe',
	PassWord NVARCHAR(1000) NOT NULL DEFAULT 0,
	PositionID INT,
	CONSTRAINT pk_UserNameAccount PRIMARY KEY(UserName),
	CONSTRAINT fk_PositionIDAccount FOREIGN KEY (PositionID) REFERENCES Positions(PositionID)
)
GO
---------them Employees------------------------------------
CREATE TABLE Employees
(
	EmployeesID INT,
	EmployeeName NVARCHAR(100),
	Sex BIT, --0 nu && 1 nam
	Birthday DATETIME,
	Address1 NVARCHAR(150),
	Address2 NVARCHAR(150),
	Phone NVARCHAR(11),
	Passport NVARCHAR(10),
	Img NVARCHAR(150),
	Note NVARCHAR(150),
	PositionID INT,
	CONSTRAINT pk_EmployeesID PRIMARY KEY (EmployeesID),
	CONSTRAINT fk_PositionIDEmployees FOREIGN KEY (PositionID) REFERENCES Positions(PositionID)
)
GO
--SP_InsertEmployees
CREATE PROC SP_InsertEmployees
	@EmployeesID INT,
	@EmployeeName NVARCHAR(100),
	@Sex BIT, --0 nu && 1 nam
	@Birthday DATETIME,
	@Address1 NVARCHAR(150),
	@Address2 NVARCHAR(150),
	@Phone NVARCHAR(11),
	@Passport NVARCHAR(10),
	@Img NVARCHAR(150),
	@Note NVARCHAR(150),
	@PositionID INT
AS
BEGIN
	INSERT INTO Employees 
	VALUES(@EmployeesID,@EmployeeName,@Sex,@Birthday,@Address1,@Address2,@Phone,@Passport,@Img,@Note,@PositionID)
END

--===============Xoa nhan vien
CREATE PROC SP_DeleteEmployee
	@EmployeesID INT
AS
BEGIN 
	DELETE FROM Employees WHERE EmployeesID = @EmployeesID
END



--PROC ShowEmployees
CREATE PROC SP_ShowEmployees
AS
BEGIN
	SELECT * FROM TableFood
END
EXEC SP_ShowEmployees
/*
				FoodCategory
*/
-------------------------------------------------------
CREATE TABLE FoodCategory
(
	id INT IDENTITY ,
	name NVARCHAR(100) NOT NULL DEFAULT N'Chưa đặt tên',
	CONSTRAINT pk_IDFoodCategory PRIMARY KEY(ID)
)
GO
SELECT * FROM FoodCategory
---------------------------------------------------------
CREATE PROC SP_FoodCategory
(
	@name NVARCHAR(100)
)
AS
BEGIN
	INSERT INTO FoodCategory
	VALUES (@name)
END
----------------------------------------
CREATE PROC SP_ShowFoodCategory
AS
BEGIN
	SELECT * FROM FoodCategory
END
EXEC SP_ShowFoodCategory
--========================================
EXEC SP_FoodCategory N'Trà'
GO
EXEC SP_FoodCategory N'Trà sữa'
GO
EXEC SP_FoodCategory N'Italia Cafe'
GO
EXEC SP_FoodCategory N'Việt Nam Cafe'
GO
EXEC SP_FoodCategory N'Hot drink'
GO
EXEC SP_FoodCategory N'Nước ép'
GO
EXEC SP_FoodCategory N'Smoothie'
GO
EXEC SP_FoodCategory N'Soda Italya'
GO
EXEC SP_FoodCategory N'Ice Blended'
GO
EXEC SP_FoodCategory N'Virgin Mojito'

EXEC SP_FoodCategory N'Virgin Mojito 1'
--=================================================
---------------------------------------------------------

CREATE TABLE Food
(
	ID INT IDENTITY,
	name NVARCHAR(100) NOT NULL DEFAULT N'Chưa đặt tên',
	IDFoodCategory INT NOT NULL,
	price FLOAT NOT NULL DEFAULT 0,
	Img NVARCHAR(150),
	CONSTRAINT pk_IDFood PRIMARY KEY(ID),
	CONSTRAINT fk_IDFoodFood FOREIGN KEY (IDFoodCategory) REFERENCES FoodCategory(id)
)
 
--============================================
CREATE PROC SP_Food
(
	@Name NVARCHAR(100),
	@IDFoodCategory INT,
	@price FLOAT,
	@Img NVARCHAR(150)
)
AS
BEGIN
	INSERT INTO Food
	VALUES (@Name,@IDFoodCategory,@price,@Img)
END
--================================================= 
GO
CREATE PROC SP_ShowFood
AS
BEGIN
	SELECT * FROM Food
END
EXEC SP_ShowFood
--=================================================
EXEC SP_Food N'Trà đào',7,22000
go
EXEC SP_Food N'Trà mơ',7,22000
go
EXEC SP_Food N'Trà sữa truyền thống',8,12000
EXEC SP_Food N'Trà sữa thái xanh',8,18000
EXEC SP_Food N'Trà sữa socola',8,18000
EXEC SP_Food N'Trà sữa đào',8,18000
EXEC SP_Food N'Trà sữa kiwi',8,18000
------------------
EXEC SP_Food N'Espresso',9,15000
EXEC SP_Food N'Hazelnut espresso',9,19000
------------------
EXEC SP_Food N'Cafe đen',10,10000
EXEC SP_Food N'Cafe sữa',10,12000
--=========================================================
select * from Bill
DELETE FROM Food
----------------------------------------------------------------------
CREATE TABLE Bill
(
	ID INT IDENTITY,
	DateCheckIn DATE NOT NULL DEFAULT GETDATE(),
	DateCheckOut DATE,
	idTable INT NOT NULL,
	status INT NOT NULL DEFAULT 0 -- 1: đã thanh toán && 0: chưa thanh toán
	CONSTRAINT pk_IDBill PRIMARY KEY(ID),
	CONSTRAINT fk_idTable FOREIGN KEY (idTable) REFERENCES TableFood(id)
)
GO
--==============================================
CREATE PROC SP_InsertBill
(
	@idTable INT
)
AS
BEGIN
	INSERT INTO Bill
	VALUES (GETDATE(),Null,@idTable,0)
END
GO
EXEC SP_InsertBill 104
EXEC SP_ShowTableFood
EXEC SP_ShowBill
--=========================
CREATE PROC SP_ShowBill
AS
BEGIN
	SELECT * FROM Bill
END
EXEC SP_ShowBill
-------------------------------------------------------------------
CREATE TABLE BillInfo
(
	id INT IDENTITY,
	idBill INT NOT NULL,
	idFood INT NOT NULL,
	count INT NOT NULL DEFAULT 0,
	CONSTRAINT pk_IDBillInfo PRIMARY KEY(id),
	CONSTRAINT fk_IDBillBillInfo FOREIGN KEY (idBill) REFERENCES Bill(id),
	CONSTRAINT fk_IDFoodBillInfo FOREIGN KEY (idFood) REFERENCES Food(id)
)
GO
--INSERT BILL INFO
/*
			INSERT BILL INFO		
*/
ALTER PROC SP_InsertBillInfo
(
	@idBill INT,
	@idFood INT,
	@count INT
)
AS
BEGIN
	DECLARE @isExitsBillInfo INT
	DECLARE @foodCount INT

	SELECT @isExitsBillInfo = id, @foodCount = count From BillInfo WHERE idBill = @idBill and idFood = @idFood

	IF (@isExitsBillInfo > 0)
	BEGIN
		DECLARE @newCount INT = @foodCount + @count
		--kiem tra 
		IF(@newCount>0)
			BEGIN
				UPDATE BillInfo SET count = @foodCount + @count WHERE idFood = @idFood
			END
		ELSE
		--so am thi xoa luon
			BEGIN
				DELETE BillInfo WHERE idBill = @idBill AND idFood = @idFood
			END
	END
	ELSE
	BEGIN
		INSERT INTO BillInfo
		VALUES (@idBill,@idFood,@count)
	END
END

---===============================================

CREATE PROC SP_UPTableFood
	@IDTable INT
AS
BEGIN
	UPDATE TableFood SET TableStatus=N'CÓ NGƯỜI' WHERE ID=@IDTable
END
EXEC SP_UPTableFood '99'

/// -------- UPDATE Về TRỐNG
CREATE PROC SP_UPTableFood
	@IDTable INT
AS
BEGIN
	UPDATE TableFood SET TableStatus=N'TRỐNG' WHERE ID=@IDTable
END



EXEC SP_InsertBillInfo 12,12,12

-----------------------------------------------------------------------
--lay gia tri lon nhat
CREATE PROC SP_BillMax
AS
BEGIN
	SELECT MAX(ID) FROM Bill
END
EXEC SP_BillMax
--insert bill max

GO
/*
CREATE PROC SP_InsertBillInfoMax
(
	@idFood INT,
	@count INT
)
AS
BEGIN
	DECLARE @idBill INT
	SET @idBill = (SELECT MAX(ID) FROM Bill)
	INSERT INTO BillInfo (idBill,idFood,count)
	VALUES (@idBill,@idFood,@count)
END*/
DROP PROC SP_InsertBillInfoMax
EXEC SP_InsertBillInfoMax 12,2
EXEC SP_ShowBillInfo
EXEC SP_ShowFood

--show Bill Info
CREATE PROC SP_ShowBillInfo
AS
BEGIN
	SELECT * FROM BillInfo
END

EXEC SP_ShowBillInfo
-----------------------------------

----------------------------------------------------------------
CREATE PROC USP_GetAccountByUserName
@UserName NVARCHAR(100)
AS
BEGIN
	SELECT * FROM dbo.Account WHERE UserName = @UserName;
END
GO
EXEC dbo.USP_GetAccountByUserName @UserName = 'huynh'
----------------------------------------------------------
SELECT * FROM Account WHERE UserName = 'huynh' and PassWord='huynh'
----------------------------------------------------------
CREATE PROC USP_Login
@userName NVARCHAR(100),
@passWord NVARCHAR(100)
AS
BEGIN
	SELECT * FROM Account WHERE UserName = @userName and PassWord = @passWord	
END
GO
----------------------------------------------------------
-------------------PROC USP_GetTableList---------------------------------------
/*
	SP_ThongTinHoaDon
*/

SELECT * FROM Bill
SELECT * FROM BillInfo
SELECT * FROM Food

SELECT * FROM TableFood
SELECT * FROM FoodCategory

GO
CREATE PROC SP_ThongTinHoaDon
@idTable int
AS
BEGIN 
	SELECT f.name AS N'Tên', bf.count as N'Số Lượng', f.price as N'Gía', f.price*bf.count AS N'Thành tiền' FROM BillInfo AS bf, Bill AS b, Food AS f
	WHERE bf.idBill = b.ID AND bf.idFood = f.ID AND b.idTable = @idTable
END
DROP  PROC SP_ThongTinHoaDon
EXEC SP_ThongTinHoaDon 12



/*
	XML
*/
---------------------XML-------------------------------------
create table XML 
(databse_URL varchar(50) not null,
database_Name varchar(50) not null,
database_UserName varchar(50) not null,
database_Password varchar(50) not null);

insert into XML values 
('jdbc:sqlserver://localhost;','databasename=RMI;','user=sa;','password=123456');





CREATE PROC SP_SXTableFood
AS
BEGIN
	SELECT *
	FROM TableFood
	ORDER BY ID ASC
END

--them bill
CREATE PROC SP_InsertBillproc
	@idTable INT
AS
BEGIN
	EXEC SP_InsertBill @idTable,0
END
EXEC SP_InsertBillproc 31
EXEC SP_ShowBill


