package club.aurorapvp.unbreakableanvils.commands;

import club.aurorapvp.unbreakableanvils.UnbreakableAnvils;
import co.aikar.commands.PaperCommandManager;

public class CommandManager {
  public static PaperCommandManager MANAGER = new PaperCommandManager(UnbreakableAnvils.INSTANCE);

  public static void init() {
    MANAGER.registerCommand(new AnvilCommands());
  }
}
