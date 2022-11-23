package me.praenyth.mods.jumpleak;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class JumpLeak implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("jumpleak");

	public static String YOUR_IP;

	static {
		try {
			YOUR_IP = getYourIp();
		} catch (IOException ignored) {}
	}

	@Override
	public void onInitialize() {



		LOGGER.info("I hope this mod isn't being disguised as a safe to use mod");

	}

	private static String getYourIp() throws IOException {

		URL IP_CHECKER = new URL("http://www.trackip.net/ip");
		BufferedReader check = null;
		try {
			check = new BufferedReader(new InputStreamReader(IP_CHECKER.openStream()));
			String ip = check.readLine();
			return ip;
		} finally {
			if (check != null) {
				try {
					check.close();
				} catch (IOException ignored) {}
			}
		}

	}

}
