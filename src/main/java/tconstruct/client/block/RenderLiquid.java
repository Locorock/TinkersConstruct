package tconstruct.client.block;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.EntityRenderer;
import net.minecraft.client.renderer.RenderBlocks;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.init.Blocks;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;

/**
 * @author BluSunrize
 */

public class RenderLiquid
{//TODO CHECK THIS!!!!
    public static boolean renderMetadataBlock (Block block, int metadata, int x, int y, int z, RenderBlocks renderer, IBlockAccess world)
    {
        int var5 = block.func_149720_d(world, x, y, z);
        float var6 = (var5 >> 16 & 0xFF) / 255.0F;
        float var7 = (var5 >> 8 & 0xFF) / 255.0F;
        float var8 = (var5 & 0xFF) / 255.0F;

        if (EntityRenderer.anaglyphEnable)
        {
            float var9 = (var6 * 30.0F + var7 * 59.0F + var8 * 11.0F) / 100.0F;
            float var10 = (var6 * 30.0F + var7 * 70.0F) / 100.0F;
            float var11 = (var6 * 30.0F + var8 * 70.0F) / 100.0F;
            var6 = var9;
            var7 = var10;
            var8 = var11;
        }

        return (Minecraft.isAmbientOcclusionEnabled()) && (block.func_149750_m() == 0) ? renderMetadataBlockWithAmbientOcclusion(block, metadata, x, y, z, var6, var7, var8, renderer, world)
                : renderMetadataBlockWithColorMultiplier(block, metadata, x, y, z, var6, var7, var8, renderer, world);
    }

    static boolean renderMetadataBlockWithAmbientOcclusion (Block block, int metadata, int xPos, int yPos, int zPos, float colorRed, float colorGreen, float colorBlue, RenderBlocks render,
            IBlockAccess world)
    {
        render.field_147863_w = true;
        boolean flag = false;
        float f3 = 0.0F;
        float f4 = 0.0F;
        float f5 = 0.0F;
        float f6 = 0.0F;
        boolean flag1 = true;
        int l = block.func_149677_c(render.field_147845_a, xPos, yPos, zPos);
        Tessellator tessellator = Tessellator.instance;
        tessellator.setBrightness(983055);

        if (render.func_147745_b(block).getIconName().equals("grass_top"))
        {
            flag1 = false;
        }
        else if (render.func_147744_b())
        {
            flag1 = false;
        }

        if ((render.field_147837_f) || (block. func_149646_a(render.field_147845_a, xPos, yPos - 1, zPos, 0)))
        {
            if (render.field_147855_j <= 0.0D)
            {
                yPos--;
            }

            render.field_147831_S = block.func_149677_c(render.field_147845_a, xPos - 1, yPos, zPos);
            render.field_147825_U = block.func_149677_c(render.field_147845_a, xPos, yPos, zPos - 1);
            render.field_147828_V = block.func_149677_c(render.field_147845_a, xPos, yPos, zPos + 1);
            render.field_147835_X = block.func_149677_c(render.field_147845_a, xPos + 1, yPos, zPos);
            render.field_147886_y = getAmbientOcclusionLightValue(render.field_147845_a, xPos - 1, yPos, zPos);
            render.field_147814_A = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos, zPos - 1);
            render.field_147815_B = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos, zPos + 1);
            render.field_147810_D = getAmbientOcclusionLightValue(render.field_147845_a, xPos + 1, yPos, zPos);
            boolean flag3 = render.field_147845_a.func_147439_a(xPos + 1, yPos - 1, zPos).func_149751_l();
            boolean flag2 = render.field_147845_a.func_147439_a(xPos - 1, yPos - 1, zPos).func_149751_l();
            boolean flag5 = render.field_147845_a.func_147439_a(xPos, yPos - 1, zPos + 1).func_149751_l();
            boolean flag4 = render.field_147845_a.func_147439_a(xPos, yPos - 1, zPos - 1).func_149751_l();

            if ((!flag4) && (!flag2))
            {
                render.field_147888_x = render.field_147886_y;
                render.field_147832_R = render.field_147831_S;
            }
            else
            {
                render.field_147888_x = getAmbientOcclusionLightValue(render.field_147845_a, xPos - 1, yPos, zPos - 1);
                render.field_147832_R = block.func_149677_c(render.field_147845_a, xPos - 1, yPos, zPos - 1);
            }

            if ((!flag5) && (!flag2))
            {
                render.field_147884_z = render.field_147886_y;
                render.field_147826_T = render.field_147831_S;
            }
            else
            {
                render.field_147884_z = getAmbientOcclusionLightValue(render.field_147845_a, xPos - 1, yPos, zPos + 1);
                render.field_147826_T = block.func_149677_c(render.field_147845_a, xPos - 1, yPos, zPos + 1);
            }

            if ((!flag4) && (!flag3))
            {
                render.field_147816_C = render.field_147810_D;
                render.field_147827_W = render.field_147835_X;
            }
            else
            {
                render.field_147816_C = getAmbientOcclusionLightValue(render.field_147845_a, xPos + 1, yPos, zPos - 1);
                render.field_147827_W = block.func_149677_c(render.field_147845_a, xPos + 1, yPos, zPos - 1);
            }

            if ((!flag5) && (!flag3))
            {
                render.field_147811_E = render.field_147810_D;
                render.field_147834_Y = render.field_147835_X;
            }
            else
            {
                render.field_147811_E = getAmbientOcclusionLightValue(render.field_147845_a, xPos + 1, yPos, zPos + 1);
                render.field_147834_Y = block.func_149677_c(render.field_147845_a, xPos + 1, yPos, zPos + 1);
            }

            if (render.field_147855_j <= 0.0D)
            {
                yPos++;
            }

            int i1 = l;

            if ((render.field_147855_j <= 0.0D) || (!render.field_147845_a.func_147439_a(xPos, yPos - 1, zPos).func_149662_c()))
            {
                i1 = block.func_149677_c(render.field_147845_a, xPos, yPos - 1, zPos);
            }

