
# Java8新特性 #

## 一 主要内容 ##

1. Lambda表达式
2. 函数式接口
3. 方法引用和构造引用
4. Stream API
5. 接口中的默认方法与静态方法
6. 新时间日期API
7. 其他新特性

## 二 新特性简介 ##

- 	速度更快

    - 修改底层数据结构：如HashMap（数组-链表-红黑树），HashSet，ConcurrentHashMap（CAS算法）
    - 修改垃圾回收机制：取消堆中的永久区（PremGen）->回收条件苛刻，使用元空间（MetaSpace）->直接使用物理内存->加载类文件
- 	代码更少(增加了新的语法lambda表达式) 
- 	强大的Stream API
- 	便于并行
- 	最大化的减少空指针异常Optional


速度更快:  底层最核心的一个数据结构就是HashMap
(不用hash算法缺点,用了hash算法的优缺点,用了红黑树的优点)



## 三 为什么使用Lambda表达式 ##

  Lambda是一个匿名函数,我们可以把lambda表达式理解为是一段可以传递的代码(将代码像数据一样传递).可以写出更简洁,更灵活的代码.作为一种更急凑的代码风格,是Java的语言表达能力得到了提升.


## 四 Java内置四大核心函数式接口 ##



### 四大函数式接口 ###

| 函数式接口                  | 参数类型 | 返回类型   |  用户  
| :----: | :---: | :---: | :---:
| Consumer<T><br>消费型接口  |   T     | void   |对类型为T的对象应用操作,包含方法: void accept(T t)
| Supplier<T><br>供给型接口   |    无   |    T    |返回类型为T的对象,包含方法: T get() 
| Consumer<T,R><br>函数型接口  |    T    |   R    | 对类型为T的对象应用操作,并返回结果.结果的类型为R类型的对象,包含方法: R apply(T t) 
| Consumer<T><br>断言型接口    |    T   |boolean |  确定类型为T的对象是否满足某个约束,并对返回boolean 值.包含方法 boolean test(T t)  


### 所有函数式接口 ###
| 序号   | 接口 | 描述
| :----: | :---: | :---: 
|  || 
|  || 
|  1  |BiConsumer<T,U>|  代表了一个接受两个输入参数的操作，并且不返回任何结果 
|  || 
|  2	| BiFunction<T,U,R>     |    代表了一个接受两个输入参数的方法，并且返回一个结果 
|  || 
|  3	| BinaryOperator<T>     |    代表了一个作用于于两个同类型操作符的操作，并且返回了操作符同类型的结果
|  || 
|  4	| BiPredicate<T,U>      |   代表了一个两个参数的boolean值方法
|  || 
|  5	| BooleanSupplier       |   代表了boolean值结果的提供方
|  || 
|  6	| Consumer<T>           |  代表了接受一个输入参数并且无返回的操作
|  || 
|  7	| DoubleBinaryOperator  |   代表了作用于两个double值操作符的操作，并且返回了一个double值的结果。
|   || 
|  8	| DoubleConsumer        |  代表一个接受double值参数的操作，并且不返回结果。
|  || 
|  9	| DoubleFunction<R>     |    代表接受一个double值参数的方法，并且返回结果
|  || 
|  10	| DoublePredicate       |  代表一个拥有double值参数的boolean值方法
|  || 
|  11	| DoubleSupplier        | 代表一个double值结构的提供方
|  || 
|  12	| DoubleToIntFunction   |       接受一个double类型输入，返回一个int类型结果。
|  || 
|  13	| DoubleToLongFunction  |       接受一个double类型输入，返回一个long类型结果
|  || 
|  14	| DoubleUnaryOperator   |      接受一个参数同为类型double,返回值类型也为double 。
|  || 
|  15	| Function<T,R>         |       接受一个输入参数，返回一个结果。
|  || 
|  16	| IntBinaryOperator     |   接受两个参数同为类型int,返回值类型也为int 。
|  ||
|  17	| IntConsumer           |         接受一个int类型的输入参数，无返回值 。
|  || 
|  18	| IntFunction<R>        |        接受一个int类型输入参数，返回一个结果 。
|  || 
|  19	| IntPredicate          |        接受一个int输入参数，返回一个布尔值的结果。
|  || 
|  20	| IntSupplier           |         无参数，返回一个int类型结果。
|  || 
|  21	| IntToDoubleFunction   |  接受一个int类型输入，返回一个double类型结果 。
|  || 
|  22	| IntToLongFunction     |    接受一个int类型输入，返回一个long类型结果。
|  || 
|  23	| IntUnaryOperator      |    接受一个参数同为类型int,返回值类型也为int 。
|  || 
|  24	| LongBinaryOperator    |     接受两个参数同为类型long,返回值类型也为long。
|  || 
|  25	| LongConsumer          |接受一个long类型的输入参数，无返回值。
|  || 
|  26	| LongFunction<R>       |   接受一个long类型输入参数，返回一个结果。
|  || 
|  27	| LongPredicate         |        R接受一个long输入参数，返回一个布尔值类型结果。
|  || 
|  28	| LongSupplier          |       无参数，返回一个结果long类型的值。
|   || 
|  29	| LongToDoubleFunction  |        接受一个long类型输入，返回一个double类型结果。
|  || 
|  30	| LongToIntFunction     |    接受一个long类型输入，返回一个int类型结果。
|  || 
|  31	| LongUnaryOperator     |    接受一个参数同为类型long,返回值类型也为long。
|  || 
|  32	| ObjDoubleConsumer<T>  |        接受一个object类型和一个double类型的输入参数，无返回值。
|  || 
|  33	| ObjIntConsumer<T>     |     接受一个object类型和一个int类型的输入参数，无返回值。
|  || 
|  34	| ObjLongConsumer<T>    |     接受一个object类型和一个long类型的输入参数，无返回值。
|  || 
|  35	| Predicate<T>          |      接受一个输入参数，返回一个布尔值结果。
|  || 
|  36	| Supplier<T>           |    无参数，返回一个结果。
|  || 
|  37	| ToDoubleBiFunction<T,U|          接受两个输入参数，返回一个double类型结果
|  || 
|  38	| ToDoubleFunction<T>   |      接受一个输入参数，返回一个double类型结果
|  || 
|  39	| ToIntBiFunction<T,U>  |        接受两个输入参数，返回一个int类型结果。
|  || 
|  40	| ToIntFunction<T>      |    接受一个输入参数，返回一个int类型结果。
|  || 
|  41	| ToLongBiFunction<T,U> |        接受两个输入参数，返回一个long类型结果。
|  || 
|  42	| ToLongFunction<T>     |    接受一个输入参数，返回一个long类型结果。
|  || 
|  43	| UnaryOperator<T>      |   接受一个参数为类型T,返回值类型也为T。

