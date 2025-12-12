Feature: Formulario de Practica DemoQA
  Como usuario de DemoQA
  Quiero completar el formulario de practica
  Para validar su funcionamiento correcto

  Scenario: Registro exitoso con campos obligatorios
    Given que el usuario navega al formulario de práctica
    When ingresa el nombre "Juan"
    And ingresa el apellido "Perez"
    And ingresa el email "juan.perez@test.com"
    And selecciona el género "Male"
    And ingresa el número móvil "9876543210"
    And hace clic en el botón Submit
    Then debe aparecer el modal de confirmación
    And el título del modal debe ser "Thanks for submitting the form"
    And el modal debe mostrar el nombre completo "Juan Perez"

  Scenario: Registro con campos adicionales
    Given que el usuario navega al formulario de práctica
    When ingresa el nombre "Maria"
    And ingresa el apellido "Garcia"
    And ingresa el email "maria.garcia@test.com"
    And selecciona el género "Female"
    And ingresa el número móvil "9123456789"
    And selecciona el hobby "Sports"
    And ingresa la dirección "Av.CondorCanqui 69, Lima"
    And hace clic en el botón Submit
    Then debe aparecer el modal de confirmación
    And el título del modal debe ser "Thanks for submitting the form"
    And el modal debe mostrar el nombre completo "Maria Garcia"

  Scenario: Validación de formulario incompleto
    Given que el usuario navega al formulario de práctica
    When ingresa el nombre "Pedro"
    And hace clic en el botón Submit
    Then los campos obligatorios deben mostrar validación de error
    And el campo "lastName" debe tener borde rojo
    And el campo "userNumber" debe tener borde rojo
    And el campo de género debe indicar error