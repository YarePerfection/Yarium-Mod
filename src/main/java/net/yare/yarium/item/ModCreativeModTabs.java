package net.yare.yarium.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.yare.yarium.Yarium;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, Yarium.MOD_ID);

    public static final RegistryObject<CreativeModeTab> YARIUM_MOD_TAB = CREATIVE_MODE_TABS.register("yarium_mod_tab", () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RUBY.get()))
            .title(Component.translatable("creativetab.yarium_tab"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.RUBY.get());
                output.accept(ModItems.RUBY_UPGRADE.get());
                output.accept(ModItems.RAW_RUBY.get());
            })
            .build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
