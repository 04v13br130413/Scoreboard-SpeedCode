package me.enzol_.scoreboard;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerKickEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.Scoreboard;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Created by EnzoL_ on 25/04/2017.
 */
public class ScoreboardManager implements Listener {

    private static Map<UUID, ScoreboardHelper> scoreboard;

    public ScoreboardManager(){
        scoreboard = new HashMap<>();

        Bukkit.getPluginManager().registerEvents(this,  ScoreboardMain.getInstance());

        for(Player player : Bukkit.getOnlinePlayers()){
            onJoin(player);
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){
        onJoin(event.getPlayer());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){
        scoreboard.remove(event.getPlayer().getUniqueId());
    }

    @EventHandler
    public void onKick(PlayerKickEvent event){
        scoreboard.remove(event.getPlayer().getUniqueId());
    }

    public void onJoin(Player player){
        Scoreboard score = Bukkit.getScoreboardManager().getNewScoreboard();
        player.setScoreboard(score);
        ScoreboardHelper helper = new ScoreboardHelper(score, color("&aYoutube"));
        scoreboard.put(player.getUniqueId(), helper);
    }

    public static ScoreboardHelper getScoreboard(Player player){
        return scoreboard.get(player.getUniqueId());
    }

    public String color(String str){
        return ChatColor.translateAlternateColorCodes('&', str);
    }
}
