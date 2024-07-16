package controller;
import board.*;
import exceptions.*;
import model.*;
import java.util.*;
public class BoardController{
	Board board;
	private static BoardController controllerInstance = null;
	private BoardController(){
		board = Board.getBoardInstance();
	}
	
	public static BoardController getControllerInstance(){
		if(controllerInstance == null){
			controllerInstance = new BoardController();
		}
		return controllerInstance;
	}
	
	public void generateBoard(int n){
		ArrayList<ArrayList<Cell>> newBoard = new ArrayList<ArrayList<Cell>>();
		for(int i = 0; i<n; i++){
			ArrayList<Cell> row = new ArrayList<>();
			for(int j = 0; j<n; j++){
				row.add(new Cell());
			}
			newBoard.add(row);
		}
		
		board.setBoard(newBoard);
	}
	
	public void placeMarker(Player p, int i, int j){
		try {
			if(board.getBoard().get(i).get(j).getMarker().equals(" . ")){
				board.getBoard().get(i).get(j).setMarker(p.getMarker());
			}
		} catch (Exception e) {
			throw new CellNotFoundException();
		}
	}

	public boolean isWinner(Player p, int i, int j){
		//horizontal
		int right = recur(board.getBoard(),i, j+1, 0, 1, p.getMarker());
		int left = recur(board.getBoard(),i, j-1, 0, -1, p.getMarker());
		if(right + left + 1 == 3)return true;
		//vertical
		//digonal
		return false;
	}

	public void viewBoard(){
		ArrayList<ArrayList<Cell>> currBoard = new ArrayList<ArrayList<Cell>>();
		currBoard = board.getBoard();
		for(ArrayList<Cell> row : currBoard){
			System.out.println(row);
		}
	}

	public int recur(ArrayList<ArrayList<Cell>> board, int i, int j, int ti, int tj, String marker){
		if(i<0 || j<0 || i>=board.size() || j>=board.get(i).size()){
			return 0;
		}

		int a = 1+recur(board, i+ti, j+tj, ti, tj, marker);

		return a;
	}
}