package minechemV6Base.process;

import minechemV6Base.chemical.IChemical;

public class Process {

    private ProcessType type;
    private int level;
    private IChemical[] output;

    public Process(ProcessType type, int level, IChemical... components)
    {
        this.type = type;
        this.level = level;
        this.output = components;
    }

    public IChemical[] getOutput(ProcessType type, int level)
    {
        if (this.type == type && level>= this.level) return output;
        return new IChemical[0];
    }
}
