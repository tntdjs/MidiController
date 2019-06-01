package com.tntdjs.mediaplayer;

/**
 * IMediaPlayerController
 * @author tsenausk
 */
public interface IMediaPlayerController {
	
	void next();
	
	void previous();
	
	void play();
	
	void stop();
	
	void pause();
	
	void setVolume();
	
	int getCurrentVolume();

	void setCurrentVolume(int currentVolume);

	int getMediaPlayerStatus();

	void close();

}