package com.gimax.freesoundify;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenEvents;
import net.fabricmc.fabric.api.client.screen.v1.ScreenMouseEvents;
import net.fabricmc.fabric.api.event.player.AttackBlockCallback;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;

public class FreeSoundifyClient implements ClientModInitializer {
    private static Object previousScreen;
    private static int cooldown = 0;

    @Override
    public void onInitializeClient() {
        ScreenEvents.AFTER_INIT.register((client, screen, width, height) -> {
            ScreenMouseEvents.afterMouseClick(screen).register(
                (s, click, consumed) -> {
                    if (consumed) play(SoundEvents.UI_BUTTON_CLICK.value(), 0.55f, 1.15f);
                }
            );
        });

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.currentScreen != previousScreen) {
                if (client.currentScreen != null) {
                    play(SoundEvents.BLOCK_CHEST_OPEN.value(), 0.35f, 1.25f);
                } else if (previousScreen != null) {
                    play(SoundEvents.BLOCK_CHEST_CLOSE.value(), 0.30f, 1.30f);
                }
                previousScreen = client.currentScreen;
            }
            if (cooldown > 0) cooldown--;
        });

        AttackBlockCallback.EVENT.register((player, world, hand, pos, direction) -> {
            if (world.isClient() && cooldown == 0) {
                play(SoundEvents.BLOCK_NOTE_BLOCK_HAT.value(), 0.22f, 1.55f);
                cooldown = 5;
            }
            return ActionResult.PASS;
        });

        UseBlockCallback.EVENT.register((player, world, hand, hit) -> {
            if (world.isClient() && cooldown == 0) {
                play(SoundEvents.BLOCK_NOTE_BLOCK_PLING.value(), 0.18f, 1.35f);
                cooldown = 5;
            }
            return ActionResult.PASS;
        });
    }

    private static void play(net.minecraft.sound.SoundEvent sound, float volume, float pitch) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player != null && client.world != null) {
            client.getSoundManager().play(
                PositionedSoundInstance.master(sound, pitch, volume)
            );
        }
    }
}
