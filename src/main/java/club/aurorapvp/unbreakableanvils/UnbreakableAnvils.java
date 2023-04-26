package club.aurorapvp.unbreakableanvils;

import club.aurorapvp.unbreakableanvils.events.AnvilEvents;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class UnbreakableAnvils extends JavaPlugin {

  public static Plugin INSTANCE;

  @Override
  public void onEnable() {
    // Plugin startup logic
    INSTANCE = this;

    Bukkit.getPluginManager().registerEvents(new AnvilEvents(), INSTANCE);
  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
  }
}
