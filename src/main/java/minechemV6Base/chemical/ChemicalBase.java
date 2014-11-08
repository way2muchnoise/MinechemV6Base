package minechemV6Base.chemical;

import minechemV6Base.chemical.properties.IRadioactive;
import minechemV6Base.chemical.properties.IState;
import minechemV6Base.chemical.properties.StateEnum;
import minechemV6Base.process.ProcessType;
import net.minecraft.nbt.NBTTagCompound;

import java.util.ArrayList;

public abstract class ChemicalBase implements IChemical, IState, IRadioactive
{
    protected int temp, mass;
    protected StateEnum state;
    protected Long halfLife;
    protected String name;

    public ChemicalBase(String name)
    {
        this.name = name;
        this.temp = 293;
        this.state = StateEnum.solid;
        this.halfLife = -1L;
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

    public ChemicalBase(String name, int temp, Long halfLife)
    {
        this(name, temp);
        this.halfLife = halfLife;
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
        return this.halfLife;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        compound.setString("minechemKey", Jenkins.getKey(this));
        return compound;
    }

    /**
     * Creates a ChemicalBase object from NBTData
     *
     * @param compound
     * @return A chemical
     */
    public static ChemicalBase createChemicalFromNBT(NBTTagCompound compound)
    {
        ChemicalBase chemicalBase = null;
        if (compound.hasKey("minechemKey"))
        {
            chemicalBase = Jenkins.find(compound.getString("minechemKey"));
        }
        return chemicalBase;
    }
}
