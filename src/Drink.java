public class Drink
{
    private final DrinkType type;
    private int stock;
    public Drink(DrinkType type, int stock)
    {
        this.type = type;
        this.stock = stock;
    }

    public int GetPrice()
    {
        return this.type.GetPrice();
    }
    public int GetStock()
    {
        return this.stock;
    }
    public DrinkType GetType()
    {
        return this.type;
    }
    public String GetName()
    {
        return this.type.GetName();
    }
    public int GetSize()
    {
        return this.type.GetSize();
    }
    public void SellDrink(int number)
    {
        stock -= number;
    }
    public void StockPlus(int number)
    {
        stock += number;
    }
    public void SetStock(int number)
    {
        stock = number;
    }
}
