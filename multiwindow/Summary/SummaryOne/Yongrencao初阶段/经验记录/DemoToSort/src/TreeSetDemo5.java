import java.util.TreeSet;

public class TreeSetDemo5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cat cat1 = new Cat("cao",5);
		Cat cat2 = new Cat("wang",3);
		Cat cat3 = new Cat("zhang",2);
		Cat cat4 = new Cat("li",6);

		CatComparatorUp ccu = new CatComparatorUp();
		CatComparatorDown ccd = new CatComparatorDown();
		
		TreeSet<Cat> catss = new TreeSet<Cat>(ccu);  //升序
		TreeSet<Cat> cats = new TreeSet<Cat>(ccd);  //降序
		cats.add(cat1);
		cats.add(cat2);
		cats.add(cat3);
		cats.add(cat4);
		
		for(Cat c:cats){
			System.out.println(c);
		}
	}

}
