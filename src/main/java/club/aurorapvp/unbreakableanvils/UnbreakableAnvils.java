package club.aurorapvp.unbreakableanvils;

import club.aurorapvp.unbreakableanvils.commands.CommandManager;
import club.aurorapvp.unbreakableanvils.configs.Lang;
import club.aurorapvp.unbreakableanvils.events.EventManager;
import java.io.File;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class UnbreakableAnvils extends JavaPlugin {

  public static Plugin INSTANCE;
  public static File DATA_FOLDER;

  @Override
  public void onEnable() {
    // Plugin startup logic
    INSTANCE = this;
    DATA_FOLDER = this.getDataFolder();

    CommandManager.init();
    Lang.init();
    EventManager.init();
  }

  @Override
  public void onDisable() {
    // Plugin shutdown logic
  }
}
