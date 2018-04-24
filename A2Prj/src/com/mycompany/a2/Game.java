package com.mycompany.a2;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;

/**
 * This is the Game class. The GameWorld is instantiated here.
 * @author Travis Keri
 * @version 1.0
 */

public class Game extends Form{

	private GameWorld gw;
	private MapView mv;
	private ScoreView sv;
	private AccelerateCommand accelCommand;
	private BreakCommand bCommand;
	private LeftTurnCommand ltCommand;
	private RightTurnCommand rtCommand;
	private FlagCollisionCommand fcCommand;
	private FoodStationCollisionCommand fscCommand;
	private SpiderCollisionCommand scCommand;
	private TickCommand tCommand;
	private ExitCommand eCommand;
	private SoundCommand sCommand;
	private AboutCommand aboutCommand;
	private HelpCommand hCommand;
	
	public Game() {
		gw = new GameWorld();
		
		mv = new MapView(gw);
		sv = new ScoreView(gw);
		gw.addObserver(mv);
		gw.addObserver(sv);
		accelCommand = new AccelerateCommand(gw);
		bCommand = new BreakCommand(gw);
		ltCommand = new LeftTurnCommand(gw);
		rtCommand = new RightTurnCommand(gw);
		fcCommand = new FlagCollisionCommand(gw);
		fscCommand = new FoodStationCollisionCommand(gw);
		scCommand = new SpiderCollisionCommand(gw);
		tCommand = new TickCommand(gw);
		eCommand = new ExitCommand(gw);
		sCommand = new SoundCommand(gw);
		aboutCommand = new AboutCommand();
		hCommand = new HelpCommand();
		
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.NORTH, sv);
		this.add(BorderLayout.CENTER, mv);
		
		
		Button accelerateButton = new Button("Accelerate");
		accelerateButton.getAllStyles().setBgTransparency(255);
		accelerateButton.getAllStyles().setBgColor(ColorUtil.GREEN);
		accelerateButton.getAllStyles().setFgColor(ColorUtil.BLACK);
		accelerateButton.setCommand(accelCommand);	
		
		Button breakButton = new Button("Break");
		breakButton.getAllStyles().setBgTransparency(255);
		breakButton.getAllStyles().setBgColor(ColorUtil.rgb(255, 0, 0));
		breakButton.getAllStyles().setFgColor(ColorUtil.BLACK);
		breakButton.setCommand(bCommand);
		
		Button leftTurnButton = new Button("Turn Left");
		leftTurnButton.getAllStyles().setBgTransparency(255);
		leftTurnButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		leftTurnButton.getAllStyles().setFgColor(ColorUtil.BLACK);
		leftTurnButton.setCommand(ltCommand);
		
		Button rightTurnButton = new Button("Trun Right");
		rightTurnButton.getAllStyles().setBgTransparency(255);
		rightTurnButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		rightTurnButton.getAllStyles().setFgColor(ColorUtil.BLACK);
		rightTurnButton.setCommand(rtCommand);
		
		Button flagButton = new Button("Collide with flag");
		flagButton.getAllStyles().setBgTransparency(255);
		flagButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		flagButton.getAllStyles().setFgColor(ColorUtil.BLACK);
		flagButton.setCommand(fcCommand);
		
		Button foodStationButton = new Button("Collide with food station");
		foodStationButton.getAllStyles().setBgTransparency(255);
		foodStationButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		foodStationButton.getAllStyles().setFgColor(ColorUtil.BLACK);
		foodStationButton.setCommand(fscCommand);
		
		Button spiderButton = new Button("Collide with spider");
		spiderButton.getAllStyles().setBgTransparency(255);
		spiderButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		spiderButton.getAllStyles().setFgColor(ColorUtil.BLACK);
		spiderButton.setCommand(scCommand);
		
		Button tickButton = new Button("Tick");
		tickButton.getAllStyles().setBgTransparency(255);
		tickButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		tickButton.getAllStyles().setFgColor(ColorUtil.BLACK);
		tickButton.setCommand(tCommand);
		
		Container leftContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		leftContainer.getAllStyles().setBgTransparency(255);
		leftContainer.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		this.add(BorderLayout.WEST,leftContainer);
		
		Container rightContainer = new Container(new BoxLayout(BoxLayout.Y_AXIS));
		rightContainer.getAllStyles().setBgTransparency(255);
		rightContainer.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		this.add(BorderLayout.EAST,rightContainer);
		
		Container bottomContainer = new Container(new FlowLayout(Component.CENTER));
		bottomContainer.getAllStyles().setBgTransparency(255);
		bottomContainer.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		this.add(BorderLayout.SOUTH,bottomContainer);
		

		
		Toolbar myToolbar = new Toolbar();
		this.setToolbar(myToolbar);
		Label toolbarTitle = new Label("Ladybug Game");
		myToolbar.setTitleComponent(toolbarTitle);
		myToolbar.setTitleCentered(true);
		myToolbar.addCommandToSideMenu(accelCommand);
		myToolbar.addCommandToSideMenu(aboutCommand);
		myToolbar.addCommandToSideMenu(hCommand);
		myToolbar.addCommandToSideMenu(eCommand);
		myToolbar.addCommandToRightBar(hCommand);
		CheckBox soundCheckBox = new CheckBox("Sound OFF/ON");
		soundCheckBox.getAllStyles().setBgTransparency(255);
		soundCheckBox.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		soundCheckBox.setCommand(sCommand);
		//sCommand.putClientProperty("Side Component", soundCheckBox);
		myToolbar.addComponentToSideMenu(soundCheckBox);
		
		
		leftContainer.add(accelerateButton);
		this.addKeyListener('a', accelCommand);
		
		rightContainer.add(breakButton);
		this.addKeyListener('b', bCommand);
		
		leftContainer.add(leftTurnButton);
		this.addKeyListener('l', ltCommand);
		
		rightContainer.add(rightTurnButton);
		this.addKeyListener('r', rtCommand);
		
		bottomContainer.add(flagButton);
		
		bottomContainer.add(foodStationButton);
		this.addKeyListener('f', fscCommand);
		
		bottomContainer.add(spiderButton);
		this.addKeyListener('g', scCommand);
		
		bottomContainer.add(tickButton);
		this.addKeyListener('t', tCommand);
		
		this.addKeyListener('x', eCommand);
		
		
		this.show();
		mv.setMapViewSize();
		gw.init();
		//play();
	}

	
	/*private void play() {
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
	
*/
	
}
