package Part2;

public class SetThermostatCommand implements Command {
    private Thermostat thermostat;
    private int temp;

    public SetThermostatCommand(Thermostat thermostat, int temp) {
        this.thermostat = thermostat;
        this.temp = temp;
    }

    @Override
    public void execute() {
        thermostat.setTemperature(temp);
    }

    @Override
    public void undo() {
        thermostat.revertTemperature();
    }
}