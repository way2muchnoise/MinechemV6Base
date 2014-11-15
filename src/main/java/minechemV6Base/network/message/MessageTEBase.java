package minechemV6Base.network.message;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import io.netty.buffer.ByteBuf;
import net.minecraft.tileentity.TileEntity;

public class MessageTEBase implements IMessage
{
    private int posX, posY, posZ;

    public MessageTEBase()
    {

    }

    public MessageTEBase(TileEntity tile)
    {
        this.posX = tile.xCoord;
        this.posY = tile.yCoord;
        this.posZ = tile.zCoord;
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.posX = buf.readInt();
        this.posY = buf.readInt();
        this.posZ = buf.readInt();
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(this.posX);
        buf.writeInt(this.posY);
        buf.writeInt(this.posZ);
    }
}
