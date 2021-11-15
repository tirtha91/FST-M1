package OutputCheck;

public class SingletonClass {
// A Singleton class means only one instance of it can exist at any time
// A Singleton class returns the same instance every time you try to instantiate an instance of the class
//	Creating a singleton class consists of:
//	
//		Make a static reference of the class, as we want to make this available globally.
//		Making the constructor of the Class private.	
//		Make a static method which returns an object of type class, and it should also check whether class is already instantiated once or not – if it’s not instantiated then it should instantiate that otherwise it can return reference of the class directly.
	public static volatile SingletonClass singletonObj;
	private SingletonClass()
	{
		System.out.println("Singleton class object created");
	}
	public static SingletonClass getInstance()
	{
		SingletonClass result = singletonObj;
		if(result==null)
		{
			synchronized(SingletonClass.class) {
				result = singletonObj;
				if(result==null)
				{
					result = singletonObj = new SingletonClass();
				}
				
			}			
		}
		return result;
	}

}
