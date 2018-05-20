## Java基础-02 概念
##### 从头开始，寻找初心
***
##### 面向对象编程
*将某一类事物抽象化，确定如何操作数据然后再考虑如何操作数据。然后再考虑下如何组织数据*

  - 特点

    - 属性: 用来描述对象的数据元素称为对象的属性。
    - 方法: 对象的属性进行的操作称为对象的方法。
    
##### 类
  - 类是描述对象特征和对象行为，类是对象的模板。
 
    - 构造器(构造方法)
 
      - 构造函数将实例变量设置为提供的参数；

    - 方法的重载
    
      - 调用哪个构造函数取决于参数；
    
    - 调用另一个构造函数(同类)
    
      - 使用关键字this
      
```
public Employee(double salary) {
    this("", salary);//调用构造函数Emplyee(String, double)
    //后面其他的声明
}
```
  - 方法的参数传递
  
    - 基本数据类型传递的是该数据的值本身。
    - 引用数据类型传递的是对象的引用而非对象本身。
    - 如果在调用方法中，出现  new  是开辟了新空间。
    

##### static 关键字
  - static修饰的方法内部，只能使用static修饰的成员变量（方法和属性）。
  - 非static修饰的方法内部，可以使用static修饰的成员变量。
  - 在static方法内，不能直接使用非static方法。
  - 在static方法内，可以使用static方法。
  - static是修饰符，不能声明构造器 。
  - static的类调用。
  
##### 修饰符
  - private:
  
    - 只能在本类中使用，在其他类中使用是 通过 get set方法。
    
  - protected:
  
    - 可以再本类中使用，也可以在本包中使用.
    - 在继承时，子类无论在哪个包中，都都可以使用。
    - 如果不是 继承，在其他类中即使导入包也不能使用。
    
  - public : 通用；
  - default： 表示一种不加任何修饰符的状态。
  
##### 重写
  - 重写方法必须和父类中的被重写的方法具有相同的/方法名称/输入参数/返回值类型。
  - 不能使用比父类中更严格的 访问权限。
  - 重写方法不能比父类重写方法抛出 更多异常。(指范围)；
  
##### super关键字
  - 访问父类的成员变量：super.变量
  - 访问父类中的方法；super.方法
  - 访问父类的构造器；super(参数列表)
  - super 具体使用
  
    - 一定要写在子类构造器中.
    - 如果调用父类无参构造器，可以省略，即系统默认；
    
##### this关键字
  - 在类本身的方法或构造器中引用该类的实例变量和方法。
  - 将当前对象作为参数传递给其它方法或构造器。
  - 用来调用其他的重载的构造器（必须写在第一行）。
 
##### static 初始化块：
  - 最先被执行
  
##### 抽象类
  - 如果在一个类中，至少有一个抽象方法，那么该类必须定义为抽象类。
  - 如果一个类中，没有抽象方法，那么该类可以是 抽象类；
  - 抽象方法 ，只需要声明，不用实现；
  - 抽象类可以定义构造器、和 普通方法。
  - 构造方法：static方法、private方法和final方法不能被定义成抽象方法。
  - 抽象类中不能实例化！
  - 子类必须实现 抽象父类的  方法！
  
    - 例外: 子类也是抽象类则不需要全部实现；
    
##### 接口
  - 接口中声明属性，必须要赋初始值。(public static final)
  - 接口中的方法默认为抽象方法，默认使用 public abstract 来修饰。
  - 在接口中，声明方法的时候，不能够使用static ,final ,private protected 来修饰；
  - 多个无关类可以实现同一个接口。
  - 一个类可以实现 多个接口。
  - 一个接口 可以 继承多个接口；
  - 如果想要不去实现那些方法，就定义成abstract抽象类。
  
##### 多态
  - 上转型：父类  对象1  =new  子类； （就是父类）  限制（只能使用父类）；
  - 下转型: 子类  对象   =（子类）父类的对象         不限制
  - 分类:
  
    - 编译时多态：静态多态，由方法重载来体现。
    - 运行时多态：动态多态，由向上转型来实现。

