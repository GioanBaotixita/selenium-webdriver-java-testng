package webdriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Topic_06_Web_Browser {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");

	@BeforeClass
	public void beforeClass() {
		//Chạy với Chrome
		////đường dẫn tuyệt đối
		//System.setProperty("webdriver.gecko.driver", "F:\\Automation Testing\\Autonation_Software Support\\2 - Selenium Web Driver\\browserDriver\\chromedriver.exe");
		//System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDriver\\chromedriver.exe");
		//driver = new ChromeDriver();
		
		
		//Chạy với firefox
	    ////đường dẫn tuyệt đối
		//System.setProperty("webdriver.gecko.driver", "F:\\Automation Testing\\Autonation_Software Support\\2 - Selenium Web Driver\\browserDriver\\geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		driver.get("");
	}

	@Test
	public void TC_01() {
		//dùng close browser / tab
		// nếu chỉ có 1 tab: close browser
		// nếu có nhìu tab: close tab đang active
		driver.close();
		
		// dùng đóng browser luôn mà ko cần quan tâm có bao nhiu tab
		driver.quit();
		
		// mở 1 url
		driver.get("https://www.youtube.com/");
		
		// dùng tím 1 element
		driver.findElement(By.ByXPath(""));
		// dùng tím nhiều element
		driver.findElements(By.ByXPath(""));
		
		//lấy ra url của page HIỆN TẠI
		driver.getCurrentUrl();
		
		//lấy ra source code cua page HIỆN TẠI ->dùng kt tương đối nhưng thông tin khó bắt tren UI
		driver.getPageSource();
		
		//lấy ra title của page HIỆN TẠI (title la cái hiển thị tren thanh tab , thuong 1 page luon có 1 title đoc lap)
		driver.getTitle();
		
		//dùng để xử lý window và tab -> lấy ra id của window/tab đang active
		driver.getWindowHandle();
		
		////dùng để xử lý window và tab -> lấy ra id của tất cả tab mà window đang có
		driver.getWindowHandles();
		
		// hàm này trả về 1 kiểu dữ liệu là interface, ten là option, chứa các hàm của option
		driver.manage();
		
		//cookie: lưu lại phiên đăng nhập/session/dữ liệu duyệt web/...sẽ có bài demo phần cookie sau trong bài Framework
		driver.manage().addCookie();
		driver.manage().deleteAllCookies();
		driver.manage().deleteCookie();
		driver.manage().deleteCookieNamed(projectPath);
		
		// sẽ có bài demo sau trong bài Framework
		driver.manage().logs().get(projectPath);
		driver.manage().logs().getAvailableLogTypes();
		
		//chờ cho cai findElement 15 giay
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		
		// chờ page load thành công trong 15 giây, thường ko dùng tới vì trong hàm get đã có page load time  out
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		
		// chờ cho 1 đoạn code java script được thực thi thành công, sẽ học kỹ trong bai java script, hàm này cũng khá it dùng
		// asynchronous script - bất đồng bộ
		// synchronous script - đồng bộ -> vì java code luôn chạy theo cơ chế này nen hàm này sẽ ít khi sử dụng
		
		driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
		
		// mở full hết toàn màn hình
		driver.manage().window().fullscreen();
		// mở max cửa sổ -> thường xuyên dùng
		driver.manage().window().maximize();
		//set vị trí của browser so với độ phân giải màn hình của máy đang chạy, cột mốc xác đinh là điểm trên cùng bên trái của browser -> hàm này it dùng
		driver.manage().window().setPosition(new Point(100,250));
		driver.manage().window().getPosition();
		
		//mở browser với kích thước theo định nghỉ -> dùng test Responsive , giả lập độ phân giải để test tính tích hợp
		driver.manage().window().setSize(new Dimension(1920,1080));
		driver.manage().window().getSize();
		
		// trả vè gia trị interface về navigation, tracking history -> it khi sử dụng
		driver.navigate();
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		
		// hàm này tương tự hàm driver.get("https://www.youtube.com/");
		driver.navigate().to("https://www.youtube.com/");
		
		// trả vè gia trị interface về switch to, sẽ có bài học riêng trong phần Alert
		driver.switchTo();
		driver.switchTo().alert();
		driver.switchTo().frame(0);
		driver.switchTo().window("");
		
		
	}

	@Test
	public void TC_02() {
		
	}

	@Test
	public void TC_03() {
		
	}

	@AfterClass
	public void afterClass() {
		//driver.quit();
	}
}