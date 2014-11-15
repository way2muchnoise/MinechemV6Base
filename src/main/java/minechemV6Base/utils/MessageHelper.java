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

    public static ItemStack readItemStack(ByteBuf buf)
    {
        Item item = Item.getItemById(buf.readInt());
        int stackSize = buf.readInt();
        int damage = buf.readInt();

        ItemStack itemStack = new ItemStack(item, stackSize, damage);

        if (buf.readBoolean())
        {
            itemStack.stackTagCompound = readNBTTagCompound(buf);
        }

        return itemStack;
    }

    public static void writeNBTTagCompound(ByteBuf buf, NBTTagCompound tagCompound)
    {
        buf.writeInt(tagCompound.func_150296_c().size()); // count of tags
        for (Object o : tagCompound.func_150296_c())
        {
            String tagName = String.valueOf(o);
            writeString(buf, tagName);
            writeNBTTag(buf, tagCompound.getTag(tagName));
        }
    }

    public static NBTTagCompound readNBTTagCompound(ByteBuf buf)
    {
        int count = buf.readInt(); // count of tags
        NBTTagCompound tagCompound = new NBTTagCompound();
        for (int i = 0; i < count; i++)
        {
            String tagName = readString(buf);
            tagCompound.setTag(tagName, readNBTTag(buf));
        }
        return tagCompound;
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
                buf.writeInt(((NBTTagByteArray) tag).func_150292_c().length);
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
                writeIntArray(buf, ((NBTTagIntArray) tag).func_150302_c());
                break;
            default:
                break;
        }
    }

    public static NBTBase readNBTTag(ByteBuf buf)
    {
        switch (buf.readByte())
        {
            case 1:
                return new NBTTagByte(buf.readByte());
            case 2:
                return new NBTTagShort(buf.readShort());
            case 3:
                return new NBTTagInt(buf.readInt());
            case 4:
                return new NBTTagLong(buf.readLong());
            case 5:
                return new NBTTagFloat(buf.readFloat());
            case 6:
                return new NBTTagDouble(buf.readFloat());
            case 7:
                int length = buf.readInt();
                return new NBTTagByteArray(buf.readBytes(length).array());
            case 8:
                return new NBTTagString(readString(buf));
            case 9:
                return readNBTTagList(buf);
            case 10:
                return readNBTTagCompound(buf);
            case 11:
                return new NBTTagIntArray(readIntArray(buf));
            default:
                return null;
        }
    }

    public static void writeNBTTagList(ByteBuf buf, NBTTagList tagList)
    {
        buf.writeInt(tagList.tagCount());
        for (int i = 0; i < tagList.tagCount(); i++)
        {
            buf.writeInt(tagList.func_150303_d());
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
                    break;
                case 11:
                    writeIntArray(buf, tagList.func_150306_c(i));
                    break;
                default:
                    break;
            }
        }
    }

    public static NBTTagList readNBTTagList(ByteBuf buf)
    {
        int count = buf.readInt();
        NBTTagList list = new NBTTagList();
        for (int i = 0; i < count; i++)
        {
            int type = buf.readInt();
            switch (type)
            {
                case 5:
                    list.appendTag(new NBTTagFloat(buf.readFloat()));
                    break;
                case 6:
                    list.appendTag(new NBTTagDouble(buf.readDouble()));
                    break;
                case 8:
                    list.appendTag(new NBTTagString(readString(buf)));
                    break;
                case 10:
                    list.appendTag(readNBTTagCompound(buf));
                    break;
                case 11:
                    list.appendTag(new NBTTagIntArray(readIntArray(buf)));
                    break;
                default:
                    break;
            }
        }
        return list;
    }

    public static void writeString(ByteBuf buf, String string)
    {
        buf.writeInt(string.length());
        buf.writeBytes(string.getBytes());
    }

    public static String readString(ByteBuf buf)
    {
        int length = buf.readInt();
        return new String(buf.readBytes(length).array());
    }

    public static void writeIntArray(ByteBuf buf, int[] array)
    {
        buf.writeInt(array.length);
        for (int i : array)
            buf.writeInt(i);
    }

    public static int[] readIntArray(ByteBuf buf)
    {
        int length = buf.readInt();
        int[] array = new int[length];
        for (int i = 0; i < length; i++)
            array[i] = buf.readInt();
        return array;
    }
}
