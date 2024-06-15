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
                    showDrinkList = user.SuggestShowDrinkList();
                    choice = Choice.fromInt(showDrinkList);
                    switch(choice)
                    {
                        case YES:
                            currentState = VMState.SHOWDRINK;
                            break;
                        case NO:
                            currentState = VMState.PURCHASEDONE;
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
                    choice = Choice.fromInt(user.SustainPurchase());
                    switch(choice)
                    {
                        case YES:
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
