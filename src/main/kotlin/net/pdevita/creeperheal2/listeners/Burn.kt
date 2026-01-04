package net.pdevita.creeperheal2.listeners

import net.pdevita.creeperheal2.CreeperHeal2
import org.bukkit.Material
import org.bukkit.block.Block
import org.bukkit.event.EventHandler
import org.bukkit.event.EventPriority
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBurnEvent
import kotlin.collections.List

class Burn (var plugin: CreeperHeal2) : Listener {
    @EventHandler(priority = EventPriority.HIGH)
    fun onBurnEvent(event: BlockBurnEvent)
    {
        //plugin.debugLogger("A burn event has happened! ${event.block.toString()}")
        if (event.block.location.world?.let { plugin.settings.worldList.allowWorld(it.name) } == true) {
            var bl = ArrayList<Block>()
            bl.add(event.block)
            this.plugin.createNewExplosion(bl)
        }
    }
}