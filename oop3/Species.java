public abstract class Species {
    String speciesName;
    int sleepRequirement;
    int foodRequirement;
    int playRequirement;

    public Species(int s, int f, int p, String sp) {
        this.sleepRequirement = s;
        this.foodRequirement = f;
        this.playRequirement = p;
        this.speciesName = sp;
    }

    abstract void feed();
    abstract void sleep();
    abstract void play();
}
