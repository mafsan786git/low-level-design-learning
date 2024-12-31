package firstapproach;

public class HouseDirector {
    private final HouseBuilder houseBuilder;

    public HouseDirector(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public House constructBasicHouse() {
        houseBuilder.reset();
        houseBuilder.buildFoundation();
        houseBuilder.buildStructure();
        houseBuilder.buildRoof();
        return houseBuilder.getHouse();
    }

    public House constructLuxuryHouse() {
        houseBuilder.reset();
        houseBuilder.buildFoundation();
        houseBuilder.buildStructure();
        houseBuilder.buildRoof();
        houseBuilder.addGarden();
        houseBuilder.addSwimmingPool();
        return houseBuilder.getHouse();
    }
}

