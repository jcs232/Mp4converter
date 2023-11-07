package com.javamp4.converter;

import ws.schild.jave.FFMPEGLocator;

public class FFlocator extends FFMPEGLocator{
//set this to your ffmpeg location
	@Override
	protected String getFFMPEGExecutablePath() {
		return("src\\main\\resources\\ffmpeg.exe");
	}
	
}
