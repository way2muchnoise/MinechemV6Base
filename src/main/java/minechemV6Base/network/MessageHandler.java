package minechemV6Base.network;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import minechemV6Base.reference.Reference;

public class MessageHandler implements IMessageHandler
{
    public static SimpleNetworkWrapper INSTANCE = new SimpleNetworkWrapper(Reference.ID);
    private static int id = 0;

    public static void init()
    {
        //INSTANCE.registerMessage(messageClass, HandlerClass, id++, Side that will handel the message);
    }

    @Override
    public IMessage onMessage(IMessage message, MessageContext ctx)
    {
        return null;
    }
}
