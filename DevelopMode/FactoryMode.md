## 工厂模式
### 简单介绍
  - 1. 工厂就是生产各种产品；--> interface FactoryBMW
  - 2. 产品都源于一个模型;   --> BMW
  - 3. 工厂中含有创建模型的方法; --> createBMW()
  - 4. 各种产品都自己的特点;  --> FactoryBMW220
##
abstract class BMW {
    public BMW() {

    }
}

public class BMW220 extends BMW {
    public BMW220 () {
       System.out.println("-----"); 
    }
}


interface FactoryBMW {
    BMW createBMW();
}

public class FactoryBMW320 implements FactoryBMW{

    @Override
    public BMW320 createBMW() {
        return new BMW320();
    }
}

public class FactoryBMW532 implements FactoryBMW {
    @Override
    public BMW523 createBMW() {
        return new BMW532();
    }
}

public class client {
    public static void main(String args[]) {
        FactoryBMW220 factoryBMW = new FactoryBMW220();
        BMW220 bmw = FactoryBMW.createBMW();
    }
}
