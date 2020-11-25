package frog;

import gameCommons.Game;
import gameCommons.IFrog;
import util.Case;
import util.Direction;

public class Frog implements IFrog {
	
	private Game game;
	private Direction direction;
	private Case position;

	public Frog(Game game){
		this.game = game;
		this.direction = Direction.up;
		this.position = new Case(game.width/2, 0);
	}

	/**
	 * Donne la position actuelle de la grenouille
	 * @return
	 */
	public Case getPosition(){
		return this.position;
	}

	/**
	 * Donne la direction de la grenouille, c'est � dire de son dernier mouvement
	 * @return
	 */
	public Direction getDirection(){
		return this.direction;
	}

	/**
	 * D�place la grenouille dans la direction donn�e et teste la fin de partie
	 * @param key
	 */
	public void move(Direction key){
		if(key == Direction.up && this.position.ord < game.height-1){
			this.position = new Case(this.position.absc, this.position.ord+1);
		}

		if(key == Direction.down && this.position.ord != 0){
			this.position = new Case(this.position.absc, this.position.ord-1);
		}

		if(key == Direction.left && this.position.absc != 0){
			this.position = new Case(this.position.absc-1, this.position.ord);
		}

		if(key == Direction.right && this.position.absc < game.width-1){
			this.position = new Case(this.position.absc+1, this.position.ord);
		}
	}
}
