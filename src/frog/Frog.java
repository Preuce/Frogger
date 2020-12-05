package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import util.Case;
import util.Direction;

public class Frog implements IFrog {

	private Game game;
	private Case position;
	private Direction direction;


	public Frog(Game game){
		this.game = game;
		this.direction = Direction.up;
		this.position = new Case (game.width/2, 0);
	}


	//méthode getPosition (pour obtenir la pos de la grenouille) ( logic)
	public Case getPosition(){
		return this.position;
	}

	//méthode getDirection (pour obtenir la direction(logic))
	public Direction getDirection(){
		return this.direction;
	}

	//méthode move
	public void move(Direction direction){
		if(direction == Direction.up){
			this.position = new Case(this.position.absc, this.position.ord+1);
		}
		//mouv possible si pas tout à gauche
		if(direction == Direction.left && this.position.absc != 0){
			this.position = new Case(this.position.absc-1, this.position.ord);
		}
		//mouv possible si pas tout à droite
		if(direction == Direction.right && this.position.absc != game.width-1){
			this.position = new Case( this.position.absc+1, this.position.ord);
		}
		//mouv possible si pas tout en bas
		if(direction == Direction.down && this.position.ord != 0){
			this.position = new Case( this.position.absc, this.position.ord-1);
		}
		game.testLose();
		game.testWin();

	}

}
