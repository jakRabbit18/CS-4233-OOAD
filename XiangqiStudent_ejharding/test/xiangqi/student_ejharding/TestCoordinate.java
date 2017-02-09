package xiangqi.student_ejharding;

import xiangqi.common.XiangqiCoordinate;

public class TestCoordinate implements XiangqiCoordinate {

	private int rank, file;
	
	public static TestCoordinate make(int rank, int file){
		return new TestCoordinate(rank,file);
	}
	
	private TestCoordinate(int rank, int file){
		this.rank = rank;
		this.file = file;
	}
	
	@Override
	public int getRank() {
		// TODO Auto-generated method stub
		return rank;
	}

	@Override
	public int getFile() {
		// TODO Auto-generated method stub
		return file;
	}

}
