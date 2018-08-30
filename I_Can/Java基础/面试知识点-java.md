## Android 知识点大全
***
### Java基础知识
***
## 技术道路计划
***
### 一　java知识和算法回顾之路
#### 参考资料: 写给大忙人看的Java核心技术　csdn / githup
**Date:  2018年03月06日**
#### 基础
*1. Math类*
  - ①Math.PI   // 获取π的值；
  - ②Math.sin(30)//  获取正弦的值
  - ③Math.cos(30)//获取余弦的值
  - ④Math.sqrt(16)//求平方根
  - ⑤Math.pow(a,b)//  a的b次幂
  - ⑥Math.abs(-1)//取绝对值
  - ⑦Math.floor(3.4)//  取 整小值，3
  - ⑧Math.ceil(3.7)//取整大值   4
  - ⑨Math.min(3,5)  //取小值
  - ⑩Math.max(3,5) //取大值
  - Math.random() //取随机数；
  - Math.round(4.6); //四舍五入；

*2. 日期类*
  - Calendar类: 是一个抽象基类，主要用于完成日期字段之间相互操作的功能。既可以设置和获取数据的特定部分。
  - Calendar calendar = Calendar.getInstance();//创建对象
  - calendar.get(Calendar.MONTH);//获取指定的日期
  - calendar.add(Calendar.HOUR, 2);//获取时钟加两个小时
  - calendar.add(Calendar.MONTH, -2);//设置月份 减两个小时；
  - 格式化输出:
    - Date date = new Date();
    - SimpleDateFormat form = new SimpleDateFormat("yyyy-MM-dd EEE hh:mm:ss");
    - System.out.println(form.format(date));//格式输出
    - date.getTime();//获取当前时间
    - random类：　随机数
      - 创建一个新的随机数生成器
      - Random(long seed):使用单个long种子创建一个随机数生成器；
      - 如果用相同的种子创建两个Random实例，则对每个实例进行相同的
      　方法调用，他们将生成并返回相同的数字序列；
    - enum枚举类:
      - enum Color {
        RED, GREEN, BLUE;
      }

      public class EnumDemo {
        public static void main(String args) {
          Color c = Color.RED;
          System.out.println();
        }

        Color[] color = Color.values();
        for (int i=0; i < Color.length; i++) {
          System.out.println(color[**]);
        }
      }
  - 虚拟机
    - Runtime runtime = Runtime.getRuntime();
    - System.out.println(runtime.totalMemory() / 1024 / 1024);
    - System.out.println(runtime.maxMemory() / 1024 / 1024);

  - StringBuffer
    解释：　线程安全的可变字序列。一个类似String 的字符串缓冲区，
    　　但不能修改。　虽然在任意时间点上它都包含某种特定的字符序列。
　 　- buffer.append("123");  //追加字符
    - buffer.insert(2, '2'); //在索引位置　插入
    - buffer.toString(); //回归字符串
    - buffer.reverse(); //反转
    - buffer.delete(2, 6); //索引2 - 6删除；
    - splite() ; //方法的使用
      - String str = "sdljflsdakjfdlska";
        - String[] arr = str.splite("\\d+");
        - for (String e:arr) {
          System.out.println(e);
        }

  - String
    ①str1.equalsIgnoreCase(str2); // 不区分大小写；
    ②str1.compareTo(str2);           //相等返回0  包含返回正，不包含返回负；
    ③str1.comparetoIgnoreCase(str2)  //忽略大小写；
    ④str1.endWith(".mp3");//   检索文件中  以.mp3结束的文件；
    ⑤str1.startWith("abc");// 以abc开始的文件。
    ⑥str.substring(3);  //从0--3进行截取；
    ⑦str.substring(2,4);// 截取一段位置；
    ⑧str.concat("uyt");// 连接
    ⑨str.replace('c','a');//替换

 - 集合框架
 <Interface>ListIterator--------><Interface>Iterator

<class>ArrayList-------------><Interface>List----------------><Interface>Collection--------><Interface>Iterator

<class>LinkedList------------><Interface>List----------------><Interface>Collection--------><Interface>Iterator

<class>LinkedHashSet-------><class>HashSet---------------><Interface>Set-----------------><Interface>Collection

<class>TreeSet---------------><Interface>SortedSet<Interface>Set-----------------><Interface>Collection

<class>Properties------------><class>Hashtable---------><Interface>Map
<class>HashMap----------------><Interface>Map
<class>TreeMap----------------><Interface>SortMap------><Interface>Map

通过这个：继承关系图，明白他们之间的关系；
①Iterator接口
所有实现了Collection接口的集合类都有一个iterator()方法用以返回一个实现Iterator接口对象。
     例如：List<String>  list=new ArrayList<String>();  
    (接口的多态，接口通过子类引用，实现自己的抽象方法)
Iterator是专门的迭代输出接口。所谓的迭代输出就是将元素进行判断，判断是否有内容，
如果有内容则把内容取出。
    Iterator it=list.iterator();       //
    例如：while(it.hasNext()){  // list.hasNext()  返回为 布尔型；
        System.out.println(it.next());
方法：
  -boolean hasNext();//判断游标游标是否有元素。
  -Object next();//返回游标右边的元素 并将游标移到下一个位置。
  -void remove();//删除左边的元素；（很死板，只删除左边的元素，不移动）
(习惯：Iterator迭代器遍历集合)		}
②List接口
1、实现List接口的集合类中的元素是有序的，且允许重复。
2、List集合中的元素都存在索引。
方法：
  1、public Object get(int index)
    返回列表中的元素数；
  2、public Object add(int index,Object element);
    在列表的指定位置插入指定元素，将当前处于该位置的元素
    和所有后续元素向后移动。         ---------可以是：基本数据类型、boolean型、字符串
  3、public Object set(int index,Object element);
    用指定元素替换列表中指定位置的元素。
  4、public Object remove(int index);
    用于移除指定索引的元素；
