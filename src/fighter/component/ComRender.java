package fighter.component;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public abstract class ComRender extends Component {
	
	public ComRender(String id){
		this.id = id;
	}
	
	public abstract float getHalfWidth();
	public abstract float getHalfHeight();
	public abstract void render(GameContainer gc, StateBasedGame sb, Graphics g);

}
