package pom;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class ValidacionRegistroPageTest {

    //instancias
    private WebDriver driver;
    ValidacionRegistroPage validacionPage;

    @Before
    public void setUp() throws Exception {

       validacionPage = new ValidacionRegistroPage(driver);
        driver= validacionPage.conexionNavegador();
        validacionPage.visita("https://demo.guru99.com/test/newtours/");
    }

    @Test
    public void test(){
        validacionPage.ejecucionFlujo();
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

}