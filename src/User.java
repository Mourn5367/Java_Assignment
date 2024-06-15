import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
//import java.util.Comparator;

public class User
{
    private int wallet;
    List<Drink> drinkList;
    Scanner sc;
    private Drink drink;

    public User()
    {
        sc = new Scanner(System.in);
        wallet = 3000;
        drinkList = new ArrayList<>();
    }
    public int GetWallet()
    {
        return wallet;
    }
    public void ShowWallet()
    {
        System.out.printf("잔액: %d원\n",GetWallet());
    }
    public void SetWallet(int price)
    {
        wallet -= price;
    }
    public void PlusDrink(Drink drink)
    {
        if (drink == null)
        {
            return;
        }
        boolean first = true;
        for (Drink d : drinkList)
        {
            if (d.GetType() == drink.GetType())
            {
                first = false;
                d.StockPlus(1);
            }
        }
        if(drinkList.isEmpty() || first)
        {
            this.drink = new Drink(drink.GetType(), 1);
            drinkList.add(this.drink);
        }
//        if(drinkList.contains(drink))
//        {
//            int drinkIndex = drinkList.indexOf(drink);
//            drinkList.get(drinkIndex).StockPlus(1);
//        }
//        else
//        {
//            drinkList.add(drink);
//            int drinkIndex = drinkList.indexOf(drink);
//            drinkList.get(drinkIndex).SetStock
//                    (drinkList.get(drinkIndex).GetStock()
//                            -(drinkList.get(drinkIndex).GetStock()-1));
//        }

    }
    public int SelectDrink(VendingMachine vm)
    {
        int selectMenu = -1;
        
        try
        {
            vm.AlertMenuSize();
            selectMenu = sc.nextInt();
        }
        catch(Exception e)
        {
            sc.nextLine();
        }
        if (selectMenu > vm.drinks.size()+1 || selectMenu < 1)
        {
            vm.ExactChoose();
            return -1;
        }
        else
        {
            return selectMenu;
        }
    }
    public int SuggestShowDrinkList()
    {

        int selectChoice = 0;
            try
            {
                System.out.println("1. 장바구니 보기\t2. 계속 진행");
                selectChoice = sc.nextInt();
            }
            catch(Exception e)
            {
                sc.nextLine();
//                System.out.println("잘못된 입력을 하였습니다.");
            }
        return selectChoice;
    }
    public int SustainPurchase()
    {

        int selectChoice = 0;
            try
            {
                System.out.println("1. 계속 구입\t2. 그만 두기");
                selectChoice = sc.nextInt();
            }
            catch(Exception e)
            {
                sc.nextLine();
//                System.out.println("잘못된 입력을 하였습니다.");
            }
        return selectChoice;
    }
    public void ShowDrink()
    {

        if (!drinkList.isEmpty())
        {
            for(Drink drink : drinkList)
            {
                System.out.printf("%s %d개\t", drink.GetName(), drink.GetStock());
            }
            System.out.println();
        }
        else
        {
            System.out.println("아무것도 사지않았습니다.");
        }
    }
    public void ShowResult()
    {
        int resultPrice =0;
        for(Drink drink : drinkList)
        {
            System.out.printf("%s %d개 %d원\t", drink.GetName(),drink.GetStock(), drink.GetStock()*drink.GetPrice());
            resultPrice+=drink.GetPrice()*drink.GetStock();
        }
        System.out.println();
        System.out.printf("총 %d원", resultPrice);
    }

//    public void ShowDrink()
//    {
//
//        if (!drinkList.isEmpty())
//        {
////            drinkList.sort(Comparator.comparing(Drink::GetName));
////            for(int i = 0 ; i < DrinkType.values().length ; i++)
////            {
////                int count = 0;
////                for(int j = 0 ; j < drinkList.size(); j++)
////                {
////                    if (DrinkType.values()[i].GetName().equals( drinkList.get(i).GetName()))
////                    {
////                        count++;
////                    }
////                    System.out.printf("%d.\t %s\t%d개",i+1,drinkList.get(i).GetName(),count);
////                }
////
////                System.out.println();
////            }
////                for (int i = 0 ; i < length ; i++)
////                {
////
////                }
//
//        }
//    }
}
