package HW6.pet;

public enum Species {
    DOMESTICCAT("DomesticCat"),
    DOG("Dog"),
    RABBIT("RABBIT"),
    RAT("Rat"),
    OWL("Owl"),
    ROBOCAT("RoboCat"),
    FISH("Fish"),
    UNKNOWN("Unknown");


    private final String species;

    Species(String species) {
        this.species = (species == null) ? "Unknown" : species;
    }

    public String getSpecies() {
        return species;
    }

    @Override
    public String toString() {
        return species;
    }
}
