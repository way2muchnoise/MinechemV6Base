package minechemV6Base.chemical;

import minechemV6Base.chemical.properties.IRadioactive;
import minechemV6Base.chemical.properties.IState;
import minechemV6Base.chemical.properties.RadioactivityEnum;
import minechemV6Base.chemical.properties.StateEnum;
import minechemV6Base.process.ProcessType;
import net.minecraft.nbt.NBTTagCompound;

import java.util.ArrayList;

public abstract class ChemicalBase implements IChemical, IState, IRadioactive
{
    protected int temp, mass, meltingPoint, boilingPoint;
    protected Long halfLife;
    protected String name;
    protected RadioactivityEnum radioactivity;

    public ChemicalBase(String name)
    {
        this.name = name;
        this.temp = 293;
        this.halfLife = -1L;
        this.meltingPoint = 0;
        this.boilingPoint = 1000; // don't ask me where the values are from at all
    }

    public ChemicalBase(String name, int temp)
    {
        this(name);
        this.temp = temp;
    }
    
    public ChemicalBase(String name, int temp, int meltingPoint, int boilingPoint)
    {
        this(name,temp);
        this.meltingPoint=meltingPoint;
        this.boilingPoint=boilingPoint;
    }

    public ChemicalBase(String name, int temp, int meltingPoint, int boilingPoint, Long halfLife)
    {
        this(name, temp, meltingPoint, boilingPoint);
        this.halfLife = halfLife;
        this.radioactivity = RadioactivityEnum.getRadioactivity(this.halfLife);
    }


    //IChemical
    //##############################################
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
    public String getName()
    {
        return this.name;
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

    //IState
    //##############################################
    @Override
    public ChemicalBase setStateBounds(int meltingPoint, int boilingPoint)
    {
        this.meltingPoint = meltingPoint;
        this.boilingPoint = boilingPoint;
        return this;
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
        return getState(temp);
    }

    @Override
    public StateEnum getState(int temperature)
    {
        if (temperature>=boilingPoint){
        	return StateEnum.gas;
        }else if (temperature>=meltingPoint){
        	return StateEnum.liquid;
        }else{
        	return StateEnum.solid;
        }
    }

    @Override
    public int getTemperature()
    {
        return temp;
    }

    @Override
    public int getMeltingPoint()
    {
        return meltingPoint;
    }

    @Override
    public int getBoilingPoint()
    {
        return boilingPoint;
    }

    //IRadioactivity
    //#####################################################

    @Override
    public long getHalfLife()
    {
        return this.halfLife;
    }

    @Override
    public RadioactivityEnum getRadioactivity()
    {
        return this.radioactivity;
    }

    @Override
    public int getDamage()
    {
        return this.radioactivity.getDamage();
    }

}
