package stellarwitch7.hollow_depths.cca.block

import net.minecraft.block.entity.SculkCatalystBlockEntity
import stellarwitch7.hollow_depths.HollowDepths
import stellarwitch7.libstellar.registry.cca.block.CCABlockComponentRegistrar

object ModBlockComponents : CCABlockComponentRegistrar() {
    override val modID: String = HollowDepths.MOD_ID

    val cataclysm = register("cataclysm", CataclysmComponent::class, ::CataclysmComponent, SculkCatalystBlockEntity::class)
}