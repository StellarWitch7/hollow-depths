package stellarwitch7.hollow_depths.cca.entity

import net.minecraft.entity.player.PlayerEntity
import net.minecraft.nbt.NbtCompound
import net.minecraft.registry.RegistryWrapper
import org.ladysnake.cca.api.v3.component.sync.AutoSyncedComponent
import org.ladysnake.cca.api.v3.component.tick.ServerTickingComponent

class ShadeComponent(val player: PlayerEntity) : ServerTickingComponent, AutoSyncedComponent {
    override fun readFromNbt(tag: NbtCompound, registryLookup: RegistryWrapper.WrapperLookup) {
//        TODO("Not yet implemented")
    }

    override fun writeToNbt(tag: NbtCompound, registryLookup: RegistryWrapper.WrapperLookup) {
//        TODO("Not yet implemented")
    }

    override fun serverTick() {
//        TODO("Not yet implemented")
    }
}