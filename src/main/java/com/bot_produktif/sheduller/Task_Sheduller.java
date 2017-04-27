package com.bot_produktif.sheduller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.ScheduledFuture;

import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.apache.commons.configuration.PropertiesConfiguration;


/*
 * Author : IF
 * Date : Kamis, 27 April 2017. 16:40
 * Eksplorasi task scheduler di java. Calon class reminder adzan
 */
@PropertySource(value= {"classpath:cron_adzan.properties"})
@Component
public class Task_Sheduller {
	
	private static final String PATH = "src/main/resources/cron_adzan.properties";
	
	@Scheduled(cron = "${update}")
	public void update_cron() {
		try {			
			PropertiesConfiguration prop = new PropertiesConfiguration(PATH);
			prop.setProperty("shubuh", "--cron dzuhur");
			prop.setProperty("dzuhur", "--cron dzuhur");
			prop.setProperty("maghrib", "--cron maghrib");
			prop.setProperty("ashar", "--cron ashar");
			prop.setProperty("isya", "--cron isya");
			
			prop.save();
			System.out.println("Cron has been successfully updated.");
		}
		
		catch (Exception e){
			System.out.println(e.getMessage());
		}
	}


}
