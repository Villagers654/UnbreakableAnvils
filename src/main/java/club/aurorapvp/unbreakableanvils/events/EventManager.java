package club.aurorapvp.unbreakableanvils.events;

import club.aurorapvp.unbreakableanvils.UnbreakableAnvils;
import club.aurorapvp.unbreakableanvils.events.listeners.AnvilEvents;
import org.bukkit.Bukkit;

public class EventManager {
  public static void init() {
    Bukkit.getPluginManager().registerEvents(new AnvilEvents(), UnbreakableAnvils.INSTANCE);
  }
}
