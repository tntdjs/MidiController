package com.tntdjs.mediaplayer;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.tntdjs.utils.SystemPropertyMgr;

import javazoom.jlgui.basicplayer.BasicPlayerException;

/**
 * MediaPlayerController
 * 
 * Contains one of either 2 alternate players; BasicPlayer or AdvancedPlayer which is 
 * 		new AdvancedPlayer(new BufferedInputStream(fis));
 * 
 * @author tsenausk
 */
public class MediaPlayerController extends AbstractMediaPlayerController {
	private static final Logger LOGGER = LogManager.getLogger(MediaPlayerController.class.getName());

	/**
	 * Constructor
	 * @param currentSong
	 */
	public MediaPlayerController(String currentSong) {
		super();
		setCurrentVolume(Integer.valueOf(SystemPropertyMgr.getInstance().getString("audio.volume.level")));		
		openFile(currentSong);
	}
	
	@Override
	protected void openFile() {
		try {
//			FileInputStream fis = new FileInputStream(CURRENT_SONG);
			MEDIA_CONTROLLER.open(new File(CURRENT_SONG)); //new BufferedInputStream(fis));
						
			List<?> mixers = MEDIA_PLAYER.getMixers();
			if (mixers != null) {
				Iterator<?> it = mixers.iterator();
				String mixer = SystemPropertyMgr.getInstance().getString("audio.device");
				boolean mixerFound = false;
				if ((mixer != null) && (mixer.length() > 0)) {
					// Check if mixer is valid.
					while (it.hasNext()) {
						if (((String) it.next()).equals(mixer)) {
							MEDIA_PLAYER.setMixerName(mixer);
							mixerFound = true;
							break;
						}
					}
				}
				if (mixerFound == false) {
					// Attempt to assign the first mixer found.
					it = mixers.iterator();
					if (it.hasNext()) {
						mixer = (String) it.next();
						MEDIA_PLAYER.setMixerName(mixer);
					}
				}
			}												
		} catch (Exception e) {
			LOGGER.error("Problem opening audio file - " + CURRENT_SONG, e);
		}
	}
		
	public void pause() {
		if (MEDIA_PLAYER_STATUS == MediaPlayerState.PLAY) {
			try {
				MEDIA_CONTROLLER.pause();
			} catch (BasicPlayerException e) {
				LOGGER.error("Cannot pause", e);
			}
			MEDIA_PLAYER_STATUS = MediaPlayerState.PAUSE;
		} else if (MEDIA_PLAYER_STATUS == MediaPlayerState.PAUSE) {
			try {
				MEDIA_CONTROLLER.resume();
			} catch (BasicPlayerException e) {
				LOGGER.info("Cannot resume", e);
			}
			MEDIA_PLAYER_STATUS = MediaPlayerState.PLAY;
		}	
	}
	
	public void stop() {
		if ((MEDIA_PLAYER_STATUS == MediaPlayerState.PAUSE) || (MEDIA_PLAYER_STATUS == MediaPlayerState.PLAY)) {
			try {
				if (null != MEDIA_CONTROLLER) {
					MEDIA_CONTROLLER.stop();					
				}
			} catch (BasicPlayerException e) {
				LOGGER.info("Cannot stop", e);
			}
			MEDIA_PLAYER_STATUS = MediaPlayerState.STOP;
		}
	}
	
	/**
	 * Play
	 * @param filename
	 */
	public void play() {
		if (MEDIA_PLAYER_STATUS == MediaPlayerState.PAUSE) {
			try {
				MEDIA_CONTROLLER.resume();
			} catch (BasicPlayerException e) {
				LOGGER.error("Cannot resume", e);
			}
		}		
		try {
			MEDIA_CONTROLLER.play();
		} catch (BasicPlayerException e) {
			LOGGER.debug(e);
		}
		setVolume();
		MEDIA_PLAYER_STATUS = MediaPlayerState.PLAY;
	}


	@Override
	public void setVolume() {		
		try {
			MEDIA_CONTROLLER.setGain(((double) CURRENT_VOLUME / (double) 100));
			SystemPropertyMgr.getInstance().setString("audio.volume.level", CURRENT_VOLUME+"");
			SystemPropertyMgr.getInstance().saveProperties();
		} catch (BasicPlayerException e) {
			LOGGER.error(e);
		}
	}

	@Override
	public void next() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void previous() {
		// TODO Auto-generated method stub
		
	}
	
}
