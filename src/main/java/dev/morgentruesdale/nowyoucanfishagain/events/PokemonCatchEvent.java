package dev.morgentruesdale.nowyoucanfishagain.events;

import com.pixelmonmod.pixelmon.api.events.FishingEvent;
import dev.morgentruesdale.nowyoucanfishagain.config.Config;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

import java.util.Random;

@EventBusSubscriber
public class PokemonCatchEvent {

	@SubscribeEvent
	public void onFishCatch(FishingEvent.Catch e) {

		Player player = e.player;
		Level level = player.level();
		Random random = new Random();

		level.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.NEUTRAL, 0.5F, 0.4F / (random.nextFloat() * 0.4F + 0.8F));
		if (!Config.catchMessage.get().equalsIgnoreCase("false")) {
			player.sendSystemMessage(Component.literal(Config.catchMessage.get()));
		}

	}

}
