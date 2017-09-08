import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

public class MatrizMath {
	
	private double cords[][];
	
	public MatrizMath(String path) throws FileNotFoundException {
		
		Scanner sc = new Scanner(new FileReader(path));
		cords = new double [sc.nextInt()][sc.nextInt()];
		
		for(int i=0; i<cantFilas(); i++){
			for(int j=0; j<cantColumnas(); j++)
				cords[i][j] = sc.nextDouble();
		}
		sc.close();
	}
	
	@Override
	public String toString() {
		return "MatrizMath [cords=" + Arrays.toString(cords) + "]";
	}

	public MatrizMath(int dimension1,int dimension2)
	{
		cords = new double [dimension1][dimension2];		
	}
	
	public int dimension(){
		return cantFilas();
	}
	
	public VectorMath getVectorColumna(int j)
	{
		VectorMath vec = new VectorMath(cords[j].length);
		for(int i=0; i<vec.dimension(); i++)
			vec.setCordenada(i,cords[j][i]);
		return vec;
	}
	
	public VectorMath Multiplicar(VectorMath v2) throws ExceptionMatriz, ExceptionVector
	{
		if(v2.dimension() != dimension())
			throw new ExceptionMatriz("Dimensiones no compatibles");
		
		VectorMath vec = new VectorMath(v2.dimension());
		for(int i=0;i< vec.dimension(); i++)
			vec.setCordenada(i,v2.Multiplicar(getVectorColumna(i)));
		return vec;
	}
	
	public MatrizMath Multiplicar(MatrizMath m2)
	{
		MatrizMath mat = new MatrizMath(cantFilas(),m2.cantColumnas());
		for(int i=0;i<this.cantFilas();i++)
		{
			for(int j=0;j<m2.cantColumnas();j++)
			{
				for(int k=0;k<this.cantColumnas();k++)
					mat.cords[i][j]+=this.cords[i][k]*m2.cords[k][j];
			}
		}
		return mat;
	}
	

	private int cantFilas() {
		return cords.length;
	}
	
	
	private int cantColumnas() {
		return cords[0].length;
	}
	
}
