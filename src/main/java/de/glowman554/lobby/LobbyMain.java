package de.glowman554.lobby;

import de.glowman554.lobby.commands.LobbyCommand;
import de.glowman554.lobby.utils.BungeeUtils;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class LobbyMain extends JavaPlugin {
    private static LobbyMain instance;
    public LobbyMain() {
        instance = this;
    }

    private final FileConfiguration config = getConfig();
    private String lobby;

    @Override
    public void onLoad() {
        config.addDefault("lobby", "lobby");
        config.options().copyDefaults(true);
        saveConfig();
        reloadConfig();

        lobby = config.getString("lobby");
    }

    @Override
    public void onEnable() {
        BungeeUtils.init();

        getCommand("lobby").setExecutor(new LobbyCommand());
    }

    public static LobbyMain getInstance() {
        return instance;
    }

    public String getLobby() {
        return lobby;
    }
}
