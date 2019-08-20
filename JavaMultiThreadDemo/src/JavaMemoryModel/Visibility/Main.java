package JavaMemoryModel.Visibility;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Johnny Zhang
 * @Date: 2018/12/3 20:44
 */
public class Main {
    public static void main(String[] args) {
        LaneInfo laneInfo0 = new LaneInfo(LaneInfo.LanePattern.Continue, LaneInfo.HighlightedLane.Continue);
        List<LaneInfo> oldList = new ArrayList<>();
        oldList.add(laneInfo0);
        List<LaneInfo> newList = new ArrayList<>();
        for (LaneInfo laneInfo : oldList) {
            newList.add(new LaneInfo(laneInfo));
        }
        oldList.get(0).lanePattern = LaneInfo.LanePattern.Left;
        System.out.println("old list item:" + oldList.get(0).lanePattern);
        System.out.println("new list item:" + newList.get(0).lanePattern);
    }

//    private static class Runner extends Thread {
//        private boolean quit = false;
//        @Override
//        public void run() {
//            while(!quit) {
//                System.out.println("while.....");
//            }
//            System.out.println("Done");
//        }
//
//        public void shutdown() {
//            System.out.println("shutdown");
//            quit = true;
//        }
//    }
}
