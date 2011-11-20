package fighter;

import java.util.ArrayList;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.geom.Vector2f;

import fighter.component.ComForces;
import fighter.entity.*;


public class GameplayState extends BasicGameState {
	
	private Image imgBackground;
	private int stateID = -1;
	private Collider collider = new Collider();
	private Player player = null;
	private ArrayList<Dirt> alDirt = new ArrayList<Dirt>();
	private int test = 0;
	private Vector2f velSec = new Vector2f(0,0);
	
	GameplayState(int stateID){
		this.stateID = stateID;
	}
	
	@Override
	public int getID(){
		return stateID;
	}
	//Slick methods.
	public void init(GameContainer gc, StateBasedGame sbg) throws SlickException{
		//Make the sky.
		imgBackground = new Image("img/sky.png");
		//Make the player.
		player = new Player(0,60);
		player.setPosition(new Vector2f(100,100));
		collider.addEntity(player);
		//Make some dirt.
		int count = 0;
		for(int i = 1;i < 4;i ++){
			for(int j = 1;j < (i)*5;j ++){
				Dirt dirt = new Dirt(count);
				dirt.setPosition(new Vector2f(32+(j-1)*64,400+(i)*64));
				collider.addEntity(dirt);
				alDirt.add(dirt);
				count ++;
			}
		}
	}
	public void render(GameContainer gc, StateBasedGame sbg, Graphics gr) throws SlickException{
		imgBackground.draw(0,0);
		player.render(gc, sbg, gr);
		for(int i=0;i<alDirt.size();i++)
			alDirt.get(i).render(gc, sbg, gr);
		
	}
	public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
		//if (delta <20)
			//gc.sleep(20-delta);
		/*ComForces forces = (ComForces)player.getComponent("ComForces");
		velSec.add(forces.getVelocity());
		test += delta;
		if(test >= 1000){
			System.out.println("tick: "+player.getPosition()+velSec);
			velSec.set(0,0);
			test = 0;
		}*/
		
		
		player.update(gc,sbg,delta);
		for(int i=0;i<alDirt.size();i++)
			alDirt.get(i).update(gc, sbg, delta);
		
	}
	//My methods.
	public Collider getCollider() {
		return collider;
	}
}