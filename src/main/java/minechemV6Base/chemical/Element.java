package minechemV6Base.chemical;

import java.util.LinkedHashMap;
import java.util.Map;

public class Element extends ChemicalBase
{
    private String symbol;

    public Element(String name, String symbol)
    {
        super(name);
        this.symbol = symbol;
    }

    public Element(String name, int temp, String symbol)
    {
        super(name, temp);
        this.symbol = symbol;
    }

    public Element(String name, int temp, int meltingPoint, int boilingPoint, String symbol)
    {
        super(name, temp, meltingPoint, boilingPoint);
        this.symbol = symbol;
    }

    public Element(String name, int temp, int meltingPoint, int boilingPoint, Long halfLife, String symbol)
    {
        super(name, temp, meltingPoint, boilingPoint, halfLife);
        this.symbol = symbol;
    }

    @Override
    public String getFormula()
    {
        return symbol;
    }

    /**
     * Creates an Entry to us in constructing a {@link Molecule}
     *
     * @param element
     * @param amount
     * @return
     */
    public static Map.Entry<Element, Integer> create(Element element, int amount)
    {
        return new LinkedHashMap.SimpleEntry<Element, Integer>(element, amount);
    }

    @Override
    public boolean isElement()
    {
        return true;
    }
}
