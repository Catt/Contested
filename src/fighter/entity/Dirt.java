package fighter.entity;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import fighter.component.ComCollidable;
import fighter.component.ComRenderImage;


public class Dirt extends Entity {
	
	
	public Dirt(int id) throws SlickException{
		super(id);
		
		addComponent(new ComRenderImage("ComRenderImage",new Image("img/dirt.png")));
		//addComponent(new ComForces("ComForces"));
		addComponent(new ComCollidable("ComCollidable"));
	}
	@Override
	public void collisionEvent(Entity other, char side){
	}
	
	

}
