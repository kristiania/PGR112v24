package canvas;

import canvas.library.helper.Terminal;


public abstract class Plugin
{
    //# Fields
    private final String identifier;


    //# Constructors
    public Plugin() {
        this.identifier = STR."Plugin\{this.hashCode()}";

        Terminal.log(STR."Canvas.\{this.identifier}", "Plugin initialized");
    }

    public Plugin(String identifier) {
        this.identifier = identifier;

        Terminal.log(this.identifier, "Plugin initialized");
    }


    //# Methods
    public String getIdentifier() {
        return this.identifier;
    }

    public void setup(API.Setup canvas) {}
    public void update() {}
    abstract public void draw(API canvas);
}
