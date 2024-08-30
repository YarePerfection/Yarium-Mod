package net.yare.yarium.block;

import net.minecraft.client.resources.sounds.Sound;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.yare.yarium.Yarium;
import net.yare.yarium.item.ModItems;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Yarium.MOD_ID);

    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_DIAMOND_ORE), UniformInt.of(3,6)));
    public static final RegistryObject<Block> RUBY_BLOCK = registerBlock("ruby_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK)));
    public static final RegistryObject<Block> RAW_RUBY_BLOCK = registerBlock("raw_ruby_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RAW_IRON_BLOCK)));

    public static final RegistryObject<Block> DEAD_LOG = registerBlock("dead_log",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRIMSON_STEM)));
    public static final RegistryObject<Block> DEAD_WOOD = registerBlock("dead_wood",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRIMSON_STEM)));
    public static final RegistryObject<Block> DEAD_PLANKS = registerBlock("dead_planks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.CRIMSON_STEM)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registrerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registrerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void registrer(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
