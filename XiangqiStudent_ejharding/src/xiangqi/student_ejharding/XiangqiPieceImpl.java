package xiangqi.student_ejharding;

import java.util.List;
import java.util.function.BiPredicate;

import static xiangqi.common.XiangqiColor.*;

import xiangqi.common.XiangqiColor;
import xiangqi.common.XiangqiCoordinate;
import xiangqi.common.XiangqiPiece;
import xiangqi.common.XiangqiPieceType;

import static xiangqi.common.XiangqiPieceType.*;

public class XiangqiPieceImpl implements XiangqiPiece {

	
	private XiangqiPieceType type;
	private XiangqiColor color;
	List<BiPredicate<IMyCoordinate, IMyCoordinate>> moveValidators;

	public XiangqiPieceImpl(XiangqiPieceType type, XiangqiColor color){
		this.type = type;
		this.color = color;
		moveValidators = MoveValidatorFactory.getValidators(type);
	}
	
	public XiangqiPieceImpl(XiangqiPiece piece){
		this.type = piece.getPieceType();
		this.color = piece.getColor();
		moveValidators = MoveValidatorFactory.getValidators(type);
	}
	
	public boolean isValid(MyCoordinate c1, MyCoordinate c2){
		for(BiPredicate<IMyCoordinate, IMyCoordinate> validator: moveValidators){
			if(!validator.test(c1, c2)){
				return false;
			}
		}
		return true;
	}
	@Override
	public XiangqiColor getColor() {
		return color;
	}

	@Override
	public XiangqiPieceType getPieceType() {
		return type;
	}
	
//	@Override
//	public String toString(){
//		return color.toString() + " " + type.toString();
//	}
	
//	public boolean equals(Object other){
//		if(!(other instanceof XiangqiPieceImpl)){
//			return false;
//		}
//		XiangqiPieceImpl toCheck = (XiangqiPieceImpl) other;
//		
//		if(toCheck.getColor().equals(this.color) && toCheck.getPieceType().equals(this.type)){
//			return true;
//		} else {
//			return false;
//		}
//	}
	
}
