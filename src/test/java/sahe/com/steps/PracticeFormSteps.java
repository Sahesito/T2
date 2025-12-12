package sahe.com.steps;

import io.cucumber.java.Before;
import io.cucumber.java.es.*;
import sahe.com.pages.PracticeFormPage;
import static org.junit.jupiter.api.Assertions.*;

public class PracticeFormSteps {

    private PracticeFormPage practiceFormPage;

    @Before
    public void setUp() {
        practiceFormPage = new PracticeFormPage();
    }

    @Dado("que el usuario navega al formulario de práctica")
    public void queElUsuarioNavegaAlFormularioDePractica() {
        practiceFormPage.openForm();
    }

    @Cuando("ingresa el nombre {string}")
    public void ingresaElNombre(String nombre) {
        practiceFormPage.enterFirstName(nombre);
    }

    @Y("ingresa el apellido {string}")
    public void ingresaElApellido(String apellido) {
        practiceFormPage.enterLastName(apellido);
    }

    @Y("ingresa el email {string}")
    public void ingresaElEmail(String email) {
        practiceFormPage.enterEmail(email);
    }

    @Y("selecciona el género {string}")
    public void seleccionaElGenero(String genero) {
        practiceFormPage.selectGender(genero);
    }

    @Y("ingresa el número móvil {string}")
    public void ingresaElNumeroMovil(String numero) {
        practiceFormPage.enterMobileNumber(numero);
    }

    @Y("selecciona el hobby {string}")
    public void seleccionaElHobby(String hobby) {
        practiceFormPage.selectHobby(hobby);
    }

    @Y("ingresa la dirección {string}")
    public void ingresaLaDireccion(String direccion) {
        practiceFormPage.enterAddress(direccion);
    }

    @Y("hace clic en el botón Submit")
    public void haceClicEnElBotonSubmit() {
        practiceFormPage.clickSubmit();
    }

    @Entonces("debe aparecer el modal de confirmación")
    public void debeAparecerElModalDeConfirmacion() {
        assertTrue(practiceFormPage.isModalDisplayed(),"El modal de confirmación no se mostró");
    }

    @Y("el título del modal debe ser {string}")
    public void elTituloDelModalDebeSer(String tituloEsperado) {
        String tituloActual = practiceFormPage.getModalTitle();
        assertEquals(tituloEsperado, tituloActual,"El título del modal no coincide con el esperado");
    }

    @Y("el modal debe mostrar el nombre completo {string}")
    public void elModalDebeMostrarElNombreCompleto(String nombreCompleto) {
        String contenidoModal = practiceFormPage.getModalBodyText();
        assertTrue(contenidoModal.contains(nombreCompleto),"El modal no contiene el nombre completo esperado: " + nombreCompleto);
    }

    @Entonces("los campos obligatorios deben mostrar validación de error")
    public void losCamposObligatoriosDebenMostrarValidacionDeError() {
        assertFalse(practiceFormPage.isModalDisplayed(),"El modal no debería aparecer con formulario incompleto");
    }

    @Y("el campo {string} debe tener borde rojo")
    public void elCampoDebeTenerBordeRojo(String fieldId) {
        assertTrue(practiceFormPage.hasErrorBorder(fieldId),"El campo " + fieldId + " no muestra borde de error");
    }

    @Y("el campo de género debe indicar error")
    public void elCampoDeGeneroDebeIndicarError() {
        assertFalse(practiceFormPage.isModalDisplayed(),"El campo de género debería indicar que es obligatorio");
    }
}
