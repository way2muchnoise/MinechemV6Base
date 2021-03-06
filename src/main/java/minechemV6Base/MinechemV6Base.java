package minechemV6Base;


import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.ModMetadata;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import minechemV6Base.proxy.CommonProxy;
import minechemV6Base.reference.MetaData;
import minechemV6Base.reference.Reference;
import minechemV6Base.utils.LogHelper;
import minechemV6Base.utils.StringParser;

@Mod(modid = Reference.ID, name = Reference.NAME, version = Reference.VERSION_FULL, acceptedMinecraftVersions = "[1.7.10,)", dependencies = "required-after:Forge@[10.13.0.1180,)")
public class MinechemV6Base
{
    // Instancing
    @Mod.Instance(value = Reference.ID)
    public static MinechemV6Base INSTANCE;

    // Public extra data about our mod that Forge uses in the mods listing page for more information.
    @Mod.Metadata(Reference.ID)
    public static ModMetadata metadata;

    @SidedProxy(clientSide = "minechemV6Base.proxy.ClientProxy", serverSide = "minechemV6Base.proxy.CommonProxy")
    public static CommonProxy PROXY;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        INSTANCE = this;

        LogHelper.info("Setting up metaData...");
        metadata = MetaData.init(metadata);
        //StringParser.getValenceShell(8);
        StringParser.getValenceShell(150);
        StringParser.getValenceShell(160);
        StringParser.getValenceShell(170);

    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {

    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
