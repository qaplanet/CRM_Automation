public class classB {
	//type1: No arguments & no returns
	void method1()
	{
		System.out.println("Method1");
	}
	//Type 2: Only arguments
	void method2(int a,int b)
	{
		System.out.println(a+b);
	}
	//Type3: Only retunrs
	boolean method3()
	{
		return false;		
	}
	//type4: Arguments & returns
	int method4(int a,int b)
	{
		int c=a+b;
		return c;
	}
	
	public static void main(String[] args)
	{
		classB x=new classB();
		x.method1();
		x.method2(10, 20);
		boolean res=x.method3();
		System.out.println(res);
		int res1=x.method4(20, 30);
		System.out.println(res1);
	}
}
