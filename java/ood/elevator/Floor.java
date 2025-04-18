package ood.elevator;

public class Floor {

    Elevator[] elevators;
    int currentFloor;
    Elevator selectedElevator = null;

    public Floor() {
        this.currentFloor = currentFloor;
    }

    public void requestUp() {
        int closest = Integer.MAX_VALUE;

        for (Elevator elevator : elevators) {
            if (elevator.currentFloor < currentFloor && (elevator.elevatorStatus == ElevatorStatus.Idle || elevator.elevatorStatus == ElevatorStatus.movingUp)) {
                if (currentFloor - elevator.currentFloor < closest) {
                    closest = currentFloor - elevator.currentFloor;
                    selectedElevator = elevator;
                }
            } else if (elevator.currentFloor == currentFloor) {
                selectedElevator = elevator;
            }
        }

        if (selectedElevator.currentFloor == currentFloor) {
            selectedElevator.open();
        } else {
            selectedElevator.select(currentFloor);
        }
    }

    public void requestDown() {
        int closest = Integer.MAX_VALUE;
        for (Elevator elevator : elevators) {
            if (elevator.currentFloor > currentFloor && (elevator.elevatorStatus == ElevatorStatus.Idle || elevator.elevatorStatus == ElevatorStatus.movingDown )) {
                if (elevator.currentFloor - currentFloor < closest) {
                    closest = elevator.currentFloor - currentFloor;
                    selectedElevator = elevator;
                }
            } else if (elevator.currentFloor == currentFloor) {
                selectedElevator = elevator;
            }
        }

        if (selectedElevator.currentFloor == currentFloor) {
            selectedElevator.open();
        } else {
            selectedElevator.select(currentFloor);
        }
    }
}
