package minechemV6Base.compatibility.computercraft;

import minechemV6Base.compatibility.CompatBase;
import minechemV6Base.utils.ModList;

public class ComputerCraftCompat extends CompatBase {

    public ComputerCraftCompat(ModList modlist) {
        super(modlist);
    }

    @Override
    public void init()
    {
        PeripheralProvider.register();
    }
}
