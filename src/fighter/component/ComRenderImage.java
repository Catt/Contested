package fighter.component;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.StateBasedGame;


public class ComRenderImage extends ComRender {

	Image image;
	float halfWidth = 0;
	float halfHeight = 0;
	
	public ComRenderImage(String id, Image image){
		super(id);
		this.image = image;
		halfWidth = image.getWidth()/2;
		halfHeight = image.getHeight()/2;
	}
	
	@Override
	public float getHalfWidth() {
		return halfWidth;
	}
	@Override
	public float getHalfHeight() {
		return halfHeight;
	}
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g){
		Vector2f pos = owner.getPosition();
		float scale = owner.getScale();
		
		image.draw(pos.x-halfWidth,pos.y-halfHeight,scale);
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta){
		image.rotate(owner.getRotation() - image.getRotation());
	}
	
}
