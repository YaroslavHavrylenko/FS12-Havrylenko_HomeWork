package HW5.pet;

public enum Species {
    CAT ("Cat"),
    DOG ("Dog"),
    RABBIT ("RABBIT"),
    RAT ("Rat"),
    OWL ("Owl");

    private final String spice;


    Species(String spice) {
        this.spice = spice;
    }

    public String getSpice() {
        return spice;
    }

    @Override
    public String toString() {
        return spice;
    }
}
