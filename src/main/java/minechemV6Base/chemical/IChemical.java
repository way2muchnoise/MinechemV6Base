package minechemV6Base.chemical;

import minechemV6Base.chemical.properties.StateEnum;
import minechemV6Base.process.ProcessType;
import net.minecraft.nbt.NBTTagCompound;

import java.util.ArrayList;

public interface IChemical
{
    public ArrayList<IChemical> getOutput(ProcessType type, int level);

    public int getMass();

    public StateEnum getState(int temperature);

    public NBTTagCompound writeToNBT(NBTTagCompound compound);

    public String getFormula();

    public String getName();

    public boolean isElement();
}
