package com.somelogs;

import org.junit.Test;

/**
 * test
 *
 * @author LBG - 2018/1/15 0015 16:30
 */
public class ClassTest {

    @Test
    public void test() throws Exception {
        ClassFileAnalyzer.analyze("C:/Users/Administrator/Desktop/TestClass.class").print();
    }
}
