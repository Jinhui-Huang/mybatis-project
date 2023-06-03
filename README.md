# 一. Mybatis-入门
## 1. 引入Mybatis和mysql.driver的相关依赖, 配置Mybatis
首先新建springboot项目, 然后在pom.xml文件下进行配置
```xml
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>2.2.2</version>
</dependency>

<dependency>
<groupId>com.mysql</groupId>
<artifactId>mysql-connector-j</artifactId>
<version>8.0.33</version>
<scope>runtime</scope>
</dependency>

<dependency>
<groupId>mysql</groupId>
<artifactId>mysql-connector-java</artifactId>
<version>8.0.28</version>
</dependency>
```
## 2. 编写SQL语句(注解/XML)
首先编写一个User类来存放获取到的数据, 各个成员变量要和数据库表里的字段名一样
```java
public class User {
    private Integer customer_id;
    private String first_name;
    private String last_name;
    private String birth_date;
    private String phone;


    public User() {
    }

    public User(Integer customer_id, String first_name, String last_name, String birth_date, String phone) {
        this.customer_id = customer_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.birth_date = birth_date;
        this.phone = phone;
    }
}
```
详细请看[User.java](MybatisDemo01%2Fsrc%2Fmain%2Fjava%2Fcom%2Fitstudy%2Fpojo%2FUser.java)

然后配置mybatis的配置文件application.properties
```properties
# jdbc.driver
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
# Database's url
spring.datasource.url=jdbc:mysql://localhost:3306/sql_store
# username
spring.datasource.username=mybatis
# password
spring.datasource.password=mybatis
```
新建一个接口来自动获取一个存放user列表的bean对象, 同时在里面注解定义sql语句
```java
@Mapper //在运行时, 会自动生成该接口的实现类对象(代理对象), 并且将该对象交给IoC容器管理
public interface UserMapper {
    //查询全部用户的信息
    @Select("select customer_id, first_name, last_name, birth_date, phone from customers " +
            "limit 10")
    List<User> list();

}
```
最后在测试类里进行bean的调用
```java
@SpringBootTest  //springboot整合单元测试的注解
class AppTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testListUser() {
        List<User> userList = userMapper.list();
        userList.stream().forEach(System.out::println);
    }
}
```
运行结果打印出了10条顾客的信息
```
User{customer_id=1, first_name='Babara', last_name='MacCaffrey', birth_date='1986-03-28', phone='781-932-9754'}
User{customer_id=2, first_name='Ines', last_name='Brushfield', birth_date='1986-04-13', phone='804-427-9456'}
User{customer_id=3, first_name='Freddi', last_name='Boagey', birth_date='1985-02-07', phone='719-724-7869'}
User{customer_id=4, first_name='Ambur', last_name='Roseburgh', birth_date='1974-04-14', phone='407-231-8017'}
User{customer_id=5, first_name='Clemmie', last_name='Betchley', birth_date='1973-11-07', phone='null'}
User{customer_id=6, first_name='Elka', last_name='Twiddell', birth_date='1991-09-04', phone='312-480-8498'}
User{customer_id=7, first_name='Ilene', last_name='Dowson', birth_date='1964-08-30', phone='615-641-4759'}
User{customer_id=8, first_name='Thacher', last_name='Naseby', birth_date='1993-07-17', phone='941-527-3977'}
User{customer_id=9, first_name='Romola', last_name='Rumgay', birth_date='1992-05-23', phone='559-181-3744'}
User{customer_id=10, first_name='Levy', last_name='Mynett', birth_date='1969-10-13', phone='404-246-3370'}
```
**以上信息均为随机生成的假信息**
