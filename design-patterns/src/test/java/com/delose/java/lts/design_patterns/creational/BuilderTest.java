package com.delose.java.lts.design_patterns.creational;

import org.junit.jupiter.api.Test;

public class BuilderTest {

    @Test
    public void testConstructHouse() throws Exception {
        HouseBuilder concreteHouseBuilder = new ConcreteHouseBuilder();
        ConstructionEngineer engineerA = new ConstructionEngineer(concreteHouseBuilder);
        House houseA = engineerA.constructHouse();
        System.out.println("House is: "+houseA);
        PrefabricatedHouseBuilder prefabricatedHouseBuilder = new PrefabricatedHouseBuilder();
        ConstructionEngineer engineerB = new ConstructionEngineer(prefabricatedHouseBuilder);
        House houseB = engineerB.constructHouse();
        System.out.println("House is: "+houseB);
    }
}
