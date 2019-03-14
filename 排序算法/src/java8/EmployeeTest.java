package java8;

import com.google.common.collect.Maps;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class EmployeeTest {

  public static List<Employee> generateData() {
    return Arrays.asList(new Employee("Matt", 5000, "New York"),
      new Employee("Steve", 6000, "London"),
      new Employee("Carrie", 10000, "New York"),
      new Employee("Peter", 7000, "New York"),
      new Employee("Alec", 6000, "London"),
      new Employee("Sarah", 8000, "London"),
      new Employee("Rebecca", 4000, "New York"),
      new Employee("Pat", 20000, "New York"),
      new Employee("Tammy", 9000, "New York"),
      new Employee("Fred", 15000, "Tokyo"));
  }

  public static Map<String, Integer> generateMapData() {
    Map<String, Integer> items = Maps.newHashMap();
    items.put("A", 10);
    items.put("B", 20);
    items.put("C", 30);
    items.put("D", 40);
    items.put("E", 50);
    items.put("F", 60);

    return items;
  }


  @Test
  public void testEmployee() {
    List<Employee> results = generateData();

    //打印出名字是Steve的员工信息
    results.forEach(c -> {
      if (c.getName().equals("Steve")) {
        System.out.println(c);
      }
    });

    System.out.println("---------");

    //找出年薪超过6000的员工
    results.stream().filter(c -> c.getSalary() >= 6000).forEach(c -> System.out.println(c));

    System.out.println("--->>>>>>----");

    //java8遍历map
    Map<String, Integer> map_ = generateMapData();
    map_.forEach((key, value) -> System.out.println("key:" + key + "," + "value:" + value));

    System.out.println("---->>>>分组>>>-----");

    //java8 分组操作
    Map<String, List<Employee>> groupMap = results.stream().collect(Collectors.groupingBy(c -> c.getOffice()));
    System.out.println(groupMap);

    System.out.println("---->>>>List转化为Map>>>----");
    //List转化Map
    Map<String, Object> map = results.stream().collect(Collectors.toMap(Employee::getName, Employee::getOffice));
    map.forEach((key, value) -> System.out.println("key:" + key + "," + "value:" + value));

    System.out.println("---->>>>>>>----");
    //下面这一行是错误代码 这里使用map没有考虑到去重的问题
    //Map<Integer, Employee> employeeMap = results.stream().collect(Collectors.toMap((key -> key.getSalary()),
    // (value -> value)));

    //试一试这一段代码 这种方式把第二个相同的key给去掉了 有相同的第二个不保留
    Map<Integer, Employee> employeeMap1 = results.stream().collect(Collectors.toMap((key -> key.getSalary()), Function
      .identity(), (value1, value2) -> value1));

    //这种是直接先定好key和value的值，最后一个参数是对重复数据的处理
    Map<Integer, Employee> employeeMap2 = results.stream().collect(Collectors.toMap(Employee::getSalary, value -> value,
      (a, b) -> a));
    employeeMap1.forEach((key, value) -> System.out.println(key + "," + value));
    employeeMap2.forEach((key, value) -> System.out.println(key + "," + value));

    System.out.println("---->>遍历map>>>----");
    //打印出值大于30的map
    Map<String, Integer> resultMap = map_.entrySet().stream().filter(c -> c.getValue() > 30).collect(Collectors.toMap(
      p -> p.getKey(), p -> p.getValue()));
    resultMap.forEach((key, value) -> System.out.println(key + "=" + value));

    System.out.println(">>>>>>>>>>>>>>>");
    //打印key=D的map
    Map<String, Integer> mapResults = map_.entrySet().stream().filter(c -> c.getKey().equals("D")).collect(Collectors
      .toMap(p -> p.getKey(), p -> p.getValue()));
    mapResults.forEach((key, value) -> System.out.println(key + ">>>>" + value));

    System.out.println(">>>>>>>Optional>>>>>>>");
    Optional<String> optional = Optional.of("hello");
    System.out.println("optional用法，判断值是否存在  ：" + optional.isPresent());

  }

  @Test
  public void testEmployeeExample() {
    //anyMatch 是否匹配任一元素
    List<Employee> employeeList = generateData();
    boolean isMatch = employeeList.stream().anyMatch(employee -> employee.getOffice().equals("London"));
    System.out.println(isMatch);

    //allMatch  是否匹配所有的元素
    boolean matched = employeeList.stream().allMatch(employee -> employee.getOffice().equals("London"));
    System.out.println(matched);
    //找出工资最高的,有两种方式
    Optional<Employee> employeeOptional = employeeList.stream().max((e1, e2) -> Integer.compare(e1.getSalary(),
      e2.getSalary()));
    Optional<Employee> employeeOptional1 = employeeList.stream().max(Comparator.comparing(Employee::getSalary));
    System.out.println("找出最高工资的 ：" + employeeOptional + '\n');
    System.out.println("找出工资最高的方式二" + employeeOptional1 + '\n');

    //找出工资最少的
    Optional<Employee> employee = employeeList.stream().min((e1, e2) -> Integer.compare(e1.getSalary(), e2.getSalary
      ()));
    System.out.println(employee);

    //返回姓名列表
    List<String> names = employeeList.stream().map(c -> c.getName()).collect(Collectors.toList());
    System.out.println(names);
    System.out.println(">>>>>>>>>>>");
    //List转化Map 前提是key没有重复的，这一点是很重要的。
    Map<String, Employee> employeeMap = employeeList.stream().collect(Collectors.toMap((key -> key.getName()), (value
      -> value)));
    employeeMap.forEach((key, value) -> System.out.println(key + "=" + value));

    //统计办公室是New York的个数
    long officeCount = employeeList.stream().filter(c -> c.getOffice().equals("New York")).count();
    System.out.println(officeCount);

    long salaryCount = employeeList.stream().filter(c -> c.getSalary() > 60000).count();
    System.out.println(salaryCount);
    //List转化为Set 前提是全部必须去重，因为set集合不可能有重复元素
    Set<String> officeSet = employeeList.stream().map(c -> c.getOffice()).distinct().collect(Collectors.toSet());
    System.out.println(officeSet);

    Set<Integer> salarySet = employeeList.stream().map(c -> c.getSalary()).distinct().collect(Collectors.toSet());
    System.out.println(salarySet);

    //查找办公室地点是New York的员工 用于 查找的方法 的返回类型是Optional 一把结果是单个值;
    Optional<Employee> optionals = employeeList.stream().filter(c -> c.getOffice().equals("New York")).findAny();
    System.out.println("查找办公室是New York 的员工 ： " + optionals + '\n');


    System.out.println(">>>>>工资降序排序>>>>>");
    //按照工资的降序来列出员工信息
    List<Employee> sortSalaryEmployeeList = employeeList.stream().sorted((e1, e2) -> Integer.compare(e2.getSalary(),
      e1.getSalary())).collect(Collectors.toList());
    System.out.println(sortSalaryEmployeeList);

    System.out.println(">>>>>姓名升序排序>>>>>");
    List<Employee> sortNameEmployeeList = employeeList.stream().sorted((e1, e2) -> e1.getName().compareTo(e2.getName
      ())).collect(Collectors.toList());
    System.out.println(sortNameEmployeeList);

    System.out.println(">>>>获取工资最高的前2条员工信息");
    List<Employee> dispaly2EmployeeList = employeeList.stream().sorted((e1, e2) -> Integer.compare(e2.getSalary(),
      e1.getSalary())).limit(2).collect(Collectors.toList());
    System.out.println(dispaly2EmployeeList);

    System.out.println(">>>>获取平均工资");
    OptionalDouble averageSalary = employeeList.stream().mapToInt(c -> c.getSalary()).average();
    System.out.println(averageSalary);

    System.out.println(">>>>获取工作地点的平均工资");
    OptionalDouble optionalDouble = employeeList.stream().filter(c -> c.getOffice().equals("New York")).
      mapToInt(c -> c.getSalary()).average();

    System.out.println(optionalDouble);
    System.out.println();
    System.out.println("----对工作地点进行分组-----");
    Map<String, List<Employee>> map = employeeList.stream().collect(Collectors.groupingBy(Employee::getOffice));
/*    结果如下：
    {
      NewYork=[
      Employee(name=Matt,
        salary=5000,
        office=NewYork),
        Employee(name=Carrie,
          salary=10000,
          office=NewYork),
        Employee(name=Peter,
          salary=7000,
          office=NewYork),
        Employee(name=Rebecca,
          salary=4000,
          office=NewYork),
        Employee(name=Pat,
          salary=20000,
          office=NewYork),
        Employee(name=Tammy,
          salary=9000,
          office=NewYork)
    ],
      Tokyo=[
      Employee(name=Fred,
        salary=15000,
        office=Tokyo)
    ],
      London=[
      Employee(name=Steve,
        salary=6000,
        office=London),
        Employee(name=Alec,
          salary=6000,
          office=London),
        Employee(name=Sarah,
          salary=8000,
          office=London)
    ]
    }*/


    System.out.println(map);

    System.out.println("对工作地点先进行分组再进行数学运算");
    /*
    * groupingBy有两个参数，第一个参数是分类的标准字段，第二个字段是分类后的操作，这里对数据进行了所有的操作
    * 所有操作包括求和，求最小最大，求均值，当然，如果不想求所有的，那么可以把Map的泛型改成自己想要的类型，
    * 同时对数据的操作也就可以用与之相对应的 方法计算求职。
    * 如 ：
    *  Map<String, Double> orderyThenCalculation1 = employeeList.stream()
      .collect(Collectors.groupingBy(Employee::getOffice, Collectors.averagingDouble(Employee::getSalary)));
    * */
    Map<String, DoubleSummaryStatistics> orderyThenCalculation = employeeList.stream()
      .collect(Collectors.groupingBy(Employee::getOffice, Collectors.summarizingDouble(Employee::getSalary)));

    //计算结果：
/*
    {
      NewYork=DoubleSummaryStatistics{
      count=6,
        sum=55000.000000,
        min=4000.000000,
        average=9166.666667,
        max=20000.000000
    },
      Tokyo=DoubleSummaryStatistics{
      count=1,
        sum=15000.000000,
        min=15000.000000,
        average=15000.000000,
        max=15000.000000
    },
      London=DoubleSummaryStatistics{
      count=3,
        sum=20000.000000,
        min=6000.000000,
        average=6666.666667,
        max=8000.000000
    }
    }*/
    System.out.println(orderyThenCalculation);

    System.out.println(">>>>>>Java8 Optional用法>>>>>>");
    Optional<String> stringOptional = Optional.of("test");
    System.out.println(stringOptional.get());

    Optional<String> isOptional = Optional.ofNullable("hello");
    System.out.println(isOptional.isPresent());
    System.out.println(isOptional.get());
    System.out.println(isOptional.orElse("0"));

    System.out.println(">>>>>>>>>>>>");
    //Optional<String> optionalVal = Optional.of(null);
    // System.out.println(optionalVal);
    Optional<String> optional = Optional.ofNullable("optional");
    System.out.println(optional);
    System.out.println(optional.isPresent());
    System.out.println(optional.get());
    System.out.println(optional.orElse("haha"));
    System.out.println(">>>>>>>>>>>>");

    Optional<Employee> employeeOptional_ = employeeList.stream().filter(c -> c.getOffice().equals("New York"))
      .findFirst();
    System.out.println(employeeOptional_);

  }
}
