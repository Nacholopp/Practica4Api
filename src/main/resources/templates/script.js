function enviarFormulario (){

    const email = document.getElementById("formEmail").value;
    const nombre = document.getElementById("formNombre").value;
    const pais = document.getElementById("formPais").value;
    const telefono = document.getElementById("formTlf").value;


    //Creamos el objeto del POST
    const data ={
        email : email,
        nombre : nombre,
        pais : pais,
        telefono : telefono,
    };

    fetch("http://localhost:8080/api/registro",{
        method : "POST",
        headers :{
            "Content-Type":"application/json",
        },
        body : JSON.stringify(data)

    })

        .then(response => {
            if (response.ok) {
                alert("Usuario registrado correctamente");
            } else {
                alert("Error en el registro");
            }
        })
        .catch(error => {
            console.error("Error:", error);
            alert("Hubo un problema al conectar con el servidor");
        });

}