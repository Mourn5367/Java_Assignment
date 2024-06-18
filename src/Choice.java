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

    // 번호의 마지막은 탈출하려는 부정의 선택지이며 그 전까지는 긍정의 다른 선택지이다.
    // 긍정의 선택지 가짓수를 limitYesNum 파라미터에 넣고 사용자가 입력받은 숫자를 choiceNum에 넣는다.
    // 긍정의 선택 가짓수 보다 1 높은 숫자는 부정의 선택 탈출을 의미하여 첫 if문에서 검사 후 반복문을 진행한다.
    // 첫 조건문, 반복문에도 걸리지않는다면 그 외의 숫자를 입력한 것으로 ERROR를 반환하게 된다.
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