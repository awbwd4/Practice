package sequential_Structure_2;

public class PolyNomial {
	//다항식을 만드는 클래스
	
	private int degree;//차수
	private float coef[] = new float[20];//계수
	
	
	public PolyNomial(int degree, float coef[]) {
		//다항식 A와 B는 미리 차수와 계수가 주어지므로 이 생성자를 통해
		//초기화 해 준다
		this.degree = degree;
		this.coef = coef;
	}
	
	
	public PolyNomial(int degree) {
		this.degree = degree;
		for (int i = 0; i <= degree; i++) {
			this.coef[i] = 0;
		}
	}
	                                        
	public int getDegree() {
		return this.degree;
	}


	public float getCoef(int i) {
		return this.coef[i];
	}

	public void setCoef(int i, float coef) {
		this.coef[i] = coef;
	}

	public void printPoly() {
		int temp = this.degree;
		
		for (int i = 0; i < this.degree; i++) {
			System.out.printf("%3.0fx^%d", this.coef[i], temp--);
		}
		System.out.println();
	}
	
	
	
	
	
}
