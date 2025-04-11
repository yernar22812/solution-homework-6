package Part2;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Light livingRoomLight = new Light();
        Thermostat thermostat = new Thermostat();

        Command lightOn = new TurnOnLightCommand(livingRoomLight);
        Command temp22 = new SetThermostatCommand(thermostat, 22);

        MacroCommand goodNight = new MacroCommand(Arrays.asList(
                lightOn,
                temp22
        ));

        SmartHomeRemoteControl remote = new SmartHomeRemoteControl();
        remote.setCommand("light", lightOn);
        remote.setCommand("temp22", temp22);
        remote.setCommand("goodnight", goodNight);

        while (true) {
            System.out.println("""
            \n--- Smart Home Remote ---
            Choose an option:
            1. Turn on light
            2. Set temperature to 22°C
            3. Goodnight mode (macro)
            4. Undo
            5. Redo
            0. Exit
            -------------------------
            """);

            String input = scanner.nextLine();
            switch (input) {
                case "1" -> remote.pressButton("light");
                case "2" -> remote.pressButton("temp22");
                case "3" -> remote.pressButton("goodnight");
                case "4" -> remote.undoButton();
                case "5" -> remote.redoButton();
                case "0" -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }
        }
    }
}
