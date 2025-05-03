package ood.elevator;

public class Building {
    Floor[] floors;
    Elevator[] elevators;

    public Building() {
        this.floors = new Floor[20];
        this.elevators = new Elevator[6];
        for (int i = 0; i < 20; i++) {
            floors[i].currentFloor = i;
            floors[i].elevators = this.elevators;
        }
    }

    public void Test() {
        floors[0].requestUp();
        Elevator selectedElevator = floors[0].selectedElevator;

        while (selectedElevator.currentFloor != floors[0].currentFloor) {
            System.out.println(selectedElevator.elevatorStatus);
            System.out.println(selectedElevator.currentFloor);
        }
    }
}
