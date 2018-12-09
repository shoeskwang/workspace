
public class Minesweeper {
	public static final int ROW        = 10;			//가로
	public static final int COL        = 10;			//세로
	public static final int MINE_CNT   = 10;			//지뢰갯수
	public static int arr[][] = new int[ROW+2][COL+2]; //지뢰판 (상하좌우 여유로 1칸씩 추가) // 범위 벗어나는 주변 8개 사각형 확인을 위해 여유공간 확보 
	public static boolean vArr[][] = new boolean[ROW+2][COL+2]; //가상지뢰판 (지뢰만 보유)
	public static int mine[] = new int[MINE_CNT];			//지뢰위치
	
	public static void mineCreate(){
		 // 지뢰 생성
		boolean repeatCheck = false; // 지뢰 위치 중복 확인
		
		for(int i=0;i<MINE_CNT;i++){
			repeatCheck = false;
			// 1~(ROW*COL) 난수 생성
			int ran = (int) (Math.random()*ROW*COL) +1; 
			
			// 지뢰 위치 중복되는지 확인 
			for(int j=0;j<=i;j++){
				if(ran==mine[j]){
					i--;
					repeatCheck=true;
					break;
				}
			}
			// 지뢰 위치 중복되지 않을 경우 추가
			if(!repeatCheck){
				mine[i]=ran;
			}
		}
		// 임의로 지뢰 위치 지정
		/*
		mine[1]=100;
		mine[2]=1;
		mine[3]=2;
		mine[4]=99;
		*/
	}
	
	public static void minePrint(){
		// 지뢰 좌표 출력 (실제 판 크기가 10X10 일경우 사용되는 배열 범위는 (1,1)~(10,10)으로 처리)
		// mineCreate()에서 만든 지뢰 위치를 좌표로 변환하여 가상 지뢰판(vArr)에 지뢰 삽입
		System.out.println("-------지뢰 좌표("+MINE_CNT+"개)--------");
		for(int i=0;i<MINE_CNT;i++){ 
				if(mine[i]%COL==0){ 
					// ex) 100 => (10,10) 으로 변경하기 위해 분기문 추가
					System.out.println(mine[i]/COL+","+(COL));
					vArr[mine[i]/COL][COL] = true;
				}
				else{
					System.out.println((mine[i]/COL+1)+","+(mine[i]%COL) ); 
					vArr[mine[i]/COL+1][mine[i]%COL] = true;
				}
		}
		
	}
	
	public static void mineCntInsert(){
		// 지뢰판 숫자 입력
		int tempCnt=0;
		// 자신을 제외한 주변 8개의 사각형에 포함된 폭탄 갯수 입력
		for(int a=1;a<=ROW;a++){
			for(int b=1;b<=COL;b++){
				if(vArr[a-1][b-1]){ tempCnt++; }
				if(vArr[a-1][b]){ tempCnt++; }
				if(vArr[a-1][b+1]){ tempCnt++; }
				if(vArr[a][b-1]){ tempCnt++; }
				if(vArr[a][b+1]){ tempCnt++; }
				if(vArr[a+1][b-1]){ tempCnt++; }
				if(vArr[a+1][b]){ tempCnt++; }
				if(vArr[a+1][b+1]){ tempCnt++; }
				arr[a][b]=tempCnt; // 갯수 입력
				tempCnt=0; // 초기화
			}
		}
		
		// 지뢰 위치 출력 
		System.out.println("-------vArr(가상 지뢰판("+ROW+"X"+COL+"))--------");
		for(int a=1;a<=ROW;a++){
			for(int b=1;b<=COL;b++){
				if(vArr[a][b]){
					System.out.print("x ");
				}else{
					System.out.print("o ");
				}
			}
			System.out.println();
		}
	}
	
	public static void resultPrint(){
		// 실제 보여질 지뢰판 출력
		System.out.println("-------result--------");
		for(int a=1;a<=ROW;a++){
			for(int b=1;b<=COL;b++){
				System.out.print(arr[a][b]+" ");
			}
			System.out.println();
		}
		
		// 전체 출력 (여유공간 포함)
		/*
		for(int a=0;a<ROW+2;a++){
			for(int b=0;b<COL+2;b++){
				System.out.print(arr[a][b]+" ");
			}
			System.out.println();
		}
		*/
	}
	public static void main(String[] args) {
		mineCreate();		// 지뢰 생성
		minePrint();		// 지뢰 위치 출력
		mineCntInsert();	// 주변 지뢰 갯수 입력
		resultPrint();		// 최종 결과 출력 
	}
}
