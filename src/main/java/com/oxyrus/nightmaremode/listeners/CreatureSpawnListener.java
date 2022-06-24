package com.oxyrus.nightmaremode.listeners;

import com.oxyrus.nightmaremode.managers.GameManager;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Monster;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.inventory.ItemStack;

public final class CreatureSpawnListener implements Listener {
    private final GameManager gameManager;

    public CreatureSpawnListener(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    @EventHandler
    public void onCreatureSpawn(CreatureSpawnEvent event) {
        if (!this.gameManager.nightmareModeEnabled()) return;

        var entity = event.getEntity();

        if (entity instanceof Monster) {
            entity.getEquipment().setBoots(new ItemStack(Material.DIAMOND_BOOTS));
            entity.getEquipment().setChestplate(new ItemStack(Material.DIAMOND_CHESTPLATE));
            entity.getEquipment().setHelmet(new ItemStack(Material.DIAMOND_HELMET));
            entity.getEquipment().setLeggings(new ItemStack(Material.DIAMOND_LEGGINGS));

            if (entity.getType() == EntityType.SKELETON) {
                var bow = new ItemStack(Material.BOW);
                bow.addEnchantment(Enchantment.ARROW_DAMAGE, 4);
                entity.getEquipment().setItemInMainHand(bow);
            }

            if (entity.getType() == EntityType.CREEPER) {
                var creeper = (Creeper)entity;
                creeper.setPowered(true);
            }
        }
    }
}
