package com.project;

import com.password4j.Password;

class Main {
    public static void main(String[] args) {

        // Contrasenya que volem definir o validar
        String pwd0 = "hola";
        String pwd1 = "adeu";

        // Valor "Salt" que es genera automàticament
        // al crear l'usuari en una taula i base de dades
        // diferent a la que conté les dades d'usuaris
        String pwdSalt = "ac4re21";

        // Valor "Pepper" que es genera automàticament
        // al crear l'usuari en una taula i base de dades
        // diferent a la que conté les dades d'usuaris
        String pwdPepper = "pepperCool";

        // Generar el HASH, quan l'usuari defineix una 
        // contrasenya es guarda a la taula d'usuaris
        // enlloc de la contrasenya "en clar"
        // Per generar el HASH cal:
        // - La contrasenya que defineix l'usuari
        // - El salt d'aquest usuari
        // - El pepper d'aquest usuari
        String hash = Password.hash(pwd0).addSalt(pwdSalt).addPepper(pwdPepper).withArgon2().getResult();
        System.out.println("Hash generat: " + hash);

        // Imaginem que guardem el valor anterior a 
        // la base de dades i que quan el llegim el 
        // guardem a la variable "pwdHash"
        String pwdHash = "$argon2id$v=19$m=4096,t=20,p=4$YWM0cmUyMQ$+Tr/FOiVJSR2nJqJ3eC9nHsngWdNf+tFEHqmKiCO6b3Qafq+P6bs1FPMhxx9mwCSCL0zpWPsDpXBAjvZYjQarOhWOdHeNRFALM//Q4CJNHytZxi9x8yxpHENLqlwdQrpW3WKolHaxnxIEWfY6yKZl2DFPedZYLEoInpMsP/RRa4";

        // Per validar si la contrasenya és correcta o no:
        // - La contrasenya que es vol validar
        // - El hash que correspon a aquest usuari
        // - El salt d'aquest usuari
        // - El pepper d'aquest usuari
        boolean verified0 = Password.check(pwd0, pwdHash).addSalt(pwdSalt).addPepper(pwdPepper).withArgon2();
        boolean verified1 = Password.check(pwd1, pwdHash).addSalt(pwdSalt).addPepper(pwdPepper).withArgon2();

        // Mostrar el hash i si és vàlid per aquesta contrasenya
        System.out.println("Password '" + pwd0 + "' is " + (verified0 ? "valid" : "invalid"));
        System.out.println("Password '" + pwd1 + "' is " + (verified1 ? "valid" : "invalid"));
    }
}