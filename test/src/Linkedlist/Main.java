import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static class Floor
    {
        private int currentFloor;
        private int destinationFloor;
        private String direction;

        public String getDirection()
        {
            return direction;
        }

        public int getCurrentFloor()
        {
            return currentFloor;
        }
        public int getDestinationFloor()
        {
            return destinationFloor;
        }

        public Floor(int destinationFloor)
        {
            this.currentFloor = currentFloor;
            this.direction = direction;
            this.destinationFloor = destinationFloor;
        }


        public void addFloor(Floor f)
        {
            Elevator.queue.add(f.destinationFloor);
            System.out.println("Next Request:" + f.destinationFloor);
        }

        public void goUp()
        {
            System.out.println("Elevator is going up");
        }

        public void goDown()
        {
            System.out.println("Elevator is going down");
        }


    }

    public static class ElevatorManager
    {
        private Elevator idleElevator, elevatorInSameDirection;

        Elevator e = new Elevator(3, "Up");

        public int enterDestination(int d)
        {
            Floor f = new Floor(d);
            return d;
        }


        public void delegate(Elevator currentFloor, Elevator direction,int d)
        {
            if (Elevator.queue.peek() != null)
            {

                if (enterDestination(d) == e.getCurrentFloor())
                {
                    Elevator.queue.remove();
                    System.out.println("Destination reached");
                    //System.out.println("Next destination"+Elevator.queue.peek());
                   //e.setCurrentFloor(f.getDestinationFloor());

                }
                else if(enterDestination(d) < e.getCurrentFloor())
                {
                    // System.out.println("Going up");
                    // e.moveUp();
                    //e.setCurrentFloor(f.getDestinationFloor());

                    System.out.println("Going down");
                    e.moveDown();
                }
                else if (enterDestination(d) > e.getCurrentFloor()) {
                    // System.out.println("Going down");
                    // e.moveDown();
                    //e.setCurrentFloor(f.getDestinationFloor());

                    System.out.println("Going up");
                    e.moveUp();
                    //e.setCurrentFloor(f.getDestinationFloor());
                }
            }
        }
    }

    public static class Elevator
    {
        static Queue<Integer> queue = new LinkedList<>();
        private int currentFloor;
        Floor f;
        private String direction;

        public void details(Elevator e)
        {
            System.out.println("Current floor:" + currentFloor);
            System.out.println("Lift is going" + direction);
        }

        public Elevator(int currentFloor, String direction)
        {
            this.currentFloor = currentFloor;
            this.direction = direction;
        }

        public String getDirection()
        {
            return direction;
        }

        public int getCurrentFloor()
        {
            return currentFloor;
        }

        public void setCurrentFloor(int f)
        {
            currentFloor=f;
        }

        public void moveUp()
        {
            currentFloor++;
        }

        public void moveDown()
        {
            currentFloor--;
        }

        public void operate()
        {
            while (queue.peek() != null)
            {
                int nextFloor = queue.peek();
                while (currentFloor != nextFloor)
                {
                    if (direction == "Up")
                    {
                        moveUp();
                    }
                    else if (direction == "Down")
                    {

                        moveDown();
                    }
                    queue.remove();
                }
            }
        }
    }

    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        Elevator elevator=new Elevator(3,"Up");
        ElevatorManager em=new ElevatorManager();

        int n=0;
        do{
            System.out.println("Enter your destination floor");
            int d=sc.nextInt();
            Floor floor=new Floor(d);
            floor.addFloor(floor);
            em.delegate(elevator,elevator,d);
            System.out.println("Press 1 to continue");
            n= sc.nextInt();
        }while(n==1);}
}