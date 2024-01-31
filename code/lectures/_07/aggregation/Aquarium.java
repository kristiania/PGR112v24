package lectures._07.aggregation;

import java.util.ArrayList;


public class Aquarium
{
    //# Fields
    private final ArrayList<Fish> fish;
    private final ArrayList<Plant> plants;
    private final Liquid water;


    //# Constructors
    public Aquarium(double volume) {
        this.fish = new ArrayList<>();
        this.plants = new ArrayList<>();
        this.water = new Liquid("Water", volume);
    }

    public ArrayList<Fish> getAllFish() {
        return this.fish;
    }

    public ArrayList<Plant> getAllPlants() {
        return this.plants;
    }


    //# Getter-methods
    private Liquid getLiquid() {
        return this.water;
    }

    public double getVolume() {
        return this.getLiquid().getVolume();
    }


    //# Methods
    public void addFish(Fish fish) {
        this.fish.add(fish);
    }

    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    public void removeAllFish() {
        this.fish.clear();
    }

    public void addPlant(Plant plant) {
        this.plants.add(plant);
    }

    public void removePlant(Plant plant) {
        this.plants.remove(plant);
    }

    public void removeAllPlants() {
        this.plants.clear();
    }

    //# Static
    public static void main(String[] args) {
        Aquarium aquarium = new Aquarium(10.0);

        Fish alice = new Fish("Alice");
        Fish bob = new Fish("Bob");

        aquarium.addFish(alice);
        aquarium.addFish(bob);

        Plant plant1 = new Plant();
        Plant plant2 = new Plant();

        aquarium.addPlant(plant1);
        aquarium.addPlant(plant2);

        System.out.println("Akvariumet inneholder " + aquarium.getAllFish().size() + " fisker!");

        for (Fish fish : aquarium.getAllFish()) {
            System.out.println("Navnet på en fisk: " + fish.getName());
        }
    }
}