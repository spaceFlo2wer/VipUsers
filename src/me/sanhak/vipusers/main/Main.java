package me.sanhak.vipusers.main;

import java.io.File;

import cn.nukkit.plugin.PluginBase;
import cn.nukkit.plugin.PluginManager;
import cn.nukkit.utils.Config;
import me.sanhak.vipusers.listeners.PlayerJoinListener;

public class Main extends PluginBase {

	private static Config config;
	private File file;
	private static Main instance;

	@Override
	public void onEnable() {
		instance = this;

		file = new File(this.getDataFolder(), "config.yml");
		config = new Config(file, Config.YAML);
		config.save();

		registerEvents();
		getLogger().info("Plugin has been enabled !");
	}

	@Override
	public void onDisable() {
		getLogger().info("Plugin has been disabled !");
	}

	void registerEvents() {
		PluginManager pluginManager = getServer().getPluginManager();
		pluginManager.registerEvents(new PlayerJoinListener(), this);
	}

	public static Main getInstance() {
		return instance;
	}

	public static Config getCfg() {
		return config;
	}

}
