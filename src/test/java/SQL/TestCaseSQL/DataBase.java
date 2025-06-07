package SQL.TestCaseSQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import net.bytebuddy.build.Plugin.Factory.UsingReflection.Priority;

public class DataBase {
	
	Connection con;  
	
	Statement stmt;
	
	ResultSet rs;
	WebDriver driver = new ChromeDriver();
	
	String URL = "https://smartbuy-me.com/account/register";
	
	String customerName;
	@BeforeTest 
	public void setup() throws SQLException {
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classicmodels","root","12345");
		
		driver.get(URL);
		
	}
	
	@Test (priority= 1,enabled = false)
	public void InsertTheDataBase() throws SQLException {
		
		String Query = "INSERT INTO orders (orderNumber, orderDate, requiredDate, status, customerNumber) VALUES (12345, '2025-05-01', '2025-05-10', 'In Process', 103)";
		stmt = con.createStatement();
		
		int rowEfected = stmt.executeUpdate(Query);
		System.out.println(rowEfected);
		
		
	}
	
	
@Test (priority= 2)
public void UpdetDataBase()  throws SQLException {
	
	
String Query = "UPDATE customers SET creditLimit = 75000 WHERE customerNumber = 999";
stmt = con.createStatement();

int rowEfected = stmt.executeUpdate(Query);
System.out.println(rowEfected);

}



@Test (priority= 3)
public void ReadtDataBase()  throws SQLException {


String Query = "SELECT * FROM customers WHERE customerNumber = 103;";
stmt = con.createStatement();
rs = stmt.executeQuery(Query);

while (rs.next()) {
	String customerName = rs.getNString("contactFirstName");
	
	System.out.println(customerName);

  driver.findElement(By.id("customer[first_name]")).sendKeys(customerName);
}

}





}
