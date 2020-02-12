//Made with Blockbench
//Paste this code into your mod.

public static class Modelshield extends ModelBase {
	private final ModelRenderer bone;

	public Modelshield() {
		textureWidth = 128;
		textureHeight = 128;

		bone = new ModelRenderer(this);
		bone.setRotationPoint(0.0F, 24.0F, 0.0F);
		bone.cubeList.add(new ModelBox(bone, 0, 80, -22.0F, -42.0332F, 1.9669F,
				48, 48, 0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 6, -2.042F, -32.0104F,
				-0.0524F, 8, 8, 0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 6, 5.979F, -24.0174F, -0.0384F,
				4, 12, 0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 6, -6.021F, -23.9965F,
				-0.0175F, 4, 12, 0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 6, -2.0F, -12.0035F, -0.0035F,
				4, 12, 0, 0.0F, false));
		bone.cubeList.add(new ModelBox(bone, 0, 6, 2.0F, -12.0105F, -0.0105F,
				4, 12, 0, 0.0F, false));
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3,
			float f4, float f5) {
		bone.render(f5);
	}
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y,
			float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3,
			float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}
}