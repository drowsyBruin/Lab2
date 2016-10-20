package Mysql;

import java.sql.*; 
import com.opensymphony.xwork2.ActionSupport;

public class BookDB_Mysql extends ActionSupport{
	static Connection connect;
	String Output;
	
	String ISBN;
	String Title;
	String AuthorID;
	String Publisher;
	String PublishDate;
	String Price;
	
	String Name;
	int Age;
	String Country;
	
	public String getOutput(){
		return Output;
	}
	
 	public void setISBN(String ISBN){
		this.ISBN = ISBN;
	}
	
	public void setTitle(String Title){
		this.Title = Title;
	}
	
	public void setAuthorID(String AuthorID){
		this.AuthorID = AuthorID;
	}
	
	public void setPublisher(String Publisher){
		this.Publisher = Publisher;
	}

	public void setPublishDate(String PublishDate){
		this.PublishDate = PublishDate;
	}

	public void setPrice(String Price){
		this.Price = Price;
	}
	
	public void setName(String Name){
		this.Name = Name;
	}

	public void setAge(int Age){
		this.Age = Age;
	}

	public void setCountry(String Country){
		this.Country = Country;
	}


	
	public void Jdbc(){
		try { 
			  Class.forName("com.mysql.jdbc.Driver");  //加载MYSQL JDBC驱动程序 
			  //Class.forName("org.gjt.mm.mysql.Driver"); 
			  System.out.println("Success loading Mysql Driver!"); 
			 } 
			 catch (Exception e) { 
			  System.out.print("Error loading Mysql Driver!"); 
			  e.printStackTrace(); 
			 } 
			 try { 
			  connect = DriverManager.getConnection( 
			   "jdbc:mysql://aszxvpfmsouv.rds.sae.sina.com.cn:10422/BookDB","root","1234567890"); 
			   //连接URL为 jdbc:mysql//服务器地址/数据库名 ，后面的2个参数分别是登陆用户名和密码 
			  
			  System.out.println("Success connect Mysql server!"); 
			 } 
		catch (Exception e) { 
			System.out.print("get data error!"); 
			e.printStackTrace(); 
		} 
	}
	
	public static boolean if_Author(String AuthorID) throws SQLException{
		String sql = "select * from Author where AuthorID='" + AuthorID + "'";
		Statement stmt = connect.createStatement();
		
		ResultSet rs = stmt.executeQuery(sql);
		
		if(rs.next())
			return true;
		else
			return false;
	}
	
	public String InsertBook() throws SQLException{
		Jdbc();
		try{
			String sql="INSERT INTO Book(ISBN,Title,AuthorID,Publisher,PublishDate,Price) VALUES (";
			sql = sql + "'" + ISBN + "'," + "'" + Title + "'," +"'" + AuthorID + "'," +"'" + Publisher + "'," + "'" + PublishDate + "'," + "'" + Price + "')";
		   
		    //创建执行对象
		     
		    Statement stmt = connect.createStatement();
		  
		    stmt.executeUpdate(sql);
		    
		    //添加新作者
		    if(!if_Author(AuthorID)){
		    	connect.close();
				return "AddAuthor";
		    }

		    
		}
		//  catch (ClassNotFoundException e) { 
		// TODO Auto-generated catch block 
		// System.out.println("An error has occurred:"+e.toString()); 
		// e.printStackTrace(); 		
		catch(SQLException e) {
			System.out.println("SQLerror!");
		}
		connect.close();
		
	    
		return SUCCESS;
	}	
	
	public String InsertAuthor() throws SQLException{
		Jdbc();
		try{
			String sql="INSERT INTO Author(AuthorID,Name,Age,Country) VALUES (";
			sql = sql + "'" + AuthorID + "'," + "'" + Name + "',"  + Age + "," +"'" + Country + "')";
		   
		    //创建执行对象
		     
		    Statement stmt = connect.createStatement();
		  
		    stmt.executeUpdate(sql);
		    
		}
		//  catch (ClassNotFoundException e) { 
		// TODO Auto-generated catch block 
		// System.out.println("An error has occurred:"+e.toString()); 
		// e.printStackTrace(); 		
		catch(SQLException e) {
			System.out.println("SQLerror!");
		} 
		connect.close();
		return SUCCESS;
	}
	
	//展示所有图书
	public String ViewBooks() throws SQLException{
		Jdbc();
		try{
		    String sql="select * from Book";
		    //创建执行对象
		     
		    Statement stmt = connect.createStatement();
		     
		    Output = "<table width='50%' border='1' cellspacing='2' cellpadding='0'><tr>"
		    		+ "<td>ISBN</td><td>Title</td><td>Delete</td></tr>";
		    ResultSet rs = stmt.executeQuery(sql);
		    
		    while(rs.next()){
		    	Output += "<td>" + rs.getString(1) + "</td>" + "<td><a href=\"ViewBook.action?ISBN=\'" +
		    			rs.getString(1) + "\'\" class='href1'>" + rs.getString(2) +
		    			"</a></td><td><a href=\"DeleteBook.action?ISBN=\'" + rs.getString(1) + "\'\" class='href2'>删除</a></td></tr>";
		    }    
		}
		catch(SQLException e) {
			System.out.println("SQLerror!");
		}
		connect.close();
		return SUCCESS;
	}
	
