package ru.clubbreakfast.at_the_lecture.sept25.war_and_peace;

import java.util.Date;
import java.util.regex.Pattern;

public class MyConsumer implements Runnable{
    private volatile int count1=0;
    private volatile int count2=0;
    private Pattern pat = Pattern.compile("страдание");
    static boolean isStopped=false;


    @Override
    public void run() {
        long time = new Date().getTime();
        while (!isStopped|Solution.que.size()!=0) {
            String line = Solution.que.poll();
            try {
                parseLine(line);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        long newTime = new Date().getTime();
        System.out.printf("На работу потока Consumer ушло %d милисекунд\n", newTime-time);
        System.out.printf("cтрадание, как часть слова, встречается %d раз\n", count1);
        System.out.printf("страдание, как отдельное слово, встречается %d раз", count2);
    }

    private void parseLine(String str) throws InterruptedException {
        if (str==null){
            Thread.sleep(10);
        }else{
            String[] arrString = str.split("[^А-я\\-]");
            for(String s : arrString){
                if (pat.matcher(s).find())++count1;
                if (s.matches("страдание"))count2++;
            }
        }
    }
}
