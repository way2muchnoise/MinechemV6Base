package minechemV6Base.process;

import minechemV6Base.chemical.ChemicalBase;
import net.minecraft.item.ItemStack;

import java.util.*;

public class ChemicalProcessRegistry
{
    private static ChemicalProcessRegistry instance;
    // TODO: change this key to something that does work
    private Map<ItemStack, Map<ChemicalProcessType, Set<ChemicalProcess>>> processMap;
    
    public static ChemicalProcessRegistry getInstance()
    {
        if (instance == null) instance = new ChemicalProcessRegistry();
        return instance;
    }
    
    private ChemicalProcessRegistry()
    {
        processMap = new HashMap<ItemStack, Map<ChemicalProcessType, Set<ChemicalProcess>>>();
    }
    
    public void addProcess(ItemStack itemStack, ChemicalProcess process)
    {
        Map<ChemicalProcessType, Set<ChemicalProcess>> chemicalTypes = processMap.get(itemStack);
        if (chemicalTypes == null)
            chemicalTypes = new HashMap<ChemicalProcessType, Set<ChemicalProcess>>();
        Set<ChemicalProcess> processes = chemicalTypes.get(process.getType());
        if (processes == null)
            processes = new HashSet<ChemicalProcess>();
        processes.add(process);
        chemicalTypes.put(process.getType(), processes);
        processMap.put(itemStack, chemicalTypes);
    }
    
    public ChemicalBase[] getOutput(ItemStack itemStack, ChemicalProcessType processType, int level)
    {
        Map<ChemicalProcessType, Set<ChemicalProcess>> chemicalTypes = processMap.get(itemStack);
        if (itemStack == null) return ChemicalProcess.empty;
        Set<ChemicalProcess> processes = chemicalTypes.get(processType);
        if (processType == null) return ChemicalProcess.empty;
        List<ChemicalBase> output = new ArrayList<ChemicalBase>();
        for (ChemicalProcess process : processes)
            output.addAll(Arrays.asList(process.getOutput(processType, level)));
        return output.toArray(new ChemicalBase[output.size()]);
    }
}
