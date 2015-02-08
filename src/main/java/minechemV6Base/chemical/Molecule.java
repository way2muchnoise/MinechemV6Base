package minechemV6Base.chemical;

import java.util.Arrays;
import java.util.LinkedList;

public class Molecule extends ChemicalBase
{
    public static class ChemicalBaseSet
    {
        public ChemicalBase chemical;
        public int count;
        
        public ChemicalBaseSet(ChemicalBase chemical)
        {
            this(chemical, 1);
        }
        
        public ChemicalBaseSet(ChemicalBase chemical, int count)
        {
            this.chemical = chemical;
            this.count = count;
        }
    }
    
    private LinkedList<ChemicalBaseSet> structure = new LinkedList<ChemicalBaseSet>();

    public Molecule(String name, ChemicalBaseSet... structure)
    {
        super(name);
        initStructure(structure);
    }

    public Molecule(String name, int temp, ChemicalBaseSet... structure)
    {
        super(name, temp);
        initStructure(structure);
    }

    public Molecule(String name, int temp, int meltingPoint, int boilingPoint, ChemicalBaseSet... structure)
    {
        super(name, temp, meltingPoint, boilingPoint);
        initStructure(structure);
    }

    public Molecule(String name, int temp, int meltingPoint, int boilingPoint, Long halfLife, ChemicalBaseSet... structure)
    {
        super(name, temp, meltingPoint, boilingPoint, halfLife);
        initStructure(structure);
    }

    private void initStructure(ChemicalBaseSet... structure)
    {
        this.structure.addAll(Arrays.asList(structure));
    }

    @Override
    public String getFormula()
    {
        String formula = "";
        for (ChemicalBaseSet chemicalBaseSet : structure)
        {
            boolean molecule = chemicalBaseSet.chemical instanceof Molecule;
            if (molecule) formula += "(";
            formula += chemicalBaseSet.chemical.getFormula();
            if (molecule) formula += ")";
            formula += chemicalBaseSet.count;
        }
        return formula;
    }

    @Override
    public boolean isElement()
    {
        return false;
    }
}
