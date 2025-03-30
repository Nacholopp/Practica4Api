async function enviarFormulario() {
    const email = document.getElementById("formEmail").value;
    const nombre = document.getElementById("formNombre").value;
    const pais = document.getElementById("formPais").value;
    const telefono = document.getElementById("formTlf").value;

    console.log("me he metido en la funcion");

    // Creamos el objeto del POST
    const data = {
        email: email,
        nombre: nombre,
        pais: pais,
        telefono: telefono,
    };

    try {
        const response = await fetch("http://localhost:8080/api/registro", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(data),
        });

        if (response.ok) {
            alert("Usuario registrado correctamente");
        } else {
            alert("Error en el registro");
        }

        // Usuario que se acaba de registrar
        const usuarioResponse = await fetch(`http://localhost:8080/api/registro/${email}`);
        if (usuarioResponse.ok) {
            const usuario = await usuarioResponse.json(); // Convertimos la respuesta en JSON

            console.log("Nombre del usuario:", usuario.nombre);  // Aquí accedemos al nombre
            document.getElementById("bienvenida").textContent = `Bienvenido ${usuario.nombre}`;
            document.getElementById("bienvenida").style.display = "inline-block";

            // Mostrar los botones de actualizar y borrar
            document.getElementById("btnActualizar").style.display = "block";
            document.getElementById("btnBorrar").style.display = "block";
        } else {
            console.error("No se encontró el usuario o hubo un error");
        }
    } catch (error) {
        console.error("Error:", error);
        alert("Hubo un problema al conectar con el servidor");
    }
}

async function actualizarUsuario() {
    const email = document.getElementById("emailActualizar").value;
    const nombre = document.getElementById("nombreActualizar").value;

    try {
        const response = await fetch(`http://localhost:8080/api/registro/${email}`, {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify({ nombre: nombre }),
        });

        if (response.ok) {
            alert("Usuario actualizado correctamente");
            document.getElementById("bienvenida").textContent = `Bienvenido ${nombre}`;
        } else {
            alert("Error al actualizar el usuario");
        }
    } catch (error) {
        console.error("Error:", error);
        alert("Hubo un problema al actualizar el usuario");
    }
}

async function borrarUsuario() {
    const email = document.getElementById("emailBorrar").value;

    try {
        const response = await fetch(`http://localhost:8080/api/contadores/${email}`, {
            method: "DELETE",
        });

        if (response.ok) {
            alert("Usuario eliminado correctamente");
            document.getElementById("bienvenida").style.display = "none";
        } else {
            alert("Error al eliminar el usuario");
        }
    } catch (error) {
        console.error("Error:", error);
        alert("Hubo un problema al eliminar el usuario");
    }
}
