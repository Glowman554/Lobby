package de.glowman554.lobby.utils;

import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import de.glowman554.lobby.LobbyMain;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.messaging.PluginMessageListener;

public class BungeeUtils implements Listener {
    public static void init() {
        LobbyMain.getInstance().getServer().getMessenger().registerOutgoingPluginChannel(LobbyMain.getInstance(), "BungeeCord");
        LobbyMain.getInstance().getServer().getMessenger().registerIncomingPluginChannel(LobbyMain.getInstance(), "BungeeCord", new PluginMessageListener() {
            @Override
            public void onPluginMessageReceived(String channel, Player player, byte[] message) {

            }
        });
    }
    public static void sendPlayer(Player player, String server) {
        ByteArrayDataOutput dataOutput = ByteStreams.newDataOutput();
        dataOutput.writeUTF("Connect");
        dataOutput.writeUTF(server);
        player.sendPluginMessage(LobbyMain.getInstance(), "BungeeCord", dataOutput.toByteArray());
    }
}