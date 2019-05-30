import java.util.List;
import processing.core.PImage;
import java.util.Random;
import java.util.Optional;

public class Vein extends AbstractActivity
{
    // private String id;
    // private Point position;
    // private List<PImage> images;
    // private int imageIndex;
    // private int resourceLimit;
    // private int resourceCount;
    // private int actionPeriod;
    // private int animationPeriod;

    private static final Random rand = new Random();

    public Vein(String id, Point position, List<PImage> images, int actionPeriod)
    {
        // this.id = id;
        // this.position = position;
        // this.images = images;
        // this.imageIndex = 0;
        // this.resourceLimit = 0;
        // this.resourceCount = 0;
        // this.actionPeriod = actionPeriod;
        // this.animationPeriod = 0;
        super(id, position, images, 0, 0, actionPeriod);
    }

    //    public void scheduleActions(EventScheduler scheduler, WorldModel world, ImageStore imageStore)
    //    {
    //         scheduler.scheduleEvent(this,
    //            Activity.createActivityAction(this, world, imageStore),
    //            this.actionPeriod);
    // }

    public void executeActivity(WorldModel world, ImageStore imageStore, EventScheduler scheduler)
    {
        Optional<Point> openPt = world.findOpenAround(this.getposition());

        if (openPt.isPresent())
        {
            Entity ore = openPt.get().createOre(Ore.getOreIdPrefix() + this.getid(),
                    Ore.getOreCorruptMin() + rand.nextInt(Ore.getOreCorruptMax() - Ore.getOreCorruptMin()),
                    imageStore.getImageList(Ore.getOreKey()));
            world.addEntity(ore);
            ((KineticEntity)ore).scheduleActions(scheduler, world, imageStore);
        }

        scheduler.scheduleEvent(this,
                Activity.createActivityAction(this, world, imageStore),
                this.getactionPeriod());
    }

    // public int getactionPeriod() { return actionPeriod; }
    // public Point getposition() { return position; }
    // public void setposition(Point point) { this.position = point; }
    // public List<PImage> getimages() { return images; }
    // public String getid() { return id; }
    // public int getImageIndex() { return imageIndex; }

    public <R> R accept(EntityVisitor<R> visitor)
    {
        return visitor.visit(this);
    }
}