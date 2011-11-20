package fighter.component;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import fighter.FighterGame;

public class ComForces extends Component {

	private Vector2f velocity = new Vector2f(0.f,0.f);
	private Vector2f gravity = new Vector2f(0.f,0.5f);
	private float friction = 0.99f;
	
	public ComForces(String id){
		this.id = id;
	}
	
	
	public Vector2f getVelocity(){
		return velocity.copy();
	}
	public void setVelocity(Vector2f velocity){
		this.velocity.set(velocity);
	}
	public void addVelocity(Vector2f velocity){
		this.velocity.add(velocity);
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		
		float deltaf = (float)delta/1000.f;
		
		//Move the entity according to velocity.
		owner.addPosition(velocity.copy().scale(deltaf*FighterGame.MODELSCALE));
		
		//if velocity was greater than 0, set the entity as having moved.
		if(velocity.length()!=0)
			owner.setMoved(true);
		
		//Apply gravity.
		if(!owner.getGrounded()){
			velocity.add(gravity.copy().scale(deltaf*FighterGame.MODELSCALE));
		}
		//Apply friction.
		velocity.set(velocity.getX()*(float)Math.pow(friction,delta),velocity.getY());

	}

}
