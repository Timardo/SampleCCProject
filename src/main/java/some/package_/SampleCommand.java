package some.package_;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.command.CommandException;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;

public class SampleCommand implements ICommand {
    
    private List<String> aliases = new ArrayList<>();
    
    public SampleCommand() {
        this.aliases.add("samplealias");
    }

    @Override
    public int compareTo(ICommand o) {
        return 0;
    }
    
    @Override
    public String getName() {
        return "samplecommand";
    }
    
    @Override
    public String getUsage(ICommandSender sender) {
        return "/samplecommand";
    }
    
    @Override
    public List<String> getAliases() {
        return this.aliases ;
    }
    
    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        server.getEntityWorld().getWorldInfo().setRaining(true);
        server.getEntityWorld().getWorldInfo().setThundering(true);
        sender.sendMessage(new TextComponentString("It's raining day!"));
    }
    
    @Override
    public boolean checkPermission(MinecraftServer server, ICommandSender sender) {
        return true;
    }
    
    @Override
    public List<String> getTabCompletions(MinecraftServer server, ICommandSender sender, String[] args, BlockPos targetPos) {
        return null;
    }
    
    @Override
    public boolean isUsernameIndex(String[] args, int index) {
        return false;
    }
    
}
