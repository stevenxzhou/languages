package ood.elevator;

import java.util.*;

enum ElevatorDoorState {
    Closed,
    Open
}

enum ElevatorStatus {
    movingUp,
    movingDown,
    Idle
}

public class Elevator {
    private int id;
    private ElevatorDoorState elevatorDoorState;
    private List<Integer> upFloors;
    private List<Integer> downFloors;
    private int waitTime;

    public int currentFloor;
    public ElevatorStatus elevatorStatus;

    public Elevator(int id) {
        this.id = id;
        this.currentFloor = 0;
        this.elevatorDoorState = ElevatorDoorState.Closed;
        this.elevatorStatus = elevatorStatus.Idle;
        this.waitTime = 10;
        this.upFloors = new ArrayList<>();
        this.downFloors = new ArrayList<>();
    }

    public void countDown() {
        this.waitTime = 20000;
        try {
            Thread.sleep(this.waitTime);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt(); // Restore interrupted status
            System.out.println("Thread was interrupted: " + e.getMessage());
        }
        moveElevator();
    }

    public void select(int destFloor) {
        if (destFloor < 0) {
            throw new IllegalArgumentException("Invalid Floor");
        } 
        if (this.elevatorStatus == ElevatorStatus.Idle) {
            if (destFloor > currentFloor) {
                this.upFloors.add(destFloor);
            } else if (destFloor < currentFloor) {
                this.downFloors.add(destFloor);
            } else {
                this.elevatorDoorState = ElevatorDoorState.Open;
            }
        }
    }

    public void moveElevator() {
        int uplen = upFloors.size();
        int downlen = downFloors.size();
        if (uplen > downlen) {
            upFloors.sort((itema, itemb) -> Integer.compare(itema, itemb));
            for (int floor : upFloors) {
                this.movingToFloor(floor);
                this.upFloors.remove(floor);
            }
        } else {
            downFloors.sort((itema, itemb) -> Integer.compare(itemb, itema));
            for (int floor : downFloors) {
                this.movingToFloor(floor);
                this.downFloors.remove(floor);
            }
        }
    }

    public void updateStatus() {
        if (upFloors.isEmpty() && downFloors.isEmpty()) {
            this.elevatorStatus = elevatorStatus.Idle;
        }
    }

    public void movingToFloor(int destFloor) {
        this.close();
        if (destFloor > currentFloor) {
            this.elevatorStatus = ElevatorStatus.movingUp;
            for (int i = currentFloor; i < destFloor; i++) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Restore interrupted status
                    System.out.println("Thread was interrupted: " + e.getMessage());
                }
                this.currentFloor = i;
            }
        } else {
            this.elevatorStatus = ElevatorStatus.movingDown;
            for (int i = currentFloor; i > destFloor; i--) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt(); // Restore interrupted status
                    System.out.println("Thread was interrupted: " + e.getMessage());
                }
                this.currentFloor = i;
            }
        }
        this.elevatorStatus = elevatorStatus.Idle;
        this.open(); 
    }

    public void close() {
        this.elevatorDoorState = ElevatorDoorState.Closed;
    }

    public void open() {
        this.elevatorDoorState = ElevatorDoorState.Open;
        this.countDown();
    }
}
