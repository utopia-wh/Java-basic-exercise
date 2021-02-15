package part2;

/**
 * @Author wanghu
 * @Description：
 * @Date 2021/2/15 11:12
 */
public class StringPractice {

    /**
     * 回答
     *
     * @param question
     * @return
     */
    public String answer(String question) {
        String ret = null;
        ret = handleCanStart(question);

        if (ret != null) {
            return ret;
        }

        ret = handleAskTail(question);

        if (ret != null) {
            return ret;
        }

        return handleUnKnown(question);
    }


    /**
     * 在这个方法中处理开头
     *
     * @param question
     * @return
     */
    private String handleCanStart(String question) {
        String[] canStart = new String[]{"会", "能", "有", "敢", "在"};
        for (int i = 0; i < canStart.length; i++) {
            if (question.startsWith(canStart[i])) {
                return canStart[i] + "!";
            }
        }
        return null;

    }

    /**
     * 在这个方法中处理结尾
     *
     * @param question
     * @return
     */
    private String handleAskTail(String question) {
        String[] askTail = new String[]{"吗？", "吗?", "吗"};
        for (int i = 0; i < askTail.length; i++) {
            if (question.endsWith(askTail[i])) {
                return question.replace(askTail[i], "!");
            }
        }
        return null;
    }


    /**
     * 如果处理不了回答的处理办法
     *
     * @param question
     * @return
     */
    private String handleUnKnown(String question) {
        return question + "!";
    }

}
