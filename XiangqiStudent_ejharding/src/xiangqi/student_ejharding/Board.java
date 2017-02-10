package xiangqi.student_ejharding;

import java.util.ArrayList;

import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;

/**
 * data structure to represent the Xiangqi Board
 * coordinates are stored internally from the red aspect
 * @author Everett Harding
 *
 */
public class Board {

	Intersection board[][];

	static class Intersection{
		XiangqiPiece piece;

		public Intersection(XiangqiPiece p ){
			this.piece = p;
		}

		boolean place(XiangqiPiece p){
			this.piece = p;
			return true;
		}

		XiangqiPiece getPiece(){
			return this.piece;
		}

		/**
		 * returns the piece in this cell, and replaces that piece with a null piece
		 * @return the piece in this cell
		 */
		XiangqiPiece removePiece(){
			XiangqiPiece temp = this.piece;
			this.piece = new XiangqiPieceImpl(XiangqiPieceType.NONE, XiangqiColor.NONE);
			return temp;
		}

	} 

	public Board(int numRanks, int numFiles){
		board = new Intersection[numRanks][numFiles];
		//initialize the board array to none-pieces
		for(int rank = 0; rank < numRanks; rank++){
			for(int file = 0; file < numFiles; file++){
				board[rank][file] = new Intersection(new XiangqiPieceImpl(XiangqiPieceType.NONE, XiangqiColor.NONE));
			}
		}
	}

	/**
	 * method for returning the piece at the specified location
	 * @param location:: the coordinates from which to remove the piece
	 * @return the piece found at the given location
	 */
	public XiangqiPiece getPieceAt(XiangqiCoordinate location){
		/**
		 * checks:
		 * TODO valid location
		 * TODO valid piece
		 * 
		 */

		int rank = location.getRank()-1;
		int file = location.getFile()-1;

		if(!isValidLocation(location)){
			return new XiangqiPieceImpl(XiangqiPieceType.NONE, XiangqiColor.NONE);
		}

		return board[rank][file].getPiece();
	}

	public XiangqiPiece removePieceFrom(XiangqiCoordinate location){
		int rank = location.getRank()-1;
		int file = location.getFile()-1;

		if(!isValidLocation(location)){
			return new XiangqiPieceImpl(XiangqiPieceType.NONE, XiangqiColor.NONE);
		}

		return board[rank][file].removePiece();
	}
	/**
	 * places the given piece on the board in the specified location
	 * @param piece :: the piece to be placed
	 * @param location :: the coordinates at which to place the given piece
	 * @return true if the piece was successfully placed, false otherwise
	 */
	public boolean placePieceAt(XiangqiPiece piece, XiangqiCoordinate location){
		/*
		 * error checks:
		 * valid board location
		 * will not duplicate pieces on the board more times than they are supposed to be
		 */
		int rank, file;
		if(!isValidLocation(location)){
			return false;
		}
		if(piece.getColor() == XiangqiColor.RED){
			rank = location.getRank() -1;
			file = location.getFile() -1;
		} else {
			rank = location.getRank() -1;
			file = location.getFile() -1;
		} return board[rank][file].place(piece);
	}

	public boolean isValidLocation(XiangqiCoordinate loc){
		int rank = loc.getRank() -1;
		int file = loc.getFile() -1;
		return rank < board.length && file < board[0].length && rank >= 0 && file >= 0;
	}

	public int getNumRanks(){
		return board.length;
	}

	public int getNumFiles(){
		return board[0].length;
	}

	public boolean generalInCheckMate(XiangqiColor player) {
		MyCoordinate generalLoc = findGeneral(player);
		
		return false;
	}

	public boolean generalInCheck(XiangqiColor player) {
		MyCoordinate generalLoc = findGeneral(player);
		ArrayList<MyCoordinate> pieceLocs = new ArrayList<MyCoordinate>();
		for(int r = 0; r < getNumRanks(); r++){
			for(int f = 0; f < getNumFiles(); f++){
				if(board[r][f].getPiece().getColor() != XiangqiColor.NONE && board[r][f].getPiece().getColor() != player){
					pieceLocs.add(new MyCoordinate(r+1,f+1,this));
				}
			}
		}
		
		for(MyCoordinate loc: pieceLocs){
			Move test = new Move(loc, generalLoc, this, player);
			if(test.isValid()){
				return true;
			}
		}
		return false;
	}

	private MyCoordinate findGeneral(XiangqiColor player){
		for(int r = 0; r < getNumRanks(); r++){
			for(int f = 0; f < getNumFiles(); f++){
				if(board[r][f].getPiece().getColor() == player && board[r][f].getPiece().getPieceType() == XiangqiPieceType.GENERAL){
					return new MyCoordinate(r+1,f+1,this);
				}
			}
		}
		return null;
	}
	
	public String toString(){
		String s = "";
		for(int r = 0; r < getNumRanks(); r++){
			for(int f = 0; f < getNumFiles(); f++){
				s += getPieceChar(board[r][f].getPiece()) + " ";
			}
			s+="\n";
		}
		return s;
	}
	
	private String getPieceChar(XiangqiPiece p){
		String chars = "";
		switch(p.getColor()){
		case BLACK: chars += "b"; break;
		case RED: chars += "r"; break;
		case NONE: chars += "-"; break;
		default: break;
		}
		switch(p.getPieceType()){
		case CHARIOT: chars += "C"; break;
		case ADVISOR: chars += "A"; break;
		case GENERAL: chars += "G"; break;
		case SOLDIER: chars += "S"; break;
		case NONE: chars += "-"; break;
		default: break;
		}
		return chars;
	}
}
