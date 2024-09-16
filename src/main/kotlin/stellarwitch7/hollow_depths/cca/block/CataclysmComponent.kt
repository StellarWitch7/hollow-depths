package stellarwitch7.hollow_depths.cca.block

import net.minecraft.block.entity.SculkCatalystBlockEntity
import net.minecraft.nbt.NbtCompound
import net.minecraft.registry.RegistryWrapper
import org.ladysnake.cca.api.v3.component.tick.ServerTickingComponent

class CataclysmComponent(val blockEntity: SculkCatalystBlockEntity) : ServerTickingComponent {
    private var deathsLeft: Int = 1 //TODO: x100
    private var ticksSinceLastSpread: Int = 0
    private var power: Int = 0
    var locked: Boolean = false
        private set

    override fun readFromNbt(tag: NbtCompound, registryLookup: RegistryWrapper.WrapperLookup) {
        deathsLeft = tag.getInt("deaths_left")
        power = tag.getInt("power")
        locked = tag.getBoolean("locked")
    }

    override fun writeToNbt(tag: NbtCompound, registryLookup: RegistryWrapper.WrapperLookup) {
        tag.putInt("deaths_left", deathsLeft)
        tag.putInt("power", power)
        tag.putBoolean("locked", locked)
    }

    override fun serverTick() {
        if (deathsLeft <= 0 && ticksSinceLastSpread > 100) {
            if (locked) {
                charge()
            } else {
//                blockEntity.eventListener.spreadManager.spread(blockEntity.pos, 10)
            }

            ticksSinceLastSpread = 0
            deathsLeft = 0
        }

        ticksSinceLastSpread++
    }

    fun charge() {
        power = Math.clamp(power + 1L, 0, MAX_POWER)
    }

    fun approach() {
        deathsLeft--
    }

    companion object {
        const val MAX_POWER: Int = 1000
    }
}