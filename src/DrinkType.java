public enum DrinkType
{
    WATER( 0,"Water",700, 500),
    COLA(1,"Cola", 1000, 355 ),
    CIDER(2,"Cider", 1500, 500 ),;

    private int num;
    private String name;
    private int price;
    private int size;

    DrinkType(int num, String name, int price, int size)
    {
        this.num = num;
        this.name = name;
        this.price = price;
        this.size = size;
    }

    public int GetNum()
    {
        return num;
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
