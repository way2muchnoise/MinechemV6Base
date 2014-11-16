package minechemV6Base.utils;

import cpw.mods.fml.common.Loader;
import minechemV6Base.reference.Reference;

public enum ModList
{
    cofhcore("CoFHCore"),
    minecraft("minecraft"),
    computercraft(Reference.COMPUTERCRAFT),
    opencomputers(Reference.OPENCOMPUTERS);

    private String id;
    private Boolean isLoaded = null;


    ModList(String name)
    {
        this.id = name;
    }

    @Override
    public String toString()
    {
        return id;
    }

    public boolean isLoaded()
    {
        if (isLoaded!=null) return isLoaded;
        return isLoaded = Loader.isModLoaded(this.id);
    }
}
