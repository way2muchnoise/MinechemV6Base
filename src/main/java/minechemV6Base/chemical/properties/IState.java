package minechemV6Base.chemical.properties;

import minechemV6Base.chemical.IChemical;

public interface IState
{
    public IChemical setTemperature(int temperature);

    public StateEnum getState();

    public StateEnum getState(int temperature);
}
