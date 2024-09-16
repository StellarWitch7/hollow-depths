package stellarwitch7.hollow_depths.cca.entity

import org.ladysnake.cca.api.v3.component.ComponentKey
import org.ladysnake.cca.api.v3.entity.RespawnCopyStrategy
import stellarwitch7.hollow_depths.HollowDepths
import stellarwitch7.libstellar.registry.cca.entity.CCAEntityComponentRegistrar

object ModEntityComponents : CCAEntityComponentRegistrar() {
    override val modID: String = HollowDepths.MOD_ID

    val shade: ComponentKey<ShadeComponent> = register("shade", ShadeComponent::class, ::ShadeComponent, RespawnCopyStrategy.ALWAYS_COPY)
}