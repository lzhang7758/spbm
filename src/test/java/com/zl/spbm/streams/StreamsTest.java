package com.zl.spbm.streams;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.time.ZoneId;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Author: lzhang
 * @Date: 2019/6/26 14:36
 */
public class StreamsTest {
    List<Person> persons = new ArrayList<Person>() {
        private static final long serialVersionUID = 1L;
        {
            add(new Person("张三", "Java", "female", 25, 1000));
            add(new Person("李四", "Java", "male", 29, 1200));
            add(new Person("王五", "测试", "female", 25, 1400));
            add(new Person("赵六", "Java", "male", 31, 1800));
            add(new Person("张三三", "设计", "male", 33, 1900));
            add(new Person("李四四", "需求", "female", 30, 2000));
            add(new Person("王五五", "Java", "female", 29, 2100));
            add(new Person("赵六六", "Java", "male", 43, 2800));
        }
    };

    @Test
    public void consumerTest(){
        Consumer<Person> println = e -> System.out.println(e.toString());
        Consumer<Person> salaryPlus = e -> e.setSalary(e.getSalary() / 100 * 10 + e.getSalary());
        persons.forEach(salaryPlus);
        persons.forEach(println);
    }

    @Test
    public void PersonForEach(){
        Consumer<Person> println = e -> System.out.println(e.toString());
//        persons.stream().filter(e -> (e.getSalary() < 1500)).forEach(println);
        Predicate<Person> salaryPredicate = e -> e.getSalary() > 100;
        Predicate<Person> jobPredicate = e -> "Java".equals(e.getJob());
        Predicate<Person> agePredicate = e -> e.getAge() > 10;
        Predicate<Person> genderPredicate = e -> "female".equals(e.getGender());
        persons.stream().filter(salaryPredicate)
                .filter(jobPredicate)
                .filter(agePredicate)
                .filter(genderPredicate)
                .limit(2)
                .forEach(println);
    }

    @Test
    public void minOrMax(){
        System.out.println(persons.stream().min((p1, p2) -> p1.getAge() - p2.getAge()).get().toString());
        System.out.println(persons.stream().max((p1, p2) -> p1.getAge() - p2.getAge()).get().toString());
        System.out.println(persons.stream().parallel().mapToInt(p -> p.getSalary()).sum());

        String names = persons.stream().map(Person::getName).collect(Collectors.joining(","));
        System.out.println(names);

        TreeSet<String> treeSet = persons.stream().map(Person::getName).collect(Collectors.toCollection(TreeSet::new));
        treeSet.forEach(System.out::println);

        Set<String> set = persons.stream().map(Person::getName).collect(Collectors.toSet());
        set.forEach(System.out::println);


    }

    /**
     * 统计
     */
    @Test
    public void summaryStatistics() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        IntSummaryStatistics statistics = list.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("合计="+statistics.getCount());
        System.out.println("age="+statistics.getAverage());
        System.out.println("max="+statistics.getMax());
        System.out.println("min="+statistics.getMin());
    }

    /**
     * 去重
     */
    @Test
    public void distinct(){
        List<Integer> numbers1 = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinctList = numbers1.stream().distinct().collect(Collectors.toList());
        distinctList.forEach(System.out::println);
    }

    @Test
    public void Strategy(){
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
//        sumAllByPredicate(numbers,n -> true);
//        sumAllByPredicate(numbers, n -> n % 2 == 0);
        sumAllByPredicate(numbers, n -> n > 3);
    }
    private  static int sumAllByPredicate(List<Integer> numbers, Predicate<Integer> p) {
        int total = 0;
        for (int number : numbers) {
            if (p.test(number)) {
                total += number;
            }
        }
        return total;
    }

    /**
     * 字符串拼接
     */
    @Test
    public void joined() {
        String joined = String.join("/", "usr", "local", "bin");
        System.out.println("joined="+joined);
        String ids = String.join(",", ZoneId.getAvailableZoneIds());
        System.out.println(ids);
    }

}
