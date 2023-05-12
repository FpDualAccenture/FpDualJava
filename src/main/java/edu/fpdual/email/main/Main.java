package edu.fpdual.email.main;

import edu.fpdual.email.sender.Sender;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws
        FileNotFoundException,
        IOException {
        new Sender().send("fpdualaccenture@gmail.com", "fpdualaccenture@gmail.com", "FpDual",
            "<h3>Hola</h3>"
                + "<b>Estoy aprendiendo a enviar emails con adjuntos<b>","c:\\DEV\\temp\\mail.properties");
//                new Sender().send("fpdualaccenture@gmail.com", "fpdualaccenture@gmail.com", "FpDual",
//                        "<h3>Hola</h3>"
//                            + "<b>Estoy aprendiendo a enviar emails<b>");
    }
}
