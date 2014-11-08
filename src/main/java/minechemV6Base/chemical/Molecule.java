package minechemV6Base.chemical;

import minechemV6Base.chemical.properties.IRadioactive;
import minechemV6Base.chemical.properties.IState;
import minechemV6Base.chemical.properties.StateEnum;
import minechemV6Base.process.ProcessType;
import net.minecraft.nbt.NBTTagCompound;

import java.util.ArrayList;

public class Molecule implements IChemical, IState, IRadioactive
{
    @Override
    public ArrayList<IChemical> getOutput(ProcessType type, int level)
    {
        return null;
    }

    @Override
    public int getMass()
    {
        return 0;
    }

    @Override
    public boolean isElement()
    {
        return false;
    }

    @Override
    public void setTemperature()
    {

    }

    @Override
    public StateEnum getState()
    {
        return null;
    }

    @Override
    public StateEnum getState(int temperature)
    {
        return null;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        return null;
    }

    @Override
    public IChemical readFromNBT(NBTTagCompound compound)
    {
        return null;
    }

    @Override
    public long getHalfLife()
    {
        return 0;
    }
}
