import com.sun.j3d.utils.geometry.Cone;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Primitive;
import com.sun.j3d.utils.image.TextureLoader;

import javax.media.j3d.*;
import javax.vecmath.AxisAngle4d;
import javax.vecmath.Color3f;
import javax.vecmath.Color4f;
import javax.vecmath.Vector3f;
import java.awt.*;


public class PensilBody {

    public static Cylinder getBigCylinder(float cylinderHeight) {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Cylinder(0.2f, cylinderHeight, primflags, getBigCylinderAppearence());
    }

    public static Cylinder getMiddleCylinder(float cylinderHeight) {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Cylinder(0.21f, cylinderHeight, primflags, getMiddleCylinderAppearence());
    }

    public static Cylinder getPencilRubber(float cylinderHeight) {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Cylinder(0.23f, cylinderHeight, primflags, getPencilRubberAppearence());
    }

    private static Cone getPencilCap() {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Cone(0.2f, 0.2f, primflags, getPencilCapAppearence());
    }


    public static TransformGroup getCylinders(float height, float xPos, float yPos) {
        TransformGroup tg = new TransformGroup();

        Cylinder centralTower = PensilBody.getBigCylinder(height);
        Transform3D centralTowerT = new Transform3D();
        centralTowerT.setTranslation(new Vector3f(xPos, yPos, height * 0.5f));
        centralTowerT.setRotation(new AxisAngle4d(1, 0, 0, Math.toRadians(90)));
        TransformGroup centralTowerTG = new TransformGroup();
        centralTowerTG.setTransform(centralTowerT);
        centralTowerTG.addChild(centralTower);
        tg.addChild(centralTowerTG);

        Cylinder pencilMiddle = PensilBody.getMiddleCylinder(0.08f);
        Transform3D pencilMiddleT = new Transform3D();
        pencilMiddleT.setTranslation(new Vector3f(xPos, yPos, height * 0.99f));
        pencilMiddleT.setRotation(new AxisAngle4d(1, 0, 0, Math.toRadians(90)));
        TransformGroup pencilMiddleTG = new TransformGroup();
        pencilMiddleTG.setTransform(pencilMiddleT);
        pencilMiddleTG.addChild(pencilMiddle);
        tg.addChild(pencilMiddleTG);


        Cone pencilCap = PensilBody.getPencilCap();
        Transform3D pencilCapT = new Transform3D();
        pencilCapT.setTranslation(new Vector3f(xPos, yPos, height + 0.1f));
        pencilCapT.setRotation(new AxisAngle4d(1, 0, 0, Math.toRadians(90)));
        TransformGroup pencilCapTG = new TransformGroup();
        pencilCapTG.setTransform(pencilCapT);
        pencilCapTG.addChild(pencilCap);
        tg.addChild(pencilCapTG);

        return tg;
    }

    private static Appearance getBigCylinderAppearence() {
        // завантажуємо текстуру
        TextureLoader loader = new TextureLoader("./resources/pencilbody.jpg", "LUMINANCE", new
                Container());

        Texture texture = loader.getTexture();
        // задаємо властивості границі текстури
        texture.setBoundaryModeS(Texture.WRAP);
        texture.setBoundaryModeT(Texture.WRAP);
        texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 1.0f, 0.0f));

        // встановлюємо атрибути текстури
        TextureAttributes texAttr = new TextureAttributes();
        texAttr.setTextureMode(TextureAttributes.MODULATE); // може бути REPLACE, BLEND або DECAL замість MODULATE

        Appearance ap = new Appearance();
        ap.setTexture(texture);
        ap.setTextureAttributes(texAttr);

        Color3f emissive = new Color3f(new Color(149, 67, 21));
        Color3f ambient = new Color3f(new Color(149, 67, 21));
        Color3f diffuse = new Color3f(new Color(100, 38, 38));
        Color3f specular = new Color3f(new Color(149, 67, 21));
        ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
        return ap;
    }

    private static Appearance getPencilCapAppearence() {
        Appearance ap = new Appearance();
        Color3f emissive = new Color3f(new Color(0, 0, 0));
        Color3f ambient = new Color3f(new Color(255, 224, 124));
        Color3f diffuse = new Color3f(new Color(255, 38, 38));
        Color3f specular = new Color3f(new Color(0, 0, 0));
        ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
        return ap;
    }

    private static Appearance getPencilRubberAppearence() {
        Appearance ap = new Appearance();
        Color3f emissive = new Color3f(new Color(0, 0, 0));
        Color3f ambient = new Color3f(new Color(255, 131, 142));
        Color3f diffuse = new Color3f(new Color(255, 38, 38));
        Color3f specular = new Color3f(new Color(0, 0, 0));
        ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
        return ap;
    }

    private static Appearance getMiddleCylinderAppearence() {
        Appearance ap = new Appearance();
        Color3f emissive = new Color3f(new Color(0, 0, 0));
        Color3f ambient = new Color3f(new Color(0, 0, 0));
        Color3f diffuse = new Color3f(new Color(54, 27, 10));
        Color3f specular = new Color3f(new Color(0, 0, 0));
        ap.setMaterial(new Material(ambient, emissive, diffuse, specular, 1.0f));
        return ap;
    }

}