package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.List;

public class Base {

    //instancia webDriver
    protected WebDriver driver;

    //constructor
    public Base(WebDriver driver){
        this.driver=driver;
    }

    //metodo conexion navegador
    public WebDriver conexionNavegador(){
        WebDriverManager.chromedriver().setup(); // Esto se encarga del driver automáticamente

        ChromeOptions options = new ChromeOptions();

        // Detectar si estamos en GitHub Actions
        boolean esCI = System.getenv("GITHUB_ACTIONS") != null;

        if (esCI) {
            options.setBinary("/opt/google/chrome/google-chrome"); // Chrome en Actions
            options.addArguments("--headless");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }

        driver = new ChromeDriver(options);
        return driver;
    }


    //****************Wrapping******************
    //metodo finElement
    public WebElement findElement (By locator) {
        return driver.findElement(locator);
    }

    //metodo lista de elementos
    public List<WebElement> findElements(By locator){
        return driver.findElements(locator);
    }

    //metodo para obtener texto
    public String getText(WebElement element){
        return element.getText();
    }

    //Sobrecarga metodo getText
    public String getText(By locator){
        return driver.findElement(locator).getText();
    }

    //metodo para escribir text
    public void sendKeys(String texto, By locator){
        driver.findElement(locator).sendKeys(texto);
    }

    //metodo para hacer click
    public void click(By locator){
        driver.findElement(locator).click();
    }

    //metodo para validar elemento en pantalla
    public Boolean isDisplayed(By locator){
        try{
            return driver.findElement(locator).isDisplayed();
        }catch (org.openqa.selenium.NoSuchElementException e){
            return false;
        }
    }

    //metodo para obtener url
    public void visita(String url){
        driver.get(url);
        driver.manage().window().maximize();
    }

    //metodo para esperar 2 segundos
    public void esperar(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

