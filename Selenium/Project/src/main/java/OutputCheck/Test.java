package OutputCheck;

public class Test {

	public static void main(String[] args) {
		
//		String[] testArray = new String[5];
//		int a = 10;
//		int b = 20;
//		String name = "Tirtha";
//		System.out.println( a + b + name);
//		System.out.println(name + a + b);
		System.out.println("abc"+21+9);
		System.out.println(21+8+"anv"+"uyt");
		
		System.out.println("--------------------------");
		
		Base obj = new Base();
		obj.firstMethod();
		System.out.println(obj.firstVar);
		
		System.out.println("--------------------------");
		
		Base obj1 = new Child();
		obj1.firstMethod();
		System.out.println(obj1.firstVar);
		
		System.out.println("--------------------------");
		
		Child obj2 = new Child();
		obj2.firstMethod();
		obj2.child();
		System.out.println(obj2.firstVar);
		
		
//		Animal obj = new Dog();
//		obj.legs();

	}

}
