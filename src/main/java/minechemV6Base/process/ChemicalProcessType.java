package minechemV6Base.process;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class ChemicalProcessType
{
    public static HashMap<ChemicalProcessType,String> processTypes = new LinkedHashMap<ChemicalProcessType,String>();
    public static HashMap<String,ChemicalProcessType> processNames = new LinkedHashMap<String,ChemicalProcessType>();

    public static final ChemicalProcessType heat = addProcess("heat");
    public static final ChemicalProcessType acid = addProcess("acid");
    public static final ChemicalProcessType friction = addProcess("friction");
    public static final ChemicalProcessType electrolysis = addProcess("electroylysis");

    private String name;

    public ChemicalProcessType(String name)
    {
        this.name=name;
    }

    public static ChemicalProcessType addProcess(String name)
    {
        if (name!=null)
        {
            ChemicalProcessType result = new ChemicalProcessType(name);
            if (processTypes.get(result)==null && processNames.get(name)==null)
            {
                processTypes.put(result, name);
                processNames.put(name, result);
                return result;
            }
        }
        return null;
    }

    @Override
    public String toString()
    {
        return name;
    }

    public static ChemicalProcessType getProcess(String name)
    {
        return processNames.get(name);
    }
}
