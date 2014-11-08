package minechemV6Base.chemical.properties;

import minechemV6Base.chemical.IChemical;

public interface IState
{
    public IChemical setTemperature(int temperature);

    public int getTemperature();

    public StateEnum getState();

    public StateEnum getState(int temperature);

    public IChemical setStateBounds(int meltingPoint, int boilingPoint);

    public int getMeltingPoint();

    public int getBoilingPoint();
}
