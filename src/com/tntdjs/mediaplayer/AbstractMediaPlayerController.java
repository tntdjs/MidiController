package com.tntdjs.mediaplayer;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import javazoom.jlgui.basicplayer.BasicController;
import javazoom.jlgui.basicplayer.BasicPlayer;
import javazoom.jlgui.basicplayer.BasicPlayerException;

/**
 * AbstractMediaPlayerController
 * Contains one of either 2 alternate players; BasicPlayer or AdvancedPlayer which is 
 * 		new AdvancedPlayer(new BufferedInputStream(fis));
 * 
 * @author tsenausk
 */
public abstract class AbstractMediaPlayerController implements IMediaPlayerController {
	private static final Logger LOGGER = LogManager.getLogger(AbstractMediaPlayerController.class.getName());
	
	protected int MEDIA_PLAYER_STATUS = MediaPlayerState.INIT;
	
	protected final BasicPlayer MEDIA_PLAYER = new BasicPlayer();
	protected final BasicController MEDIA_CONTROLLER = (BasicController) MEDIA_PLAYER;
	
	protected String CURRENT_SONG = "";
	protected int CURRENT_VOLUME;

	protected abstract void openFile();
	
	/**
	 * openFile
	 * @param currentSong
	 */
	protected void openFile(String currentSong) {
		CURRENT_SONG = currentSong;
		openFile();
	}
		
	/* (non-Javadoc)
	 * @see com.tntdjs.mediaplayer.IMediaPlayerController#getCurrentVolume()
	 */
	@Override
	public int getCurrentVolume() {
		return CURRENT_VOLUME;
	}

	/* (non-Javadoc)
	 * @see com.tntdjs.mediaplayer.IMediaPlayerController#setCurrentVolume(int)
	 */
	@Override
	public void setCurrentVolume(int currentVolume) {
		this.CURRENT_VOLUME = currentVolume;
	}

	/* (non-Javadoc)
	 * @see com.tntdjs.mediaplayer.IMediaPlayerController#getMediaPlayerStatus()
	 */
	@Override
	public int getMediaPlayerStatus() {
		return MEDIA_PLAYER_STATUS;
	}
	
	/* (non-Javadoc)
	 * @see com.tntdjs.mediaplayer.IMediaPlayerController#close()
	 */
	@Override
	public void close() {
		if ((MEDIA_PLAYER_STATUS == MediaPlayerState.PAUSE) || (MEDIA_PLAYER_STATUS == MediaPlayerState.PLAY)) {
			try {
				if (MEDIA_PLAYER != null) {
					MEDIA_PLAYER.stop();
				}
			} catch (BasicPlayerException e) {
				LOGGER.error("Cannot stop", e);
			}
		}
	}
}