package fighter.entity;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Vector2f;

import fighter.component.ComCollidable;
import fighter.component.ComForces;
import fighter.component.ComRenderAnimation;
import fighter.component.ComRenderImage;
import fighter.component.ComWSAD;


public class Player extends Entity {
	
	
	public Player(int id,int m) throws SlickException{
		super(id);
		SpriteSheet idle = new SpriteSheet(new Image("img/player_idle.png"),64,128);
		SpriteSheet run = new SpriteSheet(new Image("img/player_run.png"),64,128);
		ComRenderAnimation com = new ComRenderAnimation("ComRenderAnimation",new Animation(idle,500));
		com.addAnimation(new Animation(run,100));
		addComponent(com);
		addComponent(new ComCollidable("ComCollidable"));
		addComponent(new ComForces("ComForces"));
		addComponent(new ComWSAD("ComWSAD",60.f));
	}
	@Override
	public void collisionEvent(Entity other, char side){
		if (Dirt.class.isInstance(other))
		{
			
			ComForces forces = (ComForces)getComponent("ComForces");
			Vector2f velocity = forces.getVelocity();
			
			if (side == 'u' && velocity.getY() < 0){
				forces.setVelocity(velocity.set(velocity.getX(),0));
				//System.out.println("u");
			}
			if (side == 'd' && velocity.getY() > 0){
				forces.setVelocity(velocity.set(velocity.getX(),0));
				//System.out.println("d");
			}
			if (side == 'l' && velocity.getX() < 0){
				forces.setVelocity(velocity.set(0,velocity.getY()));
				//System.out.println("l");
			}
			if (side == 'r' && velocity.getX() > 0){
				forces.setVelocity(velocity.set(0,velocity.getY()));
				//System.out.println("r");	
			}
		}
	}
	
	

}
