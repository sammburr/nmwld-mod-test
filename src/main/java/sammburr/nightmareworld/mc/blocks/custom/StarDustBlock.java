package sammburr.nightmareworld.mc.blocks.custom;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class StarDustBlock extends Block {

    public static final BooleanProperty LIT = BooleanProperty.of("lit");

    public StarDustBlock(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(LIT, false));
    }

    @Override
    protected void appendProperties(Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {

        if (!world.isClient()) {

            if (entity instanceof LivingEntity) {

                world.setBlockState(pos, state.with(LIT, true));
            }
        }

        super.onSteppedOn(world, pos, state, entity);
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {

        world.setBlockState(pos, state.with(LIT, false));

    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {

        if ((boolean) state.get(LIT)) {

            double x = (double) pos.getX() + random.nextDouble();
            double y = (double) pos.getY() + random.nextDouble();
            double z = (double) pos.getZ() + random.nextDouble();

            world.addParticle(ParticleTypes.END_ROD, x, y + 0.5D, z, 0.0D, 0.0D, 0.0D);

        }
    }

}
