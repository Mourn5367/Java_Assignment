public enum Choice {
    YES(1),
    NO(2),
    ERROR(-1);

    private final int choiceNum;

    Choice(int choiceNum) {
        this.choiceNum = choiceNum;
    }

    public int getChoiceNum() {
        return choiceNum;
    }

    public static Choice fromInt(int choiceNum) {
        for (Choice choice : Choice.values()) {
            if (choice.getChoiceNum() == choiceNum) {
                return choice;
            }
        }
        return ERROR; // 또는 원하는 기본 값을 반환
    }
}