③ArrayList类
特点：数组结构    优点：使用索引取出元素有较好的效率。
                  缺点：元素的插入、删除，效率低；

    例子：List<Class> list=new ArrayList<Class>();  //利用的就是接口借用子类实现
                              自己方法的多态；
      故：要实现List中 的方法，
        list.get(1);     //获取索引处的值；
        list.add(2,"d");//插入
        list.set(2,"d");//替换

④LinkedList类
特点：使用双向表实现的集合。   优点：便于插入或删除元素。

⑤Set接口
特点：实现Set接口的集合类的元素是不可重复  且  无序。 存、取、删除对象有很高的效率。
存放原理：根据每个对象的哈希码值（调用hashCode()获得）用固定
的算法算出它的存储索引，把每个对象放在一个叫散列表的相应位置。
--没有其他元素，就只需要直接存入。
--若该位置有了元素，会将新对象跟该位置的所有对象进行比较（调用equals()）,
   以查看是否已经存在。
--对于要存放到Set集合中的对象，对应的类一定要重写equals（）和hashCode（Object obj）
方法以实现对象相等规则。

  重写方式：
  public int hashCode(){
      int result=this.name.hashCode;   //  比较hashCode
      return result;
    }


    例如：class Dog{
      String name

      public Dog(String name){
        this.name=name;
      }

      public boolean equals(Object obj){
        if(this.name==((Dog)(obj)).name){
          return true;
        }else{
          return false;
        }
      }

    }


解释：在对于已经有的元素进行对比的时候，要先对比的是  hashCode  （哈希码）
当哈希码一样时，再通过equals比较 他们的内容，如果还是一眼，那就是相同。相同在set集合中不重复；

全部方法：
  ①boolean add();set.add("a");//添加元素；
  ②boolean contains();set.contains("d");//判断是否包含；
  ③set.size();//长度
  ④Object []obj=set.toArray();//  将集合变为数组；
    例子：
      Object obj[]=set.toArray();
      String str[]=new String[set.size()];
      for(int i=0;i<set.size;i++){
        str[i]=(String)obj[i];
      }
⑥HashSet接口
特点:不保存元素的加入顺序。根据哈希码进行存放，也可以通过哈希码快速找到。
Set<String> set=new HashSet<Set>();        （重写hashCode  和 equals 来进行保证不重复）

LinkedHashSet是其子类，   --特点：就是怎么输入，怎么输出；


⑦TreeSet接口
特点：元素必须是可“排序”的。<对于基本数据类型如：整型-存入后就给拍好序>

排序的方法有两种：
  ①构造一个新的空 set，该 set 根据其元素的自然顺序进行排序。
    插入该 set 的所有元素都必须实现 Comparable 接口。
    另外，所有这些元素都必须是可互相比较的：
    对于 set 中的任意两个元素 e1 和 e2，执行 e1.compareTo(e2)
    都不得抛出 ClassCastException。
  解释：Comparable
  让封装的类来实现 Comparable接口，然后重写 里面的方法
  public int compareTo(Dog o){           //括号里面写 类；
    if(this.age>o.age){
      return 1;  //大于返回 1；
    }else if(this.age<o.age){
      return -1;//小于返回 -1；
    }else{
      return 0;//相等；   则重复不输出；
      //  如果，还要 比较第二个属性；
    }

￥￥￥￥￥￥￥	注意： 如果是字符串比较要用：  compareTo()方法；
           ①返回  1 正序 排序；《1在前   -1在后》
           ②返回 -1 逆序 排序；《1在后   -1在前》
           ③有时候再：对第一个字段保证不重复时，我们要去除排序方法，然后用
      重写 hashCode 和equals 的方法来实现。
           ④hashSet是无序的利用散列表进行存储，
       TreeSet是红黑树（有序）。
           ⑤清楚：
      public boolean equals(Object obj) {
                        if(this.name.equals(((Dog)(obj)).name)){
                         return true;            //True是 有重复，则去除；
                          }else{
                      return false;
                        }
                        }
  }
                  ⑥顺一遍：
      HashSet中重写hashCode和equals 方法可以去除重复，
      但是不能排序，要想排序最好 用list.
      TreeSet中重写 comparable 因为它本身是有序，但是要 操控顺序则需要重写。
      还有就是：如果要保证某个字段不重复那就利用，hashCode equals 但不能有比较器。

  ②由于：使用Comparable接口定义排序顺序有局限性，实现此接口的类只能按照
    compareTo()定义的这一种方式排序。
    如果同一类对象要有多种排序方式，应该为该类定义不同的比较器。

  Comparator接口：
    Comparator接口中的比较方法：
      public int compare(Object a,Object b);
      1、如果返回0，表示 this==obj(元素相同)
      2、返回正数，表示this>object
      3、返回负数，表示this<obj
  TreeSet有个构造方法允许给定比较器，它就会给比较器对元素进行排序。
  例如：
    CatComparatorUp  cc=new CatComparatorUp();
    Set<Cat> set=new TreeSet<Cat>(cc);           ///排序；

⑧Collections类  该类是继承 Object类
该类有很多方法，但是从API中明显可以看出，很多方法是 静态方法。(括号里面写集合)
1、static void sort(List<T> list);  //根据元素的自然顺序对指定列表进行排序。
2、static void  swap(List<?> list,int i,int j)  指定位置处交换元素。
3、static void reverse(list<?> list)  //反转指定列表中元素的顺序。
4、static <T> boolean replaceAll(List<T> list,T oldVal T newVal)
    //使用另外一个值来替换列表中出现的所有某一个指定值。
 例如： Collections.sort(list);
5、static void shuffle(list)  ;打乱顺序；

⑨Map接口
Map接口的集合类用来存储“键-值”映射对。
JDK API 中Map接口 的实现类常用的有
①--HashMap  首先可以从结构图中看出，它是一个继承于Map接口的类，自然可以通过
  接口的多态   Map<String,Integer> map=new HashMap<String,Integer>();

  这样，map就可以调用 Map接口中的方法。
方法：
  1、Object put(Object key,Object value);// 将指定的“键-值”对存入Map中。
  2、Object get(Object key);//返回指定键所映射的值。
  3、Object remove(Object key);//根据指定的键把 “键-值” 对Map中移除。
  4、boolean containsKey(Object key);//判断Map是否包含指定  键-值。
  5、boolean containsKay(Object value);//
  6、boolean isEmpty();//  判断此Map中是否有元素。
  7、int size();  //获得些 Map数量。
  8、void clear();//  清空。

