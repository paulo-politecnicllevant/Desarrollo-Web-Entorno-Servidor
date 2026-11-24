package org.example.jdbcdao.model;

import java.util.Map;

public class Usuaris {

    private static final Map<String, String> USUARIS = Map.of(
            "anna", "anna123",
            "marc", "marc123"
    );

    private Usuaris() {
    }

    public static boolean autentica(String nom, String contrasenya) {
        return nom != null && contrasenya != null && contrasenya.equals(USUARIS.get(nom));
    }
}
