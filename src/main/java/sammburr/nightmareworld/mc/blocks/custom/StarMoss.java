package sammburr.nightmareworld.mc.blocks.custom;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.state.StateManager.Builder;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import sammburr.nightmareworld.mc.NightmareWorldMC;

public class StarMoss extends HorizontalFacingBlock {

    public static final BooleanProperty LIT = BooleanProperty.of("lit");
    public static final IntProperty FRAME = IntProperty.of("frame", 0, 3);
    public static final IntProperty FACE = IntProperty.of("face", 0, 5);

    public StarMoss(Settings settings) {
        super(settings);
        setDefaultState(getStateManager().getDefaultState().with(FRAME, 0).with(LIT,
                false).with(FACE, 0));
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {

        int face;
        switch (ctx.getPlacementDirections()[0].toString()) {

            case "north":
                face = 0;
                break;
            case "east":
                face = 1;
                break;
            case "south":
                face = 2;
                break;
            case "west":
                face = 3;
                break;
            case "up":
                face = 4;
                break;
            case "down":
                face = 5;
                break;
            default:
                face = 0;
                break;
        }

        NightmareWorldMC.LOGGER.info(String.valueOf(face));

        return (BlockState) this.getDefaultState().with(FRAME, 0).with(FACE, face);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {

        switch (state.get(FACE)) {

            case 0:
                return VoxelShapes.cuboid(0.2f, 0.2f, 0f, 0.8f, 0.8f, 0.5f);
            case 1:
                return VoxelShapes.cuboid(0.5f, 0.2f, 0.2f, 1f, 0.8f, 0.8f);
            case 2:
                return VoxelShapes.cuboid(0.2f, 0.2f, 0.5f, 0.8f, 0.8f, 1f);
            case 3:
                return VoxelShapes.cuboid(0f, 0.2f, 0.2f, 0.5f, 0.8f, 0.8f);
            case 4:
                return VoxelShapes.cuboid(0.2f, 0.5f, 0.2f, 0.8f, 1f, 0.8f);
            case 5:
                return VoxelShapes.cuboid(0.2f, 0f, 0.2f, 0.8f, 0.5f, 0.8f);
            default:
                return VoxelShapes.cuboid(0.2f, 0f, 0.2f, 0.8f, 0.5f, 0.8f);
        }

    }

    @Override
    protected void appendProperties(Builder<Block, BlockState> builder) {
        builder.add(LIT);
        builder.add(FRAME);
        builder.add(FACE);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {

        double playerDist;
        boolean playerIsClose = false;

        for (PlayerEntity player : world.getPlayers()) {

            playerDist = pos.getSquaredDistance(player.getPos());
            int frame = state.get(FRAME);

            if (playerDist < 14.0D) {

                playerIsClose = true;
                world.setBlockState(pos, state.with(LIT, true));

                if (frame > 0) {
                    world.setBlockState(pos, state.with(FRAME, frame - 1));
                }

                if (!state.get(LIT)) {

                    double x = (double) pos.getX() + random.nextDouble();
                    double y = (double) pos.getY() + random.nextDouble();
                    double z = (double) pos.getZ() + random.nextDouble();

                    world.addParticle(ParticleTypes.END_ROD, x, y + 0.5D, z, 0.0D, 0.0D, 0.0D);
                }

            } else if (playerDist > 16.0D && !playerIsClose) {

                world.setBlockState(pos, state.with(LIT, false));

                if (frame < 3) {
                    world.setBlockState(pos, state.with(FRAME, frame + 1));
                }

            }

        }

    }

}
