package minechemV6Base.chemical.properties;

import minechemV6Base.utils.Constants;

public enum RadioactivityEnum
{
    stable("Stable", -1, 0),
    hardlyRadioactive("Hardly Radioactive", Constants.TICKS_PER_DAY, 1),
    slightlyRadioactive("Slightly Radioactive", Constants.TICKS_PER_HOUR * 12, 2),
    radioactive("Radioactive", Constants.TICKS_PER_HOUR * 6, 6),
    highlyRadioactive("Highly Radioactive", Constants.TICKS_PER_HOUR, 8),
    extremelyRadioactive("Extremely Radioactive", 0, 16),
    invalid("Invalid", 0, 0);

    public static final RadioactivityEnum[] RADIOACTIVE = {hardlyRadioactive, slightlyRadioactive, radioactive,
            highlyRadioactive, extremelyRadioactive};

    private String name;
    private long halfLife;
    private int damage;

    RadioactivityEnum(String name, long halfLife, int damage)
    {
        this.name = name;
        this.halfLife = halfLife;
        this.damage = damage;
    }

    public static RadioactivityEnum getRadioactivity(int halfLife)
    {
        if (halfLife == -1) return stable;
        for (RadioactivityEnum value : RADIOACTIVE)
        {
            if (!(halfLife < value.getHalfLife())) return value;
        }
        return invalid;
    }

    public long getHalfLife()
    {
        return halfLife;
    }

    public int getDamage(){ return damage;}
}
