package tihyo.godzilla.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

/** Single-use sword: applies Wither II + Poison II (10s each) on hit and is consumed. */
public class OxygenDestroyerItem extends SwordItem {

    public OxygenDestroyerItem(Tier tier, int attackDamage, float attackSpeed, Item.Properties props) {
        super(tier, attackDamage, attackSpeed, props);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 1));
        target.addEffect(new MobEffectInstance(MobEffects.POISON, 200, 1));
        // Original always consumed it; creative players keep theirs.
        if (!(attacker instanceof Player player && player.getAbilities().instabuild)) {
            stack.shrink(1);
        }
        return true;
    }
}
