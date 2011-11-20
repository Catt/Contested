package fighter;

import java.util.ArrayList;

import org.newdawn.slick.geom.Vector2f;

import fighter.component.ComCollidable;
import fighter.entity.Entity;


public class Collider {
	
	ArrayList<Entity> entities = new ArrayList<Entity>();
	
	public void addEntity(Entity e){
		entities.add(e);
	}
	
	public boolean collision(Entity e){
		//For every entity on the collision list...
		for (int i = 0;i<entities.size();i++){
			Entity other = entities.get(i);
			//If this entity isn't the one that called the method...
			if (e != other){
				//Get the distance components between the two entities.
				float distX = e.getPosition().getX() - other.getPosition().getX();
				float distY = e.getPosition().getY() - other.getPosition().getY();
				float hws = e.getHalfWidth()+other.getHalfWidth();
				float hhs = e.getHalfHeight()+other.getHalfHeight();
				//If the entities are intersecting on the Y axis...
				if (hhs >= Math.abs(distY)){
					//And the Y axis...
					if (hws > Math.abs(distX)){
						//Get the overlap between the two entities.
						float overlapX = hws - Math.abs(distX);
						float overlapY = hhs - Math.abs(distY);
						
						if(Math.abs(overlapX)<Math.abs(overlapY)){
							if(distX < 0){
								//Collision to the right.
								e.addPosition(new Vector2f(-overlapX,0));
								e.collisionEvent(other, 'r');
								return true;
							}
							else{
								//Collision to the left.
								e.addPosition(new Vector2f(overlapX,0));
								e.collisionEvent(other, 'l');
								return true;
							}	
						}
						else{
							if(distY < 0){
								//Collision below.
								e.addPosition(new Vector2f(0,-overlapY));
								e.collisionEvent(other, 'd');
								e.setGrounded(true);
								return true;
							}
							else{
								//Collision above.
								e.addPosition(new Vector2f(0,overlapY));
								e.collisionEvent(other, 'u');
								return true;
							}
						}
					}
				}
			}
		}
	return false;
	}

}
