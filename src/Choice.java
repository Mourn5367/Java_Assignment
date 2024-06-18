public enum Choice {
    YES_1(1),
    YES_2(2),
    YES_3(3),
    NO(4),
    ERROR(-1);

    private final int choiceNum;

    Choice(int choiceNum) {
        this.choiceNum = choiceNum;
    }

    public int getChoiceNum() {
        return choiceNum;
    }

    public static Choice fromInt(int choiceNum,int limitYesNum)
    {
        int count = 0;
        if(choiceNum == limitYesNum+1)
        {
            return NO;
        }
        for (Choice choice : Choice.values())
        {
            if (count == limitYesNum)
            {
                break;
            }
            if (choice.getChoiceNum() == choiceNum) {
                return choice;
            }
            count++;
        }
        return ERROR;
    }
}