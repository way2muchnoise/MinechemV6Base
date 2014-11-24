package minechemV6Base.compatibility.computercraft;

import cpw.mods.fml.common.Optional;
import dan200.computercraft.api.ComputerCraftAPI;
import dan200.computercraft.api.peripheral.IPeripheral;
import dan200.computercraft.api.peripheral.IPeripheralProvider;
import minechemV6Base.reference.Reference;
import minechemV6Base.tileentities.TileEntityComputerBase;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

@Optional.Interface(iface = "dan200.computercraft.api.peripheral.IPeripheralProvider", modid = Reference.COMPUTERCRAFT)
public class PeripheralProvider implements IPeripheralProvider
{
    public static void register()
    {
        ComputerCraftAPI.registerPeripheralProvider(new PeripheralProvider());
    }

    @Override
    @Optional.Method(modid = Reference.COMPUTERCRAFT)
    public IPeripheral getPeripheral(World world, int x, int y, int z, int side)
    {
        TileEntity te = world.getTileEntity(x, y, z);
        if (te instanceof TileEntityComputerBase)
        {
            return (IPeripheral) te;
        }
        return null;
    }
}