## 五 方法引用与构造引用 ##

### 方法引用三种语法 ###

- 对象::实例方法名

- 类::静态方法名

- 类::实例方法名

## 六 强大的Stream API ##

位于包： java.util.stream .*

Stream 是 Java8 中处理集合的关键抽象概念，它可以指定你希望对集合进行的操作，可以执行非常复杂的查找、过滤和映射数据等操作。使用Stream API 对集合数据进行操作，就类似于使用 SQL 执行的数据库查询。也可以使用 Stream API 来并行执行操作。简而言之，Stream API 提供了一种高效且易于使用的处理数据的方式。

### 什么是 Stream ###
流 (Stream) 到底是什么呢 ？ 
是数据渠道，用于操作数据源（集合、数组等）所生成的元素序列。“集合讲的是数据，流讲的是计算！ ”

注意： 
①Stream 自己不会存储元素。 
②Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。 
③Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行。

### Stream的操作三步骤 ###

- 创建Stream 
一个数据源（如：集合、数组），获取一个流

- 中间操作 
一个中间操作链，对数据源的数据进行处理

- 终止操作（终端操作） 
一个终止操作，执行中间操作链，并产生结果



方法 返回类型 作用
joining String 连接流中每个字符串

String str= list.stream().map(Employee::getName).collect(Collectors.joining());

maxBy Optional<T> 根据比较器选择最大值
    
Optional<Emp>max= list.stream().collect(Collectors.maxBy(comparingInt(Employee::getSalary)));
    
minBy Optional<T> 根据比较器选择最小值
    
Optional<Emp> min = list.stream().collect(Collectors.minBy(comparingInt(Employee::getSalary)));
    
reducing 归约产生的类型 从一个作为累加器的初始值

开始，利用BinaryOperator与流中元素逐个结合，从而归约成单个值

inttotal=list.stream().collect(Collectors.reducing(0, Employee::getSalar, Integer::sum));

collectingAndThen 转换函数返回的类型 包裹另一个收集器，对其结果转换函数

inthow= list.stream().collect(Collectors.collectingAndThen(Collectors.toList(), List::size));

groupingBy Map<K, List<T>> 根据某属性值对流分组，属性为K，结果为V
    
Map<Emp.Status, List<Emp>> map= list.stream().collect(Collectors.groupingBy(Employee::getStatus));
    
partitioningBy Map<Boolean, List<T>> 根据true或false进行分区
    
Map<Boolean,List<Emp>>vd= list.stream().collect(Collectors.partitioningBy(Employee::getManage));


## 并行流与串行流 ##
并行流就是把一个内容分成多个数据块，并用不同的线程分别处理每个数据块的流。

Java 8 中将并行进行了优化，我们可以很容易的对数据进行并行操作。Stream API 可以声明性地通过 parallel() 与sequential() 在并行流与顺序流之间进行切换。


## 了解 Fork/Join 框架 ## 

Fork/Join 框架：就是在必要的情况下，将一个大任务，进行拆分(fork)成若干个
小任务（拆到不可再拆时），再将一个个的小任务运算的结果进行 join 汇总


Fork/Join 框架与传统线程池的区别

采用 “工作窃取”模式（work-stealing）：

当执行新的任务时它可以将其拆分分成更小的任务执行，并将小任务加到线程队列中，然后再从一个随机线程的队列中偷一个并把它放在自己的队列中。

相对于一般的线程池实现,fork/join框架的优势体现在对其中包含的任务的处理方式上.在一般的线程池中,如果一个线程正在执行的任务由于某些原因无法继续运行,那么该线程会处于等待状态.而在fork/join框架实现中,如果某个子问题由于等待另外一个子问题的完成而无法继续运行.那么处理该子问题的线程会主动寻找其他尚未运行的子问题来执行.这种方式减少了线程的等待时间,提高了性能.


##  新时间日期 API ## 

