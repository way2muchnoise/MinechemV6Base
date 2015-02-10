package minechemV6Base.process;

import minechemV6Base.chemical.ChemicalBase;

import java.util.Random;

public class ChemicalChanceProcess extends ChemicalProcess
{
    private float chance;
    
    public ChemicalChanceProcess(ChemicalProcessType type, int level, float chance, ChemicalBase... components)
    {
        super(type, level, components);
        this.chance = chance;
        if (this.chance > 1) this.chance = 1;
        if (this.chance < 0) this.chance = 0;
    }

    @Override
    public ChemicalBase[] getOutput(ChemicalProcessType type, int level)
    {
        if (new Random().nextFloat() > chance)
        {
            return super.getOutput(type, level);
        }
        return empty;
    }
}