特点：
  HashMap内部对“键” 用Set进行散列存放。（自然在 API Map 接口中一个 方法 .entrySet()
    返回一个set集合视图--用于保证键唯一）￥￥￥
    HashMap的值是没有顺序的，它是按照key的HashCode来实现的￥￥￥￥
  例子：
    Set<Map.Entry<String,String>> set=map.entrySet();

    Iterator<Map.Entry<String,String>> it=set.iterator();
    while(it.hashNext()){
      Map.Entry<String,String> entry=it.next(); //把遍历的键值对给 map;
    }
②--Map.Entry<K,V>   // Map.Entry对象仅在迭代期间有效；确切的说，如果在迭代器返回项之后
  修改了底层映射，则某些映射行为是不确定的。

方法：
  1、boolean equals(Object o)  //比较指定对象与此项的相等性。
  2、entry.getKey();//返回 与此项对应的键、
  3、entry.getValue();//返回此项对应的值、
  4、hashCode返回此映射项的哈希码
  5、setValue(V value)  //用指定的值替代与此对应的值。

③TreeMap
  内部使用红黑树结构 key  进行排序存放，所以放入TreeMap中的“Key-value”
  对的 key  必须是可 “排序” 的；（默认是升序）
  根据其键的自然顺序《TreeSet也是》进行排序，或者根据创建映射时提供的 Comparator 进行排序！￥￥￥￥￥￥
④Hashtable  操作和HashMap相同，只是它保证 线程同步。

  在Hashtable中有一个子类Properties
    此类，表示了一个持久的属性集。Properties可保存在流中或从流中加载。
    属性集中每个键及其对应值都是一个字符串。
    但是，不支持泛型操作。
    Properties对象应用put和putAll方法（不应使用）要使用；
    1、getProperty(String key)  用指定的键在此属性表中搜素属性。
    2、getProperty(String key,String defaultValue)用指定的键在属性列表中搜索属性。
    3、load(InputStream inStream)  //从输入流中读取属性列表。
    4、setProperty(String key,String value)  //调用Hashtable的方法put.强制要求为属性的键和值使用字符串
    5、store（outputStreaM out,String comments）//以适合使用load（InputStream）
      方法加载到Properties表中的格式。将此Properties表中的属性列表写入输出流。

⑩解释 泛型；
-在定义集合时，指定集合存储对象的数据类型。
优点：1、简化集合的使用。
      2、增强代码的可读性和稳定性。

11、
栈：Stack   先进后出  方法就是： stack.push();      stack.pop();
队列：	Queue  先进先出；方法：  

File类的常用方法：
①boolean canRead()  、canWrite()、  是否可以 读写；
②boolean createNewFile()、当不存在时，创建一个新的空文件。
③boolean delete()   删除文件或目录。
④boolean exists()    测试是否存在。
⑤long  length()   返回此抽象路径名表示的文件长度。
⑥String toString()   返回此抽象路径名字符串。
⑦String list()   返回一个字符串数组。
⑧File[] listFiles()  返回抽象路径名数组。
⑨boolean isDirectory()  判断文件是否存在。
⑩public File[] listFiles(FilenameFilter filter)
  应用举例：
    class FilterDemo implements FilenameFilter{       //实现 接口用于过滤文件名
      public boolean accept(File dir,String name){
        if(name.endWith(".mp3")){
          return true;
        }else{
          return false;
        }
      }
    }
    //在主函数中写
    File[] files=file.listFiles(new FilterDemo());
    for(){}// 写增强for循环；

 两个重要：实例
 1、深度遍历文件（利用递归）
 class demo{
public static void main(String args[]){
  File file=new File("E:\\word.txt");
  listDemo(file,0);
}

public static void listDemo(File file,int level){
  File []f=file.listFiles();
  System.out.println(getSpace(level)+file.getName());
  level++;
  for(int i=0;i<f.length;i++){
    if(fe.isDirectory()){
      listDemo(fi[i],level);
    }else{
      System.out.println(getSpace(level)+fi[i].getName(););
    }
  }
}

public static String getSpace(int level){
  StringBuffer stringBuffer=new StringBuffer();
  for(int i=0;i<level;i++){
    stringBuffer.append("   ");
  }
  return stringBuffer.toString();
}
 }

 2、深度删除；
class DeleteDemo{
  public static void main(String args[]){
    File file=new File("E:\\word");

    deleteMethod();
  }

  public static void deleteMethod(File file){
    File []fi=file.listFiles();
    for(File f:fi){
      if(f.isDirectory()){
        deleteMethod(f);
      }else{
        f.delete();
      }
    }

    file.delete();//  删除根目录；
  }

}
￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥I/O流￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥

IO流用于处理设备之间的数据传输；
java对数据的操作就是对流的操作。
①按流向分：  输入流（InputStream）、输出流(OutputStream)。
②按操作数据分：字节流和字符流。
框架：
字节流<字节流读取的是 一个字节  自然用 byte[]>
      FileInputStream extends InputStream(abstract)

FileOutputStream extends OutputStream (abstract)

DataInputStream   extends FilterInputStream  extends InputStream(abstract)
DataOutputStream  extends FilterOutputStream extends OutputStream(abstract)

BufferedInputStream extends FilterInputStream
BufferedOutputStream extends FilterOutputStream

字符流<字符流 读取的是 两个字节，自然用的是 char[]>
FileReader  extends InputStreamReader  extends Reader (abstract)
FileWriter  extends OutputStreamWriter extends Writer(abstract)

BufferedReader extends Reader(abstract)
BufferedWriter extends Writer(abstract)

①InputStream  抽象类   
方法：1、read(byte[] b)从输入流中读取一定数量的字节，并将其存储在缓冲区数组b中。
         read(byte[] b,int off,int len)  最多len个数据字节读入byte数组。

①FileInputStream 类（输入流）

