package dev.morgentruesdale.nowyoucanfishagain;

import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.api.config.api.yaml.YamlConfigFactory;
import dev.morgentruesdale.nowyoucanfishagain.config.Config;
import dev.morgentruesdale.nowyoucanfishagain.events.PokemonCatchEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.event.server.ServerStoppedEvent;
import net.minecraftforge.event.server.ServerStoppingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

@Mod("nowyoucanfishagain")
@Mod.EventBusSubscriber(modid = ForgeMod.MOD_ID)
public class ForgeMod {

	public static final String MOD_ID = "nowyoucanfishagain";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	private static ForgeMod instance;

	private Config config;

	public ForgeMod() {
		IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
		modEventBus.addListener(this::loadComplete);

		reloadConfig();

		MinecraftForge.EVENT_BUS.register(this);
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		bus.addListener(ForgeMod::onModLoad);
	}

	public static void onModLoad(FMLCommonSetupEvent event) {

		Pixelmon.EVENT_BUS.register(new PokemonCatchEvent());

	}

	@SubscribeEvent
	public static void onServerStarting(ServerStartingEvent event) {
		// Logic for when the server is starting here
	}

	public void reloadConfig() {
		try {
			this.config = YamlConfigFactory.getInstance(Config.class);
		} catch (IOException e) {
			LOGGER.error("Failed to load config", e);
		}
	}

	@SubscribeEvent
	public static void onServerStarted(ServerStartedEvent event) {
		// Logic for once the server has started here
	}

	private void loadComplete(final FMLLoadCompleteEvent event) {
    	MinecraftForge.EVENT_BUS.register(new PokemonCatchEvent());
	}

	@SubscribeEvent
	public static void onServerStopping(ServerStoppingEvent event) {
		// Logic for when the server is stopping
	}

	@SubscribeEvent
	public static void onServerStopped(ServerStoppedEvent event) {
		// Logic for when the server is stopped
	}

	public static ForgeMod getInstance() {
		return instance;
	}

	public static Logger getLogger() {
		return LOGGER;
	}

	public static Config getConfig() {
		return instance.config;
	}
}