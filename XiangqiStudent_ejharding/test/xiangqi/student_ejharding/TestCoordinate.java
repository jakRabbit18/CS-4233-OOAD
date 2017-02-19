package xiangqi.student_ejharding;

import xiangqi.common.XiangqiCoordinate;

public class TestCoordinate implements XiangqiCoordinate {

	private int rank, file;
	
	/**
	 * hack of a creation, leaves unused ranks & files for board[0][x] and board[x][0]
	 * returns array of TestCoordinates [numRanks+1][numFiles+1] to fix 0-indexing discontinuities
	 * @param numRanks
	 * @param numFiles
	 * @return an array of TestCoordinate
	 */
	public static TestCoordinate[][] makeFullBoardofCoordinates(int numRanks, int numFiles){
		TestCoordinate board[][] = new TestCoordinate[numRanks+1][numFiles+1];
		for (int r = 0; r <= numRanks; r++)
			for(int f= 0; f <= numFiles; f++){
				board[r][f] = make(r, f);
		}
		return board;
	}
	
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
