package minechemV6Base.chemical;

import minechemV6Base.chemical.properties.RadioactivityEnum;
import minechemV6Base.chemical.properties.StateEnum;
import net.minecraft.nbt.NBTTagCompound;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class Molecule extends ChemicalBase
{
    private HashMap<ChemicalBase, Integer> structure = new LinkedHashMap<ChemicalBase, Integer>();

    public Molecule(String name, Map.Entry<ChemicalBase, Integer>... structure)
    {
        super(name);
        initStructure(structure);
    }

    public Molecule(String name, int temp, Map.Entry<ChemicalBase, Integer>... structure)
    {
        super(name, temp);
        initStructure(structure);
    }

    public Molecule(String name, int temp, StateEnum state, Map.Entry<ChemicalBase, Integer>... structure)
    {
        super(name, temp, state);
        initStructure(structure);
    }

    public Molecule(String name, int temp, RadioactivityEnum radioactivity, Map.Entry<ChemicalBase, Integer>... structure)
    {
        super(name, temp, radioactivity);
        initStructure(structure);
    }

    private void initStructure(Map.Entry<ChemicalBase, Integer>... structure)
    {
        for (Map.Entry<ChemicalBase, Integer> entry : structure)
        {
            this.structure.put(entry.getKey(), entry.getValue());
        }
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
        String formula = "";
        for (Map.Entry<ChemicalBase, Integer> entry : structure.entrySet())
        {
            boolean molecule = entry.getKey() instanceof Molecule;
            if (molecule) formula += "(";
            formula += entry.getKey().getFormula();
            if (molecule) formula += ")";
            formula += entry.getValue();
        }
        return formula;
    }

    public static Map.Entry<Molecule, Integer> create(Molecule molecule, int amount)
    {
        return new LinkedHashMap.SimpleEntry<Molecule, Integer>(molecule, amount);
    }
}
