class Board{
	private static Board boardInstance = null;
	
	ArrayList<Cell> board = new ArrayList<Cell>();
	private Board(){
		for(int i = 0; i<3; i++){
			for(int j = 0; j<3; j++){
				board.add(new Cell());
			}
		}
		
		System.out.println(board);
	}
	
	public static Board getBoardInstance(){
		if(boardInstance == null){
			boardInstance = new Board();
		}
		return boardInstance;
	}
}