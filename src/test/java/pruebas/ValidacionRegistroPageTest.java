package pruebas;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import io.qameta.allure.*;


 @Epic("Validacion y registro de usuario en la web de pruebas")
 @Owner("Edwin Higuera")
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
    @Story("Registro usuario, ingreso de usuario")
    @Description("Verifica que un usuario pueda registrarse correctamente y tambien pueda hacer un ingreso exitoso")
    @Severity(SeverityLevel.CRITICAL)
    public void test(){
        validacionPage.registraUsuario();
        validacionPage.usuarioRegistrado();
        validacionPage.resultadoRegistro();
        validacionPage.ingreso();
    }

    @After
    public void tearDown() throws Exception {
        //cierre
        driver.quit();
    }

}