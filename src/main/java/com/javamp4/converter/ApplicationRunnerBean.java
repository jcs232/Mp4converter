package com.javamp4.converter;

import java.io.File;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import ws.schild.jave.AudioAttributes;
import ws.schild.jave.Encoder;
import ws.schild.jave.EncodingAttributes;
import ws.schild.jave.MultimediaObject;
import ws.schild.jave.VideoAttributes;
import ws.schild.jave.VideoAttributes.X264_PROFILE;
import ws.schild.jave.VideoSize;

@Component
public class ApplicationRunnerBean implements ApplicationRunner {
	@Override
	public void run(ApplicationArguments arg0) throws Exception {
		System.out.println("ApplicationRunnerBean");
		/* Step 1. Declaring source file and Target file */
		File sourcevid = new File("src\\main\\resources\\test.mp4");
		MultimediaObject source = new MultimediaObject(sourcevid);
		File target = new File("target.m4a");

		/* Step 2. Set Audio Attrributes for conversion */
		AudioAttributes audio = new AudioAttributes();
		audio.setCodec("aac");
		// here 64kbit/s is 64000
		audio.setBitRate(64000);
		audio.setChannels(2);
		audio.setSamplingRate(44100);

	
		/* Step 3. Set Encoding Attributes */
		EncodingAttributes attrs = new EncodingAttributes();
		attrs.setFormat("m4a");
		attrs.setAudioAttributes(audio);

		/* Step 4. Do the Encoding */
		try {
			Encoder encoder = new Encoder(new FFlocator());
			encoder.encode(source, target, attrs);
		} catch (Exception e) {
			/* Handle here the video failure */
			e.printStackTrace();
		}
	}
}