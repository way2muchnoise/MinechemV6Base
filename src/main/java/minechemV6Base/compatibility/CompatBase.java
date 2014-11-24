package minechemV6Base.compatibility;

import minechemV6Base.utils.ModList;

public class CompatBase
{
    public static void register()
    {
        for (ModList value:ModList.values())
            value.initialize();
    }

    public boolean initialise(ModList modlist)
    {
        if (modlist.isLoaded()) {
            init();
            return true;
        }
        return false;
    }

    public void init()
    {
    }
}
