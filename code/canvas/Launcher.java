package canvas;

import canvas.library.helper.Terminal;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.*;


public class Launcher
{
    //# Main-method
    public static void main(String[] args) {
        Launcher.createWindow(640, 480);
    }


    //# Static-fields
    static private final ArrayList<String> folders = new ArrayList<>();
    static private final HashMap<String, Module> modules = new HashMap<>();
    static private final HashMap<String, Plugin> plugins = new HashMap<>();


    //# Static-block
    static {
        // default folders to look for modules and plugins in
        folders.add("code/sandbox");
        folders.add("student");
    }


    //# Constructors
    private Launcher() {}


    //# Static-methods
    static public void createWindow(int width, int height) {
        Window.initialize(width, height, Launcher.getPlugins());
    }

    static public void createWindow(int width, int height, Plugin... plugins) {
        Window.initialize(width, height, List.of(plugins));
    }

    static private ArrayList<Plugin> getPlugins() {
        return Launcher.getPlugins(Launcher.folders);
    }

    static private ArrayList<Plugin> getPlugins(List<String> folders) {
        return Launcher.getPlugins(Launcher.plugins, folders);
    }

    static private ArrayList<Plugin> getPlugins(
            HashMap<String, Plugin> manifest,
            List<String> folders
    ) {
        ArrayList<Plugin> output = new ArrayList<>();

        for (String folder : folders) {
            File resource = new File(folder);
            Launcher.findPlugins(manifest, output, resource.listFiles());
        }

        return output;
    }

    static private void findPlugins(List<Plugin> output, File[] input) {
        Launcher.findPlugins(Launcher.plugins, output, input);
    }

    static private void findPlugins(
            final Map<String, Plugin> manifest,
            List<Plugin> output,
            File[] input
    ) {
        if (input != null) {
            for (File file : input) {
                if (file.isDirectory()) {
                    Launcher.findPlugins(output, file.listFiles());
                }
                else if (file.isFile()) {
                    if (file.getName().endsWith(".java")) {
                        Launcher.parsePlugin(manifest, output, file);
                    }
                }
            }
        }
    }

    static private void parsePlugin(
            Map<String, Plugin> manifest,
            List<Plugin> output,
            File input
    ) {
        String classIdentifier = input.getPath()
                .replaceFirst("code.", "")
                .replaceFirst("student.", "")
                .replaceAll("/", ".")
                .replace(".java", "");

        if (manifest.containsKey(classIdentifier)) {
            return;
        }

        try {
            Class<?> template = Class.forName(classIdentifier);

            if (template.getSuperclass().getName().equals("canvas.Plugin")) {
                output.add((Plugin) template.getDeclaredConstructor().newInstance());

                Terminal.log("Launcher", STR."Plugin loaded: \{classIdentifier}");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (
                InvocationTargetException
                | InstantiationException
                | IllegalAccessException
                | NoSuchMethodException e
        ) {
            throw new RuntimeException(e);
        }
    }
}
