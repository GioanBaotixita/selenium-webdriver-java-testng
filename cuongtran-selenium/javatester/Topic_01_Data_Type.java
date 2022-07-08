package javatester;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Topic_01_Data_Type {
	public static void main(String[] args) {
		// Khai báo biến : kiểu dữ liệu + tên biến
		int studentNumber;
		
		// khởi tạo dữ liệu
		studentNumber = 100;
		
		// vừa khai báo biến vừa khởi tạo
		int teacherNumber = 20;
		
		//I - Kiễu dữ liệu nguyên thủy - có 8 kiểu
			//1 - boolean : luận lý/logic - 2 giá trị (true/false)
		boolean studentSex = true;
		    //2 - số nguyên - ko có phần thập phân - byte
		byte bEmployee = 100;
		    //3 - số nguyên - ko có phần thập phân - short
		short sEmployee = 10;
		    //4 - số nguyên - ko có phần thập phân - int
		int iEmployee = 1000000;
		    //5 - số nguyên - ko có phần thập phân - long
		long lEmployee = 100000000;
		    //6 - số thực - có phần thập phân - float
		float fEmployee = 7.5f;
		    //7 - số thực - có phần thập phân - double	
		double dEmployee = 8.5d;
		    //8 - kiếu ký tự - char
		char a = 'B';
		
		//I - Kiễu dữ liệu tham chiếu
		//Array - Mảng
		int[] studentNumbers = {15,50,-7,19};
		String[] studentName = {"NVA", "NVB"};
		
		//Class/Interface
		WebDriver driver = new ChromeDriver();
		Actions action = new Actions(driver);
		
		//Collection : List(ArrayList/LinkedList)/Set/Queue
		ArrayList<String> studentCountry = new ArrayList<String>();
		
		//Object
		Object phone;
		
		//chuổi ký tự : chứa số/chữ/ký tự đặc biệt	
		String companyName = "Cong Ty Co Phan TiTan 2022 @titancorpvn.com";
		  
	}
	
}