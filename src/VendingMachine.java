import java.util.ArrayList;
import java.util.List;

public class VendingMachine
{
    List<Drink> drinks;
    public VendingMachine()
    {
        drinks = new ArrayList<>();
        drinks.add(new Drink(DrinkType.WATER,3));
        drinks.add(new Drink(DrinkType.COLA,3));
        drinks.add(new Drink(DrinkType.CIDER,3));
    }
    public int GetMinPrice()
    {
        int minPrice = drinks.get(0).GetPrice();
        for(Drink d : drinks)
        {
            if ( d.GetPrice() < minPrice)
            {
                minPrice = d.GetPrice();
            }
        }
        return minPrice;
    }
    public void ShowMenu()
    {
        for (int i = 0 ; i < drinks.size(); i++)
        {
            System.out.printf("%d.\t%s\t%dml\t%d원\t현재 재고 %d\n",i+1,
                    drinks.get(i).GetName(),drinks.get(i).GetSize(), drinks.get(i).GetPrice(),drinks.get(i).GetStock());
        }
        System.out.println("4. \t구입 종료.");
    }

    public int SelectDrinkPrint(int selectMenu)
    {
        if (selectMenu == -1)
        {
            return -1;
        }
        DrinkType drinkType = drinks.get(selectMenu-1).GetType();

        switch (drinkType)
        {
            case WATER: // 1
                System.out.print("Water ");
                break;
            case COLA:
                System.out.print("Cola ");
                break;
            case CIDER:
                System.out.print("Cider ");
                break;
        }
        System.out.println("제품을 선택하였습니다.");
       return selectMenu-1;
    }
    public Drink DrinkCondition(int selectMenu, int wallet)
    {
        if (selectMenu == -1)
        {
            return null;
        }
        Drink drink = drinks.get(selectMenu);

        if((wallet>=drink.GetPrice()) & drink.GetStock() > 0)
        {
            drink.SellDrink(1);
            System.out.printf("%s를 구입하였습니다.\n",drink.GetName());
            return drink;
        }
        else if (wallet>=drink.GetPrice())
        {
            System.out.printf("%s의 재고가 부족하다\n",drink.GetName());
            return null;
        }
        else if (drink.GetStock() > 0)
        {
            System.out.println("잔액이 부족하다.");
            return null;
        }
        else
        {
            System.out.printf("%s을(를) 사기에는 재고와 잔액이 부족하다.\n",drink.GetName());
            return null;
        }
    }
    public void AlertMenuSize()
    {
        System.out.printf("1 ~ %d 까지 입력해 주세요\n",drinks.size()+1);
    }
    public void ExactChoose()
    {
        System.out.println("알맞은 입력을 해주세요");
    }
    public int GetDrinkListSize()
    {
        return drinks.size();
    }
    public boolean CheckStock()
    {
        for(Drink d : drinks)
        {
            if (d.GetStock()> 0)
            {
                return true;
            }
        }
        return false;
    }
}
