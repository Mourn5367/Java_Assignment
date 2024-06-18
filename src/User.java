import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class User
{
    private int wallet;
    List<Drink> drinkList;
    Scanner sc;

    public User()
    {
        sc = new Scanner(System.in);
        wallet = 10000;
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

    // 잘못된 입력을 하여 음료수에서 나온 drink 객체가 NULL이 아닌 경우 함수가 진행.
    // 사용자 User가 가지고 있는 drinkList중에 자판기에서 건네받은 drinkType과 지금
    // 소유하고있는 음료수 중의 drinkType이 일치하다면 처음 사지 않았다는 first 지역변수 값을
    // false로 변경하고 가지고 있는 drink객체의 stock 속성을 1 올려주는 StockPlus 함수를 실행한다.
    // 만약 drinkList가 비었고 first 값이 true일때는 drinkList에 새로 추가한다.
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
            drink = new Drink(drink.GetType(), 1);
            drinkList.add(drink);
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
        int selectMenu = 0;

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
            //이 값이 VendingMachine의 SelectDrinkPrint 함수로 넘어간다.
            // -1 이면 drink객체를 NULL을 반환하기로 함
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
                System.out.println("1. 장바구니 보기\t2. 계속 구입\t3. 구입 종료");
                selectChoice = sc.nextInt();
            }
            catch(Exception e)
            {
                sc.nextLine();
            }
        return selectChoice;
    }
    public int SustainPurchase()
    {

        int selectChoice = 0;
            try
            {
                System.out.println("1. 계속 구입\t2. 구입 종료");
                selectChoice = sc.nextInt();
            }
            catch(Exception e)
            {
                sc.nextLine();
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
