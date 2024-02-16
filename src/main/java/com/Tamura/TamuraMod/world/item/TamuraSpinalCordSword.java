package com.Tamura.TamuraMod.world.item;

import com.Tamura.TamuraMod.world.entity.NonFireLB;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LightningBolt;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.level.NoteBlockEvent;

import java.util.ArrayList;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class TamuraSpinalCordSword extends SwordItem {
    public TamuraSpinalCordSword(Item.Properties p_40626) {
        super(Tiers.DIAMOND, 5, 1.0F, p_40626);
    }


    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        boolean a = super.hurtEnemy(stack, target, attacker);
        if(a==false)
            return a;

        for(int i = 0; i<100; i++){
            ((ServerLevel)attacker.level).sendParticles(ParticleTypes.SMOKE, target.getX()-0.5+Math.random(), target.getY()+0.5+Math.random(), target.getZ()-0.5+Math.random(), 15, 0.2D, 0.2D, 0.2D, 0.0D);

        }

        return a;
    }
    /*
    public boolean hurtEnemy(ItemStack stack, LivingEntity enemy, LivingEntity attacker) {

        boolean judge = super.hurtEnemy(stack, enemy, attacker);
        if (!judge)
            return judge;

        Vec3 vec3 = attacker.getLookAngle();
        enemy.setDeltaMovement(1.0 * vec3.x, 0.5, 1.0 * vec3.z);
        Player player = (Player) attacker;
        UseOnContext context = new UseOnContext(player, player.getUsedItemHand(), null);
        Level world = context.getLevel();
        {

            Level wld = attacker.level;
            BlockPos pos = enemy.blockPosition();
            wld.addParticle(ParticleTypes.EXPLOSION, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, 0.0, 0.0, 0.0);

        }

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {

                BlockPos pos = enemy.blockPosition();
                LightningBolt nonFire = new NonFireLB(world);
                nonFire.moveTo(Vec3.atBottomCenterOf(pos));//当たる場所
                nonFire.setCause(player instanceof ServerPlayer ? (ServerPlayer) player : null);//サーバープレイヤーだけ使える
                world.addFreshEntity(nonFire);//発動
            }
        }, 500);//0.5秒

        return judge;
    }
     */
    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        //UseOnContext context = new UseOnContext(player, player.getUsedItemHand(), null);
        BlockPos pos = player.blockPosition();
        sp(world, pos);

        if (player.experienceLevel >= 1) {
            player.giveExperienceLevels(-1);
            stack.setDamageValue(stack.getDamageValue() - 10);
            player.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST, 20 * 60 * 5, 9, false, false));//レベル10,お知らせなし,泡なし
        }
        return InteractionResultHolder.success(stack);
    }

    private void sp(Level world,BlockPos pos){
        for (int i= 0; i<360; i++){
            if(i % 20 != 0)
                continue;
            world.addParticle(ParticleTypes.FIREWORK,
                    pos.getX()+0.5d,pos.getY()+1,pos.getZ()+0.5d,
                    Math.cos(i)*0.25d,0.15d,Math.sin(i)*0.25d);
        }
    }
}
