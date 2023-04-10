package com.diamondgoobird;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import org.lwjgl.input.Keyboard;

@Mod(modid = "toggletitle", name = "Toggle Title")
public class ToggleTitleMod {
    private static boolean enabled = true;
    private static final KeyBinding toggleTitles = new KeyBinding("Toggle Titles", Keyboard.KEY_B, "Toggle Title");

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new ToggleTitleCommand());
        ClientRegistry.registerKeyBinding(toggleTitles);
        MinecraftForge.EVENT_BUS.register(this);
    }

    public static boolean isEnabled() {
        return enabled;
    }

    public static void toggleTitles() {
        enabled = !enabled;
        if (ToggleTitleMod.isEnabled()) {
            printColoredChat(EnumChatFormatting.GREEN + "Enabled titles.");
        }
        else {
            printColoredChat(EnumChatFormatting.RED + "Disabled titles.");
        }
    }

    @SubscribeEvent
    public void onKeyPress(InputEvent.KeyInputEvent event) {
        if (toggleTitles.isPressed()) {
            toggleTitles();
        }
    }

    public static void printColoredChat(String text) {
        Minecraft.getMinecraft().thePlayer.addChatComponentMessage(new ChatComponentText(text.replaceAll("&","\u00a7").replaceAll("\u00a7\u00a7","&")));
    }
}
