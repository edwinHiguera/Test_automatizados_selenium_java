package pruebas;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

 import static junit.framework.TestCase.assertEquals;

public class ValidacionRegistroPage extends Base {

    //constructor
    public ValidacionRegistroPage(WebDriver driver) {
        super(driver);
    }

    //LOCALIZADORES

    //registro
    By registrarGlobal = By.linkText("REGISTER");
    By imagenRegistrar = By.xpath("//img[@src='images/mast_register.gif']");
    By campoUsuario = By.id("email");
    By campoContrasena = By.name("password");
    By campoConfirmaContrasena = By.name("confirmPassword");
    By btnEnviar = By.name("submit");

    //login
    By mensajeRegistrado = By.tagName("font");
    By ingresar = By.cssSelector("font>a[href=\"login.php\"]");
    By imagenIngresar = By.xpath("//img[@src=\"images/mast_signon.gif\"]");
    By ingresaUsuario = By.name("userName");
    By ingresaContrasena = By.name("password");
    By btnIngresa = By.name("submit");
    By mensajeExitoso = By.xpath("//h3[text()=\"Login Successfully\"]");


    //METODOS

    @Step("Validación del formulario de registro de usuarios")
    public void registraUsuario(){

        click(registrarGlobal);
        esperar();

        if (isDisplayed(imagenRegistrar)){
            //escribe datos
            sendKeys("edwin123",campoUsuario);
            sendKeys("123456789875",campoContrasena);
            sendKeys("123456789875",campoConfirmaContrasena);

            click(btnEnviar);
            esperar();

        }else {
            System.out.println("La pagina no corresponde a la esperada!");
        }

    }

    //valida mensaje exitoso
    @Step("Validacion de mensaje de usuario registrado correctamente")
    public String usuarioRegistrado(){
        List<WebElement> listaFonts= findElements(mensajeRegistrado);

        if(listaFonts.size()>5) {
            return getText(listaFonts.get(5));
        }else{
            throw new RuntimeException("Mensaje de registro no encontrado en la posición esperada.");
        }
    }

    //valida el texto resultado registro
    @Step("Compara si el mensaje de registro exitoso es el correcto")
    public void resultadoRegistro(){
        assertEquals("Note: Your user name is edwin123.", usuarioRegistrado());
    }

    @Step("Validación del formulario de ingreso")
    public void ingreso(){
        click(ingresar);
        esperar();

        if (isDisplayed(imagenIngresar)){
            sendKeys("edwin123",ingresaUsuario);
            sendKeys("123456789875",ingresaContrasena);

            click(btnIngresa);
            esperar();

            String mensaje = getText(mensajeExitoso);

            assertEquals("Login Successfully", mensaje); // Verifica su contenido
            System.out.println("Prueba Exitosa");

        }else {
            System.out.println("La pagina no es correcta");
        }

    }

}
