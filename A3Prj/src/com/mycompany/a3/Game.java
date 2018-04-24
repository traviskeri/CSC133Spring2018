package com.mycompany.a3;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.*;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.UITimer;

/**
 * This is the Game class. The GameWorld is instantiated here.
 * @author Travis Keri
 * @version 1.0
 */

public class Game extends Form implements Runnable, ActionListener{

	private GameWorld gw;
	private MapView mv;
	private ScoreView sv;
	private AccelerateCommand accelCommand;
	private BreakCommand bCommand;
	private LeftTurnCommand ltCommand;
	private RightTurnCommand rtCommand;
	private ExitCommand eCommand;
	private SoundCommand sCommand;
	private AboutCommand aboutCommand;
	private HelpCommand hCommand;
	private PauseCommand pCommand;
	private PositionCommand posCommand;
	private UITimer timer;
	private Button accelerateButton;
	private Button breakButton;
	private Button leftTurnButton;
	private Button rightTurnButton;
	private Button pauseButton;
	private Button positionButton;
	private Button aSideButton;
	private BGSound bgSound;
	private Sound sSound;
	private Sound fSound;
	private Sound fsSound;
	private int time = 50;
	private Style disabledStyle;

	
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
		eCommand = new ExitCommand(gw);
		sCommand = new SoundCommand(gw);
		aboutCommand = new AboutCommand();
		hCommand = new HelpCommand();
		pCommand = new PauseCommand(gw);
		posCommand =  new PositionCommand(gw);
		bgSound = new BGSound("bgsound.wav");
		
		
		this.setLayout(new BorderLayout());
		this.add(BorderLayout.NORTH, sv);
		this.add(BorderLayout.CENTER, mv);
		
		accelerateButton = new Button("Accelerate");
		accelerateButton.getAllStyles().setBgTransparency(255);
		accelerateButton.getAllStyles().setBgColor(ColorUtil.GREEN);
		accelerateButton.getAllStyles().setFgColor(ColorUtil.BLACK);
		accelerateButton.setCommand(accelCommand);	
		
		disabledStyle = new Style(accelerateButton.getStyle());
		disabledStyle.setBgColor(ColorUtil.WHITE);
		accelerateButton.setDisabledStyle(disabledStyle);
		
		breakButton = new Button("Break");
		breakButton.getAllStyles().setBgTransparency(255);
		breakButton.getAllStyles().setBgColor(ColorUtil.rgb(255, 0, 0));
		breakButton.getAllStyles().setFgColor(ColorUtil.BLACK);
		breakButton.setCommand(bCommand);
		breakButton.setDisabledStyle(disabledStyle);
		
		leftTurnButton = new Button("Turn Left");
		leftTurnButton.getAllStyles().setBgTransparency(255);
		leftTurnButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		leftTurnButton.getAllStyles().setFgColor(ColorUtil.BLACK);
		leftTurnButton.setCommand(ltCommand);
		leftTurnButton.setDisabledStyle(disabledStyle);
		
		rightTurnButton = new Button("Trun Right");
		rightTurnButton.getAllStyles().setBgTransparency(255);
		rightTurnButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		rightTurnButton.getAllStyles().setFgColor(ColorUtil.BLACK);
		rightTurnButton.setCommand(rtCommand);
		rightTurnButton.setDisabledStyle(disabledStyle);
		
		pauseButton = new Button("Play/Pause");
		pauseButton.getAllStyles().setBgTransparency(255);
		pauseButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		pauseButton.getAllStyles().setFgColor(ColorUtil.BLACK);
		pauseButton.setCommand(pCommand);
		pauseButton.addActionListener(this);
		
