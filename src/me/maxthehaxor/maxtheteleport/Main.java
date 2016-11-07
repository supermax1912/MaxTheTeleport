package me.maxthehaxor.maxthespawn;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener
{
	public void onEnable()
	{
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		Bukkit.getServer().getLogger().info("MaxTheSpawn v" + getDescription().getVersion() + " by MaxTheHaxor has been enabled.");
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event)
	{
		Firework f = (Firework) event.getPlayer().getWorld().spawn(event.getPlayer().getLocation(), Firework.class);
		FireworkMeta fm = f.getFireworkMeta();
		fm.addEffects(FireworkEffect.builder().flicker(false).with(Type.CREEPER).trail(true).withColor(Color.RED).withFade(Color.BLUE).build());
		fm.setPower(3);
		f.setFireworkMeta(fm);
	}
}