理解一个，模式：
            FileOutputStream(输出流)------->writer写入文件。
user    s<--------------------    （流）   --------------------->   文件
            读取文件reader()        （输入流）FileInputStream
      从文件中读取数据到流，再读取给用户；



方法：
  1、int read()  从输入流中将最多b.length个字节的数据读入一个byte数组。
  2、int read(byte b)
    从此输入流中将最多b.length个字节的数据读入一个byte数组中。
  3、int read(byte[] b,int off,int len)
    从此输入流中将最多len个字节的数据读入一个byte数组中。


     ②FileOutputStream类（输入流）
  1、构造器：
    FileOutStream(File file,boolean append)
       如果你想文件不会被覆盖，写true;
  2、方法
  ①void write(byte[] b)   将b.length个字节指定byte数组写入次文件中。
    void write(byte[] b,int off,int len)
         将指定byte数组中从偏移量off开始len字节写入此文件输出流。
    void  write(int  b)将指定字节写入此文件输出流。
￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥ ￥￥￥￥￥￥￥￥￥￥￥￥￥￥
实例总结：
class Demo{
public static void main(String args[]){
  File file=new File("world.txt");
  InputStream input=null;
  OutputStream output=null;

  input=new FileInputStream(file);
  output=new FileOutputStream(file);

  byte by[]="".getBytes();  //  通过字符串的.getBytes()方法把把字符串变为字节数组。
  output.write(by);  //  写入字节数组，切记：不能写入 字符串。
        //output.write(by,0,len);  指定部分写入。
  byte bys[]=new byte[10];//  指定读取的部分。
  int len=0;             //因为read()方法返回的是整型，它用于接收整型。
  while((len=input.read(bys))!=-1){
    String str=new String(bys,0,len);  // 读取难免要用循环。
  }                                          // 读的方法里面包括，部分的读取.read(bys,0,len)
            //还有一个方法：available();有效读取。
}
}

￥￥￥￥￥￥￥￥￥￥￥￥￥￥
②Reader 抽象类
继承Reader的流都是用于向程序输入数据的，且数据的单位为字符（16位），红色为节点流，
蓝色为过滤流。
方法：
  ①-public int read() throws IOEexception
    *读取单个字符，返回作为整数读取的字符，如果已经到达流的末尾返回-1.
  ②-public int read(char[] cbuf)throws IOException
    将字符读入数组返回 读取的字符数。
  ③-public abstract int read(char[] chuf,int off,int len) throws IOException
    将取len个字符的数据，并从数组cbuf的off位置开始写入到这个数组中。
  ④-pubic abstract void close() throws IOExcepiton
    关闭该流并释放与之关联的所有资源
  ⑤-public long skip(long n) throws IOException
    跳过n个字符；
③Writer抽象类
继承自Writer的流是程序用于向外输出数据的，且数据的单位为字符（16位）
方法：
  ①-public void write(int c) throws IOException
    写入单个字符。
    -public void write(char[] cbuf) throws IOException
    写入字符数组。
    -public abstract void write(char[] cbuf,int off,int len) throws IOException
          写入字符数组一部分。
    -public void write(String str) throws IOException
    写入字符串、
    -public void write(String str,int off,int len) throws IOException
    写字符串的某一部分。
    -close();
    -flush();
￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥ ￥￥￥￥￥￥￥￥￥￥￥￥￥￥
实例总结：
class Demo{
  public static void main(String args[]){
    File file=new File("work.txt");
    Reader reader=null;  // 初始化；
    Writer writer=null;  //初始化；

    try{
      reader=new FileReader();//  抽象类的多态； 读
      writer=new FileWriter();//  抽象类的多态；  写
      char ch[]={'a','c'};   //字符数组；
      writer.write("");//写入可以是字符串，单个字符；		
      writer.write("",1,1);  //部分写入；
      char ch[]=new char[1024];// 一次读取的大小；
      int len=0;
      while((len=reader.read(ch))!=-1){           //因为read()返回值是int型；
        String str=new String(ch,0,len);   // 控制一次读的大小。
        System.out.println(str);          //控制台输出；
      }

    }catch(){

    }finally{

    }
  }
}


￥￥￥￥￥￥￥￥￥￥￥￥￥￥

缓冲流：          <字符缓冲流   字节缓冲流>
￥建立在相应的节点流之上，对读写数据提供了缓冲的功能，提高了读写的效率。
四种缓冲流：
  -BufferedInputStream可以对任何的InputStream流进行包装。
  -BufferedOutputStream可以对任何的OutputStream流进行包装。
-----------------------------------------------------------------------
  -BufferedReader可以对任何的Reader流进行包装
    -readLine()方法用于一次读取一行字符串。
  -BufferedWriter可以对任何的Writer流进行包装。
    -newLine()方法用于写入一行分隔符。
注意：
  ①对于缓冲输出流，写出的数据会先缓冲在内存缓冲区中，关闭此流前要用
  flush（）方法将缓存区的数据立刻写出。
  ②关闭过滤流时，会自动关闭过滤流所包装的所有的底层流。
￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥ ￥￥￥￥￥￥￥￥￥￥￥￥￥￥
实例总结：
（字节缓冲流）（写缓冲流，必须要先写流）
class Demo{
  File file=new File("world.txt");
  InputStream input=null;
  OutputStream output=null;

  BufferedOutputStream bos=null;
  BufferedInputStream bis=null;

  input=new FileInputStream(file);
  output=new FileOutputStream(file);

  bos=new BufferedOutputStream(input);
  bis=new BufferedInputStream(output);

  byte by[]="I am a teacher".getBytes();
  write(str);     //和字节流的输入方式一致。

  byte by[]=new byte[1024];
  int len=0;
  while((len=bis.read(by))!=-1){
    System.out.println((char)len);   // 循环式 有长度式读取。
  }

  //  特殊的方法：  bis.mark(2);  做标记， 然后bis.reset(); 从标记处开始读。
}