		positionButton = new Button("Position");
		positionButton.getAllStyles().setBgTransparency(255);
		positionButton.getAllStyles().setBgColor(ColorUtil.BLUE);
		positionButton.getAllStyles().setFgColor(ColorUtil.BLACK);
		positionButton.setCommand(posCommand);
		Style posStyle = new Style(disabledStyle);
		positionButton.setDisabledStyle(posStyle);
		positionButton.setEnabled(false);
		
		
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
		aSideButton = new Button("Accelerate");
		aSideButton.setCommand(accelCommand);
		myToolbar.addComponentToSideMenu(aSideButton);
		//myToolbar.addCommandToSideMenu(accelCommand);
		myToolbar.addCommandToSideMenu(aboutCommand);
		myToolbar.addCommandToSideMenu(hCommand);
		myToolbar.addCommandToSideMenu(eCommand);
		myToolbar.addCommandToRightBar(hCommand);
		CheckBox soundCheckBox = new CheckBox("Sound OFF/ON");
		soundCheckBox.getAllStyles().setBgTransparency(255);
		soundCheckBox.getAllStyles().setBgColor(ColorUtil.LTGRAY);
		soundCheckBox.setCommand(sCommand);
		myToolbar.addComponentToSideMenu(soundCheckBox);
		
		leftContainer.add(accelerateButton);
		this.addKeyListener('a', accelCommand);
		
		rightContainer.add(breakButton);
		this.addKeyListener('b', bCommand);
		
		leftContainer.add(leftTurnButton);
		this.addKeyListener('l', ltCommand);
		
		rightContainer.add(rightTurnButton);
		this.addKeyListener('r', rtCommand);
		
		this.addKeyListener('x', eCommand);
		
		bottomContainer.add(pauseButton);
		
		bottomContainer.add(positionButton);
		
		
		timer = new UITimer(this);
		timer.schedule(time, true, this);
		this.show();
		bgSound.play();
		mv.setMapViewSize();
		gw.init();
	}

	public void run() {
		gw.clockTick(time);
		checkSounds();
		mv.repaint();
	}
	
public void actionPerformed(ActionEvent evt) {
		if(gw.isPauseEnabled()) { checkPaused(); }
		
	}
	
	public void checkPaused() {
		
		boolean enableCheck = !gw.isPaused();
		
		accelCommand.setEnabled(enableCheck);
		bCommand.setEnabled(enableCheck);
		ltCommand.setEnabled(enableCheck);
		rtCommand.setEnabled(enableCheck);
		
		accelerateButton.setEnabled(enableCheck);
		breakButton.setEnabled(enableCheck);
		leftTurnButton.setEnabled(enableCheck);
		rightTurnButton.setEnabled(enableCheck);
		aSideButton.setEnabled(enableCheck);
		positionButton.setEnabled(!enableCheck);
		
		
		if(gw.isPaused()) {
			bgSound.pause();
			this.removeKeyListener('a', accelCommand);
			this.removeKeyListener('b', bCommand);
			this.removeKeyListener('l', ltCommand);
			this.removeKeyListener('r', rtCommand);
		}
		else if(!gw.isPaused()) {
			bgSound.play();
			this.addKeyListener('a', accelCommand);
			this.addKeyListener('b', bCommand);
			this.addKeyListener('l', ltCommand);
			this.addKeyListener('r', rtCommand);
		}
		
		gw.setPauseEnabled(false);
	}
	
	public void checkSounds() {
		
		if(gw.isSound()){
			if(gw.issCollision()) {
				gw.setsCollision(false);
				sSound = new Sound("alertred.wav", "audio/wav");
				sSound.play();
			}
			if(gw.isfCollision()) {
				gw.setfCollision(false);
				fSound = new Sound("Cartoon_Effeckt.mp3", "audio/mp3");
				fSound.play();
			}
			if(gw.isFsCollision()) {
				gw.setFsCollision(false);
				fsSound = new Sound("VehicleDie1.wav", "audio/wav");
				fsSound.play();
				System.out.println(gw.isFsCollision());
			}
			if(gw.isSoundChanged()) {
				bgSound.play();
				gw.setSoundChanged(false);
			}
		}
		else {
			if(gw.isSoundChanged()) {
				bgSound.pause();
				gw.setSoundChanged(false);
			}
		}
	}

	
	
}
