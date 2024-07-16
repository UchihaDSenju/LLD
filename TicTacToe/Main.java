import controller.*;
import exceptions.CellNotEmptyException;
import exceptions.CellNotFoundException;
import model.*;
import java.util.*;
class Main{
	public static void main(String[] args){
		BoardController controller = BoardController.getControllerInstance();
		controller.generateBoard(3);
		controller.viewBoard();
		Queue<Player> q = new LinkedList<>();
		
		q.offer(new Player("A", "X"));
		q.offer(new Player("B", "O"));
		Scanner sc = new Scanner(System.in);
		while(true){
			Player p = q.poll();
			while(true){
				try{
					System.out.println("Player "+p.getName());
					System.out.println("Enter Where to place " + p.getMarker());
					int x = sc.nextInt();
					int y = sc.nextInt();
					x = x-1;
					y = y-1;
					controller.placeMarker(p, x, y);
					if(controller.isWinner(p, x, y)){
						controller.viewBoard();
						System.out.println("Player " +p.getName() + " Wins");
						return;
					}
					if(controller.getEmptyCells() == 0){
						controller.viewBoard();
						System.out.println("All Cells Filled");
						return;
					}
					controller.viewBoard();
					break;
				}
				catch(CellNotFoundException e){
					System.out.println(e);
					continue;
				}
				catch(IndexOutOfBoundsException e){
					System.out.println("Cell Not Found... Enter Proper Cell");
					continue;
					//break;
				}
				catch(RuntimeException e){
					return;
				}
			}
			q.offer(p);
		}
	}
}