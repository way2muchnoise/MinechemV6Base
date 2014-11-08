package minechemV6Base.process;


import java.util.HashMap;
import java.util.LinkedHashMap;

public class ProcessType
{
    public static HashMap<ProcessType,String> processTypes = new LinkedHashMap<ProcessType,String>();
    public static HashMap<String,ProcessType> processNames = new LinkedHashMap<String,ProcessType>();

    public static final ProcessType heat = addProcess("heat");
    public static final ProcessType acid = addProcess("acid");
    public static final ProcessType friction = addProcess("friction");
    public static final ProcessType electrolysis = addProcess("electroylysis");

    private String name;

    public ProcessType(String name)
    {
        this.name=name;
    }

    public static ProcessType addProcess(String name)
    {
        if (name!=null)
        {
            ProcessType result = new ProcessType(name);
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

    public static ProcessType getProcess(String name)
    {
        return processNames.get(name);
    }
}
