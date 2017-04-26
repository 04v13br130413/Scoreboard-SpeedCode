package me.enzol_.scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by EnzoL_ on 25/04/2017.
 */
public class ScoreboardTask extends BukkitRunnable {

    @Override
    public void run(){
        for(Player player : Bukkit.getOnlinePlayers()){
            ScoreboardHelper board = ScoreboardManager.getScoreboard(player);
            board.clear();

            board.add("&eTest&7: &f" + System.currentTimeMillis());

            board.update(player);
        }
    }
}
