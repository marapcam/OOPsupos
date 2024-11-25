
public class Start {

    public static void main(String[] args) {
        int[] sleepRequirements = {2, 2, 5, 3};
        int[] foodRequirements = {3, 3, 1, 2};
        int[] playRequirements = {4, 1, 1, 1};
        String[] speciesNames = {"Unicorn", "Tarantula" ,"Sloth" ,"Armadillo"};

        Interface ui = new TUI();
        String ownName = ui.takeInput("Please enter your name: ");
        for (int j = 0; j <speciesNames.length; j++) {
            ui.giveOutput((j+1)+". "+speciesNames[j]);
        }
        String species = ui.takeInput("What number species is your pet? ");
        String petName = ui.takeInput("Please enter the name of your pet: ");
        int i = Integer.parseInt(species)-1;
        new Pet(sleepRequirements[i], foodRequirements[i], playRequirements[i],
                speciesNames[i], petName, ownName);
    }
}
