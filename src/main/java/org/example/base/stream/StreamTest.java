package org.example.base.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 *  @author: paladin
 *  @date: created in 2020/7/5 21:26
 */
public class StreamTest {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("张无忌");
        list.add("张震");
        list.add("张信哲");
        list.add("爱如潮水她将你我包围");
        list.add("降龙十八掌");
        list.add("王语嫣");
        list.add("michael jackson");
        list.add("Taylor Swift");
        list.add("love story");
        list.add("Dream It Possible");
        list.add("Yeah I believe it");
        streamFilter(list);
        streamMap(list);
        streamLimit(list);
        System.out.println("===================");
        streamSkip(list, 5);
        streamConcat(list);
    }

    private static void streamFilter(List<String> list) {
        /**
         * forEach
         * 为流中的每一个元素执行一个操作
         * 这是个终止操作
         * 这个操作的行为是明显不确定的
         * 对于并行计算，这个操作并不保证流的顺序，因为这样做的话会牺牲并行计算的优势。对于任意给定
         * 的元素，这个操作会被在库选择的任意时间和线程中执行。如果这个操作访问共享状态，他有责任提供
         * 要求的同步。(也就是这个forEach的参数必须是Consumer的andThen方法，可以用accept方法来
         * 传入参数，如果涉及到多线程的操作，这个方法必须是线程安全的)
         *
         * filter
         * 返回匹配给定的断言的这个流的元素
         * Predicate 应用于每一个元素，决定它是否应该被包括
         */
        Stream<String> listStream = list.stream();
        listStream.filter(name -> name.startsWith("张")).forEach(System.out::print);
        list.stream().map(String::length).forEach(System.out::println);

    }

    private static void streamMap(List<String> list) {
        list.stream().map(String::length).forEach(System.out::println);
    }

    /**
     * 截断不超过maxSize的元素
     * 这是个短路的、有状态的中间操作
     * 尽管limit()在串行的流管道上通常是一个廉价的操作，但是在有序的并行管道上就是非常昂贵的，尤其是
     * 当maxSize很大的时候。因为limit(n)被限制返回不是n个元素，而是第一次按照出现顺序排列的n个元素。
     * 如果你的场景允许的话，在并行管道上使用一个乱序的流(比如generate(Supplier)或者用unordered()
     * 移除有序限制)可以得到有效的加速效果。如果要求出现顺序的一致性，并且并行管道的limit()的性能
     * 表现和内存利用极差，用sequential()转换到串行执行模式可以提升性能。
     * @param list
     */
    private static void streamLimit(List<String> list) {
        list.stream().limit(3).forEach(System.out::println);
    }

    /**
     * 返回包含丢弃了第一个n个元素的流，如果流包含的元素个数小于n,会返回一个空的流
     * 这是一个有状态的中间操作
     * 尽管skip()在串行的流管道上通常是一个廉价的操作，但是在有序的并行管道上就是非常昂贵的，尤其是
     * 当maxSize很大的时候。因为skip(n)被限制跳过不是n个元素，而是第一次按照出现顺序排列的n个元素。
     * 如果你的场景允许的话，在并行管道上使用一个乱序的流(比如generate(Supplier)或者用unordered()
     * 移除有序限制)可以得到有效的加速效果。如果要求出现顺序的一致性，并且并行管道的skip()的性能
     * 表现和内存利用极差，用sequential()转换到串行执行模式可以提升性能。
     *
     * @param list
     * @param n
     */
    private static void streamSkip(List<String> list, long n) {
        list.stream().skip(n).forEach(System.out::println);
    }

    private static void streamConcat(List<String> list) {
        List<String> anotherList = new ArrayList<>();
        anotherList.add("See you");
        anotherList.add("See yoda");
        anotherList.add("See Douala");
        anotherList.add("See yoknapatawpha");
        Stream.concat(list.stream(), anotherList.stream()).forEach(System.out::println);
    }
}
