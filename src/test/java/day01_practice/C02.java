package day01_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
/**
        // https://www.amazon.com/ adresine gidin
        // arama motorunda nutella yazip aratınız
        // Customer Service ve Registry butonlarına sırasıyla tıklayın ve title'larının "Amazon" icerdigini test edin
        // pencereyi kapatiniz
*/
        driver.get("https://www.amazon.com");

        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("nutella" + Keys.ENTER);

        /** Bu sekilde ayri ayri alabiliriz. */
        /*
        WebElement customerService = driver.findElement(By.xpath("//span[text()=' Kundenservice']"));
        customerService.click();
         if (driver.getTitle().contains("Amazon")){
                System.out.println("Title Amazon kelimesini iceriyor");
            } else {
                System.out.println("Title Amazon kelimesini icermiyor");
            }
            driver.navigate().back();

        WebElement registry = driver.findElement(By.xpath("//span[text()=' Wunschlisten']"));
        registry.click();
         if (driver.getTitle().contains("Amazon")){
                System.out.println("Title Amazon kelimesini iceriyor");
            } else {
                System.out.println("Title Amazon kelimesini icermiyor");
            }
            */
        /** Veya tek bir XPATH islemiyle iki tane Locate aliriz. Ve index belirtiriz. */ // Bu islemi herkes bilmez. !!!!
        for (int i = 0; i < 2 ; i++) {
            List<WebElement> buttons = driver.findElements(By.xpath("(//a[@tabindex='0'])[6] | (//a[@tabindex='0'])[7]"));
            buttons.get(i).click();
            if (driver.getTitle().contains("Amazon")){
                System.out.println("Title Amazon kelimesini iceriyor");
            } else {
                System.out.println("Title Amazon kelimesini icermiyor");
            }
            driver.navigate().back();
        }

        driver.close();

    }

}
