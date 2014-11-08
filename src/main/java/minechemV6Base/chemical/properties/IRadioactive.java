package minechemV6Base.chemical.properties;

public interface IRadioactive
{
    public long getHalfLife();

    public RadioactivityEnum getRadioactivity();

    public int getDamage();
}
