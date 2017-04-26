package me.enzol_.scoreboard;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by EnzoL_ on 25/04/2017.
 */
public class ScoreboardMain extends JavaPlugin {

     private static ScoreboardMain instance;

    public void onEnable(){

        instance = this;

        new ScoreboardManager();
        new ScoreboardTask().runTaskTimer(this , 0L, 3L);

    }

    public void onDisable(){}

    public static ScoreboardMain getInstance(){
        return instance;
    }
}
