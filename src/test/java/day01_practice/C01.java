package day01_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01 {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        /** SORU 1 :

         *  "https://testpages.herokuapp.com/styled/calculator" adresine gidin
         *         ilk kutucuga 20 giriniz
         *         ikinci kutucuga 30 giriniz
         *         calculate'e tıklayınız
         *         sonucu yazdırınız
         *         Sayfayi kapatiniz

         */
        driver.get("https://testpages.herokuapp.com/styled/calculator");

        //ilk kutucuga 20 giriniz
        WebElement aramaKutusu1 = driver.findElement(By.xpath("//input[@id='number1']"));
        aramaKutusu1.sendKeys("20");

        //ikinci kutucuga 30 giriniz
        WebElement aramaKutusu2 = driver.findElement(By.xpath("//input[@id='number2']"));
        aramaKutusu2.sendKeys("30");

        //calculate'e tıklayınız
        WebElement calculate = driver.findElement(By.xpath("//input[@type='submit']"));
        calculate.click();

        // sonucu yazdırınız
        WebElement answer = driver.findElement(By.xpath("//span[text()='50']"));
        System.out.println(answer.getText());

        //Sayfayi kapatiniz
        driver.quit();
    }

}
