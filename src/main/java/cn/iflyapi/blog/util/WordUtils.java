package cn.iflyapi.blog.util;

import org.apdplat.word.WordFrequencyStatistics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author qfwang
 * @date 2018-12-25 6:50 PM
 */
public class WordUtils {

    private static String TMP = System.getProperty("java.io.tmpdir");

    //词频统计设置
    private static WordFrequencyStatistics wordFrequencyStatistics = new WordFrequencyStatistics();

    public static List<String> wordCount(Long userId, String tags) {
        String countFile = TMP + userId + "-word-count.txt";
        System.out.println(countFile);

        wordFrequencyStatistics.setRemoveStopWord(false);
        wordFrequencyStatistics.setResultPath(countFile);
        //开始分词
        wordFrequencyStatistics.seg(tags);
        //输出词频统计结果
        wordFrequencyStatistics.dump();
        List<String> wrs = new ArrayList<>();
        try {
            File file = new File(countFile);
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s1;
            int count = 0;
            while ((s1 = br.readLine()) != null) {
                count++;
                if (count <= 3) {
                    wrs.add(s1.split(" ")[0]);
                }
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wrs;
    }

    public static void main(String[] args) {
        System.out.println(wordCount(12312L, "赤是化,好是吃,你说是呢,哈s哈,spring,mvc,aop,最终,你说"));
        System.out.println(wordCount(122343212L, "赤化,好吃,你说呢,哈哈,spring,mvc,aop,最终,你说"));
    }
}
