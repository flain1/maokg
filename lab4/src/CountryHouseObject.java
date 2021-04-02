import com.sun.j3d.utils.geometry.*;
import com.sun.j3d.utils.image.TextureLoader;
import javax.media.j3d.*;
import javax.vecmath.*;
import javax.vecmath.Color3f;
import java.awt.*;

public class CountryHouseObject {
    public static Box getBody(float height, float width, float length) {
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Box(width, length, height, primflags, getBodyAppearence());
    }

    public static Cone getHouseRoof(float height, float radius){
        TransformGroup tg = new TransformGroup();
        int primflags = Primitive.GENERATE_NORMALS + Primitive.GENERATE_TEXTURE_COORDS;
        return new Cone(radius, height, primflags, getRoofAppearence());
    }


    private static Appearance getBodyAppearence() {
        
        TextureLoader loader = new TextureLoader("resources\\woodtexture.jpg",
                new Container());
        Texture texture = loader.getTexture();

      
        texture.setBoundaryModeS(Texture.WRAP);
        texture.setBoundaryModeT(Texture.WRAP);
        texture.setBoundaryColor(new Color4f(0.0f, 1.0f, 1.0f, 0.0f));

        
        TextureAttributes texAttr = new TextureAttributes();
        texAttr.setTextureMode(TextureAttributes.REPLACE); 

        Appearance ap = new Appearance();
        ap.setTexture(texture);
        ap.setTextureAttributes(texAttr);
        return ap;
    }

    private static Appearance getRoofAppearence() {
        
        TextureLoader loader = new TextureLoader("resources\\woodtexture.jpg",
                new Container());

        Texture texture = loader.getTexture();

        
        texture.setBoundaryModeS(Texture.WRAP);
        texture.setBoundaryModeT(Texture.WRAP);
        texture.setBoundaryColor(new Color4f(0.0f, 0.0f, 0.0f, 0.0f));

        
        TextureAttributes texAttr = new TextureAttributes();
        texAttr.setTextureMode(TextureAttributes.REPLACE);

        Appearance ap = new Appearance();
        ap.setTexture(texture);
        ap.setTextureAttributes(texAttr);
        return ap;
    }
}