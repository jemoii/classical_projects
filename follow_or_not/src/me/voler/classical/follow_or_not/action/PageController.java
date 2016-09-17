package me.voler.classical.follow_or_not.action;

import me.voler.classical.follow_or_not.mood.Mood;

import java.util.ArrayList;

public class PageController {
    final static int FOLLOW_OPERATION = 1;
    final static int CANCEL_OPERATION = 0;
    private static ArrayList<String> log;

    public static ArrayList<Mood> homePage() {
        ArrayList<Mood> list = new ArrayList<Mood>();
        list.add(new Mood("m150521245", "",
                "This is a mood in English, just for testing."));
        list.add(new Mood("m150521036", "中文心情", "这是一个中文心情，用来测试编码问题。"));
        list.add(new Mood("m150520506", "#Nice day#", "今天添加了一个新的功能模块。"));

        return list;
    }

    public static void operationTip(int operation, String mid, String uid) {
        if (log == null)
            log = new ArrayList<String>();

        switch (operation) {
            case FOLLOW_OPERATION:
                log.add("</br>" + "用户" + uid + "关注了心情" + mid);
                break;
            case CANCEL_OPERATION:
                log.add("</br>" + "用户" + uid + "取消关注心情" + mid);
                break;
        }
    }

    public static ArrayList<String> showLog() {
        return log;
    }
}
