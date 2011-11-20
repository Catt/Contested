/*
 * ComCollidable.java by Matthew Canestraro
 * 
 * This class requests a collision check when ever the owner Entity moves.
 * It contains the method collisionEvent() that is called in the event of a collision.
 */

package fighter.component;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.geom.Vector2f;

import fighter.GameplayState;
import fighter.FighterGame;
import fighter.entity.Entity;


public class ComCollidable extends Component{
	
	//CLASS VARIABLES GO HERE------------------------------------------------------------------------------------------------------------------|
	
	//CONSTRUCTORS GO HERE---------------------------------------------------------------------------------------------------------------------|
	public ComCollidable(String id){
		this.id = id;
	}

	//THE GOOD STUFF GOES HERE-----------------------------------------------------------------------------------------------------------------|
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		//If this entity has moved.
		if (owner.getMoved())
		{
			//Set grounded to false (will be set to true again if there is a collision.
			owner.setGrounded(false);
			//Reset the moved flag and request a collision check from the Collider.
			owner.setMoved(false);
			((GameplayState)sbg.getState(FighterGame.GAMEPLAYSTATE)).getCollider().collision(owner);	
		}
	}


}//End of class: ComForces.