package com.bukkit.happo2000.BasicCommands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.CreatureType;
import org.bukkit.entity.Player;
import org.bukkit.Location;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class BasicCommands extends JavaPlugin implements CommandExecutor
{
    public BasicCommands() 
    {
        super(); 
    }

    public void onEnable() 
    {
        PluginDescriptionFile pdfFile = this.getDescription();

        getCommand("basic").setExecutor(this);
   
        System.out.println( pdfFile.getName() + " version " + pdfFile.getVersion() + " is enabled!" );
    }

    public void onDisable() 
    {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
    	String[] 	trimmedArgs 	= args;

        if (sender instanceof Player)
        {
            if (trimmedArgs.length > 0)
            {
	            String  subCommandName	= trimmedArgs[0].toLowerCase();
	
	            if (subCommandName.equals("spawn"))
	        	{
	        		Location loc = ((Player)sender).getLocation();
	        		
	        		loc.setX(loc.getX() + 10);
	        		
	        		this.getServer().getWorld("world").spawnCreature(loc, CreatureType.CREEPER);
	        	}
	        	else if (subCommandName.equals("time"))
	        	{
	        		this.getServer().getWorld("world").setTime(0);
	        	}
            }
            
        	return true;
        }
        
        return false;
    }
    
    public boolean isDebugging(final Player player) 
    {
    	return false;
    }

    public void setDebugging(final Player player, final boolean value) 
    {
    }
}

