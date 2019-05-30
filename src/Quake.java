import java.util.List;
import processing.core.PImage;
import java.util.Optional;

public class Quake extends AbstractAnimatedEntity
{
    // private String id;
    // private Point position;
    // private List<PImage> images;
    // private int imageIndex;

    // //NOT USED:
    // private int resourceLimit;
    // private int resourceCount;

    // private int actionPeriod;
    // private int animationPeriod;

    private static final String QUAKE_ID = "quake";
    private static final String QUAKE_KEY = "quake";
    private static final int QUAKE_ACTION_PERIOD = 1100;
    private static final int QUAKE_ANIMATION_PERIOD = 100;
    private static final int QUAKE_ANIMATION_REPEAT_COUNT = 10;

    public Quake(String id, Point position, List<PImage> images, int actionPeriod, int animationPeriod)
    {
        // this.id = id;
        // this.position = position;
        // this.images = images;
        // this.imageIndex = 0;

        // //NOT USED:
        // this.resourceLimit = 0;
        // this.resourceCount = 0;

        // this.actionPeriod = actionPeriod;
        // this.animationPeriod = animationPeriod;
        super(id, position, images, 0, 0, actionPeriod, animationPeriod, QUAKE_ANIMATION_REPEAT_COUNT);
    }

    // public void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore)
    // {
    //     scheduler.scheduleEvent(this,
    //         Activity.createActivityAction(this, world, imageStore),
    //         this.actionPeriod);
    //     scheduler.scheduleEvent(this,
    //         Animation.createAnimationAction(this, QUAKE_ANIMATION_REPEAT_COUNT),
    //         this.animationPeriod);
    // }

    public void executeActivity(WorldModel world, ImageStore imageStore, EventScheduler scheduler)
    {
        scheduler.unscheduleAllEvents(this);
        world.removeEntity(this);
    }

    // public int getactionPeriod() { return actionPeriod; }
    // public int getanimationPeriod() { return animationPeriod; }
    // public void nextImage() { imageIndex = (imageIndex + 1) % images.size(); }

    // public Point getposition() { return position; }
    // public void setposition(Point point) { this.position = point; }
    // public List<PImage> getimages() { return images; }
    // public String getid() { return id; }
    // public int getImageIndex() { return imageIndex; }


    public static String getQuakeKey() {
        return QUAKE_KEY;
    }

    public <R> R accept(EntityVisitor<R> visitor)
    {
        return visitor.visit(this);
    }
}