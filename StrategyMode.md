#### 策略模式
#### 需求：
**Boss提出一个新的需求：他要参加一个相亲，约了A B C三个姑娘，Boss针对不同面容的姑娘有不同的语言行为．**
**我大致分为：漂亮/一般/难看，"你好，～"，　＂沉默＂，　＂转身走＂**
为了Boss的相亲可以高效率，我需要写一段程序：
***
A B C　共有一个属性女人，则创建一个抽象的父类：Woman.java
    public abstract class Wonman{
        private String name;
        public Wonman(String name) {
            this.name = name;
        }
        abstract void behavior();
    }　

创建子类：Beautiful.java  Common.java  Ugly.java 继承Woman.java
    public class　Beautiful extends Woman {
        public Beautiful(String name) {
            super(name);
        }
        
        @Override
        public void behavior() {
            System.out.println("你好, 美女！");
        }    
    }

　　．．．其他两个类似．
    public class Boss{

        public static void main(String args[]) {
            System.out.println("相亲开始　．．．");
            Beautiful beautiful = new Beautiful("美女");
            behavior(beautiful);    
        }
        
        public static void behavior(Wonman wonman) {
            woman.behavior();
        }
    }

***　　
** 针对这个实现，感觉很不错， 后期Boss见的越来越多，不再只是三种，又有气质好的/大长腿的/..
.你需要每次都建一个类并给一种行为吗？　何况Boss比较干练只有三种行为．
为何不思考一个策略：　只有三个行为，建三个行为类：试试如何**

    public interface Strategy {
        void behavior();
    }

    public class Woman {
        private String name;

        public Woman(String name) {
            this.name = name;
        }

        public void setBehavior(Strategy strategy) {
            strategy.behavior();
        }
    }

    public class　Beautiful extends Woman {
        public Beautiful(String name) {
            super(name);
            setBehavior(new SayHelloStrategy());
        }
    }

    ...

    public class SayHelloStrategy implements Strategy{
        void behavior() {
            System.out.println("你好，　美女");
        }
    }
  
    ...

　　public class Boss {
        public static void main(String args[]) {
            System.out.println("相求开始　．．．");
　　　　　　Beautiful beautify = new Beautiful("美女");
        }
    }

***
 从表面上看，前者更好理解而且好少写一个类文件，但是，如果你想后期来了很多气质妹子　贤惠的妹子
Boss的行为没变，你只需要再增加一个Graceful.java 不用再写　print..
从直观上看，这不就实现了code　复用吗？

看了几篇博文，有些自己的感觉，写个笔记，　刚开始仍需要多琢磨　．．．

