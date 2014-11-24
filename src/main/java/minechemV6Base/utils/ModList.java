package minechemV6Base.utils;

import cpw.mods.fml.common.Loader;
import minechemV6Base.compatibility.CompatBase;
import minechemV6Base.compatibility.computercraft.ComputerCraftCompat;
import minechemV6Base.reference.Reference;

public enum ModList
{
    cofhcore("CoFHCore"),
    computercraft(Reference.COMPUTERCRAFT, new ComputerCraftCompat()),
    opencomputers(Reference.OPENCOMPUTERS);

    private String id;
    private CompatBase compat;
    private boolean isLoaded;

    ModList(String name)
    {
        this(name,null);
    }

    ModList(String name, CompatBase compatBase)
    {
        this.id = name;
        this.compat = compatBase;
        isLoaded = Loader.isModLoaded(this.id);
    }

    @Override
    public String toString()
    {
        return id;
    }

    public boolean isLoaded()
    {
        return isLoaded;
    }

    public boolean initialize()
    {
        if (!isLoaded || compat == null) return false;
        try {
            return compat.initialise(this);
        } catch (Exception e) {
        }
        return false;
    }
}
