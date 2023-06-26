package club.aurorapvp.unbreakableanvils.events.listeners;

import club.aurorapvp.unbreakableanvils.configs.Lang;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

public class AnvilEvents implements Listener {
  @EventHandler
  public void onAnvilUse(BlockDamageEvent event) {
    if (event.getBlock().getType() != Material.ANVIL) {
      return;
    }

    Location blockLoc = event.getBlock().getLocation();
    PersistentDataContainer container = event.getBlock().getWorld().getPersistentDataContainer();

    for (NamespacedKey key : container.getKeys()) {
      if (key.getKey().startsWith("ua")) {
        String locString = container.get(key, PersistentDataType.STRING);

        assert locString != null;
        if (locString.equals(blockLoc.toString())) {
          event.setCancelled(true);
        }
      }
    }
  }

  @EventHandler
  public void onAnvilBreak(BlockBreakEvent event) {
    if (event.getBlock().getType() != Material.ANVIL) {
      return;
    }

    Location blockLoc = event.getBlock().getLocation();
    PersistentDataContainer container = event.getBlock().getWorld().getPersistentDataContainer();

    for (NamespacedKey key : container.getKeys()) {
      if (key.getKey().startsWith("ua")) {
        String locString = container.get(key, PersistentDataType.STRING);

        assert locString != null;
        if (locString.equals(blockLoc.toString())) {
          event.getPlayer().sendMessage(Lang.getComponent("break-denied"));

          event.setCancelled(true);
        }
      }
    }
  }
}
