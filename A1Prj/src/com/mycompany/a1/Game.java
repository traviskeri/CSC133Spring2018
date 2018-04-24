package com.mycompany.a1;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionListener;
import java.lang.String;
/**
 * This is the Game class. The GameWorld is instantiated here.
 * @author Travis Keri
 * @version 1.0
 */

public class Game extends Form{

	private GameWorld gw;
		
	public Game() {
		gw = new GameWorld();
		gw.init();
		play();
	}

	
	private void play() {
		Label myLable=new Label("Enter a Command:");
		this.addComponent(myLable);
		final TextField myTextField=new TextField();
		this.addComponent(myTextField);
		this.show();
		
		myTextField.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent evt) {
				
				String sCommand=myTextField.getText().toString();
				myTextField.clear();
				if(sCommand.length() > 0){
					if(!gw.isExitSelected()) {
						switch (sCommand.charAt(0)){
							case 'a'://accelerate
								gw.speedUp();
								System.out.println("accelerate");
								break;
							case 'b': //break
								gw.slowDown();
								System.out.println("breaks");
								break;
							case 'l': //left
								gw.turnLeft();
								System.out.println("turn left");
								break;
							case 'r': //right
								gw.turnRight();
								System.out.println("turn right");
								break;
							case '1':
								gw.hitFlag(1);
								System.out.println("hit flag 1");
								break;
							case '2':
								gw.hitFlag(2);
								System.out.println("hit flag 2");
								break;
							case '3':
								gw.hitFlag(3);
								System.out.println("hit flag 3");
								break;
							case '4':
								gw.hitFlag(4);
								System.out.println("hit flag 4");
								break;
							case '5':
								gw.hitFlag(5);
								System.out.println("hit flag 5");
								break;
							case 'f': //food
								gw.eat();
								System.out.println("eating");
								break;
							case 'g': //"gotten by the spider"
								gw.hitSpider();
								System.out.println("hit spider");
								gw.checkGameOver();
								break;
							case 't': //"tick of clock"
								gw.clockTick();
								gw.lowerFoodLevel();
								gw.checkGameOver();
								gw.move();
								System.out.println("clock tick, lower food level, move");
								break;
							case 'd': //display stats
								gw.displayStats();
								break;
							case 'm': //map
								gw.map();
								break;
							case 'x': //exit
								System.out.println("Are you sure you want to exit?");
								gw.setExitSelected(true);
								break;
							default:
								System.out.println("Invalid command");
								break;
								
						}//switch
					}//if
					else {
						switch (sCommand.charAt(0)){
							case 'y': //yes
								gw.exit();
								System.out.println("yes selected");
								break;
							case 'n': //no
								gw.setExitSelected(false);
								System.out.println("no selected");
								break;
							default:
								System.out.println("Invalid command");
								break;
						}//switch
					}//else
				}
				else
					System.out.println("Please enter a command");
			}//actionPerformed
		}//new ActionListener
		);//addActionListener
	}//play
	
}
