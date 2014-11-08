package minechemV6Base.chemical;

import minechemV6Base.chemical.properties.IRadioactive;
import minechemV6Base.chemical.properties.IState;
import minechemV6Base.chemical.properties.RadioactivityEnum;
import minechemV6Base.chemical.properties.StateEnum;
import minechemV6Base.process.ProcessType;

import java.util.ArrayList;

public abstract class ChemicalBase implements IChemical, IState, IRadioactive
{
    protected int temp, mass;
    protected StateEnum state;
    protected RadioactivityEnum radioactivity;
    protected String name;

    public ChemicalBase(String name)
    {
        this.name = name;
        this.temp = 0;
        this.state = StateEnum.solid;
        this.radioactivity = RadioactivityEnum.stable;
    }

    public ChemicalBase(String name, int temp)
    {
        this(name);
        this.temp = temp;
    }

    public ChemicalBase(String name, int temp, StateEnum state)
    {
        this(name, temp);
        this.state = state;
    }

    public ChemicalBase(String name, int temp, RadioactivityEnum radioactivity)
    {
        this(name, temp);
        this.radioactivity = radioactivity;
    }

    @Override
    public ArrayList<IChemical> getOutput(ProcessType type, int level)
    {
        return null;
    }

    @Override
    public int getMass()
    {
        return this.mass;
    }

    @Override
    public ChemicalBase setTemperature(int temperature)
    {
        this.temp = temperature;
        return this;
    }

    @Override
    public StateEnum getState()
    {
        return this.state;
    }

    @Override
    public StateEnum getState(int temperature)
    {
        return this.state;
    }

    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public long getHalfLife()
    {
        return this.radioactivity.getHalfLife();
    }
}
