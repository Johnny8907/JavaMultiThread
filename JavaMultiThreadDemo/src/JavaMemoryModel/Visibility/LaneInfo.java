package JavaMemoryModel.Visibility;

public class LaneInfo {
    public static enum LanePattern {
        None(1), Continue(2), ContinueAndLeft(3), ContinueAndRight(4), Left(5), Right(6), LeftUTurn(7),
        RightUTurn(8), LeftAndRight(9), LeftAndLeftUTurn(10), RightAndRightUTurn(11), ContinueAndLeftAndUTurn(12), ContinueAndLeftAndRight(13);

        private int value = -1;

        private LanePattern(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }

        public static LanePattern valueOf(int value) {
            for (LanePattern lanePattern : LanePattern.values()) {
                if (lanePattern.value == value) {
                    return lanePattern;
                }
            }

            return null;
        }
    }

    public static enum LaneAttribute {
        LANE_ATTRIBUTE_NORMAL(0), LANE_ATTRIBUTE_BUS(1), LANE_ATTRIBUTE_HIPASS(2);

        private int value = -1;

        public int value() {
            return this.value;
        }

        private LaneAttribute(int value) {
            this.value = value;
        }

        public static LaneAttribute valueOf(int value) {
            for (LaneAttribute laneAttribute : LaneAttribute.values()) {
                if(laneAttribute.value == value) {
                    return laneAttribute;
                }
            }
            return null;
        }
    }


    public static enum HighlightedLane {
        None(1), Continue(2), Left(3), Right(4), LeftUTurn(5),
        RightUTurn(6);

        private int value = -1;

        private HighlightedLane(int value) {
            this.value = value;
        }

        public int value() {
            return this.value;
        }

        public static HighlightedLane valueOf(int value) {
            for (HighlightedLane highlightedLane : HighlightedLane.values()) {
                if (highlightedLane.value == value) {
                    return highlightedLane;
                }
            }

            return null;
        }
    }
    public LanePattern lanePattern = LanePattern.None;
    public HighlightedLane highlightedLane = HighlightedLane.None;

    public LaneInfo(LanePattern lanePattern, HighlightedLane highlightedLane) {
        this.lanePattern = lanePattern;
        this.highlightedLane = highlightedLane;
    }

    public LaneInfo(LaneInfo laneInfo) {
        this.lanePattern = laneInfo.lanePattern;
        this.highlightedLane = laneInfo.highlightedLane;
    }
}
