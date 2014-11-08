package minechemV6Base.process;

import minechemV6Base.chemical.ChemicalBase;

public class Process {

    private ProcessType type;
    private int level;
    private ChemicalBase[] output;

    public Process(ProcessType type, int level, ChemicalBase... components)
    {
        this.type = type;
        this.level = level;
        this.output = components;
    }

    public ChemicalBase[] getOutput(ProcessType type, int level)
    {
        if (this.type == type && level>= this.level) return output;
        return new ChemicalBase[0];
    }
}
