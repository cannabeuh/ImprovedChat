import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;

public class Tab {

    public String name;
    public String prefix;
    public int width;
    public boolean blink = false;
    public boolean blinking = false;
    public List<ag> e = new ArrayList<ag>();
    public ArrayList<Pattern> track = new ArrayList<Pattern>();
    public ArrayList<Pattern> ignore = new ArrayList<Pattern>();
    public int chatScroll = 0;


    public Tab(String name) {
        this.name = name;
        this.prefix = "";
        this.width = ImprovedChat.minecraft.q.a(name);
    }

    public boolean valid(String line) {
        if (line != null && !line.trim().equals("")) {
            Iterator var3 = this.ignore.iterator();

            Pattern p;
            while (var3.hasNext()) {
                p = (Pattern) var3.next();
                if (p.matcher(line).find()) {
                    return false;
                }
            }

            var3 = this.track.iterator();

            while (var3.hasNext()) {
                p = (Pattern) var3.next();
                if (p.matcher(line).find()) {
                    return true;
                }
            }

            return false;
        } else {
            return false;
        }
    }

    public boolean ignored(String line) {
        Iterator var3 = this.ignore.iterator();

        while (var3.hasNext()) {
            Pattern p = (Pattern) var3.next();
            if (p.matcher(line).find()) {
                return true;
            }
        }

        return false;
    }

    public void track(String regex) {
        this.track.add(Pattern.compile(regex));
    }

    public void ignore(String regex) {
        this.ignore.add(Pattern.compile(regex));
    }

    public void add(String l) {
        this.e.add(0, new ag(l));
        this.blinking = this.blink;
    }

    public void add(ag l) {
        this.e.add(0, l);
        this.blinking = this.blink;
    }

    public void setName(String name) {
        this.name = name;
        this.width = ImprovedChat.minecraft.q.a(name);
    }
}