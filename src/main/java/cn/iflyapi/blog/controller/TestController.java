package cn.iflyapi.blog.controller;

import org.apdplat.word.WordFrequencyStatistics;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author flyhero
 * @date 2018-12-22 3:24 PM
 */
@RestController
public class TestController {

    public static void main(String[] args) {
        List<Word> words = WordSegmenter.seg("不得不知的Spring设计模式");
        System.out.println(words.stream().map(word -> word.getText()).collect(Collectors.joining(",")));
        System.out.println(words.toString());

        long t = System.currentTimeMillis();
        String s = System.getProperty("java.io.tmpdir");
        //词频统计设置
        WordFrequencyStatistics wordFrequencyStatistics = new WordFrequencyStatistics();
        wordFrequencyStatistics.setRemoveStopWord(false);
        wordFrequencyStatistics.setResultPath(s + "word-frequency-statistics.txt");
        //开始分词
        wordFrequencyStatistics.seg("明天下雨，明天吧，明天好，结合成分子，明天有关于分子和原子的课程，下雨了也要去听课");
        //输出词频统计结果
        wordFrequencyStatistics.dump();
        System.out.println((System.currentTimeMillis() - t) / 1000);

        try {
            List<String> wrs= new ArrayList<>();
            File file = new File(s + "word-frequency-statistics.txt");
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s1;
            int count = 0;
            while ((s1 = br.readLine()) != null) {
                count++;
                if (count <=3) {
                    wrs.add(s1.split(" ")[0]);
                }
            }
            br.close();
            System.out.println(wrs.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
