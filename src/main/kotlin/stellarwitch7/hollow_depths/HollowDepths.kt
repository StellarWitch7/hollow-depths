package stellarwitch7.hollow_depths

import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import stellarwitch7.hollow_depths.item.ModItems

object HollowDepths : ModInitializer {
	const val MOD_ID: String = "hollow-depths"
    val logger: Logger = LoggerFactory.getLogger(MOD_ID)

	override fun onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.
		logger.info("Crawling, seeking, devouring...")
		ModItems.register()
	}
}