import java.io.FileNotFoundException;

public class Main {
	public static void main(String args[]) throws FileNotFoundException, ExceptionVector
	{
		 VectorMath v1 = new VectorMath("v1.in");
		 VectorMath v2 = new VectorMath("v2.in");
		 VectorMath v3 = new VectorMath(2);
		 
		 System.out.println(v1.Multiplicar(v2));
		 //System.out.println(v3);
		 
		 MatrizMath m1 = new MatrizMath("mat1.in");
		 MatrizMath m2 = new MatrizMath("mat2.in");
		 MatrizMath m3 = new MatrizMath(3,1);
		 
		 m3= m1.Multiplicar(m2);
		 System.out.println(m3);
		 
		 
	}
}
