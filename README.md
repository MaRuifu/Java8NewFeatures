
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



| 名称   | 类型 | 是否必须| 参数描述
| :----: | :---: | :---: | :---:
| out_trade_no  |String|  必须  |   交易流水号（不可重复，重复就会显示二维码失效）
| total_amount  |String|  必须  |   订单金额
| subject  |String|  必须  |   订单标题(支付宝官网支付测试)
| body  |String|  必须  |   订单描述



### 其他函数式接口 ###
|序号|	接口 | 描述||
| -------- :                  | :-----:| :-----:    | :----:  |
|  1	| BiConsumer<T,U>       |    代表了一个接受两个输入参数的操作，并且不返回任何结果|
|  || 
|  2	| BiFunction<T,U,R>     |    代表了一个接受两个输入参数的方法，并且返回一个结果|
|  || 
|  3	| BinaryOperator<T>     |    代表了一个作用于于两个同类型操作符的操作，并且返回了操作符同类型的结果|
|  || 
|  4	| BiPredicate<T,U>      |   代表了一个两个参数的boolean值方法|
|  || 
|  5	| BooleanSupplier       |   代表了boolean值结果的提供方|
|  || 
|  6	| Consumer<T>           |  代表了接受一个输入参数并且无返回的操作|
|  || 
|  7	| DoubleBinaryOperator  |   代表了作用于两个double值操作符的操作，并且返回了一个double值的结果。|
|   || 
|  8	| DoubleConsumer        |  代表一个接受double值参数的操作，并且不返回结果。|
|  || 
|  9	| DoubleFunction<R>     |    代表接受一个double值参数的方法，并且返回结果|
|  || 
|  10	| DoublePredicate       |  代表一个拥有double值参数的boolean值方法|
|  || 
|  11	| DoubleSupplier        | 代表一个double值结构的提供方|
|  || 
|  12	| DoubleToIntFunction   |       接受一个double类型输入，返回一个int类型结果。|
|  || 
|  13	| DoubleToLongFunction  |       接受一个double类型输入，返回一个long类型结果|
|  || 
|  14	| DoubleUnaryOperator   |      接受一个参数同为类型double,返回值类型也为double 。|
|  || 
|  15	| Function<T,R>         |       接受一个输入参数，返回一个结果。|
|  || 
|  16	| IntBinaryOperator     |   接受两个参数同为类型int,返回值类型也为int 。|
|  || 
|  17	| IntConsumer           |         接受一个int类型的输入参数，无返回值 。|
|  || 
|  18	| IntFunction<R>        |        接受一个int类型输入参数，返回一个结果 。|
|  || 
|  19	| IntPredicate          |        接受一个int输入参数，返回一个布尔值的结果。|
|  || 
|  20	| IntSupplier           |         无参数，返回一个int类型结果。|
|  || 
|  21	| IntToDoubleFunction   |  接受一个int类型输入，返回一个double类型结果 。|
|  || 
|  22	| IntToLongFunction     |    接受一个int类型输入，返回一个long类型结果。|
|  || 
|  23	| IntUnaryOperator      |    接受一个参数同为类型int,返回值类型也为int 。|
|  || 
|  24	| LongBinaryOperator    |     接受两个参数同为类型long,返回值类型也为long。|
|  || 
|  25	| LongConsumer          |接受一个long类型的输入参数，无返回值。|
|  || 
|  26	| LongFunction<R>       |   接受一个long类型输入参数，返回一个结果。|
|  || 
|  27	| LongPredicate         |        R接受一个long输入参数，返回一个布尔值类型结果。|
|  || 
|  28	| LongSupplier          |       无参数，返回一个结果long类型的值。|
|   || 
|  29	| LongToDoubleFunction  |        接受一个long类型输入，返回一个double类型结果。|
|  || 
|  30	| LongToIntFunction     |    接受一个long类型输入，返回一个int类型结果。|
|  || 
|  31	| LongUnaryOperator     |    接受一个参数同为类型long,返回值类型也为long。|
|  || 
|  32	| ObjDoubleConsumer<T>  |        接受一个object类型和一个double类型的输入参数，无返回值。|
|  || 
|  33	| ObjIntConsumer<T>     |     接受一个object类型和一个int类型的输入参数，无返回值。|
|  || 
|  34	| ObjLongConsumer<T>    |     接受一个object类型和一个long类型的输入参数，无返回值。|
|  || 
|  35	| Predicate<T>          |      接受一个输入参数，返回一个布尔值结果。|
|  || 
|  36	| Supplier<T>           |    无参数，返回一个结果。|
|  || 
|  37	| ToDoubleBiFunction<T,U|          接受两个输入参数，返回一个double类型结果|
|  || 
|  38	| ToDoubleFunction<T>   |      接受一个输入参数，返回一个double类型结果|
|  || 
|  39	| ToIntBiFunction<T,U>  |        接受两个输入参数，返回一个int类型结果。|
|  || 
|  40	| ToIntFunction<T>      |    接受一个输入参数，返回一个int类型结果。|
|  || 
|  41	| ToLongBiFunction<T,U> |        接受两个输入参数，返回一个long类型结果。|
|  || 
|  42	| ToLongFunction<T>     |    接受一个输入参数，返回一个long类型结果。|
|  || 
|  43	| UnaryOperator<T>      |   接受一个参数为类型T,返回值类型也为T。|
|
