package com.delose.java.lts.design_patterns.creational;


/**
 * Builder pattern is a creational design pattern
 * that lets you construct complex objects step by step.
 */
public class Builder {
    public static void main(String[] args) {

    }

}

class House {
    private String foundation;
    private String structure;
    private String roof;
    private boolean furnished;
    private boolean painted;
    public void setFoundation(String foundation) {
        this. foundation = foundation;
    }
    public void setStructure(String structure) {
        this.structure = structure;
    }
    public void setRoof(String roof) {
        this.roof = roof;
    }
    public void setFurnished(boolean furnished) {
        this.furnished = furnished;
    }
    public void setPainted(boolean painted) {
        this.painted = painted;
    }
    @Override
    public String toString() {
        return "Foundation - " + foundation + " Structure - " + structure + " Roof - " + roof +" Is Furnished? "+furnished+" Is Painted? "+painted;
    }
}


interface HouseBuilder {
    void buildFoundation();
    void buildStructure();
    void buildRoof();
    void paintHouse();
    void furnishHouse();
    House getHouse();
}

class ConcreteHouseBuilder implements HouseBuilder{
    private House house;
    public ConcreteHouseBuilder() {
        this.house = new House();
    }
    @Override
    public void buildFoundation() {
        house.setFoundation("Concrete, brick, and stone");
        System.out.println("ConcreteHouseBuilder: Foundation complete...");
    }
  @Override
    public void buildStructure(){
      house.setStructure("Concrete, mortar, brick, and reinforced steel");
      System.out.println("ConcreteHouseBuilder: Structure complete...");
  }
    @Override
    public void buildRoof(){
      house.setRoof("Concrete and reinforced steel");
        System.out.println("ConcreteHouseBuilder: Roof complete...");
    }
    @Override
    public void paintHouse(){
      house.setPainted(true);
        System.out.println("ConcreteHouseBuilder: Painting complete...");
    }
    @Override
    public void furnishHouse(){
    house.setFurnished(true);
        System.out.println("ConcreteHouseBuilder: Furnishing complete...");
    }
    public House getHouse() {
        System.out.println("ConcreteHouseBuilder: Concrete house complete...");
        return this.house;
    }
}

class PrefabricatedHouseBuilder implements HouseBuilder{
    private House house;
    public PrefabricatedHouseBuilder() {
        this.house = new House();
    }
    @Override
    public void buildFoundation() {
        house.setFoundation("Wood, laminate, and PVC flooring");
        System.out.println("PrefabricatedHouseBuilder: Foundation complete...");
    }
    @Override
    public void buildStructure(){
        house.setStructure("Structural steels and wooden wall panels");
        System.out.println("PrefabricatedHouseBuilder: Structure complete...");
    }
    @Override
    public void buildRoof(){
        house.setRoof("Roofing sheets");
        System.out.println("PrefabricatedHouseBuilder: Roof complete...");
    }
    @Override
    public void paintHouse(){
        house.setPainted(false);
        System.out.println("PrefabricatedHouseBuilder: Painting not required...");
    }
    @Override
    public void furnishHouse(){
        house.setFurnished(true);
        System.out.println("PrefabricatedHouseBuilder: Furnishing complete...");
    }
    public House getHouse() {
        System.out.println("PrefabricatedHouseBuilder: Prefabricated house complete...");
        return this.house;
    }
}

class ConstructionEngineer {
    private HouseBuilder houseBuilder;
    public ConstructionEngineer(HouseBuilder houseBuilder){
        this.houseBuilder = houseBuilder;
    }
    public House constructHouse() {
        this.houseBuilder.buildFoundation();
        this.houseBuilder.buildStructure();
        this.houseBuilder.buildRoof();
        this.houseBuilder.paintHouse();
        this.houseBuilder.furnishHouse();
        return this.houseBuilder.getHouse();
    }
}
