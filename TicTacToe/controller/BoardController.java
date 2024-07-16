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
		board.setCellCount(n*n);
	}
	
	public int getEmptyCells(){
		return board.getCellCount();
	}
	
	public void placeMarker(Player p, int i, int j){
		if(board.getBoard().get(i).get(j).getMarker().equals(".")){
			board.getBoard().get(i).get(j).setMarker(p.getMarker());
			board.setCellCount(board.getCellCount() - 1);
			return;
		}
		throw new CellNotEmptyException();
	}

	public boolean isWinner(Player p, int i, int j){
		//horizontal
		int right = recur(board.getBoard(),i, j+1, 0, 1, p.getMarker());
		int left = recur(board.getBoard(),i, j-1, 0, -1, p.getMarker());
		if(right + left + 1 == 3)return true;
		//vertical
		int top = recur(board.getBoard(), i+1, j, 1, 0, p.getMarker());
		int down = recur(board.getBoard(), i-1, j, -1, 0, p.getMarker());
		if(top + down + 1 == 3)return true;
		//digonal
		if(i == j){
			int downRight = recur(board.getBoard(), i+1, j+1, 1, 1, p.getMarker());
			int topLeft = recur(board.getBoard(), i-1, j-1, -1, -1, p.getMarker());
			if(downRight + topLeft + 1 == 3)return true;

			int upRight = recur(board.getBoard(), i-1, j+1, -1, 1, p.getMarker());
			int downLeft = recur(board.getBoard(), i+1, j-1, 1, -1, p.getMarker());
			if(upRight + downLeft + 1 == 3)return true;
		}
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

		if(!board.get(i).get(j).getMarker().equals(marker)) return 0;

		int a = 1+recur(board, i+ti, j+tj, ti, tj, marker);

		return a;
	}
}