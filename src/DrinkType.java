public enum DrinkType
{
    WATER( "Water",700, 500),
    COLA("Cola", 1000, 355 ),
    CIDER("Cider", 1500, 500 ),;

    private final String name;
    private final int price;
    private final int size;

    DrinkType(String name, int price, int size)
    {
        this.name = name;
        this.price = price;
        this.size = size;
    }

    public String GetName()
    {
        return name;
    }
    public int GetPrice()
    {
        return price;
    }
    public int GetSize()
    {
        return size;
    }
}
