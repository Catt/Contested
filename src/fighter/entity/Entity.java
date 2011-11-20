package fighter.entity;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Shape;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;

import fighter.component.ComCollidable;
import fighter.component.ComRender;
import fighter.component.Component;



public class Entity {
	
	private int id;
	
	private Vector2f position= new Vector2f(0,0);
	private float halfWidth = 0;
	private float halfHeight = 0;
	private float scale = 1;
	private float rotation = 0;
	private boolean grounded = false; //Whether there is ground below this entity.
	private boolean moved = false; //Set this to true whenever the entity moves, so ComCollidable knows to check for collisions.
	
	private ArrayList<Component> components = new ArrayList<Component>();
	private ComRender renderComponent = null;
	private ComCollidable collisionComponent = null;
	
	
	public Entity(int id)
	{
		this.id = id;
	}
	
	public void addComponent(Component component){		
		component.setOwner(this);
		components.add(component);
		if(ComRender.class.isInstance(component)){
			renderComponent = (ComRender)component;
			halfWidth = renderComponent.getHalfWidth();
			halfHeight = renderComponent.getHalfHeight();
		}
		if(ComCollidable.class.isInstance(component)){
			collisionComponent = (ComCollidable)component;
		}

	}
	
	public Component getComponent(String id)
	{
		for(Component comp : components){
			if (comp.getId().equals(id))
				return comp;
		}
		return null;
	}
	
	public Vector2f getPosition(){
		return position.copy();
	}
	public float getRotation(){
		return rotation;
	}
	public float getHalfWidth(){
		return halfWidth;
	}
	public float getHalfHeight(){
		return halfHeight;
	}
	public float getScale(){
		return scale;
	}
	public int getId(){
		return id;
	}
	public boolean getGrounded(){
		return grounded;
	}
	public boolean getMoved(){
		return moved;
	}
	public void setPosition(Vector2f pos){
		this.position.set(pos);
	}
	public void setRotation(float rotate) {
		rotation = rotate;
	}
	public void setHalfWidth(float hwidth) {
		halfWidth = hwidth;
	}
	public void setHalfHeight(float hheight) {
		halfHeight = hheight;
	}
	public void setScale(float scale) {
		this.scale = scale;
	}
	public void setGrounded(boolean grounded) {
		this.grounded = grounded;
	}
	public void setMoved(boolean moved) {
		this.moved = moved;
	}
	public void addPosition(Vector2f pos){
		this.position.add(pos);
	}
	public void collisionEvent(Entity other, char side){
		
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta){
		for(Component component : components)
			component.update(gc, sbg, delta);
	}
	
	public void render(GameContainer gc, StateBasedGame sbg, Graphics gr){
		if(renderComponent != null)
			renderComponent.render(gc,sbg,gr);
	}

}
