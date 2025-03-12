package package1;
import package2.classC;

public class classA extends classC {

    int i = 0 ;
	
	void show() {
		System.out.println("showing A");
	}
	
	public static void main(String[] args) {
		
		classB b = new classB() ;
		b.show();
		
	}

}