	//展示图书和对应作者信息
	public String ViewBook() throws SQLException{
		Jdbc();
		try{
		    String sql="select * from Book where ISBN=" + ISBN + "";
		    //创建执行对象
		     
		    Statement stmt = connect.createStatement();
		     
		    ResultSet rs = stmt.executeQuery(sql);
		    Output = "<table width='80%' border='1' cellspacing='2' cellpadding='0'><tr>"
		    		+ "<td>ISBN</td><td>Title</td><td>Publisher</td><td>PublishDate</td><td>Price</td><td>AuthorID</td><td>Name</td><td>Age</td><td>Country</td></tr>";
		    
		    if(rs.next()){
		    	Output += "<td>" + rs.getString(1) + "</td>" + "<td>" + rs.getString(2) + "</td>" +
		    			 "<td>" + rs.getString(4) + "</td>" + "<td>" + rs.getString(5) +
		    			 "</td>" + "<td>" + rs.getString(6) + "</td>";
		    }
		    String sql1="select * from Author where AuthorID='" + rs.getString(3) + "'";
		    
		    ResultSet rs1 = stmt.executeQuery(sql1);
		    
		    if(rs1.next()){//指针控制判断是否有下一行记录,如果有两个next则是第二条记录，有几个就是第几条
		    	Output += "<td>" + rs1.getString(1) + "</td>" + "<td>" + rs1.getString(2) + "</td>" +
		    			"<td>" + rs1.getString(3) + "</td>" + "<td>" + rs1.getString(4) + "</td>";
		    }
		    
		}
		catch(SQLException e) {
			System.out.println("SQLerror!");
		}
		connect.close();
		return SUCCESS;
	}
	
	//展示作者所有书目
	public String ViewAuthor() throws SQLException{
		Jdbc();
		try{
		    String sql="select * from Author where Name='" + Name + "'";
		    //创建执行对象
		     
		    Statement stmt = connect.createStatement();
		    Statement stmt1 = connect.createStatement();
		    Output = "<table width=40%' border='1' cellspacing='2' cellpadding='0' align='left'><tr>";
		    ResultSet rs = stmt.executeQuery(sql);
		    while(rs.next()){//指针控制判断是否有下一行记录,如果有两个next则是第二条记录，有几个就是第几条
		    	
		    	String sql1 = "select * from Book where AuthorID='" + rs.getString(1) + "'";
		    	ResultSet rs1 = stmt1.executeQuery(sql1);
			    while(rs1.next()){
				    Output += "<td>" + rs1.getString(2) + "</td></tr>";
			    }

		    }	
		    Output += "</table>";
		}
		catch(SQLException e) {
			System.out.println("SQLerror!");
		}
		connect.close();
		return SUCCESS;
	}
	
	
	public String DeleteBook() throws SQLException{
		Jdbc();
		try{		
			String sql0="select * from Book where ISBN=" + ISBN + "";
		    String sql="delete from Book where ISBN =" + ISBN + "";
		    //创建执行对象
		    Statement stmt = connect.createStatement();
		    
		    //删除前获取AuthorID
		    ResultSet rs = stmt.executeQuery(sql0);
		    if(rs.next())
		    	AuthorID = rs.getString(3);
		    //删除
		    stmt.executeUpdate(sql);
		    //检查Book中还有没有该Author书目
		    String sql1="select * from Book where AuthorID='" + AuthorID + "'";
		    ResultSet rs1 = stmt.executeQuery(sql1);
		    //若没有，从Author删除该Author
		    if(!rs1.next()){
		    	String sql2="delete from Author where AuthorID ='" + AuthorID + "'";
		    	stmt.executeUpdate(sql2);
		    }
		}
		catch(SQLException e) {
			System.out.println("SQLerror!");
		} 
		connect.close();
		return SUCCESS;
	}
	
	public String UpdateBook() throws SQLException{
		Jdbc();
		try{	
			String sql="UPDATE Book SET AuthorID='" + AuthorID + "',Publisher='" + Publisher + 
					"',PublishDate='" + PublishDate + "',Price='" + Price + "' where ISBN='" + ISBN + "'";		    
		    //创建执行对象 
		    Statement stmt = connect.createStatement();
		     
		    stmt.executeUpdate(sql);
		    
		    //添加新作者
		    if(!if_Author(AuthorID)){
		    	connect.close();
				return "AddAuthor";
		    }

		}
		catch(SQLException e) {
			System.out.println("SQLerror!");
		} 
		connect.close();
		return SUCCESS;
	}
	
//	public static void main(String args[]) throws SQLException{
//		BookDB_Mysql test = new BookDB_Mysql();
//		//test.getBook("0000-0213", "还是测试用例", "1143710401", "drowsyBruin", "2016-10-11", "100$");
//		test.InsertBook();
//		if(!if_Author(test.AuthorID)){
//			//test.getAuthor(test.AuthorID, "刘穗雄", 21, "天朝");
//			test.InsertAuthor();
//		}
//		//test.getUpdaate("0000-0213", "11437104001", "drowsy_Bruin", "2016-10-12", "99$");
//		test.Updata();
//		//test.Select();
//		//test.Delete("0000-0213");
//	}
	
}
