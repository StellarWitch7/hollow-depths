package stellarwitch7.hollow_depths.item

import net.minecraft.item.Item
import net.minecraft.item.ItemUsageContext
import net.minecraft.util.ActionResult
import stellarwitch7.hollow_depths.cca.block.ModBlockComponents

class SculkContainmentUnitItem : Item(Settings()) {
    override fun useOnBlock(context: ItemUsageContext): ActionResult {
        @Suppress("UNNECESSARY_SAFE_CALL") // for some reason IntelliJ is annoyed by this, but getBlockEntity is nullable
        context.world.getBlockEntity(context.blockPos)?.let { be ->
            ModBlockComponents.cataclysm.get(be)?.let { cataclysm ->
                cataclysm.lock()
                return ActionResult.SUCCESS
            }
        }

        return ActionResult.PASS
    }
}