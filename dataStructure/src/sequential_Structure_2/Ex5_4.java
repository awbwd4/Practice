package sequential_Structure_2;

// 계수 : coefficient
// 변수 : variable
// 지수 : exponent
// 차수 : degree = 지수


public class Ex5_4 {

	public static void main(String[] args) {

		//다항식 A와 B의 계수들
		float a[] = new float[] {4,3,5,0};
		float b[] = new float[] {3,1,0,2,1};
		
		PolyNomial A = new PolyNomial(3, a);
		//A는 3차 방정식
		PolyNomial B = new PolyNomial(4, b);
		//B는 4차 방정식
		
		OperatePoly optPoly = new OperatePoly();
		//다항식 A와 B를 연산해서 그 결과 다항식C를 생성하는 객체
		
		PolyNomial C = optPoly.addPoly(A, B);
		
		System.out.println("======tdd=========");
		
		System.out.printf("A(x) = "); A.printPoly();
		System.out.printf("B(x) = "); B.printPoly();
		System.out.printf("C(x) = "); C.printPoly();
	
	}
}



class OperatePoly{//다항식 연산
	
	//다항식 A와 다항식 B를 연산한 결과값 : 다항식 C
	
	
	private int degree_A = 0, degree_B = 0, degree_C = 0,
			index_A = 0, index_B = 0, index_C = 0;
	
	private int expo_A, expo_B;
	private float coef_A, coef_B, coef_C;
	
	
	public PolyNomial addPoly(PolyNomial A, PolyNomial B) {
		
		degree_A = A.getDegree();
		degree_B = B.getDegree();
		
		expo_A = degree_A;
		expo_B = degree_B;
		
		if (degree_A >= degree_B) {
			degree_C = degree_A;
		}else {
			degree_C = degree_B;}
		
		PolyNomial C = new PolyNomial(degree_C);
		//degree_C를 차수로 갖는 다항식 C 생성
		//아직은 계수들이 0임.
		
		
		//인덱스 i는 지수 n-1에 대한 항을 의미하고,
		//그 항의 계수를 인덱스i에 대한 배열 요소에 저장한다.
		while (index_A <= degree_A && index_B <= degree_B) {
			//차수와 지수 중 둘 중 하나는 반복문을 끝내는 기준점이 돼야 하므로
			//degree와 expo변수를 둘다 선언해준것.
			
			if (expo_A > expo_B) {
				
				C.setCoef(index_C++, A.getCoef(index_A++));
				expo_A--;
				
			} else if(expo_A == expo_B){
				
				C.setCoef(index_C++, A.getCoef(index_A++)+B.getCoef(index_B++));
				//다차식 배열의 인덱스 번호, 해당 인덱스에 들어갈 값(계수)
				
				expo_A--; expo_B--;
			} else {
				C.setCoef(index_C++, B.getCoef(index_B++));
				
				expo_B--;
			}
			
			
			//차수만큼 인덱스가 증가하면, 루프 종료
		}
		
		  
		
		return C;
	}
	
	
	
}

