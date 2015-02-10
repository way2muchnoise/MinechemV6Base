package minechemV6Base.process;

import minechemV6Base.chemical.ChemicalBase;

import java.util.Random;

public class ChemicalMultiChanceProcess extends ChemicalProcess
{
    private ChemicalBase[][] outputs;
    
    public ChemicalMultiChanceProcess(ChemicalProcessType type, int level, ChemicalBase[]... components)
    {
        super(type, level);
        outputs = components;
    }

    @Override
    public ChemicalBase[] getOutput(ChemicalProcessType type, int level)
    {
        if (super.getOutput(type, level) != empty)
        {
            return outputs[new Random().nextInt(outputs.length)];
        }
        return empty;
    }
}
