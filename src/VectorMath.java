import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class VectorMath {
	
	private double cords[];
	
	public VectorMath(String path) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new FileReader(path));
		cords = new double [sc.nextInt()];
		for(int i=0; i< cords.length; i++)
			cords[i] = sc.nextDouble();
		sc.close();
	}
	
	public VectorMath (int dimension)
	{
		cords = new double [dimension];
		
	}
	
	public int dimension(){
		return cords.length;
	}


	public VectorMath Sumar(VectorMath v2) throws ExceptionVector
	{
		if(v2.dimension() != dimension())
		{
			throw new ExceptionVector("Dimensiones no compatibles");
		}
		VectorMath resultado = new VectorMath(v2.dimension());
		for(int i=0; i<dimension(); i++)
			resultado.cords[i] = cords[i] + v2.cords[i];
		return resultado;
	}
	
	public VectorMath Restar(VectorMath v2) throws ExceptionVector
	{
		if(v2.dimension() != dimension())
		{
			throw new ExceptionVector("Dimensiones no compatibles");
		}
		VectorMath resultado = new VectorMath(v2.dimension());
		for(int i=0; i<dimension(); i++)
			resultado.cords[i] = cords[i] - v2.cords[i];
		return resultado;
		
	}
	
	public double Multiplicar(VectorMath v2) throws ExceptionVector
	{
		if(v2.dimension() != dimension())
		{
			throw new ExceptionVector("Dimensiones no compatibles");
		}
		double res=0;
		for(int i=0; i<dimension(); i++)
			res += cords[i] * v2.cords[i];
		return res;
	}
	
	public double Multiplicar(MatrizMath v2) throws ExceptionVector, ExceptionMatriz
	{
		if(v2.dimension() != dimension())
		{
			throw new ExceptionMatriz("Dimensiones no compatibles");
		}
		double res=0;
		for(int i=0; i<dimension(); i++)
			res += this.Multiplicar(v2.getVectorColumna(i));
		return res;
	}

	public void setCordenada(int i, double d) {
		cords[i] = d;
		
	}

	@Override
	public String toString() {
		return "VectorMath [cords=" + Arrays.toString(cords) + "]";
	}
	
		
}
