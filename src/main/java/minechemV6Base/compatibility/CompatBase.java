package minechemV6Base.compatibility;

import minechemV6Base.utils.ModList;

public class CompatBase
{

    public CompatBase(ModList modlist)
    {
        if (modlist.isLoaded())
            init();
    }

    public void init()
    {
    }
}