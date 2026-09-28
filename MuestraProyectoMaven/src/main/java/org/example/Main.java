package org.example;

import net.datafaker.Faker;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Faker faker = new Faker();

        for(int i = 0; i < 10; i++) {
            String nom = faker.animal().scientificName();
            System.out.println(nom);
        }
    }
}
