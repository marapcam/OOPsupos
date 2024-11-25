import java.util.Scanner;

public class TUI implements Interface{
    private Scanner s = new Scanner(System.in);

    public String takeInput(String prompt) {
        giveOutput(prompt);
        return s.nextLine();
    }

    public void giveOutput(String output) {
        System.out.println(output);
    }
}
