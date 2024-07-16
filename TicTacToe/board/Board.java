package board;
import java.util.*;
import model.*;
public class Board{
	private static Board boardInstance = null;
	private ArrayList<ArrayList<Cell>> board = new ArrayList<ArrayList<Cell>>();
	private Board(){}
	
	public static Board getBoardInstance(){
		if(boardInstance == null){
			boardInstance = new Board();
		}
		
		return boardInstance;
	}
	
	// read methods
	public ArrayList<ArrayList<Cell>> getBoard(){
		return board;
	}
	
	// write methods
	public void setBoard(ArrayList<ArrayList<Cell>> board){
		this.board = board;
	}
}