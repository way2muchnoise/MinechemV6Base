package minechemV6Base.chemical.properties;

public interface IState
{
    public void setTemperature();

    public StateEnum getState();

    public StateEnum getState(int temperature);
}
