package club.aurorapvp.unbreakableanvils.commands;

import club.aurorapvp.unbreakableanvils.UnbreakableAnvils;
import club.aurorapvp.unbreakableanvils.configs.Lang;
import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CatchUnknown;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.Subcommand;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;

@CommandAlias("unbreakableanvils|ua")
public class AnvilCommands extends BaseCommand {
  @Subcommand("set")
  @CommandPermission("unbreakableanvils.admin")
  @Description("Sets an anvil as unbreakable")
  @SuppressWarnings("unused")
  public void onSet(Player p) {
    Block block = p.getTargetBlockExact(5);

    assert block != null;
    if (block.getType() != Material.ANVIL) {
      return;
    }

    int index = 0;
    PersistentDataContainer container = p.getWorld().getPersistentDataContainer();

    for (NamespacedKey setKey : container.getKeys()) {
      int keyIndex = Integer.parseInt(setKey.getKey().replace("ua", ""));

      index = Math.max(index, keyIndex);
    }

    NamespacedKey key = new NamespacedKey(UnbreakableAnvils.INSTANCE, "ua" + index);

    container.set(key, PersistentDataType.STRING, block.getLocation().toString());

    p.sendMessage(Lang.getComponent("set"));
  }

  @Subcommand("unset")
  @CommandPermission("unbreakableanvils.admin")
  @Description("Makes an unbreakable anvil breakable")
  @SuppressWarnings("unused")
  public void onUnset(Player p) {
    Block block = p.getTargetBlockExact(5);

    assert block != null;
    if (block.getType() != Material.ANVIL) {
      return;
    }

    Location blockLoc = block.getLocation();
    PersistentDataContainer container = block.getWorld().getPersistentDataContainer();

    for (NamespacedKey key : container.getKeys()) {
      if (key.getKey().startsWith("ua")) {
        String locString = container.get(key, PersistentDataType.STRING);

        assert locString != null;
        if (locString.equals(blockLoc.toString())) {
          container.remove(key);
        }
      }
    }

    p.sendMessage(Lang.getComponent("unset"));
  }
}
