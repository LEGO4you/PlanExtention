package me.lego4you.planextention;

import me.lego4you.planextention.extention.PlanHook;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginLogger;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;
import java.util.logging.LogRecord;

public final class PlanExtention extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        try {
            new PlanHook().hookIntoPlan();
        } catch (NoClassDefFoundError planIsNotInstalled) {
            PluginLogger logger = (PluginLogger) Bukkit.getLogger();
            logger.log(new LogRecord(Level.ALL, "Plan Player Analytics is not installed! please install it to propperly enable this plugin"));
            Bukkit.getPluginManager().disablePlugin(this);
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
