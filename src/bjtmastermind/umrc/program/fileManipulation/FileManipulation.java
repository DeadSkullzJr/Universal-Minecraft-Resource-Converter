package bjtmastermind.umrc.program.fileManipulation;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import bjtmastermind.umrc.program.Main;

public class FileManipulation extends Main {
	
	public static void copy(File source, File copy) throws IOException {
		if (!file.exists()) {
			System.out.println("File does not exist.");
		} else {
			FileManipulation cf = new FileManipulation();
			cf.copydir(file, fileCopied);
		}
	}

	private void copydir(File src, File dest) throws IOException {
		if (src.isDirectory()) {
			if (!dest.exists()) {
				dest.mkdir();
			}
			String files[] = src.list();

			for (String fileName : files) {
				File srcFile = new File(src, fileName);
				File destFile = new File(dest, fileName);
				copydir(srcFile, destFile);
			}
		} else {
			fileCopy(src, dest);
		}
	}

	private void fileCopy(File src, File dest) throws FileNotFoundException {
		InputStream in = null;
		OutputStream out = null;

		try {
			in = new FileInputStream(src);
			out = new FileOutputStream(dest);
			byte[] buf = new byte[1024];
			int length;
			while ((length = in.read(buf)) > 0) {
				out.write(buf, 0, length);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	@SuppressWarnings("unlikely-arg-type")
	public static void unstitch() throws IOException {
		BufferedImage base = ImageIO.read(new File("/home/bjtmastermind/Desktop/terrain.png"));
		int i = 0, ii = 0, x = 0, y = 0;
		File[] names = {new File(path+"grass_top.png"),new File(path+"stone.png"),new File(path+"dirt.png"),new File(path+"grass_side.png"),new File(path+"planks_oak.png"),new File(path+"stone_slab_side.png"),new File(path+"stone_slab_top.png"),new File(path+"brick.png"),new File(path+"tnt_side.png"),new File(path+"tnt_top.png"),new File(path+"tnt_bottom.png"),new File(path+"web.png"),new File(path+"flower_rose.png"),new File(path+"flower_dandelion.png"),new File(path+"none"),new File(path+"sapling_oak.png"),new File(path+"cobblestone.png"),new File(path+"bedrock.png"),new File(path+"sand.png"),new File(path+"gravel.png"),new File(path+"log_oak.png"),new File(path+"log_oak_top.png"),new File(path+"iron_block.png"),new File(path+"gold_block.png"),new File(path+"diamond_block.png"),new File(path+"emerald_block.png"),new File(path+"none"),new File(path+"none"),new File(path+"mushroom_red.png"),new File(path+"mushroom_brown.png"),new File(path+"sapling_jungle.png"),new File(path+"none"),new File(path+"gold_ore.png"),new File(path+"iron_ore.png"),new File(path+"coal_ore.png"),new File(path+"bookshelf.png"),new File(path+"cobblestone_mossy.png"),new File(path+"obsidian.png"),new File(path+"grass_side_overlay.png"),new File(path+"tallgrass.png"),new File(path+"grass_top.png"),new File(path+"beacon.png"),new File(path+"none"),new File(path+"crafting_table_top.png"),new File(path+"furnace_front_off.png"),new File(path+"furnace_side.png"),new File(path+"dispenser_front_horizontal.png"),new File(path+"none"),new File(path+"sponge.png"),new File(path+"glass.png"),new File(path+"diamond_ore.png"),new File(path+"redstone_ore.png"),new File(path+"leaves_oak.png"),new File(path+"none"),new File(path+"stonebrick.png"),new File(path+"deadbush.png"),new File(path+"fern.png"),new File(path+"none"),new File(path+"none"),new File(path+"crafting_table_side.png"),new File(path+"crafting_table_front.png"),new File(path+"furnace_front_on.png"),new File(path+"furnace_top.png"),new File(path+"sapling_spruce.png"),new File(path+"wool_colored_white.png"),new File(path+"mob_spawner.png"),new File(path+"snow.png"),new File(path+"ice.png"),new File(path+"grass_side_snowed.png"),new File(path+"cactus_top.png"),new File(path+"cactus_side.png"),new File(path+"cactus_bottom.png"),new File(path+"clay.png"),new File(path+"reeds.png"),new File(path+"jukebox_side.png"),new File(path+"jukebox_top.png"),new File(path+"waterlily.png"),new File(path+"mycelium_side.png"),new File(path+"mycelium_top.png"),new File(path+"sapling_birch.png"),new File(path+"torch_on.png"),new File(path+"door_wood_upper.png"),new File(path+"door_iron_upper.png"),new File(path+"ladder.png"),new File(path+"trapdoor.png"),new File(path+"iron_bars.png"),new File(path+"farmland_wet.png"),new File(path+"farmland_dry.png"),new File(path+"wheat_stage_0.png"),new File(path+"wheat_stage_1.png"),new File(path+"wheat_stage_2.png"),new File(path+"wheat_stage_3.png"),new File(path+"wheat_stage_4.png"),new File(path+"wheat_stage_5.png"),new File(path+"wheat_stage_6.png"),new File(path+"wheat_stage_7.png"),new File(path+"lever.png"),new File(path+"door_wood_lower.png"),new File(path+"door_iron_lower.png"),new File(path+"redstone_torch_on.png"),new File(path+"stonebrick_mossy.png"),new File(path+"stonebrick_cracked.png"),new File(path+"pumpkin_top.png"),new File(path+"netherrack.png"),new File(path+"soul_sand.png"),new File(path+"glowstone.png"),new File(path+"piston_top_sticky.png"),new File(path+"piston_top_normal.png"),new File(path+"piston_side.png"),new File(path+"piston_bottom.png"),new File(path+"piston_inner.png"),new File(path+"pumpkin_stem_disconnected.png"),new File(path+"rail_normal_turned.png"),new File(path+"wool_colored_black.png"),new File(path+"wool_colored_gray.png"),new File(path+"redstone_torch_off.png"),new File(path+"log_spruce.png"),new File(path+"log_birch.png"),new File(path+"pumpkin_side.png"),new File(path+"pumpkin_face_off.png"),new File(path+"pumpkin_face_on.png"),new File(path+"cake_top.png"),new File(path+"cake_side.png"),new File(path+"cake_inner.png"),new File(path+"cake_bottom.png"),new File(path+"mushroom_block_skin_red.png"),new File(path+"mushroom_block_skin_brown.png"),new File(path+"pumpkin_stem_connected.png"),new File(path+"rail_normal.png"),new File(path+"wool_colored_red.png"),new File(path+"wool_colored_pink.png"),new File(path+"repeater_off.png"),new File(path+"leaves_spruce.png"),new File(path+"none"),new File(path+"bed_feet_top.png"),new File(path+"bed_head_top.png"),new File(path+"melon_side.png"),new File(path+"melon_top.png"),new File(path+"cauldron_top.png"),new File(path+"cauldron_inner.png"),new File(path+"none"),new File(path+"mushroom_block_skin_stem.png"),new File(path+"mushroom_block_inside.png"),new File(path+"vine.png"),new File(path+"lapis_block.png"),new File(path+"wool_colored_green.png"),new File(path+"wool_colored_lime.png"),new File(path+"repeater_on.png"),new File(path+"glass_pane_top.png"),new File(path+"bed_feet_end.png"),new File(path+"bed_feet_side.png"),new File(path+"bed_head_side.png"),new File(path+"bed_head_end.png"),new File(path+"log_jungle.png"),new File(path+"cauldron_side.png"),new File(path+"cauldron_bottom.png"),new File(path+"brewing_stand_base.png"),new File(path+"brewing_stand.png"),new File(path+"endframe_top.png"),new File(path+"endframe_side.png"),new File(path+"lapis_ore.png"),new File(path+"wool_colored_brown.png"),new File(path+"wool_colored_yellow.png"),new File(path+"rail_golden.png"),new File(path+"redstone_dust_dot.png"),new File(path+"redstone_dust_line0.png"),new File(path+"enchanting_table_top.png"),new File(path+"dragon_egg.png"),new File(path+"cocoa_stage_2.png"),new File(path+"cocoa_stage_1.png"),new File(path+"cocoa_stage_0.png"),new File(path+"emerald_ore.png"),new File(path+"trip_wire_source.png"),new File(path+"trip_wire.png"),new File(path+"endframe_eye.png"),new File(path+"end_stone.png"),new File(path+"sandstone_top.png"),new File(path+"wool_colored_blue.png"),new File(path+"wool_colored_light_blue.png"),new File(path+"rail_golden_powered.png"),new File(path+"none"),new File(path+"none"),new File(path+"enchanting_table_side.png"),new File(path+"enchanting_table_bottom.png"),new File(path+"command_block_back.png"),new File(path+"itemframe_background.png"),new File(path+"flower_pot.png"),new File(path+"none"),new File(path+"none"),new File(path+"none"),new File(path+"none"),new File(path+"none"),new File(path+"sandstone_normal.png"),new File(path+"wool_colored_purple.png"),new File(path+"wool_colored_magenta.png"),new File(path+"rail_detector.png"),new File(path+"leaves_jungle.png"),new File(path+"none"),new File(path+"planks_spruce.png"),new File(path+"planks_jungle.png"),new File(path+"carrots_stage_0.png"),new File(path+"carrots_stage_1.png"),new File(path+"carrots_stage_2.png"),new File(path+"carrots_stage_3.png"),new File(path+"potatoes_stage_3.png"),new File(path+"none"),new File(path+"none"),new File(path+"none"),new File(path+"sandstone_bottom.png"),new File(path+"wool_colored_cyan.png"),new File(path+"wool_colored_orange.png"),new File(path+"redstone_lamp_off.png"),new File(path+"redstone_lamp_on.png"),new File(path+"stonebrick_carved.png"),new File(path+"planks_birch.png"),new File(path+"anvil_base.png"),new File(path+"anvil_top_damaged_1.png"),new File(path+"none"),new File(path+"none"),new File(path+"none"),new File(path+"none"),new File(path+"none"),new File(path+"none"),new File(path+"none"),new File(path+"nether_brick.png"),new File(path+"wool_colored_silver.png"),new File(path+"nether_wart_stage_0.png"),new File(path+"nether_wart_stage_1.png"),new File(path+"nether_wart_stage_2.png"),new File(path+"sandstone_carved.png"),new File(path+"sandstone_smooth.png"),new File(path+"anvil_top_damaged_0.png"),new File(path+"anvil_top_damaged_2.png"),new File(path+"none"),new File(path+"none"),new File(path+"none"),new File(path+"none"),new File(path+"none"),new File(path+"none"),new File(path+"none"),new File(path+"destroy_stage_0.png"),new File(path+"destroy_stage_1.png"),new File(path+"destroy_stage_2.png"),new File(path+"destroy_stage_3.png"),new File(path+"destroy_stage_4.png"),new File(path+"destroy_stage_5.png"),new File(path+"destroy_stage_6.png"),new File(path+"destroy_stage_7.png"),new File(path+"destroy_stage_8.png"),new File(path+"destroy_stage_9.png"),new File(path+"none"),new File(path+"none"),new File(path+"none"),new File(path+"none"),new File(path+"none"),new File(path+"none")};
		File none = new File(path+"none");
		
		for(int img = 0; img <= 264; img++) {
			if(ii == 16) {
				x = 0;
				y += 16;
				ii = 0;
			} else if(names[i].equals(path+"none")) {
				x += 16;
				i += 1;
				ii += 1;
			} else {
				BufferedImage texture = base.getSubimage(x, y, 16, 16);
				ImageIO.write(texture, "png", names[i]);
				x += 16;
				i += 1;
				ii += 1;
			}
		}
		none.delete();
	}
	
	public static void stitch() throws IOException {
		File[] textures = {new File(path+"grass_top.png"),new File(path+"stone.png"),new File(path+"dirt.png"),new File(path+"grass_side.png"),new File(path+"planks_oak.png"),new File(path+"stone_slab_side.png"),new File(path+"stone_slab_top.png"),new File(path+"brick.png"),new File(path+"tnt_side.png"),new File(path+"tnt_top.png"),new File(path+"tnt_bottom.png"),new File(path+"web.png"),new File(path+"flower_rose.png"),new File(path+"flower_dandelion.png"),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(path+"sapling_oak.png"),new File(path+"cobblestone.png"),new File(path+"bedrock.png"),new File(path+"sand.png"),new File(path+"gravel.png"),new File(path+"log_oak.png"),new File(path+"log_oak_top.png"),new File(path+"iron_block.png"),new File(path+"gold_block.png"),new File(path+"diamond_block.png"),new File(path+"emerald_block.png"),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(path+"mushroom_red.png"),new File(path+"mushroom_brown.png"),new File(path+"sapling_jungle.png"),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(path+"gold_ore.png"),new File(path+"iron_ore.png"),new File(path+"coal_ore.png"),new File(path+"bookshelf.png"),new File(path+"cobblestone_mossy.png"),new File(path+"obsidian.png"),new File(path+"grass_side_overlay.png"),new File(path+"tallgrass.png"),new File(path+"grass_top.png"),new File(path+"beacon.png"),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(path+"crafting_table_top.png"),new File(path+"furnace_front_off.png"),new File(path+"furnace_side.png"),new File(path+"dispenser_front_horizontal.png"),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(path+"sponge.png"),new File(path+"glass.png"),new File(path+"diamond_ore.png"),new File(path+"redstone_ore.png"),new File(path+"leaves_oak.png"),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(path+"stonebrick.png"),new File(path+"deadbush.png"),new File(path+"fern.png"),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(path+"crafting_table_side.png"),new File(path+"crafting_table_front.png"),new File(path+"furnace_front_on.png"),new File(path+"furnace_top.png"),new File(path+"sapling_spruce.png"),new File(path+"wool_colored_white.png"),new File(path+"mob_spawner.png"),new File(path+"snow.png"),new File(path+"ice.png"),new File(path+"grass_side_snowed.png"),new File(path+"cactus_top.png"),new File(path+"cactus_side.png"),new File(path+"cactus_bottom.png"),new File(path+"clay.png"),new File(path+"reeds.png"),new File(path+"jukebox_side.png"),new File(path+"jukebox_top.png"),new File(path+"waterlily.png"),new File(path+"mycelium_side.png"),new File(path+"mycelium_top.png"),new File(path+"sapling_birch.png"),new File(path+"torch_on.png"),new File(path+"door_wood_upper.png"),new File(path+"door_iron_upper.png"),new File(path+"ladder.png"),new File(path+"trapdoor.png"),new File(path+"iron_bars.png"),new File(path+"farmland_wet.png"),new File(path+"farmland_dry.png"),new File(path+"wheat_stage_0.png"),new File(path+"wheat_stage_1.png"),new File(path+"wheat_stage_2.png"),new File(path+"wheat_stage_3.png"),new File(path+"wheat_stage_4.png"),new File(path+"wheat_stage_5.png"),new File(path+"wheat_stage_6.png"),new File(path+"wheat_stage_7.png"),new File(path+"lever.png"),new File(path+"door_wood_lower.png"),new File(path+"door_iron_lower.png"),new File(path+"redstone_torch_on.png"),new File(path+"stonebrick_mossy.png"),new File(path+"stonebrick_cracked.png"),new File(path+"pumpkin_top.png"),new File(path+"netherrack.png"),new File(path+"soul_sand.png"),new File(path+"glowstone.png"),new File(path+"piston_top_sticky.png"),new File(path+"piston_top_normal.png"),new File(path+"piston_side.png"),new File(path+"piston_bottom.png"),new File(path+"piston_inner.png"),new File(path+"pumpkin_stem_disconnected.png"),new File(path+"rail_normal_turned.png"),new File(path+"wool_colored_black.png"),new File(path+"wool_colored_gray.png"),new File(path+"redstone_torch_off.png"),new File(path+"log_spruce.png"),new File(path+"log_birch.png"),new File(path+"pumpkin_side.png"),new File(path+"pumpkin_face_off.png"),new File(path+"pumpkin_face_on.png"),new File(path+"cake_top.png"),new File(path+"cake_side.png"),new File(path+"cake_inner.png"),new File(path+"cake_bottom.png"),new File(path+"mushroom_block_skin_red.png"),new File(path+"mushroom_block_skin_brown.png"),new File(path+"pumpkin_stem_connected.png"),new File(path+"rail_normal.png"),new File(path+"wool_colored_red.png"),new File(path+"wool_colored_pink.png"),new File(path+"repeater_off.png"),new File(path+"leaves_spruce.png"),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(path+"bed_feet_top.png"),new File(path+"bed_head_top.png"),new File(path+"melon_side.png"),new File(path+"melon_top.png"),new File(path+"cauldron_top.png"),new File(path+"cauldron_inner.png"),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(path+"mushroom_block_skin_stem.png"),new File(path+"mushroom_block_inside.png"),new File(path+"vine.png"),new File(path+"lapis_block.png"),new File(path+"wool_colored_green.png"),new File(path+"wool_colored_lime.png"),new File(path+"repeater_on.png"),new File(path+"glass_pane_top.png"),new File(path+"bed_feet_end.png"),new File(path+"bed_feet_side.png"),new File(path+"bed_head_side.png"),new File(path+"bed_head_end.png"),new File(path+"log_jungle.png"),new File(path+"cauldron_side.png"),new File(path+"cauldron_bottom.png"),new File(path+"brewing_stand_base.png"),new File(path+"brewing_stand.png"),new File(path+"endframe_top.png"),new File(path+"endframe_side.png"),new File(path+"lapis_ore.png"),new File(path+"wool_colored_brown.png"),new File(path+"wool_colored_yellow.png"),new File(path+"rail_golden.png"),new File(path+"redstone_dust_dot.png"),new File(path+"redstone_dust_line0.png"),new File(path+"enchanting_table_top.png"),new File(path+"dragon_egg.png"),new File(path+"cocoa_stage_2.png"),new File(path+"cocoa_stage_1.png"),new File(path+"cocoa_stage_0.png"),new File(path+"emerald_ore.png"),new File(path+"trip_wire_source.png"),new File(path+"trip_wire.png"),new File(path+"endframe_eye.png"),new File(path+"end_stone.png"),new File(path+"sandstone_top.png"),new File(path+"wool_colored_blue.png"),new File(path+"wool_colored_light_blue.png"),new File(path+"rail_golden_powered.png"),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(path+"enchanting_table_side.png"),new File(path+"enchanting_table_bottom.png"),new File(path+"command_block_back.png"),new File(path+"itemframe_background.png"),new File(path+"flower_pot.png"),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(path+"sandstone_normal.png"),new File(path+"wool_colored_purple.png"),new File(path+"wool_colored_magenta.png"),new File(path+"rail_detector.png"),new File(path+"leaves_jungle.png"),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(path+"planks_spruce.png"),new File(path+"planks_jungle.png"),new File(path+"carrots_stage_0.png"),new File(path+"carrots_stage_1.png"),new File(path+"carrots_stage_2.png"),new File(path+"carrots_stage_3.png"),new File(path+"potatoes_stage_3.png"),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(path+"sandstone_bottom.png"),new File(path+"wool_colored_cyan.png"),new File(path+"wool_colored_orange.png"),new File(path+"redstone_lamp_off.png"),new File(path+"redstone_lamp_on.png"),new File(path+"stonebrick_carved.png"),new File(path+"planks_birch.png"),new File(path+"anvil_base.png"),new File(path+"anvil_top_damaged_1.png"),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(path+"nether_brick.png"),new File(path+"wool_colored_silver.png"),new File(path+"nether_wart_stage_0.png"),new File(path+"nether_wart_stage_1.png"),new File(path+"nether_wart_stage_2.png"),new File(path+"sandstone_carved.png"),new File(path+"sandstone_smooth.png"),new File(path+"anvil_top_damaged_0.png"),new File(path+"anvil_top_damaged_2.png"),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(path+"destroy_stage_0.png"),new File(path+"destroy_stage_1.png"),new File(path+"destroy_stage_2.png"),new File(path+"destroy_stage_3.png"),new File(path+"destroy_stage_4.png"),new File(path+"destroy_stage_5.png"),new File(path+"destroy_stage_6.png"),new File(path+"destroy_stage_7.png"),new File(path+"destroy_stage_8.png"),new File(path+"destroy_stage_9.png"),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile()),new File(FileManipulation.class.getClassLoader().getResource("images/empty.png").getFile())};
		BufferedImage terrain = new BufferedImage(256, 256, BufferedImage.TYPE_INT_ARGB);
		int x = 0, y = 0;
		
		for(int img = 0; img < textures.length; img++) {
			BufferedImage base = ImageIO.read(textures[img]);
			if(x == 256) {
				x = 0;
				y += 16;
			}
			Graphics g = terrain.getGraphics();
			g.drawImage(base, x, y, null);
			g.dispose();
			ImageIO.write(terrain, "png", new File(path+"terrain.png"));
			x += 16;
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void convert_pack() throws IOException, ParseException {
		String description = "";
		if(Main.ToType == 1) {
			if(Main.FromType == 2) {
				File packt = new File(Main.fileCopied+"/pack.txt");
				BufferedReader br = new BufferedReader(new FileReader(packt));
		 		description = br.readLine();
		 		br.close();
		 		packt.delete();
		 	} else if(Main.FromType == 3) {
		 		File manifest = new File(Main.fileCopied+"/manifest.json");
				JSONParser jp = new JSONParser();
				JSONObject jFile = (JSONObject) jp.parse(new FileReader(manifest));
				JSONObject header = (JSONObject) jFile.get("header");
				description = header.get("description").toString();
				manifest.delete();
			}
			JSONObject jo = new JSONObject();
			JSONObject pack = new JSONObject();
			pack.put("description", description);
			pack.put("pack_format", 5);
			jo.put("pack", pack);
			
			FileWriter fw = new FileWriter(Main.fileCopied+"/pack.mcmeta");
			fw.write(jo.toJSONString());
			fw.close();
		} else if(Main.ToType == 2) {
			if(Main.FromType == 1) {
				File packr = new File(Main.fileCopied+"/pack.mcmeta");
				JSONParser jp = new JSONParser();
				JSONObject jFile = (JSONObject) jp.parse(new FileReader(packr));
				JSONObject pack = (JSONObject) jFile.get("pack");
				description = pack.get("description").toString();
				packr.delete();
			} else if(Main.FromType == 3) {
				File manifest = new File(Main.fileCopied+"/manifest.json");
				JSONParser jp = new JSONParser();
				JSONObject jFile = (JSONObject) jp.parse(new FileReader(Main.fileCopied+"/manifest.json"));
				JSONObject header = (JSONObject) jFile.get("header");
				description = header.get("description").toString();
				manifest.delete();
			}
			
			FileWriter fw = new FileWriter(Main.fileCopied+"/pack.txt");
			fw.write(description);
			fw.close();
			
		} else if(Main.ToType == 3) {
			if(Main.FromType == 1) {
				File packr = new File(Main.fileCopied+"/pack.mcmeta");
				JSONParser jp = new JSONParser();
				JSONObject jFile = (JSONObject) jp.parse(new FileReader(Main.file+"/pack.mcmeta"));
				JSONObject pack = (JSONObject) jFile.get("pack");
				description = pack.get("description").toString();
				packr.delete();
			} else if(Main.FromType == 2) {
				File packt = new File(Main.fileCopied+"/pack.txt");
				BufferedReader br = new BufferedReader(new FileReader(Main.file+"/pack.txt"));
		 		description = br.readLine();
		 		br.close();
		 		packt.delete();
			}
			JSONObject jo = new JSONObject();
			jo.put("format_version", 2);
			JSONObject header = new JSONObject();
			header.put("description", description);
			if(Main.fileCopied.getName().contains(".zip")) header.put("name", Main.fileCopied.getName().toString().substring(0, Main.fileCopied.getName().toString().lastIndexOf(".")));
			if(!Main.fileCopied.getName().contains(".zip")) header.put("name", Main.fileCopied.getName());
			header.put("uuid", UUID.randomUUID());
			JSONArray version = new JSONArray();
			version.add(1);
			version.add(0);
			version.add(0);
			header.put("version", version);
			JSONArray minEng = new JSONArray();
			minEng.add(1);
			minEng.add(10);
			minEng.add(1);
			header.put("min_engine_version", minEng);
			JSONArray modules = new JSONArray();
			JSONObject jo1 = new JSONObject();
			jo1.put("description", description);
			jo1.put("type", "resource");
			jo1.put("uuid", UUID.randomUUID());
			JSONArray version1 = new JSONArray();
			version1.add(1);
			version1.add(0);
			version1.add(0);
			jo1.put("version", version1);
			modules.add(jo1);
			jo.put("header", header);
			jo.put("modules", modules);
			
			FileWriter fw = new FileWriter(Main.fileCopied+"/manifest.json");
			fw.write(jo.toJSONString());
			fw.close();
		}
	}
	
	public static void crop() {
		if(Main.FromType == 1) {
			String path = Main.fileCopied+"/assets/minecraft/textures/";
			File[] textures = {new File(path+"entity/steve.png"),new File(path+"entity/zombie_pigman.png"),new File(path+"entity/zombie/zombie.png")};
			try {
				BufferedImage img = ImageIO.read(new File(path+"blocks/command_block_back.png"));
				BufferedImage cropped = img.getSubimage(0, 0, 16, 16);
				ImageIO.write(cropped, "png", new File(path+"blocks/command_block_back.png"));
				
				BufferedImage img1 = ImageIO.read(new File(path+"environment/moon_phases.png"));
				BufferedImage cropped1 = img1.getSubimage(0, 0, 32, 32);
				ImageIO.write(cropped1, "png", new File(path+"environment/moon_phases.png"));
				
				for(int i = 0; i < textures.length; i++) {
					BufferedImage img2 = ImageIO.read(textures[i]);
					BufferedImage cropped2 = img2.getSubimage(0, 0, 64, 32);
					ImageIO.write(cropped2, "png", textures[i]);
				}
			} catch(Exception e) {}
		} else if(Main.FromType == 3) {
			String path = Main.fileCopied+"/textures/";
			File[] textures = {new File(path+"entity/steve.png"),new File(path+"entity/zombie_pigman.png"),new File(path+"entity/zombie/zombie.png")};
			try {
				BufferedImage img = ImageIO.read(new File(path+"blocks/glass_pane_top.png"));
				BufferedImage cropped = img.getSubimage(7, 0, 9, 16);
				BufferedImage pane = new BufferedImage(16, 16, BufferedImage.TYPE_INT_ARGB);
				Graphics g = pane.getGraphics();
				g.drawImage(cropped, 7, 0, null);
				g.dispose();
				ImageIO.write(pane, "png", new File(path+"blocks/glass_pane_top.png"));
				
				BufferedImage img1 = ImageIO.read(new File(path+"environment/moon_phases.png"));
				BufferedImage cropped1 = img1.getSubimage(0, 0, 32, 32);
				ImageIO.write(cropped1, "png", new File(path+"environment/moon_phases.png"));
				
				for(int i = 0; i < textures.length; i++) {
					BufferedImage img2 = ImageIO.read(textures[i]);
					BufferedImage cropped2 = img2.getSubimage(0, 0, 64, 32);
					ImageIO.write(cropped2, "png", textures[i]);
				}
			} catch(Exception e) {}
		}
		convert_bed();
		tga_to_png();
	}
	
	private static void convert_bed() {
		if(Main.FromType == 1) {
			String path = Main.fileCopied+"/assets/minecraft/textures/";
			try {
				BufferedImage img = ImageIO.read(new File(path+"entity/bed/red.png"));
				BufferedImage bedl = img.getSubimage(50, 3, 3, 3);
				BufferedImage flipped = RotateImage.getFlipped(bedl, RotateImage.FLIP_180);
				
				BufferedImage bedft = img.getSubimage(6, 28, 16, 16);
				BufferedImage flipped1 = RotateImage.getFlipped(bedft, RotateImage.FLIP_NEG_90);
				ImageIO.write(flipped1, "png", new File(path+"entity/bed/bed_feet_top.png"));
				
				BufferedImage bedht = img.getSubimage(6, 6, 16, 16);
				BufferedImage flipped2 = RotateImage.getFlipped(bedht, RotateImage.FLIP_NEG_90);
				ImageIO.write(flipped2, "png", new File(path+"entity/bed/bed_head_top.png"));
				
				BufferedImage bedfs = img.getSubimage(22, 28, 6, 16);
				BufferedImage bedfs1 = new BufferedImage(16, bedfs.getHeight(), BufferedImage.TYPE_INT_ARGB);
				Graphics g = bedfs1.getGraphics();
				g.drawImage(bedfs, 7, 0, null);
				g.drawImage(RotateImage.getFlipped(flipped, RotateImage.FLIP_90), 13, 13, null);
				g.dispose();
				BufferedImage flipped3 = RotateImage.getFlipped(bedfs1, RotateImage.FLIP_NEG_90);
				ImageIO.write(flipped3, "png", new File(path+"entity/bed/bed_feet_side.png"));
				
				BufferedImage bedhs = img.getSubimage(22, 6, 6, 16);
				BufferedImage bedhs1 = new BufferedImage(16, bedhs.getHeight(), BufferedImage.TYPE_INT_ARGB);
				Graphics g1 = bedhs1.getGraphics();
				g1.drawImage(bedhs, 7, 0, null);
				g1.drawImage(RotateImage.getFlipped(flipped, RotateImage.FLIP_NEG_90), 13, 0, null);
				g1.dispose();
				BufferedImage flipped4 = RotateImage.getFlipped(bedhs1, RotateImage.FLIP_NEG_90);
				ImageIO.write(flipped4, "png", new File(path+"entity/bed/bed_head_side.png"));
				
				BufferedImage bedfe = img.getSubimage(22, 22, 16, 6);
				BufferedImage bedfe1 = new BufferedImage(bedfe.getWidth(), 16, BufferedImage.TYPE_INT_ARGB);
				Graphics g2 = bedfe1.getGraphics();
				g2.drawImage(bedfe, 0, 3, null);
				g2.drawImage(flipped, 0, 0, null);
				g2.drawImage(RotateImage.getFlipped(flipped, RotateImage.FLIP_180), 13, 0, null);
				g2.dispose();
				BufferedImage flipped5 = RotateImage.getFlipped(bedfe1, RotateImage.FLIP_180);
				ImageIO.write(flipped5, "png", new File(path+"entity/bed/bed_feet_end.png"));
				
				BufferedImage bedhe = img.getSubimage(6, 0, 16, 6);
				BufferedImage bedhe1 = new BufferedImage(bedhe.getWidth(), 16, BufferedImage.TYPE_INT_ARGB);
				Graphics g3 = bedhe1.getGraphics();
				g3.drawImage(bedhe, 0, 3, null);
				g3.drawImage(flipped, 0, 0, null);
				g3.drawImage(RotateImage.getFlipped(flipped, RotateImage.FLIP_180), 13, 0, null);
				g3.dispose();
				BufferedImage flipped6 = RotateImage.getFlipped(bedhe1, RotateImage.FLIP_180);
				ImageIO.write(flipped6, "png", new File(path+"entity/bed/bed_head_end.png"));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if(Main.FromType == 3) {
			String path = Main.fileCopied+"/textures/";
			try {
				BufferedImage img = ImageIO.read(new File(path+"entity/bed/red.png"));
				BufferedImage bedl = img.getSubimage(15, 38, 3, 3);
				BufferedImage flipped = RotateImage.getFlipped(bedl, RotateImage.FLIP_180);
				
				BufferedImage bedft = img.getSubimage(6, 22, 16, 16);
				BufferedImage flipped1 = RotateImage.getFlipped(bedft, RotateImage.FLIP_NEG_90);
				ImageIO.write(flipped1, "png", new File(path+"entity/bed/bed_feet_top.png"));
				
				BufferedImage bedht = img.getSubimage(6, 6, 16, 16);
				BufferedImage flipped2 = RotateImage.getFlipped(bedht, RotateImage.FLIP_NEG_90);
				ImageIO.write(flipped2, "png", new File(path+"entity/bed/bed_head_top.png"));
				
				BufferedImage bedfs = img.getSubimage(22, 22, 6, 16);
				BufferedImage bedfs1 = new BufferedImage(16, bedfs.getHeight(), BufferedImage.TYPE_INT_ARGB);
				Graphics g = bedfs1.getGraphics();
				g.drawImage(bedfs, 7, 0, null);
				g.drawImage(RotateImage.getFlipped(flipped, RotateImage.FLIP_90), 13, 13, null);
				g.dispose();
				BufferedImage flipped3 = RotateImage.getFlipped(bedfs1, RotateImage.FLIP_NEG_90);
				ImageIO.write(flipped3, "png", new File(path+"entity/bed/bed_feet_side.png"));
				
				BufferedImage bedhs = img.getSubimage(22, 6, 6, 16);
				BufferedImage bedhs1 = new BufferedImage(16, bedfs.getHeight(), BufferedImage.TYPE_INT_ARGB);
				Graphics g1 = bedhs1.getGraphics();
				g1.drawImage(bedhs, 7, 0, null);
				g1.drawImage(RotateImage.getFlipped(flipped, RotateImage.FLIP_NEG_90), 13, 0, null);
				g1.dispose();
				BufferedImage flipped4 = RotateImage.getFlipped(bedhs1, RotateImage.FLIP_NEG_90);
				ImageIO.write(flipped4, "png", new File(path+"entity/bed/bed_head_side.png"));
				
				BufferedImage bedfe = img.getSubimage(22, 0, 16, 6);
				BufferedImage bedfe1 = new BufferedImage(bedfe.getWidth(), 16, BufferedImage.TYPE_INT_ARGB);
				Graphics g2 = bedfe1.getGraphics();
				g2.drawImage(bedfe, 0, 3, null);
				g2.drawImage(flipped, 0, 0, null);
				g2.drawImage(RotateImage.getFlipped(flipped, RotateImage.FLIP_180), 13, 0, null);
				g2.dispose();
				BufferedImage flipped5 = RotateImage.getFlipped(bedfe1, RotateImage.FLIP_180);
				ImageIO.write(flipped5, "png", new File(path+"entity/bed/bed_feet_end.png"));
				
				BufferedImage bedhe = img.getSubimage(6, 0, 16, 6);
				BufferedImage bedhe1 = new BufferedImage(bedhe.getWidth(), 16, BufferedImage.TYPE_INT_ARGB);
				Graphics g3 = bedhe1.getGraphics();
				g3.drawImage(bedhe, 0, 3, null);
				g3.drawImage(flipped, 0, 0, null);
				g3.drawImage(RotateImage.getFlipped(flipped, RotateImage.FLIP_180), 13, 0, null);
				g3.dispose();
				BufferedImage flipped6 = RotateImage.getFlipped(bedhe1, RotateImage.FLIP_180);
				ImageIO.write(flipped6, "png", new File(path+"entity/bed/bed_head_end.png"));				
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void tga_to_png() {
		String path = Main.fileCopied+"/textures/";
		String[] tga_textures = {path+"entity/blaze.tga",path+"entity/ghast/ghast_shooting.tga",path+"entity/sheep/sheep.tga"};
		for(int i = 0; i < tga_textures.length; i++) {
			try {
				BufferedImage png_texture = TGA2PNG.read(Paths.get(tga_textures[i]+"tga"));
				ImageIO.write(png_texture, "PNG", new File(tga_textures[i]+"png"));
				File remove = new File(tga_textures[i]);
				remove.delete();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
