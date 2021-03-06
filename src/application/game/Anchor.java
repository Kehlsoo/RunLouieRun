package application.game;

import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;

/**
 * Anchor class, creates anchors at a specified location 
 * renders, and provides functionality to move anchors left.
 * @author Nabeel
 */
public class Anchor extends BaseSprite {

	/** How fast to charge louie.**/
	private float chargePower = 2.9f;
		
	/**
	 * Constructor to create a sprite and assign it a position.
	 * On creation the animation of the sprite is also started
	 * @param positionX X coordinate of the sprite 
	 * @param positionY Y coordinate of the sprite
	 */
	public Anchor(final double positionX, final double positionY) {
		super(positionX, positionY);
		initAnimation();
	}
	
	/**
	 * Moves the Sprite left to right across the screen at a constant
	 * speed.
	 */
	public void chargeLeft() {
		super.setPosition(super.getPositionX() 
				- chargePower, super.getPositionY());
	}
	
	/**
	 * Returns a rectangle boundary around the sprite.
	 * @return A new rectangle around the sprite
	 */
	public Rectangle2D getBoundary() {
		return new Rectangle2D(getPositionX(), getPositionY(), 32, 64);
	}
	
	/**
	 * Loads the images and sets the duration for each animation of the.
	 * sprite
	 */
	private void initAnimation() {
		Image[] anchorFrames = new Image[7];
		for (int i = 0; i < 7; i++) {
			anchorFrames[i] = new Image("file:resources/Images/anchor"
					+ i + ".png");
		}
		this.setFrames(anchorFrames);
		this.setFrameDuration(0.100);
	}
}
