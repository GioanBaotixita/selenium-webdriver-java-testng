package TestNG;
import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Topic_01_Assert {
	
	WebDriver driver;
	
	@Test
	
	public void TC_01{
		// hàm assert thường dùng để verify đúng/sai của test case
		//3 ham assert hay sai
	
		//kiểm tra dữ liệu mình mong muốn là sai.vd expected email textbox ko hiển thì
		//do mong muôn trả về là sai nên dùng hàm có kiểu dữ liệu trả về là boolean
		// neu email textbox ko có hiển thì -> map với giá trị hàm ->TC pass, nguoc lại failed
		Assert.assertFalse(driver.findElement(By.id("email")).isDisplayed());
		
		
		//kiểm tra dữ liệu mình mong muốn là đúng.vd expected email textbox hiển thì
		//do mong muôn trả về là đúng nên dùng hàm có kiểu dữ liệu trả về là boolean
		// neu email textbox có hiển thì -> map với giá trị hàm ->TC pass, nguoc lại failed
		Assert.assertTrue(driver.findElement(By.id("email")).isDisplayed());
		
		
		
		//kiểm tra dữ liệu mình mong muốn với dữ liệu thực tế là bằng nhau
		assert.assertEquals(driver.findElement(By.id("search")).getAttribute("placeholder"), "search entri store here...");
		
		//diễn giải
		// hàm assert.assertEquals có 2 đối số assert.assertEquals(boolean actual, boolean expected)
		// đối số thư nhất gần cái giá trị acutal : driver.findElement(By.id("search")).getAttribute("placeholder")
		// ->  có nghĩa là tìm den cái element có id = search và get cai giá trị của attribute "placeholder"
		// đối số thứ 2 là giá trị expected mà mình mong muốn nó sẽ trả về 
		// nếu giá trị đối số 1 trả về đúng giá trị đối số 2 -> TC pass
		// nếu giá trị đối số 1 trả về sai giá trị đối số 2 -> TC failed
		
		
		
	}

}
