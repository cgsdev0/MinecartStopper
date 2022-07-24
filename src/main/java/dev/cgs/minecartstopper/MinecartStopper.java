package dev.cgs.minecartstopper;

import org.bukkit.Bukkit;
import org.bukkit.entity.Minecart;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleExitEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public final class MinecartStopper extends JavaPlugin implements Listener {

  @EventHandler
  public void onExitMinecart(VehicleExitEvent e) {
    if(e.getExited() instanceof Player && e.getVehicle() instanceof Minecart) {
      e.getVehicle().setVelocity(new Vector(0, 0, 0));
      ((Minecart)e.getVehicle()).setMaxSpeed(0.4D);
    }
  }

  @Override
  public void onEnable() {
    this.getServer().getPluginManager().registerEvents(this, this);
    Bukkit.getLogger().info("Minecart Stopper has been enabled!");
  }

  @Override
  public void onDisable() {
    Bukkit.getLogger().info("Minecart Stopper has been disabled.");
  }
}
