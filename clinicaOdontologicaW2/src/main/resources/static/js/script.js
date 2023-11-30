document.getElementById("btnRegistrarOdontologo").addEventListener("click", () => {
    cargarFormulario("odontologo.html");
});

document.getElementById("btnRegistrarPaciente").addEventListener("click", () => {
    cargarFormulario("paciente.html");
});

function cargarFormulario(formulario) {
    window.location.href = formulario;
}

function registrarOdontologo() {
    // Obtener los valores del formulario
    const matricula = document.getElementById("matricula").value;
    const nombre = document.getElementById("nombre").value;
    const apellido = document.getElementById("apellido").value;

    // Realizar la solicitud POST al backend para registrar el odontólogo
    fetch("http://localhost:8081/odontologos/registrar", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            matricula: matricula,
            nombre: nombre,
            apellido: apellido,
        }),
    })
        .then(response => response.json())
        .then(data => {
            console.log("Respuesta del servidor:", data);
        })
        .catch(error => console.error("Error en la solicitud:", error));
}

function registrarPaciente() {
    // Obtener los valores del formulario
    const nombre = document.getElementById("nombre").value;
    const apellido = document.getElementById("apellido").value;
    const dni = document.getElementById("dni").value;
    const fechaIngreso = document.getElementById("fechaIngreso").value;

    // Obtener los valores del domicilio
    const calle = document.getElementById("calle").value;
    const numero = document.getElementById("numero").value;
    const localidad = document.getElementById("localidad").value;
    const provincia = document.getElementById("provincia").value;

    // Realizar la solicitud POST al backend para registrar el paciente
    fetch("http://localhost:8081/pacientes/registrar", {
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            nombre: nombre,
            apellido: apellido,
            dni: dni,
            fechaIngreso: fechaIngreso,
            domicilioEntradaDto: {
                calle: calle,
                numero: numero,
                localidad: localidad,
                provincia: provincia,
            },
        }),
    })
        .then(response => response.json())
        .then(data => {
            console.log("Respuesta del servidor:", data);
        })
        .catch(error => console.error("Error en la solicitud:", error));
}

function volverAlIndice() {
    window.location.href = "index.html";
}
