package minechemV6Base.compatibility.lua.events;

import cpw.mods.fml.common.Optional;
import dan200.computercraft.api.peripheral.IComputerAccess;
import li.cil.oc.api.machine.Context;
import minechemV6Base.reference.Reference;
import minechemV6Base.tileentities.TileEntityComputerBase;
import minechemV6Base.utils.ModList;
import net.minecraft.tileentity.TileEntity;

public abstract class LuaEvent {

    String name;

    public LuaEvent(String name)
    {
        this.name = name;
    }

    public abstract boolean checkEvent(TileEntity te);

    public void announce(TileEntity te, Object... message)
    {
        if (!(te instanceof TileEntityComputerBase)) return;
        TileEntityComputerBase cTE = (TileEntityComputerBase) te;
        if (ModList.computercraft.isLoaded())
            computerCraftAnnounce(cTE, message);
        if (ModList.opencomputers.isLoaded())
            openComputersAnnounce(cTE, message);
    }

    @Optional.Method(modid = Reference.COMPUTERCRAFT)
    public void computerCraftAnnounce(TileEntityComputerBase te, Object... message)
    {
        for (Object computer:te.getComputers())
        {
            ((IComputerAccess)computer).queueEvent(name,message);
        }
    }

    @Optional.Method(modid = Reference.OPENCOMPUTERS)
    public void openComputersAnnounce(TileEntityComputerBase te, Object... message)
    {
        for (Object context:te.getContext()) {
            ((Context)context).signal(name, message);
        }
    }
}
