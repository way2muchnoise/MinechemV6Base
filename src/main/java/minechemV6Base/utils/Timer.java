package minechemV6Base.utils;

import net.minecraft.nbt.NBTTagCompound;

public class Timer
{
    private int reset;
    private int counter = 0;

    public Timer(int reset)
    {
        this.reset = reset;
    }

    private Timer(int reset, int count)
    {
        this.reset = reset;
        this.counter = count;
    }

    public boolean update()
    {
        if (counter++ == reset)
        {
            counter = 0;
            return true;
        }
        return false;
    }

    public NBTTagCompound timerToNBT()
    {
        NBTTagCompound result = new NBTTagCompound();
        result.setInteger("count",counter);
        result.setInteger("reset",reset);
        return result;
    }

    public static Timer nbtToTimer(NBTTagCompound compound)
    {
        if (compound.hasKey("count") && compound.hasKey("reset")) return new Timer(compound.getInteger("count"),compound.getInteger("reset"));
        return null;
    }

}
