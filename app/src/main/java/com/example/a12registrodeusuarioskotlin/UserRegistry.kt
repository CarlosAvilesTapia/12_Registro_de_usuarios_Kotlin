package com.example.a12registrodeusuarioskotlin

// Creación de data class para guardar datos
data class User(
    val name: String,
    val lastName: String,
    val age: Int,
    val email: String,
    val healthSystem: String
) {
    // Creación de funcion de la clase para desplegar datos de forma ordenada.
    override fun toString(): String {
        return "Nombre completo: $name $lastName\nEdad: $age años\nCorreo electrónico: $email" +
                "\nSistema de salud: $healthSystem\n--------------------------------------------"
    }
}

fun main() {

    // Declaración de variable para el número de usuarios a registrar
        var usersQuantity : Int

    // Validación para ingresar una cantidad válida de usuarios.
    do {
        println("Ingrese la cantidad de usuarios a registrar: ")
        val input = readLine()
        usersQuantity = input?.toIntOrNull()?: 0

    } while (usersQuantity <= 0)

    // Cración de un listado con los usuarios.
    val users = mutableListOf<User>()

    // Ciclo para llenar listado según la cantidad de usuarios ingresados.
    for (i in 1.. usersQuantity) {
        println("Usuario $i")

        // Llenado de datos a través de funciones.
        val name = askName()
        val lastName = askLastName()
        val age = askAge()
        val email = askEmail()
        val healthSystem = askHealthSystem()

        users.add(User(name, lastName, age, email, healthSystem))
    }

    // Ordenamiento del listado en forma ascendente según edad.
    val sortedUsers = users.sortedBy { it.age }

    println("")
    println("Usuarios registrados:")
    println("--------------------------------------------")

    // Ciclo para desplegar por consola los datos ingresados
    for (user in sortedUsers) {

        // Llamado al método toString para facilitar lectura en la consola.
        println(user.toString())
    }
}

// Validación de longitud y tipo de caracteres
fun askName(): String {
    var name : String
    do {
        println("Ingrese nombre de usuario (entre 1 y 20 caracteres): ")
        name = readLine()?.trim()?: ""

    } while (name.length > 20 || !name.matches(Regex("^[a-zA-Z]+$")))

    return name
}

// Validación de tipo de caracteres.
fun askLastName(): String {
    var lastName : String
    do {
        println("Ingrese apellido de usuario: ")
        lastName = readLine()?.trim()?: ""

    } while (!lastName.matches(Regex("^[a-zA-Z]+$")))

    return lastName
}

// Validación para edad
fun askAge(): Int {
    var age : Int
    do {
        println("Ingrese edad: ")
        val input = readLine()
        age = input?.toIntOrNull()?: 0

    } while (age <= 0)

    return age
}

// Validación para email
fun askEmail(): String {
    var email: String
    do {
        println("Ingrese el correo electrónico:")
        email = readLine()?.trim() ?: ""

        // La validación consta de 6 partes, separadas por []
    } while (!email.matches(Regex("[A-Za-z0-9._%+-]+" + // Valida caracteres para nombre de usuario
                "@" + // Valida que exista @.
                "[A-Za-z0-9.-]+" + // Valida caracteres para el proveedor de email.
                "\\." + // Valida que exista un . en la dirección.
                "[A-Za-z]" + // Valida caracteres para el dominio.
                "{2,}"))) // Valida que el dominio tenga al menos 2 caracteres.

    return email
}

// Validación del sistema de salud
fun askHealthSystem(): String {
    var healthSystem: String
    do {
        println("Ingrese el sistema de salud (FONASA/ISAPRE/PARTICULAR):")
        healthSystem = readLine()?.trim()?.uppercase()?: ""
    } while (healthSystem != "FONASA" && healthSystem != "ISAPRE" && healthSystem != "PARTICULAR")

    return healthSystem
}
