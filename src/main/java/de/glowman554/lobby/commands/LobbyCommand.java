package de.glowman554.lobby.commands;

import de.glowman554.lobby.LobbyMain;
import de.glowman554.lobby.utils.BungeeUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LobbyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage("Player only command!");
        } else {
            Player player = (Player) commandSender;
            BungeeUtils.sendPlayer(player, LobbyMain.getInstance().getLobby());
        }
        return false;
    }
}
