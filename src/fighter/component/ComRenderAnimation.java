package fighter.component;

import java.util.ArrayList;

import org.newdawn.slick.Animation;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;


public class ComRenderAnimation extends ComRender {

	private ArrayList<Animation> animations = new ArrayList<Animation>();
	private float halfWidth = 0;
	private float halfHeight = 0;
	private Animation current;
	private boolean flip = false;
	
	public ComRenderAnimation(String id, Animation animation){
		super(id);
		animation.setAutoUpdate(false);
		animations.add(animation);
		current = animation;
		halfWidth = animation.getImage(0).getWidth()/2;
		halfHeight = animation.getImage(0).getHeight()/2;
	}
	
	@Override
	public float getHalfWidth() {
		return halfWidth;
	}
	@Override
	public float getHalfHeight() {
		return halfHeight;
	}
	public void setAnimation(int index) {
		current = animations.get(index);
	}
	public void setFlip(boolean flip) {
		this.flip = flip;
	}
	public void addAnimation(Animation animation){
		animations.add(animation);
	}
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g){
		Vector2f pos = owner.getPosition();
		float scale = owner.getScale();
		Image frame = current.getCurrentFrame();
		if(flip){
			frame.draw(pos.x+halfWidth,pos.y-halfHeight,frame.getWidth()*-scale,frame.getHeight()*scale);
		}
		else{
			frame.draw(pos.x-halfWidth,pos.y-halfHeight,frame.getWidth()*scale,frame.getHeight()*scale);
		}
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta){
		current.update(delta);
	}
	
}