字符缓冲流
class Demo{
  public static void main(String args[]){
    File file=new File("world.txt");
    Reader reader=null;
    Writer writer=null;

    BufferedReader br=null;
    BufferedWriter bw=null;

    reader=new FileReader(file);
    writer=new FileWriter(file);

    br=new BufferedReader(reader);
    bw=new BufferedWriter(writer);

    String line=null;   // 注意： br.read();  返回的是 String类型；
    while((line=br.readLine())!=null){  //  最大特点：   按行读；还具有缓冲流的特点标记，重置；
      System.out.println(line);
    }

    bw.newLine();//  换行；  新特点；
    bw.write(String s,int off,int len);  //  写入字符串的部分；
    bw.write(char[] chub,int off,int len);// 写入字符的部分。

  }
}

￥￥￥￥￥￥￥￥￥￥￥￥￥￥

  转化流：
在IO包中，实际上就是分为字节流和字符流，但是除了这两个流之外，
还存在一组字节流-字符流的转换。
--InputStreamReader:
  是Reader的子类，将输入的字节流变为字符流，即：将一个字节流的输入对象变为字符流
  的输入对象。
  --InputStreamReader  需要和InputStream 套接  ，它可以将字节流中读入的字节码变成字符。

--OutputStreamWriter

￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥￥ ￥￥￥￥￥￥￥￥￥￥￥￥￥￥
实例总结：
class Demo{
  public static void main(String args[]){
    InputStream is=null;
    OutputStream out=null;

    InputStreamReader isr=null;
    OutputStreamWriter osw=null;

    is=new FileInputStream(file);
    isw=new InputStreamReader(in);      //输入字节流-->输入字符流

    out=new FileOutputStream(file);
    osw=new OutputStreamWriter(out);  // 输出字节流->输出字符流

    osw.write(“ ”);//  方法类似于 字符流；  可以写字符串；

    char buf[]=new char[is.available()];    //  读取；  类似字符流
    int len=isr.read(buf);
    System.out.println(new String(buf,0,len));
  }
}

￥￥￥￥￥￥￥￥￥￥￥￥￥￥


内存流：
例图：
  数据-->ByteArrayInputStream-->内存         --读入内存
  数据<--ByteArrayOutputStream<--内存        --读出内存
实例：
  模拟：从网络上下载图片，给定图片，先写入内存，然后再读到磁盘。
class Demo{
  public static void main(String args[]){
    File files=new File("E://aa.jpg");
    File file=new File("F:bb.jpg");

    FileInputStream fis=null;
    OutputStream out=null;

    ByteArrayOutputStream baos=new ByteArrayOutputStream();
    try{
      fis=new FileInputStream(files);
      byte by[]=new byte[1024];

      int len=0;
      while((len=fis.read(by))!=-1){          //读取文件
        baos.write(by,0,len);         // 把文件写入内存；
      }
      baos.flush();

      ByteArrayInputStream bais=new ByteArrayInputStream(baos.toByteArray());  //获取整个字节；

      //放到磁盘
      out =new FileOutputStream(file);
      byte b[]=new byte[1024];
      int n=0;
      while((n=bais.read(b))!=-1){         //从内存中读取；
        out.write(b,0,n);        //然后写入磁盘
      }

      out.fush();
      Sysetem.out.println("OK");
    }
  }
}


Object流
JDK提供的ObjectOutputStream 和ObjectInputStream 类是用于存储和读取基本
数据类型或对象的过滤流。
-ObjectOutputStream类保存基本数据那类型或对象的机制叫序列化。
-ObjectOutputStream类读取基本数据类型会对象的机制叫 反序列化。

能被序列化的对象所对应的类必须实行Serializable这个标识型接口。

实例：
  class{

    public static void main(String args[]){
      File file=new File("world.txt");
      ObjectOutputStream oos=null;
      OutputStream out=null;

      Stu stu=null;

      stu.setName("cao");
      stu.setAge(10);
      stu.getName();
      stu.getAge();

      try{
        out=new FileOutputStream(File);
        oos=new ObjectOutputStream(out);

        oos.writeObject(stu);
        oos.flush();
      }
    }
  }
☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺
线程：Thread.   主要两个静态方法，三个常用方法；
☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺☺

最重要一周： 网络、解析；
1、数据要发送到指定的应用程序上。为了标识这些应用程序，所以给这些网络应用
程序都用数字进行标识。为方便称呼这个数字，叫做 端口。逻辑端口。

2、定义通信规则。这个通讯规则称为协议。TCP/IP

127.0.0。1 表示本机；
具体：
  UDP  
将数据及源和目的封装成数据包，不需要建立连接
每个数据报的大小在限制在64k内
因无连接，是不可靠协议。
不需要建立连接，速度快。
  TCP
建立连接，形成传输数据的通道。
在连接汇总进行大数据量 传输
通过三次握手完成连接，是可靠协议
必须建立连接，效率稍低。


 Socket  编程：
Socket就是为网络服务提供的一种机制。
通信的两端都有 Socket
网络通信其实就是Socket间的通信。
数据在两个Socket 间通过IO传输。


Socket  要记住流程；
/*
需求：通过UDP传输方式，将一段文字数据发送出去。
1、建立udpsocket服务
2、提供数据，并将数据封装到数据包中。
3、通过socket服务的发送功能，将数据包发送出去。
4、关闭资源。
*/

*/
public static void main(String args[]){
//1、创建udp服务。通过DataSocket对象
DatagramSocket data=new DatagramSocket();
//2、提供数据,封装成包
byte []data="".getBytes();
DatagramPacket dpn=new DatagramPacket(buf,buf.length,Address.getByName(ip),100000(端口));// 注意参数
//3、通过socket服务，将已有的数据包发送出去。
data.send(dp);//发送；
//4、关闭资源
data.close();2016/3/19
接收端没开；
(数据丢失)

}
/*

/*
服务端
1、建立服务端的socket服务，ServerSocket
并监听一个端口。
2、获取连接过来的客户端对象，通过ServerSocket 的accept方法
没有连接就会等，所以这个方法是阻塞式的。
3、客户端如果发过来数据，那么入伍端要使用对应的客户端对象的读取
发过来的数据。并打印在控制台。
4、关闭服务器。（可选）

class TcpServer{

public static void main(String args[]){
  //建立服务端Socket 服务，并监听一个端口
  Socket s=ss.accept();
  String ip=s.getInetAddress().getHostAddress();
  System.out.println(ip+",,,,,,,,,,,,,,,,,,");
  //获取客户端发送过来的数据，那么服务端要使用客户端的读取流来读取数据
  InputStream in=s.getInputStream();
  byte[] buf=new byte[1024];
  int len=in.read(buf);
  s.close();         //关闭客户端；
  ss.close();
}
}
*/
客户端
1、建立socket服务。指定要连接主句和端口
2、获取socket流中的输出流。将数据写到该流中，通过网络发送给服务器、
3、获取socket流中的输入流，将服务端反馈的数据获取到，并打印。
4、关闭客户端。

