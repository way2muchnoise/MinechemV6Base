package minechemV6Base.chemical;

import minechemV6Base.chemical.properties.RadioactivityEnum;
import minechemV6Base.chemical.properties.StateEnum;
import net.minecraft.nbt.NBTTagCompound;

import java.util.LinkedHashMap;
import java.util.Map;

public class Element extends ChemicalBase
{
    private String symbol;

    public Element(String name, String symbol)
    {
        super(name);
        this.symbol = symbol;
    }

    public Element(String name, int temp, String symbol)
    {
        super(name, temp);
        this.symbol = symbol;
    }

    public Element(String name, int temp, StateEnum state, String symbol)
    {
        super(name, temp, state);
        this.symbol = symbol;
    }

    public Element(String name, int temp, RadioactivityEnum radioactivity, String symbol)
    {
        super(name, temp, radioactivity);
        this.symbol = symbol;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        return null;
    }

    @Override
    public Element readFromNBT(NBTTagCompound compound)
    {
        return null;
    }

    @Override
    public String getFormula()
    {
        return symbol;
    }

    public static Map.Entry<Element, Integer> create(Element element, int amount)
    {
        return new LinkedHashMap.SimpleEntry<Element, Integer>(element, amount);
    }
}
