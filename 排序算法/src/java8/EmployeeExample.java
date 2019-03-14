package java8;

import com.google.common.collect.Lists;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeExample {

  private static List<Employee> employeeList = Lists.newArrayList();

  static{
    employeeList.add(Employee.builder().name("Matt").salary(5000).office("New York").build());
    employeeList.add(Employee.builder().name("Steve").salary(6000).office("London").build());
    employeeList.add(Employee.builder().name("Carrie").salary(20000).office("New York").build());
    employeeList.add(Employee.builder().name("Peter").salary(7000).office("New York").build());
    employeeList.add(Employee.builder().name("Pat").salary(8000).office("London").build());
    employeeList.add(Employee.builder().name("Tammy").salary(29000).office("Shanghai").build());
  }

  public static void main(String[] args) {
    //   1:  anyMatch
    boolean isMatch = employeeList.stream().anyMatch(employee -> employee.getOffice().equals("London"));
    System.out.println("1:  anyMatch"+isMatch);

    //返回所有salary大于6000
    boolean matched = employeeList.stream().allMatch(employee -> employee.getSalary()>4000);
    System.out.println("salary大于6000    "+matched+'\n');

    //找出工资最高
    Optional<Employee> hightestSalary = employeeList.stream().max((e1, e2)->Integer.compare(e1.getSalary(),e2.getSalary()));
    Optional<Employee> hightestSalary1 = employeeList.stream().max(Comparator.comparing(Employee::getSalary));
    System.out.println("工资最高     :"+hightestSalary+'\n');
    System.out.println("工资最高第二种方式    :"+hightestSalary1+'\n');

    //返回姓名列表
    List<String> names = employeeList.stream().map(employee -> employee.getName()).collect(Collectors.toList());
    System.out.println("姓名列表   "+names+'\n');
    List<String> name=employeeList.stream().map(employee -> employee.getName()).collect(Collectors.toList());

    //List转换成Map
    Map<String,Employee> employeeMap = employeeList.stream().collect(Collectors.toMap((key->key.getName()),(value->value)));
    employeeMap.forEach((key,value)-> System.out.println(key + "=" + value));

    //统计办公室是New York的个数
    long officeCount = employeeList.stream().filter(employee -> employee.getOffice().equals("Shanghai")).count();
    System.out.println("办公室是New York的个数" +officeCount+'\n');

    //List转换为Set
    Set<String> officeSet = employeeList.stream().map(employee -> employee.getOffice()).distinct().collect(Collectors.toSet());
    System.out.println("list转set"+officeSet+'\n');

    //查找办公室地点是New York的员工
    Optional<Employee> allMatchedEmployees = employeeList.stream().filter(employee -> employee.getOffice().equals("New York")).findAny();
    System.out.println("查找办公室地点是New York的员工"+allMatchedEmployees+'\n');

    //按照工资的降序来列出员工信息
    List<Employee> sortEmployeeList =  employeeList.stream().sorted((e1,e2)->Integer.compare(e2.getSalary(),e1.getSalary())).collect(Collectors.toList());
    //按照名字的升序列出员工信息
    List<Employee> sortEmployeeByName = employeeList.stream().sorted((e1,e2)->e1.getName().compareTo(e2.getName())).collect(Collectors.toList());
    System.out.println("按照工资降序来输出员工信息"+sortEmployeeList+'\n');
    System.out.println("按照名字的升序列出员工信息:" + sortEmployeeByName+'\n');
    List<Employee> infomation = employeeList.stream().sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
    System.out.println("自己写的按照名字的升序来输出员工信息"+infomation+'\n');
    //获取工资最高的前2条员工信息
    List<Employee> top2EmployeeList= employeeList.stream()
      .sorted((e1,e2)->Integer.compare(e2.getSalary(),e1.getSalary()))
      .limit(2)
      .collect(Collectors.toList());
    System.out.println("工资最高的前两条员工信息"+top2EmployeeList+'\n');

    //获取平均工资
    OptionalDouble averageSalary = employeeList.stream().mapToInt(employee->employee.getSalary()).average();
    System.out.println("平均工资:" + averageSalary+'\n');

    //查找New York
    OptionalDouble averageSalaryByOffice = employeeList.stream().filter(employee -> employee.getOffice()
      .equals("New York"))
      .mapToInt(employee->employee.getSalary())
      .average();
    System.out.println("New York办公室平均工资:" + averageSalaryByOffice+'\n');

  }
}