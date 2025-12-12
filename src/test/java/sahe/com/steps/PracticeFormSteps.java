package sahe.com.steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import sahe.com.pages.PracticeFormPage;
import static org.junit.jupiter.api.Assertions.*;

public class PracticeFormSteps {

    private PracticeFormPage practiceFormPage;

    @Before
    public void setUp() {
        practiceFormPage = new PracticeFormPage();
    }

    @Given("que el usuario navega al formulario de práctica")
    public void queElUsuarioNavegaAlFormularioDePractica() {
        practiceFormPage.openForm();
    }

    @When("ingresa el nombre {string}")
    public void ingresaElNombre(String nombre) {
        practiceFormPage.enterFirstName(nombre);
    }

    @And("ingresa el apellido {string}")
    public void ingresaElApellido(String apellido) {
        practiceFormPage.enterLastName(apellido);
    }

    @And("ingresa el email {string}")
    public void ingresaElEmail(String email) {
        practiceFormPage.enterEmail(email);
    }

    @And("selecciona el género {string}")
    public void seleccionaElGenero(String genero) {
        practiceFormPage.selectGender(genero);
    }

    @And("ingresa el número móvil {string}")
    public void ingresaElNumeroMovil(String numero) {
        practiceFormPage.enterMobileNumber(numero);
    }

    @And("selecciona el hobby {string}")
    public void seleccionaElHobby(String hobby) {
        practiceFormPage.selectHobby(hobby);
    }

    @And("ingresa la dirección {string}")
    public void ingresaLaDireccion(String direccion) {
        practiceFormPage.enterAddress(direccion);
    }

    @And("hace clic en el botón Submit")
    public void haceClicEnElBotonSubmit() {
        practiceFormPage.clickSubmit();
    }

    @Then("debe aparecer el modal de confirmación")
    public void debeAparecerElModalDeConfirmacion() {
        assertTrue(practiceFormPage.isModalDisplayed(),"El modal de confirmación no se mostró");
    }

    @And("el título del modal debe ser {string}")
    public void elTituloDelModalDebeSer(String tituloEsperado) {
        String tituloActual = practiceFormPage.getModalTitle();
        assertEquals(tituloEsperado, tituloActual,"El título del modal no coincide con el esperado");
    }

    @And("el modal debe mostrar el nombre completo {string}")
    public void elModalDebeMostrarElNombreCompleto(String nombreCompleto) {
        String contenidoModal = practiceFormPage.getModalBodyText();
        assertTrue(contenidoModal.contains(nombreCompleto),"El modal no contiene el nombre completo esperado: " + nombreCompleto);
    }

    @Then("los campos obligatorios deben mostrar validación de error")
    public void losCamposObligatoriosDebenMostrarValidacionDeError() {
        assertFalse(practiceFormPage.isModalDisplayed(),"El modal no debería aparecer con formulario incompleto");
    }

    @And("el campo {string} debe tener borde rojo")
    public void elCampoDebeTenerBordeRojo(String fieldId) {
        assertTrue(practiceFormPage.hasErrorBorder(fieldId),"El campo " + fieldId + " no muestra borde de error");
    }

    @And("el campo de género debe indicar error")
    public void elCampoDeGeneroDebeIndicarError() {
        assertFalse(practiceFormPage.isModalDisplayed(),"El campo de género debería indicar que es obligatorio");
    }
}
