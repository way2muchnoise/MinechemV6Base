package minechemV6Base.chemical;

import minechemV6Base.chemical.properties.RadioactivityEnum;
import minechemV6Base.chemical.properties.StateEnum;
import net.minecraft.nbt.NBTTagCompound;

public class Molecule extends ChemicalBase
{
    public Molecule(String name, Element... elements)
    {
        super(name);
    }

    public Molecule(String name, int temp, Element... elements)
    {
        super(name, temp);
    }

    public Molecule(String name, int temp, StateEnum state, Element... elements)
    {
        super(name, temp, state);
    }

    public Molecule(String name, int temp, RadioactivityEnum radioactivity, Element... elements)
    {
        super(name, temp, radioactivity);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        return compound;
    }

    @Override
    public Molecule readFromNBT(NBTTagCompound compound)
    {
        return null;
    }

    @Override
    public String getFormula()
    {
        return null;
    }
}
