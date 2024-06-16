package fr.epsi;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu-petstore");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Création de PetStore
        PetStore petStore = new PetStore();
        petStore.setName("oui");
        petStore.setManagerName("oui");
        em.persist(petStore);

        // Création d'address
        Address address = new Address();
        address.setNumber("123");
        address.setStreet("oui");
        address.setZipCode("12345");
        address.setCity("tourcoing");
        address.setPetStore(petStore);
        em.persist(address);

        // Création de produits
        Product product1 = new Product();
        product1.setCode("P001");
        product1.setLabel("croquette");
        product1.setType(ProdType.FOOD);
        product1.setPrice(19.99);
        product1.setPetStore(petStore);
        em.persist(product1);

        Product product2 = new Product();
        product2.setCode("P002");
        product2.setLabel("jouet_pour_chat");
        product2.setType(ProdType.ACCESSORY);
        product2.setPrice(9.99);
        product2.setPetStore(petStore);
        em.persist(product2);

        // Création d'animaux
        Fish fish = new Fish();
        fish.setAnimal_Name("oui");
        fish.setBirthDate(new Date());
        fish.setCouleur("Gold");
        fish.setLivingEnv(FishLivEnv.FRESH_WATER);
        fish.setPetStore(petStore);
        em.persist(fish);

        Cat cat = new Cat();
        cat.setAnimal_Name("lechat");
        cat.setBirthDate(new Date());
        cat.setCouleur("Black");
        cat.setChipId("123ABC");
        cat.setPetStore(petStore);
        em.persist(cat);

        em.getTransaction().commit();

        // Requête pour extraire tous les animaux d’une animalerie donnée
        List<Animal> animals = em.createQuery("SELECT a FROM Animal a WHERE a.petStore.id = :storeId", Animal.class)
                .setParameter("storeId", petStore.getId())
                .getResultList();

        for (Animal a : animals) {
            System.out.println("Animal Name: " + a.getAnimal_Name());
        }

        em.close();
        emf.close();
    }
}