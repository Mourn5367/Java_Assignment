public class Main
{
    public static void main(String[] args)
    {
        VendingMachine vm = new VendingMachine();
        User user = new User();
        int userSelectMenuNum = 0;
        int inputVMNum = 0;
        int showDrinkList = 0;

        Drink chooseDrink;
        Choice choice;
        VMState currentState = VMState.START;
        while(currentState != VMState.DONE)
        {
            switch(currentState)
            {
                case START:
                    System.out.println("자판기 가동");
                case SHOWMENU:
                    if (!vm.CheckStock())
                    {
                        currentState = VMState.RESULT;
                        System.out.println("재고가 없어 구입이 종료됩니다.");
                        continue;
                    }
                    user.ShowWallet();
                    vm.ShowMenu();
                    currentState = VMState.SELECTMENUUSER;
                    break;
                case SELECTMENUUSER:
                    userSelectMenuNum = user.SelectDrink(vm);
                    if (vm.GetDrinkListSize()+1 == userSelectMenuNum)
                    {
                        currentState = VMState.RESULT;
                        continue;
                    }
                    currentState = VMState.INPUTNUMBERVMMACHINE;
                    break;
                case INPUTNUMBERVMMACHINE:
                    inputVMNum = vm.SelectDrinkPrint(userSelectMenuNum);
                    currentState = VMState.PURCHASE;
                    break;
                case PURCHASE:
                    chooseDrink = vm.DrinkCondition(inputVMNum, user.GetWallet());
                    user.PlusDrink(chooseDrink);
                    if (chooseDrink == null)
                    {
                        if (user.GetWallet() < vm.GetMinPrice())
                        {
                            currentState = VMState.RESULT;
                            continue;
                        }
                        currentState = VMState.SELECTMENUUSER;
                        continue;
                    }
                    user.SetWallet(chooseDrink.GetPrice());
                    currentState = VMState.SELECTSHOWDRINKLIST;
                    break;
                case SELECTSHOWDRINKLIST:
                    // 숫자 이외의 입력은 user.SuggestShowDrinkList() 여기서 검사함.
                    showDrinkList = user.SuggestShowDrinkList();
                    choice = Choice.fromInt(showDrinkList,2);
                    switch(choice)
                    {
                        case YES_1:
                            currentState = VMState.SHOWDRINK;
                            break;
                        case YES_2:
                            currentState = VMState.SHOWMENU;
                            break;
                        case NO:
                            currentState = VMState.RESULT;
                            break;
                        case ERROR:
                            vm.ExactChoose();
                            break;
                    }
                    break;
                case SHOWDRINK:
                    user.ShowDrink();
                    currentState = VMState.PURCHASEDONE;
                break;
                case PURCHASEDONE:
                    // 숫자 이외의 입력은 user.SustainPurchase() 여기서 검사함.
                    choice = Choice.fromInt(user.SustainPurchase(),1);
                    switch(choice)
                    {
                        case YES_1:
                            currentState = VMState.SHOWMENU;
                            break;
                        case NO:
                            currentState = VMState.RESULT;
                            break;
                        case ERROR:
                            vm.ExactChoose();
                            break;
                    }
                    break;
                case RESULT:
                    System.out.println("구입 종료");
                    user.ShowResult();
                    currentState = VMState.DONE;
                    break;
            }
        }
    }
}
