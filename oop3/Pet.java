import java.util.List;

public class Pet extends Species {
    String petName;
    String ownerName;
    int sleepiness;
    int hunger;
    int boredom;
    private final Interface ui;

    public Pet(int s, int f, int p, String speciesName, String pet, String owner) {
        super(s, f, p, speciesName);
        ui = new TUI();
        petName = pet;
        ownerName = owner;
        sleepiness = 0;
        hunger = 0;
        boredom = 0;

        while (true) {
            try {
                playRound();
            } catch (RuntimeException e) {
                ui.giveOutput("End of Game: " + e.getMessage());
                break;
            }
        }
    }

    public void playRound() {
        sleepiness += sleepRequirement;
        hunger += foodRequirement;
        boredom += playRequirement;

        giveWarnings();

        ui.giveOutput("\n"+petName+" the "+speciesName+"'s current stats:\nsleepiness: "+sleepiness+"/15\nhunger: "+hunger+"/15\nboredom: "+boredom+"/15");

        String i = ui.takeInput("\n"+ownerName+", Would you like to \n1. Feed "+petName+"\n2. Play with "+petName+"\n3. Let "+petName+" sleep");
        List<Runnable> actions = List.of(this::feed, this::play, this::sleep);
        actions.get(Integer.parseInt(i)-1).run();
    }

    public void giveWarnings() {
        if (hunger > 15) {
            ui.giveOutput(petName + " got too hungry and has died :(");
            throw new RuntimeException(ownerName+" has killed "+petName);
        } else if (hunger > 10) {
            ui.giveOutput(petName + " is getting very hungry");
        }
        if (sleepiness > 15) {
            ui.giveOutput(petName + " got too tired, fell asleep in the road and has died :(");
            throw new RuntimeException(ownerName+" has killed "+petName);
        } else if (sleepiness > 10) {
            ui.giveOutput(petName + " is getting very tired");
        }
        if (boredom > 15) {
            ui.giveOutput(petName + " got too bored, ran away and can be assumed dead :(");
            throw new RuntimeException(ownerName+" has killed "+petName);
        } else if (boredom > 10) {
            ui.giveOutput(petName + " is getting very bored");
        }
    }

    public void feed() {
        hunger = 0;
        ui.giveOutput(petName+" had a lovely meal");
    }

    public void sleep() {
        sleepiness = 0;
        ui.giveOutput(petName+" had a lovely sleep");
    }

    public void play() {
        if (hunger > 10) {
            ui.giveOutput(petName+" was too hungry to play");
        }
        else if (sleepiness > 10) {
            ui.giveOutput(petName+" was too tired to play");
        } else {
            boredom = 0;
            sleepiness += 2;
            ui.giveOutput(petName+" had a lot of fun playing with you");
        }
    }
}