            float f7 = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos - 1, zPos);
            f3 = (render.field_147884_z + render.field_147886_y + render.field_147815_B + f7) / 4.0F;
            f6 = (render.field_147815_B + f7 + render.field_147811_E + render.field_147810_D) / 4.0F;
            f5 = (f7 + render.field_147814_A + render.field_147810_D + render.field_147816_C) / 4.0F;
            f4 = (render.field_147886_y + render.field_147888_x + f7 + render.field_147814_A) / 4.0F;
            render.field_147864_al = render.func_147778_a(render.field_147826_T, render.field_147831_S, render.field_147828_V, i1);
            render.field_147870_ao = render.func_147778_a(render.field_147828_V, render.field_147834_Y, render.field_147835_X, i1);
            render.field_147876_an = render.func_147778_a(render.field_147825_U, render.field_147835_X, render.field_147827_W, i1);
            render.field_147874_am = render.func_147778_a(render.field_147831_S, render.field_147832_R, render.field_147825_U, i1);

            if (flag1)
            {
                render.field_147872_ap = (render.field_147852_aq = render.field_147850_ar = render.field_147848_as = colorRed * 0.5F);
                render.field_147846_at = (render.field_147860_au = render.field_147858_av = render.field_147856_aw = colorGreen * 0.5F);
                render.field_147854_ax = (render.field_147841_ay = render.field_147839_az = render.field_147833_aA = colorBlue * 0.5F);
            }
            else
            {
                render.field_147872_ap = (render.field_147852_aq = render.field_147850_ar = render.field_147848_as = 0.5F);
                render.field_147846_at = (render.field_147860_au = render.field_147858_av = render.field_147856_aw = 0.5F);
                render.field_147854_ax = (render.field_147841_ay = render.field_147839_az = render.field_147833_aA = 0.5F);
            }

            render.field_147872_ap *= f3;
            render.field_147846_at *= f3;
            render.field_147854_ax *= f3;
            render.field_147852_aq *= f4;
            render.field_147860_au *= f4;
            render.field_147841_ay *= f4;
            render.field_147850_ar *= f5;
            render.field_147858_av *= f5;
            render.field_147839_az *= f5;
            render.field_147848_as *= f6;
            render.field_147856_aw *= f6;
            render.field_147833_aA *= f6;
            render.func_147768_a(block, xPos, yPos, zPos, block.func_149691_a(0, metadata));
            flag = true;
        }

        if ((render.field_147837_f) || (block. func_149646_a(render.field_147845_a, xPos, yPos + 1, zPos, 1)))
        {
            if (render.field_147857_k >= 1.0D)
            {
                yPos++;
            }

            render.field_147880_aa = block.func_149677_c(render.field_147845_a, xPos - 1, yPos, zPos);
            render.field_147885_ae = block.func_149677_c(render.field_147845_a, xPos + 1, yPos, zPos);
            render.field_147878_ac = block.func_149677_c(render.field_147845_a, xPos, yPos, zPos - 1);
            render.field_147887_af = block.func_149677_c(render.field_147845_a, xPos, yPos, zPos + 1);
            render.field_147813_G = getAmbientOcclusionLightValue(render.field_147845_a, xPos - 1, yPos, zPos);
            render.field_147824_K = getAmbientOcclusionLightValue(render.field_147845_a, xPos + 1, yPos, zPos);
            render.field_147822_I = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos, zPos - 1);
            render.field_147817_L = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos, zPos + 1);
            boolean flag3 = render.field_147845_a.func_147439_a(xPos + 1, yPos + 1, zPos).func_149751_l();
            boolean flag2 = render.field_147845_a.func_147439_a(xPos - 1, yPos + 1, zPos).func_149751_l();
            boolean flag5 = render.field_147845_a.func_147439_a(xPos, yPos + 1, zPos + 1).func_149751_l();
            boolean flag4 = render.field_147845_a.func_147439_a(xPos, yPos + 1, zPos - 1).func_149751_l();

            if ((!flag4) && (!flag2))
            {
                render.field_147812_F = render.field_147813_G;
                render.field_147836_Z = render.field_147880_aa;
            }
            else
            {
                render.field_147812_F = getAmbientOcclusionLightValue(render.field_147845_a, xPos - 1, yPos, zPos - 1);
                render.field_147836_Z = block.func_149677_c(render.field_147845_a, xPos - 1, yPos, zPos - 1);
            }

            if ((!flag4) && (!flag3))
            {
                render.field_147824_K = render.field_147824_K;
                render.field_147879_ad = render.field_147885_ae;
            }
            else
            {
                render.field_147824_K = getAmbientOcclusionLightValue(render.field_147845_a, xPos + 1, yPos, zPos - 1);
                render.field_147879_ad = block.func_149677_c(render.field_147845_a, xPos + 1, yPos, zPos - 1);
            }

            if ((!flag5) && (!flag2))
            {
                render.field_147821_H = render.field_147813_G;
                render.field_147881_ab = render.field_147880_aa;
            }
            else
            {
                render.field_147821_H = getAmbientOcclusionLightValue(render.field_147845_a, xPos - 1, yPos, zPos + 1);
                render.field_147881_ab = block.func_149677_c(render.field_147845_a, xPos - 1, yPos, zPos + 1);
            }

            if ((!flag5) && (!flag3))
            {
                render.field_147819_N = render.field_147824_K;
                render.field_147882_ag = render.field_147885_ae;
            }
            else
            {
                render.field_147819_N = getAmbientOcclusionLightValue(render.field_147845_a, xPos + 1, yPos, zPos + 1);
                render.field_147882_ag = block.func_149677_c(render.field_147845_a, xPos + 1, yPos, zPos + 1);
            }

            if (render.field_147857_k >= 1.0D)
            {
                yPos--;
            }

            int i1 = l;

            if ((render.field_147857_k >= 1.0D) || (!render.field_147845_a.func_147439_a(xPos, yPos + 1, zPos).func_149662_c()))
            {
                i1 = block.func_149677_c(render.field_147845_a, xPos, yPos + 1, zPos);
            }

            float f7 = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos + 1, zPos);
            f6 = (render.field_147821_H + render.field_147813_G + render.field_147817_L + f7) / 4.0F;
            f3 = (render.field_147817_L + f7 + render.field_147819_N + render.field_147824_K) / 4.0F;
            f4 = (f7 + render.field_147822_I + render.field_147824_K + render.field_147824_K) / 4.0F;
            f5 = (render.field_147813_G + render.field_147812_F + f7 + render.field_147822_I) / 4.0F;
            render.field_147870_ao = render.func_147778_a(render.field_147881_ab, render.field_147880_aa, render.field_147887_af, i1);
            render.field_147864_al = render.func_147778_a(render.field_147887_af, render.field_147882_ag, render.field_147885_ae, i1);
            render.field_147874_am = render.func_147778_a(render.field_147878_ac, render.field_147885_ae, render.field_147879_ad, i1);
            render.field_147876_an = render.func_147778_a(render.field_147880_aa, render.field_147836_Z, render.field_147878_ac, i1);
            render.field_147872_ap = (render.field_147852_aq = render.field_147850_ar = render.field_147848_as = colorRed);
            render.field_147846_at = (render.field_147860_au = render.field_147858_av = render.field_147856_aw = colorGreen);
            render.field_147854_ax = (render.field_147841_ay = render.field_147839_az = render.field_147833_aA = colorBlue);
            render.field_147872_ap *= f3;
            render.field_147846_at *= f3;
            render.field_147854_ax *= f3;
            render.field_147852_aq *= f4;
            render.field_147860_au *= f4;
            render.field_147841_ay *= f4;
            render.field_147850_ar *= f5;
            render.field_147858_av *= f5;
            render.field_147839_az *= f5;
            render.field_147848_as *= f6;
            render.field_147856_aw *= f6;
            render.field_147833_aA *= f6;
            render.func_147806_b(block, xPos, yPos, zPos, block.func_149691_a(1, metadata));
            flag = true;
        }

        if ((render.field_147837_f) || (block. func_149646_a(render.field_147845_a, xPos, yPos, zPos - 1, 2)))
        {
            if (render.field_147851_l <= 0.0D)
            {
                zPos--;
            }

            render.field_147820_O = getAmbientOcclusionLightValue(render.field_147845_a, xPos - 1, yPos, zPos);
            render.field_147814_A = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos - 1, zPos);
            render.field_147822_I = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos + 1, zPos);
            render.field_147820_O = getAmbientOcclusionLightValue(render.field_147845_a, xPos + 1, yPos, zPos);
            render.field_147883_ah = block.func_149677_c(render.field_147845_a, xPos - 1, yPos, zPos);
            render.field_147825_U = block.func_149677_c(render.field_147845_a, xPos, yPos - 1, zPos);
            render.field_147878_ac = block.func_149677_c(render.field_147845_a, xPos, yPos + 1, zPos);
            render.field_147866_ai = block.func_149677_c(render.field_147845_a, xPos + 1, yPos, zPos);
            boolean flag3 = render.field_147845_a.func_147439_a(xPos + 1, yPos, zPos - 1).func_149751_l();
            boolean flag2 = render.field_147845_a.func_147439_a(xPos - 1, yPos, zPos - 1).func_149751_l();
            boolean flag5 = render.field_147845_a.func_147439_a(xPos, yPos + 1, zPos - 1).func_149751_l();
            boolean flag4 = render.field_147845_a.func_147439_a(xPos, yPos - 1, zPos - 1).func_149751_l();

            if ((!flag2) && (!flag4))
            {
                render.field_147888_x = render.field_147820_O;
                render.field_147832_R = render.field_147883_ah;
            }
            else
            {
                render.field_147888_x = getAmbientOcclusionLightValue(render.field_147845_a, xPos - 1, yPos - 1, zPos);
                render.field_147832_R = block.func_149677_c(render.field_147845_a, xPos - 1, yPos - 1, zPos);
            }

            if ((!flag2) && (!flag5))
            {
                render.field_147812_F = render.field_147820_O;
                render.field_147836_Z = render.field_147883_ah;
            }
            else
            {
                render.field_147812_F = getAmbientOcclusionLightValue(render.field_147845_a, xPos - 1, yPos + 1, zPos);
                render.field_147836_Z = block.func_149677_c(render.field_147845_a, xPos - 1, yPos + 1, zPos);
            }

            if ((!flag3) && (!flag4))
            {
                render.field_147816_C = render.field_147820_O;
                render.field_147827_W = render.field_147866_ai;
            }
            else
            {
                render.field_147816_C = getAmbientOcclusionLightValue(render.field_147845_a, xPos + 1, yPos - 1, zPos);
                render.field_147827_W = block.func_149677_c(render.field_147845_a, xPos + 1, yPos - 1, zPos);
            }

            if ((!flag3) && (!flag5))
            {
                render.field_147824_K = render.field_147820_O;
                render.field_147879_ad = render.field_147866_ai;
            }
            else
            {
                render.field_147824_K = getAmbientOcclusionLightValue(render.field_147845_a, xPos + 1, yPos + 1, zPos);
                render.field_147879_ad = block.func_149677_c(render.field_147845_a, xPos + 1, yPos + 1, zPos);
            }

            if (render.field_147851_l <= 0.0D)
            {
                zPos++;
            }

            int i1 = l;

            if ((render.field_147851_l <= 0.0D) || (!render.field_147845_a.func_147439_a(xPos, yPos, zPos - 1).func_149662_c()))
            {
                i1 = block.func_149677_c(render.field_147845_a, xPos, yPos, zPos - 1);
            }

            float f7 = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos, zPos - 1);
            f3 = (render.field_147820_O + render.field_147812_F + f7 + render.field_147822_I) / 4.0F;
            f4 = (f7 + render.field_147822_I + render.field_147820_O + render.field_147824_K) / 4.0F;
            f5 = (render.field_147814_A + f7 + render.field_147816_C + render.field_147820_O) / 4.0F;
            f6 = (render.field_147888_x + render.field_147820_O + render.field_147814_A + f7) / 4.0F;
            render.field_147864_al = render.func_147778_a(render.field_147883_ah, render.field_147836_Z, render.field_147878_ac, i1);
            render.field_147874_am = render.func_147778_a(render.field_147878_ac, render.field_147866_ai, render.field_147879_ad, i1);
            render.field_147876_an = render.func_147778_a(render.field_147825_U, render.field_147827_W, render.field_147866_ai, i1);
            render.field_147870_ao = render.func_147778_a(render.field_147832_R, render.field_147883_ah, render.field_147825_U, i1);

            if (flag1)
            {
                render.field_147872_ap = (render.field_147852_aq = render.field_147850_ar = render.field_147848_as = colorRed * 0.8F);
                render.field_147846_at = (render.field_147860_au = render.field_147858_av = render.field_147856_aw = colorGreen * 0.8F);
                render.field_147854_ax = (render.field_147841_ay = render.field_147839_az = render.field_147833_aA = colorBlue * 0.8F);
            }
            else
            {
                render.field_147872_ap = (render.field_147852_aq = render.field_147850_ar = render.field_147848_as = 0.8F);
                render.field_147846_at = (render.field_147860_au = render.field_147858_av = render.field_147856_aw = 0.8F);
                render.field_147854_ax = (render.field_147841_ay = render.field_147839_az = render.field_147833_aA = 0.8F);
            }

            render.field_147872_ap *= f3;
            render.field_147846_at *= f3;
            render.field_147854_ax *= f3;
            render.field_147852_aq *= f4;
            render.field_147860_au *= f4;
            render.field_147841_ay *= f4;
            render.field_147850_ar *= f5;
            render.field_147858_av *= f5;
            render.field_147839_az *= f5;
            render.field_147848_as *= f6;
            render.field_147856_aw *= f6;
            render.field_147833_aA *= f6;
            IIcon icon = block.func_149691_a(2, metadata);
            render.func_147761_c(block, xPos, yPos, zPos, icon);

            flag = true;
        }

        if ((render.field_147837_f) || (block. func_149646_a(render.field_147845_a, xPos, yPos, zPos + 1, 3)))
        {
            if (render.field_147853_m >= 1.0D)
            {
                zPos++;
            }

            render.field_147830_P = getAmbientOcclusionLightValue(render.field_147845_a, xPos - 1, yPos, zPos);
            render.field_147829_Q = getAmbientOcclusionLightValue(render.field_147845_a, xPos + 1, yPos, zPos);
            render.field_147815_B = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos - 1, zPos);
            render.field_147817_L = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos + 1, zPos);
            render.field_147868_aj = block.func_149677_c(render.field_147845_a, xPos - 1, yPos, zPos);
            render.field_147862_ak = block.func_149677_c(render.field_147845_a, xPos + 1, yPos, zPos);
            render.field_147828_V = block.func_149677_c(render.field_147845_a, xPos, yPos - 1, zPos);
            render.field_147887_af = block.func_149677_c(render.field_147845_a, xPos, yPos + 1, zPos);
            boolean flag3 = render.field_147845_a.func_147439_a(xPos + 1, yPos, zPos + 1).func_149751_l();
            boolean flag2 = render.field_147845_a.func_147439_a(xPos - 1, yPos, zPos + 1).func_149751_l();
            boolean flag5 = render.field_147845_a.func_147439_a(xPos, yPos + 1, zPos + 1).func_149751_l();
            boolean flag4 = render.field_147845_a.func_147439_a(xPos, yPos - 1, zPos + 1).func_149751_l();

            if ((!flag2) && (!flag4))
            {
                render.field_147884_z = render.field_147830_P;
                render.field_147826_T = render.field_147868_aj;
            }
            else
            {
                render.field_147884_z = getAmbientOcclusionLightValue(render.field_147845_a, xPos - 1, yPos - 1, zPos);
                render.field_147826_T = block.func_149677_c(render.field_147845_a, xPos - 1, yPos - 1, zPos);
            }

            if ((!flag2) && (!flag5))
            {
                render.field_147821_H = render.field_147830_P;
                render.field_147881_ab = render.field_147868_aj;
            }
            else
            {
                render.field_147821_H = getAmbientOcclusionLightValue(render.field_147845_a, xPos - 1, yPos + 1, zPos);
                render.field_147881_ab = block.func_149677_c(render.field_147845_a, xPos - 1, yPos + 1, zPos);
            }

            if ((!flag3) && (!flag4))
            {
                render.field_147811_E = render.field_147829_Q;
                render.field_147834_Y = render.field_147862_ak;
            }
            else
            {
                render.field_147811_E = getAmbientOcclusionLightValue(render.field_147845_a, xPos + 1, yPos - 1, zPos);
                render.field_147834_Y = block.func_149677_c(render.field_147845_a, xPos + 1, yPos - 1, zPos);
            }

            if ((!flag3) && (!flag5))
            {
                render.field_147819_N = render.field_147829_Q;
                render.field_147882_ag = render.field_147862_ak;
            }
            else
            {
                render.field_147819_N = getAmbientOcclusionLightValue(render.field_147845_a, xPos + 1, yPos + 1, zPos);
                render.field_147882_ag = block.func_149677_c(render.field_147845_a, xPos + 1, yPos + 1, zPos);
            }

            if (render.field_147853_m >= 1.0D)
            {
                zPos--;
            }

            int i1 = l;

            if ((render.field_147853_m >= 1.0D) || (!render.field_147845_a.func_147439_a(xPos, yPos, zPos + 1).func_149662_c()))
            {
                i1 = block.func_149677_c(render.field_147845_a, xPos, yPos, zPos + 1);
            }

            float f7 = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos, zPos + 1);
            f3 = (render.field_147830_P + render.field_147821_H + f7 + render.field_147817_L) / 4.0F;
            f6 = (f7 + render.field_147817_L + render.field_147829_Q + render.field_147819_N) / 4.0F;
            f5 = (render.field_147815_B + f7 + render.field_147811_E + render.field_147829_Q) / 4.0F;
            f4 = (render.field_147884_z + render.field_147830_P + render.field_147815_B + f7) / 4.0F;
            render.field_147864_al = render.func_147778_a(render.field_147868_aj, render.field_147881_ab, render.field_147887_af, i1);
            render.field_147870_ao = render.func_147778_a(render.field_147887_af, render.field_147862_ak, render.field_147882_ag, i1);
            render.field_147876_an = render.func_147778_a(render.field_147828_V, render.field_147834_Y, render.field_147862_ak, i1);
            render.field_147874_am = render.func_147778_a(render.field_147826_T, render.field_147868_aj, render.field_147828_V, i1);

            if (flag1)
            {
                render.field_147872_ap = (render.field_147852_aq = render.field_147850_ar = render.field_147848_as = colorRed * 0.8F);
                render.field_147846_at = (render.field_147860_au = render.field_147858_av = render.field_147856_aw = colorGreen * 0.8F);
                render.field_147854_ax = (render.field_147841_ay = render.field_147839_az = render.field_147833_aA = colorBlue * 0.8F);
            }
            else
            {
                render.field_147872_ap = (render.field_147852_aq = render.field_147850_ar = render.field_147848_as = 0.8F);
                render.field_147846_at = (render.field_147860_au = render.field_147858_av = render.field_147856_aw = 0.8F);
                render.field_147854_ax = (render.field_147841_ay = render.field_147839_az = render.field_147833_aA = 0.8F);
            }

            render.field_147872_ap *= f3;
            render.field_147846_at *= f3;
            render.field_147854_ax *= f3;
            render.field_147852_aq *= f4;
            render.field_147860_au *= f4;
            render.field_147841_ay *= f4;
            render.field_147850_ar *= f5;
            render.field_147858_av *= f5;
            render.field_147839_az *= f5;
            render.field_147848_as *= f6;
            render.field_147856_aw *= f6;
            render.field_147833_aA *= f6;
            IIcon icon = block.func_149691_a(3, metadata);
            render.func_147734_d(block, xPos, yPos, zPos, icon);

            flag = true;
        }

        if ((render.field_147837_f) || (block. func_149646_a(render.field_147845_a, xPos - 1, yPos, zPos, 4)))
        {
            if (render.field_147859_h <= 0.0D)
            {
                xPos--;
            }

            render.field_147886_y = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos - 1, zPos);
            render.field_147820_O = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos, zPos - 1);
            render.field_147830_P = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos, zPos + 1);
            render.field_147813_G = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos + 1, zPos);
            render.field_147831_S = block.func_149677_c(render.field_147845_a, xPos, yPos - 1, zPos);
            render.field_147883_ah = block.func_149677_c(render.field_147845_a, xPos, yPos, zPos - 1);
            render.field_147868_aj = block.func_149677_c(render.field_147845_a, xPos, yPos, zPos + 1);
            render.field_147880_aa = block.func_149677_c(render.field_147845_a, xPos, yPos + 1, zPos);
            boolean flag3 = render.field_147845_a.func_147439_a(xPos - 1, yPos + 1, zPos).func_149751_l();
            boolean flag2 = render.field_147845_a.func_147439_a(xPos - 1, yPos - 1, zPos).func_149751_l();
            boolean flag5 = render.field_147845_a.func_147439_a(xPos - 1, yPos, zPos - 1).func_149751_l();
            boolean flag4 = render.field_147845_a.func_147439_a(xPos - 1, yPos, zPos + 1).func_149751_l();

            if ((!flag5) && (!flag2))
            {
                render.field_147888_x = render.field_147820_O;
                render.field_147832_R = render.field_147883_ah;
            }
            else
            {
                render.field_147888_x = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos - 1, zPos - 1);
                render.field_147832_R = block.func_149677_c(render.field_147845_a, xPos, yPos - 1, zPos - 1);
            }

            if ((!flag4) && (!flag2))
            {
                render.field_147884_z = render.field_147830_P;
                render.field_147826_T = render.field_147868_aj;
            }
            else
            {
                render.field_147884_z = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos - 1, zPos + 1);
                render.field_147826_T = block.func_149677_c(render.field_147845_a, xPos, yPos - 1, zPos + 1);
            }

            if ((!flag5) && (!flag3))
            {
                render.field_147812_F = render.field_147820_O;
                render.field_147836_Z = render.field_147883_ah;
            }
            else
            {
                render.field_147812_F = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos + 1, zPos - 1);
                render.field_147836_Z = block.func_149677_c(render.field_147845_a, xPos, yPos + 1, zPos - 1);
            }

            if ((!flag4) && (!flag3))
            {
                render.field_147821_H = render.field_147830_P;
                render.field_147881_ab = render.field_147868_aj;
            }
            else
            {
                render.field_147821_H = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos + 1, zPos + 1);
                render.field_147881_ab = block.func_149677_c(render.field_147845_a, xPos, yPos + 1, zPos + 1);
            }

            if (render.field_147859_h <= 0.0D)
            {
                xPos++;
            }

            int i1 = l;

            if ((render.field_147859_h <= 0.0D) || (!render.field_147845_a.func_147439_a(xPos - 1, yPos, zPos).func_149662_c()))
            {
                i1 = block.func_149677_c(render.field_147845_a, xPos - 1, yPos, zPos);
            }

            float f7 = getAmbientOcclusionLightValue(render.field_147845_a, xPos - 1, yPos, zPos);
            f6 = (render.field_147886_y + render.field_147884_z + f7 + render.field_147830_P) / 4.0F;
            f3 = (f7 + render.field_147830_P + render.field_147813_G + render.field_147821_H) / 4.0F;
            f4 = (render.field_147820_O + f7 + render.field_147812_F + render.field_147813_G) / 4.0F;
            f5 = (render.field_147888_x + render.field_147886_y + render.field_147820_O + f7) / 4.0F;
            render.field_147870_ao = render.func_147778_a(render.field_147831_S, render.field_147826_T, render.field_147868_aj, i1);
            render.field_147864_al = render.func_147778_a(render.field_147868_aj, render.field_147880_aa, render.field_147881_ab, i1);
            render.field_147874_am = render.func_147778_a(render.field_147883_ah, render.field_147836_Z, render.field_147880_aa, i1);
            render.field_147876_an = render.func_147778_a(render.field_147832_R, render.field_147831_S, render.field_147883_ah, i1);

            if (flag1)
            {
                render.field_147872_ap = (render.field_147852_aq = render.field_147850_ar = render.field_147848_as = colorRed * 0.6F);
                render.field_147846_at = (render.field_147860_au = render.field_147858_av = render.field_147856_aw = colorGreen * 0.6F);
                render.field_147854_ax = (render.field_147841_ay = render.field_147839_az = render.field_147833_aA = colorBlue * 0.6F);
            }
            else
            {
                render.field_147872_ap = (render.field_147852_aq = render.field_147850_ar = render.field_147848_as = 0.6F);
                render.field_147846_at = (render.field_147860_au = render.field_147858_av = render.field_147856_aw = 0.6F);
                render.field_147854_ax = (render.field_147841_ay = render.field_147839_az = render.field_147833_aA = 0.6F);
            }

            render.field_147872_ap *= f3;
            render.field_147846_at *= f3;
            render.field_147854_ax *= f3;
            render.field_147852_aq *= f4;
            render.field_147860_au *= f4;
            render.field_147841_ay *= f4;
            render.field_147850_ar *= f5;
            render.field_147858_av *= f5;
            render.field_147839_az *= f5;
            render.field_147848_as *= f6;
            render.field_147856_aw *= f6;
            render.field_147833_aA *= f6;
            IIcon icon = block.func_149691_a(4, metadata);
            render.func_147798_e(block, xPos, yPos, zPos, icon);

            flag = true;
        }

        if ((render.field_147837_f) || (block. func_149646_a(render.field_147845_a, xPos + 1, yPos, zPos, 5)))
        {
            if (render.field_147861_i >= 1.0D)
            {
                xPos++;
            }

            render.field_147810_D = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos - 1, zPos);
            render.field_147820_O = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos, zPos - 1);
            render.field_147829_Q = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos, zPos + 1);
            render.field_147824_K = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos + 1, zPos);
            render.field_147835_X = block.func_149677_c(render.field_147845_a, xPos, yPos - 1, zPos);
            render.field_147866_ai = block.func_149677_c(render.field_147845_a, xPos, yPos, zPos - 1);
            render.field_147862_ak = block.func_149677_c(render.field_147845_a, xPos, yPos, zPos + 1);
            render.field_147885_ae = block.func_149677_c(render.field_147845_a, xPos, yPos + 1, zPos);
            boolean flag3 = render.field_147845_a.func_147439_a(xPos + 1, yPos + 1, zPos).func_149751_l();
            boolean flag2 = render.field_147845_a.func_147439_a(xPos + 1, yPos - 1, zPos).func_149751_l();
            boolean flag5 = render.field_147845_a.func_147439_a(xPos + 1, yPos, zPos + 1).func_149751_l();
            boolean flag4 = render.field_147845_a.func_147439_a(xPos + 1, yPos, zPos - 1).func_149751_l();

            if ((!flag2) && (!flag4))
            {
                render.field_147816_C = render.field_147820_O;
                render.field_147827_W = render.field_147866_ai;
            }
            else
            {
                render.field_147816_C = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos - 1, zPos - 1);
                render.field_147827_W = block.func_149677_c(render.field_147845_a, xPos, yPos - 1, zPos - 1);
            }

            if ((!flag2) && (!flag5))
            {
                render.field_147811_E = render.field_147829_Q;
                render.field_147834_Y = render.field_147862_ak;
            }
            else
            {
                render.field_147811_E = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos - 1, zPos + 1);
                render.field_147834_Y = block.func_149677_c(render.field_147845_a, xPos, yPos - 1, zPos + 1);
            }

            if ((!flag3) && (!flag4))
            {
                render.field_147824_K = render.field_147820_O;
                render.field_147879_ad = render.field_147866_ai;
            }
            else
            {
                render.field_147824_K = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos + 1, zPos - 1);
                render.field_147879_ad = block.func_149677_c(render.field_147845_a, xPos, yPos + 1, zPos - 1);
            }

            if ((!flag3) && (!flag5))
            {
                render.field_147819_N = render.field_147829_Q;
                render.field_147882_ag = render.field_147862_ak;
            }
            else
            {
                render.field_147819_N = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos + 1, zPos + 1);
                render.field_147882_ag = block.func_149677_c(render.field_147845_a, xPos, yPos + 1, zPos + 1);
            }

            if (render.field_147861_i >= 1.0D)
            {
                xPos--;
            }

            int i1 = l;

            if ((render.field_147861_i >= 1.0D) || (!render.field_147845_a.func_147439_a(xPos + 1, yPos, zPos).func_149662_c()))
            {
                i1 = block.func_149677_c(render.field_147845_a, xPos + 1, yPos, zPos);
            }

            float f7 = getAmbientOcclusionLightValue(render.field_147845_a, xPos + 1, yPos, zPos);
            f3 = (render.field_147810_D + render.field_147811_E + f7 + render.field_147829_Q) / 4.0F;
            f4 = (render.field_147816_C + render.field_147810_D + render.field_147820_O + f7) / 4.0F;
            f5 = (render.field_147820_O + f7 + render.field_147824_K + render.field_147824_K) / 4.0F;
            f6 = (f7 + render.field_147829_Q + render.field_147824_K + render.field_147819_N) / 4.0F;
            render.field_147864_al = render.func_147778_a(render.field_147835_X, render.field_147834_Y, render.field_147862_ak, i1);
            render.field_147870_ao = render.func_147778_a(render.field_147862_ak, render.field_147885_ae, render.field_147882_ag, i1);
            render.field_147876_an = render.func_147778_a(render.field_147866_ai, render.field_147879_ad, render.field_147885_ae, i1);
            render.field_147874_am = render.func_147778_a(render.field_147827_W, render.field_147835_X, render.field_147866_ai, i1);

            if (flag1)
            {
                render.field_147872_ap = (render.field_147852_aq = render.field_147850_ar = render.field_147848_as = colorRed * 0.6F);
                render.field_147846_at = (render.field_147860_au = render.field_147858_av = render.field_147856_aw = colorGreen * 0.6F);
                render.field_147854_ax = (render.field_147841_ay = render.field_147839_az = render.field_147833_aA = colorBlue * 0.6F);
            }
            else
            {
                render.field_147872_ap = (render.field_147852_aq = render.field_147850_ar = render.field_147848_as = 0.6F);
                render.field_147846_at = (render.field_147860_au = render.field_147858_av = render.field_147856_aw = 0.6F);
                render.field_147854_ax = (render.field_147841_ay = render.field_147839_az = render.field_147833_aA = 0.6F);
            }

            render.field_147872_ap *= f3;
            render.field_147846_at *= f3;
            render.field_147854_ax *= f3;
            render.field_147852_aq *= f4;
            render.field_147860_au *= f4;
            render.field_147841_ay *= f4;
            render.field_147850_ar *= f5;
            render.field_147858_av *= f5;
            render.field_147839_az *= f5;
            render.field_147848_as *= f6;
            render.field_147856_aw *= f6;
            render.field_147833_aA *= f6;
            IIcon icon = block.func_149691_a(5, metadata);
            render.func_147764_f(block, xPos, yPos, zPos, icon);

            flag = true;
        }

        render.field_147863_w = false;
        return flag;
    }

    private static float getAmbientOcclusionLightValue (IBlockAccess access, int x, int y, int z)
    {
        return access.func_147439_a(x, y, z).func_149685_I();
    }

    static boolean renderMetadataBlockWithColorMultiplier (Block block, int metadata, int xPos, int yPos, int zPos, float colorRed, float colorGreen, float colorBlue, RenderBlocks render,
            IBlockAccess world)
    {
        render.field_147863_w = false;
        Tessellator tessellator = Tessellator.instance;
        boolean flag = false;
        float f3 = 0.5F;
        float f4 = 1.0F;
        float f5 = 0.8F;
        float f6 = 0.6F;
        float f7 = f4 * colorRed;
        float f8 = f4 * colorGreen;
        float f9 = f4 * colorBlue;
        float f10 = f3;
        float f11 = f5;
        float f12 = f6;
        float f13 = f3;
        float f14 = f5;
        float f15 = f6;
        float f16 = f3;
        float f17 = f5;
        float f18 = f6;

        if (block != Blocks.grass)
        {
            f10 = f3 * colorRed;
            f11 = f5 * colorRed;
            f12 = f6 * colorRed;
            f13 = f3 * colorGreen;
            f14 = f5 * colorGreen;
            f15 = f6 * colorGreen;
            f16 = f3 * colorBlue;
            f17 = f5 * colorBlue;
            f18 = f6 * colorBlue;
        }

        int l = block.func_149677_c(render.field_147845_a, xPos, yPos, zPos);

        if ((render.field_147837_f) || (block. func_149646_a(render.field_147845_a, xPos, yPos - 1, zPos, 0)))
        {
            tessellator.setBrightness(render.field_147855_j > 0.0D ? l : block.func_149677_c(render.field_147845_a, xPos, yPos - 1, zPos));
            tessellator.setColorOpaque_F(f10, f13, f16);
            render.func_147768_a(block, xPos, yPos, zPos, block.func_149691_a(0, metadata));
            flag = true;
        }

        if ((render.field_147837_f) || (block. func_149646_a(render.field_147845_a, xPos, yPos + 1, zPos, 1)))
        {
            tessellator.setBrightness(render.field_147857_k < 1.0D ? l : block.func_149677_c(render.field_147845_a, xPos, yPos + 1, zPos));
            tessellator.setColorOpaque_F(f7, f8, f9);
            render.func_147806_b(block, xPos, yPos, zPos, block.func_149691_a(1, metadata));
            flag = true;
        }

        if ((render.field_147837_f) || (block. func_149646_a(render.field_147845_a, xPos, yPos, zPos - 1, 2)))
        {
            tessellator.setBrightness(render.field_147851_l > 0.0D ? l : block.func_149677_c(render.field_147845_a, xPos, yPos, zPos - 1));
            tessellator.setColorOpaque_F(f11, f14, f17);
            render.func_147761_c(block, xPos, yPos, zPos, block.func_149691_a(2, metadata));

            flag = true;
        }

        if ((render.field_147837_f) || (block. func_149646_a(render.field_147845_a, xPos, yPos, zPos + 1, 3)))
        {
            tessellator.setBrightness(render.field_147853_m < 1.0D ? l : block.func_149677_c(render.field_147845_a, xPos, yPos, zPos + 1));
            tessellator.setColorOpaque_F(f11, f14, f17);
            render.func_147734_d(block, xPos, yPos, zPos, block.func_149691_a(3, metadata));

            flag = true;
        }

        if ((render.field_147837_f) || (block. func_149646_a(render.field_147845_a, xPos - 1, yPos, zPos, 4)))
        {
            tessellator.setBrightness(render.field_147859_h > 0.0D ? l : block.func_149677_c(render.field_147845_a, xPos - 1, yPos, zPos));
            tessellator.setColorOpaque_F(f12, f15, f18);
            render.func_147798_e(block, xPos, yPos, zPos, block.func_149691_a(4, metadata));

            flag = true;
        }

        if ((render.field_147837_f) || (block. func_149646_a(render.field_147845_a, xPos + 1, yPos, zPos, 5)))
        {
            tessellator.setBrightness(render.field_147861_i < 1.0D ? l : block.func_149677_c(render.field_147845_a, xPos + 1, yPos, zPos));
            tessellator.setColorOpaque_F(f12, f15, f18);
            render.func_147764_f(block, xPos, yPos, zPos, block.func_149691_a(5, metadata));

            flag = true;
        }

        return flag;
    }

    public static boolean renderFakeBlock (IIcon texture, int x, int y, int z, RenderBlocks renderer, IBlockAccess world)
    {
        Block block = Blocks.stone;
        int var5 = block.func_149720_d(world, x, y, z);
        float var6 = (var5 >> 16 & 0xFF) / 255.0F;
        float var7 = (var5 >> 8 & 0xFF) / 255.0F;
        float var8 = (var5 & 0xFF) / 255.0F;

        if (EntityRenderer.anaglyphEnable)
        {
            float var9 = (var6 * 30.0F + var7 * 59.0F + var8 * 11.0F) / 100.0F;
            float var10 = (var6 * 30.0F + var7 * 70.0F) / 100.0F;
            float var11 = (var6 * 30.0F + var8 * 70.0F) / 100.0F;
            var6 = var9;
            var7 = var10;
            var8 = var11;
        }

        return Minecraft.isAmbientOcclusionEnabled() ? renderFakeBlockWithAmbientOcclusion(texture, x, y, z, var6, var7, var8, renderer, world) : renderFakeBlockWithColorMultiplier(texture, x, y, z,
                var6, var7, var8, renderer, world);
    }

    static boolean renderFakeBlockWithAmbientOcclusion (IIcon texture, int xPos, int yPos, int zPos, float colorRed, float colorGreen, float colorBlue, RenderBlocks render, IBlockAccess world)
    {
        Block block = Blocks.stone;
        render.field_147863_w = true;
        boolean flag = false;
        float f3 = 0.0F;
        float f4 = 0.0F;
        float f5 = 0.0F;
        float f6 = 0.0F;
        boolean flag1 = true;
        int l = block.func_149677_c(render.field_147845_a, xPos, yPos, zPos);
        Tessellator tessellator = Tessellator.instance;
        tessellator.setBrightness(983055);

        if (render.func_147745_b(block).getIconName().equals("grass_top"))
        {
            flag1 = false;
        }
        else if (render.func_147744_b())
        {
            flag1 = false;
        }

        if ((render.field_147837_f) || (block. func_149646_a(render.field_147845_a, xPos, yPos - 1, zPos, 0)))
        {
            if (render.field_147855_j <= 0.0D)
            {
                yPos--;
            }

            render.field_147831_S = block.func_149677_c(render.field_147845_a, xPos - 1, yPos, zPos);
            render.field_147825_U = block.func_149677_c(render.field_147845_a, xPos, yPos, zPos - 1);
            render.field_147828_V = block.func_149677_c(render.field_147845_a, xPos, yPos, zPos + 1);
            render.field_147835_X = block.func_149677_c(render.field_147845_a, xPos + 1, yPos, zPos);
            render.field_147886_y = getAmbientOcclusionLightValue(render.field_147845_a, xPos - 1, yPos, zPos);
            render.field_147814_A = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos, zPos - 1);
            render.field_147815_B = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos, zPos + 1);
            render.field_147810_D = getAmbientOcclusionLightValue(render.field_147845_a, xPos + 1, yPos, zPos);
            boolean flag3 = render.field_147845_a.func_147439_a(xPos + 1, yPos - 1, zPos).func_149751_l();
            boolean flag2 = render.field_147845_a.func_147439_a(xPos - 1, yPos - 1, zPos).func_149751_l();
            boolean flag5 = render.field_147845_a.func_147439_a(xPos, yPos - 1, zPos + 1).func_149751_l();
            boolean flag4 = render.field_147845_a.func_147439_a(xPos, yPos - 1, zPos - 1).func_149751_l();

            if ((!flag4) && (!flag2))
            {
                render.field_147888_x = render.field_147886_y;
                render.field_147832_R = render.field_147831_S;
            }
            else
            {
                render.field_147888_x = getAmbientOcclusionLightValue(render.field_147845_a, xPos - 1, yPos, zPos - 1);
                render.field_147832_R = block.func_149677_c(render.field_147845_a, xPos - 1, yPos, zPos - 1);
            }

            if ((!flag5) && (!flag2))
            {
                render.field_147884_z = render.field_147886_y;
                render.field_147826_T = render.field_147831_S;
            }
            else
            {
                render.field_147884_z = getAmbientOcclusionLightValue(render.field_147845_a, xPos - 1, yPos, zPos + 1);
                render.field_147826_T = block.func_149677_c(render.field_147845_a, xPos - 1, yPos, zPos + 1);
            }

            if ((!flag4) && (!flag3))
            {
                render.field_147816_C = render.field_147810_D;
                render.field_147827_W = render.field_147835_X;
            }
            else
            {
                render.field_147816_C = getAmbientOcclusionLightValue(render.field_147845_a, xPos + 1, yPos, zPos - 1);
                render.field_147827_W = block.func_149677_c(render.field_147845_a, xPos + 1, yPos, zPos - 1);
            }

            if ((!flag5) && (!flag3))
            {
                render.field_147811_E = render.field_147810_D;
                render.field_147834_Y = render.field_147835_X;
            }
            else
            {
                render.field_147811_E = getAmbientOcclusionLightValue(render.field_147845_a, xPos + 1, yPos, zPos + 1);
                render.field_147834_Y = block.func_149677_c(render.field_147845_a, xPos + 1, yPos, zPos + 1);
            }

            if (render.field_147855_j <= 0.0D)
            {
                yPos++;
            }

            int i1 = l;

            if ((render.field_147855_j <= 0.0D) || (!render.field_147845_a.func_147439_a(xPos, yPos - 1, zPos).func_149662_c()))
            {
                i1 = block.func_149677_c(render.field_147845_a, xPos, yPos - 1, zPos);
            }

            float f7 = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos - 1, zPos);
            f3 = (render.field_147884_z + render.field_147886_y + render.field_147815_B + f7) / 4.0F;
            f6 = (render.field_147815_B + f7 + render.field_147811_E + render.field_147810_D) / 4.0F;
            f5 = (f7 + render.field_147814_A + render.field_147810_D + render.field_147816_C) / 4.0F;
            f4 = (render.field_147886_y + render.field_147888_x + f7 + render.field_147814_A) / 4.0F;
            render.field_147864_al = render.func_147778_a(render.field_147826_T, render.field_147831_S, render.field_147828_V, i1);
            render.field_147870_ao = render.func_147778_a(render.field_147828_V, render.field_147834_Y, render.field_147835_X, i1);
            render.field_147876_an = render.func_147778_a(render.field_147825_U, render.field_147835_X, render.field_147827_W, i1);
            render.field_147874_am = render.func_147778_a(render.field_147831_S, render.field_147832_R, render.field_147825_U, i1);

            if (flag1)
            {
                render.field_147872_ap = (render.field_147852_aq = render.field_147850_ar = render.field_147848_as = colorRed * 0.5F);
                render.field_147846_at = (render.field_147860_au = render.field_147858_av = render.field_147856_aw = colorGreen * 0.5F);
                render.field_147854_ax = (render.field_147841_ay = render.field_147839_az = render.field_147833_aA = colorBlue * 0.5F);
            }
            else
            {
                render.field_147872_ap = (render.field_147852_aq = render.field_147850_ar = render.field_147848_as = 0.5F);
                render.field_147846_at = (render.field_147860_au = render.field_147858_av = render.field_147856_aw = 0.5F);
                render.field_147854_ax = (render.field_147841_ay = render.field_147839_az = render.field_147833_aA = 0.5F);
            }

            render.field_147872_ap *= f3;
            render.field_147846_at *= f3;
            render.field_147854_ax *= f3;
            render.field_147852_aq *= f4;
            render.field_147860_au *= f4;
            render.field_147841_ay *= f4;
            render.field_147850_ar *= f5;
            render.field_147858_av *= f5;
            render.field_147839_az *= f5;
            render.field_147848_as *= f6;
            render.field_147856_aw *= f6;
            render.field_147833_aA *= f6;
            render.func_147768_a(block, xPos, yPos, zPos, texture);
            flag = true;
        }

        if ((render.field_147837_f) || (block. func_149646_a(render.field_147845_a, xPos, yPos + 1, zPos, 1)))
        {
            if (render.field_147857_k >= 1.0D)
            {
                yPos++;
            }

            render.field_147880_aa = block.func_149677_c(render.field_147845_a, xPos - 1, yPos, zPos);
            render.field_147885_ae = block.func_149677_c(render.field_147845_a, xPos + 1, yPos, zPos);
            render.field_147878_ac = block.func_149677_c(render.field_147845_a, xPos, yPos, zPos - 1);
            render.field_147887_af = block.func_149677_c(render.field_147845_a, xPos, yPos, zPos + 1);
            render.field_147813_G = getAmbientOcclusionLightValue(render.field_147845_a, xPos - 1, yPos, zPos);
            render.field_147824_K = getAmbientOcclusionLightValue(render.field_147845_a, xPos + 1, yPos, zPos);
            render.field_147822_I = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos, zPos - 1);
            render.field_147817_L = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos, zPos + 1);
            boolean flag3 = Block.canBlockGrass[render.field_147845_a.func_147439_a(xPos + 1, yPos + 1, zPos)];
            boolean flag2 = Block.canBlockGrass[render.field_147845_a.func_147439_a(xPos - 1, yPos + 1, zPos)];
            boolean flag5 = Block.canBlockGrass[render.field_147845_a.func_147439_a(xPos, yPos + 1, zPos + 1)];
            boolean flag4 = Block.canBlockGrass[render.field_147845_a.func_147439_a(xPos, yPos + 1, zPos - 1)];

            if ((!flag4) && (!flag2))
            {
                render.field_147812_F = render.field_147813_G;
                render.field_147836_Z = render.field_147880_aa;
            }
            else
            {
                render.field_147812_F = getAmbientOcclusionLightValue(render.field_147845_a, xPos - 1, yPos, zPos - 1);
                render.field_147836_Z = block.func_149677_c(render.field_147845_a, xPos - 1, yPos, zPos - 1);
            }

            if ((!flag4) && (!flag3))
            {
                render.field_147824_K = render.field_147824_K;
                render.field_147879_ad = render.field_147885_ae;
            }
            else
            {
                render.field_147824_K = getAmbientOcclusionLightValue(render.field_147845_a, xPos + 1, yPos, zPos - 1);
                render.field_147879_ad = block.func_149677_c(render.field_147845_a, xPos + 1, yPos, zPos - 1);
            }

            if ((!flag5) && (!flag2))
            {
                render.field_147821_H = render.field_147813_G;
                render.field_147881_ab = render.field_147880_aa;
            }
            else
            {
                render.field_147821_H = getAmbientOcclusionLightValue(render.field_147845_a, xPos - 1, yPos, zPos + 1);
                render.field_147881_ab = block.func_149677_c(render.field_147845_a, xPos - 1, yPos, zPos + 1);
            }

            if ((!flag5) && (!flag3))
            {
                render.field_147819_N = render.field_147824_K;
                render.field_147882_ag = render.field_147885_ae;
            }
            else
            {
                render.field_147819_N = getAmbientOcclusionLightValue(render.field_147845_a, xPos + 1, yPos, zPos + 1);
                render.field_147882_ag = block.func_149677_c(render.field_147845_a, xPos + 1, yPos, zPos + 1);
            }

            if (render.field_147857_k >= 1.0D)
            {
                yPos--;
            }

            int i1 = l;

            if ((render.field_147857_k >= 1.0D) || (!render.field_147845_a.func_147439_a(xPos, yPos + 1, zPos).func_149662_c()))
            {
                i1 = block.func_149677_c(render.field_147845_a, xPos, yPos + 1, zPos);
            }

            float f7 = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos + 1, zPos);
            f6 = (render.field_147821_H + render.field_147813_G + render.field_147817_L + f7) / 4.0F;
            f3 = (render.field_147817_L + f7 + render.field_147819_N + render.field_147824_K) / 4.0F;
            f4 = (f7 + render.field_147822_I + render.field_147824_K + render.field_147824_K) / 4.0F;
            f5 = (render.field_147813_G + render.field_147812_F + f7 + render.field_147822_I) / 4.0F;
            render.field_147870_ao = render.func_147778_a(render.field_147881_ab, render.field_147880_aa, render.field_147887_af, i1);
            render.field_147864_al = render.func_147778_a(render.field_147887_af, render.field_147882_ag, render.field_147885_ae, i1);
            render.field_147874_am = render.func_147778_a(render.field_147878_ac, render.field_147885_ae, render.field_147879_ad, i1);
            render.field_147876_an = render.func_147778_a(render.field_147880_aa, render.field_147836_Z, render.field_147878_ac, i1);
            render.field_147872_ap = (render.field_147852_aq = render.field_147850_ar = render.field_147848_as = colorRed);
            render.field_147846_at = (render.field_147860_au = render.field_147858_av = render.field_147856_aw = colorGreen);
            render.field_147854_ax = (render.field_147841_ay = render.field_147839_az = render.field_147833_aA = colorBlue);
            render.field_147872_ap *= f3;
            render.field_147846_at *= f3;
            render.field_147854_ax *= f3;
            render.field_147852_aq *= f4;
            render.field_147860_au *= f4;
            render.field_147841_ay *= f4;
            render.field_147850_ar *= f5;
            render.field_147858_av *= f5;
            render.field_147839_az *= f5;
            render.field_147848_as *= f6;
            render.field_147856_aw *= f6;
            render.field_147833_aA *= f6;
            render.func_147806_b(block, xPos, yPos, zPos, texture);
            flag = true;
        }

        if ((render.field_147837_f) || (block. func_149646_a(render.field_147845_a, xPos, yPos, zPos - 1, 2)))
        {
            if (render.field_147851_l <= 0.0D)
            {
                zPos--;
            }

            render.field_147820_O = getAmbientOcclusionLightValue(render.field_147845_a, xPos - 1, yPos, zPos);
            render.field_147814_A = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos - 1, zPos);
            render.field_147822_I = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos + 1, zPos);
            render.field_147820_O = getAmbientOcclusionLightValue(render.field_147845_a, xPos + 1, yPos, zPos);
            render.field_147883_ah = block.func_149677_c(render.field_147845_a, xPos - 1, yPos, zPos);
            render.field_147825_U = block.func_149677_c(render.field_147845_a, xPos, yPos - 1, zPos);
            render.field_147878_ac = block.func_149677_c(render.field_147845_a, xPos, yPos + 1, zPos);
            render.field_147866_ai = block.func_149677_c(render.field_147845_a, xPos + 1, yPos, zPos);
            boolean flag3 = Block.canBlockGrass[render.field_147845_a.func_147439_a(xPos + 1, yPos, zPos - 1)];
            boolean flag2 = Block.canBlockGrass[render.field_147845_a.func_147439_a(xPos - 1, yPos, zPos - 1)];
            boolean flag5 = Block.canBlockGrass[render.field_147845_a.func_147439_a(xPos, yPos + 1, zPos - 1)];
            boolean flag4 = Block.canBlockGrass[render.field_147845_a.func_147439_a(xPos, yPos - 1, zPos - 1)];

            if ((!flag2) && (!flag4))
            {
                render.field_147888_x = render.field_147820_O;
                render.field_147832_R = render.field_147883_ah;
            }
            else
            {
                render.field_147888_x = getAmbientOcclusionLightValue(render.field_147845_a, xPos - 1, yPos - 1, zPos);
                render.field_147832_R = block.func_149677_c(render.field_147845_a, xPos - 1, yPos - 1, zPos);
            }

            if ((!flag2) && (!flag5))
            {
                render.field_147812_F = render.field_147820_O;
                render.field_147836_Z = render.field_147883_ah;
            }
            else
            {
                render.field_147812_F = getAmbientOcclusionLightValue(render.field_147845_a, xPos - 1, yPos + 1, zPos);
                render.field_147836_Z = block.func_149677_c(render.field_147845_a, xPos - 1, yPos + 1, zPos);
            }

            if ((!flag3) && (!flag4))
            {
                render.field_147816_C = render.field_147820_O;
                render.field_147827_W = render.field_147866_ai;
            }
            else
            {
                render.field_147816_C = getAmbientOcclusionLightValue(render.field_147845_a, xPos + 1, yPos - 1, zPos);
                render.field_147827_W = block.func_149677_c(render.field_147845_a, xPos + 1, yPos - 1, zPos);
            }

            if ((!flag3) && (!flag5))
            {
                render.field_147824_K = render.field_147820_O;
                render.field_147879_ad = render.field_147866_ai;
            }
            else
            {
                render.field_147824_K = getAmbientOcclusionLightValue(render.field_147845_a, xPos + 1, yPos + 1, zPos);
                render.field_147879_ad = block.func_149677_c(render.field_147845_a, xPos + 1, yPos + 1, zPos);
            }

            if (render.field_147851_l <= 0.0D)
            {
                zPos++;
            }

            int i1 = l;

            if ((render.field_147851_l <= 0.0D) || (!render.field_147845_a.func_147439_a(xPos, yPos, zPos - 1).func_149662_c()))
            {
                i1 = block.func_149677_c(render.field_147845_a, xPos, yPos, zPos - 1);
            }

            float f7 = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos, zPos - 1);
            f3 = (render.field_147820_O + render.field_147812_F + f7 + render.field_147822_I) / 4.0F;
            f4 = (f7 + render.field_147822_I + render.field_147820_O + render.field_147824_K) / 4.0F;
            f5 = (render.field_147814_A + f7 + render.field_147816_C + render.field_147820_O) / 4.0F;
            f6 = (render.field_147888_x + render.field_147820_O + render.field_147814_A + f7) / 4.0F;
            render.field_147864_al = render.func_147778_a(render.field_147883_ah, render.field_147836_Z, render.field_147878_ac, i1);
            render.field_147874_am = render.func_147778_a(render.field_147878_ac, render.field_147866_ai, render.field_147879_ad, i1);
            render.field_147876_an = render.func_147778_a(render.field_147825_U, render.field_147827_W, render.field_147866_ai, i1);
            render.field_147870_ao = render.func_147778_a(render.field_147832_R, render.field_147883_ah, render.field_147825_U, i1);

            if (flag1)
            {
                render.field_147872_ap = (render.field_147852_aq = render.field_147850_ar = render.field_147848_as = colorRed * 0.8F);
                render.field_147846_at = (render.field_147860_au = render.field_147858_av = render.field_147856_aw = colorGreen * 0.8F);
                render.field_147854_ax = (render.field_147841_ay = render.field_147839_az = render.field_147833_aA = colorBlue * 0.8F);
            }
            else
            {
                render.field_147872_ap = (render.field_147852_aq = render.field_147850_ar = render.field_147848_as = 0.8F);
                render.field_147846_at = (render.field_147860_au = render.field_147858_av = render.field_147856_aw = 0.8F);
                render.field_147854_ax = (render.field_147841_ay = render.field_147839_az = render.field_147833_aA = 0.8F);
            }

            render.field_147872_ap *= f3;
            render.field_147846_at *= f3;
            render.field_147854_ax *= f3;
            render.field_147852_aq *= f4;
            render.field_147860_au *= f4;
            render.field_147841_ay *= f4;
            render.field_147850_ar *= f5;
            render.field_147858_av *= f5;
            render.field_147839_az *= f5;
            render.field_147848_as *= f6;
            render.field_147856_aw *= f6;
            render.field_147833_aA *= f6;
            render.func_147761_c(block, xPos, yPos, zPos, texture);

            flag = true;
        }

        if ((render.field_147837_f) || (block. func_149646_a(render.field_147845_a, xPos, yPos, zPos + 1, 3)))
        {
            if (render.field_147853_m >= 1.0D)
            {
                zPos++;
            }

            render.field_147830_P = getAmbientOcclusionLightValue(render.field_147845_a, xPos - 1, yPos, zPos);
            render.field_147829_Q = getAmbientOcclusionLightValue(render.field_147845_a, xPos + 1, yPos, zPos);
            render.field_147815_B = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos - 1, zPos);
            render.field_147817_L = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos + 1, zPos);
            render.field_147868_aj = block.func_149677_c(render.field_147845_a, xPos - 1, yPos, zPos);
            render.field_147862_ak = block.func_149677_c(render.field_147845_a, xPos + 1, yPos, zPos);
            render.field_147828_V = block.func_149677_c(render.field_147845_a, xPos, yPos - 1, zPos);
            render.field_147887_af = block.func_149677_c(render.field_147845_a, xPos, yPos + 1, zPos);
            boolean flag3 = Block.canBlockGrass[render.field_147845_a.func_147439_a(xPos + 1, yPos, zPos + 1)];
            boolean flag2 = Block.canBlockGrass[render.field_147845_a.func_147439_a(xPos - 1, yPos, zPos + 1)];
            boolean flag5 = Block.canBlockGrass[render.field_147845_a.func_147439_a(xPos, yPos + 1, zPos + 1)];
            boolean flag4 = Block.canBlockGrass[render.field_147845_a.func_147439_a(xPos, yPos - 1, zPos + 1)];

            if ((!flag2) && (!flag4))
            {
                render.field_147884_z = render.field_147830_P;
                render.field_147826_T = render.field_147868_aj;
            }
            else
            {
                render.field_147884_z = getAmbientOcclusionLightValue(render.field_147845_a, xPos - 1, yPos - 1, zPos);
                render.field_147826_T = block.func_149677_c(render.field_147845_a, xPos - 1, yPos - 1, zPos);
            }

            if ((!flag2) && (!flag5))
            {
                render.field_147821_H = render.field_147830_P;
                render.field_147881_ab = render.field_147868_aj;
            }
            else
            {
                render.field_147821_H = getAmbientOcclusionLightValue(render.field_147845_a, xPos - 1, yPos + 1, zPos);
                render.field_147881_ab = block.func_149677_c(render.field_147845_a, xPos - 1, yPos + 1, zPos);
            }

            if ((!flag3) && (!flag4))
            {
                render.field_147811_E = render.field_147829_Q;
                render.field_147834_Y = render.field_147862_ak;
            }
            else
            {
                render.field_147811_E = getAmbientOcclusionLightValue(render.field_147845_a, xPos + 1, yPos - 1, zPos);
                render.field_147834_Y = block.func_149677_c(render.field_147845_a, xPos + 1, yPos - 1, zPos);
            }

            if ((!flag3) && (!flag5))
            {
                render.field_147819_N = render.field_147829_Q;
                render.field_147882_ag = render.field_147862_ak;
            }
            else
            {
                render.field_147819_N = getAmbientOcclusionLightValue(render.field_147845_a, xPos + 1, yPos + 1, zPos);
                render.field_147882_ag = block.func_149677_c(render.field_147845_a, xPos + 1, yPos + 1, zPos);
            }

            if (render.field_147853_m >= 1.0D)
            {
                zPos--;
            }

            int i1 = l;

            if ((render.field_147853_m >= 1.0D) || (!render.field_147845_a.func_147439_a(xPos, yPos, zPos + 1).func_149662_c()))
            {
                i1 = block.func_149677_c(render.field_147845_a, xPos, yPos, zPos + 1);
            }

            float f7 = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos, zPos + 1);
            f3 = (render.field_147830_P + render.field_147821_H + f7 + render.field_147817_L) / 4.0F;
            f6 = (f7 + render.field_147817_L + render.field_147829_Q + render.field_147819_N) / 4.0F;
            f5 = (render.field_147815_B + f7 + render.field_147811_E + render.field_147829_Q) / 4.0F;
            f4 = (render.field_147884_z + render.field_147830_P + render.field_147815_B + f7) / 4.0F;
            render.field_147864_al = render.func_147778_a(render.field_147868_aj, render.field_147881_ab, render.field_147887_af, i1);
            render.field_147870_ao = render.func_147778_a(render.field_147887_af, render.field_147862_ak, render.field_147882_ag, i1);
            render.field_147876_an = render.func_147778_a(render.field_147828_V, render.field_147834_Y, render.field_147862_ak, i1);
            render.field_147874_am = render.func_147778_a(render.field_147826_T, render.field_147868_aj, render.field_147828_V, i1);

            if (flag1)
            {
                render.field_147872_ap = (render.field_147852_aq = render.field_147850_ar = render.field_147848_as = colorRed * 0.8F);
                render.field_147846_at = (render.field_147860_au = render.field_147858_av = render.field_147856_aw = colorGreen * 0.8F);
                render.field_147854_ax = (render.field_147841_ay = render.field_147839_az = render.field_147833_aA = colorBlue * 0.8F);
            }
            else
            {
                render.field_147872_ap = (render.field_147852_aq = render.field_147850_ar = render.field_147848_as = 0.8F);
                render.field_147846_at = (render.field_147860_au = render.field_147858_av = render.field_147856_aw = 0.8F);
                render.field_147854_ax = (render.field_147841_ay = render.field_147839_az = render.field_147833_aA = 0.8F);
            }

            render.field_147872_ap *= f3;
            render.field_147846_at *= f3;
            render.field_147854_ax *= f3;
            render.field_147852_aq *= f4;
            render.field_147860_au *= f4;
            render.field_147841_ay *= f4;
            render.field_147850_ar *= f5;
            render.field_147858_av *= f5;
            render.field_147839_az *= f5;
            render.field_147848_as *= f6;
            render.field_147856_aw *= f6;
            render.field_147833_aA *= f6;
            render.func_147734_d(block, xPos, yPos, zPos, texture);

            flag = true;
        }

        if ((render.field_147837_f) || (block. func_149646_a(render.field_147845_a, xPos - 1, yPos, zPos, 4)))
        {
            if (render.field_147859_h <= 0.0D)
            {
                xPos--;
            }

            render.field_147886_y = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos - 1, zPos);
            render.field_147820_O = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos, zPos - 1);
            render.field_147830_P = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos, zPos + 1);
            render.field_147813_G = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos + 1, zPos);
            render.field_147831_S = block.func_149677_c(render.field_147845_a, xPos, yPos - 1, zPos);
            render.field_147883_ah = block.func_149677_c(render.field_147845_a, xPos, yPos, zPos - 1);
            render.field_147868_aj = block.func_149677_c(render.field_147845_a, xPos, yPos, zPos + 1);
            render.field_147880_aa = block.func_149677_c(render.field_147845_a, xPos, yPos + 1, zPos);
            boolean flag3 = Block.canBlockGrass[render.field_147845_a.func_147439_a(xPos - 1, yPos + 1, zPos)];
            boolean flag2 = Block.canBlockGrass[render.field_147845_a.func_147439_a(xPos - 1, yPos - 1, zPos)];
            boolean flag5 = Block.canBlockGrass[render.field_147845_a.func_147439_a(xPos - 1, yPos, zPos - 1)];
            boolean flag4 = Block.canBlockGrass[render.field_147845_a.func_147439_a(xPos - 1, yPos, zPos + 1)];

            if ((!flag5) && (!flag2))
            {
                render.field_147888_x = render.field_147820_O;
                render.field_147832_R = render.field_147883_ah;
            }
            else
            {
                render.field_147888_x = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos - 1, zPos - 1);
                render.field_147832_R = block.func_149677_c(render.field_147845_a, xPos, yPos - 1, zPos - 1);
            }

            if ((!flag4) && (!flag2))
            {
                render.field_147884_z = render.field_147830_P;
                render.field_147826_T = render.field_147868_aj;
            }
            else
            {
                render.field_147884_z = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos - 1, zPos + 1);
                render.field_147826_T = block.func_149677_c(render.field_147845_a, xPos, yPos - 1, zPos + 1);
            }

            if ((!flag5) && (!flag3))
            {
                render.field_147812_F = render.field_147820_O;
                render.field_147836_Z = render.field_147883_ah;
            }
            else
            {
                render.field_147812_F = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos + 1, zPos - 1);
                render.field_147836_Z = block.func_149677_c(render.field_147845_a, xPos, yPos + 1, zPos - 1);
            }

            if ((!flag4) && (!flag3))
            {
                render.field_147821_H = render.field_147830_P;
                render.field_147881_ab = render.field_147868_aj;
            }
            else
            {
                render.field_147821_H = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos + 1, zPos + 1);
                render.field_147881_ab = block.func_149677_c(render.field_147845_a, xPos, yPos + 1, zPos + 1);
            }

            if (render.field_147859_h <= 0.0D)
            {
                xPos++;
            }

            int i1 = l;

            if ((render.field_147859_h <= 0.0D) || (!render.field_147845_a.func_147439_a(xPos - 1, yPos, zPos).func_149662_c()))
            {
                i1 = block.func_149677_c(render.field_147845_a, xPos - 1, yPos, zPos);
            }

            float f7 = getAmbientOcclusionLightValue(render.field_147845_a, xPos - 1, yPos, zPos);
            f6 = (render.field_147886_y + render.field_147884_z + f7 + render.field_147830_P) / 4.0F;
            f3 = (f7 + render.field_147830_P + render.field_147813_G + render.field_147821_H) / 4.0F;
            f4 = (render.field_147820_O + f7 + render.field_147812_F + render.field_147813_G) / 4.0F;
            f5 = (render.field_147888_x + render.field_147886_y + render.field_147820_O + f7) / 4.0F;
            render.field_147870_ao = render.func_147778_a(render.field_147831_S, render.field_147826_T, render.field_147868_aj, i1);
            render.field_147864_al = render.func_147778_a(render.field_147868_aj, render.field_147880_aa, render.field_147881_ab, i1);
            render.field_147874_am = render.func_147778_a(render.field_147883_ah, render.field_147836_Z, render.field_147880_aa, i1);
            render.field_147876_an = render.func_147778_a(render.field_147832_R, render.field_147831_S, render.field_147883_ah, i1);

            if (flag1)
            {
                render.field_147872_ap = (render.field_147852_aq = render.field_147850_ar = render.field_147848_as = colorRed * 0.6F);
                render.field_147846_at = (render.field_147860_au = render.field_147858_av = render.field_147856_aw = colorGreen * 0.6F);
                render.field_147854_ax = (render.field_147841_ay = render.field_147839_az = render.field_147833_aA = colorBlue * 0.6F);
            }
            else
            {
                render.field_147872_ap = (render.field_147852_aq = render.field_147850_ar = render.field_147848_as = 0.6F);
                render.field_147846_at = (render.field_147860_au = render.field_147858_av = render.field_147856_aw = 0.6F);
                render.field_147854_ax = (render.field_147841_ay = render.field_147839_az = render.field_147833_aA = 0.6F);
            }

            render.field_147872_ap *= f3;
            render.field_147846_at *= f3;
            render.field_147854_ax *= f3;
            render.field_147852_aq *= f4;
            render.field_147860_au *= f4;
            render.field_147841_ay *= f4;
            render.field_147850_ar *= f5;
            render.field_147858_av *= f5;
            render.field_147839_az *= f5;
            render.field_147848_as *= f6;
            render.field_147856_aw *= f6;
            render.field_147833_aA *= f6;
            render.func_147798_e(block, xPos, yPos, zPos, texture);

            flag = true;
        }

        if ((render.field_147837_f) || (block. func_149646_a(render.field_147845_a, xPos + 1, yPos, zPos, 5)))
        {
            if (render.field_147861_i >= 1.0D)
            {
                xPos++;
            }

            render.field_147810_D = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos - 1, zPos);
            render.field_147820_O = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos, zPos - 1);
            render.field_147829_Q = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos, zPos + 1);
            render.field_147824_K = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos + 1, zPos);
            render.field_147835_X = block.func_149677_c(render.field_147845_a, xPos, yPos - 1, zPos);
            render.field_147866_ai = block.func_149677_c(render.field_147845_a, xPos, yPos, zPos - 1);
            render.field_147862_ak = block.func_149677_c(render.field_147845_a, xPos, yPos, zPos + 1);
            render.field_147885_ae = block.func_149677_c(render.field_147845_a, xPos, yPos + 1, zPos);
            boolean flag3 = Block.canBlockGrass[render.field_147845_a.func_147439_a(xPos + 1, yPos + 1, zPos)];
            boolean flag2 = Block.canBlockGrass[render.field_147845_a.func_147439_a(xPos + 1, yPos - 1, zPos)];
            boolean flag5 = Block.canBlockGrass[render.field_147845_a.func_147439_a(xPos + 1, yPos, zPos + 1)];
            boolean flag4 = Block.canBlockGrass[render.field_147845_a.func_147439_a(xPos + 1, yPos, zPos - 1)];

            if ((!flag2) && (!flag4))
            {
                render.field_147816_C = render.field_147820_O;
                render.field_147827_W = render.field_147866_ai;
            }
            else
            {
                render.field_147816_C = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos - 1, zPos - 1);
                render.field_147827_W = block.func_149677_c(render.field_147845_a, xPos, yPos - 1, zPos - 1);
            }

            if ((!flag2) && (!flag5))
            {
                render.field_147811_E = render.field_147829_Q;
                render.field_147834_Y = render.field_147862_ak;
            }
            else
            {
                render.field_147811_E = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos - 1, zPos + 1);
                render.field_147834_Y = block.func_149677_c(render.field_147845_a, xPos, yPos - 1, zPos + 1);
            }

            if ((!flag3) && (!flag4))
            {
                render.field_147824_K = render.field_147820_O;
                render.field_147879_ad = render.field_147866_ai;
            }
            else
            {
                render.field_147824_K = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos + 1, zPos - 1);
                render.field_147879_ad = block.func_149677_c(render.field_147845_a, xPos, yPos + 1, zPos - 1);
            }

            if ((!flag3) && (!flag5))
            {
                render.field_147819_N = render.field_147829_Q;
                render.field_147882_ag = render.field_147862_ak;
            }
            else
            {
                render.field_147819_N = getAmbientOcclusionLightValue(render.field_147845_a, xPos, yPos + 1, zPos + 1);
                render.field_147882_ag = block.func_149677_c(render.field_147845_a, xPos, yPos + 1, zPos + 1);
            }

            if (render.field_147861_i >= 1.0D)
            {
                xPos--;
            }

            int i1 = l;

            if ((render.field_147861_i >= 1.0D) || (!render.field_147845_a.func_147439_a(xPos + 1, yPos, zPos).func_149662_c()))
            {
                i1 = block.func_149677_c(render.field_147845_a, xPos + 1, yPos, zPos);
            }

            float f7 = getAmbientOcclusionLightValue(render.field_147845_a, xPos + 1, yPos, zPos);
            f3 = (render.field_147810_D + render.field_147811_E + f7 + render.field_147829_Q) / 4.0F;
            f4 = (render.field_147816_C + render.field_147810_D + render.field_147820_O + f7) / 4.0F;
            f5 = (render.field_147820_O + f7 + render.field_147824_K + render.field_147824_K) / 4.0F;
            f6 = (f7 + render.field_147829_Q + render.field_147824_K + render.field_147819_N) / 4.0F;
            render.field_147864_al = render.func_147778_a(render.field_147835_X, render.field_147834_Y, render.field_147862_ak, i1);
            render.field_147870_ao = render.func_147778_a(render.field_147862_ak, render.field_147885_ae, render.field_147882_ag, i1);
            render.field_147876_an = render.func_147778_a(render.field_147866_ai, render.field_147879_ad, render.field_147885_ae, i1);
            render.field_147874_am = render.func_147778_a(render.field_147827_W, render.field_147835_X, render.field_147866_ai, i1);

            if (flag1)
            {
                render.field_147872_ap = (render.field_147852_aq = render.field_147850_ar = render.field_147848_as = colorRed * 0.6F);
                render.field_147846_at = (render.field_147860_au = render.field_147858_av = render.field_147856_aw = colorGreen * 0.6F);
                render.field_147854_ax = (render.field_147841_ay = render.field_147839_az = render.field_147833_aA = colorBlue * 0.6F);
            }
            else
            {
                render.field_147872_ap = (render.field_147852_aq = render.field_147850_ar = render.field_147848_as = 0.6F);
                render.field_147846_at = (render.field_147860_au = render.field_147858_av = render.field_147856_aw = 0.6F);
                render.field_147854_ax = (render.field_147841_ay = render.field_147839_az = render.field_147833_aA = 0.6F);
            }

            render.field_147872_ap *= f3;
            render.field_147846_at *= f3;
            render.field_147854_ax *= f3;
            render.field_147852_aq *= f4;
            render.field_147860_au *= f4;
            render.field_147841_ay *= f4;
            render.field_147850_ar *= f5;
            render.field_147858_av *= f5;
            render.field_147839_az *= f5;
            render.field_147848_as *= f6;
            render.field_147856_aw *= f6;
            render.field_147833_aA *= f6;
            render.func_147764_f(block, xPos, yPos, zPos, texture);

            flag = true;
        }

        render.field_147863_w = false;
        return flag;
    }

    static boolean renderFakeBlockWithColorMultiplier (IIcon texture, int xPos, int yPos, int zPos, float colorRed, float colorGreen, float colorBlue, RenderBlocks render, IBlockAccess world)
    {
        Block block = Blocks.stone;
        render.field_147863_w = false;
        Tessellator tessellator = Tessellator.instance;
        boolean flag = false;
        float f3 = 0.5F;
        float f4 = 1.0F;
        float f5 = 0.8F;
        float f6 = 0.6F;
        float f7 = f4 * colorRed;
        float f8 = f4 * colorGreen;
        float f9 = f4 * colorBlue;
        float f10 = f3;
        float f11 = f5;
        float f12 = f6;
        float f13 = f3;
        float f14 = f5;
        float f15 = f6;
        float f16 = f3;
        float f17 = f5;
        float f18 = f6;

        if (block != Blocks.grass)
        {
            f10 = f3 * colorRed;
            f11 = f5 * colorRed;
            f12 = f6 * colorRed;
            f13 = f3 * colorGreen;
            f14 = f5 * colorGreen;
            f15 = f6 * colorGreen;
            f16 = f3 * colorBlue;
            f17 = f5 * colorBlue;
            f18 = f6 * colorBlue;
        }

        int l = block.func_149677_c(render.field_147845_a, xPos, yPos, zPos);

        if ((render.field_147837_f) || (block. func_149646_a(render.field_147845_a, xPos, yPos - 1, zPos, 0)))
        {
            tessellator.setBrightness(render.field_147855_j > 0.0D ? l : block.func_149677_c(render.field_147845_a, xPos, yPos - 1, zPos));
            tessellator.setColorOpaque_F(f10, f13, f16);
            render.func_147768_a(block, xPos, yPos, zPos, texture);
            flag = true;
        }

        if ((render.field_147837_f) || (block. func_149646_a(render.field_147845_a, xPos, yPos + 1, zPos, 1)))
        {
            tessellator.setBrightness(render.field_147857_k < 1.0D ? l : block.func_149677_c(render.field_147845_a, xPos, yPos + 1, zPos));
            tessellator.setColorOpaque_F(f7, f8, f9);
            render.func_147806_b(block, xPos, yPos, zPos, texture);
            flag = true;
        }

        if ((render.field_147837_f) || (block. func_149646_a(render.field_147845_a, xPos, yPos, zPos - 1, 2)))
        {
            tessellator.setBrightness(render.field_147851_l > 0.0D ? l : block.func_149677_c(render.field_147845_a, xPos, yPos, zPos - 1));
            tessellator.setColorOpaque_F(f11, f14, f17);
            render.func_147761_c(block, xPos, yPos, zPos, texture);

            flag = true;
        }

        if ((render.field_147837_f) || (block. func_149646_a(render.field_147845_a, xPos, yPos, zPos + 1, 3)))
        {
            tessellator.setBrightness(render.field_147853_m < 1.0D ? l : block.func_149677_c(render.field_147845_a, xPos, yPos, zPos + 1));
            tessellator.setColorOpaque_F(f11, f14, f17);
            render.func_147734_d(block, xPos, yPos, zPos, texture);

            flag = true;
        }

        if ((render.field_147837_f) || (block. func_149646_a(render.field_147845_a, xPos - 1, yPos, zPos, 4)))
        {
            tessellator.setBrightness(render.field_147859_h > 0.0D ? l : block.func_149677_c(render.field_147845_a, xPos - 1, yPos, zPos));
            tessellator.setColorOpaque_F(f12, f15, f18);
            render.func_147798_e(block, xPos, yPos, zPos, texture);

            flag = true;
        }

        if ((render.field_147837_f) || (block. func_149646_a(render.field_147845_a, xPos + 1, yPos, zPos, 5)))
        {
            tessellator.setBrightness(render.field_147861_i < 1.0D ? l : block.func_149677_c(render.field_147845_a, xPos + 1, yPos, zPos));
            tessellator.setColorOpaque_F(f12, f15, f18);
            render.func_147764_f(block, xPos, yPos, zPos, texture);

            flag = true;
        }

        return flag;
    }
}
