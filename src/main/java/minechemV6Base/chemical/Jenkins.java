package minechemV6Base.chemical;

import java.util.HashMap;
import java.util.Map;

public class Jenkins
{
    public static Map<String, ChemicalBase> chemicals = new HashMap<String, ChemicalBase>();

    public static void place(ChemicalBase chemical)
    {
        chemicals.put(getKey(chemical), chemical);
    }

    public static ChemicalBase find(String key)
    {
        return chemicals.get(key);
    }

    public static String getKey(ChemicalBase chemical)
    {
        return chemical.getName();
    }
}
