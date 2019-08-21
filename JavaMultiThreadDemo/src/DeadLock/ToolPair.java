package DeadLock;

public class ToolPair {
    private final Tool leftHand;
    private final Tool rightHand;
    public ToolPair(Tool leftHand, Tool rightHand) {
        this.leftHand = leftHand;
        this.rightHand = rightHand;
    }

    @Override
    public String toString() {
        return "[ " + leftHand + " and " + rightHand + " ]";
    }
}
