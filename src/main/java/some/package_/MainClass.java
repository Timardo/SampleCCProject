package some.package_;

import net.minecraft.command.ICommandSender;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.timardo.contentcreator.loader.IContentAddon;
import net.timardo.contentcreator.loader.ContentLoaderManager;
import java.io.File;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MainClass implements IContentAddon {
    
    public static final String ADDON_ID = "sampleaddon";
    public static final String ADDON_NAME = "Sample Addon";
    public static final String ADDON_VER = "1.0";
    public static final Logger LOGGER = LogManager.getLogger(ADDON_NAME);
    public static File config;

    @Override
    public void load(ICommandSender sender, ContentLoaderManager mng) {
        sender.sendMessage(new TextComponentString("You just initialized sample addon!"));
        sender.sendMessage(new TextComponentString("Current player count: " + FMLCommonHandler.instance().getMinecraftServerInstance().getCurrentPlayerCount()));
        Config.registerConfig();
        mng.registerEventClass(new SampleEventClass());
        mng.registerCommand(new SampleCommand());
        // parts of code borrowed from GulliverReborn mod, one of those, which can be simply substituted with an addon, 
        // it's really awesome mod, check it out here -> https://www.curseforge.com/minecraft/mc-mods/gulliver-reborn
        mng.registerCommand(new MyResizeCommand());
        mng.registerCommand(new OthersResizeCommand());
    }

    @Override
    public void unload() {
        System.out.println("goodbye");
    }

    @Override
    public String getAddonID() {
        return ADDON_ID;
    }

    @Override
    public String getName() {
        return ADDON_NAME;
    }

    @Override
    public String getVersion() {
        return ADDON_VER;
    }
}
