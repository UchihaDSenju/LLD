import controller.*;
import exceptions.CellNotFoundException;
import model.*;
import java.util.*;
class Main{
	public static void main(String[] args){
		BoardController controller = BoardController.getControllerInstance();
		controller.generateBoard(3);
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
					controller.placeMarker(p, x, y);
					controller.viewBoard();
					break;
				}
				catch(CellNotFoundException e){
					System.out.println(e);
					continue;
				}
			}
			q.offer(p);
		}
	}
}