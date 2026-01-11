package mod.maxbogomol.mod_template;

import mod.maxbogomol.fluffy_fur.FluffyFurClient;
import mod.maxbogomol.fluffy_fur.client.gui.screen.FluffyFurMod;
import mod.maxbogomol.fluffy_fur.client.language.LanguageHandler;
import mod.maxbogomol.fluffy_fur.client.splash.SplashHandler;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import java.awt.*;
import java.util.List;
import java.util.Random;

public class ModTemplateClient {
    public static Random random = new Random();

    public static class ClientOnly {
        public static void clientInit() {
            IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
            IEventBus forgeBus = MinecraftForge.EVENT_BUS;
        }
    }

    public static void clientSetup(final FMLClientSetupEvent event) {
        setupMenu();
        setupSplashes();
    }

    public static FluffyFurMod MOD_INSTANCE;

    public static void setupMenu() {
        MOD_INSTANCE = new FluffyFurMod(ModTemplate.MOD_ID, ModTemplate.NAME, ModTemplate.VERSION).setDev("MaxBogomol").setItem(new ItemStack(Items.DIRT))
                .setEdition(ModTemplate.VERSION_NUMBER).setNameColor(new Color(255, 0, 0)).setVersionColor(new Color(0, 255, 0))
                .setDescription(Component.translatable("mod_description.mod_template"))
                .addFluffyVillageLink("https://fluffy-village.dev/pages/eng/creations/mod_template.html")
                .addGithubLink("https://github.com/MaxBogomol/ModTemplate")
                .addCurseForgeLink("https://www.curseforge.com/minecraft/mc-mods/mod-template")
                .addModrinthLink("https://modrinth.com/mod/mod_template")
                .addDiscordLink("https://discord.gg/cKf55qNugw");

        FluffyFurClient.registerMod(MOD_INSTANCE);
    }

    public static void setupSplashes() {
        List<String> strings = LanguageHandler.getStringsFromFile(new ResourceLocation(ModTemplate.MOD_ID, "texts/splashes.txt"));
        for (String string : strings) {
            SplashHandler.addSplash(string);
        }
    }
}