```
		   例如：public interface Man(){
			void eat();
			void sleep();
		   }
			public class SuperMan implements Man{
				public void eat(){                    //实现的方法；
					System.out.println(">>吃饭");
				}
				public void sleep(){
					System.out.println(">>睡觉");
				}
			}

			public class Test{
				public static void main(String[] args){
					Man men=new SuperMan();  //  接口实现 多态；
					/*这样写的目的就实现了，让接口来实现自己定义的 抽象方法；
					*  但是它不能实现  子类的方法；
					*/
					men.eat();
					men.sleep();
				}
			}
```

##### 内部类
  - 成员内部类
  
    - 成员内部类也叫实例内部类，  但里面不能定义static变量。
    - 成员内部类持有外部类的引用。
    
```
		模板：
			class OutClass{             //外部类
				int x=1;
				class InnerClass{   //内部类
					private void print(){  // 内部类中定义的方法；
						System.out.println("内部类实例化");
					}
				}
				public static void main(String[] args){
					//需求：用内部类中的方法
					MemberClass.InnerClass ic=new MemberClass().new InnerClass();
					id.print();
					//外部类.内部类  对象=new 外部类（）.new 内部类（）；
				}
			}
```
- 静态内部类

```
		public static class InnerClass{}   //静态内部类的格式；
		//需求 用 静态内部类中的方法；
		StaticMember.InnerClass si=new StaticMember.InnerClass();
		//  外部类.内部类  对象=new 外部类.内部类();
```
  
  - 局部内部类

```
		此类定义在方法中，
		void method(final int temp){  // 此处的参数要用 final 修饰，保证 参数的稳定性；
			class InnerClass{                 //内部类；
				public void print(){
					System.out.println("  ok");
				}
			}
		}
```

  - 匿名内部类
  
```
		//条件
		   如果一个内部类在整个操作中 只使用一次 的话，就可以定义为匿名内部类。
		   没有名字的内部类，就是java为了方便我们编写程序设计的一个机制，因为有时候
		   有的内部类只需要创建一个它的对象就可以，以后再不会用到这个类。
		//形式
		   匿名类内部不用声明类名称，而是用new直接产生一个对象。匿名内部类是在抽象类
		   和接口的基础上发展起来的。它可以是 ①继承某个类  或②实现某个接口。

	例子：
		class interface A{
			void eat();
		}
		
		class AA implements A{
			 void eat(){ // 重写的方法 
				System.out.println(">>>>>>>>");
			 }
		}
		class InnerClass{
			public static void main(String args[]){
			/*这样就不用再 声明一个对象，可以直接
			*用继承的 类  或 实现的 接口
			*/
				new A(){                            // 利用接口（父亲）
					void eat(){                 //实现了 重写方法；
						System.out.println(”￥￥￥￥￥￥￥￥￥￥“);
					}
				}.eat();
			}
	}
```

##### 异常 throw / throws
  - 位置：throw 是放在方法 中，throws  在方法声明处；
  - 后面的值：throw是对象，throws后面为异常类。
  - 作用：throw是在方法中抛出一个异常，throws是声明的方法内将代码的异常抛出，不会划红线、
  - 使用：throw时，需要配合throws或try/catch.
  - 调用：调用throws方法时，需要处理异常。（位置、后面值、作用、使用）
  
##### 抽象类和接口的异同点:
  - 相同点:
 
    - 都是不断向上抽取而来。
    
  - 不同点
  
    - 抽象类需要被继承，而且只能单继承.(接口需要被实现，而且可以多实现。)
    - 抽象类中可以定义抽象方法和非抽象方法，子类继承后，可以直接使用非抽象方法 接口中只能定义抽象方法，必须由子类去实现。
    - 抽象类的继承，是 is  a关系，在定义该体系的基本共性内容。
