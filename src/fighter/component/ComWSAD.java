package fighter.component;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import fighter.FighterGame;


public class ComWSAD extends Component {
	
	float maxForce;
	
	public ComWSAD(String id,float pMaxForce){
		this.id = id;
		this.maxForce = pMaxForce;
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta) {
		
		Input input = gc.getInput();
		
		ComForces forces = (ComForces)owner.getComponent("ComForces");
		ComRenderAnimation animation = (ComRenderAnimation)owner.getComponent("ComRenderAnimation");
		
		if(input.isKeyDown(Input.KEY_W))
		{
			if(owner.getGrounded()){
				forces.setVelocity(new Vector2f(forces.getVelocity().getX(),-10f));
			}
		}
		else if(input.isKeyDown(Input.KEY_S))
		{
			forces.addVelocity(new Vector2f(0,0.02f));
		}
		if(input.isKeyDown(Input.KEY_D))
		{
			forces.setVelocity(new Vector2f(5f,forces.getVelocity().getY()));
			animation.setAnimation(1);
			animation.setFlip(false);
		}
		else if(input.isKeyDown(Input.KEY_A))
		{
			forces.setVelocity(new Vector2f(-2.5f,forces.getVelocity().getY()));
			animation.setAnimation(1);
			animation.setFlip(true);
		}
		else{
			animation.setAnimation(0);
		}


	}

}