class TcpClient{

public static void main(String args[]){
  Socket s=new Socket("",10004);
  OutputStream out=s.getOutputStream();
  out.write("".getBytes());

  InputStream in=s.getInputStream();
  byte[] buf=new byte[1024];
  int len=in.read(buf);
  System.out.println(new String (buf,0,len));
  s.close();
}

***
#### 分析HashMap
***
１．HashMap的本质: 1个存储Entry类对象的数组　＋　多个单链表；
２．Ｅntry对象本质=１个映射(键－值对)，属性包括: 键(key) 值(values) 点(next)=单链表的指针= 也是一个Entry对象，用于解决hash冲突；

** 该类的源码分析　**
```
/**
 * Entry类实现了Map.Entry接口
 * 即 实现了getKey()、getValue()、equals(Object o)和hashCode()等方法
**/  
static class Entry<K,V> implements Map.Entry<K,V> {
    final K key;  // 键
    V value;  // 值
    Entry<K,V> next; // 指向下一个节点 ，也是一个Entry对象，从而形成解决hash冲突的单链表
    int hash;  // hash值

    /**
     * 构造方法，创建一个Entry
     * 参数：哈希值h，键值k，值v、下一个节点n
     */  
    Entry(int h, K k, V v, Entry<K,V> n) {  
        value = v;  
        next = n;  
        key = k;  
        hash = h;  
    }  

    // 返回 与 此项 对应的键
    public final K getKey() {  
        return key;  
    }  

    // 返回 与 此项 对应的值
    public final V getValue() {  
        return value;  
    }  

    public final V setValue(V newValue) {  
        V oldValue = value;  
        value = newValue;  
        return oldValue;  
    }  

   /**
     * equals（）
     * 作用：判断2个Entry是否相等，必须key和value都相等，才返回true  
     */
      public final boolean equals(Object o) {  
        if (!(o instanceof Map.Entry))  
            return false;  
        Map.Entry e = (Map.Entry)o;  
        Object k1 = getKey();  
        Object k2 = e.getKey();  
        if (k1 == k2 || (k1 != null && k1.equals(k2))) {  
            Object v1 = getValue();  
            Object v2 = e.getValue();  
            if (v1 == v2 || (v1 != null && v1.equals(v2)))  
                return true;  
        }  
        return false;  
    }  

    /**
     * hashCode（）
     */
    public final int hashCode() {
        return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());  
    }  

    public final String toString() {  
        return getKey() + "=" + getValue();  
    }  

    /**
     * 当向HashMap中添加元素时，即调用put(k,v)时，
     * 对已经在HashMap中k位置进行v的覆盖时，会调用此方法
     * 此处没做任何处理
     */  
    void recordAccess(HashMap<K,V> m) {  
    }  

    /**
     * 当从HashMap中删除了一个Entry时，会调用该函数
     * 此处没做任何处理
     */  
    void recordRemoval(HashMap<K,V> m) {  
    }

}

```
** 源码具体分析**
```
/**
  * 函数使用原型
  */
  Map<String,Integer> map = new HashMap<String,Integer>();

 /**
   * 源码分析：主要是HashMap的构造函数 = 4个
   * 仅贴出关于HashMap构造函数的源码
   */
  public class HashMap<K,V>
      extends AbstractMap<K,V>
      implements Map<K,V>, Cloneable, Serializable{

    // 省略上节阐述的参数

  /**
     * 构造函数1：默认构造函数（无参）
     * 加载因子 & 容量 = 默认 = 0.75、16
     */
    public HashMap() {
        // 实际上是调用构造函数3：指定“容量大小”和“加载因子”的构造函数
        // 传入的指定容量 & 加载因子 = 默认
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_LOAD_FACTOR);
    }

    /**
     * 构造函数2：指定“容量大小”的构造函数
     * 加载因子 = 默认 = 0.75 、容量 = 指定大小
     */
    public HashMap(int initialCapacity) {
        // 实际上是调用指定“容量大小”和“加载因子”的构造函数
        // 只是在传入的加载因子参数 = 默认加载因子
        this(initialCapacity, DEFAULT_LOAD_FACTOR);

    }

    /**
     * 构造函数3：指定“容量大小”和“加载因子”的构造函数
     * 加载因子 & 容量 = 自己指定
     */
    public HashMap(int initialCapacity, float loadFactor) {

        // HashMap的最大容量只能是MAXIMUM_CAPACITY，哪怕传入的 > 最大容量
        if (initialCapacity > MAXIMUM_CAPACITY)
            initialCapacity = MAXIMUM_CAPACITY;

        // 设置 加载因子
        this.loadFactor = loadFactor;
        // 设置 扩容阈值 = 初始容量
        // 注：此处不是真正的阈值，是为了扩展table，该阈值后面会重新计算，下面会详细讲解  
        threshold = initialCapacity;   

        init(); // 一个空方法用于未来的子对象扩展
    }

    /**
     * 构造函数4：包含“子Map”的构造函数
     * 即 构造出来的HashMap包含传入Map的映射关系
     * 加载因子 & 容量 = 默认
     */

    public HashMap(Map<? extends K, ? extends V> m) {

        // 设置容量大小 & 加载因子 = 默认
        this(Math.max((int) (m.size() / DEFAULT_LOAD_FACTOR) + 1,
                DEFAULT_INITIAL_CAPACITY), DEFAULT_LOAD_FACTOR);

        // 该方法用于初始化 数组 & 阈值，下面会详细说明
        inflateTable(threshold);

        // 将传入的子Map中的全部元素逐个添加到HashMap中
        putAllForCreate(m);
    }
}

```
***
```
/**
  * 函数使用原型
  */
  map.put("Android", 1);
       map.put("Java", 2);
       map.put("iOS", 3);
       map.put("数据挖掘", 4);
       map.put("产品经理", 5);

  /**
    * 源码分析：主要分析： HashMap的put函数
    */
   public V put(K key, V value)
（分析1）// 1. 若 哈希表未初始化（即 table为空)
       // 则使用 构造函数时设置的阈值(即初始容量) 初始化 数组table  
       if (table == EMPTY_TABLE) {
       inflateTable(threshold);
   }  
       // 2. 判断key是否为空值null
（分析2）// 2.1 若key == null，则将该键-值 存放到数组table 中的第1个位置，即table [0]
       // （本质：key = Null时，hash值 = 0，故存放到table[0]中）
       // 该位置永远只有1个value，新传进来的value会覆盖旧的value
       if (key == null)
           return putForNullKey(value);

（分析3） // 2.2 若 key ≠ null，则计算存放数组 table 中的位置（下标、索引）
       // a. 根据键值key计算hash值
       int hash = hash(key);
       // b. 根据hash值 最终获得 key对应存放的数组Table中位置
       int i = indexFor(hash, table.length);

       // 3. 判断该key对应的值是否已存在（通过遍历 以该数组元素为头结点的链表 逐个判断）
       for (Entry<K,V> e = table[i]; e != null; e = e.next) {
           Object k;
（分析4）// 3.1 若该key已存在（即 key-value已存在 ），则用 新value 替换 旧value
           if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
               V oldValue = e.value;
               e.value = value;
               e.recordAccess(this);
               return oldValue; //并返回旧的value
           }
       }

       modCount++;

（分析5）// 3.2 若 该key不存在，则将“key-value”添加到table中
       addEntry(hash, key, value, i);
       return null;
   }

```
**初始化哈希表**
```
/**
  * 函数使用原型
  */
   if (table == EMPTY_TABLE) {
     inflateTable(threshold);
 }  

/**
  * 源码分析：inflateTable(threshold);
  */
  private void inflateTable(int toSize) {  

 // 1. 将传入的容量大小转化为：>传入容量大小的最小的2的次幂
 // 即如果传入的是容量大小是19，那么转化后，初始化容量大小为32（即2的5次幂）
 int capacity = roundUpToPowerOf2(toSize);->>分析1   

 // 2. 重新计算阈值 threshold = 容量 * 加载因子  
 threshold = (int) Math.min(capacity * loadFactor, MAXIMUM_CAPACITY + 1);  

 // 3. 使用计算后的初始容量（已经是2的次幂） 初始化数组table（作为数组长度）
 // 即 哈希表的容量大小 = 数组大小（长度）
 table = new Entry[capacity]; //用该容量初始化table  

 initHashSeedAsNeeded(capacity);  
}  

 /**
  * 分析1：roundUpToPowerOf2(toSize)
  * 作用：将传入的容量大小转化为：>传入容量大小的最小的2的幂
  * 特别注意：容量大小必须为2的幂，该原因在下面的讲解会详细分析
  */

  private static int roundUpToPowerOf2(int number) {  

    //若 容量超过了最大值，初始化容量设置为最大值 ；否则，设置为：>传入容量大小的最小的2的次幂
    return number >= MAXIMUM_CAPACITY  ?
         MAXIMUM_CAPACITY  : (number > 1) ? Integer.highestOneBit((number - 1) << 1) : 1;  

```
**问题**
***
1. 为什么不直接采用经过hashCode（）处理的哈希码作为
存储数组table的下标位置？
  - 答: 容易出现　哈希码　与　数组大小范围不匹配。

2. 为什么采用哈希码　与　运算& (数组长度-1) 计算数组下标？
  - 根据HashMap的容量大小, 按需取　哈希码一定数量的低位　作为存储的数组下标位置，从而解决哈希码与数组大小范围不匹配的为题；

3. 若对应的key已经存在，则使用新value 替换　旧　value;
  - 答: 当发生Hash冲突时，　为了保证key的唯一性哈希表并不会马上在链表中插入新数据，而是先查找key 是否已存在，若已存在，则提花即可：

```
/**
  * 函数使用原型
  */
// 2. 判断该key对应的值是否已存在（通过遍历 以该数组元素为头结点的链表 逐个判断）
     for (Entry<K,V> e = table[i]; e != null; e = e.next) {
         Object k;
         // 2.1 若该key已存在（即 key-value已存在 ），则用 新value 替换 旧value
         if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
             V oldValue = e.value;
             e.value = value;
             e.recordAccess(this);
             return oldValue; //并返回旧的value
         }
     }

     modCount++;

     // 2.2 若 该key不存在，则将“key-value”添加到table中
     addEntry(hash, key, value, i);
     return null;
```
**从HashMap中获取数据**
***
```
/**
   * 函数原型
   * 作用：根据键key，向HashMap获取对应的值
   */
   map.get(key)；


 /**
   * 源码分析
   */
   public V get(Object key) {  

    // 1. 当key == null时，则到 以哈希表数组中的第1个元素（即table[0]）为头结点的链表去寻找对应 key == null的键
    if (key == null)  
        return getForNullKey(); --> 分析1

    // 2. 当key ≠ null时，去获得对应值 -->分析2
    Entry<K,V> entry = getEntry(key);

    return null == entry ? null : entry.getValue();  
}  


 /**
   * 分析1：getForNullKey()
   * 作用：当key == null时，则到 以哈希表数组中的第1个元素（即table[0]）为头结点的链表去寻找对应 key == null的键
   */
private V getForNullKey() {  

    if (size == 0) {  
        return null;  
    }  

    // 遍历以table[0]为头结点的链表，寻找 key==null 对应的值
    for (Entry<K,V> e = table[0]; e != null; e = e.next) {  

        // 从table[0]中取key==null的value值
        if (e.key == null)  
            return e.value;
    }  
    return null;  
}  

 /**
   * 分析2：getEntry(key)
   * 作用：当key ≠ null时，去获得对应值
   */  
final Entry<K,V> getEntry(Object key) {  

    if (size == 0) {  
        return null;  
    }  

    // 1. 根据key值，通过hash（）计算出对应的hash值
    int hash = (key == null) ? 0 : hash(key);  

    // 2. 根据hash值计算出对应的数组下标
    // 3. 遍历 以该数组下标的数组元素为头结点的链表所有节点，寻找该key对应的值
    for (Entry<K,V> e = table[indexFor(hash, table.length)];  e != null;  e = e.next) {  

        Object k;  
        // 若 hash值 & key 相等，则证明该Entry = 我们要的键值对
        // 通过equals（）判断key是否相等
        if (e.hash == hash &&  
            ((k = e.key) == key || (key != null && key.equals(k))))  
            return e;  
    }  
    return null;  
}  

```

**其他操作**
***
```
void clear(); // 清除哈希表中的所有键值对
int size();  // 返回哈希表中所有 键值对的数量 = 数组中的键值对 + 链表中的键值对
boolean isEmpty(); // 判断HashMap是否为空；size == 0时 表示为 空

void putAll(Map<? extends K, ? extends V> m);  // 将指定Map中的键值对 复制到 此Map中
V remove(Object key);  // 删除该键值对

boolean containsKey(Object key); // 判断是否存在该键的键值对；是 则返回true
boolean containsValue(Object value);  // 判断是否存在该值的键值对；是 则返回true

```

**源码**
```
/**
 * 函数：isEmpty()
 * 作用：判断HashMap是否为空，即无键值对；size == 0时 表示为 空
 */

public boolean isEmpty() {  
  return size == 0;  
}

/**
 * 函数：size()
 * 作用：返回哈希表中所有 键值对的数量 = 数组中的键值对 + 链表中的键值对
 */

 public int size() {  
  return size;  
}  

/**
 * 函数：clear()
 * 作用：清空哈希表，即删除所有键值对
 * 原理：将数组table中存储的Entry全部置为null、size置为0
 */
public void clear() {  
  modCount++;  
  Arrays.fill(table, null);
  size = 0;
}  

/**
 * 函数：putAll(Map<? extends K, ? extends V> m)
 * 作用：将指定Map中的键值对 复制到 此Map中
 * 原理：类似Put函数
 */

  public void putAll(Map<? extends K, ? extends V> m) {  
  // 1. 统计需复制多少个键值对  
  int numKeysToBeAdded = m.size();  
  if (numKeysToBeAdded == 0)  
      return;

  // 2. 若table还没初始化，先用刚刚统计的复制数去初始化table  
  if (table == EMPTY_TABLE) {  
      inflateTable((int) Math.max(numKeysToBeAdded * loadFactor, threshold));  
  }  

  // 3. 若需复制的数目 > 阈值，则需先扩容
  if (numKeysToBeAdded > threshold) {  
      int targetCapacity = (int)(numKeysToBeAdded / loadFactor + 1);  
      if (targetCapacity > MAXIMUM_CAPACITY)  
          targetCapacity = MAXIMUM_CAPACITY;  
      int newCapacity = table.length;  
      while (newCapacity < targetCapacity)  
          newCapacity <<= 1;  
      if (newCapacity > table.length)  
          resize(newCapacity);  
  }  
  // 4. 开始复制（实际上不断调用Put函数插入）  
  for (Map.Entry<? extends K, ? extends V> e : m.entrySet())  
      put(e.getKey(), e.getValue());
}  

/**
 * 函数：remove(Object key)
 * 作用：删除该键值对
 */

public V remove(Object key) {  
  Entry<K,V> e = removeEntryForKey(key);  
  return (e == null ? null : e.value);  
}  

final Entry<K,V> removeEntryForKey(Object key) {  
  if (size == 0) {  
      return null;  
  }  
  // 1. 计算hash值
  int hash = (key == null) ? 0 : hash(key);  
  // 2. 计算存储的数组下标位置
  int i = indexFor(hash, table.length);  
  Entry<K,V> prev = table[i];  
  Entry<K,V> e = prev;  

  while (e != null) {  
      Entry<K,V> next = e.next;  
      Object k;  
      if (e.hash == hash &&  
          ((k = e.key) == key || (key != null && key.equals(k)))) {  
          modCount++;  
          size--;
          // 若删除的是table数组中的元素（即链表的头结点）
          // 则删除操作 = 将头结点的next引用存入table[i]中  
          if (prev == e)
              table[i] = next;

          //否则 将以table[i]为头结点的链表中，当前Entry的前1个Entry中的next 设置为 当前Entry的next（即删除当前Entry = 直接跳过当前Entry）
          else  
              prev.next = next;   
          e.recordRemoval(this);  
          return e;  
      }  
      prev = e;  
      e = next;  
  }  

  return e;  
}

/**
 * 函数：containsKey(Object key)
 * 作用：判断是否存在该键的键值对；是 则返回true
 * 原理：调用get（），判断是否为Null
 */
 public boolean containsKey(Object key) {  
  return getEntry(key) != null;
}

/**
 * 函数：containsValue(Object value)
 * 作用：判断是否存在该值的键值对；是 则返回true
 */   
public boolean containsValue(Object value) {  
  // 若value为空，则调用containsNullValue()  
  if (value == null)
      return containsNullValue();  

  // 若value不为空，则遍历链表中的每个Entry，通过equals（）比较values 判断是否存在
  Entry[] tab = table;
  for (int i = 0; i < tab.length ; i++)  
      for (Entry e = tab[i] ; e != null ; e = e.next)  
          if (value.equals(e.value))
              return true;//返回true  
  return false;  
}  

// value为空时调用的方法  
private boolean containsNullValue() {  
  Entry[] tab = table;  
  for (int i = 0; i < tab.length ; i++)  
      for (Entry e = tab[i] ; e != null ; e = e.next)  
          if (e.value == null)
              return true;  
  return false;  
}


```
