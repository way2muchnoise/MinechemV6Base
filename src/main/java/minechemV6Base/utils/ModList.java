package minechemV6Base.utils;

import cpw.mods.fml.common.Loader;
import minechemV6Base.compatibility.CompatBase;
import minechemV6Base.compatibility.computercraft.ComputerCraftCompat;
import minechemV6Base.reference.Reference;

public enum ModList
{
    cofhcore("CoFHCore"),
    computercraft(Reference.COMPUTERCRAFT, ComputerCraftCompat.class),
    opencomputers(Reference.OPENCOMPUTERS);

    private String id;
    private Class compatClass = null;
    private boolean isLoaded;

    ModList(String name)
    {
        this(name,null);
    }

    ModList(String name, Class compatClass)
    {
        this.id = name;
        this.compatClass = compatClass;
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

    public CompatBase initialize()
    {
        if (!isLoaded || compatClass == null) return null;
        try {
            return (CompatBase) compatClass.getConstructor(ModList.class).newInstance(this);
        } catch (Exception e) {
        }
        return null;
    }
}
