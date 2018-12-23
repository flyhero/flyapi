package cn.iflyapi.blog.controller;

import org.apdplat.word.WordFrequencyStatistics;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

/**
 * @author flyhero
 * @date 2018-12-22 3:24 PM
 */
@RestController
public class TestController {

    public static void main(String[] args) {
        List<Word> words = WordSegmenter.seg("不得不知的Spring设计模式");
        words.get(0).getText();
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
    }

}
