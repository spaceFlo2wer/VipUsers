package me.sanhak.vipusers.listeners;

import java.util.List;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerJoinEvent;
import me.sanhak.vipusers.main.Main;
import me.sanhak.vipusers.utils.ListUtils;
import me.sanhak.vipusers.utils.StringUtils;

public class PlayerJoinListener implements Listener {

	@EventHandler
	public void onVipPlayerUserJoin(PlayerJoinEvent playerJoinEvent) {
		Player eventPlayer = playerJoinEvent.getPlayer();

		List<String> vip_users_list = Main.getCfg().getStringList("Vip-Users");
		List<String> messages = Main.getCfg().getStringList("Messages");

		for (String name : vip_users_list) {
			if (eventPlayer.getName().equalsIgnoreCase(name)) {
				eventPlayer.sendMessage(StringUtils.format(ListUtils.toString(messages)));
			}
		}
	}

}
