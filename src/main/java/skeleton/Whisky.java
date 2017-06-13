package skeleton;

import io.vertx.core.json.JsonObject;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by sunguolei on 2017/6/12.
 */
public class Whisky {
    private static final AtomicInteger COUNTER = new AtomicInteger();

    private final int id;

    private String name;

    private String origin;

    public Whisky(String name, String origin) {
        this.name = name;
        this.origin = origin;
        this.id = -1;
    }

    public Whisky(JsonObject json) {
        this.name = json.getString("NAME");
        this.origin = json.getString("ORIGIN");
        this.id = json.getInteger("ID");
    }

    public Whisky() {
        this.id = -1;
    }

    public Whisky(int id, String name, String origin) {
        this.id = id;
        this.name = name;
        this.origin = origin;
    }

    public String getName() {
        return name;
    }

    public String getOrigin() {
        return origin;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }
}
