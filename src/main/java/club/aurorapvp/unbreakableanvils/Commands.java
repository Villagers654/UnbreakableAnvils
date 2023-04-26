package club.aurorapvp.unbreakableanvils;

import club.aurorapvp.unbreakableanvils.commands.AnvilCommands;
import co.aikar.commands.PaperCommandManager;

public class Commands {
  public static PaperCommandManager MANAGER = new PaperCommandManager(UnbreakableAnvils.INSTANCE);

  public static void init() {
    MANAGER.registerCommand(new AnvilCommands());
  }
}
