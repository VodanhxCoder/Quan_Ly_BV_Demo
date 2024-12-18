<<<<<<< HEAD
package quan_ly_benh_vien.Model;

import java.io.File;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Model_Menu {

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }

    public Model_Menu(String icon, String name, MenuType type) {
        this.icon = icon;
        this.name = name;
        this.type = type;
    }

    public Model_Menu() {
    }

    private String icon;
    private String name;
    private MenuType type;

    public Icon toIcon() {
        URL url = getClass().getResource("/image/" + icon + ".png");
        if (url == null) {
            System.err.println("Không tìm thấy file: /image/" + icon + ".png");
            return null;
        }
        return new ImageIcon(url);
    }

    public static enum MenuType {
        TITLE, MENU, EMPTY
    }
}
=======
package quan_ly_benh_vien.Model;

import java.io.File;
import java.net.URL;
import javax.swing.Icon;
import javax.swing.ImageIcon;

public class Model_Menu {

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuType getType() {
        return type;
    }

    public void setType(MenuType type) {
        this.type = type;
    }

    public Model_Menu(String icon, String name, MenuType type) {
        this.icon = icon;
        this.name = name;
        this.type = type;
    }

    public Model_Menu() {
    }

    private String icon;
    private String name;
    private MenuType type;

    public Icon toIcon() {
        URL url = getClass().getResource("/image/" + icon + ".png");
        if (url == null) {
            System.err.println("Không tìm thấy file: /image/" + icon + ".png");
            return null;
        }
        return new ImageIcon(url);
    }

    public static enum MenuType {
        TITLE, MENU, EMPTY
    }
}
>>>>>>> 96401bc93da2f4db16dbd96e6dd672a4297133c6
