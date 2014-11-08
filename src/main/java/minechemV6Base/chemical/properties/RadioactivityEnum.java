package minechemV6Base.chemical.properties;

import minechemV6Base.utils.Constants;

public enum RadioactivityEnum
{
    stable("Stable", Long.MAX_VALUE, 0),
    hardlyRadioactive("Hardly Radioactive", Constants.TICKS_PER_DAY, 1),
    slightlyRadioactive("Slightly Radioactive", Constants.TICKS_PER_HOUR * 12, 2),
    radioactive("Radioactive", Constants.TICKS_PER_HOUR * 6, 6),
    highlyRadioactive("Highly Radioactive", Constants.TICKS_PER_HOUR, 8),
    extremelyRadioactive("Extremely Radioactive", 0, 16),
    invalid("Invalid", 0, 0);

    public static final RadioactivityEnum[] VALID_RADIATION = {stable, hardlyRadioactive, slightlyRadioactive, radioactive,
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
        for (RadioactivityEnum value : VALID_RADIATION)
        {
            if (!(halfLife < value.getHalfLife())) return value;
        }
        return invalid;
    }

    public long getHalfLife()
    {
        return halfLife;
    }
}
