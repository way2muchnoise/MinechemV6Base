package minechemV6Base.utils;


import io.netty.buffer.ByteBuf;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.*;

public class MessageHelper
{
    public static void writeItemStack(ByteBuf buf, ItemStack itemStack)
    {
        buf.writeInt(Item.getIdFromItem(itemStack.getItem()));
        buf.writeInt(itemStack.stackSize);
        buf.writeInt(itemStack.getItemDamage());

        buf.writeBoolean(itemStack.hasTagCompound());
        if (itemStack.hasTagCompound())
        {
            writeNBTTagCompound(buf, itemStack.getTagCompound());
        }
    }

    public static void writeNBTTagCompound(ByteBuf buf, NBTTagCompound tagCompound)
    {
        buf.writeInt(tagCompound.func_150296_c().size()); // count of tags
        for (Object o : tagCompound.func_150296_c())
        {
            String tagName = String.valueOf(o);
            writeNBTTag(buf, tagCompound.getTag(tagName));
        }
    }

    public static void writeNBTTag(ByteBuf buf, NBTBase tag)
    {
        buf.writeByte(tag.getId());
        switch (tag.getId())
        {
            case 1:
                buf.writeByte(((NBTTagByte)tag).func_150290_f());
                break;
            case 2:
                buf.writeShort(((NBTTagShort)tag).func_150289_e());
                break;
            case 3:
                buf.writeInt(((NBTTagInt) tag).func_150287_d());
                break;
            case 4:
                buf.writeLong(((NBTTagLong) tag).func_150291_c());
                break;
            case 5:
                buf.writeFloat(((NBTTagFloat) tag).func_150288_h());
                break;
            case 6:
                buf.writeDouble(((NBTTagDouble) tag).func_150286_g());
                break;
            case 7:
                buf.writeBytes(((NBTTagByteArray) tag).func_150292_c());
                break;
            case 8:
                writeString(buf, ((NBTTagString)tag).func_150285_a_());
                break;
            case 9:
                writeNBTTagList(buf, (NBTTagList)tag);
            case 10:
                writeNBTTagCompound(buf, (NBTTagCompound)tag);
            case 11:
                writeIntArray(buf, ((NBTTagIntArray)tag).func_150302_c());
                break;
            default:
                break;
        }
    }

    public static void writeNBTTagList(ByteBuf buf, NBTTagList tagList)
    {
        for (int i = 0; i < tagList.tagCount(); i++)
        {
            switch (tagList.func_150303_d())
            {
                case 5:
                    buf.writeFloat(tagList.func_150308_e(i));
                    break;
                case 6:
                    buf.writeDouble(tagList.func_150309_d(i));
                    break;
                case 8:
                    writeString(buf, tagList.getStringTagAt(i));
                    break;
                case 10:
                    writeNBTTagCompound(buf, tagList.getCompoundTagAt(i));
                case 11:
                    writeIntArray(buf, tagList.func_150306_c(i));
                default:
                    break;
            }
        }
    }

    public static void writeString(ByteBuf buf, String string)
    {
        buf.writeInt(string.length());
        buf.writeBytes(string.getBytes());
    }

    public static void writeIntArray(ByteBuf buf, int[] array)
    {
        buf.writeInt(array.length);
        for (int i : array)
            buf.writeInt(i);
    }
}
